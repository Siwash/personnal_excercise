package com.framework.others;

public class MaterialNameByMaterialId {
	
	private String mInventoryId;
	private String materialId;
	private String materialName;
	 private String repertoryNum;

	    private String status;
	
	public String getmInventoryId() {
			return mInventoryId;
		}
		public void setmInventoryId(String mInventoryId) {
			this.mInventoryId = mInventoryId;
		}
		public String getRepertoryNum() {
			return repertoryNum;
		}
		public void setRepertoryNum(String repertoryNum) {
			this.repertoryNum = repertoryNum;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

}
