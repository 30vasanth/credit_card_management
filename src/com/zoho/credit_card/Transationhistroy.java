package com.zoho.credit_card;



import java.sql.SQLException;
import java.util.Scanner;

public class Transationhistroy {
	
	
	
	Scanner sc = null;
	Pgconnection pgc = null;
	
	public void transationcredit() throws SQLException {
		pgc = new Pgconnection();
		sc = new Scanner(System.in);
		
		System.out.println("Enter the card_number : ");
		long card_number = sc.nextLong();
		//System.out.println("Enter the description : ");
		String description = "credit";
		System.out.println("Enter the amount : ");
		long  amount = sc.nextLong();
		//System.out.println("Enter the balance : ");
		//long balance = sc.nextLong();
		System.out.println("Enter the day : ");
		int day = sc.nextInt();
		System.out.println("Enter the Month : ");
		int Month = sc.nextInt();
		System.out.println("Enter the year : ");
		int year = sc.nextInt();
		
		long	balance = pgc.getLast_transation_details(card_number);
		
		if(description.equals("credit")) {
			Long balance2 = pgc.id_typecheck(card_number);
			
			//System.out.println(balance);
			balance =balance+amount;
			
			if(balance2 == balance) {
				balance = balance2;
				System.out.println("This payment success no pending in your credit_card "+balance);
			}
			else {
				balance =balance+ amount;
				balance2 = balance2-balance;
				System.out.println("payment is pending : "+balance2+" make full payment");
				description ="payment is pending";
			}
		}
		Transationdetails t_h =new Transationdetails(card_number,description,amount,balance,day,Month,year);
		pgc.sendtransationcredit(t_h);
	}

	public void transation_insert() throws SQLException {
		pgc = new Pgconnection();
		sc = new Scanner(System.in);
		System.out.println("Enter the card_number : ");
		long card_number = sc.nextLong();
		System.out.println("Enter the description : ");
		String description = sc.next().toLowerCase();
		System.out.println("Enter the amount : ");
		Long  amount = sc.nextLong();
		//System.out.println("Enter the balance : ");
		//long balance = sc.nextLong();
		System.out.println("Enter the day : ");
		int day = sc.nextInt();
		System.out.println("Enter the Month : ");
		int Month = sc.nextInt();
		System.out.println("Enter the year : ");
		int year = sc.nextInt();
		String d1 = year+"-"+Month+"-"+day;
		
		pgc.check_Last_credit_details(d1,card_number);
		long balance = 0;
		long balance2 = 0;
		if(true==!(description.equals("credit"))) {
			balance2 = pgc.getLast_transation_details(card_number);
			System.out.println("balance : "+balance2);
				balance =balance2 - amount;
				System.out.println(balance);
				if(balance < 0) {
					System.out.println("sorry your balance is low : "+balance2);
					System.exit(0);
				}
			}
			else {
				System.out.println("please select the correct option");
			}
		
		Transationdetails t_h =new Transationdetails(card_number,description,amount,balance,day,Month,year);
		pgc.sendtransation_insert(t_h);
		
	}
	
	
}
