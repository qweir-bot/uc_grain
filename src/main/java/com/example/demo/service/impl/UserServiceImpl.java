package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public User getUserInfo(String userId) {

        long start,end;
        start = System.currentTimeMillis();

        try{
            Thread.sleep(2000);

        }catch (Exception e){

        }
        end = System.currentTimeMillis();
        System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");

        return userDao.getUserInfo(userId);
    }
}
