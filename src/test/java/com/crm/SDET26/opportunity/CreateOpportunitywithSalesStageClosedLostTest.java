package com.crm.SDET26.opportunity;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.SDET26.genericUtility.BaseClass;
import com.crm.SDET26.pomRepository.CreateNewOpportunityPage;
import com.crm.SDET26.pomRepository.CreateNewOrganizationPage;
import com.crm.SDET26.pomRepository.HomePage;
import com.crm.SDET26.pomRepository.OpportunityPage;
import com.crm.SDET26.pomRepository.OpportunityInformationPage;
import com.crm.SDET26.pomRepository.OrganizationPage;
import com.crm.SDET26.pomRepository.OrganizationInformationPage;


@Listeners(com.crm.SDET26.genericUtility.ListenerImpClass.class)
public class CreateOpportunitywithSalesStageClosedLostTest extends BaseClass{
	
	@Test(groups = "RegressionTest")
	public void createOpportunitywithSalesStageClosedLost() throws Throwable
	{
		int randomNum = jLib.getRandomNum();
		
	//TestSpecificData
		String orgname = eLib.getDataFromExcel("Organization", 0, 1) + randomNum;
		String oppname = eLib.getDataFromExcel("Oppurtunity", 0, 1) + randomNum;
		String group = eLib.getDataFromExcel("Oppurtunity", 0, 3);
		String salesstage = eLib.getDataFromExcel("Oppurtunity", 6, 5);
				
    //nav to Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		
	//nav to create Organization
		OrganizationPage org = new OrganizationPage(driver);
		org.getCreateOrgImg().click();
	
	//create new Org
		CreateNewOrganizationPage newOrg = new CreateNewOrganizationPage(driver);
		newOrg.CreateOrganization(orgname);
		
	//Wait to avoid StaleElement Exception
		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		wLib.waitForElemnetToBeClickAble(driver, orgInfo.getHeadertxt());
		
	//nav to opportunities
		hp.getOpportunityLink().click();
		
	//Nav to create Opportunity
		OpportunityPage opp = new OpportunityPage(driver);
		opp.getCreateOpprImg().click();
		
	//Create new Opportunity
		CreateNewOpportunityPage newOpp = new CreateNewOpportunityPage(driver);
		newOpp.CreateOpportunity(oppname, orgname, group, salesstage, jLib.getSystemdate__YYYY_MM_DD());
		newOpp.getSaveBtn().click();
        
    //verify
		OpportunityInformationPage oppInfo = new OpportunityInformationPage(driver);
		String createdOppName = oppInfo.getHeadertxt().getText();
		Assert.assertTrue(createdOppName.contains(oppname));
		String selectedGroup = oppInfo.getSelectedGroup().getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(selectedGroup, group);
		String selectedSalesStage = oppInfo.getSalesstageresult().getText();
		s.assertEquals(selectedSalesStage, salesstage);
		s.assertAll();

	}
}
