package com.crm.SDET26.opportunity;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.SDET26.genericUtility.BaseClass;
import com.crm.SDET26.pomRepository.CreateNewOpportunityPage;
import com.crm.SDET26.pomRepository.CreateNewOrganizationPage;
import com.crm.SDET26.pomRepository.HomePage;
import com.crm.SDET26.pomRepository.OpportunityPage;
import com.crm.SDET26.pomRepository.OrganizationPage;
import com.crm.SDET26.pomRepository.OrganizationInformationPage;

@Listeners(com.crm.SDET26.genericUtility.ListenerImpClass.class)

public class ClickOnCancelAndAllTheFillsAreClearOrNotTest extends BaseClass{


@Test(groups = "SmokeTest")
public void clickOnCancelAndAlltheFillsClearedorNot() throws Throwable {
	int randomNum = jLib.getRandomNum();	
//TestSpecificData
	String orgname = eLib.getDataFromExcel("Organization", 0, 1) + randomNum;
	String oppname = eLib.getDataFromExcel("Oppurtunity", 0, 1) + randomNum;
	String group = eLib.getDataFromExcel("Oppurtunity", 0, 3);
	String salesstage = eLib.getDataFromExcel("Oppurtunity", 6, 5);

		
    //Nav to Organization 
			HomePage hp = new HomePage(driver);
			hp.getOrganizationLink().click();
	//nav to create Organization
			OrganizationPage org = new OrganizationPage(driver);
			org.getCreateOrgImg().click();
			
	//create new Org 
			CreateNewOrganizationPage newOrg = new CreateNewOrganizationPage(driver);
			newOrg.CreateOrganization(orgname);
	//Wait to avoid StaleException
			OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
			wLib.waitForElemnetToBeClickAble(driver, orgInfo.getHeadertxt());

    //Nav to Opportunity Page
			hp.getOpportunityLink().click();
			
	//Nav to Create Opportunity
			OpportunityPage opp = new OpportunityPage(driver);
			opp.getCreateOpprImg().click();
	//Create new Opportunity
			CreateNewOpportunityPage newOpp = new CreateNewOpportunityPage(driver);
			newOpp.CreateOpportunity(oppname, orgname, group, salesstage, jLib.getSystemdate__YYYY_MM_DD());
			
	//Cancel
			newOpp.getCancelBtn().click();
			
    //verify
		try {
			opp.getGetheader().isEnabled();
			System.out.println("The Opportunity "+ oppname +" under the group "+ group+" with "+ salesstage +" sales stage has been created. Cancellation failed");
			}catch(Exception e) {
				System.out.println("The Opportunity " + oppname + " creation cancelled");
			}
             
}
}
