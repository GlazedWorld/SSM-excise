package com.hehe.service.impl;

import com.hehe.dao.ProductDao;
import com.hehe.domain.Product;
import com.hehe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }
}
