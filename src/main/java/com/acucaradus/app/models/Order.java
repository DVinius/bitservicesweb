package com.acucaradus.app.models;

import java.util.Calendar;

public class Order {
	private String code;
	private String customerName;
	private String customerPhone;
	private String address;
	private Calendar orderDate;
	private RollCake cake;
	private int amount;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Calendar getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}
	public RollCake getCake() {
		return cake;
	}
	public void setCake(RollCake cake) {
		this.cake = cake;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getTotal(){
		return "calculate total";
	}
	
}
