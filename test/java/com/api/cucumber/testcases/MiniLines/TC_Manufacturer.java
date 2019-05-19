package com.api.cucumber.testcases.MiniLines;

import java.util.List;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.ManufacturerLobDetailsPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TC_Manufacturer extends ProjMethods{
	
	LobDetailsPage lob = new LobDetailsPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	PremiumSummaryPage premium = new PremiumSummaryPage(driver);
	ManufacturerLobDetailsPage manufacturer = new ManufacturerLobDetailsPage(driver);
	
	
	@Then("^I enter policy and lob details by selecting Manufacturer lob from \"([^\"]*)\"$")
	public void selectManufacturerLOb(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
			List<List<String>> data = table.raw();

			for (int i = 0; i < data.size(); i++) {
				System.out.println(data.get(i).toString());
			}
			premium.clickPolicyTab();
			policyDetails.selectLOBs(data.get(1).get(19));
			lob.clickNext();
			Thread.sleep(2000);
			lob.clickNextButton();
			Thread.sleep(1000);
			lob.clickNext();
			}
	

	@And("^I enter the location details for Manufacturer lob from \"([^\"]*)\"$")
public void i_enter_the_location_details_for_Manufacturer_lob_from(String arg1) throws Throwable {
		lob.clickLobHeader();
		Thread.sleep(2000);
		manufacturer.selectPerClaimLimit();
		manufacturer.selectDeductible();
		Thread.sleep(1000);
//		lob.clickNavigateNext();
//		Thread.sleep(1000);
//		lob.clickNext();
//		lob.clickYesOrNo();
		
}
	@And("^I have added optional coverages for manufacturer lob$")
	public void i_have_added_optional_coverages_for_manufacturer_lob() throws Throwable {
    
		manufacturer.expandOptionalcoverage();
		Thread.sleep(1000);
		manufacturer.CheckConsentPL7095();
		manufacturer.CheckDefenseOutsideOfLimits();
		manufacturer.CheckPunitiveDamages();
		manufacturer.CheckAdditional7090();
		Thread.sleep(1000);
		manufacturer.EnterAdditional7090Quantity();
		manufacturer.CheckAdditional7104();
		Thread.sleep(1000);
		manufacturer.EnterAdditional7104Quantity();
		lob.clickNavigateNext();
		Thread.sleep(1000);
		lob.clickNext();
		lob.clickYesOrNo();
	}


	
	
	@Then("^I rate the manufacturer policy$")
	public void i_rate_the_manufacturer_policy() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   lob.clickRateButton();
	}


	}


