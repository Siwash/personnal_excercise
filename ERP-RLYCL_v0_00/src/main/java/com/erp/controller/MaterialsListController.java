package com.erp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.model.MaterialsList;
import com.erp.service.MaterialsListService;

@Controller
@RequestMapping("MaterialsListController")
public class MaterialsListController {
	@Autowired
	private MaterialsListService mls;
	
	@RequestMapping("listMaterials.do")
	public String listMaterials(HttpServletRequest request,Model model){
		List<MaterialsList> mlList=mls.queryAllMaterials();
		model.addAttribute("mlList",mlList);
		return "view/materialsList/materialsList-list";
	}
}
