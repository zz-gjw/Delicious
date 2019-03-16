package com.zz.delicious.dao;

import com.zz.delicious.entity.Cart;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);
    //添加购物车
    int insert(Cart record);
    int insertSelective(Cart record);
    //根据用户id展示该用户的购物车
    List<Cart> selectByUserid(Integer userid);
    //根据购物车id修改购物车信息
    int updateByid(Cart record);
    //根据用户id修改改用户的购物车信息
    int updateByUserid(Integer userid);
    //根据商品id和用户id查找该商品
    Cart selecByGid(Cart cart);
    //根据商品id和用户id使该商品的数量自增1
    int updataNum(Cart cart);
    //根据商品id删除该商品
    int delCart(Cart cart);
}