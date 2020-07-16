package com.hehe.service.impl;

import com.github.pagehelper.PageHelper;
import com.hehe.dao.OrderDao;
import com.hehe.domain.Order;
import com.hehe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll(int curPage,int pageSize) {
        PageHelper.startPage(curPage,pageSize);
        return orderDao.findAll();
    }

    @Override
    public Order findById(String id) {
        return orderDao.findById(id);
    }
}
