package com.api.cucumber.testcases.COP;

import java.util.List;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.COpLObPages;
import com.api.cucumber.pages.ComLinesAutoSysPage;
import com.api.cucumber.pages.FinalizePolicyPage;
import com.api.cucumber.pages.InlandMarinePages;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PFPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//To validate the Group A state scan edits validation for PF LOB VT state
public class TC001_COp extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	InlandMarinePages ir = new InlandMarinePages(driver);
	COpLObPages cop = new COpLObPages(driver);
	ComLinesAutoSysPage com = new ComLinesAutoSysPage(driver);
	PFPage pf = new PFPage(driver);
	FinalizePolicyPage finalPage = new FinalizePolicyPage(driver);
	
	@And("^Selecting COP LOB \"([^\"]*)\"$")
	public void policyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBCop()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickNextButton();
	}
	@And("^Add Location \"([^\"]*)\"$")
	public void addLoc(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		locPage
		.enterBillingDesc(data.get(5).get(1).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}
	@And("^Add Multi Location \"([^\"]*)\"$")
	public void selectmarketSeg(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		locPage
		.clickBtnNo()
		.enterBillingDesc(data.get(5).get(1).toString())
		.clickLOBTab()
		.clickAddLocation()
		.enterBillingDesc(data.get(5).get(1).toString())
		.clickLOBTab()
		.enterAddress(data.get(11).get(10).toString())
		.selectState(data.get(11).get(8).toString())
		.clickButtonSearch()
		.enterCity(data.get(11).get(9).toString())
		.clickSearch()
		.clickSearchResult()
		.clickSelect()
		.clickNo()
		.clickNo()
		.clickNextToLobDetails();
	}

	@And("^Add Other Location for FL during Renewal \"([^\"]*)\"$")
	public void addOtherLoc(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		com
		.clickRenewal()
		.clickOk()
		.clickNextToPolicyDet()
		.clickNext()
		.clickNext();
		//.clickNextToLobDetails();
		locPage
		.clickAddNewLocation()
		.enterBillingDesc(data.get(5).get(1).toString())
		.clickLOBTab()
		.enterAddress(data.get(11).get(10).toString())
		.selectState(data.get(11).get(8).toString())
		.clickButtonSearch()
		.enterCity(data.get(11).get(9).toString())
		.clickSearch()
		.clickSearchResult()
		.clickSelect()
		.clickNo()
		.clickNextToLobDetails();
	}
	@And("^Add Other Location \"([^\"]*)\"$")
	public void addLocation(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		premiumPage
		.clickLocations()
		.clickAddNewLocation()
		.enterBillingDesc(data.get(5).get(1).toString())
		.clickLOBTab()
		.enterAddress(data.get(11).get(10).toString())
		.selectState(data.get(11).get(8).toString())
		.clickButtonSearch()
		.enterCity(data.get(11).get(9).toString())
		.clickSearch()
		.clickSearchResult()
		.clickSelect()
		.clickNo()
		.clickNextToLobDetails();
	}
	@Then("^Verify Habitational is not displayed in the category dropdown \"([^\"]*)\"$")
	public void verifyCategoryInNbis(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		cop
		.checkDdlCategory(data.get(5).get(6).toString())
		.clickCancel()
		.clickExitToDashBoard();
	}
	@When("^Perform Requote \"([^\"]*)\"$")
	public void verifyCategoryInReQuote(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		com	
		.enterName(accName)
		.clickNewBuisnessLogUpdate()
		.clickUpdateStatus()
		.selNewStatus(data.get(5).get(4).toString())
		.selStatus(data.get(5).get(5).toString())
		.clickReturnToDetail()
		.clickReturnToDashBoard();
	}
	@And("^Requote \"([^\"]*)\"$")
	public void checkRequote(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		com	
		.enterName(accName)
		.clickRequote()
		.clickRadioBtnNewToAgency()
		.enterEffectDate(data.get(3).get(4).toString())
		.clickNextToPolicyDet();
		accInfo
		.clickNextToPolDet()
		.clickNext()
		.clickLobDetails();


	}
	@When("^View Quote$")
	public void verifyCategoryInViewQuote()
	{

		com
		.enterQuoteNo()
		.clickView()
		.clickLobDetails();
	}
	@And("^Cancel Policy \"([^\"]*)\"$")
	public void cancelPolicy(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		com
		.enterName(accName)
		.clickCancellation()
		.clickButtonOk()
		.enterEffectiveDate(data.get(1).get(0).toString())
		.selectDdlHowToCancel(data.get(1).get(1).toString()) // Pro-rata Short rate Flat
		.selectDdlReason(data.get(1).get(2).toString()) //Non payment //Not wanted - Insured's request
		.enterReceivedDate(data.get(1).get(3).toString())
		.clickRate()

		;
	}
	@And("^Cancel Renewal Policy \"([^\"]*)\"$")
	public void cancelRenewalPolicy(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		com
		.enterName(accName)
		.clickCancelOnRenewalPolicy()
		.clickButtonOk()
		.enterEffectiveDate(data.get(1).get(0).toString())
		.selectDdlHowToCancel(data.get(1).get(1).toString()) // Pro-rata Short rate Flat
		.selectDdlReason(data.get(1).get(2).toString()) //Non payment //Not wanted - Insured's request
		.enterReceivedDate(data.get(1).get(3).toString())
		.clickRate()

		;
	}
	@And("^Issue Cancel and Reinstate Policy$")
	public void issueCancelReinstatePolicy()
	{
		premiumPage
		.clickNextToFinalizePolicy()
		.clickIssue()
		;
	}
	
	@And("^Reinstate Policy$")
	public void reinstatePolicy()
	{
		com
		.enterName(accName)
		.clickReinstate()
		.clickRate()
		;
	}
	@And("^Issue Endorse Policy$")
	public void issueEndorsePolicy()
	{
		premiumPage
		.clickNextToFinalizePolicy()
		.clickForms()
		.clickChangeNarrative()
		.clickReturnFormsProcessing()
		.clickReviewIssue()
		.clickIssue()
		;
	}
	@And("^Issue Endorse PF Policy$")
	public void issueEndorsePFPolicy()
	{
		premiumPage
		.clickNextToFinalizePolicy()
		.clickForms()
		.clickChangeNarrative()
		.clickReturnFormsProcessing()
		.clickCommission()
		.clickDocumentation()
		.clickAdd()
		.selDdlLob("PROPERTY")
		.clickPropertyIrpm()
		.clickNext()
		.clickReturnToCreditDebitSummary();
		finalPage
		.clickReturnToLob()
		;
		finalPage
		.clickReviewIssue()
		.clickIssue()
		;
	}
	@Then("^Verify Classification Dropdown \"([^\"]*)\"$")
	@And("^Select Category \"([^\"]*)\"$")
	public void selCategory(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		cop
		.selectCategory(data.get(5).get(2).toString())
		.selectClassification(data.get(5).get(3).toString())
		.clickChkBxNetWorth()
		.clickChkBxNetRevenue()
		.clickNext();
	}

	@Then("^Verify Error Message$")
	public void verifyErrorMessage() {
		cop
		.checkErrMsg();
	}
	
	@Then("^Verify Error Message in Location Screen$")
	public void verifyErrorMsgInLocScreen() {
		cop
		.checkErrMsgINLoc();
	}
	@And("^Delete Location$")
	public void delete()
	{
		locPage
		.clickDelete()
		.clickBtnYes()
		.clickNextToLobDetails()
		.clickLobDetails()
		;
	}
	@And("^Verify Property is not Selected$")
	public void VerifyPFNotSelected()
	{
		locPage
		.checkPF()
		.clickNextToLobDetails()
		.clickCancel()
		;
		locPage
		.clickLOBTab()
		.clickNextToLobDetails()
		.clickLobDetails()
		;
	}
	@And("^Navigate to Property LOB$")
	public void clickNextToProperty()
	{
		pf
		.clickNextToProperty()
		;
	}
	@And("^User enters coverage Information \"([^\"]*)\"$")
	public void enterCovInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		cop	
		.selectConstruction(data.get(5).get(7).toString())
		.enterNoOfStories(data.get(5).get(8).toString())
		.enterYearBuilt(data.get(5).get(9).toString())
		.clickNext()
		.clickYesInMainLocInd()
		.enterBuildInsuredLimit(data.get(5).get(10).toString())
		.clickNext()
		.clickNext();
	}
	@And("^User enters coverage Information for other Location \"([^\"]*)\"$")
	public void enterCovInfoForOtherLoc(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		cop	
		.selectConstruction(data.get(5).get(7).toString())
		.enterNoOfStories(data.get(5).get(8).toString())
		.enterYearBuilt(data.get(5).get(9).toString())
		.clickNext()
		.clickNext()
		//.clickYesInMainLocInd()
		.enterBuildInsuredLimit(data.get(5).get(10).toString())
		.clickNext()
		.clickNext();
	}

	@And("^Rate Policy \"([^\"]*)\"$")
	public void ratePolicy(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		cop	
		/*.clickYesInITVCal()
		.clickITVgo()
		.enterGrossFloorArea(data.get(6).get(0).toString())
		.clickNext()
		.clickNext()*/
		.selBlanketType(data.get(7).get(1).toString())
		.clickNext()
		.clickPower()
		.clickNext()
		.clickNext()
		.clickChkBxDisasterExp()
		.clickChkBxClimaticalHazards()
		.clickSpclOccupancyhazards()
		.clickLackOfPrivateProt()
		.clickEarthMovement()
		.clickInadequatePubPro()
		.clickWaterDamage()
		.clickLowerDeductible()
		.clickCombSusceptibility()
		.clickTransitFloatingEquip()
		.clickConstruction()
		.clickExternalExp()
		.clickArrangementOfSpecIns()
		.enterDesc()
		.clickCalculate()
		.clickRate()
		.clickContRating()
		;
	}
	@When("^User Change class for Health Care category \"([^\"]*)\"$")
	@And("^Change category to Habitational \"([^\"]*)\"$")
	public void changeCategory(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		cop
		.clickEditCopLob()
		.selectCategory(data.get(7).get(2).toString())
		.selectClassification(data.get(7).get(3).toString())
		.clickNext();
	}

}
