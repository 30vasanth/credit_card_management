package com.zoho.credit_card;



import java.sql.SQLException;
import java.util.Scanner;

public class Cardholder {

	
	Scanner sc = null;
	Pgconnection pgc = null;
	
	public void insert_user_data() throws SQLException {
		sc = new Scanner(System.in);
		pgc = new Pgconnection();
		try {
			System.out.println("Enter the name : ");
			String username = sc.next();
			System.out.println("Enter the email : ");
			String email = sc.next();
			System.out.println("Enter the mobile : ");
			long mobile = sc.nextLong();
			System.out.println("Enter the income : ");
			long income = sc.nextLong();
			long limit = 1000000;

			if(income<limit) {
				System.out.println("Sorry your not eligble to the credit card");
				System.exit(0);
			}
			Cardholderdetails chd =new Cardholderdetails(username,email,mobile,income);
			pgc.sendinsertuserdata(chd);
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}

	public void update_user_data() throws SQLException {
		sc = new Scanner(System.in);
		pgc = new Pgconnection();
		System.out.println("Enter the name : ");
		String username = sc.next();
		System.out.println("Enter the email : ");
		String email = sc.next();
		System.out.println("Enter the mobile : ");
		long mobile = sc.nextLong();
		System.out.println("Enter the income : ");
		long income = sc.nextLong();
		Cardholderdetails chd =new Cardholderdetails(username,email,mobile,income);
		pgc.sendupdateduserdata(chd);
	}

	

	public void delete() throws SQLException {
		sc = new Scanner(System.in);
		pgc = new Pgconnection();
		System.out.print("Enter the your mobile :");
		long mobile = sc.nextLong();
		System.out.print("Enter the username :");
		String username = sc.next();
		
		pgc.userdeleterequest(username,mobile);
		
	}
}