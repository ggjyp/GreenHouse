package com.jyp.greenhouse.controller;

import com.jyp.greenhouse.pojo.User;
import com.jyp.greenhouse.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Author   : jyp
 * Date     : 2017/3/7 15:49
 * Describe : 用户控制模块
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/login")
    public ModelAndView login(
            String username,
            String password,
            String codevalidate,
            HttpSession session
    ) {
        ModelAndView ret;
        String code = (String) session.getAttribute("codeValidate");
        if (codevalidate == null || !codevalidate.equalsIgnoreCase(code)){
            session.setAttribute("error","验证码错误");
            ret = new ModelAndView("login");
        }
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            session.setAttribute("username",username);
            ret = new ModelAndView(new RedirectView("/index"));
            System.out.println("登陆成功");
        }catch (Exception e){
            ret = new ModelAndView("systemerror");
        }
        return ret;

    }
}
