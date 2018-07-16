package com.erp.mapper;

import com.erp.model.MaterialsList;

public interface MaterialsListMapper {
    int deleteByPrimaryKey(String materialId);

    int insert(MaterialsList record);

    int insertSelective(MaterialsList record);

    MaterialsList selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(MaterialsList record);

    int updateByPrimaryKey(MaterialsList record);
}