package com.api.cucumber.testcases.MiniLines;

import java.util.List;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.MPLobDetailsPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TC_MiscellaneousProfessionalLiab extends ProjMethods {

	LobDetailsPage lob = new LobDetailsPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	PremiumSummaryPage premium = new PremiumSummaryPage(driver);
	LocationsPage locationPage = new LocationsPage(driver);
	MPLobDetailsPage mpLob = new MPLobDetailsPage(driver);

	@Given("^I enter the location details and to rate the policy for GL lob from \"([^\"]*)\"$")
	public void enterLocationDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
			System.out.println("My username is:" + data.get(1).get(0).toString());
		}

		locationPage.enetrDesc(data.get(1).get(0).toString());
		locationPage.clickLob();
		locationPage.clickNextToLobDetails();
		lob.selectLobLossRate(data.get(1).get(2).toString());
		lob.selLossFreeYears(data.get(1).get(7).toString());
		lob.clickNext();
		Thread.sleep(2000);
		lob.clickNext();
		lob.selExtnOptions1();
		lob.clickNext();
		lob.classCode(data.get(1).get(9).toString());
		lob.enterPremiumBasics(data.get(1).get(3).toString());
		Thread.sleep(2000);
		// lob.locationOverride();
		Thread.sleep(2000);
		lob.clickNext();
		lob.clickRateButton();
		Thread.sleep(2000);
		lob.clickNext();
		Thread.sleep(20000);
	}

	@Then("^I enter policy and lob details by selecting MiscellaneousProfessionalLiab lob from \"([^\"]*)\"$")
	public void selectMPrLOb(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
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

	@Given("^I have checked MP Lob policy details$")
	public void i_have_checked_MP_Lob_policy_details() throws Throwable {
		lob.clickLobHeader();
		mpLob.ClickFirstQuestionNoRadio();
		mpLob.ClickSecondQuestionNoRadio();
		mpLob.ClickThirdQuestionNoRadio();
		mpLob.ClickFourthQuestionNoRadio();
		mpLob.ClickFifthQuestionYesRadio();
		mpLob.ClickSixthAQuestionYesRadio();
		mpLob.ClickSixthBQuestionYesRadio();
		mpLob.ClickSixthCQuestionYesRadio();
		mpLob.ClickSixthDQuestionYesRadio();
		mpLob.ClickSeventhQuestionNoRadio();
		mpLob.ClickSubmitButton();
		Thread.sleep(1000);
		mpLob.ClickAddNewClassCode();
		Thread.sleep(1000);
		mpLob.SelectProfessionalService();
		mpLob.SelectClassCode();
		mpLob.EnterPremiumBasis();
		Thread.sleep(1000);
		lob.clickNext();
		Thread.sleep(1000);
		lob.clickNext();
		Thread.sleep(2000);
		lob.clickNext();
		Thread.sleep(2000);
		lob.clickYesOrNo();

	}

	@And("^I have added optional coverages$")
	public void i_have_added_optional_coverages() throws Throwable {

		mpLob.CheckConsentPL7095();
		mpLob.CheckDefenseOutsideOfLimits();
		mpLob.CheckPunitiveDamages();
		mpLob.CheckAdditional7090();
		mpLob.EnterAdditional7090Quantity();
		mpLob.CheckAdditional7104();
		mpLob.EnterAdditional7104Quantity();
		Thread.sleep(1000);
		lob.clickNext();
		Thread.sleep(2000);
		lob.clickNext();
		Thread.sleep(2000);
		lob.clickYesOrNo();
		
	}

	@Then("^I have rated MP Lob Policy\\.$")
	public void i_have_rated_MP_Lob_Policy() throws Throwable {
		lob.clickRateButton1();

	}
}
