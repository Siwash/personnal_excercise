package com.erp.model;

import java.util.Date;

public class ProductTurnover {
    private String productTurnoverId;

    private String productId;

    private String productNumber;

    private Date inventoryTime;

    private String emeId;

    private String type;

    public String getProductTurnoverId() {
        return productTurnoverId;
    }

    public void setProductTurnoverId(String productTurnoverId) {
        this.productTurnoverId = productTurnoverId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public Date getInventoryTime() {
        return inventoryTime;
    }

    public void setInventoryTime(Date inventoryTime) {
        this.inventoryTime = inventoryTime;
    }

    public String getEmeId() {
        return emeId;
    }

    public void setEmeId(String emeId) {
        this.emeId = emeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}