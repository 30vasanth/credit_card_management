package com.zoho.credit_card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Cardmanagement {

	static InputStreamReader re = null;
	static BufferedReader sc = null;

	public static void main(String [] args) throws SQLException, NumberFormatException, IOException {
		re = new InputStreamReader(System.in);
		sc = new BufferedReader(re);
		System.out.println("your are admin enter -----> 1");
		System.out.println("your are customer enter --> 2");
		int choice = Integer.parseInt(sc.readLine());

		while(true) {
			switch(choice) {
			case 1:
				Admincontrol a_c = new Admincontrol();
				a_c.adminc();
				a_c.admin_selection();
				break;
			case 2:
				Customer c = new Customer();
				c.customer_selection();
				break;
			case 3:
				Pgconnection.connect().close();
				System.exit(0);
				break;
			default:
				System.out.println("select the correct option");
			}
		}
	}

}

