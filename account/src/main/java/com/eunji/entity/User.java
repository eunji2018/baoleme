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
}
