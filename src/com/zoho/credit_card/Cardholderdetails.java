package com.zoho.credit_card;

public class Cardholderdetails {
	private String username;
	private String email;
	private long mobile;
	private long income;

	public Cardholderdetails(String username,String email,long mobile,long income) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.income = income;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}
