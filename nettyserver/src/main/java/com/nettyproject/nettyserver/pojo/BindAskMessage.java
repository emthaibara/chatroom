package com.nettyproject.nettyserver.pojo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/25
 */

public class BindAskMessage extends AbstractMessage{

    private Boolean bindResult = false;

    private String codeMsg;

    public String getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(String codeMsg) {
        this.codeMsg = codeMsg;
    }

    public Boolean getBindResult() {
        return bindResult;
    }

    public void setBindResult(Boolean bindResult) {
        this.bindResult = bindResult;
    }

}
