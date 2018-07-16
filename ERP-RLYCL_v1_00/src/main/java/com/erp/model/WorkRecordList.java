package com.erp.model;

import java.util.Date;

public class WorkRecordList {
    private String recordListId;

    private String emeId;

    private String title;

    private Date recordTime;

    private String recordType;

    private String content;

    public String getRecordListId() {
        return recordListId;
    }

    public void setRecordListId(String recordListId) {
        this.recordListId = recordListId;
    }

    public String getEmeId() {
        return emeId;
    }

    public void setEmeId(String emeId) {
        this.emeId = emeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}