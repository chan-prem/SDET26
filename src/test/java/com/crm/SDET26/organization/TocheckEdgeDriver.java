package com.crm.SDET26.organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TocheckEdgeDriver {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "D:\\JAVA\\EXE Files\\edgedriver_win64\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
	}
}
