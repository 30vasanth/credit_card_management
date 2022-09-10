package com.zoho.credit_card;



import java.sql.SQLException;
import java.util.Scanner;

public class Billingprocess {

	
	
	Scanner sc = null;
	Pgconnection pgc = null;
	public void insertcardbilling() throws SQLException {
		sc = new Scanner(System.in);	
		pgc = new Pgconnection();
		System.out.println("Enter the card name : ");
		long card_number = sc.nextLong();
		System.out.println("Enter the billing_date : ");
		String billing_date = sc.next();
		System.out.println("Enter the due_date : ");
		String duedate = sc.next();
		
		pgc.getLast_transation_details(card_number,billing_date);
		
		Cardmapping cm = new Cardmapping(billing_date,duedate,card_number);
		pgc.sendinsertcardbilling(cm);
		

	}
	
	public void get_the_bill() throws SQLException {
		sc = new Scanner(System.in);	
		pgc = new Pgconnection();
		long card_number2 = sc.nextLong();
		
		pgc.getthebilldatarequest(card_number2);
		
	}
}

