package com.zz.delicious.serviceimpl;

import com.zz.delicious.common.token.TokenUtil;
import com.zz.delicious.common.util.ResultUtil;
import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.dao.OrderMapper;
import com.zz.delicious.dao.OrderdetailMapper;
import com.zz.delicious.entity.Cart;
import com.zz.delicious.entity.Order;
import com.zz.delicious.entity.Orderdetail;
import com.zz.delicious.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    public ResultVo addOrder(Order order, Orderdetail orderDetail, String token) {

        int userid = TokenUtil.parseToken(token).getId();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date();
            String date1 = sdf.format(new Date());

            String uuid = UUID.randomUUID().toString().replace("-","");

            order.setNumber(userid + uuid + date1);
            order.setCreatetime(sdf.parse(date1));
            order.setState(1);
            order.setUserid(userid);
            orderMapper.insertSelective(order);

            int a = order.getId();
            orderDetail.setOrderid(a);
            orderdetailMapper.insertSelective(orderDetail);

            return ResultUtil.exec(true,"ok",null);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ResultUtil.exec(false,"添加异常",null);
    }

    @Override
    public ResultVo showOrder(Integer state, String token) {
        int userid = TokenUtil.parseToken(token).getId();
        Order order = new Order();
        order.setUserid(userid);
        order.setState(state);
        List<Order> a = orderMapper.selectByState(order);
        if(a.size()!=0){
            return ResultUtil.exec(true,"ok",a);
        }
        return ResultUtil.exec(false,"未查询到结果",null);
    }

    @Override
    public ResultVo updateById(String token, Integer id, Integer state) {
        int userid = TokenUtil.parseToken(token).getId();
        Order order = new Order();
        order.setState(state);
        order.setUserid(userid);
        order.setId(id);

        int a = orderMapper.updateById(order);
        if(a > 0){
            return ResultUtil.exec(true,"ok",null);
        }
        return ResultUtil.exec(false,"系统异常",null);
    }
}
