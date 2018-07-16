package com.erp.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LeaveAsk {
    private String leaveId;

    private String opinion;

    private String leaveReason;

    private String emeId;
    
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    private Date endingTime;

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getEmeId() {
        return emeId;
    }

    public void setEmeId(String emeId) {
        this.emeId = emeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }

	@Override
	public String toString() {
		return "LeaveAsk [leaveId=" + leaveId + ", opinion=" + opinion + ", leaveReason=" + leaveReason + ", emeId="
				+ emeId + ", startTime=" + startTime + ", endingTime=" + endingTime + "]";
	}
    
}