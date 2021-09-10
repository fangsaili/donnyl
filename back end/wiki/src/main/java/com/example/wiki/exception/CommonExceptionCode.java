package com.example.wiki.exception;

public enum CommonExceptionCode {
    USER_LOGIN_NAME_EXESIT("用户名已存在"),
    USER_ID_NOT_EXESIT("用户不存在"),
    USER_LOGIN_ERROR("用户不存在或者密码错误"),
    ;;



    private String desc;

    CommonExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
