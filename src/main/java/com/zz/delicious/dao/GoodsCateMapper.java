package com.zz.delicious.dao;

import com.zz.delicious.entity.GoodsCate;
import com.zz.delicious.entity.GoodsType;
import io.swagger.models.auth.In;

import java.util.List;

public interface GoodsCateMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(GoodsCate record);

    int insertSelective(GoodsCate record);

    GoodsCate selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(GoodsCate record);

    int updateByPrimaryKey(GoodsCate record);

    //展示一级分类
    List<GoodsCate> selectAll();




}