package com.api.cucumber.testcases.GL;

import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;


public class TC_009_GL_NC_TN extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	com.api.cucumber.pages.ComLinesAutoSysPage comLine= new com.api.cucumber.pages.ComLinesAutoSysPage(driver);
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);

	//To validate the GL state scan edits validation for GL LOB NC, TN state



	@Given("^Select Multi state with effective date from jan 10,2019 \"([^\"]*)\"$")
	public void clickCLAS(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		accInfo
		.enterAgentCode(data.get(1).get(3).toString())
		.selectPredState(data.get(1).get(4).toString())
		.selectMultiState()
		.enterMailAddrs1(data.get(1).get(5).toString())
		.enterMailAddrs2(data.get(1).get(6).toString())
		.enterZipCode1(data.get(1).get(7).toString())
		.enterZipCode2(data.get(1).get(8).toString())
		//.enterCity(data.get(1).get(9).toString())
		//.selectMailState(data.get(1).get(10).toString())
		.enterPhoneAreaCode(data.get(3).get(0).toString())
		.enterPhoneExchange(data.get(3).get(1).toString())
		.enterPhoneLastDigits(data.get(3).get(2).toString())
		.selectEmailAsNone()
		.clickRadioBtnNewToAgencyNo()
		.enterPreminumSize(data.get(3).get(3).toString())
		.enterEffectDate(data.get(3).get(4).toString())
		.selectCPP()
		.clickNext()
		.clickNextToPolDet()
		.enterNatureOfBus(data.get(3).get(5).toString())
		.getQuoteNo()
		.enterYear(data.get(3).get(6).toString())    
		.enterOwnership(data.get(3).get(7).toString())
		.selectrMarketSegment(data.get(3).get(8).toString())
		.selectInsComp(data.get(3).get(9).toString());
	}
	@And("^location added for TN state from excel at \"([^\"]*)\"$")
	public void selectmarketSeg(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBGL()
		.selectSICCoide(data.get(1).get(16).toString())
		.selectPriorCarrier(data.get(1).get(17).toString())
		.clickNext()
		.clickNextButton()
		.enterBillingDesc(data.get(1).get(18).toString())
		.clickLOBTab()
		.clickAddLocation()
		.enterBillingDesc(data.get(1).get(18).toString())
		.clickLOBTab()
		.enterAddress(data.get(1).get(34).toString())
		.selectState(data.get(1).get(32).toString())
		.clickButtonSearch()
		.enterCity(data.get(1).get(33).toString())
		.clickSearch()
		.clickSearchResult()
		.clickSelect()
		.clickNextToLobDetails();
	}


	@And("^Enter GL class code NC state & TN State from excel at \"([^\"]*)\"$")
	public void glLobDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.selGeneralAggregate()
		.selLossFreeYears(data.get(1).get(19).toString())
		.selLossRatedPolicy(data.get(1).get(31).toString())
		.clickNext()
		.selExtnOptions(data.get(1).get(20).toString())

		.clickNextBttn()
		.enterClassCodeSLT(data.get(1).get(23).toString())
		.enterPremiumBasis(data.get(1).get(35).toString())
		.clickOptionalPac()
		.checkOptionalCoveragesForBroadFormProducts()
		.clickNextButton()
		.enterBaseRates(data.get(1).get(36).toString())
		//.clickBtnNext()
		.enterDescription("TEXT")
		.enterFillingIndicator("1")
		.enterRateBasis("1")
		.clickNextButton();
	}

	@Then("^Broad Form Products optional coverage should be available in optional coverages screen from excel at \"([^\"]*)\"$")
	public void checkOptionalCovOptions(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage

		.enterClassCodeinSLT(data.get(1).get(37).toString())
		.enterPremiumBasis(data.get(1).get(35).toString())
		.clickOptionalPac()
		.checkOptionalCoveragesForBroadFormProducts()
		.clickNextButton()
		.clickRate();

	}


}
