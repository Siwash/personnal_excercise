package com.erp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.service.EmployeeService;

@Controller
@RequestMapping("testController")
public class EmployeeController {
		@Resource
		EmployeeService employeeService;
		@RequestMapping(value="test.do")
		public String doLogIn(HttpServletRequest request,HttpServletResponse response) {
			System.err.println("*********");
			employeeService.testbern();
			return "index";
		}
	
	
}
