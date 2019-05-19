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


public class TC_007_GL extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	com.api.cucumber.pages.ComLinesAutoSysPage comLine= new com.api.cucumber.pages.ComLinesAutoSysPage(driver);
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);

	//To validate the GL state scan edits validation for GL LOB VT state


	@Given("^Start the application and login as Agent for CLAS with data from excel at \"([^\"]*)\"$")
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
	@And("GL LOB for VT state effective  10/01/19 with data from excel at \"([^\"]*)\"$")
	public void clickCLAS(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		comLine
		.clickGoinAgent()
		.enterAccName(data.get(1).get(2).toString())
		.clickNext()
		.clickYesOrNo()
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
		.selectCPPinAgent()
		.clickNext()
		.clickOk();
	}
	@And("^Marget segement is Contractors with data from excel at \"([^\"]*)\"$")
	public void selectmarketSeg(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectBuisnessType(data.get(1).get(30).toString())
		.enterNatureOfBus("TEST")
		.enterYear(data.get(1).get(13).toString())
		.selectLOBGL()
		.selectPriorCarrier(data.get(1).get(17).toString())
		.clickNext()
		.clickNextInPolicyDetailsPage()
		.enterBillingDesc(data.get(1).get(18).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}


	@And("Add Elitepac extension option as ElitePac Property Extension Endorsement with data from excel at \"([^\"]*)\"$")
	public void glLobDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.selGeneralAggregate()
		.selLossFreeYears(data.get(1).get(19).toString())
		.clickNext()
		.selExtnOptions(data.get(1).get(20).toString());
	}

	@Then("^Elitepac optional coverage should not be available in optional coverages screen$")
	public void checkOptionalCovOptions()
	{
		lobPage
		.checkOptionalCoverages();

	}


}
