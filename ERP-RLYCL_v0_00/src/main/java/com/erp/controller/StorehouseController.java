package com.erp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.erp.model.MaterialPurchase;
import com.erp.model.MaterialsInventoryList;
import com.erp.model.MaterialsList;
import com.erp.model.MaterialsRecordList;
import com.erp.model.Product;
import com.erp.model.ProductInventory;
import com.erp.model.ProductTurnover;
import com.erp.service.ProductService;
import com.erp.service.StorehouseService;
import com.framework.controller.BaseController;
import com.framework.utils.PrimaryKeyUtil;
import com.framework.utils.pageUtil.PagedResult;

@Controller
@RequestMapping("/StorehouseController")
public class StorehouseController extends BaseController {

	/**  */
	private static final long serialVersionUID = 5993390908844728110L;

//	@RequestMapping("/queryProduct.do")
//	public String queryProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session,
//			Model model) {
//
//		List<Product> productList = productService.queryProduct();
//
//		List<ProductInventory> productInventoryList = storehouseService.queryProductInventory();
//
//
//		model.addAttribute("productList", productList);
//		model.addAttribute("productInventoryList", productInventoryList);
//
//		return "view/product/queryProduct";
//	}

	@RequestMapping("/querySomeProduct.ajax")
	@ResponseBody
	public String querySomeProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		System.out.println("我进了");
		String id = request.getParameter("productId");
		
		System.err.println("000"+id);
		
		System.err.println("111"+storehouseService.querySomeProduct(id));

		return storehouseService.querySomeProduct(id);
	}
//	
//	@RequestMapping("/queryMaterials.do")
//	public String queryMaterials(HttpServletRequest request, HttpServletResponse response, HttpSession session,
//			Model model) {
//
//		List<MaterialsList> materialsList = storehouseService.queryMaterials();
//		List<MaterialsInventoryList> materialsInventoryList=storehouseService.queryMaterialsInventory();
//
//		
//
//
//		model.addAttribute("materialsList", materialsList);
//		model.addAttribute("materialsInventoryList", materialsInventoryList);
//		
//
//		return "view/materials/queryMaterials";
//	}
	

	@RequestMapping("/querySomeMaterials.ajax")
	@ResponseBody
	public String querySomeMaterials(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		System.out.println("我进了");
		String id = request.getParameter("materialId");
		
		System.err.println("000"+id);
		
		System.err.println("111"+storehouseService.querySomeProduct(id));

		return storehouseService.querySomeMaterials(id);
	}
	

	@RequestMapping("/addProduct.do")

	public String addProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model,Product product,ProductInventory productInventory) {
		product.setProductId(PrimaryKeyUtil.getPrimaryKey());
		productInventory.setpInventoryId(PrimaryKeyUtil.getPrimaryKey());
		productInventory.setProductId(product.getProductId());
		System.out.println(product);
		int n = storehouseService.addProduct(product);
		int m =storehouseService.addProductInventory(productInventory);
		

		return "redirect:/StorehouseController/listByProductPage.do";
	}
	
//	@RequestMapping("/queryProductTurnover.do")
//
//	public String queryProductTurnover(HttpServletRequest request, HttpServletResponse response, HttpSession session,
//			Model model) {
//		
//		List<ProductTurnover> productTurnoverList=productService.queryProductTurnover();
//		
//		model.addAttribute("productTurnoverList", productTurnoverList);
//		
//		
//
//		return "view/product/queryProductTurnover";
//	}
//	
	@RequestMapping("/queryMaterialsRecordList.do")

	public String queryMaterialsRecordList(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		
		List<MaterialsRecordList> MaterialsRecordList=productService.queryMaterialsRecordList();
		
		model.addAttribute("MaterialsRecordList", MaterialsRecordList);
		
		

		return "view/materials/queryMaterialsRecordList";
	}
	
	
	@RequestMapping("/queryMaterialPurchase.do")

	public String queryMaterialPurchase(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		
		List<MaterialPurchase> materialPurchaseList=purchaseService.queryMaterialPurchase();
		
		model.addAttribute("materialPurchaseList", materialPurchaseList);
		
		

		return "view/materials/materialPurchase";
	}
	

	@RequestMapping("/queryLossManagement.do")

	public String queryLossManagement(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		
		List<Product> productList = productService.queryProduct();
		List<MaterialsList> materialsList = storehouseService.queryMaterials();
		
		model.addAttribute("materialsList", materialsList);
		model.addAttribute("productList", productList);
		
		int i=productList.size();
		int j=materialsList.size();
		int p=i+j;
		model.addAttribute("p", p);
		

		return "view/Loss/lossManagement";
	}
	
	@RequestMapping("/queryPurchaseRequisition.do")

	public String queryPurchaseRequisition(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		
		
		
		List<MaterialsList> materialsList = storehouseService.queryMaterials();
		
		model.addAttribute("materialsList", materialsList);
		
		
	

	

	
		 return "view/purchase/purchaseRequisition";
		
	}
	

	

	@RequestMapping("/purchaseRequisition.do")

	public String purchaseRequisition(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, MaterialPurchase purchaseRequisition) {
		
		purchaseRequisition.setMaterialPurchaseId(PrimaryKeyUtil.getPrimaryKey());
		
		int p = storehouseService.purchaseRequisition(purchaseRequisition);
		if (p > 0 ) {
			model.addAttribute("requisitionSuccess", "采购申请发起成功");
			return "welcome";
		} else {
			
			model.addAttribute("requisitionError", "采购申请失败，请重试");
			return "view/purchase/purchaseRequisition";

		}
		

	
	
	

	

	
	}
	

	@RequestMapping("/deleteProduct.ajax")
	@ResponseBody

	public String deleteProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model,String productId) {
		
		System.out.println(productId);
		System.out.println("111");
		
		int m=storehouseService.deleteProduct(productId);
		int n =storehouseService.deleteProductInventory(productId);
		
		
		
		
		
		
		
		

		return "";
	}
	

	@RequestMapping("/deleteMaterialsList.ajax")
	@ResponseBody

	public String deleteMaterialsList(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model,String materialId) {
		
		System.out.println(materialId);
		System.out.println("111");
		
		int m=storehouseService.deleteMaterialsList(materialId);
		int n =storehouseService.deleteMaterialsInventoryList(materialId);
		
		
		
		
		
		
		
		

		return "";
	}
	
	
	@RequestMapping("/updateUI.do")

	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model,String productId) {
		
		System.out.println(productId);
		

	     Product product = storehouseService.queryOneProduct(productId);

	     ProductInventory productInventory = storehouseService.queryOneProductInventory(productId);
	     
	     model.addAttribute("product", product);
	     model.addAttribute("productInventory", productInventory);

		
		
	
			
		

		return "view/product/updateProduct";
	}
	
	@RequestMapping("/updateProduct.do")

	public String updateProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model,Product product,ProductInventory productInventory) {
		
		System.out.println(product);
		
		
		

	     int o= storehouseService.updateOneProduct(product);

	     int k = storehouseService.updateOneProductInventory(productInventory);
	     
	     
	     if (o > 0 || k > 0) {
				model.addAttribute("updateSuccess", "修改成功");
				return "redirect:/StorehouseController/listByProductPage.do";
			} else {
				
				model.addAttribute("updateError", "修改失败，请重试");
				return "view/product/updateProduct";

			}
	     
	

		
		
	
			
		

		
	}

	@RequestMapping("/updateMaterialsList.do")

	public String updateMaterialsList(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model,MaterialsList materialsList,MaterialsInventoryList materialsInventoryList) {
		
		System.out.println(666666);
		

	     int o= storehouseService.updateOneMaterialsList(materialsList);

	     int k = storehouseService.updateOneMaterialsInventoryList(materialsInventoryList);
	     
	 
	     
	     
	     if (o > 0 || k > 0) {
				model.addAttribute("updateSuccess", "修改成功");
				return "redirect:/StorehouseController/listByqueryMaterialsPage.do";
			} else {
				
				model.addAttribute("updateError", "修改失败，请重试");
				return "view/materials/updateMaterialsList";

			}
	     
		
	
			
		

	}
	@RequestMapping("/updateMaterialsListUI.do")

	public String updateMaterialsListUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model,String materialId) {
		
		System.out.println(materialId);
		

		MaterialsList materialsList = storehouseService.queryOneMaterialsList(materialId);

		MaterialsInventoryList materialsInventoryList = storehouseService.queryOneMaterialsInventoryList(materialId);
	     
	     model.addAttribute("materialsList", materialsList);
	     model.addAttribute("materialsInventoryList", materialsInventoryList);

		
		
	
			
		

		return "view/materials/updateMaterialsList";
	}
	
	
	
	

	@RequestMapping(value = "listByProductPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listByProductPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
		
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<Product> pageResult = productService.getAllByPage(pageNumber, pageSize);
		List<ProductInventory> productInventoryList = storehouseService.queryProductInventory();
		List<Product> productList = productService.queryProduct();
		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.addObject("productInventoryList", productInventoryList);
		mv.addObject("productList", productList);
		
		mv.setViewName("view/product/queryProduct");
		return mv;

	}
	
	
	@RequestMapping(value = "listByqueryMaterialsPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listByqueryMaterialsPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
		
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<MaterialsList> pageResult = storehouseService.getAllByPage(pageNumber, pageSize);

		List<MaterialsList> materialsList = storehouseService.queryMaterials();
		List<MaterialsInventoryList> materialsInventoryList=storehouseService.queryMaterialsInventory();

		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.addObject("materialsList", materialsList);
		mv.addObject("materialsInventoryList", materialsInventoryList);
		
		mv.setViewName("view/materials/queryMaterials");
		return mv;

	}
	
	@RequestMapping(value = "listByqueryProductTurnoverPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listByqueryProductTurnoverPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
		
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<ProductTurnover> pageResult = storehouseService.getAllByPage1(pageNumber, pageSize);


		List<ProductTurnover> productTurnoverList=productService.queryProductTurnover();

		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.addObject("productTurnoverList", productTurnoverList);
	
		
		mv.setViewName("view/product/queryProductTurnover");
		return mv;

	}
	
	@RequestMapping(value = "listByqueryMaterialsRecordListPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listByqueryMaterialsRecordListPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
		
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<MaterialsRecordList> pageResult = productService.getAllByPage2(pageNumber, pageSize);


		List<MaterialsRecordList> MaterialsRecordList=productService.queryMaterialsRecordList();

		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.addObject("MaterialsRecordList", MaterialsRecordList);
	
		
		mv.setViewName("view/materials/queryMaterialsRecordList");
		return mv;

	}
	

	@RequestMapping(value = "listByqueryMaterialPurchasePage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listByqueryMaterialPurchasePage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
		
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<MaterialPurchase> pageResult = purchaseService.getAllByPage3(pageNumber, pageSize);


		List<MaterialPurchase> materialPurchaseList=purchaseService.queryMaterialPurchase();

		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.addObject("materialPurchaseList", materialPurchaseList);
	
		
		mv.setViewName("view/materials/materialPurchase");
		return mv;

	}
	
	@RequestMapping(value = "listByqueryLossManagementPage.do", produces = "application/json;charset=utf-8")
	public ModelAndView listByqueryLossManagementPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
		
		ModelAndView mv = new ModelAndView();
		// 当前页和每页的条数
		// 传入数据到分页工具类
		PagedResult<Product> pageResult = productService.getAllByPage(pageNumber, pageSize);
		PagedResult<MaterialsList> pageResult2 = storehouseService.getAllByPage(pageNumber, pageSize);


		
		List<Product> productList = productService.queryProduct();
		List<MaterialsList> materialsList = storehouseService.queryMaterials();
		
		
		
		int i=productList.size();
		int j=materialsList.size();
		int p=i+j;
		

		// 数据传递到前台页面展示层
		mv.addObject("pageResult", pageResult);
		mv.addObject("pageResult2", pageResult2);
		mv.addObject("p", p);
	
		
		mv.setViewName("view/Loss/lossManagement");
		return mv;

	}
	

	@RequestMapping("/addMaterials.do")

	public String addMaterials(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model,MaterialsList materialsList,MaterialsInventoryList materialsInventoryList) {
		materialsList.setMaterialId(PrimaryKeyUtil.getPrimaryKey());
		
		materialsInventoryList.setmInventoryId(PrimaryKeyUtil.getPrimaryKey());
		materialsInventoryList.setMaterialId(materialsList.getMaterialId());
		
		int n = storehouseService.addMaterialsList(materialsList);
		int m =storehouseService.addMaterialsInventoryList(materialsInventoryList);
		

		return "redirect:/StorehouseController/listByqueryMaterialsPage.do";
	}



@RequestMapping("/updateProductLossUI.do")

public String updateProductLossUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
		Model model,String productId,String materialId) {
	
	System.out.println(productId);
	

	Product product = storehouseService.queryOneProduct(productId);

	
     
     model.addAttribute("product", product);
    
	return "view/Loss/updateProductLossUI";
     
}


@RequestMapping("/updateMaterialsListLossUI.do")

public String updateMaterialsListLossUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
		Model model,String productId,String materialId) {
	
	System.out.println(materialId);
	

	MaterialsList materialsList = storehouseService.queryOneMaterialsList(materialId);

	
     
     model.addAttribute("materialsList", materialsList);
    
	return "view/Loss/updateMaterialsListLossUI";
     
}


@RequestMapping("/updateProductLoss.do")

public String updateProductLoss(HttpServletRequest request, HttpServletResponse response, HttpSession session,
		Model model,Product product) {
	
	
	

	 int o= storehouseService.updateOneProduct(product);

	if (o > 0){
		
		return "redirect:/StorehouseController/queryLossManagement.do";
		
	}else{
		
		return  "view/Loss/updateProductLossUI";
	}
     
    
    
	
     
}

@RequestMapping("/updateMaterialsListLoss.do")

public String updateMaterialsListLoss(HttpServletRequest request, HttpServletResponse response, HttpSession session,
		Model model,MaterialsList materialsList) {
	
	 int o= storehouseService.updateOneMaterialsList(materialsList);
	
	 if (o > 0){
			
			return "redirect:/StorehouseController/queryLossManagement.do";
			
		}else{
			
			return  "view/Loss/updateMaterialsListLossUI";
		}
	     
	

	
     
    
    
	
     
}

}
     


