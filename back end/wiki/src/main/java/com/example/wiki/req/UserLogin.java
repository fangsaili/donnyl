package com.example.wiki.req;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table user
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class UserLogin {


    @NotNull(message = "用户名不能为空")
    private String loginName;



    @NotNull(message = "密码不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9a-zA-Z]{6,32}$",message = "密码长度为6-20，至少包含数字和字母")
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}