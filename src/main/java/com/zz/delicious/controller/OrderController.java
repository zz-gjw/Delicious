package com.zz.delicious.controller;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.entity.Order;
import com.zz.delicious.entity.Orderdetail;
import com.zz.delicious.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/15 20:53
 * @Description:
 */
@Api(tags = "订单接口")
@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "下订单", notes = "传入token、totalprice、address、phone、goodsid、num的值下订单")
    @PostMapping("addOrder.do")
    ResultVo addOrder(Order order, Orderdetail orderDetail, String token){
        return orderService.addOrder(order,orderDetail,token);
    }

    @ApiOperation(value = "根据状态展示订单", notes = "需要传入token 和stare的值，1为未付款，2为代付款，3为带配送，4为配送中")
    @PostMapping("showOrder.do")
    ResultVo showOrder(Integer state, String token){
        return orderService.showOrder(state,token);
    }

    @ApiOperation(value = "修改订单状态",notes = "传入token、id、state，根据用户和订单id修改订单状态")
    @PostMapping("updateOrder.do")
    ResultVo updateOrder(String token, Integer id, Integer state){
        return orderService.updateById(token, id, state);
    }
}
