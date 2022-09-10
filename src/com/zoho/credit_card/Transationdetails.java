package com.zoho.credit_card;

public class Transationdetails {
	private long card_number;
	private String description;
	private long debit_amount;
	private int day;
	private int month;
	private int year;
	private long balance;



	public Transationdetails(long card_number2, String description2, long debit_amount2, long balance,int day,int Month,int year) {
		this.card_number = card_number2;
		this.description = description2;
		this.debit_amount = debit_amount2;
		this.setBalance(balance);
		this.day = day;
		this.month = Month;
		this.year = year;
	}

	public long getCard_number() {
		return card_number;
	}

	public void setCard_number(long card_number) {
		this.card_number = card_number;
	}



	public long getDebit_amount() {
		return debit_amount;
	}

	public void setDebit_amount(long debit_amount) {
		this.debit_amount = debit_amount;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

}
