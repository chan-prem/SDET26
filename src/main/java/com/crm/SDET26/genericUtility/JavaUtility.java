package com.crm.SDET26.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/**
 * This class contains all Java specific generic reusable methods which can be used across Test Scripts
 * @author Chan
 *
 */
public class JavaUtility {
	/**
	 * It is used to generate random number within the boundary of 0 to 10000
	 * @return intData
	 */
	public int getRandomNum(){
		Random ran = new Random();
		int randomnum = ran.nextInt(10000);
		return randomnum;
	}
	
	/**
	 * This method is used to get the local system's time and date.
	 * @return String data
	 */
	public String getSystemDate() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		return systemDateAndTime;
	}
	/**
	 * This method is  used to get the local system's date in YYYY_MM_DD format.
	 * @return string data
	 */
	public String getSystemdate__YYYY_MM_DD() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		String[] arr= systemDateAndTime.split(" ");
		String DD = arr[2];
		String YYYY = arr[5];
		int MM = date.getMonth()+1;
		
		String dateformat = YYYY + "-" + MM + "-" + DD;
		
		return dateformat;
	
	}
	
	public void pressVirtualKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
