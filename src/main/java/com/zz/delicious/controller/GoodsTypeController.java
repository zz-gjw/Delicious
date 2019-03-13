package com.zz.delicious.controller;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.service.GoodsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "商品")
@RestController
@CrossOrigin
public class GoodsTypeController {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @ApiOperation(value = "展示二级菜单分类",notes = "需要传入cid，cid是一级菜单分类中每个菜单的id")
    @PostMapping("selectGoodsTypeByCid.do")
    ResultVo selectGoodsTypeByCid(Integer cid){
        return goodsTypeService.selectGoodsTypeByCid(cid);
    }
}
