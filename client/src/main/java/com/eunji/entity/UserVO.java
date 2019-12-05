package com.eunji.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserVO {

    private int code;
    private String msg;
    private int count;
    private List<User> data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
