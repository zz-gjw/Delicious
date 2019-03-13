package com.zz.delicious.dao;

import com.zz.delicious.entity.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);

    //展示二级分类
    List<GoodsType> selectGoodsTypeByCid(@Param("cid") Integer cid);
}