package com.crm.SDET26.practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IUGhj {

	@Test
	public void oidda()
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("nokia mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String mainId = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//div[text()='Nokia 105 SS 2021']")).click();

		switchWin(driver, "Nokia 105 SS 2021");
		
		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//div[text()='Nokia 150 TA-1235 DS']")).click();
		switchWin(driver, "Nokia 150 TA-1235 DS");
		driver.switchTo().window(mainId);
		driver.findElement(By.xpath("//div[text()='Nokia 110 TA-1302 DS']")).click();
		switchWin(driver, "Nokia 110 TA-1302 DS");
		driver.switchTo().window(mainId);
		driver.findElement(By.xpath("//div[text()='Nokia 105']")).click();
		switchWin(driver, "Nokia 105");
		driver.switchTo().window(mainId);
		
		driver.findElement(By.xpath("//span[text()='Cart']")).click();

		
	}
	
	
	public void switchWin(WebDriver driver, String window)
	{
		Set <String> winIds= driver.getWindowHandles();
		for (String string : winIds) {
			driver.switchTo().window(string);
			String curWin= driver.getTitle();
			if(curWin.contains(window))
			{
				driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
				break;
			}
		}
	}
}
