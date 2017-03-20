package com.jyp.greenhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Author   : jyp
 * Date     : 2017/3/7 16:23
 * Describe : 访问SireWhere的RESTFUL接口
 */
@Controller
@RequestMapping(value = "sitewhere")
public class SiteWhereController {

    @RequestMapping(value = "/assignments/measurements")
    public String getSite(HttpSession session) throws IOException{
        URL url = new URL( "http://localhost:8080/sitewhere/api/assignments/b8430c7c-5690-4fc7-ba13-644b66fbbe03/measurements");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 提交模式
        conn.setRequestMethod("GET");// POST GET PUT DELETE
        //将用户名密码转化为Base64编码
//        String userInfo = "admin:password";
//        String userInfoBase64 =  (new sun.misc.BASE64Encoder()).encode(userInfo.getBytes());//admin:password
        //授权
        conn.setRequestProperty("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=");
        //租户身份认证
        conn.setRequestProperty("X-SiteWhere-Tenant", "sitewhere1234567890");
        // 设置访问提交模式，表单提交
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setConnectTimeout(15000);// 连接超时 单位毫秒
        conn.setReadTimeout(15000);// 读取超时 单位毫秒
        //读取请求返回值
//       conn.setDoOutput(true);// 是否输入参数
//
//       StringBuffer params = new StringBuffer();
//       // 表单参数与get形式一样
//       params.append("f292139625cd4d59fcff42360ce11fc");
//       byte[] bypes = params.toString().getBytes();
//       conn.getOutputStream().write(bypes);// 输入参数
        byte bytes[]=new byte[1024];
        InputStream inStream=conn.getInputStream();
        inStream.read(bytes, 0, inStream.available());
        System.out.println(new String(bytes, "utf-8"));
        session.setAttribute("measurements", new String(bytes, "utf-8"));
        return "/login";
    }
}
