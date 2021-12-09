package com.crm.SDET26.practice;

import java.util.Date;

public class CreateDate {
public static void main(String[] args) {
	

	Date dateObj = new Date();
	String currentDate = dateObj.toString();
	/*int date = dateObj.getDate();
	int month = dateObj.getMonth() + 1;
	String year = dateObj.toString().split(" ")[5]; //(explain)
	
	String formulate = year + "-" + month+ "-" + date;

			System.out.println(currentDate);
			System.out.println(formulate);*/
	
	String time = dateObj.toString().split(" ")[3];
	String time2 = time.replace(":", "_");
	
	System.out.println(time2);
	

}
}
