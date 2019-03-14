package com.zz.delicious.controller;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "商品")
@RestController
@CrossOrigin
public class Goodscontroller {
    @Autowired
    private GoodsService goodsService;
    @ApiOperation(value = "展示商品所有信息",notes = "根据传入商品gid，查看到商品的所有信息包括一二级分类")
    @PostMapping("selectAllByGid.do")
        ResultVo selectAllByGid(Integer gid){
        return goodsService.selectAllByGid(gid);
    }

    @ApiOperation(value = "搜索商品信息",notes = "根据传入商品名字，以及模糊名字（goodsname），查看到商品的详细信息")
    @PostMapping("selectAllByGoodName.do")
    ResultVo selectAllByGoodName(String goodsname){return goodsService.selectAllByGoodName(goodsname);}

    @ApiOperation(value = "展示商品",notes = "根据传入二级分类菜单typeid，查看商品")
    @PostMapping("selectAllByTypeId.do")
    ResultVo selectAllByTypeId(Integer typeid){
        return goodsService.selectAllByTypeId(typeid);
    }
}
