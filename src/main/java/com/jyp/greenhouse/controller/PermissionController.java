package com.jyp.greenhouse.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jyp.greenhouse.dto.PermissionDTO;
import com.jyp.greenhouse.pojo.Role;
import com.jyp.greenhouse.pojo.User;
import com.jyp.greenhouse.service.RoleService;
import com.jyp.greenhouse.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author   : jyp
 * Date     : 2017-04-04 10:02
 * Describe :
 */
@Controller
@RequestMapping(value = "permission")
public class PermissionController {
    @Resource
    UserService userService;
    @Resource
    RoleService roleService;

    @RequestMapping(value = "")
    public String toPermissionManager() { return "/permission_manager";}

    @RequestMapping(value = "/list")
    public String permissionList(int pageNumber, int pageSize, HttpServletResponse response)
        throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        int total = userService.countAllUser();
        List<PermissionDTO> users = userService.getUserPermissionList((pageNumber-1)*pageSize,pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", users);
        String json = JSONObject.toJSONString(map);
        pw.print(json);
        return null;
    }

    @RequestMapping(value = "/listRoleNames")
    public String listRoleNames(HttpServletResponse response)
        throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        List<Role> roles = roleService.listRoles();
        String json = JSONObject.toJSONString(roles);
        pw.print(json);
        return null;
    }

    //跳转至修改权限页面
    @RequestMapping(value = "/toEdit", method = RequestMethod.GET , produces = "text/plain;charset=UTF-8")
    public String toEdit(HttpServletRequest request, Model model){
        model.addAttribute("username",request.getParameter("username"));
        return "modify_role";
    }

    @RequestMapping(value = "/modifyRole")
    public void modifyRole(int roleId){
    }

}
