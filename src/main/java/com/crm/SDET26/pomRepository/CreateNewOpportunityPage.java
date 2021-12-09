package com.crm.SDET26.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SDET26.genericUtility.WebDriverUtility;

public class CreateNewOpportunityPage extends WebDriverUtility {
	
	WebDriver driver;
	public CreateNewOpportunityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "potentialname")
	private WebElement oppurtunityNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancelBtn;
	
	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	@FindBy(name = "assigned_group_id")
	private WebElement assignToDDL;
	
	@FindBy(xpath = "//input[@name='related_to_display']/following-sibling::img")
	private WebElement relatedtoLookupImg;



	@FindBy(xpath = "//input[@value ='T']")
	private WebElement groupRadioBtn;
	
	@FindBy(name = "assigned_group_id")
	private WebElement groupDD;
	
	@FindBy(name = "sales_stage")
	private WebElement salesStageDD;
	
	@FindBy(name = "closingdate")
	private WebElement closingDateField;
	
	public WebElement getGroupRadioBtn() {
		return groupRadioBtn;
	}


	public WebElement getClosingDateField() {
		return closingDateField;
	}



	public WebElement getSalesStageDD() {
		return salesStageDD;
	}
	
		
	public WebElement getRelatedtoLookupImg() {
		return relatedtoLookupImg;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getGroupRadio() {
		return groupRadioBtn;
	}

	public WebElement getGroupDD() {
		return groupDD;
	}

	public WebElement getOppurtunityNameEdt() {
		return oppurtunityNameEdt;
	}

	

	public WebElement getAssignToDDL() {
		return assignToDDL;
	}
	
	public void CreateOpportunity(String oppname, String orgname, String groupDDL, String salesStageDDL, String date) throws InterruptedException {
		
		getOppurtunityNameEdt().sendKeys(oppname);
		getRelatedtoLookupImg().click();
		switchToWindow(driver, "Actions");
		OrganizationPage org = new OrganizationPage(driver);
		org.getSearchbox().sendKeys(orgname);
		org.searchBtn().click();
		WebElement wb = driver.findElement(By.xpath("//a[(text() ='"+orgname+"')]"));
		waitForElemnetToBeClickAble(driver, wb);
	    switchToWindow(driver, "Opportunities");
		getGroupRadio().click();
		select(groupDD, groupDDL);
		select(salesStageDD, salesStageDDL);

		getClosingDateField().clear();
		getClosingDateField().sendKeys(date);
	
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
}
