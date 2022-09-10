package com.zoho.credit_card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.sql.SQLException;

public class Customer {

	InputStreamReader re = null;
	BufferedReader sc = null;
	Pgconnection pgc = null;
	
	public void userc() throws IOException {
		re = new InputStreamReader(System.in);
		sc = new BufferedReader(re);
		System.out.println("Enter the cardnumber : ");
		long cardnumber = Long.parseLong(sc.readLine());
		System.out.println("Enter the mobile      : ");
		long mobile  = Long.parseLong(sc.readLine());
		pgc = new Pgconnection();
		pgc.usercrequest(cardnumber,mobile);
		
	}

	public void customer_selection() throws NumberFormatException, IOException, SQLException {
		
		//Types_of_card tc = new Types_of_card();
		Cardholder c_holder = new Cardholder();
		Card card = new Card();
		Transationhistroy t_h = new Transationhistroy();
		Billingprocess bp =new Billingprocess();
		pgc = new Pgconnection();
		re = new InputStreamReader(System.in);
		sc = new BufferedReader(re);
		try {
			while(true) {
				System.out.println("you want use the card enter ------> 1");
				System.out.println("pay bill amount ------------------> 2");
				System.out.println("your new user enter --------------> 3");
				System.out.println("you get card maximum -------------> 4");
				System.out.println("you update details ---------------> 5");
				System.out.println("you get card details -------------> 6");
				System.out.println("you want transation details ------> 7");
				System.out.println("get bills ------------------------> 8");
				System.out.println("exit -----------------------------> 9");
				int choice = Integer.parseInt(sc.readLine());
				switch(choice) {

				case 1:
					userc();
					t_h.transation_insert();
					break;
				case 2:
					userc();
					t_h.transationcredit();
					break;
				case 3:
					c_holder.insert_user_data();
					System.out.println("Application is accept process is complete within 4 days");
					break;
				case 4:
					userc();
					System.out.println("Enter card_number ");
					long card_number = Long.parseLong(sc.readLine());
					pgc.id_typecheck(card_number);
					break;
				case 5:
					userc();
					c_holder.update_user_data();
					break;
				case 6:
					userc();
					card.getCard_details();
					break;
				case 7:
					userc();	
					long card_number1 = Long.parseLong(sc.readLine());
					pgc.get_all_transation_details(card_number1);
					break;
				case 8:
					userc();
					bp.get_the_bill();
					break;
				case 9:
					Pgconnection.connect().close();
					re.close();
					sc.close();
					System.exit(0);
					break;

				default:
					System.out.println("select correct option");
					break;
				}
				System.out.println("-----------------END-----------------------");
				System.out.println();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.err.println("enter correct data");
			System.out.println("-----------------END-----------------------");
			System.out.println();
			customer_selection();
		}
		finally {
			if(sc == null) {
				sc.close();
			}
		}

	}
}
