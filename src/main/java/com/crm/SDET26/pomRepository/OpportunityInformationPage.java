package com.crm.SDET26.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage {
	
	public OpportunityInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class = 'dvHeaderText']")
	private WebElement headertxt;
	
	@FindBy(xpath = "//span[@id = 'dtlview_Assigned To']")
	private WebElement selectedGroup;
	
	public WebElement getSelectedGroup() {
		return selectedGroup;
	}

	@FindBy(xpath = "//span[@id = 'dtlview_Sales Stage']")
	private WebElement salesstageresult;
	
	

	public WebElement getSalesstageresult() {
		return salesstageresult;
	}



	public WebElement getHeadertxt() {
		return headertxt;
	}
	

}
