package com.zz.delicious.service;

import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.entity.Order;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/13 19:39
 * @Description:
 */
public interface OrderService {
    //添加订单
    ResultVo addOrder(Order order);
}
