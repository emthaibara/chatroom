package com.nettyproject.nettyserver.advice;

import com.nettyproject.nettyserver.util.JwtUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 */

@Aspect
@Component
public class GlobalAopAdvice {

    @Before("com.nettyproject.nettyserver.aspect.CommonAspect.sendMessageHandlerAspect()")
    public void checkToken(){

    }

    private Boolean verifyJwtToken(String jwt){
        return JwtUtil.verify(jwt);
    }

}
