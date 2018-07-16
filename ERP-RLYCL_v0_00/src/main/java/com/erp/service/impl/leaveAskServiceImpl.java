package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.erp.mapper.LeaveAskMapper;
import com.erp.model.LeaveAsk;
import com.erp.service.leaveAskService;

@Service
public class leaveAskServiceImpl implements leaveAskService {
	
	@Resource
	private LeaveAskMapper lam;

	public List<LeaveAsk> queryAllAskLeave() {
		return lam.qureyAllLeaveAsk();
	}

	public LeaveAsk queryLeaveByLeaveId(String leaveId) {
		return lam.selectByPrimaryKey(leaveId);
	}

	public int updateLeaveByLa(LeaveAsk la) {
		return lam.updateByPrimaryKeySelective(la);
	}

	public List<LeaveAsk> queryLeaveByOpinion(String opinion) {
		return lam.queryLeaveByOpinion(opinion);
	}
	
}
