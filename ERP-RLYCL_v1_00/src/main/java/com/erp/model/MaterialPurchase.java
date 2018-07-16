package com.erp.model;

import java.util.Date;

public class MaterialPurchase {
    private String materialPurchaseId;

    private String materialId;

    private String emeId;

    private String trackingNumber;

    private String purchasePrice;

    private String materialNum;

    private Date purchaseTime;

    private String opinion;

    public String getMaterialPurchaseId() {
        return materialPurchaseId;
    }

    public void setMaterialPurchaseId(String materialPurchaseId) {
        this.materialPurchaseId = materialPurchaseId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getEmeId() {
        return emeId;
    }

    public void setEmeId(String emeId) {
        this.emeId = emeId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(String materialNum) {
        this.materialNum = materialNum;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}