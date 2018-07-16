package com.erp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.model.Employee;
import com.erp.model.LeaveAsk;
import com.erp.model.WorkRecordList;
import com.erp.service.EmployeeService;
import com.erp.service.SelfService;
import com.sun.xml.internal.ws.api.pipe.Tube;

@Controller
@RequestMapping("selfController")
public class SelfController {
	@Resource
	EmployeeService employeeService;
	@Resource 
	SelfService selfService;
	@RequestMapping("baseInfo.do")
	public String baseInfo(HttpServletRequest request,HttpServletResponse response){
		Employee employee=employeeService.selectBaseInfo(request,response);
		request.setAttribute("user", employee);
		return "view/employee/baseInfo";
	}
	
	@RequestMapping(value="showRecoder.ajax",produces="text/html;charset=utf-8")
	public @ResponseBody String showRecoder(HttpServletRequest request,HttpServletResponse response,String pageIndex,String flushData){
		boolean firstPage=flushData!=null? true :false;
		String result=selfService.getRecoderPage(request,firstPage,pageIndex);
		return result;
	}
	@RequestMapping("doRecoder.ajax")
	public @ResponseBody String doRecoder(HttpServletRequest request,HttpServletResponse response,WorkRecordList record){
		String result=selfService.doRecoder(request,record);
		return result;
	}
	@RequestMapping("readRecoder.do")
	public String readRecoder(HttpServletRequest request,HttpServletResponse response,String recordId){
		String result=selfService.readRecoder(request,recordId);
		return "view/self/readRecord";
	}
	@RequestMapping(value="showAskLeave.ajax",produces="text/html;charset=utf-8")
	public @ResponseBody String showAskLeave(HttpServletRequest request,HttpServletResponse response,String pageIndex,String flushData){
		boolean firstPage=flushData!=null? true :false;
		String result=selfService.getLeavePage(request,firstPage,pageIndex);
		return result;
	}
	@RequestMapping("doAskLeave.ajax")
	public @ResponseBody String doAskLeave(HttpServletRequest request,HttpServletResponse response,LeaveAsk leave){
		String result=selfService.doLeave(request,leave);
		return result;
	}
	@RequestMapping("readLeave.do")
	public String readLeave(HttpServletRequest request,HttpServletResponse response,String leaveId){
		String result=selfService.readLeave(request,leaveId);
		return "view/self/readLeave";
	}
}
