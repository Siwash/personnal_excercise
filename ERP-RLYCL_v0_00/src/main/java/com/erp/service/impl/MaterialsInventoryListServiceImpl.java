package com.erp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.mapper.MaterialsInventoryListMapper;
import com.erp.mapper.MaterialsListMapper;
import com.erp.mapper.MaterialsRecordListMapper;
import com.erp.model.MaterialsInventoryList;
import com.erp.model.MaterialsList;
import com.erp.service.MaterialsInventoryListService;
import com.framework.others.MaterialNameByMaterialId;
import com.google.gson.Gson;

@Service
public class MaterialsInventoryListServiceImpl implements MaterialsInventoryListService {
	
	@Autowired
	private MaterialsInventoryListMapper milp;
	
	@Autowired
	private MaterialsListMapper mlm;

	public List<MaterialsInventoryList> queryAllMaterialsInventory() {
		return milp.queryAllMaterialsInventory();
	}

	public int deleteMaterialInventoryByMaterialId(String materialId) {
		return milp.deleteMaterialInventoryByMaterialId(materialId);
	}

	public int addMaterialInventoryByMaterinl(MaterialsInventoryList materinl) {
		return milp.insertSelective(materinl);
	}

	public MaterialsInventoryList queryMaterialsInventoryByMaterialId(String materialId) {
		return milp.queryMaterialsInventoryByMaterialId(materialId);
	}

	public String getPage(String n) {
		int i=0;//定义一个整型变量为0
		if(n!=null){
			i=Integer.parseInt(n);//将String转化为整型，并赋给i
		}else{
			i=1;//如果String为空，默认为第一页，所以给i赋值为1
		}
		//每一页存10个数据
		i=(i-1)*2;//此处的
		Gson g=new Gson();
		
		List<MaterialNameByMaterialId> mnList=new ArrayList<MaterialNameByMaterialId>();
		
		List<MaterialsInventoryList> miList=milp.getStuByPage(i);
		
		for (MaterialsInventoryList mil : miList) {
			MaterialsList m=mlm.queryMaterialNameById(mil.getMaterialId());
			
			
			MaterialNameByMaterialId mn=new MaterialNameByMaterialId();
			mn.setMaterialId(mil.getMaterialId());
			mn.setMaterialName(m.getMaterialName());
			mn.setmInventoryId(mil.getmInventoryId());
			mn.setRepertoryNum(mil.getRepertoryNum());
			mn.setStatus(mil.getStatus());
			mnList.add(mn);
		}
		
		return g.toJson(mnList);
	}
}
