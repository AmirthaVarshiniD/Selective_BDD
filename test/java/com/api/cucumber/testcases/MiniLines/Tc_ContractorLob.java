package com.api.cucumber.testcases.MiniLines;

import java.util.List;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.ContractorLobDetailsPage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Tc_ContractorLob extends ProjMethods {

	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locationPage = new LocationsPage(driver);
	LobDetailsPage lob = new LobDetailsPage(driver);
	PremiumSummaryPage premium = new PremiumSummaryPage(driver);
	ContractorLobDetailsPage con = new ContractorLobDetailsPage(driver);

	@Given("^I enter the policy and lob details by selecting Gl lob from \"([^\"]*)\"$")
	public void enterPoilicyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {

		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
		}

		policyDetails.enterYear(data.get(1).get(10).toString());
		policyDetails.enterNatureOfBus();
		policyDetails.selectOwnership(data.get(1).get(18).toString());
		policyDetails.selectrMarketSegment(data.get(1).get(11).toString()).selectInsComp(data.get(1).get(12).toString())
				.findListOfInsComp().selectLOBs(data.get(1).get(17)).selectMarijuanaQuest()
				.selectSICCoide(data.get(1).get(13).toString()).selectPriorCarrier(data.get(1).get(14).toString());
		if (!(data.get(1).get(11).toString().equals("Mercantile")) && ((data.get(1).get(17).equals("GR")))) {
			lob.clickNext();
			lob.clickNext();
			lob.clickNextButton();
		} else {
			lob.clickNext();
			Thread.sleep(2000);
			lob.clickNextButton();
		}
	}

	@Given("^I enter the location details and rate the policy for GL lob from \"([^\"]*)\"$")
	public void enterLoctaiondetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
			System.out.println("My username is:" + data.get(1).get(0).toString());
		}
		locationPage.enetrDesc(data.get(1).get(0).toString());
		locationPage.clickLob();
		Thread.sleep(1000);
		locationPage.clickNextToLobDetails();
		Thread.sleep(2000);
		lob.selectAggrLimit();
		lob.selectLobLossRate(data.get(1).get(2).toString());
		lob.selLossFreeYears(data.get(1).get(7).toString());
		lob.clickNext();
		Thread.sleep(2000);
		lob.clickNext();
		Thread.sleep(2000);
		lob.selExtnOptions1();
		lob.clickNext();
		lob.classCode("10100");
		lob.enterPremiumBasics(data.get(1).get(3).toString());
		Thread.sleep(2000);
		// lob.locationOverride();
		lob.clickNext();
		lob.clickRateButton();
		Thread.sleep(2000);
		lob.clickNext();
		Thread.sleep(20000);
}

	@Then("^I enter policy and lob details by selecting Contractor lob from \"([^\"]*)\"$")
	public void selectContractorLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
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

	@Then("^I enetr the location details for Contractor lob from \"([^\"]*)\"$")
	public void i_enetr_the_location_details_for_Contractor_lob_from(String arg1) throws Throwable {
		lob.clickLobHeader();
		Thread.sleep(2000);
		con.selectContractorLimit();
		Thread.sleep(1000);
		con.selectContractorDeductible();
		con.clickContractorCitySearch();
		lob.clickNext();
	}

	@Then("^I rate the policy$")
	public void i_rate_the_policy() throws Throwable {
		lob.clickRateButton1();
		Thread.sleep(20000);
		premium.verifyPremiumValue();
	}

}
