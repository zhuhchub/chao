package com.example.demo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//生成getset方法
@AllArgsConstructor//生成有参构造
@NoArgsConstructor//生成无参构造
public class User {
    @TableId("id")//主键
    private int id;
    @TableField("name")
    //若没有开启驼峰命名，或者表中列名不符合驼峰规则，可通过该注解指定数据库表中的列名，exist标明数据表中有没有对应列
    private String name;
    @TableField("age")
    private int age;
}
