package com.nettyproject.nettyserver.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/26
 */


public abstract class AbstractMessage{

    /**
     * 发起者
     */
    protected long sender;

    /**
     * 接收者
     */
    protected long receiver;

    //protected Date buildDate;
}
