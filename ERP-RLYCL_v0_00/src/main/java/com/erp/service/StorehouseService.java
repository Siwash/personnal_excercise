package com.erp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.erp.model.MaterialPurchase;
import com.erp.model.MaterialsInventoryList;
import com.erp.model.MaterialsList;
import com.erp.model.Product;
import com.erp.model.ProductInventory;
import com.erp.model.ProductTurnover;
import com.framework.utils.pageUtil.PagedResult;

public interface StorehouseService {

	List<ProductInventory> queryProductInventory();

	String querySomeProduct(String id);

	List<MaterialsList> queryMaterials();

	List<MaterialsInventoryList> queryMaterialsInventory();

	String querySomeMaterials(String id);

	int addProduct(Product product);

	int addProductInventory(ProductInventory productInventory);

	int purchaseRequisition(MaterialPurchase purchaseRequisition);

	int deleteProduct(String productId);

	PagedResult<MaterialsList> getAllByPage(Integer pageNumber, Integer pageSize);

	PagedResult<ProductTurnover> getAllByPage1(Integer pageNumber, Integer pageSize);

	int addMaterialsInventoryList(MaterialsInventoryList materialsInventoryList);

	int addMaterialsList(MaterialsList materialsList);

	int deleteProductInventory(String productId);

	Product queryOneProduct(String productId);

	ProductInventory queryOneProductInventory(String productId);

	int updateOneProduct(Product product);

	int updateOneProductInventory(ProductInventory productInventory);

	int deleteMaterialsList(String materialId);

	int deleteMaterialsInventoryList(String materialId);

	MaterialsList queryOneMaterialsList(String materialId);

	MaterialsInventoryList queryOneMaterialsInventoryList(String materialId);

	int updateOneMaterialsList(MaterialsList materialsList);

	int updateOneMaterialsInventoryList(MaterialsInventoryList materialsInventoryList);

}
