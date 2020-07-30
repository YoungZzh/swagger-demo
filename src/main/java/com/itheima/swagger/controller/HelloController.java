package com.itheima.swagger.controller;

import com.itheima.swagger.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:Young
 * Date:2020/7/20-17:01
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    //只要我们接口中，返回值中存在实体类，它就会被扫描到swagger中
    @PostMapping
    public User user(){
        return new User();
    }
}
