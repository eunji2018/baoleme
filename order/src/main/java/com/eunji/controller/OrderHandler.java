package com.eunji.controller;

import com.eunji.entity.Order;
import com.eunji.entity.OrderVO;
import com.eunji.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        return "order的端口：" + this.port;
    }

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @GetMapping("/findAll/{index}/{limit}/{uid}")
    public OrderVO findAllById(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid) {
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countById(uid));
        orderVO.setData(orderRepository.findAllById(index, limit, uid));
        return orderVO;
    }

    @GetMapping("/countById/{uid}")
    public int countById(@PathVariable("uid") int uid) {
        return orderRepository.countById(uid);
    }

    @GetMapping("/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.count());
        orderVO.setData(orderRepository.findAll(index, limit));
        return orderVO;
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") long id) {
        orderRepository.updateState(id);
    }
}
