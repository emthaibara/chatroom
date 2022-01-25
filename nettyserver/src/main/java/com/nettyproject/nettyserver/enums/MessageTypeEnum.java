package com.nettyproject.nettyserver.enums;

import com.nettyproject.nettyserver.pojo.*;
import com.nettyproject.nettyserver.util.TypeMapUtil;

public enum MessageTypeEnum {

    BIND(1,"初始化连接，申请绑定", BindAskMessage.class),
    FORCE_OFFLINE(5,"异地登陆，您已被挤下线", ForceOfflineMessage.class),
    PRIVATE_CHAT(2,"单聊消息", PrivateChatMessage.class),
    GROUP_CHAT(3,"群发消息", GroupChatMessage.class),
    FRIEND_REQUEST(4,"好友申请", FriendRequestMessage.class);

    private final String content;

    MessageTypeEnum(Integer type, String content,Class<?> c) {
        TypeMapUtil.put(type,c);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
