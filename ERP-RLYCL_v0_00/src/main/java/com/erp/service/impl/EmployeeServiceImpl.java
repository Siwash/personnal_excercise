package com.erp.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.erp.mapper.EmployeeMapper;
import com.erp.model.Employee;
import com.erp.model.RememberMe;
import com.erp.service.EmployeeService;
import com.erp.utils.pageUtil.PageBeanUtil;
import com.erp.utils.pageUtil.PagedResult;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Resource
	private EmployeeMapper employeeMapper;
	public void testbern() {
		System.err.println("service");
		
	}

	public String checkUser(HttpServletRequest request, HttpServletResponse response) {
		String account=request.getParameter("account");
		String pwd=request.getParameter("pwd");
		if (account!=null&&!account.equals("")) {
			Employee employee=employeeMapper.selectByAccount(account);
			if (employee==null) {
				return "用户不存在";
			}else {
				String isRemember=(String) request.getSession().getAttribute("isRemember");
				if (isRemember!=null&&isRemember.equals("on")&&pwd.equals("MrFox")) {
					pwd=employee.getPassword();
				}
				if (employee.getPassword().equals(pwd)) {
					request.getSession().setAttribute("USERID", employee.getEmeId());
					 ServletContext servletContext=request.getServletContext();
					 @SuppressWarnings("unchecked")
					HashMap<String, String> LOGUSER=(HashMap<String, String>) servletContext.getAttribute("LOGUSER");
					 LOGUSER.put(employee.getEmeId(), request.getRemoteAddr());
					 servletContext.setAttribute("LOGUSER",LOGUSER);
					request.getSession().setAttribute("LOGINDATE", new Date());
					String rembMe=request.getParameter("rememberMe");
					if (rembMe!=null) {
						if (rembMe.equals("true")) {
							Cookie cookie=new Cookie("ERP_37_RememberMe", employee.getEmeId());
							cookie.setMaxAge(30*24*60*60);
							response.addCookie(cookie);
						}
					}
					return "登陆成功";
				}else {
					return "密码错误";
				}
			}
		}else {
			return "账户不合法";
		}
	}

	public Employee queryUserById(HttpServletRequest request) {
		String emeId=(String) request.getSession().getAttribute("USERID");	
		return employeeMapper.selectByPrimaryKey(emeId);
	}

	public String getServeTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");	
		return sdf.format(date);
	}

	public String countLogUser(HttpServletRequest request) {
		ServletContext servletContext=request.getServletContext();
		@SuppressWarnings("unchecked")
		HashMap<String, String> loginUser=(HashMap<String, String>) servletContext.getAttribute("LOGUSER");
		return loginUser.size()+"";
	}

	public String checkRembMe(HttpServletRequest requset, HttpServletResponse response) {
		Cookie [] cookies=requset.getCookies();
		RememberMe rememberMe=new RememberMe();
		rememberMe.setUserAccount("");
		rememberMe.setUserPwd("");
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("ERP_37_RememberMe")) {
				Employee user=employeeMapper.selectByPrimaryKey(cookie.getValue());
				rememberMe.setUserAccount(user.getUsername());
				requset.getSession().setAttribute("isRemember","on");
				rememberMe.setUserPwd("MrFox");//浏览器不可见密码
			}
		}
		Gson gson=new Gson();
		return gson.toJson(rememberMe);
	}

	public String cancelRememberMe(HttpServletRequest requset, HttpServletResponse response) {
		Cookie [] cookies=requset.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("ERP_37_RememberMe")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				requset.getSession().setAttribute("isRemember","off");
			}
		}
		return null;
	}

	public Employee selectBaseInfo(HttpServletRequest request, HttpServletResponse response) {
		String userId=(String) request.getSession().getAttribute("USERID");
		Employee employee=employeeMapper.selectByPrimaryKey(userId);
		
		return employee;
	}

	public List<Employee> queryAllEmployee() {
		
		return employeeMapper.queryAllUser();
	}

	public int addEmployee(Employee employee) {
		
		return employeeMapper.insert(employee);
	}

	public int deleteEmployee(String emeId) {
		
		return employeeMapper.deleteByPrimaryKey(emeId);
	}

	public Employee queryEmployeeByemeId(String emeId) {
		
		return employeeMapper.selectByPrimaryKey(emeId);
	}

	public int updateEmployee(Employee employee) {
		
		return employeeMapper.updateByPrimaryKeySelective(employee);
	}

	public PagedResult<Employee> getAllByPage(Integer pageNumber, Integer pageSize) {
		
		
				PageHelper.startPage(pageNumber, pageSize);
				
				List<Employee> glist = employeeMapper.queryAllUser();
				
				return PageBeanUtil.toPagedResult(glist);
	}


}
