package com.zz.delicious.serviceimpl;

import com.zz.delicious.common.token.TokenUtil;
import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.dao.OrderMapper;
import com.zz.delicious.dao.OrderdetailMapper;
import com.zz.delicious.entity.Order;
import com.zz.delicious.entity.Orderdetail;
import com.zz.delicious.service.OrderService;
import com.zz.delicious.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/13 20:14
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public ResultVo addOrder(Order order, Orderdetail orderDetail) {
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String uuid = UUID.randomUUID().toString().replace("-","");
        order*/

        return null;
    }
}
