package com.zz.delicious.service;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.entity.Cart;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/12 10:56
 * @Description:
 */
public interface CartService {
    //添加购物车
    ResultVo addCart(String token, int goodsid);
    //根据用户id展示该用户的购物车
    ResultVo showUserCart(String token);

    //根据用户id和goodsid修改该用户的购物车
    ResultVo updateUserCart(String token, Integer goodsid);


    /*//通过userid删除该用户的购物车
    ResultVo delCart(String token);*/



    ResultVo deleCart(String token, Integer goodsid);
}
