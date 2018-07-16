package com.erp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.erp.model.MaterialsList;

public interface MaterialsListMapper {
    int deleteByPrimaryKey(String materialId);

    int insert(MaterialsList record);

    int insertSelective(MaterialsList record);

    MaterialsList selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(MaterialsList record);

    int updateByPrimaryKey(MaterialsList record);

	
	ArrayList<MaterialsList> queryAllMaterials();

	List<MaterialsList> queryMaterialByNameAndType(@Param(value="materialName")String materialName, @Param(value="materialType")String materialType);

	MaterialsList queryMaterialNameById(String materialId);

	List<MaterialsList> getPage(int j);
}