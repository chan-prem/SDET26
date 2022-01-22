package com.crm.SDET26.practice;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebSite {

	@Test
	public void webSite() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.clinique.in/");
		
		WebElement popup = driver.findElement(By.xpath("//div[@class='outer-wrap signup jquery-once-1-processed']/*"));
		popup.click();
		
		driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']//button[@aria-label='Close']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='text-link--style-2']")).click();
		driver.findElement(By.xpath("//span[text()='Shop All']")).click();
			
	/*	wb.click();
		wb.click();
	*/	
		driver.findElement(By.xpath("//button[text()='Makeup']/ancestor::div[@class='header-gnav-section disabled']/following-sibling::div[@class='header-gnav-section header-gnav-section--basic-link current']/descendant::a")).click();
		//div[@class='header-gnav-section header-gnav-section--basic-link']/descendant::a[text()='Clinique Minis']
		
	}
}
