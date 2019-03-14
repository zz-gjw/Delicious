package com.zz.delicious.service;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.entity.Goods;

import java.util.List;

public interface GoodsService {

    ResultVo selectAllByGid(Integer gid);

    ResultVo selectAllByGoodName(String goodsname);


    ResultVo selectAllByTypeId(Integer typeid);

}
