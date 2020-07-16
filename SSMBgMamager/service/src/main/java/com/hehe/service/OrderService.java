package com.hehe.service;

import com.hehe.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll(int curPage,int pageSize);

    Order findById(String id);
}
