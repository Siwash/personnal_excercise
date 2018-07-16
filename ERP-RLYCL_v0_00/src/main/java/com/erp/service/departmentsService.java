package com.erp.service;

import java.util.List;

import com.erp.model.Departments;

public interface departmentsService {

	List<Departments> queryAllDepartments();

	Departments queryDepartmentByDepId(String depId);

	int updateDepartment(Departments departments);

	int addDepartments(Departments departments);

	int deleteDepartmentByDepId(String depId);

}
