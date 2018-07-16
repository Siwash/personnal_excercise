package com.erp.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.erp.mapper.LeaveAskMapper;
import com.erp.mapper.WorkRecordListMapper;
import com.erp.model.LeaveAsk;
import com.erp.model.PageModel;
import com.erp.model.WorkRecordList;
import com.erp.service.SelfService;
@Service
public class SelfServiceImpl implements SelfService {

	@Resource
	WorkRecordListMapper WRLM;
	@Resource
	LeaveAskMapper LAM;
	public String getRecoderPage(HttpServletRequest request,boolean b,String pageIndex) {
		String n="-1";
		String userId=(String) request.getSession().getAttribute("USERID");
		if (b) {
			n=WRLM.totalRecoders(userId);
		}
		int index=1;
		if (pageIndex!=null) {
			index=Integer.parseInt(pageIndex)>0? Integer.parseInt(pageIndex):1;
		}
		int m=(index-1)*10;
		List<WorkRecordList> list=WRLM.getRecoderPageDate(m,userId);
		PageModel p=new PageModel(n,list);
		
		return PageModel.getJson(p);
	}
	public String doRecoder(HttpServletRequest request, WorkRecordList record) {
		String result="failed";
		if (record!=null&&record.getContent()!=null) {
			record.setEmeId((String) request.getSession().getAttribute("USERID"));
			record.setRecordListId(UUID.randomUUID().toString());
			record.setRecordTime(new Date());
			int i= WRLM.insert(record);
			result=i>0? "success":result;
		}
		return result;
	}
	public String readRecoder(HttpServletRequest request, String recordId) {
		WorkRecordList recordList= WRLM.selectByPrimaryKey(recordId);
		request.setAttribute("record", recordList);
		return recordList==null? "erro":"success";
	}
	//ask for leave
	public String getLeavePage(HttpServletRequest request, boolean b, String pageIndex) {
		String n="-1";
		String userId=(String) request.getSession().getAttribute("USERID");
		if (b) {
			n=LAM.totalLeave(userId);
			System.out.println(n);
		}
		int index=1;
		if (pageIndex!=null) {
			index=Integer.parseInt(pageIndex)>0? Integer.parseInt(pageIndex):1;
		}
		int m=(index-1)*10;
		List<LeaveAsk> list=LAM.getLeavePageDate(m,userId);
		PageModel p=new PageModel(n,list);
		System.out.println(m+"--"+userId+list);
		return PageModel.getJson(p);
	}
	public String doLeave(HttpServletRequest request, LeaveAsk leave) {
		String result="failed";
		if (leave!=null&&leave.getLeaveReason()!=null) {
			leave.setEmeId((String) request.getSession().getAttribute("USERID"));
			leave.setLeaveId(UUID.randomUUID().toString());
			leave.setOpinion("审批中");
			int i= LAM.insert(leave);
			result=i>0? "success":result;
		}
		return result;
	}
	public String readLeave(HttpServletRequest request, String leaveId) {
		LeaveAsk leave= LAM.selectByPrimaryKey(leaveId);
		request.setAttribute("leave", leave);
		return leave==null? "erro":"success";
	}

}
