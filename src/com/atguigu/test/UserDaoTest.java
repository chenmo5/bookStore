package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        User user=userDao.queryUserByUsername("admin");
        if (user==null){
            System.out.println("用户名可用!");
        }else{
            System.out.println("用户名已存在!");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"wang168","123465","123456@qq.com")));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user=userDao.queryUserByUsernameAndPassword("admin","admin");
        if (user==null){
            System.out.println("用户名或密码已存在，登录失败");
        }else {
            System.out.println("查询成功");
        }
    }
}