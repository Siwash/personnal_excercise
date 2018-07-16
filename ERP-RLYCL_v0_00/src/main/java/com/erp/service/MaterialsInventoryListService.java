package com.erp.service;

import java.util.List;

import com.erp.model.MaterialsInventoryList;

public interface MaterialsInventoryListService {

	List<MaterialsInventoryList> queryAllMaterialsInventory();

	int deleteMaterialInventoryByMaterialId(String materialId);

	int addMaterialInventoryByMaterinl(MaterialsInventoryList materinl);

	MaterialsInventoryList queryMaterialsInventoryByMaterialId(String materialId);

	String getPage(String n);

}
