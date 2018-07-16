package com.erp.mapper;

import java.util.List;

import com.erp.model.Authority;

public interface AuthorityMapper {
    int deleteByPrimaryKey(String authorityId);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(String authorityId);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);

	List<Authority> queryAllAuthority();

	List<Authority> selectByDepartment(String department);
}