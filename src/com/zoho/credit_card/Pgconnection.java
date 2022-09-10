package com.zoho.credit_card;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Pgconnection {
	private static Connection c = null;
	String SQL = null;
	PreparedStatement pstmt =null;
	

	public static Connection connect() {
		try {
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/credit_card_management","postgres","1234567890");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public void sendtransationcredit(Transationdetails t_h) throws SQLException {
		// TODO Auto-generated method stub
		SQL = "INSERT INTO transationdetails (cardnumber,description,amount,balance,day,month,year)"+"VALUES(?,?,?,?,?,?,?);";


		try {
			pstmt = connect().prepareStatement(SQL);
			pstmt.setLong(1,t_h.getCard_number());
			pstmt.setString(2,t_h.getDescription());
			pstmt.setLong(3,t_h.getDebit_amount());
			pstmt.setLong(4,t_h.getBalance());
			pstmt.setInt(5, t_h.getDay());
			pstmt.setInt(6, t_h.getMonth());
			pstmt.setInt(7, t_h.getYear());

			pstmt.executeUpdate();
			System.out.println("Data insert successfully");
		}catch(Exception e) {
			System.out.println(e);
		}
		finally{
			pstmt.close();
		}
	}

	public Long id_typecheck(long card_number) {
		Statement st= null;
		long balance = 0;

		SQL = "SELECT carddetails.cardnumber,cardtype.id,cardtype.range,carddetails.userid FROM cardtype Left Outer join carddetails ON cardtype.id = carddetails.typeid where cardnumber = "+card_number;
		try {
			st=Pgconnection.connect().createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while(rs.next()) {
				System.out.println(rs.getInt(3));
				balance = rs.getInt(3);
			}
			return balance;
		}catch(Exception e) {
			System.out.println(e);
		}
		return balance;

	}

	public void sendtransation_insert(Transationdetails t_h) throws SQLException {
		// TODO Auto-generated method stub
		SQL = "INSERT INTO transationdetails (cardnumber,description,amount,balance,day,month,year)"+"VALUES(?,?,?,?,?,?,?);";


		try {
			pstmt = connect().prepareStatement(SQL);
			pstmt.setLong(1,t_h.getCard_number());
			pstmt.setString(2,t_h.getDescription());
			pstmt.setLong(3,t_h.getDebit_amount());
			pstmt.setLong(4,t_h.getBalance());
			pstmt.setInt(5, t_h.getDay());
			pstmt.setInt(6, t_h.getMonth());
			pstmt.setInt(7, t_h.getYear());
			pstmt.executeUpdate();
			System.out.println("Data insert successfully");
		}catch(Exception e) {
			System.out.println(e);
		}
		finally{
			pstmt.close();
		}
	}

	public Long getLast_transation_details(long card_number) {

		Statement st= null;
		Long balance2 = 0l;
		long balance = 0; 
		SQL = "SELECT * FROM transationdetails where cardnumber = "+card_number;
		try {
			st=Pgconnection.connect().createStatement();
			ResultSet rs = st.executeQuery(SQL);
			ArrayList <Long>a = new ArrayList<Long>();
			while(rs.next()) {

				balance = rs.getLong(5);
				a.add(balance);
			}
			if(a.size()==0) {
				balance2 = id_typecheck(card_number);
			}
			else {
				balance2 = a.get((a.size())-1);
				System.out.println(balance2);
			}


			return balance2;
		}catch(Exception e) {
			System.out.println(e);
		}
		return balance;

	} 

	public void get_all_transation_details(long card_number) {



		SQL = "SELECT * FROM transationdetails where cardnumber = ?";
		try {
			pstmt = Pgconnection.connect().prepareStatement(SQL);

			pstmt.setLong(1,card_number);
			ResultSet rs= pstmt.executeQuery();

			while(rs.next()) {

				String description = rs.getString(3);
				long amount = rs.getLong(4);
				int day = rs.getInt(6);
				int month = rs.getInt(7);
				int year = rs.getInt(8);
				long balance = rs.getLong(5);
				System.out.printf("card_number =%s description =%s amount =%s day =%s month =%s year =%s balance = %s",card_number,description,amount,day,month,year,balance);	
				System.out.println();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void sendinsertcardtype(Cardtype ct) {
		// TODO Auto-generated method stub
		SQL = "INSERT INTO cardtype (cardname,range)"+"VALUES(?,?);";
		try {
			pstmt = Pgconnection.connect().prepareStatement(SQL);
			pstmt.setString(1,ct.getCard_name());
			pstmt.setLong(2,ct.getRange());
			pstmt.executeUpdate();
			System.out.println("Data insert successfully");
		}catch(Exception e) {
			System.out.println(e);
			Typesofcard ty = new Typesofcard();
			ty.insertcardtype();
		}
		finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void sendupdatecardtype(Cardtype ct,int id) throws SQLException {
		// TODO Auto-generated method stub
		SQL ="update cardtype "+"set cardname = ?,"+" range = ? where id = ?";
		try {
			pstmt = Pgconnection.connect().prepareStatement(SQL);
			pstmt.setString(1, ct.getCard_name());
			pstmt.setLong(2, ct.getRange());
			pstmt.setInt(3,id);
			pstmt.executeUpdate();
			System.out.println("Data insert successfully");
		}catch(Exception e) {
			System.out.println(e);
		}
		finally{
			pstmt.close();
		}
	} 

	public void display_card_type() {

		try {
			Statement st = Pgconnection.connect().createStatement();	
			ResultSet rs = st.executeQuery( "select * from public.\"cardtype\" ;" );	 
			while ( rs.next() ) {
				int id = rs.getInt(1);
				String card_name= rs.getString(2);
				Long range = rs.getLong(3);

				System.out.printf( "id = %s , cardname = %s , range = %s ", id,card_name,range );
				System.out.println();
			}
			rs.close();
			st.close();

		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println(" Data Retrieved Successfully ..");
	}

	public void sendinsertcardbilling(Cardmapping cm) throws SQLException {
		// TODO Auto-generated method stub
		SQL = "INSERT INTO cardmapping (cardnumber,billing_date,due)"+"VALUES(?,?,?);";
		try {
			pstmt = Pgconnection.connect().prepareStatement(SQL);
			pstmt.setLong(1,cm.getCard_number());
			pstmt.setDate(2,Date.valueOf(cm.getBilling_date()));
			pstmt.setDate(3,Date.valueOf(cm.getDue_date()));
			pstmt.executeUpdate();
			System.out.println("Data insert successfully");
		}catch(Exception e) {
			System.out.println(e);
			Billingprocess bp = new Billingprocess();
			bp.insertcardbilling();
		}
		finally{
			pstmt.close();
		}
	}

	public void check_Last_credit_details(String d3,long card_number) throws SQLException {
		Statement st= null;
		String date ="";
		ResultSet rs = null;
		Transationdetails t_h;
		SQL = "SELECT * FROM transationdetails where cardnumber = "+card_number+"and description = 'credit';";
		try {
			st=Pgconnection.connect().createStatement();
			rs = st.executeQuery(SQL);
			ArrayList <Transationdetails>a = new ArrayList<Transationdetails>();
			while(rs.next()) {
				long card_number2 = rs.getLong(2);
				String description = rs.getString(3);
				long debit_amount = rs.getLong(4);
				int day = rs.getInt(6);
				int	month = rs.getInt(7);
				int year = rs.getInt(8);
				Long balance = rs.getLong(5);

				t_h = new Transationdetails (card_number2,description,debit_amount,balance,day,month,year);
				a.add(t_h);

			}
			t_h = a.get(a.size()-1);
			date =t_h.getYear()+"-"+t_h.getMonth()+"-"+t_h.getDay();
			System.out.println(date);
			Date_checker(date,d3,card_number);
		}catch(Exception e) {
			System.out.println(e);

		}
		finally {
			rs.close();
		}

	} 

	public void Date_checker(String current,String d3,long card_number2) throws SQLException {
		Statement st = null;
		ArrayList<Cardmapping> a = new ArrayList<Cardmapping>();
		ResultSet rs= null;
		String find =""; 
		DateWithinRange dr = new DateWithinRange();
		try {
			st = Pgconnection.connect().createStatement();
			rs = st.executeQuery( "select * from cardmapping where cardnumber = "+card_number2);
			while ( rs.next() ) {
				long card_number = rs.getInt(2);
				String billing_date = rs.getString(3);
				String due_date = rs.getString(4);
				Cardmapping c_m = new Cardmapping(billing_date,due_date,card_number);
				a.add(c_m);
			}
			Cardmapping data = a.get(a.size()-1);
			System.out.println(data.getCard_number()+" "+data.getBilling_date()+" "+data.getDue_date());
			find = data.getBilling_date();

			dr.dateFormat(find,current,d3);
		} 
		catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}

		finally {
			rs.close();
			st.close();
		}

		System.out.println(" Data Retrieved Successfully ..");

	}

	public void getthebilldatarequest(long card_number) throws SQLException {
		Statement st = null;
		ArrayList<Cardmapping> a = new ArrayList<Cardmapping>();
		ResultSet rs= null;

		try {
			st =Pgconnection.connect().createStatement();
			rs = st.executeQuery( "select * from cardmapping where cardnumber ="+card_number);
			while ( rs.next() ) {
				card_number = rs.getInt(2);
				String billing_date = rs.getString(3);
				String due_date = rs.getString(4);
				Cardmapping c_m = new Cardmapping(billing_date,due_date,card_number);
				a.add(c_m);
			}
			Cardmapping data = a.get(a.size()-1);
			System.out.println("card number : "+data.getCard_number()+" get bill date : "+data.getBilling_date()+"due date : "+data.getDue_date());
			System.out.println(" Data Retrieved Successfully ..");
		} 
		catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );

			//System.exit(0);
		}

		finally {
			rs.close();
			st.close();
		}
	}

	public void getLast_transation_details(long card_number,String date) {

		Statement st= null;
		String date0 = null;
		DateWithinRange dr = new DateWithinRange();

		SQL = "SELECT * FROM transationdetails where cardnumber = "+card_number;
		try {
			st=Pgconnection.connect().createStatement();
			ResultSet rs = st.executeQuery(SQL);
			ArrayList <String>a = new ArrayList<String>();
			while(rs.next()) {
				int day = rs.getInt(5);
				int Month = rs.getInt(6);
				int year = rs.getInt(7);
				String d1 = year+"-"+Month+"-"+day;
				a.add(d1);
			}

			date0 = a.get((a.size())-1);
			dr.date_checker(date,date0);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void  sendinsertuserdata(Cardholderdetails c_h_d) {
		
		SQL = "INSERT INTO cardholderdetails (username,mobile,email,income)"+"VALUES(?,?,?,?);";
	try {	
		pstmt = Pgconnection.connect().prepareStatement(SQL);
		pstmt.setString(1,c_h_d.getUsername());
		pstmt.setString(3,c_h_d.getEmail());
		pstmt.setLong(2,c_h_d.getMobile());
		pstmt.setLong(4,c_h_d.getIncome());
		pstmt.executeUpdate();
		System.out.println("Data insert successfully");
	}catch(Exception e) {
		System.out.println(e);
	}
	}
	
	public void sendupdateduserdata(Cardholderdetails c_h_d) {
		SQL = "update cardholderdetails "+"set username = ?,"+"email = ?,"+" income =? where mobile = ?";
		try {
			pstmt = Pgconnection.connect().prepareStatement(SQL);
			pstmt.setString(1,c_h_d.getUsername());
			pstmt.setString(2,c_h_d.getEmail());
			pstmt.setLong(4,c_h_d.getMobile());
			pstmt.setLong(3,c_h_d.getIncome());
			pstmt.executeUpdate();
			System.out.println("Data insert successfully");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void display_all_user() throws SQLException {
		ResultSet rs = null;
		Statement st = null;

		try {
			st = Pgconnection.connect().createStatement();	
			rs = st.executeQuery( "select * from public.\"cardholderdetails\" ;" );	 
			while ( rs.next() ) {
				long id = rs.getInt(1);
				long mobile = rs.getLong(5); 
				String username= rs.getString(2);
				String email = rs.getString(3);
				Long income = rs.getLong(4);

				System.out.printf( "id = %s , username = %s , email = %s , income = %s , mobile = %s ", id,username,email,income,mobile);
				System.out.println();
			}

			System.out.println("Data Retrieved Successfully ..");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		finally {
			rs.close();
			st.close();
		}
	}

	public void userdeleterequest(String username, long mobile) throws SQLException {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM cardholderdetails WHERE mobile  = ? and username = ?";
		try {



			pstmt = Pgconnection.connect().prepareStatement(SQL);

			pstmt.setLong(1,mobile);
			pstmt.setString(2,username);
			pstmt.executeQuery();

			System.out.println("deletion process is completed ! deleted id :"+mobile);

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			pstmt.close();
		}
		
	}

	public void admincrequest(String name,String password) {
		// TODO Auto-generated method stub
		Admincontrol ac = new Admincontrol();
		String SQL = "SELECT username,password FROM admin WHERE username = ? and password = ?";
		try {
			pstmt = Pgconnection.connect().prepareStatement(SQL);
			pstmt.setString(1,name);
			pstmt.setString(2,password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("continue the process");
			}
			else {
				System.out.println("your username and password is wrong ");
				ac.adminc();
			}


		} catch (Exception e) {
			System.out.println(e.getMessage());
			//admin_c();
		}
	}

	public void usercrequest(long cardnumber, long mobile) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		String SQL = "SELECT cardholderdetails.id FROM cardholderdetails Left Outer join carddetails ON cardholderdetails.id = carddetails.userid where cardholderdetails.mobile = ? and carddetails.cardnumber = ? ";
		try {


			PreparedStatement pstmt = Pgconnection.connect().prepareStatement(SQL);
			pstmt.setLong(2,cardnumber);
			pstmt.setLong(1,mobile);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("continue the process");
			}
			else {
				System.out.println("your username and password is wrong ");
			
				customer.userc();
			}


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void cardapprovalrequest(Carddetails cd) throws SQLException {
		// TODO Auto-generated method stub
		SQL = "INSERT INTO carddetails (cardnumber,typeid,userid, expriedate,cvv)"+"VALUES(?,?,?,?,?);";
		try {
			pstmt = Pgconnection.connect().prepareStatement(SQL);
			pstmt.setLong(1,cd.getCard_number());
			pstmt.setInt(2,cd.getType_id());
			pstmt.setInt(3,cd.getUser_id());
			pstmt.setDate(4,Date.valueOf(cd.getExpire_date()));
			pstmt.setInt(5,cd.getCvv());
			pstmt.executeUpdate();
			System.out.println("Data insert successfully");
		}catch(Exception e) {
			System.out.println(e);
		}
		finally{
			pstmt.close();
		}
	}

	public void carddetailsrequest(Long id) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		String SQL = "SELECT cardnumber,typeid,userid FROM carddetails WHERE  cardnumber = ?";
		try {
			pstmt = Pgconnection.connect().prepareStatement(SQL);
			pstmt.setLong(1,id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getLong(1)+"\t"+rs.getInt(3)+"\t"+rs.getInt(2)+"\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			rs.close();
			pstmt.close();

		}
	}
	
	
}

