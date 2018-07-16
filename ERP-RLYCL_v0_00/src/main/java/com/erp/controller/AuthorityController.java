package com.erp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.service.AuthorityService;

@Controller
@RequestMapping("athryController")
public class AuthorityController {
		
	@Resource
	AuthorityService authorityService;
	@RequestMapping(value="getMenu.ajax",produces="text/html;charset=utf-8")
	private @ResponseBody String activeMenu(HttpServletRequest request,HttpServletResponse response) {
			return authorityService.getMenus(request,response);
	}
}
