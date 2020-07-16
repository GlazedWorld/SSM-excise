package com.hehe.controller;

import com.hehe.domain.Product;
import com.hehe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        List<Product> products = productService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping("addProduct.do")
    public String allProduct(Product product){
         productService.addProduct(product);
         return "redirect:findAll.do";
    }

}
