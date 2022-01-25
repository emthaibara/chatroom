package com.nettyproject.nettyserver.server;

import com.nettyproject.nettyserver.handler.WebSocketTextInboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @Author:SCBC_LiYongJie
 * @time:2021/12/20
 */

public class SocketChannelInitializer extends ChannelInitializer<NioSocketChannel> {

    private final String handshakePath;

    public SocketChannelInitializer(String handshakePath) {
        this.handshakePath = handshakePath;
    }

    @Override
    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
        nioSocketChannel
                .pipeline()
                //http请求解码器，websocket建立之前首先需要发送一个http请求，请求升级协议
                .addLast(new HttpServerCodec())
                //消息聚合器，解决粘包半包等问题
                .addLast(new HttpObjectAggregator(65536))
                .addLast(new ChunkedWriteHandler())
                //netty封装的专门用于处理websocket连接的各种事务处理，如ping pong 请求的处理，协议升级
                .addLast(new WebSocketServerProtocolHandler(handshakePath))
                //websocket连接建立后，文本消息处理器
                .addLast(new WebSocketTextInboundHandler());
    }

}
