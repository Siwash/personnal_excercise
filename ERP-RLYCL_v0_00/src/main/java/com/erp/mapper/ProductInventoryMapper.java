package com.erp.mapper;

import java.util.List;

import com.erp.model.ProductInventory;

public interface ProductInventoryMapper {
    int deleteByPrimaryKey(String pInventoryId);

    int insert(ProductInventory record);

    int insertSelective(ProductInventory record);

    ProductInventory selectByPrimaryKey(String pInventoryId);

    int updateByPrimaryKeySelective(ProductInventory record);

    int updateByPrimaryKey(ProductInventory record);
    List<ProductInventory> queryProductInventory();

	ProductInventory querySomeProduct(String id);

	int addProductInventory(ProductInventory productInventory);

	int deleteProduct(String productId);

	int deleteProductInventory(String productId);

	ProductInventory queryOneProductInventory(String productId);
}