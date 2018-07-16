package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erp.mapper.MaterialPurchaseMapper;
import com.erp.mapper.MaterialsInventoryListMapper;
import com.erp.mapper.MaterialsListMapper;
import com.erp.mapper.ProductInventoryMapper;
import com.erp.mapper.ProductMapper;
import com.erp.mapper.ProductTurnoverMapper;
import com.erp.model.MaterialPurchase;
import com.erp.model.MaterialsInventoryList;
import com.erp.model.MaterialsList;
import com.erp.model.Product;
import com.erp.model.ProductInventory;
import com.erp.model.ProductTurnover;
import com.erp.service.StorehouseService;
import com.framework.utils.pageUtil.PageBeanUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
@Service
public class StorehouseServiceImpl implements StorehouseService {
	@Resource
	
	private ProductInventoryMapper productInventoryMapper;
	@Resource
	private  MaterialsListMapper materialsListMapper;
	@Resource
	private MaterialsInventoryListMapper materialsInventoryListMapper;
	@Resource
	private ProductMapper productMapper;
	@Resource
	private MaterialPurchaseMapper materialPurchaseMapper;
	@Resource
	private ProductTurnoverMapper productTurnoverMapper;

	public List<ProductInventory> queryProductInventory() {
		
		
		// TODO Auto-generated method stub
		return productInventoryMapper.queryProductInventory();
	}

	public String querySomeProduct(String id) {
		// TODO Auto-generated method stub
		
		
		ProductInventory  pInventory  =	productInventoryMapper.querySomeProduct(id);
		System.out.println("===="+pInventory);
		
		Gson g= new Gson();
		
		
				
				
		return g.toJson(pInventory);
		
	}

	public List<MaterialsList> queryMaterials() {
		
		
		// TODO Auto-generated method stub
		return materialsListMapper.queryAllMaterials();
	}

	public List<MaterialsInventoryList> queryMaterialsInventory() {
		// TODO Auto-generated method stub
		return materialsInventoryListMapper.queryAllMaterialsInventory();
	}

	public String querySomeMaterials(String id) {
		
		MaterialsInventoryList materialsInventoryList=materialsInventoryListMapper.queryMaterialsInventoryByMaterialId(id);
		Gson g= new Gson();
		
		return g.toJson(materialsInventoryList);
		
	}

	public int addProduct(Product product) {
		
		return productMapper.insertSelective(product);
	}

	public int addProductInventory(ProductInventory productInventory) {
		
		return productInventoryMapper.insertSelective(productInventory);
	}

	public int purchaseRequisition(MaterialPurchase purchaseRequisition) {
		// TODO Auto-generated method stub
		return materialPurchaseMapper.insertSelective(purchaseRequisition);
	}

	public int deleteProduct(String productId) {
		// TODO Auto-generated method stub
		return productMapper.deleteByPrimaryKey(productId);
	}

	public PagedResult<MaterialsList> getAllByPage(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<MaterialsList> glist = materialsListMapper.queryAllMaterials();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(glist);
	}

	public PagedResult<ProductTurnover> getAllByPage1(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<ProductTurnover> glist = productTurnoverMapper.queryProductTurnover();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(glist);
	}

	public int addMaterialsInventoryList(MaterialsInventoryList materialsInventoryList) {
		// TODO Auto-generated method stub
		return materialsInventoryListMapper.insertSelective(materialsInventoryList);
	}

	public int addMaterialsList(MaterialsList materialsList) {
		// TODO Auto-generated method stub
		return materialsListMapper.insertSelective(materialsList);
	}

	public int deleteProductInventory(String productId) {
		// TODO Auto-generated method stub
		return productInventoryMapper.deleteProductInventory(productId);
	}

	public Product queryOneProduct(String productId) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(productId);
	}

	public ProductInventory queryOneProductInventory(String productId) {
		// TODO Auto-generated method stub
		return productInventoryMapper.queryOneProductInventory(productId);
	}

	public int updateOneProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKeySelective(product);
	}

	public int updateOneProductInventory(ProductInventory productInventory) {
		// TODO Auto-generated method stub
		return productInventoryMapper.updateByPrimaryKeySelective(productInventory);
	}

	public int deleteMaterialsList(String materialId) {
		// TODO Auto-generated method stub
		return materialsListMapper.deleteByPrimaryKey(materialId);
	}

	public int deleteMaterialsInventoryList(String materialId) {
		// TODO Auto-generated method stub
		return materialsInventoryListMapper.deleteMaterialInventoryByMaterialId(materialId);
	}

	public MaterialsList queryOneMaterialsList(String materialId) {
		// TODO Auto-generated method stub
		return materialsListMapper.selectByPrimaryKey(materialId);
	}

	public MaterialsInventoryList queryOneMaterialsInventoryList(String materialId) {
		// TODO Auto-generated method stub
		return materialsInventoryListMapper.queryMaterialsInventoryByMaterialId(materialId);
	}

	public int updateOneMaterialsList(MaterialsList materialsList) {
		// TODO Auto-generated method stub
		return materialsListMapper.updateByPrimaryKeySelective(materialsList);
	}

	public int updateOneMaterialsInventoryList(MaterialsInventoryList materialsInventoryList) {
		// TODO Auto-generated method stub
		return materialsInventoryListMapper.updateByPrimaryKeySelective(materialsInventoryList);
	}

	
}
