package com.shopable.model;

public class ProductInformation {

	private String productid;
	private String productname;
	private int price;
	private int availstock;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAvailstock() {
		return availstock;
	}
	public void setAvailstock(int availstock) {
		this.availstock = availstock;
	}
	@Override
	public String toString() {
		return "ProductInformation [productid=" + productid + ", productname=" + productname + ", price=" + price
				+ ", availstock=" + availstock + "]";
	}
	
}
