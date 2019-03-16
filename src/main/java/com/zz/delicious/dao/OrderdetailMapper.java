package com.zz.delicious.dao;

import com.zz.delicious.entity.Orderdetail;

public interface OrderdetailMapper {
    //添加购物详情
    int insertSelective(Orderdetail record);
}