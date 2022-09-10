package com.zoho.credit_card;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Typesofcard {
	
	String SQL = null;
	PreparedStatement pstmt =null;
	Scanner sc = null;
	Pgconnection pgc = null;
	public void insertcardtype()  {
		sc = new Scanner(System.in);
		System.out.println("Enter the card name : ");
		String card_name = sc.next();
		System.out.println("Enter the range : ");
		long range = sc.nextLong();
		pgc = new Pgconnection();
		Cardtype ct = new Cardtype(card_name,range);
		//Connection c = ;
		
		pgc.sendinsertcardtype(ct);
		

	}

	public void updatecardtype() throws SQLException {
		sc = new Scanner(System.in);
		System.out.println("Enter the card name : ");
		String card_name = sc.next();
		System.out.println("Enter the range : ");
		long range = sc.nextLong();
		System.out.println("Enter the id : ");
		int id = sc.nextInt();
		
		pgc = new Pgconnection();
		Cardtype ct = new Cardtype(card_name,range);
		pgc.sendupdatecardtype(ct,id);
		
	}

	
}
