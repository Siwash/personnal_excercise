package com.erp.model;

public class ProductInventory {
    private String pInventoryId;

    private String productId;

    private String inventoryNumber;

    private String outboundStatus;

    public String getpInventoryId() {
        return pInventoryId;
    }

    public void setpInventoryId(String pInventoryId) {
        this.pInventoryId = pInventoryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getOutboundStatus() {
        return outboundStatus;
    }

    public void setOutboundStatus(String outboundStatus) {
        this.outboundStatus = outboundStatus;
    }
}