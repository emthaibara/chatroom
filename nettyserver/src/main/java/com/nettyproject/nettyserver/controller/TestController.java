package com.nettyproject.nettyserver.controller;

import com.nettyproject.nettyserver.handler.SendMessageHandler;
import com.nettyproject.nettyserver.pojo.PrivateChatMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 */

@RestController
public class TestController {

    @Resource
    private SendMessageHandler sendMessageHandler;

    @GetMapping("/message")
    public String message(){
        PrivateChatMessage privateChatMessage = new PrivateChatMessage();
        privateChatMessage.setSender("187872718L");
        //privateChatMessage.setToken("7812dgh19819hnoo12jdi");
        privateChatMessage.setReceiver("721982891L");
        sendMessageHandler.sendToAFriendMsg(privateChatMessage);
        return "Hello World";
    }


}
