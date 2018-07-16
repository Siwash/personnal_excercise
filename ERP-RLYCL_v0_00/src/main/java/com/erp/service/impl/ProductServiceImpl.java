package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.erp.mapper.MaterialsRecordListMapper;
import com.erp.mapper.ProductMapper;
import com.erp.mapper.ProductTurnoverMapper;
import com.erp.model.MaterialsRecordList;
import com.erp.model.Product;
import com.erp.model.ProductTurnover;
import com.erp.service.ProductService;
import com.framework.utils.pageUtil.PageBeanUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.github.pagehelper.PageHelper;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Resource
	
	private ProductMapper productMapper;
	@Resource
	private ProductTurnoverMapper productTurnoverMapper;
	@Resource
	private MaterialsRecordListMapper materialsRecordListMapper;

	public List<Product> queryProduct() {
		
		return productMapper.queryProduct();
	}

	public List<ProductTurnover> queryProductTurnover() {
		
		return productTurnoverMapper.queryProductTurnover();
	}

	public List<MaterialsRecordList> queryMaterialsRecordList() {
		
		return materialsRecordListMapper.queryMaterialsRecordList();
	}

	public PagedResult<Product> getAllByPage(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<Product> glist = productMapper.queryProduct();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(glist);
	}

	public PagedResult<MaterialsRecordList> getAllByPage2(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<MaterialsRecordList> glist = materialsRecordListMapper.queryMaterialsRecordList();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(glist);
	}


}
