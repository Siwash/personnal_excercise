package com.erp.model;

import java.util.Date;

public class MaterialsRecordList {
    private String recordlistId;

    private String materialId;

    private String materialNum;

    private Date recordTime;

    private String materialType;

    public String getRecordlistId() {
        return recordlistId;
    }

    public void setRecordlistId(String recordlistId) {
        this.recordlistId = recordlistId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(String materialNum) {
        this.materialNum = materialNum;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
}