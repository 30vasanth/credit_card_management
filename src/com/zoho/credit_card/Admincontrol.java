package com.zoho.credit_card;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.SQLException;


public class Admincontrol {

	InputStreamReader re = null;
	BufferedReader sc = null;
	Pgconnection pgc = null;

	public void adminc() throws IOException {
		re = new InputStreamReader(System.in);
		sc = new BufferedReader(re);
		System.out.println("Enter the Admin_name : ");
		String name = sc.readLine();
		System.out.println("Enter the password   : ");
		String password = sc.readLine();
		pgc = new Pgconnection();
		pgc.admincrequest(name,password);
		
	}

	public void admin_selection() throws NumberFormatException, IOException, SQLException {
		re = new InputStreamReader(System.in);
		sc = new BufferedReader(re);
		Typesofcard tc = new Typesofcard();
		Cardholder c_holder = new Cardholder();
		Card card = new Card();
		Billingprocess bp =new Billingprocess();
		pgc = new Pgconnection();
		try {
			while(true) {
				System.out.println("insert new card type information ---------> 1");
				System.out.println("display the card type information --------> 2");
				System.out.println("update card type information -------------> 3");
				System.out.println("card holder information ------------------> 4");
				System.out.println("remove the card holder information -------> 5");
				System.out.println("insert new card information --------------> 6");
				System.out.println("check the one person limit ---------------> 7");
				System.out.println("card billing -----------------------------> 8");
				System.out.println("exit -------------------------------------> 9");
				int choice = Integer.parseInt(sc.readLine()); 
				switch(choice) {
				case 1:
					tc.insertcardtype();
					break;
				case 2:
					pgc.display_card_type();
					break;	
				case 3:
					tc.updatecardtype();
					break;

				case 4:
					c_holder.pgc.display_all_user();
					break;
				case 5:
					c_holder.delete();
					break;
				case 6:
					card.insertcard_details();
					break;
				case 7:
					System.out.println("Enter the cardnumber : ");
					long card_number = Long.parseLong(sc.readLine());
					System.out.println("given card  limit ");
					pgc.id_typecheck(card_number);
					break;
				case 8:
					bp.insertcardbilling();
					break;
				case 9:
					Pgconnection.connect().close();
					re.close();
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("select correct choice");
					break;
				}
				System.out.println("-----------------END-----------------------");
				System.out.println();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Enter the correct data");
			System.out.println("-----------------END-----------------------");
			System.out.println();
			admin_selection();
		}
	}
}
