package com.zz.delicious.serviceimpl;

import com.zz.delicious.common.token.TokenUtil;
import com.zz.delicious.common.util.ResultUtil;
import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.dao.UserMapper;
import com.zz.delicious.entity.User;
import com.zz.delicious.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/9 16:29
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultVo login(String username, String password) {
        User user = userMapper.selectByName(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                String token = TokenUtil.createToken(user);
                return ResultUtil.exec(true,"ok",token);
            }
        }
        return ResultUtil.exec(false,"用户或者密码错误",null);
    }

    @Override
    public ResultVo checkUser(String username) {
        User user = userMapper.selectByName(username);
        if(user!=null){
            return  ResultUtil.exec(true,"ok",null);
        }
        return ResultUtil.exec(false,"该用户不存在",null);
    }

    @Override
    public ResultVo addUser(User user) {
        User a = userMapper.selectByName(user.getUsername());
        if(a==null){
            Integer b = userMapper.insert(user);
            if(b > 0){
                return ResultUtil.exec(true,"ok",null);
            }
            return ResultUtil.exec(false,"注册失败", null);
        }
        return ResultUtil.exec(false,"该用户已存在",null);
    }
}
