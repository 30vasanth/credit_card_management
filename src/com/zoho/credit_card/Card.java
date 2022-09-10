package com.zoho.credit_card;




import java.sql.SQLException;
import java.util.Scanner;

public class Card {
	Pgconnection pgc = null;
	
	Scanner sc = null;
	
	
	public void insertcard_details() throws SQLException {
		sc = new Scanner(System.in);
		pgc = new Pgconnection();
		System.out.println("Enter the card number : ");
		long card_number = sc.nextLong();
		System.out.println("Enter the type id : ");
		int type_id = sc.nextInt();
		System.out.println("Enter the user id : ");
		int user_id = sc.nextInt();
		System.out.println("Enter the user cvv : ");
		int cvv = sc.nextInt();
		System.out.println("Enter the user expire_date : ");
		String expire_date = sc.next();
		Carddetails cd = new Carddetails(card_number,type_id,user_id,cvv,expire_date);
		
		pgc.cardapprovalrequest(cd);
		

	}

	public void getCard_details() throws SQLException {
		sc = new Scanner(System.in);
		System.out.println("Enter the your card_number");
		Long id = sc.nextLong();
		
		pgc.carddetailsrequest(id);
		
	}
}
