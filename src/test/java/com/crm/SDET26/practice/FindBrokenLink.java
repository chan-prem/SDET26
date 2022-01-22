package com.crm.SDET26.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindBrokenLink {
	
	@Test
	public void verifyLinks() throws IOException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in/");
		
		List <WebElement> elements = driver.findElements(By.xpath("//a"));
		
		for(int i=0; i<elements.size();i++)
		{
			WebElement ele = elements.get(i);
			String link = ele.getAttribute("href");
			verifylinkActive(link);
		}
		driver.quit();
	}
	
	
	public static void verifylinkActive(String link) throws IOException
	{
		URL url = new URL(link);
		
		HttpsURLConnection httpurlcon = (HttpsURLConnection)url.openConnection();
		httpurlcon.connect();
		
		if(httpurlcon.getResponseCode()==200)
		{
			System.out.println(link+" "+httpurlcon.getResponseMessage());
		}
		if(httpurlcon.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
		{
			System.out.println(link+" "+httpurlcon.getResponseMessage()+" "+ HttpURLConnection.HTTP_NOT_FOUND);
		}
	}

	
}
