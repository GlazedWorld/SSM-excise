package com.hehe.dao;

import com.hehe.domain.Member;
import com.hehe.domain.Order;
import com.hehe.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    @Select("select * from orders")
    @Results(
            @Result(column = "productId", property = "product", javaType = Product.class, one = @One(select = "com.hehe.dao.ProductDao.findById"))
    )
    List<Order> findAll();




    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(column = "productId", property = "product",
                    javaType = Product.class,
                    one = @One(select = "com.hehe.dao.ProductDao.findById")),
            @Result(column = "memberId", property = "member",
                    javaType = Member.class,
                    one = @One(select = "com.hehe.dao.MemberDao.findById")),
            @Result(column = "id",property = "travellers",
                    javaType = List.class,
                    many = @Many(select = "com.hehe.dao.TravellerDao.findByIds"))
    })
    Order findById(String id);
}
