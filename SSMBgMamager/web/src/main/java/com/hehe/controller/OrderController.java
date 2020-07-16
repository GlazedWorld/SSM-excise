package com.hehe.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hehe.domain.Order;
import com.hehe.domain.Product;
import com.hehe.domain.Traveller;
import com.hehe.service.OrderService;
import com.hehe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam( value = "curPage") int curPage,@RequestParam(value = "pageSize") int pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orders = orderService.findAll(curPage,pageSize);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
        modelAndView.addObject("ordersList",orderPageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }
    @RequestMapping("findById.do")
    public ModelAndView findById(String id){
        Order order = orderService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }



}
