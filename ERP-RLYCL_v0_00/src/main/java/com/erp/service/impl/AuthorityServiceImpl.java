package com.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.erp.mapper.AuthorityMapper;
import com.erp.mapper.DepartmentsMapper;
import com.erp.mapper.EmployeeMapper;
import com.erp.model.Authority;
import com.erp.model.Departments;
import com.erp.model.Employee;
import com.erp.service.AuthorityService;
import com.google.gson.Gson;

import utils.ActiveMenu;
@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	@Resource
	AuthorityMapper authorityMapper;
	@Resource
	EmployeeMapper employeeMapper;
	@Resource
	DepartmentsMapper departmentsMapper;
	public String getMenus(HttpServletRequest request, HttpServletResponse response) {
		ActiveMenu activeMenu=new ActiveMenu();
		String emeId=(String) request.getSession().getAttribute("USERID");
		Employee employee=employeeMapper.selectByPrimaryKey(emeId);
		List<Authority> UserMenus=authorityMapper.selectByDepartment(employee.getDepartment());
		
		//判断职务是否为项目经理
		Departments departments=departmentsMapper.selectByDepName(employee.getDepartment());
		if (departments!=null&&departments.getEmeId().equals(employee.getEmeId())) {
			//部门经理
			UserMenus.add(authorityMapper.selectByPrimaryKey("001"));
		}
		//System.err.println(UserMenus);
		List<Authority> aList=authorityMapper.queryAllAuthority();
		List<Authority> menus=new ArrayList<Authority>();
		for (Authority authority : UserMenus) {
			menus.addAll(activeMenu.getMenu(aList, authority));
		}
		//List<Authority> aList2=activeMenu.getMenu(aList, authorityMapper.selectByPrimaryKey("31"));
		Gson gson=new Gson();
		return gson.toJson(menus);
	}
	

}
