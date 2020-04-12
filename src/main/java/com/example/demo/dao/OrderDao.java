package com.example.demo.dao;

import com.example.demo.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderDao {
    @Select("select * from t_grain_order where order_id = #{id}")
    @Results({ @Result(property = "id", column = "order_id"),
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "customerName", column = "customer_name")})
    Order getOrderInfo(String id);
}
