package com.zoho.credit_card;

public class Cardtype {
	private String card_name;
	private long range;

	public Cardtype(String name,long range) {
		this.card_name = name;
		this.range = range;
	}

	public String getCard_name() {
		return card_name;
	}

	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}

	public long getRange() {
		return range;
	}

	public void setRange(long range) {
		this.range = range;
	}
}
