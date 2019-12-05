package com.eunji.entity;

import lombok.Data;

@Data
public class User {

    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private String address;

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
