package com.nettyproject.nettyserver.Model;


/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/25
 */

public class MessageModel <T>{

    private Integer type;
    private T t;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }


}
