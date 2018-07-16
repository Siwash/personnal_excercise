package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.mapper.DepartmentsMapper;
import com.erp.model.Departments;
import com.erp.service.departmentsService;

@Service
public class departmentsServiceImpl implements departmentsService {
	
	@Resource
	private DepartmentsMapper dm;

	public List<Departments> queryAllDepartments() {
		return dm.queryAllDepartments();
	}

	public Departments queryDepartmentByDepId(String depId) {
		return dm.selectByPrimaryKey(depId);
	}

	public int updateDepartment(Departments departments) {
		return dm.updateByPrimaryKeySelective(departments);
	}

	public int addDepartments(Departments departments) {
		return dm.insertSelective(departments);
	}

	public int deleteDepartmentByDepId(String depId) {
		return dm.deleteByPrimaryKey(depId);
	}
}
