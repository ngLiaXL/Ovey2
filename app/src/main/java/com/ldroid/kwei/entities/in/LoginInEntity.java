package com.ldroid.kwei.entities.in;

import com.ldroid.kwei.common.entities.InputEntity;

public class LoginInEntity extends InputEntity {


    private String name;
    private String password;


    public LoginInEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

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
}
