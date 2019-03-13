package com.zz.delicious.service;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.entity.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTypeService {

    ResultVo selectGoodsTypeByCid(@Param("cid") Integer cid);
}
