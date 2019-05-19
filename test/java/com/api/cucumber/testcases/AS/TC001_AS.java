package com.api.cucumber.testcases.AS;

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
import com.api.cucumber.pages.FinalizePolicyPage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

//To validate the Group A state scan edits validation for PF LOB VT state
public class TC001_AS extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	ComLinesAutoSysPage com = new ComLinesAutoSysPage(driver);
	FinalizePolicyPage finalPage =  new FinalizePolicyPage(driver);

	@And("^Selecting Auto Non Dealer LOB \"([^\"]*)\"$")
	public void selectLobAS(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBAutoNonDealer()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		//.clickNext()
		.clickNextButton()
		;
	}
	@And("^Select Auto Non Dealer LOB \"([^\"]*)\"$")
	public void selectAS(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBAutoNonDealer()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		//.clickNext()
		.clickNextButton()
		.enterBillingDesc(data.get(9).get(3).toString())
		.clickLOBTab()
		.clickNextToLobDetails()
		;
	}
	@Then("^Verify PIP symbol is displayed$")
	public void checkPip()
	{
		lobPage
		.verifyPipDisplayed();

	}

	@And("^Verify error message when PIP symbol is chosen before liability symbol$")
	public void selctPIP()
	{
		lobPage
		.selPipSymbol()
		.selAddPipSymbol()
		.selPropVechicleNo()
		.selAutoLossRatedInd("No")
		.clickNext()
		;
	}
	@And("^Select PIP symbol$")
	public void selctPIPSymbol()
	{
		lobPage
		.selPipSymbol()
		.selAddPipSymbol()
		;
	}
	@And("^Verify error message when PIP symbol is chosen before liability symbol in Auto lob$")
	public void selectPIPError()
	{
		lobPage
		.selPipSymbol()
		.selAddPipSymbol()
		.selPropVechicleNo()
		.selLossFreeYears("2")
		.selAutoExtnOptions("Coverage not Wanted")
		.clickNext()
		;
	}
	@When("^In Auto Non Dealer LOB details page \"([^\"]*)\"$")
	public void enterliability(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPipSymbol()
		.selAddPipSymbol()
		.selPropVechicleNo()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext()
		.clickSelectInCity()
		.enterNonOwned(data.get(9).get(9).toString())
		;
	}
	@When("^In Auto Non Dealer LOB details page and Select PIP,Med Pay \"([^\"]*)\"$")
	public void selPipMedPay(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPipSymbol()
		.selAddPipSymbol()
		.selMedPaySymbol()
		.selPropVechicleNo()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext()
		.clickSelectInCity()
		.enterNonOwned(data.get(9).get(9).toString())
		;
	}
	@When("^In Auto Non Dealer LOB \"([^\"]*)\"$")
	public void enterASLoBDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPropVechicleNo()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		;
	}
	@When("^In Auto Non Dealer LOB and Select Pip Comprehensive and Collision \"([^\"]*)\"$")
	public void enterASLoBDetail(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPipSymbol()
		.selAddPipSymbol()
		.selComprehensive(data.get(5).get(4).toString())
		.enterCollision(data.get(5).get(5).toString())
		.selPropVechicleNo()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		;
	}
	@When("^In Auto Non Dealer LOB State Screen \"([^\"]*)\"$")
	public void enterASLoBDetailsStateScreen(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.clickNext()
		.clickSelectInCity()
		.enterNonOwned(data.get(9).get(9).toString())
		;
	}




	@When("^In Auto Non-Dealer LOB details page \"([^\"]*)\"$")
	public void selectPip(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPropVechicleNo()
		.clickUMSymbol()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext()
		.clickSelectInCity()
		.enterNonOwned(data.get(9).get(9).toString())
		;
	}
	@And("^Select City for other state$")
	public void enterOtherStateLobDetails()
	{
		lobPage		
		.clickSelectInCity()
		;
	}
	@Then("^Navigating next Screen$")
	public void checkDeductible()
	{
		lobPage
		.clickNext()
		.clickNext()
		.clickNext()
		//.clickNext()
		;
	}

	@And("^Verify WorkLoss Exclusion Option$")
	public void checkWorkLossExclusion()
	{
		lobPage
		.checkWorkLossExclusion("NAMED INSURED ONLY");
	}
	@And("^Verify Extended PIP is disabled$")
	public void verifyExtendedPipDisabled()
	{
		lobPage
		.checkDeductible()
		.checkWorkLossExclusion("NAMED INSURED ONLY")
		.verifyExtendedPipDisabled()
		;
	}
	@And("^Verify Extended PIP,Brd PIP and Extended Brd PIP,Add'l Brd Pip \"([^\"]*)\"$")
	public void verifyExtendedPip(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		//.checkDeductible()
		.clickOkInStateLevelScreen()
		.checkWorkLossExclusion(data.get(11).get(3).toString())
		.verifyExtendedPipDisabled()
		.checkWorkLossExclusion("NONE")
		.verifyExtendedPipEnabled()
		.clickExtendedPip()
		.verifyDdlAddlnPipLimit("25,000")
		.verifyBrdPip(data.get(11).get(4).toString())
		.verifyExtendedBrdPipEnabled()
		.clickExtendedBrdPip()
		.clickAddlBrdPip()
		;
	}
	@And("^Enter Broadened PIP Value \"([^\"]*)\"$")
	public void enterBroadenedPip(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.verifyBrdPip(data.get(11).get(4).toString())
		;
	}
	@Then("^Verify PIP is Select by default$")
	public void checkPIp()
	{
		lobPage
		.verifyPipSelected()
		;
	}
	@Then("^Verify Extended PIP is available in Vehicle Coverage$")
	public void checkExtendedPIpCoverage()
	{
		lobPage
		.clickVehicleLevelPipCoverage()
		.verifyExtendedPip()
		;
	}
	
	@Then("^Verify APIP Coverage is available at Vehicle Level$")
	public void checkAPIpCoverage()
	{
		lobPage
		.verifyAPip()
		;
	}

	@Then("^Verify Extended PIP Coverage is available at State Level$")
	public void checkExtendedPIpCoverageStateLevel()
	{
		lobPage
		.clickExtendedPip()
		;
	}
	@Then("^Select Extended PIP and Work loss Exclusion Option$")
	public void checkExtendedPIpWorkLossOption()
	{
		lobPage
		.clickWorkLossExclusion()
		.clickExtendedPip()
		;
	}
	@Then("^Select Work loss Exclusion Option \"([^\"]*)\"$")
	public void selWorkLossOption(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.selWorkLossExclusion(data.get(11).get(3).toString())//NAME INSURED AND DEPENDENT FAMILY MEMBER //NONE
		;
	}
	
	@Then("^Verify APIP Coverage is available at State Level$")
	public void checkAPIpCoverageStateLevel()
	{
		lobPage
		.verifyAPipStateLevel()
		;
	}
	@Then("^Verify PIP is not selected by default and verify Banner message on selecting Pip$")
	public void checkPIpNotSelected()
	{
		lobPage
		.verifyPipNotSelected()
		.clickPipCoverage()
		.checknotifictaion()
		;
	}
	@And("^Select Comprehensive and Collision Coverage$")
	public void selectComprehensiveCoverage()
	{
		lobPage
		.clickCompCoverage("789560")
		.clickCollisionCoverage("789560")
		;
	}
	@And("^Navigate to Auto Non Dealer LOB details page \"([^\"]*)\"$")
	public void checkGaragewithMedSym(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPropVechicleNo()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext()
		//.clickSelectCity()
		.enterNonOwned(data.get(9).get(9).toString())
		.clickNext()
		.clickNext()
		.clickNext()

		;
		//.clickNext()
		/*.clickCityHelpCheckBox()
		.clickSelectCity()
		.clickCityCountryInfo()
		.enterTerr()
		.clickCityHelpCheckBox()
		.clickCityCountyInfo()
		.clickCityHelpCheckBox()
		.enterTerritory("101")
		.clickCityHelpCheckBox()
		.clickNext()
		.clickCityCountyInfo()
		.enterTerritoryinVehScreen("101")*/

	}
	@Then("^Rate Policy$")
	public void ratePolicy()
	{
		lobPage
		.clickRate();
		//premiumPage
		//.clickRatingWorkSheet("NON-OWNED");
	}
	@And("^Verify Experience Rating and Schedule Mod$")
	public void checkExpRating()
	{
		premiumPage
		.clickPricing()
		.clickExperienceRating()
		.clickAutoLiability()
		.clickYearsOne()
		.clickCalculateMSL()
		.clickGetClaims()
		.clickYearsOneNo()
		.clickExperienceRate()
		.clickReturnToPricing()
		.checkIrpmEnabled("0.750")
		.clickRate()
		;
	}
	@And("^Edit Auto Lob \"([^\"]*)\"$") 
	public void editAuto(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.clickEditAutoLob()
		.clearAULiabilitySymbol()
		.clickNext()
		.checknotifictaion()
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.clickNext()
		;
	}
	@And("^Issue Auto Policy \"([^\"]*)\"$")
	public void issuePolicy(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		premiumPage
		.clickNextToFinalizePolicy()
		.clickYesQues1()
		//.clickYesQues2()
		//.clickYesQues3()		
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
		.clickPrintAutoIDCards()
		.enterFalsePretenseFormDetails()
		.clickReviewIssue()
		.clickNoinAgencyCode()
		.clickIssue()
		.clickNoBtn()
		.enterName(accName)
		;
	}
	@And("^Edit Auto Non Dealer Lob$")
	public void editGarage()
	{
		lobPage
		.clickEditAutoNonDealerLOB();
	}
}

