package com.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.mapper.MaterialsListMapper;
import com.erp.model.MaterialsList;
import com.erp.service.MaterialsListService;
import com.google.gson.Gson;

@Service
public class MaterialsListServiceImpl implements MaterialsListService {
	@Autowired
	private MaterialsListMapper mlm;
	
	public ArrayList<MaterialsList> queryAllMaterials() {
		
		return mlm.queryAllMaterials();
	}

	public List<MaterialsList> getMaterialByNameAndType(HttpServletRequest request) {
		String materialName=request.getParameter("materialName");
		String materialType=request.getParameter("materialType");
		List<MaterialsList> mtlList=mlm.queryMaterialByNameAndType(materialName,materialType);
		return mtlList;
	}

	public MaterialsList queryMaterialById(String materialId) {
		
		return mlm.selectByPrimaryKey(materialId);
	}

	public String getPage(String n) {
		int i=0;
		if(n!=null){
			i=Integer.parseInt(n);
		}else{
			i=1;//第一页
		}
		//每一页存多少数据
		int j=(i-1)*2;
		Gson g=new Gson();
		
		List<MaterialsList> maList=mlm.getPage(j);
			
		return g.toJson(maList);
	}


}
