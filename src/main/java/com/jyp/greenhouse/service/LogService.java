package com.jyp.greenhouse.service;

import com.jyp.greenhouse.pojo.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/4/6 9:59
 * Describe :
 */
public interface LogService {
    /**
     * 根据日志编号获取日志
     * @param id
     * @return
     */
    Log getById(int id);

    /**
     * 新增操作日志
     * @param log
     * @return
     */
    int saveLog(Log log);

    /**
     * 根据pageNumber和pageSize获取操作日志列表
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Log> listLogs(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize);

    /**
     * 返回操作日志总数
     * @return
     */
    int countAllLog();
}
