package com.erp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.model.MaterialsInventoryList;
import com.erp.model.MaterialsList;
import com.erp.service.MaterialsInventoryListService;
import com.erp.service.MaterialsListService;
import com.framework.others.MaterialNameByMaterialId;

@Controller
@RequestMapping("MaterialsInventoryListController")
public class MaterialsInventoryListController {
	@Autowired
	private MaterialsInventoryListService mils;
	
	@Autowired
	private MaterialsListService mls;
	
	/**
	 * 
	 * @return
	 */
	
	//查询当前材料库存的数据
	@RequestMapping("/listMaterialInventory.do")
	public String listMaterialInventory(Model model,HttpServletRequest re){
		
		List<MaterialsInventoryList> materList=mils.queryAllMaterialsInventory();
		model.addAttribute("materList", materList);
		
		ArrayList<MaterialsList> materialList=mls.queryAllMaterials();
		model.addAttribute("materialList", materialList);
		
		re.setAttribute("EACHNUM", materialList.size());
		return "view/materialInventory/materialsInventory_list";
	}
	
	//分页 初始化页面  每页两条数据
	@RequestMapping("initKKpager.do")
	public String initKKpager(HttpSession session){
		List<MaterialsInventoryList> materList=mils.queryAllMaterialsInventory();
		int i=materList.size();
		int j;
		if(i/2==0){
			j=i/2;
		}else{
			j=(i/2)+1;
		}
			session.setAttribute("totolDatas", i);
			session.setAttribute("totolPages", j);
		System.out.println("总数据条数："+i+"页码为："+j);
		return "view/materialInventory/materialsInventory_list";
	}
	
	//数据库分页 每页两条数据
	@RequestMapping(value="showPage.ajax",produces="text/html;charset=utf-8")
	@ResponseBody
	public String showPage(String n){
		String thisPage=mils.getPage(n);
		
		return thisPage;
	}
}
