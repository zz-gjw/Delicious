package com.zz.delicious.serviceimpl;

import com.zz.delicious.common.util.ResultUtil;
import com.zz.delicious.common.vo.ResultVo;
import com.zz.delicious.dao.GoodsCateMapper;
import com.zz.delicious.entity.GoodsCate;
import com.zz.delicious.service.GoodsCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsCateServiceImpl implements GoodsCateService {
    @Autowired
    private GoodsCateMapper cateDao;
    @Override
    public ResultVo selectAll() {
        List<GoodsCate> list = cateDao.selectAll();
        return ResultUtil.exec(true,"OK",list);
    }
}
