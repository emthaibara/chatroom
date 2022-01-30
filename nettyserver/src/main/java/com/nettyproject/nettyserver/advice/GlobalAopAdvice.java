package com.nettyproject.nettyserver.advice;

import com.nettyproject.nettyserver.pojo.AbstractMessage;
import com.nettyproject.nettyserver.util.JwtUtil;
import com.nettyproject.nettyserver.util.UserChannelMapUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 */

@Aspect
@Component
public class GlobalAopAdvice {

    private static final Logger log = LoggerFactory.getLogger(GlobalAopAdvice.class);

    @Before("com.nettyproject.nettyserver.aspect.CommonAspect.sendMessageHandlerAspect()")
    public void checkToken(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();
        Object message = args[0];
        AbstractMessage abstractMessage = (AbstractMessage) message;
        String token = abstractMessage.getToken();
        System.out.println(token);

        if (!verifyJwtToken(abstractMessage.getToken()))
            throw new RuntimeException("jwt token verify fail");

        log.info("有新的合法消息，token：{}",token);
        log.info(UserChannelMapUtil.getClient().entrySet().toString());
    }

    @After("com.nettyproject.nettyserver.aspect.CommonAspect.sendMessageHandlerAspect()")
    public void printLog(){
        log.info(UserChannelMapUtil.getClient().entrySet().toString());
    }

    private Boolean verifyJwtToken(String jwt){
        return JwtUtil.verify(jwt);
    }

}
