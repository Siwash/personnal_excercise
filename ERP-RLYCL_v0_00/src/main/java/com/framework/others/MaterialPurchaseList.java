package com.framework.others;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MaterialPurchaseList {
	private String trackingNumber;
	private String materialId;
	private String purchasePrice;

    private String materialNum;

    private Date purchaseTime;
    
    private String purchaseTimeString;

    public String getPurchaseTimeString() {

		return purchaseTimeString;
	}

	public void setPurchaseTimeString(String purchaseTimeString) {

		
		this.purchaseTimeString =purchaseTimeString;
	}

	private String opinion;
    
    private String materialName;
    
    private String emeName;

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.purchaseTimeString = sdf.format(purchaseTime);
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getEmeName() {
		return emeName;
	}

	public void setEmeName(String emeName) {
		this.emeName = emeName;
	}
}
