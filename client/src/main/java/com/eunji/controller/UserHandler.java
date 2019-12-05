package com.eunji.controller;

import com.eunji.entity.User;
import com.eunji.entity.UserVO;
import com.eunji.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userFeign.count());
        userVO.setData(userFeign.findAll(index, limit));
        return userVO;
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id) {
        return userFeign.findById(id);
    }

    @GetMapping("/count")
    public int count() {
        return userFeign.count();
    }

    @PostMapping("/save")
    public String save(User user) {
        userFeign.save(user);
        return "redirect:/menu/redirect/user_manage";
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userFeign.update(user);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id) {
        userFeign.deleteById(id);
        return "redirect:/menu/redirect/user_manage";
    }

}
