package com.nettyproject.nettyserver.util;

import com.alibaba.fastjson.JSON;
import com.nettyproject.nettyserver.pojo.GroupChatMessage;
import com.nettyproject.nettyserver.pojo.PrivateChatMessage;
import com.nettyproject.nettyserver.result.Result;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/26
 *          phoneNumber : Channel
 */

public class UserChannelMapUtil {

    //可以用来广播消息
    private static final ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //实现点对点的信息传播
    private static final Map<String, Channel> USER_CHANNEL = new ConcurrentHashMap<>(256);

    private static final String ID = "id";

    public synchronized static void doBind(String id,Channel channel){

        //之前该用户已经绑定过，再次绑定的时候需要从CHANNEL_GROUP删除该channel并且随手close
        if (USER_CHANNEL.containsKey(id)){
            Channel oldChannel = USER_CHANNEL.get(id);
            CHANNEL_GROUP.remove(oldChannel);
            oldChannel.close();
        }

        AttributeKey<String> attributeKey = AttributeKey.valueOf(ID);
        channel.attr(attributeKey).set(id);

        CHANNEL_GROUP.add(channel);
        USER_CHANNEL.put(id,channel);

        USER_CHANNEL.get(id).writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(new Result<>("bind success!!!"))));
    }

    public synchronized static void unBind(String id){

        Channel channel = USER_CHANNEL.get(id);

        USER_CHANNEL.remove(id);
        CHANNEL_GROUP.remove(channel);

        if (!ObjectUtils.isEmpty(channel))
            channel.close();

    }

    public synchronized static void unBind(Channel channel){

        AttributeKey<String> attributeKey = AttributeKey.valueOf(ID);
        String id = channel.attr(attributeKey).get();

        if (!StringUtils.hasText(id)) {
            USER_CHANNEL.remove(id);
        }

        CHANNEL_GROUP.remove(channel);

        channel.close();
    }

    public static synchronized Map<String, Channel> getClient(){
        return USER_CHANNEL;
    }

    public static void sendMessageToAFriend(PrivateChatMessage privateChatMessage){
        String receiver = privateChatMessage.getReceiver();
        USER_CHANNEL.get(receiver).writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(new Result<>(privateChatMessage))));
    }

    public static void sendToAGroupMsg(GroupChatMessage message){
        ArrayList<String> receivers = message.getReceivers();

        for(String receiver : receivers){
            USER_CHANNEL.get(receiver).writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(message)));
        }
    }

}
