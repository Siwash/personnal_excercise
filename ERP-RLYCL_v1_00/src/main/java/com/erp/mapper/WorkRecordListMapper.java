package com.erp.mapper;

import com.erp.model.WorkRecordList;

public interface WorkRecordListMapper {
    int deleteByPrimaryKey(String recordListId);

    int insert(WorkRecordList record);

    int insertSelective(WorkRecordList record);

    WorkRecordList selectByPrimaryKey(String recordListId);

    int updateByPrimaryKeySelective(WorkRecordList record);

    int updateByPrimaryKey(WorkRecordList record);
}