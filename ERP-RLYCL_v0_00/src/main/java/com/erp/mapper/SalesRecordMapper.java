package com.erp.mapper;

import com.erp.model.SalesRecord;

public interface SalesRecordMapper {
    int deleteByPrimaryKey(String salesRecordId);

    int insert(SalesRecord record);

    int insertSelective(SalesRecord record);

    SalesRecord selectByPrimaryKey(String salesRecordId);

    int updateByPrimaryKeySelective(SalesRecord record);

    int updateByPrimaryKey(SalesRecord record);
}