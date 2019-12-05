package com.eunji.feign;

import com.eunji.entity.MenuVO;
import com.eunji.entity.Order;
import com.eunji.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

    @GetMapping("/order/findAllById/{index}/{limit}/{uid}")
    public OrderVO findAllById(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid);
}
