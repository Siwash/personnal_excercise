package com.erp.mapper;

import com.erp.model.AuthorityRole;

public interface AuthorityRoleMapper {
    int deleteByPrimaryKey(String authorityRoleId);

    int insert(AuthorityRole record);

    int insertSelective(AuthorityRole record);

    AuthorityRole selectByPrimaryKey(String authorityRoleId);

    int updateByPrimaryKeySelective(AuthorityRole record);

    int updateByPrimaryKey(AuthorityRole record);
}