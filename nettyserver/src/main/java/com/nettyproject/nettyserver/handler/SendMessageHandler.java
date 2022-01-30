package com.nettyproject.nettyserver.handler;

import com.nettyproject.nettyserver.enums.TokenClaimEnum;
import com.nettyproject.nettyserver.pojo.*;
import com.nettyproject.nettyserver.util.JwtUtil;
import com.nettyproject.nettyserver.util.UserChannelMapUtil;
import io.netty.channel.Channel;
import org.springframework.stereotype.Service;


/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/26
 */

@Service
public class SendMessageHandler {

    public void sendToAFriendMsg(PrivateChatMessage message){

    }

    public void sendToAGroupMsg(GroupChatMessage message){

    }

    public void sendFriendRequestMsg(FriendRequestMessage message){

    }

    public void sendForceOfflineMsg(ForceOfflineMessage message){

    }

    public synchronized void doBind(BindAskMessage message, Channel channel){
        String token = message.getToken();
        String id = JwtUtil.getClaim(TokenClaimEnum.ID,token);

        UserChannelMapUtil.doBind(id,channel);
    }

}
