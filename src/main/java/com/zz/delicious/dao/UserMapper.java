package com.zz.delicious.dao;

import com.zz.delicious.entity.User;

public interface UserMapper {
    //注册
    int insert(User record);
    //通过用户名查找用户
    User selectByName(String username);
}