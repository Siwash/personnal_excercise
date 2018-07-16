package com.erp.service;

import java.util.List;

import com.erp.model.Departments;

public interface DepartmentService {

	List<Departments> queryAllDepartments();

	Departments queryDepartmentBydepName(String de);

}
