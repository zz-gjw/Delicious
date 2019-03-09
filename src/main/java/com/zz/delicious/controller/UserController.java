package com.zz.delicious.controller;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.entity.User;
import com.zz.delicious.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/9 17:02
 * @Description:
 */
@Api(tags = "用户中心")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录接口", notes = "根据账号密码登录，登录前会判断该账号是否存在")
    @PostMapping("login.do")
    public ResultVo login(String username,String password){
        return userService.login(username,password);
    }

    @ApiOperation(value = "检查该用户是否存在", notes = "根据用户输入的账号，判断该用户是否存在")
    @PostMapping("checkUser.do")
    public ResultVo checkUser(String username){
        return userService.checkUser(username);
    }

    @ApiOperation(value = "",notes = "用户注册")
    @PostMapping("addUser.do")
    public ResultVo addUser(User user){
        return  userService.addUser(user);
    }
}
