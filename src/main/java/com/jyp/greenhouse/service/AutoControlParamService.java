package com.jyp.greenhouse.service;

import com.jyp.greenhouse.pojo.AutoControlParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author   : jyp
 * Date     : 2017/4/6 15:24
 * Describe :
 */
public interface AutoControlParamService {
    /**
     * 根据自控参数名称查询自控参数
     * @param paramName
     * @return
     */
    AutoControlParam getByParamName(String paramName);

    /**
     * 新增自控参数
     * @param autoControlParam
     * @return
     */
    int saveParamName(AutoControlParam autoControlParam);

    /**
     * 删除自控参数
     * @param paramName
     * @return
     */
    boolean deleteParamByName(String paramName);

    /**
     * 修改自控参数
     * @param autoControlParam
     * @return
     */
    boolean updateParam(AutoControlParam autoControlParam);

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<AutoControlParam> listParams(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize);

    /**
     * 获取记录总数
     * @return
     */
    int countAllParams();
}
