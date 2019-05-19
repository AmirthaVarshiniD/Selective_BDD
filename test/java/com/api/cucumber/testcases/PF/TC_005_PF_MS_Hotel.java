package com.api.cucumber.testcases.PF;

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
import com.api.cucumber.pages.PFPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

//Given PF LOB with Selective Insurance Company of SouthEast  for VT state effective  10/01/19 and market segment as hotel
public class TC_005_PF_MS_Hotel extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	PFPage pf = new PFPage(driver);


	@Given("^start application and login as Employee for CLAS data at \"([^\"]*)\"$")
	public void enterLoginDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		login
		//.selectLogInAs("Employee")
		.enterUserName(data.get(1).get(0).toString())
		.enterPassword(data.get(1).get(1).toString())
		.clickLogin()
		.selectComLink()
		.clickGo()
		.enterAccName(data.get(1).get(2).toString())
		.clickNext()
		.clickYesOrNo();
	}



	@Given("^PF LOB with Selective Insurance Company of SouthEast  for VT state effective  Jan10,2019 from data \"([^\"]*)\"$")
	public void fillAccountInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		accInfo
		.enterAgentCode(data.get(1).get(3).toString())
		.selectPredState(data.get(1).get(4).toString())
		.enterMailAddrs1(data.get(1).get(5).toString())
		.enterZipCode1(data.get(1).get(6).toString())
		.enterZipCode2(data.get(1).get(7).toString())
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
	@And("^Market segment is Hotels with SIC Code 701106 \"([^\"]*)\"$")
	public void selectMarketSegment(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.enterYear(data.get(3).get(5).toString())
		.selectrMarketSegment(data.get(3).get(6).toString())
		.selectInsComp(data.get(3).get(7).toString())
		.selectLOBPF()
		.selectSICCoide(data.get(3).get(8).toString())
		.selectAdditionalCovgNO();
		//.selectMarijuanaQuest();
		
	}
	@And("^Navigate to LOB details \"([^\"]*)\"$") 
	public void lobDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		locPage
		.enterBillingDesc(data.get(3).get(10).toString())
		.clickLOBTab()
		.clickNextToLobDetails()
		.selLossFreeYears(data.get(1).get(19).toString());
		pf
		.selPLExtnOptions(data.get(1).get(20).toString());
	}



	@And("Check Club professional Optional Coverage is available")
	public void verifyOptionalCoverage()
	{
		pf
		.verifyClubProf()
		.clickNextBtn();
	}

	@And("Verify  Tax District field is enabled as CityHelp Override is not checked$")
	public void cityInfo()
	{		
		if(!driver.findElementById("chkCityOverride").isSelected()){
			lobPage
			.checkTaxDistrictFieldIsEnabled();	
		}
	}
	@When("Over ride the CityHelp")
	public void selectCityHelpOverride(){
		lobPage
		.clickCityHelpCheckBox();
	}

	@Then("Tax District field is NOT enabled  as CityHelp Override is checked")
	public void checkTaxDistisEnable(){

		if(driver.findElementById("chkCityOverride").isSelected()){
			lobPage
			.checkTaxDistrictFieldIsEnabled();	
		}
	}


}
