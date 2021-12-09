package com.crm.SDET26.Opportunity;

import org.testng.annotations.Test;

import com.crm.SDET26.genericUtility.BaseClass;
import com.crm.SDET26.pomRepository.CreateNewOrganizationPage;
import com.crm.SDET26.pomRepository.HomePage;
import com.crm.SDET26.pomRepository.OrganizationInformationPage;
import com.crm.SDET26.pomRepository.OrganizationPage;

public class CreateOpportunityAndClickonSave extends BaseClass{

	@Test
	public void createOpportunityAndClickonSave() throws Throwable{
		
		//navigate to Organization
		
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		
		//Nav to Create Organization
		
		OrganizationPage org = new OrganizationPage(driver);
		org.getCreateOrgImg().click();
		
		//Create Organization
		
		String orgname = eLib.getDataFromExcel("organization", 0, 1);
		CreateNewOrganizationPage newOrg = new CreateNewOrganizationPage(driver);
		newOrg.CreateOrganization(orgname);
		//
		
	}
	
	
}
