package com.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.erp.model.LeaveAsk;

public interface LeaveAskMapper {
    int deleteByPrimaryKey(String leaveId);

    int insert(LeaveAsk record);

    int insertSelective(LeaveAsk record);

    LeaveAsk selectByPrimaryKey(String leaveId);

    int updateByPrimaryKeySelective(LeaveAsk record);

    int updateByPrimaryKey(LeaveAsk record);

	String totalLeave(String userId);

	List<LeaveAsk> getLeavePageDate(@Param(value="startIndex")int m,@Param(value="userId") String userId);

	List<LeaveAsk> qureyAllLeaveAsk();

	List<LeaveAsk> queryLeaveByOpinion(String opinion);
}