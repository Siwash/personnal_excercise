package com.erp.controller;


import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.erp.model.Employee;
import com.erp.model.LeaveAsk;
import com.erp.service.EmployeeService;
import com.erp.service.PersonnelService;
import com.erp.utils.PrimaryKeyUtil;
import com.erp.utils.pageUtil.PagedResult;

@Controller
@RequestMapping("personnelController")
public class PersonnelController {
	@Resource
	private EmployeeService employeeService;
	@Resource
	private PersonnelService personnelService;
	
	@RequestMapping(value="list.do")
	public String list(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Model model,Employee employee) {
		  List<Employee> employeelist =employeeService.queryAllEmployee();
		  model.addAttribute("employeelist", employeelist);
	            return "view/employee/emeList";
	}
	
	@RequestMapping(value = "listPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
		
				ModelAndView mv = new ModelAndView();		
		PagedResult<Employee> pageResult = employeeService.getAllByPage(pageNumber, pageSize);
		System.err.println("-----------"+pageResult);
		mv.addObject("pageResult", pageResult);
		mv.setViewName("view/employee/emeList");
		return mv;
	}
	
	
	
		@RequestMapping(value="/addUI.do")
		public String addUI(HttpServletRequest request,HttpServletResponse response,
				HttpSession session,Model model,Employee employee) {
			 
			  return "view/employee/emeAdd";
		}
	
	
	
	@RequestMapping(value="add.do")
	public String add(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Model model,Employee employee) throws Exception {
		
		String dateStr= request.getParameter("entryTimeStr");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		employee.setEntryTime(sdf.parse(dateStr));
		
		employee.setEmeId(PrimaryKeyUtil.getPrimaryKey());
		//System.err.println(employee);
		int n=employeeService.addEmployee(employee);
		System.err.println("---------"+employee);
		return "redirect:/personnelController/listPage.do";
	}
	
	
	@RequestMapping(value="/delete.do")
	public String delete(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Model model,Employee employee,String emeId) {
		 System.out.println("--------"+emeId);
		 
		 int m=employeeService.deleteEmployee(emeId);
		return "redirect:/personnelController/listPage.do";
	}
	@RequestMapping(value="/updateUI.do")
	public String updateUI(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Model model,Employee employee,String emeId) {
	
		Employee e=employeeService.queryEmployeeByemeId(emeId);
		model.addAttribute("employee", e);
		
		return  "view/employee/emeUpdate";
	}
	
	@RequestMapping(value="/update.do")
	public String update(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Model model,Employee employee,String emeId) {
	      // System.err.println(request.getSession().getAttribute("USERID"));
		   int n=employeeService.updateEmployee(employee);
		return "redirect:/personnelController/listPage.do";
		
	}
	
	@RequestMapping(value="/leave.do")
	public String leave(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Model model,Employee employee,String emeId,LeaveAsk leaveAsk,String leaveId) {
		
		List<Employee> emList=employeeService.queryAllEmployee();
		model.addAttribute("emList", emList);
	
		List<LeaveAsk> leavelist=personnelService.qureyAllLeaveAsk();
		model.addAttribute("leavelist", leavelist);
	
		
		return  "view/leave/leaveAskList";
	}
	
}
