package com.api.cucumber.testcases.MiniLines;

import java.util.List;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.TechnologyLobPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TC_TechnologyLob extends ProjMethods {
	LoginPage2 login = new LoginPage2();
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LobDetailsPage lob = new LobDetailsPage(driver);
	PremiumSummaryPage premium = new PremiumSummaryPage(driver);
	TechnologyLobPage tech = new TechnologyLobPage(driver);

	@Then("^I enter policy and loctaion details by selecting technology lob from \"([^\"]*)\"$")
	public void selectTechnologyLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
		}
		premium.clickPolicyTab();
		Thread.sleep(2000);
		policyDetails.selectLOBs(data.get(1).get(19));
		lob.clickNext();
		Thread.sleep(2000);
		lob.clickNextButton();
		Thread.sleep(1000);
		lob.clickNext();
		Thread.sleep(1000);

	}

	@Then("^I enter the lob details for technology lob from \"([^\"]*)\"$")
	public void i_enter_the_lob_details_for_technology_lob_from(String arg1) throws Throwable {
		lob.clickLobHeader();
		Thread.sleep(1000);
		tech.selectTechAgrLimit();
		tech.selectTechPerClaimLimit();
		tech.selectTechdeductible();
		tech.enterGrossSales();
		Thread.sleep(1000);
		

	}
	
	@Given("^I verify all the optional coverages are selected in tech lob")
	public void i_verify_all_the_optional_coverages_are_selected_in_tech_lob() throws Throwable {
		tech.selectOptionalCoveragetech();
		lob.clickNextNavButton();
		Thread.sleep(1000);
		lob.clickNext();
		lob.clickYesOrNo();
		lob.clickRateButton1();
		Thread.sleep(5000);
		premium.verifyPremiumValue();
		
	}

}
