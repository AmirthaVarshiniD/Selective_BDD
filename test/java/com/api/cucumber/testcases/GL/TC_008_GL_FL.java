package com.api.cucumber.testcases.GL;

import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;


public class TC_008_GL_FL extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	com.api.cucumber.pages.ComLinesAutoSysPage comLine= new com.api.cucumber.pages.ComLinesAutoSysPage(driver);
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);

	//To validate the GL state scan edits validation for GL LOB FL state
	@Given("^Login as Employee and click new buisness issue \"([^\"]*)\"$")
	public void enterLoginDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		login
		.enterUserName(data.get(1).get(0).toString())
		.enterPassword(data.get(1).get(1).toString())
		.clickLoginBtnInSLT();
	}




	@Given("^Select state FL with effective date \"([^\"]*)\"$")
	public void clickCLAS(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		comLine
		.selectBuisnessIssue()
		.enterAccName(data.get(1).get(2).toString())
		.clickNext()
		.clickYesOrNo()
		.enterAgentCode(data.get(1).get(3).toString())
		.selectPredState(data.get(1).get(4).toString())
		.enterMailAddrs1(data.get(1).get(5).toString())
		.enterMailAddrs2(data.get(1).get(27).toString())
		.enterZipCode1(data.get(1).get(6).toString())
		.enterZipCode2(data.get(1).get(7).toString())
		.enterCity(data.get(1).get(28).toString())
		.selectMailState(data.get(1).get(29).toString())
		.enterPhoneAreaCode(data.get(1).get(8).toString())
		.enterPhoneExchange(data.get(1).get(9).toString())
		.enterPhoneLastDigits(data.get(1).get(10).toString())
		.clickRadioBtnNewToAgency()
		.enterPreminumSize(data.get(1).get(11).toString())
		.enterEffectDate(data.get(1).get(12).toString())
		.selectApplicablePolicy()
		.clickNext()
		.clickNextToPolDet();
	}
	@And("^GL LOB with Marget segement is Office \"([^\"]*)\"$")
	public void selectmarketSeg(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.enterNatureOfBus("TEST")
		.enterYear(data.get(1).get(13).toString())
		.enterOwnership("CORPORATION")
		.selectrMarketSegment(data.get(1).get(14).toString())
		.selectInsComp(data.get(1).get(15).toString())
		.selectLOBGL()
		.selectSICCoide(data.get(1).get(16).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(1).get(17).toString())
		.clickNext()
		.clickNextButton()
		.enterBillingDesc(data.get(1).get(18).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}
	@And("^Select GL Lob \"([^\"]*)\"$")
	public void selLobGl(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBGL()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickNextButton()
		.enterBillingDesc(data.get(5).get(1).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}
		

	
	@And("Add Elitepac extension option as ElitePac Property Extension Endorsement \"([^\"]*)\"$")
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
		.selExtnOptions(data.get(1).get(20).toString());
	}

	@Then("^Verify Elitepac optional coverage is not available in optional coverages screen$")
	public void checkOptionalCovOptions()
	{
		lobPage
		.checkOptionalCoverages();

	}


}
