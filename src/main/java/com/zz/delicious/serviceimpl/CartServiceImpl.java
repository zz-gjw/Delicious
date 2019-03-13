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
        Cart a = new Cart();
        int b = TokenUtil.parseToken(token).getId();
        a.setGoodsid(goodsid);
        a.setNum(1);
        a.setUserid(b);
        Integer c = cartMapper.insert(a);
        if(c>0){
            return ResultUtil.exec(true,"ok",null);
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
    public ResultVo updateUserCart(Cart cart) {
        int a = cartMapper.updateByid(cart);
        if(a>0){
            return ResultUtil.exec(true,"ok",null);
        }
        return ResultUtil.exec(false,"",null);
    }

}
