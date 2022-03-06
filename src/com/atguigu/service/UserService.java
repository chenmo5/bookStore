package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);


    /**
     * 登录
     * @param user
     * @return 返回null登录失败
     */
    public User login(User user);

    /**
     *检查用户名是否存在
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
