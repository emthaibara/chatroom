package com.nettyproject.nettyserver.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/25
 */

public class PrivateChatMessage extends AbstractMessage{

    /**
     * 发起者
     */
    private String sender;

    /**
     * 接收者
     */
    private String receiver;

    @Override
    public String toString() {
        return "PrivateChatMessage{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", token='" + token + '\'' +
                '}';
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
