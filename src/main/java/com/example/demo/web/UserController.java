package com.example.demo.web;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public  User getUserInfo(String userId){

        User user =  userService.getUserInfo(userId);
        System.out.print(user.toString());
        return  user;
    }
}
