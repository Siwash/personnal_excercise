package com.erp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.model.Employee;
import com.erp.model.MaterialPurchase;
import com.erp.model.MaterialsInventoryList;
import com.erp.model.MaterialsList;
import com.erp.service.EmployeeService;
import com.erp.service.MaterialsInventoryListService;
import com.erp.service.MaterialsListService;
import com.erp.service.purchaseService;
import com.framework.others.PrimaryKeyUtil;
import com.framework.others.currentTime;
import com.google.gson.Gson;

/**
 * 采购表
 * @author liuy
 *
 */
@Controller
@RequestMapping("purchaseController")
public class purchaseController {
	@Resource
	private purchaseService  pcs;
	
	@Resource
	private MaterialsListService mls;
	
	@Resource
	private EmployeeService es;
	
	@Resource
	private MaterialsInventoryListService mils;
	
	/**
	 * 进采购管理，首先我们看到的是材料的清单
	 * @return
	 */
	@RequestMapping("/listMaterial.do")
	public String listMaterial(HttpServletRequest request,Model model){
		
		List<MaterialsList> mlList=mls.queryAllMaterials();
		model.addAttribute("mlList",mlList);
		request.setAttribute("materialsNum", mlList.size());
		return "view/purchaseMaterials/purchasematerials-list";
	}
	
	//根据查询条件查出材料
	@RequestMapping(value="/selectMaterialNameAndType.ajax",produces="text/html;charset=utf-8")
	@ResponseBody
	public String selectMaterialNameAndType(HttpServletRequest request){
		List<MaterialsList> mtlList=mls.getMaterialByNameAndType(request);
		Gson g=new Gson();
		return g.toJson(mtlList);
	}
	
	@RequestMapping("productPurchaseMaterialsList.do")
	public String productPurchaseMaterialsList(HttpServletRequest request,Model model
			,String materialId,MaterialPurchase materialPurchase,HttpSession session){
		//根据材料id取出材料信息
		MaterialsList material=mls.queryMaterialById(materialId);
		model.addAttribute("mr", material);
		//取出存在session中的员工id，找出员工
//		String id=(String) request.getSession().getAttribute("EmeID");
		Employee emoloyee=es.queryUserById(request);
		model.addAttribute("em", emoloyee);
		//将原料id设置到采购表
		materialPurchase.setMaterialId(materialId);
		model.addAttribute("mp", materialPurchase);
		return "view/purchaseMaterials/purchaseMaterial_add";
	}
	
	@RequestMapping("addPurchaseList.do")
	@Transactional(rollbackFor=Exception.class)
	public String addPurchaseList(HttpServletRequest request,Model model) {
		
		System.out.println("----------------222--------------");
		//创建一个材料采购表对象，将本次采购的数据从jsp页面或session中取出来，并存入采购表中
		MaterialPurchase materialPurchase =new MaterialPurchase();		
		String emeName=request.getParameter("emeName");
		String materialNum=request.getParameter("materialNum");
		String materialPrice=request.getParameter("materialPrice");
		String materialName=request.getParameter("materialName");
		String materialId=request.getParameter("materialId");
		String id=(String) request.getSession().getAttribute("EmeID");
		materialPurchase.setMaterialPurchaseId(PrimaryKeyUtil.getPrimaryKey());
		materialPurchase.setEmeId(id);
		materialPurchase.setMaterialId(materialId);
		int price=Integer.parseInt(materialPrice);
		int num=Integer.parseInt(materialNum);
		int sumPrice=price*num;
		String purchasePrice=""+sumPrice;
		materialPurchase.setPurchasePrice(purchasePrice);
		materialPurchase.setMaterialNum(materialNum);
		materialPurchase.setPurchaseTime(new Date());
		//以上都是获取数据并将数据存入表中
		
		//获得采购审批意见
		String shenpi=request.getParameter("item");
		
		//如果部门经理或老总同意采购
		if(shenpi!=null){
		if(shenpi.equals("1")|shenpi.equals("0")){
			//给此次采购获取一个快递编号，并设置采购意见到采购表中
			String trackingNum=request.getParameter("trackingNumber");
			materialPurchase.setTrackingNumber(trackingNum);
			materialPurchase.setOpinion("同意采购");
			//将采购表存入数据库
			pcs.addPurchaseListToDB(materialPurchase);
			
			//取出此种材料库存表的所有数据
			MaterialsInventoryList mateList=mils.queryMaterialsInventoryByMaterialId(materialId);
//			List<MaterialsInventoryList> miList=mils.queryAllMaterialsInventory();
			/**
			 * 如果在本次采购之前，材料库存表的数据不为空，当我们添加某种材料的数据到材料库存表里时，
			 * 我们首先判断库存表里的哪种材料与我本次采购的材料ID一致，在判断成功后，取出本种材料在库存表
			 * 里面的原有数量，在取出本次采购的数量，将两个数据相加成新的材料库存数量，并将这个值存入对象中
			 * ，根据当前的材料ID删除原来的库存表 本材料的数据，再将采购后的数据添加入库存中。
			 */
			if(mateList!=null){
					if(mateList.getMaterialId().equals(materialId)){
						int n=Integer.parseInt(mateList.getRepertoryNum());
						int k=Integer.parseInt(materialNum);
						int nk=n+k;
						String sum=""+nk;
						mateList.setRepertoryNum(sum);
						mateList.setStatus("入库");
						int i=mils.deleteMaterialInventoryByMaterialId(materialId);
						int j=mils.addMaterialInventoryByMaterinl(mateList);
					}
			}else{
				/**
				 * 如果当前材料库存表为空，我们直接将本次采购数据添加到库存中
				 */
				MaterialsInventoryList mainl =new MaterialsInventoryList();
				mainl.setMaterialId(materialId);
				mainl.setmInventoryId(PrimaryKeyUtil.getPrimaryKey());
				mainl.setRepertoryNum(materialNum);
				mainl.setStatus("入库");
				int kk=mils.addMaterialInventoryByMaterinl(mainl);
			}
			model.addAttribute("CAIGOURESULT", "采购成功");
			return "view/purchaseMaterials/purchasematerials-success";
		}else if(shenpi.equals("-1")){
			try {
				throw new Exception();
			} catch (Exception e) {
				model.addAttribute("CAIGOURESULT", "采购失败");
				return "view/purchaseMaterials/purchasematerials-success";
			}
		}
		}
		
		return "";
	}
	
	
	@RequestMapping("/listMaterialPurchase.do")
	public String listMaterialInventory(Model model,HttpServletRequest request){
		List<MaterialPurchase> miList=pcs.queryAllMaterials();		
		model.addAttribute("miList", miList);
		
		ArrayList<MaterialsList> materialList=mls.queryAllMaterials();
		model.addAttribute("materialList", materialList);
		
		String id=(String) request.getSession().getAttribute("EmeID");
		Employee e=es.queryUserById(request);
		model.addAttribute("e", e);
		request.setAttribute("EACHNUM", miList.size());
		return "view/purchaseMaterials/materialPurchaseList-list";
	}
	
	@RequestMapping("/query.do")
	public String queryMaterialPurchaseListByMaterialNameAndEmeName(HttpServletRequest
			request,Model model){
		
		
		List<MaterialPurchase> miList=pcs.queryMaterialPurchaseListByTrackingNumAndEmeId(request);
		model.addAttribute("miList", miList);
			request.setAttribute("EACHNUM", miList.size());
		
		ArrayList<MaterialsList> materialList=mls.queryAllMaterials();
		model.addAttribute("materialList", materialList);
		
		
		Employee e=es.queryUserById(request);
		model.addAttribute("e", e);
		return "view/purchaseMaterials/materialPurchaseList-search";
	}
	
	@RequestMapping("initKKpager.do")
	public String initKKpager(HttpSession session){
		List<MaterialsList> maList=mls.queryAllMaterials();
		int i=maList.size();
		int j;
		if(i/2==0){
			j=i/2;
		}else{
			j=(i/2)+1;
		}
			session.setAttribute("totolDatas", i);
			session.setAttribute("totolPages", j);
		System.out.println("总数据条数："+i+"页码为："+j);
		return "view/purchaseMaterials/purchasematerials-list";
	}
	
	@RequestMapping(value="showPage.ajax",produces="text/html;charset=utf-8")
	@ResponseBody
	public String showPage(String n){
		String myPage=mls.getPage(n);
		
		return myPage;
	}
	
	@RequestMapping("initKKpager1.do")
	public String initKKpager1(HttpSession session){
		List<MaterialPurchase> miList=pcs.queryAllMaterials();
		int i=miList.size();
		System.out.println("---数据为："+i);
		int j;
		if(i/10==0){
			j=i/10;
		}else{
			j=(i/10)+1;
		}
			session.setAttribute("TDATAS", i);
			session.setAttribute("TPAGES", j);
		System.out.println("总数据条数："+i+"页码为："+j);
		return "view/purchaseMaterials/materialPurchaseList-list";
	}
	
	@RequestMapping(value="showPage1.ajax",produces="text/html;charset=utf-8")
	@ResponseBody
	public String showPage1(String n,HttpSession session){
		String myPage=pcs.getPage(n,session);
		return myPage;
	}
}
