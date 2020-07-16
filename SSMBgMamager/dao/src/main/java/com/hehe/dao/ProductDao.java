package com.hehe.dao;

import com.hehe.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface ProductDao {
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Select("select * from product where id = #{id}")
    Product findById(String productId);

    @Insert("insert into product " +
            "(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice}," +
            "#{productDesc},#{productStatus})")
    void addProduct(Product product);
}
