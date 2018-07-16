package com.erp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
@Controller  
@RequestMapping("userController")  
public class UserController { 
	

	@RequiresRoles("admin")
    @RequestMapping(value="/getUserInfo.do")  
    public String getUserInfo(HttpServletRequest request){  
        String currentUser = (String)request.getSession().getAttribute("currentUser");  
        System.out.println("当前登录的用户为[" + currentUser + "]");  
        request.setAttribute("currUser", currentUser);  
        return "welcome";  
    }  
	@RequestMapping(value="/getUser.do")  
    public String getUser(HttpServletRequest request){  
        String currentUser = (String)request.getSession().getAttribute("currentUser");  
        Subject currentUser2 = SecurityUtils.getSubject();
        System.out.println("当前登录的用户为[" + currentUser2 + "]");  
        request.setAttribute("currUser", currentUser);  
        return "welcome";  
    }  
}  

