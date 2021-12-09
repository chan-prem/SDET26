package com.crm.SDET26.Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgwithIndandType {
public static void main(String[] args) throws IOException {
		Random ran = new Random();
		int randomnum = ran.nextInt(10000);
	
	//commondata
		FileInputStream fis = new FileInputStream("./data/VtigerLogin.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String BROWSER = pObj.getProperty("browser");
		String PASSWORD = pObj.getProperty("password");
		
	//TestSpecificData
		FileInputStream efis = new FileInputStream("./data/VtigerTestSpecificData.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		Sheet sh = wb.getSheet("Organization");
		Row row = sh.getRow(0);
		String orgname = row.getCell(1).getStringCellValue() + randomnum;
		String industry = row.getCell(5).getStringCellValue();
		String type = row.getCell(7).getStringCellValue();
		wb.close();
		
		
			
	//Browser
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver  = new ChromeDriver();
		}else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//login
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();

	//CreateOrg
        driver.findElement(By.linkText("Organizations")).click();
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        driver.findElement(By.name("accountname")).sendKeys(orgname);
    //Selectindustry
        WebElement wb1 = driver.findElement(By.name("industry"));
        Select s1 = new Select(wb1);
        s1.selectByVisibleText(industry);
        
    //SelectType
        WebElement wb2 = driver.findElement(By.name("accounttype"));
        Select s2 = new Select(wb2);
        s2.selectByVisibleText(type);
        
    //save
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
    //verifyorg creation
        String verifyorgname = driver.findElement(By.className("dvHeaderText")).getText();
        if(verifyorgname.contains(orgname)) {
        	System.out.println("Org creation pass");
        }else {
        	System.out.println("org creation failed");
        }
        
        
    //verifyInd
        String verifyInd = driver.findElement(By.id ("dtlview_Industry")).getText();
        if(verifyInd.contains(industry)) {
        	System.out.println("Ind dropdwn pass");
        	
        }else {
        	System.out.println("Ind drpdwn failed");
        }
    //VerifyType
        String verifytype = driver.findElement(By.id("dtlview_Type")).getText();
        if(verifytype.contains(type)) {
        	System.out.println("Type creation Pass");
        }else {
        	System.out.println("Type Creation Fail");
        }
        
    //logout
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        driver.close();

        
}
}
