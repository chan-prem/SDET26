package com.crm.SDET26.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SDET26.genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver; 
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Documents")
	private WebElement DocumentLink;
		
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunityLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}


	public WebElement getContactsLink() {
		return contactsLink;
	}


	public WebElement getDocumentLink() {
		return DocumentLink;
	}


	public WebElement getProductLink() {
		return productLink;
	}


	public WebElement getOpportunityLink() {
		return opportunityLink;
	}


	public WebElement getAdministratorImg() {
		return administratorImg;
	}


	public WebElement getSignOutLink() {
		return signOutLink;
	}


	public void logout() {
		mouseOverOnElemnet(driver, administratorImg);
		signOutLink.click();
	}
}
