package company.items.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.items.model.SysUser;

public interface UserService {

	String checkUser(HttpServletRequest request, HttpServletResponse response);

	SysUser queryUserById(HttpServletRequest request);

	String getServeTime();

	String countLogUser(HttpServletRequest request);

	String checkRembMe(HttpServletRequest requset, HttpServletResponse response);

	String cancelRememberMe(HttpServletRequest requset, HttpServletResponse response);

}
