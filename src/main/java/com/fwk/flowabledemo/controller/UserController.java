package com.fwk.flowabledemo.controller;

import com.fwk.flowabledemo.entity.User;
import com.fwk.flowabledemo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2022/11/9 5:33 PM
 * @Created by fuwk
 */
@RestController
@Api("测试user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/test")
    public String test(){
        return userService.getName();
    }

    @ApiOperation(value = "获取用户")
    @GetMapping(value = "/getUser")
    public List<User> getUser(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(100L);
        user.setName("李四");
        user.setDate(new Date());
        user.setLd(LocalDate.now());
        user.setLdt(LocalDateTime.now());
        users.add(user);
        return users;
    }

    @ApiOperation(value = "获取用户")
    @GetMapping(value = "/getUser2")
    public String getUser2(){
        System.out.println(System.getProperty("file.encoding"));
        return "王五888";
    }

}
