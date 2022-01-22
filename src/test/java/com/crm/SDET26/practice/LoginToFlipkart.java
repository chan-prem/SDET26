package com.crm.SDET26.practice;

import java.awt.AWTException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginToFlipkart {
	@Test
	public void login()throws InterruptedException, AWTException {
		
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='✕']")).click();

		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("nokia mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		driver.findElement(By.xpath("//div[text()='Nokia 105 SS 2021']")).click();
		String mainID = driver.getWindowHandle();
		switchWindow(driver, "Nokia 105 SS 2021");

		driver.switchTo().window(mainID);		
		
		driver.findElement(By.xpath("//div[text()='Nokia 150 TA-1235 DS']")).click();
		switchWindow(driver, "Nokia 150 TA-1235 DS");
		driver.switchTo().window(mainID);
		driver.findElement(By.xpath("//div[text()='Nokia 110 TA-1302 DS']")).click();
		switchWindow(driver, "Nokia 110 TA-1302 DS");
		driver.switchTo().window(mainID);
		driver.findElement(By.xpath("//div[text()='Nokia 105']")).click();
		switchWindow(driver, "Nokia 105");
		driver.switchTo().window(mainID);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		Thread.sleep(10000);
		driver.quit();
	}
	
	public void switchWindow(WebDriver driver, String title) throws InterruptedException
	{
		Set<String> set = driver.getWindowHandles();
        for (String string : set) 
        {
			driver.switchTo().window(string);
			String currentWindowTitle = driver.getTitle();
		    
			if(currentWindowTitle.contains(title))
			{
				 driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
				 break;
			}
        }
	}
}
