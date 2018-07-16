package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.mapper.DepartmentsMapper;
import com.erp.model.Departments;
import com.erp.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentsMapper departmentsMapper;

	public List<Departments> queryAllDepartments() {
		
		return departmentsMapper.queryAllDepartments();
	}

	public Departments queryDepartmentBydepName(String de) {
		return departmentsMapper.queryDepartmentBydepName(de);
	}
}
