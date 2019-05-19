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

//To validate the Group C state scan edits validation for PF LOB VT state for Market segment as Contractors
public class TC_006_PF_MS_Contractors extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	PFPage pf = new PFPage(driver);


	@Given("^Login as Employee for CLAS from data at \"([^\"]*)\"$")
	public void enterLoginDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		login
		//.selectLogInAs("Employee")
		.enterUserName(data.get(1).get(0).toString())
		.enterPassword(data.get(1).get(1).toString())
		.clickLoginBtnInSLT()
		//.selectComLink()
		.clickGo()
		.enterAccName(data.get(1).get(2).toString())
		.clickNext()
		.clickYesOrNo();
	}


	@And("Market segment is Contractors from data at \"([^\"]*)\"$")
	public void selectMarketSegment(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectrMarketSegment(data.get(1).get(14).toString())
		.selectInsComp(data.get(1).get(15).toString())
		.selectLOBPF()
		.selectSICCoide(data.get(1).get(16).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(1).get(17).toString())
		.clickNext()
		.clickNextButton()
		.enterBillingDesc(data.get(1).get(18).toString())
		.clickLOBTab()
		.clickNextToLobDetails()
		.selLossFreeYears(data.get(1).get(19).toString());
	}
	@And("Add Elitepac coverage as SelectPac Property Extension Endorsement from data at \"([^\"]*)\"$")	
	public void selectElitePac(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selPLExtnOptions(data.get(1).get(20).toString())
		.clickNextBtn();
		lobPage
		.enterClassCode(data.get(1).get(23).toString());
		pf
		.selectConstruction(data.get(1).get(24).toString())
		.enterYearBuilt(data.get(1).get(25).toString())
		.selectBuildingRateType(data.get(1).get(26).toString())
		.clickNextBtn();
		
	}
	@Then("^Verify Cause of loss gets defaulted to Special Other for Business Income - Education institutions and Business Income with Extra Expense coverages$")
	public void verifyCauseOfLoss()
	{
		lobPage
		.selectBuisnessIncEduIns()
		.clickEditonBusIncEduIns()
		.clickFirstResult()
		.clickEditonBusIncEduIns()
		.verifyCauseOfLossOnBIEI()
		.clickCancel()
		.selectBuisnessIncExtraExp()
		.clickEditonBusIncExtraExp()
		.verifyCauseOfLossOnBIEE();
	}



}
