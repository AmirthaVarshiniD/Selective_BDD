/*package com.api.cucumber.testcases.BOP;

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

//Given PF LOB with Selective Insurance Company of South East effective  10/01/19 and market segment as Goverm,ental
public class TC_013_BOP extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);




	@Given("^SLT login \"([^\"]*)\"$")
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
		.selectBuisnessIssue()
		.enterAccName(data.get(1).get(2).toString())
		.clickNext()
		.clickYesOrNo();
	}

	@And("^Account info \"([^\"]*)\"$")
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
		//.enterCity(data.get(3).get(0).toString())
		//.selectMailState(data.get(1).get(9).toString())
		.enterPhoneAreaCode(data.get(3).get(1).toString())
		.enterPhoneExchange(data.get(3).get(2).toString())
		.enterPhoneLastDigits(data.get(3).get(3).toString())
		.selectEmailAsNone()
		.clickRadioBtnNewToAgency()
		.enterPreminumSize(data.get(3).get(4).toString())
		.enterEffectDate(data.get(3).get(5).toString())
		.selectApplicablePolicy()
		.clickNext()
		.clickNextToPolDet();
	}
	@Then("^BOP lob details \"([^\"]*)\"$")
	public void policyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.enterNatureOfBus(data.get(3).get(6).toString())
		.enterYear(data.get(3).get(7).toString())    
		.enterOwnership(data.get(3).get(8).toString())
		.selectrMarketSegment(data.get(3).get(9).toString())
		.selectInsComp(data.get(5).get(0).toString())
		.selectLOBBOP()
		.selectSICCoide(data.get(5).get(1).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(2).toString())
		.clickNext()
		.clickNextButton()
		.enterBillingDesc(data.get(5).get(3).toString())
		.clickLOBTab()
		.clickNextToLobDetails()
		.enterGovClassCodeinSLT(data.get(5).get(4).toString())
		.selCoverageOption(data.get(5).get(5).toString())
		.selBopClaims(data.get(5).get(6).toString())
		.selLossFreeYears(data.get(5).get(7).toString())
		.clickNext()
		.clickNext()
		.clickNext()
		//.enterSwProtectionClass(data.get(5).get(8).toString())
		.enterBuildingLmt(data.get(5).get(9).toString())
		.enterBPPLmt(data.get(7).get(0).toString())
		//.clickApplyGovClassCode()
		.clickHabitExposureYes()
		.enterHabPercent(data.get(7).get(1).toString())
		.enterHabUnits(data.get(7).get(2).toString())
		.clickhabHWYes()
		.clickGreaseCookinNo()
		.enterYrBuilt(data.get(7).get(3).toString())
		.enterBuildingPercent(data.get(7).get(4).toString())
		.enterBuildingUnits(data.get(7).get(5).toString())
		.enterSales(data.get(7).get(6).toString())
		.selectBuildConstruction(data.get(7).get(7).toString())
		.enterStories(data.get(7).get(8).toString())
		.clickCitySerachBtn()
		.clickCityHelpSearch()
		.clickNext()
		.selectBuildAddrs()
		.enterYrBuilt(data.get(7).get(3).toString())
		.enterProMetrixYrBuiltOverride(data.get(7).get(9).toString())
		.enterProMetrixSquareOverride(data.get(7).get(9).toString())
		.enterProMetrixSprinklerOverride(data.get(7).get(9).toString())
		.enterProMetrixConstructionOverride(data.get(7).get(9).toString())
		.enterProMtrxNoStoriesOverride(data.get(7).get(9).toString())
		.clickAltPowergenYes()
		.clickSWEBAltPowerPhoto()
		.clickSWEBAltPowerFuel()
		.clickAutoFire()
		.clickNext()
		.enterDateCompleted(data.get(3).get(5).toString())
		.clickUpdate()
		.clickNext()
		.clickYes()
		.clickNext()
		.selectPropertyType("Dependent Property")
		.clickNext()
		.enterHSBPremium("2500")
		.clickNext()
		.clickRate()
		.clickBtnContinuerating();

	}

}
*/