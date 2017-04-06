package com.jyp.greenhouse.service.impl;

import com.jyp.greenhouse.dao.LogDao;
import com.jyp.greenhouse.pojo.Log;
import com.jyp.greenhouse.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/4/6 10:00
 * Describe :
 */
@Service
public class LogServiceImpl implements LogService {
    @Resource
    LogDao logDao;

    @Override
    public Log getById(int id) {
        return logDao.getById(id);
    }

    @Override
    public int saveLog(Log log) {
        return logDao.saveLog(log);
    }

    @Override
    public List<Log> listLogs(int pageNumber, int pageSize) {
        return logDao.listLogs(pageNumber,pageSize);
    }

    @Override
    public int countAllLog() {
        return logDao.countAllLog();
    }
}
