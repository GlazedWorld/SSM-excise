package com.hehe.service;

import com.hehe.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll() throws Exception;

    void addProduct(Product product);
}
