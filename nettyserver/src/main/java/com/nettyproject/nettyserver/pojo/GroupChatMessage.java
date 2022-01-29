package com.nettyproject.nettyserver.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/25
 */

public class GroupChatMessage{
    /**
     * 发起者
     */
    protected long sender;

    /**
     * 接收者
     */
    protected long receiver;

    private String token;
}
