package com.api.cucumber.testcases.PF;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.EnterNamePage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PFPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

//To validate the Group A state scan edits validation for PF LOB VT state
public class US_1220_TC extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	EnterNamePage enterNamePag = new EnterNamePage(driver);
	PFPage pf = new PFPage(driver);

	@BeforeTest
	public void setData() {
		testCaseName="TC001";
		testDescription="login";
		testNodes="AA";
		category="Smoke";
		authors="Amirtha";
		//browserName="chrome";
		dataSheetName="COP";
	}
	@Test(dataProvider="fetchData")
	public void enterLogin(String uName,String pwd)
	{

		login
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLoginBtnInSLT()
		//.selRegions("All Regions")
		.selectBuisnessIssue();
		//	.enterAccName(data.get(1).get(2).toString())
		//.clickNext();
		//.clickYesOrNo();
	}

	@Given("^Login to the application and select transaction \"([^\"]*)\"$")
	public void clickCLAS(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		accName = data.get(1).get(2).toString();
		accountName = data.get(1).get(2).toString();
		int no= Integer.parseInt(accountName.replaceAll("[^0-9]",""));
		no++;
		accountName =  accountName.replaceAll("[0-9]","");
		accountName=accountName+no;
		System.out.println("Acc Name "+accountName);

		login
		.selectLogInAs(data.get(1).get(4).toString())
		.enterUserName(data.get(1).get(0).toString())
		.enterPassword(data.get(1).get(1).toString())
		.clickLogin()
		.selectComLink()
		//.clickGo()  //NBQU
		//.selectBuisnessIssue()
		.selectTransaction(data.get(1).get(3).toString())
		.enterAccName(data.get(1).get(2).toString())
		.clickNext()
		.clickYesOrNo();
	}
	@Given("^login as Employee for CLAS with NBIS \"([^\"]*)\"$")
	public void enterLoginDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		accName = data.get(1).get(2).toString();
		accountName = data.get(1).get(2).toString();
		int no= Integer.parseInt(accountName.replaceAll("[^0-9]",""));
		no++;
		accountName =  accountName.replaceAll("[0-9]","");
		accountName=accountName+no;
		System.out.println("Acc Name "+accountName);
		login
		.enterUserName(data.get(1).get(0).toString())
		.enterPassword(data.get(1).get(1).toString())
		.clickLoginBtnInSLT()
		//.selRegions("All Regions")
		//		.clickGo()  //NBQU
		.selectBuisnessIssue()
		.enterAccName(data.get(1).get(2).toString())
		.clickNext();
		//.clickYesOrNo();
	}
	@Given("^check policy Number$")
	public void checkPolicy() throws InterruptedException
	{
		login
		.selectLogInAs("Employee")
		.enterUserName("qa1_field")
		.enterPassword("webclas1")
		.clickLogin()
		.selectComLink()
		.enterName("BACKOUT TEST_1465263_IL")
		.getPolicyNo()
		.clickUWCenter()
		.clickRenewalBatchJob()
		.enterPolicyNumber(policyNo)
		.enterTransactionSerial("01")
		.clickExecute()
		;

	}

	@Given("^Select state AL with effective date from jan 10,2019 \"([^\"]*)\"$")
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
		//.enterPreminumSize(data.get(3).get(3).toString())
		.enterEffectDate(data.get(3).get(4).toString())
		.selectApplicablePolicy()
		//.clickNext()
		.clickNextToPolDet();
		accInfo
		.clickNextToPolDet();
	}
	@And("^Select state FL with effective date from jan 10,2019 \"([^\"]*)\"$")
	public void enterAccountInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
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
		//.enterCity(data.get(1).get(9).toString())
		//.selectMailState(data.get(1).get(10).toString())
		.enterPhoneAreaCode(data.get(3).get(0).toString())
		.enterPhoneExchange(data.get(3).get(1).toString())
		.enterPhoneLastDigits(data.get(3).get(2).toString())
		.selectEmailAsNone()
		.clickRadioBtnNewToAgencyNo()
		.enterPreminumSize(data.get(3).get(3).toString())
		.enterEffectDate(data.get(3).get(4).toString())
		//.enterExpDate(data.get(1).get(9).toString())
		.selectCPP()
		.clickNext()
		.clickNextToPolDet()
		.enterNatureOfBus(data.get(3).get(5).toString())
		.getQuoteNo()
		.enterYear(data.get(3).get(6).toString())    
		.enterOwnership(data.get(3).get(7).toString())
		.selectrMarketSegment(data.get(3).get(8).toString()) 
		.selectInsComp(data.get(3).get(9).toString());
	}
	@And("^Selecting PF LOB \"([^\"]*)\"$")
	public void policyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBPF()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(7).get(9).toString())
		.clickNext()
		.clickLocation()
		.clickBtnNo()
		;
	}
	@And("^Selecting PF,GL LOB \"([^\"]*)\"$")
	public void selMultiLobs(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBPF()
		.selectLOBGL()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(7).get(9).toString())
		.clickNext()
		.clickLocation()
		.clickBtnNo()
		;
	}
	@And("^Selecting PF,CF LOB \"([^\"]*)\"$")
	public void selLOB(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBCF()
		.selectLOBPF()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(7).get(9).toString())
		.clickNext()
		.clickLocation()
		.clickBtnNo()
		;
	}
	@And("^Selecting PF LOB in Agent \"([^\"]*)\"$")
	public void selPFLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBPF()
		.selectPriorCarrier(data.get(7).get(9).toString())
		.clickNext()
		.clickNextButton();
	}
	@And("^Selecting GL LOB in Agent \"([^\"]*)\"$")
	public void selGlLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBGL()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickNextButton()
		.enterBillingDesc("TEST")
		.clickLOBTab()
		.clickNextToLobDetails();
	}
	@Then("Verify Contractors related Elitepac options are available under Extension options dropdown")
	public void verifyExtnList()
	{
		pf
		.optionsInEXtn();
	}

	@Then("^Verify GREEN PAC Coverage is available$")
	public void policyCoverage(){
		lobPage
		.clickNextButton()
		.clickCityCountryInfo();
		pf
		.selectGreenPac()
		.selectGreenPacICLmt()
		.selectGreenPacSCLmt();
	}

	@Then("^Verify Crisis response is available$")
	public void verifyCrisisres(){
		pf
		.selectCrisisResponse()
		.selectCRBIEE();
	}
	@Then("Verify Special Territory, is set  to  001 \"([^\"]*)\"$")
	public void cityInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.clickNext()
		.checkPfSpecTerr1(data.get(5).get(3).toString())
		.typeTerritory(data.get(5).get(3).toString());
		pf
		.selectConstruction(data.get(5).get(4).toString());
	}
	@When("^In Coverages Screen \"([^\"]*)\"$")
	public void verifyCoverage(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.clickNextBtn()
		.selIsoCity()
		.enterBasicGrp1Territory("001")
		.enterBasicGrp2Territory("001")
		.clickCityCounty()
		.typeClassCode(data.get(5).get(5).toString())
		.selectConstruction(data.get(5).get(4).toString())
		.enterYearBuilt(data.get(5).get(6).toString())
		.selectBuildingRateType(data.get(5).get(7).toString())
		.selLocationCauseOfLoss(data.get(7).get(5).toString())
		.clickNextBtn()
		.enterEstimationReason(data.get(3).get(5).toString())
		;
	}
	@When("^In the Coverages Screen \"([^\"]*)\"$")
	public void selLoc(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.clickNextBtn()
		.selIsoCity()
		.enterBasicGrp1Territory("001")
		.enterBasicGrp2Territory("001")
		.clickCityCounty()
		.typeClassCode(data.get(5).get(5).toString()) //data.get(5).get(5).toString()
		.selectConstruction(data.get(5).get(4).toString())
		.enterYearBuilt(data.get(5).get(6).toString())
		.selectBuildingRateType(data.get(5).get(7).toString())
		.selLocationCauseOfLoss(data.get(7).get(5).toString())
		.SelWindHailDeductible("2%")
		.clickcAlternatePowerGenerationNo()
		.clickNextBtn()
		.enterEstimationReason(data.get(3).get(5).toString())
		;
	}
	@Then("^verify whether the new Special Class Trees, Shrubs and Plants is not displayed in the Special Class screen \"([^\"]*)\"$")
	public void verifyCovSpclClass(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selectSpecialClasses()
		.clickEdit()
		.verifyTreesShrubsPlantsNotAvail(data.get(5).get(8).toString())
		.clickNextBtn()
		;

	}
	@When("^Florida Sinkhole Loss Coverage is selected$")
	public void selectFloridaSinkHoleLossCov()
	{
		pf
		.selectChkBxFloridaSinkHoleLossCoverage()
		;
	}
	@And("^Selecting Special Classes Coverage$")
	public void selectSpecialClassCov()
	{
		pf
		.selectSpecialClasses()
		.clickEdit()
		;
	}
	@Then("^verify whether the Sonal Panel Array is not displayed in the Special Class screen \"([^\"]*)\"$")
	public void verifyCovSolarPanel(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.verifySolarPanelNotAvail("Solar Panel")
		.clickSwimPool()
		.enterLimitsSwimPool("1200")
		.selConstructionType()
		//.enterBasicGrp2sym("AA")
		//.clickNextBtn()
		.clickNextBtn()
		;

	}

	@Then("^Verify whether user is  able to select the Extended Period Of Indemnity coverage under Business Income with Extra Expense optional coverage section \"([^\"]*)\"$")
	public void clickBuissIncWithExtraExp(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.clickBuisIncomeWithExtraExp()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		;
	}
	@Then("^Enter Buisness Income with Extra expense values \"([^\"]*)\"$")
	@And("^Verify whether in the dropdown options for the field Number of days \"([^\"]*)\"$")
	public void verifyBuissIncWithExtraExp(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.enterLimit(data.get(5).get(9).toString())
		.selRiskType(data.get(5).get(10).toString())
		.enterExtraExpClassCode("0702")
		.selIndemnityTpe(data.get(7).get(3).toString())
		//.clickExtPerOfIndemnity()
		//.selNoOfDays(data.get(7).get(2).toString())
		//.clickNextBtn()
		;
	}
	@When("^Rate PF Policy$")
	@Then("^Verify whether user is  able to select any one of the option from the dropdown and rate successfully$")
	public void ratePolicy()
	{
		lobPage
		.clickRate()
		.clickBtnContinuerating();
	}
	@Then("^Verify BPP optional coverage -Building Glass - Tenants Policy is available \"([^\"]*)\"$")
	public void verifyCovBpp(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.clickBpp()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		.clickBuildingGlassTnentsPolicy();
	}
	@And("^Verify whether a  field No Deductible is not displayed under Limit field \"([^\"]*)\"$")
	public void checkDeductible(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.verifyDeductible(data.get(7).get(4).toString())
		.clickNextBtn()
		;
	}
	@Then("^Verify whether the user is able to select the Business Income Educational Institution coverage \"([^\"]*)\"$")
	public void clickBuisIncEduIns(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		/*lobPage
		//.clickNextButton()
		.enterClassCode(data.get(5).get(5).toString());*/
		pf
		.clickBuisnessIncEduInst()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		.enterLimitBusIncEduIns(data.get(7).get(6).toString());
	}
	@And("^Verify whether the user is able to select a value 60 in the dropdown for Coinsurance field under the coverage \\. \"([^\"]*)\"$")
	public void checkCoInsuranecValue(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selCovType(data.get(7).get(7).toString())
		.selCoInsurance(data.get(7).get(8).toString())
		;
	}

	@And("^Select Extra Expense Coverage \"([^\"]*)\"$")
	@Then("^Verify whether the user is able to select the Extra Expense coverage \"([^\"]*)\"$")
	public void clickExtraExp(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.clickExtraExpense()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit();
	}
	@And("^Enter Extra Expense Coverage values \"([^\"]*)\"$")
	@Then("^Verify whether the user is  able to choose the value 25%-50%-75%-100% in the dropdown for Expand Limit field \"([^\"]*)\"$")
	public void selectExpenseLimit(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.enterExtraExpLimit(data.get(7).get(6).toString())
		.enterExtraExpClassCode("0922")
		.selExpandLimit(data.get(9).get(0).toString())
		.clickNextBtn()
		;
		lobPage
		.clickRate()
		.clickBtnContinuerating()
		//.clickRatingWorkSheet("")
		;
	}
	@And("^Adding Coverages Building,BPP$")
	public void addCov()
	{
		pf
		.clickBuilding()
		.clickBpp()
		.clickEdit()
		.selectPrometrixSchedule()
		//		.clickEdit()
		;
	}
	@And("^Adding Off Premises Utilities Coverage$")
	public void selOffPremisesUtilities()
	{
		pf
		.clickOffPremisesUtilities()
		.clickEdit()
		//.selectPrometrixSchedule()
		;
	}
	@And("^Enter Off Premises Utilities Covergae Values \"([^\"]*)\"$")
	public void enterOffPremisesValues(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.clickOffPremisesLimitTypeFull()
		.clickUtilityServiceWater(data.get(11).get(1).toString())
		.clickUtilityServiceCommunication(data.get(11).get(1).toString())
		.clickUtilityServicePower(data.get(11).get(1).toString())
		.clickUtilityServiceCommunicationLines()
		.clickUtilityServicePowerLines()
		;
	}
	@And("^Adding Building Coverages$")
	public void addBuildingCov()
	{
		pf
		.clickBuilding()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		;
	}
	@And("^Adding Coverages$")
	public void addCoverage()
	{
		pf
		.clickBuilding()
		.clickBpp()
		//.clickLegalLiabilityBuilding()
		.clickBuisIncomeWithExtraExp()
		.clickBuisnessIncEduInst()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		;
	}
	@And("^Select prometrix Schedule$")
	public void selPrometrix()
	{
		pf
		.clickEdit()
		.selectPrometrixSchedule()
		;
	}
	@And("^Add Building$")
	public void addBuilding()
	{
		pf
		.clickBuilding()
		;
	}
	@And("^Add BPP$")
	public void addBPP()
	{
		pf

		.clickBpp()

		;
	}
	@And("^Add Business Income Educational Institution$")
	public void addBusinessIncomeEduInst()
	{
		pf
		.clickBuisnessIncEduInst()
		;
	}
	@And("^Add Business Income Extra Expense$")
	public void addBusinessIncomeExtraExpense()
	{
		pf
		.clickBuisIncomeWithExtraExp()
		;
	}
	@And("^Add Legal Liability Building$")
	public void addLegalLiabilityBuilding()
	{
		pf
		.clickLegalLiabilityBuilding()
		;
	}

	@And("^Adding BPP Coverage$")
	public void addCovBpp()
	{
		pf
		.clickBpp()
		.clickEdit()
		;
	}

	@And("^Adding Building Optional Coverage \"([^\"]*)\"$")
	public void clickBuildingCov(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.enterBuildingLimit(data.get(9).get(4).toString())
		.enterPfBldgBasicGrpIRateVal("10.0")
		.clickNextBtn()
		;
	}
	@And("^Adding Building and its optional Coverage \"([^\"]*)\"$")
	public void clickBuildingOptionalCov(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();
		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.enterBuildingLimit(data.get(9).get(4).toString())
		.typeBuildingClassCode(data.get(5).get(5).toString())
		.enterPfBldgBasicGrpIRateVal("10.0")
		.clickNextBtn()
		.clickNo()
		;
	}
	@And("^Adding Legal Liability-Building optional Coverage$")
	public void addLegalLiabilityBuildingCov()
	{
		pf
		.clickLegalLiabilityBuildingCov()
		.clickEdit()
		.selectPrometrixSchedule()

		;
	}
	@And("^Adding Coverage values for Liability-Building \"([^\"]*)\"$")
	public void enterLegalLiabilityBuildingValues(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.enterLegalLiabilityBuildingLmt(data.get(9).get(4).toString())
		.changeLegalLiabilityBuildingClassCode("0702")
		//.selLegalLiabilityBuildingCoInsurance(data.get(9).get(5).toString())
		;
	}
	@And("^Adding Legal Liability optional Coverage \"([^\"]*)\"$")
	public void selLegalLiability(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.selChkBxLegalLiability()
		.enterTxtLegalLiabilityLimit(data.get(9).get(7).toString())
		.enterTxtLegalLiabilityPremium(data.get(11).get(0).toString());
	}
	@And("^Adding BPP Legal Liability optional Coverage \"([^\"]*)\"$")
	public void selBppLegalLiability(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.selChkBxLegalLiability()
		.enterTxtBppLegalLiabilityLimit(data.get(9).get(7).toString())
		.enterTxtBppLegalLiabilityPremium(data.get(11).get(0).toString());
	}
	@And("^Adding Demolition Cost optional Coverage \"([^\"]*)\"$")
	public void selDemolitionCost(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.selChkBxBuildingDemolitionCost()
		.enterTxtDemolitionLimit(data.get(9).get(4).toString())
		.clickNextBtn()
		;
	}
	@And("^Adding BPP optional Coverage \"([^\"]*)\"$")
	public void clickBppCov(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.clickBpp()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		.enterBPPLimit(data.get(9).get(4).toString())
		.enterBPPClassCode("0922")
		.enterPfBppBasicGrpIRateVal("10.0");
		;
	}
	@And("^Edit Property LOB$")
	public void editProperty()
	{
		pf
		.clickPropPolicyDetail()
		.clickNextBtn()
		.clickCityCounty()
		.enterBasicGrp1Territory("001")
		.enterBasicGrp2Territory("001")
		;
	}
	@And("^Delete Property LOB$")
	public void deletePF()
	{
		pf
		.clickProperty()
		.clickDeleteProperty()
		.clickYes()
		;
	}
	@And("^Add Property LOB$")
	public void addPF()
	{
		pf
		.clickPolicyDetails()
		.clickEditPolicyDetails()
		.selectLOBPF()
		.clickLocation()
		.clickEditLocation()
		.clickLOBTab()
		.clickNextToLobDetails()
		.clickProperty()
		;
	}

	@And("^Add Optional Coverage$")
	public void addCoverages()
	{
		pf
		.clickCoverages()
		;
	}
	@And("^Edit Coverages$")
	public void editCoverages() {
		pf
		.clickEdit()
		;
	}
	@And("^Adding BPP Optional Coverage \"([^\"]*)\"$")
	public void addBppCov(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.enterBPPLimit(data.get(9).get(4).toString())
		.enterBPPClassCode("0702")
		.clickNextBtn()
		.clickNo()
		;
	}
	@Then("^Verify Legal Liability optional coverage is not removed under the Building Optional Coverages \"([^\"]*)\"$")
	public void clickBuilding(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.clickBuilding()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		.verifyLegalLiability()
		.clickCancel()
		.clickYes()
		.clickBuilding()
		.clickYes();
	}
	@And("^Verify whether new Location Level Coverage Legal Liability – Building is available and Legal Liability – Personal Propertyis not available \"([^\"]*)\"$")
	public void clickLegalLiabilityBuilding(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.verifyLegalLiabilityBuilding()
		.verifyLegalLiabilityPersProp();
	}
	@And("^Verify Legal Liability – real Property is available in BPP \"([^\"]*)\"$")
	public void clickLegalLiabilityRealProp(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.clickBpp()
		.clickEdit()
		.verifyLegalLiabilityRealProp();
	}
	@Then("^verify whether the Business Income from Dependent Properties Coverage is available for the user to select when  Business Income Actual Loss sustained Coverage is selected \"([^\"]*)\"$")
	public void verifyBiLASCov(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.clickBuilding()
		.clickBuisnessIncomeDepProp()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEditInBiDp()
		.enterLimitBuisIncDepProp(data.get(5).get(9).toString())
		.selCoInsuranceBuisIncDepPro(data.get(7).get(1).toString())
		.clickNextBtn()
		.enterBasicGropup(data.get(9).get(1).toString())
		.clickNextBtn()
		;
		lobPage
		.clickNxtToCrimeFidelity()
		.clickDeleteLob()
		.clickBtnYes()
		.selStatus()
		.selNotTakenReason()
		.clickProcess()
		.clickLobDetails()
		;
		pf
		.clickEdit()
		.clickNextBtn()
		.enterProMetrixOverrideReason(data.get(3).get(5).toString())
		.clickNextBtn()
		.clickNextBtn()
		.enterBuildingLmt(data.get(7).get(6).toString())
		.enterBuildingCoInsurance()
		.clickNextBtn()
		.clickNextBtn()
		.clickNextBtn()
		;
		lobPage
		.clickRate()
		.clickBtnContinuerating()
		.clickExiTToDashBoard();
	}
	@Then("^Verify optional coverage Limitations On Coverage For Roof Surfacing is not available under Building Coverage \"([^\"]*)\"$")
	public void verifyRoofInBuilding(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.clickBuilding()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		.enterBuildingLmt(data.get(7).get(6).toString())
		.enterBuildingCoInsurance()
		.verifyRoofSurfacingInBuilding("Roof Surfacing")
		.clickNextBtn()
		;
		lobPage
		.clickRate()
		.clickBtnContinuerating()
		.clickRatingWorkSheet("Roof Surfacing");
	}
	@Then("^Verify Debris Removal Additional Insurance coverage is not added under Loss Payee coverage when Building coverage is selected in the Location coverages screen \"([^\"]*)\"$")
	public void verifyLossPayee(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.clickBuilding()
		//.clickLossPayee()
		.verifyDebrisRemovalAddIns()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		.enterBuildingLmt(data.get(7).get(6).toString())
		.enterBuildingCoInsurance()
		.clickNextBtn()
		;
		lobPage
		.clickRate()
		.clickBtnContinuerating()
		.clickExiTToDashBoard();
	}
	@Then("^Verify Vacancy Options section has three fields Vacant,Vacancy Changes,Vacancy Permit \"([^\"]*)\"$")
	public void verifyVacationOptions(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.clickBuilding()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		.enterBuildingLmt(data.get(7).get(6).toString())
		.enterBuildingCoInsurance()
		.clickVacationOptions()
		;
	}
	@And("^Verify Minimum Percentage Rented/Used is disabled when user expands Vacancy Options section$")
	public void verifyMinPecDisabled()
	{
		pf
		.verifyMinPecRentedUsed();
	}
	@Then("^Verify Vacancy Changes checkbox is disabled and Vacancy Permit is enabled when user selects Vacant checkbox$")
	public void clickVacant()
	{
		pf
		.clickVacant()
		.verifyEnabledVacancyPermit()
		.verifyDisabledVacancyChanges()
		.clickVacant()
		;
	}
	@And("^Verify Vacancy Changes checkbox is disabled and Vacant is enabled when user selects Vacancy Permit checkbox$")
	public void clickVacancyPermit()
	{
		pf
		.clickVacancyPermit()
		.verifyEnabledVacanct()
		.verifyDisabledVacancyChanges()
		.clickVacancyPermit()
		;
	}
	@And("^Verify user is able to select Vacant and Vacancy Permit checkboxes together and able to navigate to next screen$")
	public void clickVacantVacancyPermit()
	{
		pf
		.clickVacant()
		.clickVacancyPermit()
		.clickNextBtn()
		;
		lobPage
		.clickRate()
		.clickBtnContinuerating()
		.clickExiTToDashBoard();
	}
	@Then("^Verify Increase In Rebuilding Expenses Following Disaster coverage is not added under Building optional coverages screen$")
	public void checkIncInRebuildingExpFolDisaster() {
		pf
		.clickBuilding()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		.verifyIncInRebuildExpFollowDisaste("Increase In Rebuilding Expenses Following Disaster")
		.clickCancel()
		.clickYes()
		.clickBuilding()
		.clickYes();
	}
	@And("^Verify Increase In Rebuilding Expenses Following Disaster coverage is not added under TIB screen$")
	public void checkTIB()
	{
		pf
		.clickTIB()
		.clickEdit()
		.verifyOptionalCoverages("Increase In Rebuilding Expenses Following Disaster");

	}
	@And("^Adding TIB Coverages \"([^\"]*)\"$")
	public void checkTIBCov(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.clickTIB()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		.enterBuildingLimit(data.get(9).get(4).toString())
		.enterBuildingClassCode("0922")
		.enterPfBldgBasicGrpIRateVal("10.0")
		;
	}
	@And("^Adding TIB optional Coverage Legal Liability \"([^\"]*)\"$")
	public void clickTibOptionalCov(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		pf
		.selChkBxLegalLiability()
		.enterTxtLegalLiabilityLimit(data.get(9).get(7).toString())
		.enterTxtLegalLiabilityPremium(data.get(11).get(0).toString())
		;
	}
	@And("^Adding Coverage Inflation Guard$")
	public void clickTibOptionalCovInflationGuard()
	{
		pf
		.selChkBxBppInflationGuard()
		.selDdlBppInflationGuard()
		;

	}
	@And("^Adding EarthQuake Sprinkler Leakage Coverage \"([^\"]*)\"$")
	public void clickTibOptionalCovEarthquakeSprinkler(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxTibEarthquakeSprinkler()
		.selDdlTibEarthQuakeConstruction(data.get(11).get(2).toString())
		;

	}
	@And("^Verify Legal Liability is displayed under Tenants Improvements/Betterments optional coverages section$")
	public void checkTIBOptionalCov() {
		pf
		.verifyOptionalCoveragesAvail("Legal Liability");
	}
	@Then("^Verify Legal Liability is shown as an Optional Coverage and Exclusion section under Building and BPP$")
	public void verifyLegalLiability() {
		pf
		.clickBuilding()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		.verifyLegalLiability()
		.clickExclusion()
		.clickExclusion()
		.clickCancel()
		.clickYes()
		.clickBuilding()
		.clickYes()
		.clickBpp()
		.clickEdit()
		.clickExclusionBpp()
		.clickExclusionBpp()
		.verifyOptionalCoveragesBpp("Legal Liability")
		.clickCancel()
		.clickYes()
		.clickBpp()
		.clickYes()
		;
	}
	@And("^Verify exclusions section will be shown at the coverage level for Legal Liability-Building$")
	public void checkLegalLiability()
	{
		pf
		.clickLegalLiabilityBuilding()
		.clickEdit()
		.clickExclusion()
		.clickExclusion()

		;
	}
	@Then("^Verify Loss Assessment Coverage Condos Limit is  displayed as Combo box$")
	public void verifyLossAssement() {
		pf
		.clickLossAssessment()
		.clickEdit()
		//.selectPrometrixSchedule()
		//.clickEdit()
		.checkLossAssessmentCoverage();
	}
	@And("^Verify Sub-Limit on Assessment Resulting from Condominium Association Deductible  is not  present under Loss Assessment/Misc Real Property section$")
	public void checkLossAssessment()
	{
		pf
		.checkLossAssessmentMiscRealProp("Sub-Limit on Assessment Resulting from Condominium Association Deductible");
	}
	@And("^Verify Unit number is not displayed below Miscellaneous Real Property Condos Limit$")
	public void checkLossAssessmentScreen()
	{
		pf
		.checkLossAssessmentMiscRealProp("Unit number");
	}

	@Then("^Verify Electric Vehicle Charging Station Pole-mounted or Pedestal coverage,Wind Towers coverage,Bridges and Aqueducts coverage and Tanks,Bins and Silos coverage is not available$")
	public void verifySpclClass() {
		pf
		.verifySpecialClasees("Electric Vehicle Charging Station Pole-mounted or Pedestal coverage")
		.verifySpecialClasees("Wind Towers")
		.verifySpecialClasees("Bridges and Aqueducts")
		.verifySpecialClasees("Tanks,Bins and Silos")
		.clickSwimPool()
		.enterLimitsSwimPool("1200")
		.selConstructionType()
		//.enterBasicGrp2sym("AA")
		.clickNextBtn()
		;
	}
	@And("^Selecting Amusement Equipment in the Open Coverage \"([^\"]*)\"$")
	public void selAmusementOpenCov(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selectChkBxAmusementEquipment()
		.enterTextAmusementLimit(data.get(9).get(7).toString())
		.selDdlAmusementCoInsurance(data.get(9).get(8).toString())
		.selDdlAmusementConstructionType(data.get(9).get(9).toString())
		.clickNextBtn()
		;
	}
	@When("^Selecting Artificial Turf coverage \"([^\"]*)\"$")
	public void selArtificialTurf(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxArtificialTurf()
		.enterTextArtificialTurfLimit(data.get(9).get(8).toString())
		.selDdlArtificialTurfCoInsurance()
		.clickArtificialTurfBasicGrpII()
		.clickNextBtn()
		;   
	}
	@When("^Selecting  Awnings and Canopies coverage \"([^\"]*)\"$")
	public void selAwningsCanopies(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxAwningsAndCanopies()
		.enterTextAwningsAndCanopiesLimit(data.get(9).get(7).toString())
		.selDdlAwningsAndCanopiesCoInsurance(data.get(9).get(8).toString())
		.selDdlAwningsAndCanopiesConstructionType(data.get(9).get(9).toString())
		//.clickNextBtn()
		;
	}
	@When("^Selecting  Billboards and Signs coverage \"([^\"]*)\"$")
	public void selBillboardsSigns(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxBillBoardsAndSigns()
		.enterTextBillBoardsAndSignsLimit(data.get(9).get(7).toString())
		.selDdlBillBoardsAndSignsCoInsurance(data.get(9).get(8).toString())
		.selDdlBillBoardsAndSignsConstructionType(data.get(9).get(9).toString())
		.clickNextBtn()
		;
	}

	@When("^Selecting  Bleachers coverage \"([^\"]*)\"$")
	public void selBleachers(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxBleachers()
		.enterTextBleachersLimit(data.get(9).get(7).toString())
		.selDdlBleachersCoInsurance(data.get(9).get(8).toString())
		.clickBleachersBasicGrpII()
		//.clickNextBtn()
		;

	}
	@When("^Selecting  Electronic Transformers coverage \"([^\"]*)\"$")
	public void selElectronicTransformers(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxElectronicTransformers()
		.enterTextElectronicTransformersLimit(data.get(9).get(7).toString())
		.selDdlElectronicTransformersCoInsurance(data.get(9).get(8).toString())
		.selDdlElectronicTransformersConstructionType(data.get(9).get(9).toString())
		//.clickNextBtn()
		;   
	}
	@When("^Selecting  Exhibit Stands coverage \"([^\"]*)\"$")
	public void selExhibitStands(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxExhibitStands()
		.enterTextExhibitStandsLimit(data.get(9).get(7).toString())
		.selDdlExhibitStandsCoInsurance(data.get(9).get(8).toString())
		.selDdlExhibitStandsConstructionType(data.get(9).get(9).toString())
		.clickNextBtn()
		;
	}
	@When("^Selecting  Fences and Arbors coverage \"([^\"]*)\"$")
	public void selecting_Fences_and_Arbors_coverage(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxFencesArbors()
		.enterTextFencesArborsLimit(data.get(9).get(7).toString())
		.selDdlFencesArborsCoInsurance(data.get(9).get(8).toString())
		.selDdlFencesArborsConstructionType(data.get(9).get(9).toString())
		.clickNextBtn()
		;
	}
	@When("^Selecting  Nursery Stock in the Open coverage \"([^\"]*)\"$")
	public void selNurseryStock(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxNurseryStock()
		.enterTextNurseryStockLimit(data.get(9).get(7).toString())
		.selDdlNurseryStockCoInsurance(data.get(9).get(8).toString())
		.clickNurseryStockBasicGrpII()
		.clickNextBtn()
		;
	}

	@When("^Selecting  Property in the Open coverage \"([^\"]*)\"$")
	public void selPropertyInOpen(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.clickEdit()
		.selChkBxPropertyInOpen()
		.enterTextPropertyInOpenLimit(data.get(9).get(7).toString())
		.selDdlPropertyInOpenCoInsurance(data.get(9).get(8).toString())
		.selDdlPropertyInOpenConstructionType(data.get(9).get(9).toString())
		.clickNextBtn()
		;
	}
	@When("^Selecting  Street Lights coverage \"([^\"]*)\"$")
	public void selStreetLights(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxStreetLights()
		.enterTextStreetLightsLimit(data.get(9).get(7).toString())
		.selDdlStreetLightsCoInsurance(data.get(9).get(8).toString())
		.selDdlStreetLightsConstructionType(data.get(9).get(9).toString())
		.clickNextBtn()
		;
	}

	@When("^Selecting  Swimming Pools coverage \"([^\"]*)\"$")
	public void selSwimmingPools(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxSwimmingPools()
		.enterTextSwimmingPoolsLimit(data.get(9).get(7).toString())
		.selDdlSwimmingPoolsCoInsurance(data.get(9).get(8).toString())
		.selDdlSwimmingPoolsConstructionType(data.get(9).get(9).toString())
		.clickNextBtn()
		;
	}
	@When("^Selecting  Radio and TV Antenna coverage \"([^\"]*)\"$")
	public void selRadioTVAntenna(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxRadioAntenna()
		.enterTextRadioAntennaLimit(data.get(9).get(7).toString())
		.selDdlRadioAntennaCoInsurance(data.get(9).get(8).toString())
		.selDdlRadioAntennaConstructionType(data.get(9).get(9).toString())
		.clickNextBtn()
		;
	}

	@When("^Selecting  Tents and Fabrics coverage \"([^\"]*)\"$")
	public void selTentsFabrics(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxTentsFabrics()
		.enterTextTentsFabricsLimit(data.get(9).get(7).toString())
		.selDdlTentsFabricsCoInsurance(data.get(9).get(8).toString())
		.selDdlTentsFabricsConstructionType(data.get(9).get(9).toString())
		.clickNextBtn()
		;
	}

	@When("^Selecting  Water/Sewage Lift Pumps coverage \"([^\"]*)\"$")
	public void selWaterSewageLiftPumps(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxWaterSewageLiftPumps()
		.enterTextWaterSewageLiftPumpsLimit(data.get(9).get(7).toString())
		.selDdlWaterSewageLiftPumpsCoInsurance(data.get(9).get(8).toString())
		.selDdlWaterSewageLiftPumpsConstructionType(data.get(9).get(9).toString())
		.clickNextBtn()
		;
	}
	@When("^Selecting  Rafts and Floating Equipment coverage \"([^\"]*)\"$")
	public void selRaftsFloatingEquipment(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxRaftsFloatingEquipment()
		.enterTextRaftsFloatingEquipmentLimit(data.get(9).get(7).toString())
		.selDdlRaftsFloatingEquipmentCoInsurance(data.get(9).get(8).toString())
		.clickRaftsFloatingEquipmentBasicGrpII()
		.clickNextBtn()
		;
	}

	@When("^Selecting  Special Class - NOC coverage \"([^\"]*)\"$")
	public void selSpecialClassNOC(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selChkBxSpecialClassNOC()
		.enterTextSpecialClassNOCLimit(data.get(9).get(7).toString())
		.selDdlSpecialClassNOCCoInsurance(data.get(9).get(8).toString())
		.clickSpecialClassNOCBasicGrpII()
		.clickNextBtn()
		;
	}
	@And("^Navigate To Next Screen$")
	public void next()
	{
		pf
		.clickNextBtn();
	}


	@And("^Verify Rating Worksheet$")
	public void checkRatingWorkSheet()
	{
		premiumPage
		.checkRatingWorkSheet()
		;
	}


	@And("Exit TO DashBoard")
	public void exitDashBoard()
	{
		premiumPage
		.clickExiTToDashBoard()
		.clickNoBtn()
		;
	}
	@Then("^Verify Pricing Screen$")
	public void checkPricing() throws InterruptedException
	{
		premiumPage
		.clickPricing()
		.checkIrpmEnabled("0.750")
		//.clickRate()
		.clickRate()
		.clickBtnContinuerating()
		.clickPricing()
		.cleraIrpm()
		.checkIrpmEnabled("0.650")
		.clickRate()
		.cleraIrpm()
		.checkIrpmEnabled("1.350")
		.clickRate()
		.cleraIrpm()
		.checkIrpmEnabled("0.750")
		//.clickRate()
		.clickRate()
		.clickBtnContinuerating()
		.clickPricing()
		;
	}
	@And("^User select Business Income Educational Institution coverage \"([^\"]*)\"$")
	@Then("^Verify user is able to select Business Income Educational Institution \"([^\"]*)\"$")
	public void selectBuisIncFromDepProp(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.clickBuisnessIncEduInst()
		.clickEdit()
		.selectPrometrixSchedule()
		.clickEdit()
		.enterBuisIncEdInsLmt(data.get(9).get(4).toString())
		.changeBIEIClassCode("0922")
		.selBuisIncEducInsCoInsurance(data.get(9).get(5).toString())
		;
	}
	@And("^Adding Coverage Business Income Educational Institution$")
	public void selectBuisIncEducationalIns()
	{
		pf
		.clickBuisnessIncEduInst()
		.clickEdit()
		;
	}
	@And("^Adding Coverage values for Business Income Educational Institution \"([^\"]*)\"$")
	public void selectBuisIncEducationalInsvalues(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.enterBuisIncEdInsLmt(data.get(9).get(4).toString())
		.changeBIEIClassCode("0702")
		.selBuisIncEducInsCoInsurance(data.get(9).get(5).toString())
		;
	}
	@Then("^Verify whether user is able to select Civil authority increased coverage period$")
	public void selCivilAuthIncCovPeriod()
	{
		pf
		.clickCivilAthIncCovPerd();
	}
	@Then("^Verify Number of days Dropdown and select value \"([^\"]*)\"$")
	public void checkNoDays(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.selNoOfDaysCivlAuth(data.get(9).get(6).toString())
		.clickNextBtn()
		;
	}
	@Then("^Check ProMetrix ELA Date$")
	public void checkPrometrix()
	{
		pf
		.clickBuilding001()
		.clickProMetrixLossCostDetails()
		.getELADistributionDate()
		;
	}
	@And("^Then Check ProMetrix ELA Date for other Location$")
	public void checkPrometrixOtherLoc()
	{
		pf
		.clickBuilding002()
		;
	}


}
