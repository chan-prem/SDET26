package com.crm.SDET26.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart1 {

static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("keyboard");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[text()='ZEBRONICS Zeb-K20 Wired USB Desktop Keyboard']")).click();
		
		String mainID = driver.getWindowHandle();
		
		Flipkart1 fp = new Flipkart1();
		fp.switchto("ZEBRONICS Zeb-K20");
		
		
		driver.findElement(By.xpath("//button[@type='button']/../../preceding-sibling::li/button")).click();
		
		driver.switchTo().window(mainID);
				driver.findElement(By.xpath("//img[@alt='DELL KM117 Wireless Laptop Keyboard']")).click();
				
				fp.switchto("DELL KM117");
				
				driver.findElement(By.xpath("//button[@type='button']/../../preceding-sibling::li/button")).click();	
				
				driver.switchTo().window(mainID);
				driver.findElement(By.xpath("//a[text()='Logitech Mk235 Mouse & Wireless Laptop Keyboard']")).click();
				
				
				fp.switchto("Logitech Mk235");
				
				driver.findElement(By.xpath("//button[@type='button']/../../preceding-sibling::li/button")).click();		
	}
	
	public void switchto(String PartialTitle) {
		Set<String> set2 = driver.getWindowHandles();
		Iterator<String> it2 = set2.iterator();
		while(it2.hasNext()) {
			String wID2 = it2.next();
			driver.switchTo().window(wID2);
			String currentwindowtitle = driver.getTitle();
			if(currentwindowtitle.contains(PartialTitle)){
				break;
			}
		}
		}
}

