package com.nettyproject.nettyserver.pojo;

import java.util.List;

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
    private List<String> group;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getGroup() {
        return group;
    }

    public void setGroup(List<String> group) {
        this.group = group;
    }
}
