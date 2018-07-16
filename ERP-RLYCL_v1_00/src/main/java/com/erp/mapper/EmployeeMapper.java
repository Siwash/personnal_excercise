package com.erp.mapper;

import com.erp.model.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String emeId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String emeId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}