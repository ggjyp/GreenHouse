package com.jyp.greenhouse.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author   : jyp
 * Date     : 2017/4/6 15:39
 * Describe : 通用功能
 */
public class CommonFunctions {
    //得到String类型的当前时间
    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }
}
