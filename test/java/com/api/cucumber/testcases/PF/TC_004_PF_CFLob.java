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

//Given PF LOB with Selective Insurance Company of South East effective  10/01/19 and market segment as Goverm,ental
public class TC_004_PF_CFLob extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	PFPage pf = new PFPage(driver);



	@Given("^start the application and login as Employee for CLAS from \"([^\"]*)\"$")
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




	@And("Check we do not have records  related to Special contractors and Summit Contractors under market segment dropdown")
	public void checkMSDropdown()
	{
		policyDetails
		.checkDropDownValue("Special Contractors")
		.checkDropDownValue("Summit Contractor");
	}
	@And("^Select Insurance company \"([^\"]*)\"$")
	public void selectInsComp(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectInsComp(data.get(3).get(7).toString())
		.selectLOBPF();
		//.selectLOBCF();
	}



	@And("^Validate whether Tax District field is enabled on CF PolicyInput screen under City/Count ifnromation screen when CityHelp Override is not checked$")
	public void verifyTaxtDistrictField(){
		if(!driver.findElementById("chkCityOverride").isSelected()){
			lobPage
			.checkTaxDistrictFieldIsEnabled();	
		}else{
			lobPage
			.checkTaxDistrictFieldIsEnabled();
		}
	}
	@And("^Navigate to policy details tab and choose Golf facilites as Market Segment \"([^\"]*)\"$") 
	public void navToPolicyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.enterClassCode(data.get(1).get(23).toString())
		.enterProtectionClass("01");
		pf
		.selectConstruction(data.get(1).get(24).toString())
		.enterYearBuilt(data.get(1).get(25).toString())
		.selectBuildingRateType(data.get(1).get(26).toString());
		lobPage
		.clickPolicyDetails()
		.clickEdit()
		.selectrMarketSegment(data.get(1).get(14).toString())
		.selectSICCoide(data.get(1).get(16).toString())
		.clickNext()
		.clickNextButton()
		.clickNextToLobDetails()
		.clickOk()
		.clickEditOnPolicyInfo();
	}
	@Then("Verify Club professional Coverage is available")
	public void verifyCoverage()
	{
		pf
		.verifyClubProf()
		.clickClubProf();

	}


}
