package com.zoho.credit_card;

public class Cardmapping {

	private String billing_date;
	private String due_date;
	private long card_number;

	public Cardmapping(String billing_date,String due_date,long card_number) {
		// TODO Auto-generated constructor stub
		this.billing_date= billing_date;
		this.due_date = due_date;
		this.card_number = card_number;

	}

	public long getCard_number() {
		return card_number;
	}

	public void setCard_number(long card_number) {
		this.card_number = card_number;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getBilling_date() {
		return billing_date;
	}
	public void setBilling_date(String billing_date) {
		this.billing_date = billing_date;
	}

}
