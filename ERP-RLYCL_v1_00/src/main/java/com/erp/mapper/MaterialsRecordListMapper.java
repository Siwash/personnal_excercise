package com.erp.mapper;

import com.erp.model.MaterialsRecordList;

public interface MaterialsRecordListMapper {
    int deleteByPrimaryKey(String recordlistId);

    int insert(MaterialsRecordList record);

    int insertSelective(MaterialsRecordList record);

    MaterialsRecordList selectByPrimaryKey(String recordlistId);

    int updateByPrimaryKeySelective(MaterialsRecordList record);

    int updateByPrimaryKey(MaterialsRecordList record);
}