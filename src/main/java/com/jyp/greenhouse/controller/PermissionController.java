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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author   : jyp
 * Date     : 2017-04-04 10:02
 * Describe :
 */
@Controller
@RequestMapping(value = "permission")
public class PermissionController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
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
        model.addAttribute("user",userService.getUserByName(request.getParameter("username")));
        return "modify_role";
    }


    /**
     * 修改权限
     * @param username
//     * @param roleId
     * @return
     */
    @RequestMapping(value = "/modifyRole", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, String> modifyRole(String username, int roleId)  {
        HashMap<String,String> map = new HashMap<>();

        if(userService.updateRoleId(username, roleId)){
            map.put("result","success");
        }
        else {
            map.put("result","failed");
        }
        return map;
    }

}
