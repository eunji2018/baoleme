package com.eunji.controller;

import com.eunji.repository.AdminRepository;
import com.eunji.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type) {
        Object object = null;
        switch (type) {
            case "user" :
                object = userRepository.login(username, password);
                break;
            case "admin" :
                object = adminRepository.login(username, password);
                break;
        }
        return object;
    }
}
