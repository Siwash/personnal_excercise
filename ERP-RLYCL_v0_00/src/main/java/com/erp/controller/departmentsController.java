package com.erp.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.model.Departments;
import com.erp.service.departmentsService;

@Controller
@RequestMapping("departmentsController")
public class departmentsController {
	@Resource
	private departmentsService ds;
	
	//部门的查询功能
	@RequestMapping("/listDepartments.do")
	public String listDepartments(HttpServletRequest request,Model model){
		List<Departments> dpList=ds.queryAllDepartments();
		model.addAttribute("dpList", dpList);
		//查询的部门数量
		request.setAttribute("DPNUM", dpList.size());
		return "view/department/department_ist";
	}
	
	//转入修改页面
	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request,Model model,String depId){
		
		Departments dm=ds.queryDepartmentByDepId(depId);
		model.addAttribute("dm", dm);
		return "view/department/department_update";
	}
	
	//修改方法
	@RequestMapping("/update.ajax")
	@ResponseBody
	public String update(HttpServletRequest request){
		Departments departments=new Departments();
		String depName=request.getParameter("depName");
		String emeId=request.getParameter("emeId");
		String descriptional=request.getParameter("descriptional");
		String depId=request.getParameter("depId");
		departments.setDepId(depId);
		departments.setDepName(depName);
		departments.setEmeId(emeId);
		departments.setDescriptional(descriptional);
		System.out.println(departments+"----------");
		int n=ds.updateDepartment(departments);
		System.out.println(n);
		
		if(n>0){
			System.out.println("YES");
			return "YES";
		}else{
			return "NO";
		}
	}
	
	//  增加
	@RequestMapping("/add.ajax")
	@ResponseBody
	public String add(HttpServletRequest request){
		Departments departments=new Departments();
		String depName=request.getParameter("depName");
		String emeId=request.getParameter("emeId");
		String descriptional=request.getParameter("descriptional");
		departments.setDepId(UUID.randomUUID().toString());
		departments.setDepName(depName);
		departments.setEmeId(emeId);
		departments.setDescriptional(descriptional);
		List<Departments> dpList=ds.queryAllDepartments();
		for (Departments d : dpList) {
			//同名部门不让添加
			if(depName.equals(d.getDepName())){
				return "NO";
			}else{
				int n=ds.addDepartments(departments);
				return "YES";
			}
		}
		return "";
	}
	
	//删除
	@RequestMapping("delete.ajax")
	@ResponseBody
	public String delete(HttpServletRequest request){
		String depId=request.getParameter("depId");
		System.out.println(depId);
		
		int n=ds.deleteDepartmentByDepId(depId);
		System.out.println(n);
		System.out.println("-----"+depId+"----我删除了");
		return "";
	}
}
