package com.zz.delicious.dao;



import io.swagger.models.auth.In;

import java.util.List;

public interface GoodsMapper<Goods> {
    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    //通过商品id展示商品分类
    List<Goods> selectAllByGid(Integer gid);

    List<Goods> selectAllByTypeId(Integer typeid);

    List<Goods> selectAllByGoodName(String goodsname);
}