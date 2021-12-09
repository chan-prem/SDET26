package com.crm.SDET26.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SDET26.genericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
	WebDriver driver;

	public CreateNewOrganizationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement organizationNameFieldEdt;
	@FindBy(xpath = "//input[@value = 'T']")
	private WebElement assignedtoAsGroup;
	@FindBy (name = "assigned_group_id")
	private WebElement groupDD;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancelBtn;

	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrganizationNameFieldEdt() {
		return organizationNameFieldEdt;
	}
	public WebElement getAssignedtoAsGroup() {
		return assignedtoAsGroup;
	}
	public WebElement getGroupDD() {
		return groupDD;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void CreateOrganization(String orgname) {
		organizationNameFieldEdt.sendKeys(orgname);
		saveBtn.click();
	}
	public void CreateOrganization(String orgname, String group) {
		organizationNameFieldEdt.sendKeys(orgname);
		select(groupDD, group);
	}
}