package com.erp.service;

import javax.servlet.http.HttpServletRequest;

import com.erp.model.LeaveAsk;
import com.erp.model.WorkRecordList;

public interface SelfService {

	String getRecoderPage(HttpServletRequest request, boolean b, String pageIndex);

	String doRecoder(HttpServletRequest request, WorkRecordList record);

	String readRecoder(HttpServletRequest request, String recordId);

	String getLeavePage(HttpServletRequest request, boolean firstPage, String pageIndex);

	String doLeave(HttpServletRequest request, LeaveAsk leave);

	String readLeave(HttpServletRequest request, String leaveId);

}
