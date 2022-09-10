package com.zoho.credit_card;

public class Carddetails {
	private long card_number;
	private int type_id;
	private int user_id;
	public String getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	private String expire_date;
	private int cvv;

	public Carddetails(long card_number,int type_id,int user_id,int cvv,String expire_date) {
		// TODO Auto-generated constructor stub
		this.card_number = card_number;
		this.type_id = type_id;
		this.user_id = user_id;
		this.cvv = cvv;
		this.expire_date = expire_date;
	}

	public long getCard_number() {
		return card_number;
	}

	public void setCard_number(long card_number) {
		this.card_number = card_number;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}


