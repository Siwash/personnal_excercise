package com.erp.model;

import java.util.List;

import com.google.gson.Gson;

public class PageModel {
	private String total;
	private List<?> data;
	private  static Gson gson=new Gson();
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<?> getList() {
		return data;
	}
	public void setList(List<?> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "PageModel [total=" + total + ", data=" + data + "]";
	}
	public static String getJson(PageModel pageModel) {
		
		return gson.toJson(pageModel);
	}
	public PageModel(String total,List<?> data) {
		super();
		this.total = total;
		this.data = data;
	}
	public PageModel() {
		super();
	}
	
}
