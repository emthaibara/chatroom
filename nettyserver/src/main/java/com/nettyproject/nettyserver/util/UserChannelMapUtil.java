package com.nettyproject.nettyserver.util;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/26
 *          phoneNumber : Channel
 */

public class UserChannelMapUtil {

    private static final ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private static final Map<String, Channel> USER_CHANNEL = new ConcurrentHashMap<>(256);

    public static void doBind(String id,Channel channel){

    }

    public static void unBind(String id){

    }

    public static void unBind(Channel channel){

    }
}
