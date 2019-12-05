package com.eunji.repository;

import com.eunji.entity.User;

public interface UserRepository {

    public User login(String username, String password);
}
