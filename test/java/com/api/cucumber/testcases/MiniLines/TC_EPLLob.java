package com.api.cucumber.testcases.MiniLines;

import java.util.List;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.EPLLobPageDetails;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class TC_EPLLob extends ProjMethods {

	LobDetailsPage lob = new LobDetailsPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	PremiumSummaryPage premium = new PremiumSummaryPage(driver);
	EPLLobPageDetails eplLob = new EPLLobPageDetails(driver);

	@Then("^I enter policy and lob details by selecting EPL lob from \"([^\"]*)\"$")
	public void selectEPLLOb(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
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

	@And("^I enter  details for EPL lob from \"([^\"]*)\"$")
	public void i_enter_details_for_EPL_lob_from(String arg1) throws Throwable {
		lob.clickLobHeader();
		Thread.sleep(2000);
		eplLob.EnterTotalEmployees();
		Thread.sleep(1000);
		lob.clickNext();
		eplLob.EnterTotalEmployees();
		Thread.sleep(1000);
		eplLob.selectCoverage();
		Thread.sleep(1000);
		lob.clickNext();
		Thread.sleep(2000);
		lob.clickNext();
	}
	@Then("^I rate the EPL policy$")
	public void i_rate_the_EPL_policy() throws Throwable {
	    lob.clickLobRateButton();
	}



}
