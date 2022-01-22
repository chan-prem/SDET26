package com.crm.SDET26.basicScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScrollCheck {
	
	
	@Test
	public void scrollcheck() throws InterruptedException, IOException {
		
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	    	driver = new ChromeDriver();
	    
	    
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.partialLinkText("Read License"));
		act.click().perform();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		
		WebDriver driver1 = new ChromeDriver(opt);
		driver1.get("https://www.booking.com/index.html?aid=1535084&label=enin-edge-ntp-topsites-curate-ana");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		
		/*
		act.contextClick(ele).perform();		
		*/
		
		
		
		
		
		
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000);");
		*/

		
		
	/*	
		List <WebElement>  elements = driver.findElements(By.xpath("//a"));
		
		for(WebElement wb: elements) {
			String names = wb.getText();
			System.out.println(names);
			
			
			driver.quit();
			*/
			
		
		
		
		}
	
	
		
	}


