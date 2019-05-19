package com.api.cucumber.testcases.IR;

import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.ComLinesAutoSysPage;
import com.api.cucumber.pages.InlandMarinePages;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

//To validate the Group A state scan edits validation for PF LOB VT state
public class TC001_IR extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	InlandMarinePages ir = new InlandMarinePages(driver);
	ComLinesAutoSysPage com = new ComLinesAutoSysPage(driver);





	@And("^Selecting IM LOB \"([^\"]*)\"$")
	public void policyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBInlandMarine()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickNextButton()
		.enterBillingDesc(data.get(5).get(1).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}
	@And("^Selecting multi LOB's \"([^\"]*)\"$")
	public void selMulLobs(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBInlandMarine()
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
	@And("^Selecting IM LOB with Terrorism Exclusion \"([^\"]*)\"$")
	public void policyDetailsTerrExclusion(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBInlandMarine()
		.selectSICCoide(data.get(3).get(10).toString())
		.clickTerrorismExcl()
		.selTerrExclQuestYes()
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickNextButton()
		.enterBillingDesc(data.get(5).get(1).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}
	@And("^Select IM LOB \"([^\"]*)\"$")
	public void selIMLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBInlandMarine()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickNextButton();
	}
	@And("^Select IM LOB in Policy Details page \"([^\"]*)\"$")
	public void selIMLobinPolicyDtails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBInlandMarine()
		.selectSICCoide(data.get(3).get(10).toString())
		//.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickNextButton();
	}
	@And("^Selecting IM LOB in Agent \"([^\"]*)\"$")
	public void selLobIMInAgent(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBInlandMarine()
		//.selectSICCoide(data.get(3).get(10).toString())
		//.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickNextButton()
		.enterBillingDesc(data.get(5).get(1).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}
	@When("^in Policy Level coverages \"([^\"]*)\"$")
	public void lobDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.verfyPolicyCoverages(data.get(7).get(3).toString())
		.clickNextCoverages();
	}
	@Then("^Verify Physicians and Surgeons Black Bag Coverage is not available \"([^\"]*)\"$")
	public void verifyCoverages(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.verfyPolicyCoverages(data.get(7).get(3).toString())
		.clickNext()
		.clickYes()
		.clickOkBtn();
	}
	@When("^in Location level coverages \"([^\"]*)\"$")
	public void verifyLocCoverages(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir	
		.clickLocationInfo()
		.clickLocationInfo()
		//.enterProtectionClass(data.get(7).get(4).toString())
		.selectConstruction(data.get(7).get(5).toString())
		.selectRateType(data.get(7).get(6).toString())
		.selectBGSymbol(data.get(7).get(7).toString())
		.enterClassCode(data.get(7).get(8).toString())
		.clickNextToCoverages()
		.clickNextToCoverages()
		.verfyLocCoverages(data.get(7).get(3).toString());
	}
	@Then("^Verify Physicians and Surgeons Black Bag Coverage is available \"([^\"]*)\"$")
	public void verifyPhysSECovAvail(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir	
		.clickPhysicianSurEqu()
		.clickPSeDeductible()
		.verifyDeductibleFactor()
		.enterPSLimit(data.get(7).get(9).toString())
		.clickNext();
	}
	@And("^Verify Rating Worksheet \"([^\"]*)\"$")
	public void verifyRatingWorksheet(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.clickRate();
		premiumPage
		.clickRatingWorkSheet("PHYSICIANS")
		.clickClose();
	}
	public void verifyPremmiumWithoutCov(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		premiumPage
		.clickInlandMarine()
		.cliclEditInlandMarineLOB()
		.clickNextCoverages()
		.clickNext()
		.clickNextToCoverages()
		.clickPhysicianSurEqu()
		.clickYesBtn()
		.clickEquipDealer()
		.clickEdit()
		.selectClassCode(data.get(9).get(7).toString())
		.enterEquipDepositPrem(data.get(9).get(3).toString())
		.enterPremiumBase(data.get(9).get(4).toString())
		.enterRate(data.get(9).get(5).toString())
		.clickRate();
	}
	@And("^Verify Quote Proposal \"([^\"]*)\"$")
	public void verifyQuoteProposal(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		premiumPage
		.clickQuoteProposal();
		//.clickCreateQuoteProposal();
		//.verifyQuoteProposal("PHYSICIANS");
	}
	@When("^Moving to Locatin Coverages$")
	public void navToLocCov()
	{
		ir
		.clickNextCoverages()
		.clickNext();
	}


	@When("^NBIS created with coverage Equipment Dealers \"([^\"]*)\"$")
	public void checkClassCode(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickNextCoverages()
		.clickNext()
		.clickBttnYes()
		.clickOkBtn()
		.clickCityOverride()
		.enterBasicGrpTerritory("001")
		.enterMisc("1")
		.clickLocationInfo()
		.selectConstruction(data.get(7).get(5).toString())
		.selectRateType(data.get(7).get(6).toString())
		.selectBGSymbol(data.get(7).get(7).toString())
		//.clickNextToCoverages()
		.enterClassCode(data.get(7).get(8).toString())
		.clickNextToCoverages()
		.clickNextToCoverages()
		.clickEquipDealer()
		.clickEdit()
		.clickNext()
		//.clickPolicyWideCovInfoIcon()
		//.clickBtnClose()
		.selectClassCode(data.get(9).get(6).toString())
		.enterInsideBuild(data.get(7).get(10).toString())
		.enterOutsideBuild(data.get(9).get(0).toString())
		//.enterPropInTransit(data.get(9).get(1).toString())
		.clickNext()
		.clickRate();
	}
	@When("^NBIS created without coverage Equipment Dealers \"([^\"]*)\"$")
	public void createPolicyWithoutCov(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickNextCoverages()
		.clickNext()
		.clickYes()
		.clickOkBtn()
		.clickLocationInfo()
		.selectConstruction(data.get(7).get(5).toString())
		.selectRateType(data.get(7).get(6).toString())
		.selectBGSymbol(data.get(7).get(7).toString())
		//.clickNextToCoverages()
		.enterClassCode(data.get(7).get(8).toString())
		.clickNextToCoverages()
		.clickNextToCoverages()
		.clickPhysicianSurEqu()
		.clickPSeDeductible()
		.enterPSLimit(data.get(7).get(9).toString())
		//.clickEquipDealer()
		//.clickEdit()
		//.clickNext()
		.clickNext();
		lobPage
		//.clickNextToPremiumSum()
		.clickRate()
		;
		premiumPage
		.clickNextToFinalizePolicy()
		.clickYesQues1()
		.clickNextToEligibilityResults()
		.clickNextToBilling()
		.selectDirectBill()
		.selectPayPlan(data.get(9).get(8).toString())
		.clickNewBillAccount()
		.clickNext()
		.clickNext()
		.clickNext()
		.clickNextToCommission()
		.clickNextToMarketSizeInfo()
		.clickNextToSpecialClaims()
		.clickNextToDSS()
		.clickNextToForms()
		.clickReviewIssue()
		.clickIssue()
		.enterName(accountName)
		.clickEndorse()
		.enterEffcDate(data.get(11).get(4).toString())
		.enterTransDesc(data.get(1).get(6).toString())
		.enterReceivedDate(data.get(11).get(5).toString())
		.clickNext()
		.clickLobDetails()
		.clickEditDetails()
		.clickNextCoverages()
		.clickNext()
		.clickNextToCoverages()
		.clickEquipDealer()
		.clickEdit()
		//.clickNext()
		.selectClassCode(data.get(9).get(6).toString())
		.clickEdDeductibleTxt()
		.clickEdDeductibleValue();
	}
	@Then("^View Policy$")
	public void viewPolicy()
	{
		premiumPage
		.clickExiTToDashBoard()
		.enterName(accName);
		com
		.clickView()
		.clickLobDetails()
		//		/.clickOkBttn()
		;
	}
	@Then("^View Issued Policy$")
	public void viewIssuedPolicy()
	{
		com
		.enterName(accName)
		.clickView();
		com
		.clickTxnNewBuisnessIssue()
		//clickRenewalIssuePolicy
		.clickPremmiumSummary()
	;
	}
	@Then("^View Renewal Policy$")
	public void viewRenewalPolicy()
	{
		com
		.enterName(accName)
		.clickViewARPolicy();
		com
		.clickRenewalIssuePolicy()
		.clickPremmiumSummary()
	;
	}
@And("^Issue REIS Policy$")
public void issueRenewalPolicy()
{
	premiumPage
	.clickNextToFinalizePolicy()
	.clickCommission()
	.clickDss()
	.clickReviewIssue()
	.clickIssue()
	;
}
	@Then("^View Auto Renewal Policy$")
	public void ViewARPolicy()
	{
		premiumPage
		.clickExiTToDashBoard()
		.enterName(accName);
		com
		.clickViewARPolicy()
		.clickRenewalIssuePolicy()
		.clickLobDetails()
		//		/.clickOkBttn()
		;
	}
	@When("^Class code 235 is selected \"([^\"]*)\"$")
	public void selectClassCode(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		premiumPage
		.clickInlandMarine()
		.cliclEditInlandMarineLOB()
		.clickNextCoverages()
		.clickNext()
		.clickNextToCoverages()
		.clickEdit()
		.selectClassCode(data.get(9).get(7).toString())
		.enterEquipDepositPrem(data.get(9).get(3).toString())
		.enterPremiumBase(data.get(9).get(4).toString())
		.enterRate(data.get(9).get(5).toString())
		.clickRate();
	}
	@Then("^Verify Minimum premium \"([^\"]*)\"$")
	public void checkPremium(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		premiumPage		
		.verifyPremmiumSummary(data.get(9).get(2).toString());
	}
	@And("^Verify Information Help Icon for Policy Wide Coverage \"([^\"]*)\"$")
	public void verifyInfoIcon(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		premiumPage
		.clickInlandMarine()
		.cliclEditInlandMarineLOB()
		.clickNextCoverages()
		.clickNext()
		.clickNextToCoverages()
		.clickEdit()
		.clickPolicyWideCovInfoIcon()
		.clickBtnClose()
		;
	}
	@And("^Issue Policy \"([^\"]*)\"$")
	public void issuePolicy(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		premiumPage
		.clickNextToFinalizePolicy()
		.clickYesQues1()
		.clickNextToEligibilityResults()
		.clickNextToBilling()
		.selectDirectBill()
		.selectPayPlan(data.get(9).get(8).toString())
		.clickNewBillAccount()
		.clickNext()
		.clickCommission()
		//.clickNextToCommission()
		.clickNextToMarketSizeInfo()
		.clickNextToSpecialClaims()
		.clickNextToDSS()
		//.clickNextToForms()
		.clickReviewIssue()
		.clickNoinAgencyCode()
		.clickIssue()
		//.clickNoBtn()
		.enterName(accName);
	}
	@And("^Issue GL Policy \"([^\"]*)\"$")
	public void issueGlPolicy(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		premiumPage
		.clickNextToFinalizePolicy()
		.clickYesQues1()
		.clickNextToEligibilityResults()
		.clickNextToBilling()
		.selectDirectBill()
		.selectPayPlan(data.get(9).get(8).toString())
		.clickNewBillAccount()
		.clickNext()
		//		/.clickCommission()
		.clickCommission()
		//.clickNextToCommission()
		.clickNextToMarketSizeInfo()
		.clickNextToSpecialClaims()
		.clickNextToDSS()
		.clickNextToSocialServicesEmployeeInfo()
		.enterTxtPaidEmployees("10")
		.enterTxtVolunteers("5")
		.clickNextToDocumentation()
		.clickReturnToLob()
		.clickReviewIssue()
		.clickNoinAgencyCode()
		.clickIssue()
		.clickNoBtn()
		.enterName(accName);
	}
	@Then("^Issue PF Policy \"([^\"]*)\"$")
	@And("^Issue COP Policy \"([^\"]*)\"$")
	public void issueCopPolicy(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		premiumPage
		.clickNextToFinalizePolicy()
		.clickYesQues1()
		.clickNextToEligibilityResults()
		.clickNextToBilling()
		.selectDirectBill()
		.selectPayPlan(data.get(9).get(8).toString())
		.clickNewBillAccount()
		.clickNext()
		.clickNext()
		.clickNext()
		.clickNextToCommission()
		.clickNextToMarketSizeInfo()
		.clickNextToSpecialClaims()
		.clickNextToDSS()
		.clickNextToForms()
		//.clickReviewIssue()
		.clickNext()
		.clickNoinAgencyCode()
		.clickNotePad()
		.clickChkBxSafetyMangAnalysis()
		.enterSurveyContact("TEST")
		.clickChkBxSafetyMangNotNeeded()
		.selReason("Other")
		.enterTxtDate("TEST")
		.clickNoSafetyMangService()
		.clickOrderSafetyMang()
		.enterSafetyMangContact("TEST")
		.enterProducerName("TEST")
		.clickLoc()
		.clickOrderSurvey()
		.clickReturnToLob()
		.clickIssue()
		.enterName(accName);
	}
	@Then("^Renew New Buisness Policy$")
	public void renewPolicy()
	{
		com
		.clickRenewal()
		.clickOk()
		.clickNextToPolicyDet()
		.clickOkButton()
		.clickLobDetails();
	}
	@Then("^Perform Auto Renewal$")
	public void autoRenewPolicy() throws InterruptedException
	{
		com
		.getPolicyNo()
		.clickUWCenter()
		.clickRenewalBatchJob()
		.enterPolicyNumber(policyNo)
		.enterTransactionSerial("01")
		.clickExecute()
		.clickClose()
		;
	}
	@And("^Endorse Policy \"([^\"]*)\"$")
	public void endorsePolicy(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		com
		.clickEndorse()
		.enterEffcDate(data.get(11).get(4).toString())
		.enterTransDesc(data.get(1).get(6).toString())
		.enterReceivedDate(data.get(11).get(5).toString())
		.clickNext()
		.clickLobDetails()
		;
	}
	@Then("^Perform Void Endorsement$")
	public void performVoidEndorsement()
	{
		com
		.enterName(accName)
		.clickVoidEndorsement()
		.clickOK()
		;
	}
	@And("^Verify user can enter valid values \"([^\"]*)\"$")
	public void enterValuesInPropNotAtPremises(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.cliclEditInlandMarineLOB()
		.clickNextCoverages()
		.clickNext()
		.clickNextToCoverages()
		.clickEdit()
		.enterEquipPropNotAtYourPremise(data.get(9).get(9).toString())
		.clickNext()
		.clickBack()
		.enterEquipPropNotAtYourPremise(data.get(9).get(10).toString())
		.clickNext()
		.clickBack()
		.enterEquipPropNotAtYourPremise(data.get(11).get(0).toString())
		.clickNext()
		.clickBack();
	}
	@But("^Verify user is not allowed to enter values zero,negative values,decimal values and error message \"([^\"]*)\"$")
	public void checkPropNotAtPremVal(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.enterEquipPropNotAtYourPremise(data.get(11).get(1).toString())
		.clickNext();
	}
	@And("^Verify Property Not at your Premises is not a mandatory Field \"([^\"]*)\"$")
	public void checkPropNotAtPremValMan(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir

		.clearEquipPropNotAtYourPremises()
		.clickNext()
		.clickBack();
	}

	@Then("^Verify Reporting Period and Reporting Premium Adjustment is Not available for Class code (\\d+) \"([^\"]*)\"$")
	public void verifyReportingNotAvail(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.verifyReportingNotAvailInPolicyCovInfo(data.get(10).get(2).toString())
		.verifyReportingPremAdjNotAvail(data.get(11).get(6).toString());
	}
	@And("^Verify Reporting Period & Reporting Premium Adjustment field is available for Class code (\\d+) \"([^\"]*)\"$")
	public void verifyReportingAvail(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.selectClassCode(data.get(9).get(7).toString())
		.selectReportingPeriod(data.get(10).get(3).toString())
		.selectReportingPreAdj(data.get(11).get(7).toString())
		;
	}

	@When("^User selects Policy Level Coverages Contractors,Golf,MAchinery \"([^\"]*)\"$")
	public void policyCoverages(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickNextCoverages()
		.clickContractorsEquipment()
		//.clickGolfMaintenanceEquipment()
		//.clickMiscPropTools()
		//.clickMachineryEquipment()
		.clickEdit();
	}
	@When("^User selects Policy Level Coverages Contractors \"([^\"]*)\"$")
	public void policyCovGolf(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickNextCoverages()
		.clickContractorsEquipment()
		//.clickGolfMaintenanceEquipment()
		//.clickMiscPropTools()
		//.clickMachineryEquipment()
		.clickEdit();
	}

	@And("^Navigation to Location level Coverages screen$")
	public void clickNoPolicyCov()
	{
		ir
		.clickNextCoverages()
		.clickNext()
		;
	}
	@When("^User adds Contractors Equipment coverage \"([^\"]*)\"$")
	public void covContractsEquip(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.enterScheduledPropDesc(data.get(5).get(2).toString())
		.enterLimitOfInsurance(data.get(5).get(3).toString())
		/*.clickChkBxEquLeasedRented()
		.enterEquLeasedRentedPerItem(data.get(5).get(4).toString())
		.enterTotalEquLimit(data.get(5).get(4).toString())
		.selectType()
		.enterRentalFeeRate(data.get(5).get(5).toString())
		.enterDepositPrem(data.get(5).get(6).toString())
		.clickContractorsEquipRentalReimbursmnt()
		.enterPerDayLimit(data.get(5).get(7).toString())
		.enterTotalRemntalLimit(data.get(5).get(8).toString())
		.enterRentalRate(data.get(5).get(8).toString())
		.enterPremium(data.get(5).get(8).toString())
		//.clickChkBxContEquBuisIncExtraExpense()
		//.clickChkBxLossEnd()
		//.clickChkBxReggrLiab()*/
		.clickNext();
	}
	@When("^Adding Golf Maintenance Coverage \"([^\"]*)\"$")
	public void covGolfMaintenance(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.enterScheduledPropDesc(data.get(5).get(2).toString())
		.enterLimitOfInsurance(data.get(5).get(3).toString())
		.clickOk()
		.clickChkBxEquLeasedRented()
		.clickOk()
		.enterEquLeasedRentedPerItem(data.get(5).get(4).toString())
		.enterTotalEquLimit(data.get(5).get(4).toString())
		//.selectType()
		//.enterLeasedRentalExpFees(data.get(5).get(5).toString())
		.enterDepositPrem(data.get(5).get(6).toString())
		.clickGolfMaintenanceRentReim()
		.clickOk()
		.enterGolfPerDayLimit(data.get(5).get(9).toString())
		.enterGolfTotalRemntalLimit(data.get(5).get(10).toString())
		.enterPremium(data.get(5).get(8).toString())
		.clickNext();
	}
	@When("^Adding Machinery Equipment Coverage \"([^\"]*)\"$")
	public void covMachineryEquip(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickScheduleME()
		.enterScheduledPropDesc(data.get(5).get(2).toString())
		.enterLimitOfInsurance(data.get(5).get(3).toString())
		.enterRateMachEquip("3.0")
		//.clickMESchDeductible()
		//.clickUnScheduleME()
		//.enterMEUnSchedulePropDesc(data.get(7).get(0).toString())
		//.enterMEUnScheduledLimit(data.get(7).get(1).toString())
		//.enterMEOneItemLimit(data.get(7).get(2).toString())
		//.enterRateUnScMachEquip("3.0")
		.clickNext()
		;
	}
	@When("^Adding Location class code Information \"([^\"]*)\"$")
	public void locClassCodeInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickBttnYes()
		.clickOkBtn()
		.clickCityOverride()
		.enterProtectionClass("9")
		.enterBasicGrpTerritory("001")
		.enterMisc("1")
		.clickLocationInfo()
		.selectConstruction(data.get(7).get(5).toString())
		.selectRateType(data.get(7).get(6).toString())
		.selectBGSymbol(data.get(7).get(7).toString())
		//.clickNextToCoverages()
		.enterClassCode(data.get(7).get(8).toString())
		.clickNextToCoverages()
		.selectPrometrixSchedule()
		.enterClassCode(data.get(7).get(8).toString())
		.enterPrometrixOverRideReason("TEST")
		.clickNextToCoverages();
	}
	@When("^Adding Location Information \"([^\"]*)\"$")
	public void locInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		//.clickCityOverride()
		.enterBasicGrpTerritory("001")
		.enterMisc("1")
		.clickLocationInfo()
		;
	}
	@When("^Add Location class code Information \"([^\"]*)\"$")
	public void locaClassCodeInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickBttnYes()
		//.clickOkBtn()
		.clickCityOverride()
		.enterBasicGrpTerritory("001")
		.enterMisc("1")
		.clickLocationInfo()
		.selectConstruction(data.get(7).get(5).toString())
		.selectRateType(data.get(7).get(6).toString())
		.selectBGSymbol(data.get(7).get(7).toString())
		//.clickNextToCoverages()
		.enterClassCode(data.get(7).get(8).toString())
		.clickNextToCoverages()
		.clickNextToCoverages();
	}
	@When("^Adding Location class code Information for Other Loc \"([^\"]*)\"$")
	public void locClassCodeInfoFrOtherLoc(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickBttnYes()
		//.clickOkBtn()
		//.clickSearch()
		//.clickCityOverride()
		//.enterBasicGrpTerritory("001")
		//.enterMisc("1")
		.clickLocationInfo()
		.selectConstruction(data.get(7).get(5).toString())
		.selectRateType(data.get(7).get(6).toString())
		.selectBGSymbol(data.get(7).get(7).toString())
		.enterClassCode(data.get(7).get(8).toString())
		.clickNextToCoverages()
		.selectPrometrixSchedule()
		.enterClassCode(data.get(7).get(8).toString())
		.enterPrometrixOverRideReason("TEST")
		.clickNextToCoverages()
		;
	}
	@When("^Adding Location class code Information for Loc \"([^\"]*)\"$")
	public void locClassCodeInfoFrLoc(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickBttnYes()
		.clickOkBtn()
		//.clickSearch()
		//.clickCityOverride()
		//.enterBasicGrpTerritory("001")
		//.enterMisc("1")
		.clickLocationInfo()
		.selectConstruction(data.get(7).get(5).toString())
		.selectRateType(data.get(7).get(6).toString())
		.selectBGSymbol(data.get(7).get(7).toString())
		.enterClassCode(data.get(7).get(8).toString())
		.clickNextToCoverages()
		.selectPrometrixSchedule()
		.enterClassCode(data.get(7).get(8).toString())
		.enterPrometrixOverRideReason("TEST")
		.clickNextToCoverages()
		;
	}
	@When("^Adding Location class code Information for Other Location \"([^\"]*)\"$")
	public void locClassCodeInfoFrOtherLocation(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickBttnYes()
		.clickOkBtn()
		.clickSearch()
		//.clickCityOverride()
		//.enterBasicGrpTerritory("001")
		//.enterMisc("1")
		.clickLocationInfo()
		.selectConstruction(data.get(7).get(5).toString())
		.selectRateType(data.get(7).get(6).toString())
		.selectBGSymbol(data.get(7).get(7).toString())
		.enterClassCode(data.get(7).get(8).toString())
		.clickNextToCoverages()
		//.selectPrometrixSchedule()
		.enterClassCode(data.get(7).get(8).toString())
		.enterPrometrixOverRideReason("TEST")
		.clickNextToCoverages()
		;
	}
	@When("^Adds location coverage Equipment Dealers \"([^\"]*)\"$")
	public void locCoverages(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickEquipDealer()
		.clickEdit()
		.selectClassCode(data.get(9).get(6).toString())
		.enterInsideBuild(data.get(7).get(10).toString())
		.enterOutsideBuild(data.get(9).get(0).toString())
		//.enterPropInTransit(data.get(9).get(1).toString())
		.clickNext();
	}
	@When("^Adds location coverage Camera Dealers \"([^\"]*)\"$")
	public void locCovCameraDealers(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		ir
		.clickCameraDealer()
		.selectCameraDealersClassCode()
		.enterPremiumCamDealers("10000")
		.clickCamDealersDeductible();
		//.clickNext();
	}
	@And("^Navigating to Location Coverages$")
	public void navToLocCoverages() {
		ir
		.clickNextToCoverages()
		;
	}

	@And("^Rate policy$")
	public void rate() {
		ir
		.clickRate()
		.clickBtnContinuerating()
		.getPremmiumSummary()
		;
	}

	@And("^Navigating to Other LOB$")
	public void navigateNext() {
		ir
		.clickNextToInlandMarine()
		;
	}
	@And("^Rate REIS policy$")
	public void ratePol() {
		ir
		.clickCityOverride()
		.clickCityOverride()
		.enterBasicGrpTerritory("001")
		.enterMisc("1")
		.clickLocationInfo()
		.clickRate();
		//premiumPage
		//.clickBtnContinuerating()
		//;
	}
	@Then("^Verify Rating WorkSheet$")
	public void clickRatingWorkSheet() throws InterruptedException
	{
		premiumPage
		.checkRatingWorkSheet();
	}
	@And("^Verify Quote Proposal$")
	public void checkQuoteProposal()
	{
		premiumPage
		.clickQuoteProposal()
		.clickCreateQuoteProposal()
		.verifyQuoteProposal()
		;
	}
	@Then("^Verify IRPM field is enabled in Pricing screen$")
	public void checkPricing() throws InterruptedException
	{
		premiumPage
		.clickPricing()
		.checkIrpmEnabled("0.750")
		.clickRate()
		.clickRate()
		.clickPricing()
		.cleraIrpm()
		.clickRate()
		;
	}
	@And("^Verify Schedule IRPM field in Pricing screen$")
	public void checkIRPMPricing() throws InterruptedException
	{
		premiumPage
		.clickPricing()
		.checkIrpmEnabled("0.650")
		.clickRate()

		.checkIrpmEnabled("1.650")
		.clickRate()

		.checkIrpmEnabled("1")
		.clickRate()
		;
	}
	@And("^Verify IRPM field is not enabled in Pricing screen$")
	public void checkPricingNotEnabl() throws InterruptedException
	{
		premiumPage
		.clickPricing()
		.checkIrpmEnabled("0.750")
		.clickRate()
		.clickRate()
		.clickRate()
		//.clickRate()
		.cleraIrpm()
		//.checkError()
		.clickRate()
		//.clickRate()
		;
	}
	@And("^Verify IRPM is not enabled in Pricing screen$")
	public void checkPricingNotEnabled() throws InterruptedException
	{
		premiumPage
		.clickPricing()
		//.checkIrpmNotEnable()
		.clickRate()
		;
	}
	@Then("^Delete Coverages$")
	public void deleteCoverages()
	{
		ir
		.cliclEditInlandMarineLOB()
		.clickNextCoverages()
		.clickContractorsEquipment()
		.clickBttnYes()
		//.clickGolfMaintenanceEquipment()
		//.clickMiscPropTools()
		//.clickBttnYes()
		.clickNext()
		;
	}
	@Then("^Delete Location Level Coverages$")
	public void deleteLocCoverages()
	{
		ir
		.clickNextToCoverages()
		.clickCameraDealer()
		.clickBttnYes()
		;
	}
	@Then ("^Add Coverages$")
	public void addCoverages()
	{
		ir
		.cliclEditInlandMarineLOB()
		.clickNextCoverages()
		//.clickContractorsEquipment()
		.clickMiscPropTools()
		.clickMachineryEquipment()
		.clickEdit()
		;
	}
	@And ("^Edit Inland Marine LOB$")
	public void editIR()
	{
		ir
		.cliclEditInlandMarineLOB()
		.clickNextCoverages()
		.clickContractorsEquipment()
		//.clickMiscPropTools()
		//.clickMachineryEquipment()
		.clickEdit()
		;
	}
	@And("^User Navigates to next Coverage$")
	public void navNextCov() {
		ir
		.clickNext();
	}

}
