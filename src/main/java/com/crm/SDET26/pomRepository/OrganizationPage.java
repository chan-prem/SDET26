package com.crm.SDET26.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//img[@alt = 'Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(name = "search_text")
	private WebElement searchbox;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy (xpath = "//tr[@class = 'lvtColData']")
	private WebElement selFromSearchResult;
	
	public WebElement getSearchbox() {
		return searchbox;
	}
	
	
	public WebElement searchBtn() {
		return searchBtn;
	}



	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	
}
