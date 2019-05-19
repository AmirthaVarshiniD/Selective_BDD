package com.api.cucumber.testcases.MiniLines;

import java.util.List;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.ComLinesAutoSysPage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class TC_Agent_Flow extends ProjMethods {
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policy = new PolicyDetailsPage(driver);
	LobDetailsPage lob = new LobDetailsPage(driver);
	LocationsPage locationPage = new LocationsPage(driver);
	ComLinesAutoSysPage common = new ComLinesAutoSysPage(driver);
	PremiumSummaryPage premium = new PremiumSummaryPage(driver);

	@When("^I enter the Account details as agent for the quote from \"([^\"]*)\"$")
	public void enetrAccountDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
			System.out.println("My username is:" + data.get(1).get(0).toString());
		}
		accInfo.selectPredState(data.get(1).get(3).toString()).selectMultiState()
				.enterMailAddrs1(data.get(1).get(4).toString()).enterMailAddrs2(data.get(1).get(6).toString())
				.enterZipCode1(data.get(1).get(5).toString()).enterPhoneAreaCode(data.get(1).get(7).toString())
				.enterPhoneExchange(data.get(1).get(8).toString()).enterPhoneLastDigits(data.get(1).get(9).toString())
				.clickRadioBtnMailStatus().clickRadioBtnNewToAgency().enterPreminumSize(data.get(1).get(10).toString())
				.enterEffectDate(data.get(1).get(11).toString()).enterExpectDate()
				.choosePolicy(data.get(1).get(17).toString()).clickNext();
		Thread.sleep(3000);

	}

	@Given("^I enter the policy and lob details as agent by selecting Gl lob from \"([^\"]*)\"$")
	public void enterPolicyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
			System.out.println("My username is:" + data.get(1).get(0).toString());
			
		}
		policy.selectBuisnessType(data.get(1).get(21).toString());
		policy.enterYear(data.get(1).get(12).toString());
		policy.enterNatureOfBus();
		policy.selectOwnership(data.get(1).get(20).toString());
			if (data.get(1).get(21).toString().equals("OTHER")) {
				policy
				.selectLOBs(data.get(1).get(19))
//				.selectMarijuanaQuest()
						.selectPriorCarrier(data.get(1).get(16).toString());
				lob.clickNext();
				policy.selectrMarketSegment(data.get(1).get(13).toString());
//				policy.selectLOBs(data.get(1).get(19));
				policy.selectSICCoide(data.get(1).get(13).toString());
				lob.clickNext();
				Thread.sleep(2000);
				lob.clickNext();
			} else {
				policy.selectLOBs(data.get(1).get(19)).selectMarijuanaQuest()
						.selectPriorCarrier(data.get(1).get(16).toString());
				lob.clickNext();
				Thread.sleep(2000);
				lob.clickNext();

			}

	}

	@Given("^I enter the location details and rate the policy as agent for GL lob from \"([^\"]*)\"$")
	public void enterLoctaiondetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
			System.out.println("My username is:" + data.get(1).get(0).toString());
		}
		locationPage.enetrDesc(data.get(1).get(22).toString());
		locationPage.clickLob();
		Thread.sleep(1000);
		locationPage.clickNextToLobDetails();
		Thread.sleep(2000);
		lob.selectAggrLimit();
		lob.selLossFreeYears(data.get(1).get(22).toString());
		lob.clickNext();
		Thread.sleep(2000);
		lob.selExtnOptions1();
		lob.clickNext();
		lob.classCode("10100");
		lob.enterPremiumBasics(data.get(1).get(23).toString());
		lob.clickNext();
		lob.clickRateButton();
		Thread.sleep(2000);
		lob.clickNext();
		premium.verifyPremiumValue();
		common.clickDashboardLink();
	}

}
