package com.erp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.erp.model.Departments;
import com.erp.model.Employee;
import com.erp.model.LeaveAsk;
import com.erp.service.DepartmentService;
import com.erp.service.EmployeeService;
import com.erp.service.PersonnelService;

@Controller
@RequestMapping("departmentController")
public class DepartmentController {
	@Resource
	private DepartmentService departmentService;
	
	@Resource
	private EmployeeService employeeService;
	
	@Resource
	private PersonnelService personnelService;
	
	@RequestMapping(value="/queryDE.do")
	public String queryDE(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Model model,Employee employee, Departments departments,String emeId) {
		
			 Employee e=employeeService.queryUserById(request);
			 model.addAttribute("e", e);
			 System.err.println("-----------"+e);
			  List<Employee> emList=employeeService.queryAllEmployee();	
		   			model.addAttribute("emList", emList);
		   			System.err.println("--------------"+emList);
		   		return "view/department/deList";
	}
			@RequestMapping(value="/leavepproval.do")
			
			public String leavepproval(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Model model,Employee employee, Departments departments,String emeId,LeaveAsk leaveAsk,String leaveId) {
	
				 Employee e=employeeService.queryUserById(request);
				        model.addAttribute("e", e);
//
//				List<Employee> emList=employeeService.queryAllEmployee();
//				model.addAttribute("emList", emList);
//				employeeService.queryEmployeeByemeId(emeId);
				
				List<LeaveAsk> leavelist=personnelService.qureyAllLeaveAsk();
				//employeeService.queryEmployeeByLeavelist();
				
				
				model.addAttribute("leavelist", leavelist);
				
			      return "view/leave/leavePproval";
		}
}
