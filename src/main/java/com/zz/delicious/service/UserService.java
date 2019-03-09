package com.zz.delicious.service;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.entity.User;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/9 16:24
 * @Description:
 */
public interface UserService {
    //登录
    ResultVo login(String username, String password);
    //判断是否该用户是否存在
    ResultVo checkUser(String username);
    //注册
    ResultVo addUser(User user);
}
