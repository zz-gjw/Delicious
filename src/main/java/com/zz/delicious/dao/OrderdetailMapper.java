package com.zz.delicious.dao;

import com.zz.delicious.entity.Orderdetail;

public interface OrderdetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderdetail record);

    Orderdetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
    //添加购物详情
    int insertSelective(Orderdetail record);
}