package com.erp.service;

import java.util.List;

import com.erp.model.LeaveAsk;

public interface leaveAskService {

	List<LeaveAsk> queryAllAskLeave();

	LeaveAsk queryLeaveByLeaveId(String leaveId);

	int updateLeaveByLa(LeaveAsk la);

	List<LeaveAsk> queryLeaveByOpinion(String opinion);

}
