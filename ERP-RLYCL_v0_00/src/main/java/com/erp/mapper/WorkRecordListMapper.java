package com.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.erp.model.WorkRecordList;

public interface WorkRecordListMapper {
    int deleteByPrimaryKey(String recordListId);

    int insert(WorkRecordList record);

    int insertSelective(WorkRecordList record);

    WorkRecordList selectByPrimaryKey(String recordListId);

    int updateByPrimaryKeySelective(WorkRecordList record);

    int updateByPrimaryKey(WorkRecordList record);

	String totalRecoders(String userId);

	List<WorkRecordList> getRecoderPageDate(@Param(value="index")int m,@Param(value="emeId") String emeID);
}