package com.api.cucumber.testcases.CF;

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
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

//CF- Florida
public class TC_011_CF_FL extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);





	@Given("^CF Lob with package type Monoline Crime fidelity and three years at \"([^\"]*)\"$")
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
		.enterMailAddrs2(data.get(1).get(27).toString())
		.enterZipCode1(data.get(1).get(6).toString())
		.enterZipCode2(data.get(1).get(7).toString())
		.enterCity(data.get(1).get(28).toString())
		.selectMailState(data.get(1).get(29).toString())
		.enterPhoneAreaCode(data.get(1).get(8).toString())
		.enterPhoneExchange(data.get(1).get(9).toString())
		.enterPhoneLastDigits(data.get(1).get(10).toString())
		.selectEmailAsNone()
		.clickRadioBtnNewToAgency()
		.enterPreminumSize(data.get(1).get(11).toString())
		.enterEffectDate(data.get(1).get(12).toString())
		.selectMonolineCrimeFidelityShortTerm()
		//.selectMonolineCrimeFidelity()
		.clickNext()
		.clickNextToPolDet()
		.enterNatureOfBus("TEST")
		.enterYear(data.get(1).get(13).toString())    
		.enterOwnership(data.get(1).get(39).toString())
		//.selectrMarketSegment(data.get(1).get(14).toString())
		.selectInsComp(data.get(1).get(15).toString());
		//.selectLOBCF()
		//.selectSICCoide(data.get(1).get(16).toString());
	}



	@And("^Check Commision Information at \"([^\"]*)\"$")
	public void lobDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectMarijuanaQuest()
		//.selectAdditionalCovgNO()
		.selectPriorCarrier(data.get(1).get(17).toString())
		.clickNext()
		.clickLocation()
		.enterBillingDesc(data.get(1).get(18).toString())
		.clickLOBTab()
		.clickNextToLobDetails()
		.selCoverageType(data.get(1).get(38).toString())
		.clickCitySerachBtn()
		//.clickSelect()
		.clickNextBtn()
		.clickLocationInfo()
		.enterClassCodeinSLT(data.get(1).get(23).toString())
		.clickThefOfmoneyAndSec()
		.clickNextButton()
		.enterTaxDistrict()
		.clickNextButton()
		.enterInsLin()
		.enterDeductible()
		.clickNextButton()
		.clickRate();
		//.clickBtnContinuerating();
		/*.clickFinalizePolicy()
		.clickNext()
		.clickCommission()
		.checkCommisionInfo();*/
	}




}
