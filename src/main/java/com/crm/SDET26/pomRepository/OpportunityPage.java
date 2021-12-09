package com.crm.SDET26.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {

	public OpportunityPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src = 'themes/softed/images/btnL3Add.gif']")
	private WebElement createOpprImg;
	
	@FindBy(xpath = "//span[@class = 'dvHeaderText']")
	private WebElement getheader;
	
	public WebElement getGetheader() {
		return getheader;
	}

	public WebElement getCreateOpprImg() {
		return createOpprImg;
	}
	
}
