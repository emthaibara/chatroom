package com.nettyproject.nettyserver.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/25
 */

public class PrivateChatMessage{

    /**
     * 发起者
     */
    protected long sender;

    /**
     * 接收者
     */
    protected long receiver;

    private String token;

    public long getSender() {
        return sender;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }

    public long getReceiver() {
        return receiver;
    }

    public void setReceiver(long receiver) {
        this.receiver = receiver;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
