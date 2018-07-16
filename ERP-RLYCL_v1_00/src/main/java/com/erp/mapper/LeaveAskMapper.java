package com.erp.mapper;

import com.erp.model.LeaveAsk;

public interface LeaveAskMapper {
    int deleteByPrimaryKey(String leaveId);

    int insert(LeaveAsk record);

    int insertSelective(LeaveAsk record);

    LeaveAsk selectByPrimaryKey(String leaveId);

    int updateByPrimaryKeySelective(LeaveAsk record);

    int updateByPrimaryKey(LeaveAsk record);
}