package com.zz.delicious.dao;

import com.zz.delicious.entity.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);
    //添加订单
    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}