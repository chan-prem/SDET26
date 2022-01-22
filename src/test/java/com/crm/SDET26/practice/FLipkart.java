package com.crm.SDET26.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FLipkart {

	@Test
	public void connectFlipkart() throws InterruptedException, AWTException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		
		WebElement elect = driver.findElement(By.xpath("//img[@alt='Electronics']"));
		Actions act = new Actions(driver);
		act.moveToElement(elect).perform();
		
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='xtXmba']/following-sibling::a"));
		
		for (WebElement wb : list) 
		{
			String listname = wb.getText();
			System.out.println(listname);
		}
		
		driver.quit();
	}
}
