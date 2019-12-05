package com.eunji.repository;

import com.eunji.entity.Order;

import java.util.List;

public interface OrderRepository {

    public void save(Order order);
    public List<Order> findAll(int index, int limit);
    public List<Order> findAllById(int index, int limit, long uid);
    public int countById(long uid);
    public List<Order> findAllByState(int index, int limit);
    public void updateState(long id);
    public int count();
}
