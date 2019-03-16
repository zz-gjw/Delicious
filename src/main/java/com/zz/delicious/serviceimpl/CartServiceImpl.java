package com.zz.delicious.serviceimpl;

import com.zz.delicious.common.token.TokenUtil;
import com.zz.delicious.common.util.ResultUtil;
import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.dao.CartMapper;
import com.zz.delicious.entity.Cart;
import com.zz.delicious.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/12 10:58
 * @Description:
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Override
    public ResultVo addCart(String token, int goodsid) {

        int b = TokenUtil.parseToken(token).getId();
        Cart ca = new Cart();
        ca.setGoodsid(goodsid);
        ca.setUserid(b);

        Cart a = new Cart();
        a.setGoodsid(goodsid);
        a.setNum(1);
        a.setUserid(b);

        Cart cart = cartMapper.selecByGid(ca);
        if(cart!=null){
            Integer d = cartMapper.updataNum(ca);
            return  ResultUtil.exec(true,"ok",null);
        }else if (cart==null){
            Integer c = cartMapper.insert(a);
            if(c>0){
                return ResultUtil.exec(true,"ok",null);
            }
        }
        return ResultUtil.exec(false,"添加购物车失败",null);
    }

    @Override
    public ResultVo showUserCart(String token) {
        //从token中获取用户id
        int b = TokenUtil.parseToken(token).getId();
        List<Cart> list = cartMapper.selectByUserid(b);
        return ResultUtil.exec(true,"ok",list);
    }

    @Override
    public ResultVo updateUserCart(String token, Cart cart) {
        int b = TokenUtil.parseToken(token).getId();

        Cart abc = new Cart();
        abc.setUserid(b);
        abc.setGoodsid(cart.getGoodsid());
        abc.setNum(cart.getNum());

        int a = cartMapper.updateByid(abc);
        if(a>0){
            return ResultUtil.exec(true,"ok",null);
        }
        return ResultUtil.exec(false,"",null);
    }

    @Override
    public ResultVo deleCart(String token, Integer goodsid) {

        int b = TokenUtil.parseToken(token).getId();

        Cart cart1 = new Cart();
        cart1.setUserid(b);
        cart1.setGoodsid(goodsid);
        int a = cartMapper.delCart(cart1);
        if(a>0){
            return ResultUtil.exec(true,"ok",null);
        }
        return ResultUtil.exec(false,"操作失误",null);
    }

}
