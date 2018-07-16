package com.erp.model;

import java.util.Date;

public class LeaveModel {
	private String emeName;
	
    private String leaveId;

    private String opinion;

    private String leaveReason;

    private String emeId;

    private Date startTime;

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
		return "LeaveModel [emeName=" + emeName + ", leaveId=" + leaveId + ", opinion=" + opinion + ", leaveReason="
				+ leaveReason + ", emeId=" + emeId + ", startTime=" + startTime + ", endingTime=" + endingTime + "]";
	}

	public String getEmeName() {
		return emeName;
	}

	public void setEmeName(String emeName) {
		this.emeName = emeName;
	}
	
    
}