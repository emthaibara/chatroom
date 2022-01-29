package com.nettyproject.nettyserver.controller;

import com.nettyproject.nettyserver.handler.SendMessageHandler;
import com.nettyproject.nettyserver.pojo.BindAskMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/message")
    public String message(@RequestBody BindAskMessage message){
        return "Hello World";
    }

}
