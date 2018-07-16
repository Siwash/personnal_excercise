package com.erp.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.model.Employee;
import com.erp.service.EmployeeService;



@Controller
@RequestMapping("userController")
public class EmployeeController {
		@Resource
		EmployeeService employeeService;
		
		@RequestMapping("/login.do")
		public String loginView() {
			return "login";
		}
		@RequestMapping(value="doLogin.ajax",produces="text/html; charset=utf-8")
		public @ResponseBody String doLogIn(HttpServletRequest request,HttpServletResponse response) {			
			return employeeService.checkUser(request,response);
		}
		@RequestMapping(value="toZone.do")
		public String toUserZone() {
			return "index";
		}
		@RequestMapping(value="ZoneInfo.do")
		public String ZoneInfo(HttpServletRequest request,HttpServletResponse response) throws UnknownHostException {
			Employee user=employeeService.queryUserById(request);
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
			Date logindate=(Date) request.getSession().getAttribute("LOGINDATE");
			request.setAttribute("loginDate",sdf.format(logindate));
			request.setAttribute("objPath",request.getRequestURI());
			request.setAttribute("user",user);
			InetAddress id=InetAddress.getLocalHost();
			request.setAttribute("severIp", id.getHostAddress());
			request.setAttribute("sever", id.getHostName());
	       // System.err.println(request.getSession().getMaxInactiveInterval());
	        request.setAttribute("clientIp", request.getRemoteAddr());
	        request.setAttribute("MaxTime", request.getSession().getMaxInactiveInterval());
			return "welcome";
		}
		@RequestMapping(value="logOut.do")
		public String logout(HttpServletRequest  requset,HttpServletResponse response) {
			HttpSession session=requset.getSession();
			session.invalidate();
			return "login";
		}
		@RequestMapping(value="getServeTime.ajax")
		public  @ResponseBody String getServeTime(HttpServletRequest  requset,HttpServletResponse response) {
			return employeeService.getServeTime();
		}
		@RequestMapping(value="countLogUser.ajax")
		public  @ResponseBody String countLogUser(HttpServletRequest  requset,HttpServletResponse response) {
			return employeeService.countLogUser(requset);
		}
		/***
		 * 
		 * <p>rememberMe逻辑：记住密码需要登录进去后生效，忘记密码即可以直接进行操作</p>
		 * */
		@RequestMapping(value="checkRembMe.ajax")
		public  @ResponseBody String checkRembMe(HttpServletRequest  requset,HttpServletResponse response) {
			return employeeService.checkRembMe(requset,response);
		}
		@RequestMapping(value="cancelRememberMe.ajax")
		public  @ResponseBody String cancelRememberMe(HttpServletRequest  requset,HttpServletResponse response) {
			return employeeService.cancelRememberMe(requset,response);
		}
		
	
}
