package com.crm.SDET26.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dontknw {

	

	@Test(dataProvider="getData")
	public void dontknw(String name) throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.olympics.com/");
		try {
			
		
		String ele = driver.findElement(By.xpath("//span[text()='"+name+"']/ancestor::li/descendant::span[@class='result-medal result-medal--gold']")).getText();
		System.out.println(name +" has "+ele+" gold(s)");

		}catch(Exception e) {
			System.out.println(name +" has no gold(s)");
		}
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[4][1];
		obj[0][0]="Eliud KIPCHOGE";
		obj[3][0]="Naomi Osaka";
		obj[1][0]="Yuzuru HANYU";
		obj[2][0]="Ester LEDECKA";
		
		return obj;
	}
}
