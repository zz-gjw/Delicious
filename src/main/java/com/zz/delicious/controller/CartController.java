package com.zz.delicious.controller;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.entity.Cart;
import com.zz.delicious.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/12 11:20
 * @Description:
 */
@Api(tags = "购物车相关")
@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @ApiOperation(value = "添加购物车", notes = "传入商品id，和token，创建购物车")
    @PostMapping("addCart.do")
    ResultVo addCart(String token, int goodsid){
        return cartService.addCart(token, goodsid);
    }

    @ApiOperation(value = "展示购物车",notes = "只需要传入token，从token中获取用户的id，展示该用户的购物车")
    @GetMapping("showUserCart.do")
    ResultVo showUserCart(String token){
        return cartService.showUserCart(token);
    }

    @ApiOperation(value = "修改购物车", notes = "根据购物车id修改购物车信息，只需要传入字段‘id’的值就行")
    @GetMapping("updateUserCart.do")
    ResultVo updateUserCart(Cart cart){
        return cartService.updateUserCart(cart);
    }
}
