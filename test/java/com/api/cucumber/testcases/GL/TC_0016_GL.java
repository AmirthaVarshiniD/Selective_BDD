package com.api.cucumber.testcases.GL;

import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
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


public class TC_0016_GL extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	com.api.cucumber.pages.ComLinesAutoSysPage comLine= new com.api.cucumber.pages.ComLinesAutoSysPage(driver);
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);

	//To validate the GL state scan edits validation for GL LOB FL state
	@And("for AL as predominant state effective from jan 1,2019 \"([^\"]*)\"$")
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
		.enterMailAddrs2(data.get(1).get(6).toString())
		.enterZipCode1(data.get(1).get(7).toString())
		.enterZipCode2(data.get(1).get(8).toString())
		.selectMailState(data.get(1).get(9).toString())
		.enterCity(data.get(3).get(0).toString())
		.enterPhoneAreaCode(data.get(3).get(1).toString())
		.enterPhoneExchange(data.get(3).get(2).toString())
		.enterPhoneLastDigits(data.get(3).get(3).toString())
		.clickRadioBtnNewToAgency()
		.enterPreminumSize(data.get(3).get(4).toString())
		.enterEffectDate(data.get(3).get(5).toString())
		.selectApplicablePolicy()
		.clickNext()
		.clickNextToPolDet()
		.enterNatureOfBus(data.get(3).get(6).toString())
		.enterYear(data.get(3).get(7).toString())
		.enterOwnership(data.get(3).get(8).toString())
		.selectrMarketSegment(data.get(3).get(9).toString())
		.selectInsComp(data.get(5).get(0).toString());
	}
	@And("LOB GL,PH selected")
	public void selectLoB() throws Throwable
	{
		policyDetails
		.selectLOBGL()
		.selectLOBPH();
	}
	@Then("Cycurity LOB should not be available in Policy details screen")
	public void verifyLobsCycurity()
	{
		lobPage
		.clickPolicyDetails()
		.clickEdit()
		.verifyLobs("Cycurity");
	}

	@Then("Cycurity LOB should be available in Policy details screen for selection")
	public void verifyLobsCycurityAvail()
	{
		lobPage
		.clickPolicyDetails()
		.clickEdit()
		.verifyLobAvail("Cycurity");
	}

	@And("for DE state effective from jan 1,2019 \"([^\"]*)\"$")
	public void selectState(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
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
		.selectMultiState()
		.enterMailAddrs1(data.get(1).get(5).toString())
		.enterMailAddrs2(data.get(1).get(6).toString())
		.enterZipCode1(data.get(1).get(7).toString())
		.enterZipCode2(data.get(1).get(8).toString())
		.selectMailState(data.get(1).get(9).toString())
		.enterCity(data.get(3).get(0).toString())
		.enterPhoneAreaCode(data.get(3).get(1).toString())
		.enterPhoneExchange(data.get(3).get(2).toString())
		.enterPhoneLastDigits(data.get(3).get(3).toString())
		.clickRadioBtnNewToAgency()
		.enterPreminumSize(data.get(3).get(4).toString())
		.enterEffectDate(data.get(3).get(5).toString())
		.selectApplicablePolicy()
		.clickNext()
		.clickNextToPolDet()
		.enterNatureOfBus(data.get(3).get(6).toString())
		.enterYear(data.get(3).get(7).toString())
		.enterOwnership(data.get(3).get(8).toString())
		.selectrMarketSegment(data.get(3).get(9).toString())
		.selectInsComp(data.get(5).get(0).toString());
	}
	@And("for MN state effective from jan 1,2019 \"([^\"]*)\"$")
	public void selectPredState(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
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
		.enterMailAddrs2(data.get(1).get(6).toString())
		.enterZipCode1(data.get(1).get(7).toString())
		.enterZipCode2(data.get(1).get(8).toString())
		.selectMailState(data.get(1).get(9).toString())
		.enterCity(data.get(3).get(0).toString())
		.enterPhoneAreaCode(data.get(3).get(1).toString())
		.enterPhoneExchange(data.get(3).get(2).toString())
		.enterPhoneLastDigits(data.get(3).get(3).toString())
		.clickRadioBtnNewToAgency()
		.enterPreminumSize(data.get(3).get(4).toString())
		.enterEffectDate(data.get(3).get(5).toString())
		.selectApplicablePolicy()
		.clickNext()
		.clickNextToPolDet()
		.enterNatureOfBus(data.get(3).get(6).toString())
		.enterYear(data.get(3).get(7).toString())
		.enterOwnership(data.get(3).get(8).toString())
		.selectrMarketSegment(data.get(3).get(9).toString())
		.selectInsComp(data.get(5).get(0).toString());
	}
	@And("AL added as secondary state and Rate \"([^\"]*)\"$")
	public void rateGLLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectSICCoide(data.get(5).get(1).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(2).toString())
		.clickNext()
		.clickNextInPolicyDetailsPage()
		.enterBillingDesc(data.get(5).get(3).toString())
		.clickLOBTab()
		.clickAddLocation()
		.enterBillingDesc(data.get(5).get(3).toString())
		.clickLOBTab()
		.enterAddress(data.get(7).get(0).toString())
		.selectState(data.get(7).get(1).toString())
		.clickButtonSearch()
		.enterCity(data.get(7).get(2).toString())
		.clickSearch()
		.clickSearchResult()
		.clickSelect()
		.clickNextToLobDetails()
		.selGeneralAggregate()
		.selLossFreeYears(data.get(5).get(4).toString())
		.selLossRatedPolicy(data.get(5).get(5).toString())
		.clickNext()
		.selExtnOptions(data.get(5).get(6).toString())
		.clickNextBttn()
		.enterClassCodeSLT(data.get(5).get(7).toString())
		.enterPremiumBasis(data.get(5).get(8).toString())
		.clickLocationOverrides()
		.enterBaseRate(data.get(5).get(9).toString())
		.enterDocumentation(data.get(5).get(3).toString())
		.enterBaseRte(data.get(5).get(9).toString())
		.enterDocumentations(data.get(5).get(3).toString())
		.enterFillingIndicator(data.get(7).get(3).toString())
		.enterPremiumBasisr(data.get(7).get(3).toString())
		.enterRateBasis(data.get(7).get(3).toString())
		.clickNextButton()
		//.enterTerritory("007")
		//		/.clickNextButton()
		//.clickNextButton()
		.enterClassCodeSLT(data.get(5).get(7).toString())
		.enterPremiumBasis(data.get(5).get(8).toString())
		.clickLocationOverrides()
		.enterBaseRate(data.get(5).get(9).toString())
		.enterDocumentation(data.get(5).get(3).toString())
		.enterBaseRte(data.get(5).get(9).toString())
		.enterDocumentations(data.get(5).get(3).toString())
		.enterFillingIndicator(data.get(7).get(3).toString())
		.enterPremiumBasisr(data.get(7).get(3).toString())
		.enterRateBasis(data.get(7).get(3).toString())
		.clickNextButton()
		.clickRate()
		.clickBtnContinuerating();
	}

	@And("Verify whether the user is able to rate the policy successfully with GL and PH LOB \"([^\"]*)\"$")
	public void rate(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectSICCoide(data.get(5).get(1).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(2).toString())
		.clickNext()
		.clickNextInPolicyDetailsPage()
		.enterBillingDesc(data.get(5).get(3).toString())
		.clickLOBTab()
		.clickNextToLobDetails()
		.selGeneralAggregate()
		.selLossFreeYears(data.get(5).get(4).toString())
		.selLossRatedPolicy(data.get(5).get(5).toString())
		.clickNext()
		.selExtnOptions(data.get(5).get(6).toString())
		.clickNextBttn()
		.enterClassCodeSLT(data.get(5).get(7).toString())
		.enterPremiumBasis(data.get(5).get(8).toString())
		.clickLocationOverrides()
		.enterBaseRate(data.get(5).get(9).toString())
		.enterDocumentation(data.get(5).get(3).toString())
		.enterBaseRte(data.get(5).get(9).toString())
		.enterDocumentations(data.get(5).get(3).toString())
		.enterFillingIndicator(data.get(7).get(0).toString())
		.enterPremiumBasisr(data.get(7).get(0).toString())
		.enterRateBasis(data.get(7).get(0).toString())
		.clickNextButton()
		.clickNextButton()
		.selOccuranceLmt(data.get(7).get(1).toString())
		.selClassCode(data.get(7).get(2).toString())
		.enterExposure(data.get(7).get(3).toString())
		.selDeductible(data.get(7).get(4).toString())
		.clickNextButton()
		.clickRate()
		.clickBtnContinuerating();
	}








}
