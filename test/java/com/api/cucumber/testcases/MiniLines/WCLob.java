package com.api.cucumber.testcases.MiniLines;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.api.cucumber.comMethods.CommonMethods;
import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.ComLinesAutoSysPage;
import com.api.cucumber.pages.DashboardPage;
import com.api.cucumber.pages.EnterNamePage;
import com.api.cucumber.pages.FinalizePolicyPage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class WCLob extends ProjMethods {
	CommonMethods commonMenthods = new CommonMethods();
	LoginPage2 login = new LoginPage2();
	LocationsPage locationPage = new LocationsPage(driver);
	LobDetailsPage lob = new LobDetailsPage(driver);
	PremiumSummaryPage premium = new PremiumSummaryPage(driver);
	DashboardPage dashBoard = new DashboardPage(driver);
	EnterNamePage name = new EnterNamePage(driver);
	ComLinesAutoSysPage com = new ComLinesAutoSysPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	FinalizePolicyPage finalize = new FinalizePolicyPage(driver);

	@When("^I enter the Account details for the quote fro WC policy from \"([^\"]*)\"$")
	public void accountDetailsWCLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		accInfo.enterAgentCode(data.get(1).get(0).toString()).selectPredState(data.get(1).get(1).toString())
				.selectMultiState().enterMailAddrs1(data.get(1).get(2).toString())
				.enterMailAddrs2(data.get(1).get(4).toString()).enterZipCode1(data.get(1).get(3).toString())
				.enterPhoneAreaCode(data.get(1).get(5).toString()).enterPhoneExchange(data.get(1).get(6).toString())
				.enterPhoneLastDigits(data.get(1).get(7).toString()).clickRadioBtnMailStatus()
				.clickRadioBtnNewToAgency().enterPreminumSize(data.get(1).get(9).toString())
				.enterEffectDate(data.get(1).get(9).toString()).enterExpectDate()
				.choosePolicy(data.get(1).get(15).toString()).clickNext().clickNextToPolDet();
	}

	@When("^I enter the policy and lob details by selecting WC lob from \"([^\"]*)\"$")
	public void policyDetailsWCLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
		}

		policyDetails
		.enterNatureOfBus()
		.enterYear(data.get(1).get(10).toString())
		.selectOwnership(data.get(1).get(18).toString())
		.selectrMarketSegment(data.get(1).get(11).toString())
		.selectInsComp(data.get(1).get(12).toString())
		.findListOfInsComp().selectMarijuanaQuest()
		.selectSICCoide(data.get(1).get(13).toString())
		.selectPriorCarrier(data.get(1).get(14).toString());
		if (!(data.get(1).get(11).toString().equals("Mercantile")) && ((data.get(1).get(17).equals("GR")))) {
			lob.clickNext();
			lob.clickNext();
			lob.clickNextButton();
		} else {
			lob.clickNext();
			lob.clickNextButton();
		}
	}

	@Given("^I enter the loctaion details to create new issue \"([^\"]*)\"$")
	public void enterLoctaiondetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
//			/System.out.println(data.get(i).toString());
					}
		locationPage
		.enetrDesc(data.get(1).get(0).toString())
		.enterInsuredName()
		.enterFedId()
		.clickNextToLobDetails()
		.enterNoOfEmp()
		//.selectWCLossRate(data.get(1).get(2).toString())
		.clickNext()
		.enterNoOfEmpToLoctaion()
		.enterMaxNoOfEmpToLoctaion()
		.classCode("A")
		.enterPremiumBasicsWC(data.get(1).get(3).toString())
		.clickNext()
		.clickCoinsType()
		.clickNext()
		.clickRateButtonWC()
		;
		

	}

	@Given("^I issue the policy$")
	public void i_issue_the_policy() throws Throwable {
		premium.clickNextToFinalizePolicy();
		finalize.clickYesQues1();
		finalize.clickYesQues2();
		finalize.clickNextToEligibilityResults();
		finalize.clickNextToBilling();
		finalize.selectDirectBill();
		finalize.selectPayPlan("1 PAY");
		finalize.clickNewBillAccount();
		finalize.clickNext();
		finalize.clickNext();
		finalize.clickNext();
		finalize.clickNextToCommission();
		finalize.clickNextToMarketSizeInfo();
		finalize.clickNextToSpecialClaims();
		finalize.clickNextToDSS();
		finalize.clickNextToForms();
		finalize.clickNext();
		finalize.clickReviewIssue();
		com.clickNotepadLink();
		com.clickDocumentationTab();
		com.clickDashboardLink();

	}

}
