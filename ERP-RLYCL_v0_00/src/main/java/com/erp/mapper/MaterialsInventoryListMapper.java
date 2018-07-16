package com.erp.mapper;

import java.util.List;

import com.erp.model.MaterialsInventoryList;

public interface MaterialsInventoryListMapper {
    int deleteByPrimaryKey(String mInventoryId);

    int insert(MaterialsInventoryList record);

    int insertSelective(MaterialsInventoryList record);

    MaterialsInventoryList selectByPrimaryKey(String mInventoryId);

    int updateByPrimaryKeySelective(MaterialsInventoryList record);

    int updateByPrimaryKey(MaterialsInventoryList record);

    List<MaterialsInventoryList> queryAllMaterialsInventory();

	int deleteMaterialInventoryByMaterialId(String materialId);

	MaterialsInventoryList queryMaterialsInventoryByMaterialId(String materialId);

	List<MaterialsInventoryList> getStuByPage(int i);
}