package com.hehe.dao;

import com.hehe.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{id})")
    List<Traveller> findByIds(String orderId) throws Exception;
}
