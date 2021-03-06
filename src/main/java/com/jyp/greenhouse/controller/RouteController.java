package com.jyp.greenhouse.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author   : jyp
 * Date     : 2017/3/7 15:59
 * Describe :
 */
@Controller
@RequestMapping(value = "")
public class RouteController {
    @RequiresRoles(value = {"管理员","普通用户"}, logical = Logical.OR)
    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "unAuthorization")
    public String unAuthorization() { return "unAuthorization";}

    //测试用例
    @RequestMapping(value = "test")
    public String test() { return "send_param_test";}
}
