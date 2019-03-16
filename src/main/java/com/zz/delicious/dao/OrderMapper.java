package com.zz.delicious.dao;

import com.zz.delicious.entity.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int updateByPrimaryKey(Order record);
    //添加订单
    int insertSelective(Order record);
    //根据用户id和状态查询订单
    List<Order> selectByState(Order order);
    //根据用户id和订单id修改订单状态
    int updateById(Order record);

}