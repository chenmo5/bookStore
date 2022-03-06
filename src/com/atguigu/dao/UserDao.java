package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 如果返回null没有这个用户，
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @return 如果返回null没有这个用户，或密码或用户名错误
     */
    public User queryUserByUsernameAndPassword(String username,String password);
}
