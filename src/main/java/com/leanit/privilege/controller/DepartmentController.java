package com.leanit.privilege.controller;

import com.leanit.privilege.biz.IDepartmentService;
import com.leanit.privilege.biz.IPrivilegeBaseApiService;
import com.leanit.privilege.model.Department;
import com.leanit.privilege.model.User;
import com.leanit.privilege.utils.ConstantUtil;
import com.leanit.privilege.utils.JsonUtil;
import com.leanit.privilege.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *部门管理相关的控制器 
 */

@Controller
@RequestMapping("/controller/department")
public class DepartmentController {

	@Autowired
	private IPrivilegeBaseApiService privilegeBaseApiService;

	@Autowired
	private IDepartmentService departmentService;
	
	@RequestMapping("/list")
    public String main(String visitedModule,String visitedResource,HttpServletRequest request,ModelMap map) {

		//初始化用户、菜单
		User user = SessionUtil.getSessionUser(request);
		String menus = privilegeBaseApiService.getModuleTree(user.getId(),visitedModule,visitedResource);
        map.put("user", user);
        map.put("menus", menus);
        
		return "department/list.ftl";
    }
	
	@ResponseBody
	@RequestMapping(value="/getDepartmentTree",produces="application/json;charset=UTF-8")
    public String getDepartmentTree(HttpServletResponse response,ModelMap map) {
		String tree = departmentService.getDepartmentTree();
		return tree;
	}
	
	@ResponseBody
	@RequestMapping("/get")
    public String get(Integer id,ModelMap map) {
		
		Department department = departmentService.getDepartmentById(id);
		return JsonUtil.convertObj2json(department).toString();
	}
	
	@ResponseBody
	@RequestMapping("/add")
    public String add(@ModelAttribute("department")Department department,HttpServletRequest request) {
		
		//从session取出User对象
		User user = SessionUtil.getSessionUser(request);
		//生成节点
		departmentService.createDepartment(department,user);		
		return JsonUtil.convertObj2json(department).toString();
    }
	
	@ResponseBody
	@RequestMapping("/update")
    public String update(@ModelAttribute("department")  Department department,HttpServletRequest request) {
		//从session取出User对象
		User user = SessionUtil.getSessionUser(request);

		//生成节点积累
		departmentService.updateDepartmentById(department,user);
		
		return JsonUtil.convertObj2json(department).toString();
    }
	
	@ResponseBody
	@RequestMapping("/delete")
	public String  delete(@RequestParam("id") Integer id) throws Exception{		
	
		//判断节点是否被用户关联
		if(departmentService.isUsedByUser(id))
		{
			return ConstantUtil.Fail;
		}
		
		departmentService.deleteDepartmentById(id);
		
		return ConstantUtil.Success;
	}
}
