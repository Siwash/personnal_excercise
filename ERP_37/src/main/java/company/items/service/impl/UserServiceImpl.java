package company.items.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import company.items.mapper.SysUserMapper;
import company.items.model.RememberMe;
import company.items.model.SysUser;
import company.items.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	SysUserMapper userMapper;
	public String checkUser(HttpServletRequest request,HttpServletResponse response) {
			String account=request.getParameter("account");
			String pwd=request.getParameter("pwd");
			if (account!=null&&!account.equals("")) {
				SysUser user=userMapper.selectByAccount(account);
				if (user==null) {
					return "用户不存在";
				}else {
					String isRemember=(String) request.getSession().getAttribute("isRemember");
					if (isRemember!=null&&isRemember.equals("on")) {
						pwd=user.getUserPwd();
					}
					if (user.getUserPwd().equals(pwd)) {
						request.getSession().setAttribute("USERID", user.getUserId());
						 ServletContext servletContext=request.getServletContext();
						 @SuppressWarnings("unchecked")
						HashMap<String, String> LOGUSER=(HashMap<String, String>) servletContext.getAttribute("LOGUSER");
						 LOGUSER.put(user.getUserId(), request.getRemoteAddr());
						 servletContext.setAttribute("LOGUSER",LOGUSER);
						request.getSession().setAttribute("LOGINDATE", new Date());
						String rembMe=request.getParameter("rememberMe");
						if (rembMe!=null) {
							if (rembMe.equals("true")) {
								Cookie cookie=new Cookie("ERP_37_RememberMe", user.getUserId());
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
	public SysUser queryUserById(HttpServletRequest request) {
		String userID=(String) request.getSession().getAttribute("USERID");	
		return userMapper.selectByPrimaryKey(userID);
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
				SysUser user=userMapper.selectByPrimaryKey(cookie.getValue());
				rememberMe.setUserAccount(user.getUserAccount());
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

}
