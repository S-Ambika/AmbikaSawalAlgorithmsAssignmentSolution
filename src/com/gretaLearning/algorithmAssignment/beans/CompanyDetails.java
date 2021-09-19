package com.gretaLearning.algorithmAssignment.beans;

public class CompanyDetails {

	private String name;
	private double stock_price;
	private boolean rise_in_stock_price;
	
	public CompanyDetails(String name, double stock_price, boolean rise_in_stock_price) {
		super();
		this.name = name;
		this.stock_price = stock_price;
		this.rise_in_stock_price = rise_in_stock_price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getStock_price() {
		return stock_price;
	}
	public void setStock_price(double stock_price) {
		this.stock_price = stock_price;
	}
	public boolean isRise_in_stock_price() {
		return rise_in_stock_price;
	}
	public void setRise_in_stock_price(boolean rise_in_stock_price) {
		this.rise_in_stock_price = rise_in_stock_price;
	}
	
	
}
