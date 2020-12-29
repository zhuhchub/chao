package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    User user = new User();

    @GetMapping("/{id}")
    public Object getone(@PathVariable("id")int id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        User user = userService.getOne(queryWrapper);
        return user;
    }
    @GetMapping("/all")
    public Object selectMaps(){
        return userMapper.selectMaps(new QueryWrapper<User>().isNotNull("name"));
    }
    @GetMapping("/page")//查询没问题 显示有问题
    public Object selectPage(){
        Page<User> page = new Page<>(1, 2);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        IPage<User> userIPage = userMapper.selectPage(page, queryWrapper);
        return userIPage;
    }
    @GetMapping("/po/{id}")
    public Object selectOne(@PathVariable("id")int id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        return userMapper.selectOne(queryWrapper.eq("id",id));
    }
    @GetMapping("/delect")
    public Object delect(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .isNotNull("name")
                .ge("age", 45);
        userMapper.delete(queryWrapper);
        return null;
    }
    @GetMapping("/update")
    public Object update(){
        //修改值
        user.setName("六六");
        user.setAge(35);

        //修改条件s
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("name", "张三");
        userMapper.update(user, userUpdateWrapper);
        return null;
    }
    @GetMapping("/insert")
    public Object insert(){
        //修改值

        user.setName("六六");
        user.setAge(35);

        //修改条件s
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();

        userMapper.insert(user);
        return null;
    }
}
