package com.jyp.greenhouse.service.impl;

import com.jyp.greenhouse.dao.AutoControlParamDao;
import com.jyp.greenhouse.pojo.AutoControlParam;
import com.jyp.greenhouse.service.AutoControlParamService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/4/6 15:25
 * Describe :
 */
@Service
public class AutoControlParamServiceImpl implements AutoControlParamService {
    @Resource
    AutoControlParamDao autoControlParamDao;

    @Override
    public AutoControlParam getByParamName(String paramName) {
        return autoControlParamDao.getByParamName(paramName);
    }

    @Override
    public int saveParamName(AutoControlParam autoControlParam) {
        return autoControlParamDao.saveParamName(autoControlParam);
    }

    @Override
    public boolean deleteParamByName(String paramName) {
        return autoControlParamDao.deleteParamByName(paramName);
    }

    @Override
    public boolean updateParam(AutoControlParam autoControlParam) {
        return autoControlParamDao.updateParam(autoControlParam);
    }

    @Override
    public List<AutoControlParam> listParams(int pageNumber, int pageSize) {
        return autoControlParamDao.listParams(pageNumber, pageSize);
    }

    @Override
    public int countAllParams() {
        return autoControlParamDao.countAllParams();
    }
}
