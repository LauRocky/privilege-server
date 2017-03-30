package com.leanit.privilege.controller;

import com.leanit.privilege.biz.IPrivilegeBaseApiService;
import com.leanit.privilege.model.User;
import com.leanit.privilege.utils.ConstantUtil;
import com.leanit.privilege.utils.SessionUtil;
import com.leanit.privilege.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;


/**
 * 主界面及登录验证相关的控制器
 */

@Controller
@RequestMapping("/controller")
public class IndexController {

    @Autowired
    private IPrivilegeBaseApiService privilegeBaseApiService;

    @RequestMapping("/main")
    public String main(String visitedModule, HttpServletRequest request, ModelMap map) {

        visitedModule = "p";

        //初始化用户、菜单
        User user = SessionUtil.getSessionUser(request);
        String menus = privilegeBaseApiService.getModuleTree(user.getId(), visitedModule, "");
        map.put("user", user);
        map.put("menus", menus);

        int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        map.put("hours", hours);

        return "main.ftl";
    }

    @RequestMapping("/modifypasswordform")
    public String modifypasswordform(HttpServletRequest request) throws Exception {
        return "modifypasswordform.ftl";
    }

    @ResponseBody
    @RequestMapping("/modifypassword")
    public String modifypassword(String oldpassword, String password, HttpServletRequest request) throws Exception {
        if (StringUtil.isStrEmpty(oldpassword) || StringUtil.isStrEmpty(password)) return ConstantUtil.Fail;
        //初始化用户、菜单
        User user = SessionUtil.getSessionUser(request);
        if (!user.getPassword().equals(StringUtil.makeMD5(oldpassword))) return ConstantUtil.Fail;
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setPassword(StringUtil.makeMD5(password));
        newUser.setUpdateDate(new Date());
        newUser.setUpdatePerson(user.getUsername());
        privilegeBaseApiService.updateUserById(newUser);

        //更新session
        user.setPassword(newUser.getPassword());
        request.getSession().setAttribute(SessionUtil.SessionSystemLoginUserName, user);

        return ConstantUtil.Success;
    }
}
