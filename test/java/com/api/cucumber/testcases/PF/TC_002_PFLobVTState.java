package com.api.cucumber.testcases.PF;

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
import com.api.cucumber.pages.PFPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

//To validate the Group A state scan edits validation for PF LOB VT state
public class TC_002_PFLobVTState extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	PFPage pf = new PFPage(driver);



	@Given("^login as Employee for CLAS \"([^\"]*)\"$")
	public void enterLoginDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		login
		.enterUserName(data.get(1).get(0).toString())
		.enterPassword(data.get(1).get(1).toString())
		.clickLoginBtnInSLT()
		//.clickGo()
		.selectBuisnessIssue()
		.enterAccName(data.get(1).get(2).toString())
		.clickNext()
		.clickYesOrNo();
	}

	@Given("^Select state VT with effective date from jan 10,2019 \"([^\"]*)\"$")
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
		.enterMailAddrs2(data.get(1).get(6).toString())
		.enterZipCode1(data.get(1).get(7).toString())
		.enterZipCode2(data.get(1).get(8).toString())
		.enterCity(data.get(1).get(9).toString())
		.selectMailState(data.get(1).get(10).toString())
		.enterPhoneAreaCode(data.get(3).get(0).toString())
		.enterPhoneExchange(data.get(3).get(1).toString())
		.enterPhoneLastDigits(data.get(3).get(2).toString())
		.clickRadioBtnNewToAgency()
		.enterPreminumSize(data.get(3).get(3).toString())
		.enterEffectDate(data.get(3).get(4).toString())
		.selectApplicablePolicy()
		.clickNext()
		.clickNextToPolDet();
	}
	@And("^PF LOB with Market segment is Emergency services and Insurance company is Selective Insurance Company of South Carolina from data at \"([^\"]*)\"$")
	public void policyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.enterYear(data.get(3).get(5).toString())
		.selectrMarketSegment(data.get(3).get(6).toString())
		.selectInsComp(data.get(3).get(7).toString())
		.findListOfInsComp()
		.selectLOBPF()
		.selectSICCoide(data.get(3).get(8).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(3).get(9).toString())
		.clickNext()
		.clickNextButton();
	}

	@And("^Navigate to LOB details page and enable loss free years dropdown \"([^\"]*)\"$") 
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
		.selLossFreeYears(data.get(5).get(0).toString());
		pf
		.selPLExtnOptions(data.get(5).get(1).toString());
	}

	
	@And("^Select Greenpac and Crisis response coverage are available , Electronic media coverage is NOT available$")
	public void policyCoverage(){
		pf
		.selectCrisisResponse()
		.selectCRBIEE()
		.selectGreenPac()
		.selectGreenPacICLmt()
		.selectGreenPacSCLmt();
	}
	@And("^Navigate to City/Help county information$")
	public void navigateToCity(){
		lobPage
		.clickNextButton();
	}

	@Then("Verify Basic Group 1 Territory, Special Territory, is set  to  001 \"([^\"]*)\"$")
	public void cityInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.checkPFBasicGrp1(data.get(5).get(2).toString())
		.checkPfSpecTerr1(data.get(5).get(3).toString());
		pf
		.selectConstruction(data.get(5).get(4).toString());
	}



}
