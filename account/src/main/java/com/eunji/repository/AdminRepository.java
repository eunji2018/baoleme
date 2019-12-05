package com.eunji.repository;

import com.eunji.entity.Admin;

public interface AdminRepository {

    public Admin login(String username, String password);
}
