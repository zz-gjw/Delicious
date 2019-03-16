package com.zz.delicious.service;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.entity.Order;
import com.zz.delicious.entity.Orderdetail;


/**
 * @Author : zz-gjw
 * @Date : 2019/3/13 19:39
 * @Description:
 */
public interface OrderService {
    //添加订单
    ResultVo addOrder(Order order, Orderdetail orderDetail, String token);
    //展示订单
    ResultVo showOrder(Integer state, String token);
    //修改订单状态
    ResultVo updateById(String token,Integer id, Integer state);
}
