package com.crm.SDET26.practice;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SAiFrlipkart {
	@Test
	public void flipkartInterview() throws Throwable
	{
		//System.getProperty("", "");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String arr[] = new String [3];
		int arrSize = 0;
		driver.findElement(By.xpath("//button[text() = '✕']")).click();
		
		driver.findElement(By.cssSelector("input[name = 'q']")).sendKeys("APPLE iPhone SE (Black, 64 GB)",Keys.ENTER);

		String mainId = driver.getWindowHandle();
		System.out.println(mainId);
		String item1 = driver.findElement(By.xpath("//div[text() = 'APPLE iPhone SE (Black, 64 GB)']")).getText();
		arr[arrSize] = item1;
		arrSize++;
		driver.findElement(By.xpath("//div[text() = 'APPLE iPhone SE (Black, 64 GB)']")).click();
		Set<String> allwindows = driver.getWindowHandles();
		for (String str : allwindows) 
		{
			if(!mainId.equals(str))
			{
				driver.switchTo().window(str);
				break;
			}
		}
		driver.findElement(By.xpath("//button[text() = 'ADD TO CART']")).click();
		Thread.sleep(1000);
		driver.close();
		
		
		driver.switchTo().window(mainId);
		driver.findElement(By.cssSelector("input[name = 'q']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name = 'q']")).sendKeys("APPLE iPhone SE (White, 64 GB)",Keys.ENTER);
		String item2 = driver.findElement(By.xpath("//div[text() = 'APPLE iPhone SE (White, 64 GB)']")).getText();
		arr[arrSize] = item2;
		arrSize++;
		driver.findElement(By.xpath("//div[text() = 'APPLE iPhone SE (White, 64 GB)']")).click();
		Set<String> allwindows2 = driver.getWindowHandles();
		for (String str : allwindows2) 
		{
			if(!mainId.equals(str))
			{
				driver.switchTo().window(str);
				break;
			}
		}
		driver.findElement(By.xpath("//button[text() = 'ADD TO CART']")).click();
		Thread.sleep(1000);
		driver.close();
		
		
		driver.switchTo().window(mainId);
		driver.findElement(By.cssSelector("input[name = 'q']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name = 'q']")).sendKeys("APPLE iPhone 12 Mini (White, 64 GB)",Keys.ENTER);
		String item3 = driver.findElement(By.xpath("//div[text() = 'APPLE iPhone 12 Mini (White, 64 GB)']")).getText();
		arr[arrSize] = item3;
		driver.findElement(By.xpath("//div[text() = 'APPLE iPhone 12 Mini (White, 64 GB)']")).click();
		Set<String> allwindows3 = driver.getWindowHandles();
		for (String str : allwindows3) 
		{
			if(!mainId.equals(str))
			{
				driver.switchTo().window(str);
				break;
			}
		}
		driver.findElement(By.xpath("//button[text() = 'ADD TO CART']")).click();
	
		List<WebElement> valid =  driver.findElements(By.xpath("//div[text() = 'My Cart (3)']/../../../following-sibling :: div//span/../div/a"));
		int count = 0;
		for (WebElement webElement : valid) 
		{
			for(int i = 0; i < arr.length; i++)
			{
				if(webElement.getText().equals(arr[i]))
				{
					System.out.println(webElement.getText());
					count++;
				}
			}
			
		}
		System.out.println("Items Present in cart is : " + count);
	
	
	}

}
