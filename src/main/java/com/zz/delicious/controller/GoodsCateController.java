package com.zz.delicious.controller;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.service.GoodsCateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "商品")
@RestController
@CrossOrigin
public class GoodsCateController {
    @Autowired
    private GoodsCateService goodsCateService;
    @ApiOperation(value = "一级菜单", notes = "展示所有一级菜单分类")
    @PostMapping("select.do")
    ResultVo selectAll(){
        return goodsCateService.selectAll();
    }
}
