package com.erp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.model.Employee;
import com.erp.utils.pageUtil.PagedResult;

public interface EmployeeService {

	void testbern();
	
	String checkUser(HttpServletRequest request, HttpServletResponse response);

	Employee queryUserById(HttpServletRequest request);

	String getServeTime();

	String countLogUser(HttpServletRequest request);

	String checkRembMe(HttpServletRequest requset, HttpServletResponse response);

	String cancelRememberMe(HttpServletRequest requset, HttpServletResponse response);

	Employee selectBaseInfo(HttpServletRequest request, HttpServletResponse response);


	List<Employee> queryAllEmployee();

	PagedResult<Employee> getAllByPage(Integer pageNumber, Integer pageSize);

	int addEmployee(Employee employee);

	int deleteEmployee(String emeId);

	Employee queryEmployeeByemeId(String emeId);

	int updateEmployee(Employee employee);

}
