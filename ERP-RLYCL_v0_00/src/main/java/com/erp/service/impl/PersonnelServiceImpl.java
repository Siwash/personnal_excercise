package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.mapper.EmployeeMapper;
import com.erp.mapper.LeaveAskMapper;
import com.erp.model.Employee;
import com.erp.model.LeaveAsk;
import com.erp.service.PersonnelService;
@Service
public class PersonnelServiceImpl implements PersonnelService {
	@Resource
	private EmployeeMapper employeeMapper;
	
	@Resource
	private LeaveAskMapper leaveAskMapper;

	public List<LeaveAsk> qureyAllLeaveAsk() {
		
		return leaveAskMapper.qureyAllLeaveAsk();
	}

	
	
}
