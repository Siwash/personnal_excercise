package com.erp.mapper;

import com.erp.model.Departments;

public interface DepartmentsMapper {
    int deleteByPrimaryKey(String depId);

    int insert(Departments record);

    int insertSelective(Departments record);

    Departments selectByPrimaryKey(String depId);

    int updateByPrimaryKeySelective(Departments record);

    int updateByPrimaryKey(Departments record);
}