package com.nettyproject.nettyserver;

import com.nettyproject.nettyserver.handler.SendMessageHandler;
import com.nettyproject.nettyserver.pojo.PrivateChatMessage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NettyserverApplicationTests {

    @Test
    void contextLoads() {
        PrivateChatMessage message = new PrivateChatMessage();
        message.setReceiver(828717818L);
        message.setToken("1278eghd81ygbv8y1 28129hged12bu d");
        message.setSender(271267173123871L);
        //SendMessageHandler.sendToAFriendMsg(message);
    }

}
