package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
//    @Select("select * from user_info where user_id = #{userId}")
//    @Results({ @Result(property = "userId", column = "user_id"),
//            @Result(property = "userName", column = "user_name"),
//            @Result(property = "age", column = "age"),
//            @Result(property = "phoneNum", column = "phone")})
    User getUserInfo(String phone);
}
