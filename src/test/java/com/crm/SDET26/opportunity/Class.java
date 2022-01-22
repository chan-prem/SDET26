package com.crm.SDET26.opportunity;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Class {

	
	public void window(WebDriver driver, String id) {
		
		driver = new ChromeDriver();
		String main = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		
		
		for(String wb:allId) {
			
			WebDriver window = driver.switchTo().window(wb);
			String title = window.getTitle();
			if(title.contains(id));
			{
				driver.switchTo().frame(1);
				driver.switchTo().alert().dismiss();
				break;
			}
		}
		driver.switchTo().window(main);
		
	}
	
	
	
	public void windoww(WebDriver driver , String id) {
		
		 driver = new ChromeDriver();
		String main = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for(String wb:allId) {
			
			String Window1 = driver.switchTo().window(wb).getTitle();
			System.out.println(Window1);			
		}
		
		
		for(String wb2:allId) {
			
			String Window2 = driver.switchTo().window(wb2).getTitle();
			if(Window2.contains(id));
			{
				 driver.switchTo().window(wb2).switchTo().frame(1);
				 Actions act = new Actions(driver);
				act.contextClick().perform();
				break;
			}
		
		}
		driver.switchTo().window(main);

		
			
		
	}
}
