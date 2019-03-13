package com.zz.delicious.serviceimpl;

import com.zz.delicious.common.util.ResultUtil;
import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.dao.GoodsTypeMapper;
import com.zz.delicious.entity.GoodsType;
import com.zz.delicious.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeMapper typeDao;

    @Override
    public ResultVo selectGoodsTypeByCid(Integer cid) {
        List<GoodsType> list = typeDao.selectGoodsTypeByCid(cid);
        return ResultUtil.exec(true,"OK",list);
    }
}
