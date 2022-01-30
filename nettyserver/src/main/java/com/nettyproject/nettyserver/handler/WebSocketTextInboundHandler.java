package com.nettyproject.nettyserver.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nettyproject.nettyserver.enums.MessageTypeEnum;
import com.nettyproject.nettyserver.pojo.*;
import com.nettyproject.nettyserver.util.SpringContextUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author:SCBC_LiYongJie
 * @time:2021/12/25
 */

//一定一定要标注共享handler实例，不然当用户多了，会new很多的WebSocketTextInboundHandler
@ChannelHandler.Sharable
public class WebSocketTextInboundHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static final Logger log = LoggerFactory.getLogger(WebSocketTextInboundHandler.class);

    private final SendMessageHandler handler;

    public WebSocketTextInboundHandler() {
        handler = SpringContextUtils.getContext().getBean(SendMessageHandler.class);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        String json = msg.text();
        handle(JSON.parseObject(json),ctx.channel());
    }

    private static final String TYPE = "type";
    private static final String DATA = "data";

    private void handle(JSONObject jsonObject, Channel channel) {
        final Integer type = jsonObject.getObject(TYPE,Integer.class);

        //不同消息类型区分不同的事务
        if (type.equals(MessageTypeEnum.BIND.getType())){
            handler.doBind(jsonObject.getObject(DATA,BindAskMessage.class),channel);
        }

        if (type.equals(MessageTypeEnum.PRIVATE_CHAT.getType())){
            handler.sendToAFriendMsg(jsonObject.getObject(DATA,PrivateChatMessage.class));
        }

        if (type.equals(MessageTypeEnum.GROUP_CHAT.getType())){
            handler.sendToAGroupMsg(jsonObject.getObject(DATA,GroupChatMessage.class));
        }

        if (type.equals(MessageTypeEnum.FORCE_OFFLINE.getType())){
            handler.sendForceOfflineMsg(jsonObject.getObject(DATA,ForceOfflineMessage.class));
        }

        if (type.equals(MessageTypeEnum.FRIEND_REQUEST.getType())){
            handler.sendFriendRequestMsg(jsonObject.getObject(DATA,FriendRequestMessage.class));
        }

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            log.info(ctx.channel().localAddress().toString());
        }
        else
            super.userEventTriggered(ctx,evt);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        log.error("异常信息："+cause.getMessage());
    }

}
