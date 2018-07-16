package com.erp.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.erp.model.MaterialsList;

public interface MaterialsListService {

	ArrayList<MaterialsList> queryAllMaterials();

	List<MaterialsList> getMaterialByNameAndType(HttpServletRequest request);

	MaterialsList queryMaterialById(String materialId);

	String getPage(String n);



}
