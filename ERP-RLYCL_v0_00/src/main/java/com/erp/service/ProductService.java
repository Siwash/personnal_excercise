package com.erp.service;

import java.util.List;

import com.erp.model.MaterialsList;
import com.erp.model.MaterialsRecordList;
import com.erp.model.Product;
import com.erp.model.ProductTurnover;
import com.framework.utils.pageUtil.PagedResult;

public interface ProductService {

	List<Product> queryProduct();

	List<ProductTurnover> queryProductTurnover();

	List<com.erp.model.MaterialsRecordList> queryMaterialsRecordList();

	PagedResult<Product> getAllByPage(Integer pageNumber, Integer pageSize);

	PagedResult<MaterialsRecordList> getAllByPage2(Integer pageNumber, Integer pageSize);

	



}
