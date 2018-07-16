package com.erp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.mapper.EmployeeMapper;
import com.erp.mapper.MaterialPurchaseMapper;
import com.erp.mapper.MaterialsListMapper;
import com.erp.model.Employee;
import com.erp.model.MaterialPurchase;
import com.erp.model.MaterialsList;
import com.erp.service.purchaseService;
import com.framework.others.MaterialPurchaseList;
import com.framework.utils.pageUtil.PageBeanUtil;
import com.framework.utils.pageUtil.PagedResult;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;

@Service
public class purchaseServiceImpl implements purchaseService {
	@Resource
	private MaterialPurchaseMapper mpm;
	@Autowired
	private EmployeeMapper em;
	@Autowired
	private MaterialsListMapper mlm;

	public void addPurchaseListToDB(MaterialPurchase materialPurchase) {
		mpm.insertSelective(materialPurchase);
	}

	public List<MaterialPurchase> queryMaterialPurchaseListByTrackingNumAndEmeId(
			HttpServletRequest request) {
		
		String trackingNumber=request.getParameter("trackingNumber");
		
		String emeName=request.getParameter("emeName");
		Map map=new HashMap();
		
		if(trackingNumber!=null&&trackingNumber.length()>0){
			map.put("trackingNumber", trackingNumber);
		}
		
	
		if(emeName!=null&&emeName.length()>0){
			Employee ey=em.queryEmployeeByEmeName(emeName);
			String emeId=ey.getEmeId();
			map.put("emeId", emeId);
		}
		List<MaterialPurchase> mrpList=mpm.queryMPLByTnumAndEmeId(map);
	
		//通过员工姓名取出其ID
		return mrpList;
	}

	public List<MaterialPurchase> queryAllMaterials() {
		return mpm.queryAllMaterials();
	}

	public String getPage(String n, HttpSession session) {
		List<MaterialPurchaseList> mplList=new ArrayList<MaterialPurchaseList>();
		
		int i=0;
		if(n!=null){
			i=Integer.parseInt(n);
		}else{
			i=1;
		}
		int j=(i-1)*10;
		List<MaterialPurchase> pageList=mpm.getPageByTen(j);
		System.out.println("=======长度为："+pageList.size());
		for (MaterialPurchase mp : pageList) {
			
			MaterialsList ml=mlm.queryMaterialNameById(mp.getMaterialId());
			String emeid=(String) session.getAttribute("USERID");
			Employee e=em.selectByPrimaryKey(emeid);
			
			MaterialPurchaseList mpl=new MaterialPurchaseList();
			mpl.setEmeName(e.getEmeName());
			mpl.setMaterialId(mp.getMaterialId());
			mpl.setMaterialName(ml.getMaterialName());
			mpl.setMaterialNum(mp.getMaterialNum());
			mpl.setOpinion(mp.getOpinion());
			mpl.setPurchasePrice(mp.getPurchasePrice());
			mpl.setPurchaseTime(mp.getPurchaseTime());
			mpl.setTrackingNumber(mp.getTrackingNumber());
			mplList.add(mpl);
		}
			Gson g=new Gson();
			
			
			
		return g.toJson(mplList);
	}

	public List<MaterialPurchase> queryMaterialPurchase() {
		// TODO Auto-generated method stub
		return mpm.queryAllMaterials();
	}
	public PagedResult<MaterialPurchase> getAllByPage3(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<MaterialPurchase> glist = mpm.queryAllMaterials();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(glist);
	}
}
