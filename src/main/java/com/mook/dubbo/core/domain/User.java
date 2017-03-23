package com.mook.dubbo.core.domain;

/**
 * Description: 用户
 *
 * @author wangdehai
 * @date 2017-02-26 01:19:58
 * @version 1.0
 *
 */
public class User extends BaseDomain {

    private static final long serialVersionUID = 4927887299308302662L;

    private String name;
    private String password;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + ", email=" + email + "]";
    }

}
