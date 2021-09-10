package com.example.wiki.req;

import javax.validation.constraints.NotNull;

public class PasswordResetReq {
    @NotNull(message = "id不能为空")
    long id;
    @NotNull(message = "password不能为空")
    String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
