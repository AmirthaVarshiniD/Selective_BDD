package com.api.cucumber.testcases.MiniLines;

import java.util.List;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
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

public class TC_US_48600 extends ProjMethods {

	PolicyDetailsPage policyPage = new PolicyDetailsPage(driver);
	PremiumSummaryPage premium = new PremiumSummaryPage(driver);
	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locationPage = new LocationsPage(driver);
	LobDetailsPage lob = new LobDetailsPage(driver);


	@Then("^I verify that the Assisted Living Facilities lob is not listed$")
	public void i_verify_that_the_Assisted_Living_Facilities_lob_is_not_listed() throws Throwable {
		premium.clickPolicyTab();
		Thread.sleep(2000);
		policyPage.verifyLobList();

	}
	@Then("^I verify that the Assisted Living Facilities lob need to be listed$")
	public void i_verify_that_the_Assisted_Living_Facilities_lob_need_to_be_listed() throws Throwable {
		premium.clickPolicyTab();
		Thread.sleep(2000);
		policyPage.verifyLobListsecondary();

	}
	
	@Given("^I enter the location details by selecting GL lob and also for the secondary state from \"([^\"]*)\"$")
	public void enterLoctaiondetailsSecobdaryState(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
			System.out.println("My username is:" + data.get(1).get(0).toString());
		}
		locationPage.enetrDesc(data.get(1).get(0).toString());
		locationPage.clickLob();
		Thread.sleep(1000);
//		locationPage.clickAddLocationButton();
//		Thread.sleep(1000);
//		locationPage.enetrDesc(data.get(1).get(0).toString());
//		locationPage.clickLob();
//		Thread.sleep(1000);
//		locationPage.enterAddress1();
//		locationPage.selectState();
//		Thread.sleep(1000);
//		locationPage.enterCity();
//		Thread.sleep(2000);
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
//		lob.locationOverride();
		lob.clickNext();
//		lob.classCodeFL("10100");
//		lob.enterPremiumBasics(data.get(1).get(3).toString());
//		Thread.sleep(2000);
//		lob.locationOverride2();
//		lob.clickNext();
		lob.clickRateButton();
		Thread.sleep(2000);
		lob.clickNext();
		Thread.sleep(20000);
		

	}
}