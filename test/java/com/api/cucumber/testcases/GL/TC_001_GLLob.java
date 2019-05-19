package com.api.cucumber.testcases.GL;

import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.NotePad;
import com.api.cucumber.pages.PFPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;


public class TC_001_GLLob extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	NotePad notepad = new NotePad(driver);
	PFPage pf= new PFPage(driver);


	
	@And("Customer selects Commercial Lines - CLAS \"([^\"]*)\"$")
	public void clickCLAS(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
List<List<String>> data = table.raw();
		
		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		quickLinks
		.selectComLink()
		.clickGo()
		.enterAccName(data.get(1).get(2).toString())
		.clickNext()
		.clickYesOrNo();
	}
	@And("Customer fills Account information from excel at \"([^\"]*)\"$")
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
	@And("^Navigate policy details page and enter data from excel at \"([^\"]*)\"$")
	public void policyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
List<List<String>> data = table.raw();
		
		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.enterYear(data.get(1).get(13).toString())
		.selectrMarketSegment(data.get(1).get(14).toString())
		.selectInsComp(data.get(1).get(15).toString())
		.findListOfInsComp()
		.selectLOBGL()
		//.selectLOBCP()
		.selectSICCoide(data.get(1).get(16).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(1).get(17).toString())
		.clickNext()
		.clickNextButton();
	}
	@And("Click all Lobs")
	public void locationDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
List<List<String>> data = table.raw();
		
		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		locPage
		.enterBillingDesc(data.get(1).get(18).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}

	@And("Enter LOB Details")
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
		.selExtnOptions(data.get(1).get(20).toString())
		.selectEmployeeBenefits()
		.selectNoOFEmp()
		.selSuppERPE()
		.clickNextBtn()
		.enterClassCode(data.get(1).get(23).toString())
		.enterPremiumBasis(data.get(1).get(23).toString())
		.clickNextButton()
		.clickRate()
		.clickBtnContinuerating();
		//.clickExiTToDashBoard();
	}

	/*@And("Verify premium summary")
	public void premiumDetails() throws InterruptedException
	{
		premiumPage
		.clickRatingWorkSheet();
	}*/

	@And("^User Navigates to Notepad Screen and verify GL MOD and GL Schedule MOD$")
	public void navToNotePadScreen()
	{
		notepad
		.clickNotePad()
		.clickCreditDebit()
		.clickAdd()
		.selDdlLob("GENL LIAB")
		.clickGlIrpmSelection()
		.clickNext()
		.checkErrorMessage()
		.clickCancel()
		.clickGlScheduleMod()
		.enterCreditLocation("1.3")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterCreditLocation("0.3")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterCreditLocation("0.95")
		.enterCreditExposureOutsidePremises("1.5")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterCreditExposureOutsidePremises("0.3")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterCreditExposureOutsidePremises("0.95")
		.enterCreditPremises("2.1")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterCreditPremises("0.1")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterCreditPremises("0.9")
		//.enterCreditPremises("1")
		.enterCreditEquipment("1.9")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterCreditEquipment("0.1")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterCreditEquipment("0.9")
		.enterClassificationPecularities("1.8")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterClassificationPecularities("0.8")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterClassificationPecularities("0.94")
		.enterEmployees("1.9")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterEmployees("0.8")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterEmployees("0.98")
		.enterCooperation("2.1")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterCooperation("0.1")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterCooperation("0.98")
		.enterSafetyProgram("3.1")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterSafetyProgram("0.1")
		.clickReturnToCreditDebitSummary()
		.clickOK()
		.enterSafetyProgram("0.98")
		.clickReturnToCreditDebitSummary()
		.clickReturnToCreditDebitSummary()
		//.clickOK()
				;
	}
	@And("^Edit GL LOB and Add Coverage$")
	public void editGLAddCov()
	{
		lobPage
		.clickEditGlLOB()
		.clickNext()
		.selectEmployeeBenefits()
		.selectNoOFEmp()
		.selSuppERPE()
		.clickRate()
		;
	}
	@And("^Edit GL LOB$")
	public void editGl()
	{
		lobPage
		.clickOkBttn()
		.clickOkBttn()
		.clickEditGlLOB()
		.clickNext()
		.clickNext()
		.enterPremiumBasis("55000")
		.clickRate()
		.clickBtnContinuerating()
		;
	}
	@And("^Edit GL LOB and Rate Policy$")
	public void editGlLob()
	{
		lobPage
		.clickEditGlLOB()
		.clickNext()
		.clickNext()
		.enterPremiumBasis("55000")
		.clickRate()
		.clickBtnContinuerating()
		;


	}
}
