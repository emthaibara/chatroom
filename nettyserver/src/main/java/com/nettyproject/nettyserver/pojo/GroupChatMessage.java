package com.nettyproject.nettyserver.pojo;

import java.util.ArrayList;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/25
 */

public class GroupChatMessage extends AbstractMessage{

    /**
     * 发起者
     */
    private String sender;

    /**
     * 接收者
     */
    private ArrayList<String> receivers;

    private String message;

    @Override
    public String toString() {
        return "GroupChatMessage{" +
                "token='" + token + '\'' +
                ", sender='" + sender + '\'' +
                ", receivers=" + receivers +
                ", message='" + message + '\'' +
                '}';
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public ArrayList<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(ArrayList<String> receivers) {
        this.receivers = receivers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
