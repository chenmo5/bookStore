package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService=new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"ada168","123456","4465@qq.com"));
        userService.registUser(new User(null,"abcdads562","123456","44zcxads5@qq.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"ada168","156","4465@qq.com")));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("ada168"));
    }
}