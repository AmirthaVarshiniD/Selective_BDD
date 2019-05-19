package com.api.cucumber.testcases.CF;

import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.FinalizePolicyPage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

/*Create a New Business policy and verify the following for the policy criteria mentioned :
1. Verify Whether the Tax district field on City/county section is enabled and it is of mandatroy field at both Policy level and Location level
2. Verify Territory code is fetched from the Cityhelp Service.*/


public class TC_012_CF_FL_CPP extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	FinalizePolicyPage finalizePage = new FinalizePolicyPage(driver);

	@Given("Login as Employee for State AL,CPP from \"([^\"]*)\"$")

	public void enterLoginDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		login
		.enterUserName(data.get(1).get(0).toString())
		.enterPassword(data.get(1).get(1).toString())
		.clickLoginBtnInSLT()
		.clickGo()
		//.selectBuisnessIssue()
		.enterAccName(data.get(1).get(2).toString())
		.clickNext()
		.clickYesOrNo();
	}

	@And("^Select LOB CF \"([^\"]*)\"$")
	public void selectCF(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBCF()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(7).get(9).toString())
		.clickNext()
		.clickNextButton();
		locPage
		.enterBillingDesc(data.get(7).get(10).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}
	@Given("^Select Market Segment and SIC Code \"([^\"]*)\"$")
	public void fillAccountInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.enterNatureOfBus(data.get(3).get(5).toString())
		//.getQuote()
		.enterYear(data.get(3).get(6).toString())    
		.enterOwnership(data.get(3).get(7).toString())
		.selectrMarketSegment(data.get(3).get(8).toString())
		.selectInsComp(data.get(3).get(9).toString())
		.selectLOBCF()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest();
	}
	@And("^Select CF LOB \"([^\"]*)\"$")
	public void policyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		
		.selectLOBCF()
		//.selectSICCoide(data.get(5).get(1).toString())
		//.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(2).toString())
		.clickNext()
		.clickNextButton()
		.enterBillingDesc(data.get(5).get(3).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}



	@And("^Navigate to LOB \"([^\"]*)\"$")
	public void lobDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.selCoverageType(data.get(5).get(2).toString())
		.clickCitySerachBtn()
		.clickNextBtn();
	}

	@Then("^Check Tax district field on City/county section is enabled and it is of mandatroy field at both Policy level and Location level \"([^\"]*)\"$")
	public void checkterritory(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		lobPage
		.clickLocationInfo()
		.enterClassCodeinSLT(data.get(5).get(3).toString())
		.clickCityOverRide()
		.clearTaxDistrict()
		.clickNextButton();
		//New Buisness issue - Commented for now
		/*.clickCoverageAggGuestProp()
		.enterCoverAggrGPIp(data.get(5).get(4).toString())
		.clickNextButton()
		.clickRate()
		.clickBtnContinuerating()
		.clickNextToFinalizePolicy()
		//.clickNext()
		.clickYesQues1()
		.clickYesQues2()
		.clickNextToEligibilityResults()
		//.clickNextToProducerAppointment()
		.clickNextToBilling()
		.selectDirectBill()
		.selectPayPlan(data.get(5).get(5).toString())
		.clickNewBillAccount()
		.clickNextButton()
		.clickNextButton()
		.clickNextButton()
		.clickNextToCommission()		
		.clickNextToMarketSizeInfo()
		.clickNextToSpecialClaims()
		.clickNextToDSS()
		.clickNextToForms();*/
	}
	@Then("^Check Tax district field is enabled & mandatroy field at both Policy level and Location level for Agent Login \"([^\"]*)\"$")
	public void checkTaxDistrict(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		lobPage
		.selCoverageType(data.get(5).get(4).toString())
		.clickCitySerachBtn()
		.clickNextBtn()
		.clickLocationInfo();
		/*.enterClassCodeinSLT(data.get(5).get(5).toString())
		.clickCoverageAggGuestProp()
		.enterCoverAggrGPIp(data.get(5).get(6).toString())
		.clickLocationInfo()
		.clickCityOverRide()
		.clearTaxDistrict()
		.clickNextButton();*/
	}

	//Not needed

	/*.clickExiTToDashBoard()
		.clickNoBtn()
		.enterQuoteNo();*/

	/*lobPage
		.clickLocationInfo()
		.clickCityOverRide()
		.clearTaxDistrict()
		//.clickCoverageAggGuestProp()
		//		/.enterCoverAggrGPIp()
		.clickNextButton();*/
	//.enterTaxDistrict()
	//.clickNextButton()
	/*.clickRate()
		.clickBtnContinuerating()
		.clickExiTToDashBoard()
		.selectQuote();
		policyDetails
		.clickNext()
		.clickNextButton()
		.clickEditLocation()
		.clickNextToLobDetails()
		.clickEditCF()
		.clickCitySerachBtn()
		.clickNextBtn();
		lobPage
		.clickLocationInfo()
		.clickNextButton()
		.enterTaxDistrict()
		.clickNextButton();*/






}
