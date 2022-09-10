package com.zoho.credit_card;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateWithinRange {

	public void dateFormat(String d, String d2,String d3) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date startDate = sdf.parse(d);
		Date endDate = sdf.parse(d3);

		System.out.println("billing_date : " + sdf.format(startDate));


		DateRangeValidator checker = new DateRangeValidator(startDate, endDate);

		Date testDate = sdf.parse(d2);
		/*System.out.println("start_date : "+sdf.format(startDate));
		System.out.println("start_date : "+sdf.format(endDate));
		System.out.println("testDate : " + sdf.format(testDate));*/

		if(checker.isWithinRange(testDate)){
			System.out.println("contiune the process");
		}else{
			System.out.println("sorry your bill is pending");
			System.exit(0);
		}

	}

	public void date_checker(String date,String date0) throws ParseException   
	{  

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  

		Date date1 = sdf.parse(date);  
		Date date2 = sdf.parse(date0);  
		if(date1.compareTo(date2) > 0)   
		{  
			System.out.println("continue the process");
		}
		else {
			System.out.println("Enter the correct date ");
			System.exit(0);
		}
	}
	
	
}
