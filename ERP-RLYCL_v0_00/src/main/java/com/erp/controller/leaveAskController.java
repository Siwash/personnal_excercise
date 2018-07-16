package com.erp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.model.LeaveAsk;
import com.erp.service.leaveAskService;
import com.google.gson.Gson;

@Controller
@RequestMapping("leaveAskController")
public class leaveAskController {

	@Resource
	private leaveAskService las;
	
	// 查询到 opinion字段为未审批的请假数据
	@RequestMapping("listLeave.do")
	public String listLeave(HttpServletRequest request,Model model){
		List<LeaveAsk> leaveList=las.queryAllAskLeave();
		model.addAttribute("leaveList", leaveList);
		request.setAttribute("LEAVENUM", leaveList.size());
		return "view/askforleave/askleave_list";
	}
	
	//同意请假
	@RequestMapping("agreeLeave.ajax")
	@ResponseBody
	public String agreeLeave(HttpServletRequest request){
		String leaveId=request.getParameter("leaveId");
		System.out.println(leaveId);
		LeaveAsk la=las.queryLeaveByLeaveId(leaveId);
		la.setOpinion("已同意");
		int n=las.updateLeaveByLa(la);
		return "";
	}
	
	//不同意
	@RequestMapping("refuseLeave.ajax")
	@ResponseBody
	public String refuseLeave(HttpServletRequest request){
		String leaveId=request.getParameter("leaveId");
		System.out.println(leaveId);
		LeaveAsk la=las.queryLeaveByLeaveId(leaveId);
		la.setOpinion("不同意");
		int n=las.updateLeaveByLa(la);
		return "";
	}
	
	//根据opinion检索数据
	@RequestMapping(value="queryOpinion.ajax",produces="text/html;charset=utf-8")
	@ResponseBody
	public String queryOpinion(HttpServletRequest request,Model model){
		String opinion=request.getParameter("opinion");
		List<LeaveAsk> laList=las.queryLeaveByOpinion(opinion);
		Gson g=new Gson();
		return g.toJson(laList);
	}
}
