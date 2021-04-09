package com.shopable.model;


public class UserProduct {

	private String productid;
	private String productname;
	private int quantity;
	private int batchtotal;
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBatchtotal() {
		return batchtotal;
	}
	public void setBatchtotal(int batchtotal) {
		this.batchtotal = batchtotal;
	}
	
}
