package com.api.cucumber.testcases.MiniLines;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.api.cucumber.comMethods.CommonMethods;
import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.ComLinesAutoSysPage;
import com.api.cucumber.pages.EnterNamePage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC004_GL_SB_DE extends ProjMethods {

	CommonMethods commonMenthods = new CommonMethods();
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locationPage = new LocationsPage(driver);
	LobDetailsPage lob = new LobDetailsPage(driver);
	PremiumSummaryPage premium = new PremiumSummaryPage(driver);
	EnterNamePage com = new EnterNamePage(driver);

	@When("^I enter the Account details for the quote from \"([^\"]*)\"$")
	public void accountDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		accInfo.enterAgentCode(data.get(1).get(0).toString()).selectPredState(data.get(1).get(1).toString()).selectMultiState()
				.enterMailAddrs1(data.get(1).get(2).toString()).enterMailAddrs2(data.get(1).get(4).toString())
				.enterZipCode1(data.get(1).get(3).toString())
				.enterZipCode2(data.get(1).get(3).toString())
				.enterPhoneAreaCode(data.get(1).get(5).toString()).enterPhoneExchange(data.get(1).get(6).toString())
				.enterPhoneLastDigits(data.get(1).get(7).toString()).clickRadioBtnMailStatus()
				.clickRadioBtnNewToAgency().enterPreminumSize(data.get(1).get(8).toString())
				.enterEffectDate(data.get(1).get(9).toString()).enterExpectDate()
				.choosePolicy(data.get(1).get(15).toString()).clickNext();
//		.clickNextToPolDet();

	}

	@Given("^I enter the Account details from \"([^\"]*)\"$")
	public void accountDetails1(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		accInfo.enterAgentCode(data.get(1).get(0).toString()).selectPredState(data.get(1).get(1).toString())
				.enterMailAddrs1(data.get(1).get(2).toString()).enterMailAddrs2(data.get(1).get(4).toString())
				.enterZipCode1(data.get(1).get(3).toString())
//				 .enterZipCode2(data.get(1).get(7).toString())
				// .enterCity(data.get(1).get(28).toString())
				// .selectMailState(data.get(1).get(29).toString())
				.enterPhoneAreaCode(data.get(1).get(5).toString()).enterPhoneExchange(data.get(1).get(6).toString())
				.enterPhoneLastDigits(data.get(1).get(7).toString()).clickRadioBtnMailStatus()
				.clickRadioBtnNewToAgency().enterPreminumSize(data.get(1).get(8).toString())
				// .SelectPreviousPolicy().enetrPreviousPolicyField1().enetrPreviousPolicyField2()
				// .enetrPreviousPolicyField3()
				.enterEffectDate(data.get(1).get(9).toString()).enterExpectDate()

				.choosePolicy(data.get(1).get(15).toString()).clickNext().clickNextToPolDet();
	}

	@Given("^I eneter the policy and lob details by selecting Gl Sb lob from \"([^\"]*)\"$")
	public void enterLobDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {

		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
		}
		policyDetails.enterYear(data.get(1).get(10).toString());
		policyDetails.enterNatureOfBus();
		policyDetails.selectOwnership(data.get(1).get(18).toString());
		policyDetails.selectrMarketSegment(data.get(1).get(11).toString()).selectInsComp(data.get(1).get(12).toString())
				.findListOfInsComp().selectLOBs(data.get(1).get(17)).selectMarijuanaQuest().selectSBLob()
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

	@Given("^I eneter the policy and lob details by selecting Gl SS lob from \"([^\"]*)\"$")
	public void enterLobDetailsSSLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {

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

	@Given("^I enetr the location details to create a new quote \"([^\"]*)\"$")
	public void LobDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
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
		lob.classCode("10010");
		lob.enterPremiumBasics(data.get(1).get(3).toString());
		lob.clickNext();
		lob.selectLimitAgg();
		 lob.enterSBExposure("1000");
		 lob.selectDeductible();
		 lob.clickNext();
		com .clickYesOrNo();
		Thread.sleep(1000);
		lob.clickNext();
		// lob.clickNext();
		lob.clickRateButton();
		Thread.sleep(2000);
		lob.clickNext();
//		Thread.sleep(20000);
		 

	}

	@Given("^i select SSlob in policy to complete quote")
	public void i_seelct_SSlob_in_policy_to_complete_quote() throws InterruptedException {
		premium.clickPolicyTab();
		policyDetails.selectSSLob();
		lob.clickNext();
		Thread.sleep(2000);
		lob.clickNextButton();
		Thread.sleep(1000);
		lob.clickNext();
		Thread.sleep(2000);
		lob.clickNext();
		Thread.sleep(2000);
		lob.clickNext();
		lob.clickNext();
		lob.clickNext();
		lob.clickNext();
		Thread.sleep(1000);
		lob.clickNext();
		Thread.sleep(3000);
		lob.clickNext();
		Thread.sleep(2000);
		lob.selectSSLimit();
		lob.clickPriorAct();
		lob.enterOutPatients();
		lob.enterInBeds();
		lob.clickNext();
		lob.clickRateButton1();

	}

	@Given("^I verify all the optional coverages are selected in SB lob")
	public void i_verify_all_the_optional_coverages_are_selected_in_SB_lob() throws Throwable {

		lob.selectOptionalCoverage();
		lob.clickNext();
		lob.clickNext();
		lob.clickYesOrNo();
		lob.clickRateButton();
		lob.clickBtnContinuerating();
//		premium.verifyPremiumValue();
	}

	@Given("^I enetr the location details for RCIS \"([^\"]*)\"$")
	public void LobDetailsrcs(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
			System.out.println("My username is:" + data.get(1).get(0).toString());
		}
		locationPage.enetrDesc(data.get(1).get(0).toString());
		locationPage.clickLobGR();
		locationPage.clickNextToLobDetails();
		lob.selectLobLossRate(data.get(1).get(2).toString());
		lob.selLossFreeYears(data.get(1).get(2).toString());
		lob.clickNext();
		lob.clickPolicyType();
		lob.searchLiability();
		lob.selectLiability();
		lob.selectLiabilityLimit();
		lob.selectPIPSymbol();
		lob.selectAddPIPSymbol();
		// lob.selectMedPaySym();
		lob.clickNoFleet();
		lob.clickLossRate(data.get(1).get(2).toString());
		// lob.selectSRMPolicy();
		lob.clickNextBttn();
		Thread.sleep(2000);
		lob.clickNext();
		lob.selectCitySearch();
		lob.selectCityCode();
		// lob.selectMedPayments();
		lob.clickNext();
		lob.clickNext();
		lob.expand();
		Thread.sleep(3000);
		lob.selectCitySearch1();
		lob.enterEmployeeFullTime();
		lob.clickNext();
		lob.clickNext();
		lob.clickVehicleNoRadio();
		lob.clickDriverNoRadio();
		lob.clickNext();
		lob.clickEligibilityRate();

	}

	@Given("^I enetr the location details \"([^\"]*)\"$")
	public void LobDetail(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
			System.out.println("My username is:" + data.get(1).get(0).toString());
		}
		locationPage.enetrDesc(data.get(1).get(0).toString());
		locationPage.clickLobGR();
		locationPage.clickNextToLobDetails();
		// lob.selectLobLossRate(data.get(1).get(2).toString());
		// lob.selLossFreeYears(data.get(1).get(2).toString());
		// lob.clickNext();
		lob.clickPolicyType();
		lob.searchLiability();
		lob.selectLiability();
		lob.selectLiabilityLimit();
		lob.selectPIPSymbol();
		lob.selectAddPIPSymbol();
		// lob.selectMedPaySym();
		lob.clickNoFleet();
		lob.clickLossRate(data.get(1).get(2).toString());
		// lob.selectSRMPolicy();
		lob.clickNextBttn();
		Thread.sleep(2000);
		lob.clickNext();
		lob.selectCitySearch();
		lob.selectCityCode();
		// lob.selectMedPayments();
		lob.clickDeductible();
		lob.enterBrdPip();

	}

	@Then("^I verify that the pip panel field validation are as expecetd for the Brd panel and Deductible field$")
	public void StateInputScreenValiation(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		lob.clickDeductible();

	}

}
