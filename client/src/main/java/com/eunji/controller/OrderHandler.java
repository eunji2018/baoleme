package com.eunji.controller;

import com.eunji.entity.Menu;
import com.eunji.entity.Order;
import com.eunji.entity.OrderVO;
import com.eunji.entity.User;
import com.eunji.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") int mid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        order.setUser(user);
        Menu menu = new Menu();
        menu.setId(mid);
        order.setMenu(menu);
        order.setState(0);
        orderFeign.save(order);
        return "index";
    }

    @GetMapping("findAllById")
    @ResponseBody
    public OrderVO findAllById(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int index = (page - 1) * limit;
        return orderFeign.findAllById(index, limit, user.getId());
    }


}
