package com.zz.delicious.serviceimpl;
import com.zz.delicious.common.util.ResultUtil;
import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.dao.GoodsMapper;
import com.zz.delicious.entity.Goods;
import com.zz.delicious.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodDao;


    @Override
    public ResultVo selectAllByGid(Integer gid) {
        List<Goods> list = goodDao.selectAllByGid(gid);

       return ResultUtil.exec(true,"OK",list);
    }

    @Override
    public ResultVo selectAllByGoodName(String goodsname) {
        List<Goods> list = goodDao.selectAllByGoodName(goodsname);
        if (list.size() !=0){
            return ResultUtil.exec(true,"OK",list);
        }
        return ResultUtil.exec(false,"没有此商品",null);
    }

    @Override
    public ResultVo selectAllByTypeId(Integer typeid) {
        List<Goods> list = goodDao.selectAllByTypeId(typeid);
        return ResultUtil.exec(true,"OK",list);
    }
}
