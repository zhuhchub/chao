package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.po.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class userController {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public Object getone(@PathVariable("id")int id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);

        User user = userService.getOne(queryWrapper);
        return user;
    }
    @GetMapping("/po/{id}")
    public Object selectById( int id){
        return userMapper.selectById(new QueryWrapper<User>().eq("id",id));
    }
}
