package com.erp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.erp.model.MaterialPurchase;
import com.framework.utils.pageUtil.PagedResult;

public interface purchaseService {

	void addPurchaseListToDB(MaterialPurchase materialPurchase);

	List<MaterialPurchase> queryAllMaterials();

	List<MaterialPurchase> queryMaterialPurchaseListByTrackingNumAndEmeId(HttpServletRequest request);


	String getPage(String n, HttpSession session);

	List<MaterialPurchase> queryMaterialPurchase();

	PagedResult<MaterialPurchase> getAllByPage3(Integer pageNumber, Integer pageSize);
}
