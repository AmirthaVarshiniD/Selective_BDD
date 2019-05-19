package com.api.cucumber.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.api.cucumber.comMethods.ProjMethods;


public class LobDetailsPage extends ProjMethods {
	PremiumSummaryPage premium = new PremiumSummaryPage(driver);
	public LobDetailsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	// ---- Policy Coverage and Limit Information-----
	//General Aggregate - GL
	@FindBy(how=How.ID,using="btnEachAccLmt")
	public static WebElement eleBttnEachAcctLmt;
	@FindBy(how=How.XPATH,using="(//td[@class='sigi-grid-cell']/input)[1]")
	public static WebElement eleSelGelAgg;
	public LobDetailsPage selGeneralAggregate()
	{
		click(eleBttnEachAcctLmt);
		click(eleSelGelAgg);
		return this;
	}
	//Property
	@FindBy(how=How.LINK_TEXT,using="Property")
	public static WebElement eleProperty;
	public PFPage clickProperty(){
		click(eleProperty);
		return new PFPage(driver);
	}
	//Loss free Year - GL,PF
	@FindBy(how=How.ID,using="ddlLossFreeYr")
	public static WebElement eleLossFreeYears;
	public LobDetailsPage selLossFreeYears(String data){
		selectDropDownUsingText(eleLossFreeYears, data);
		return this;
	}

	//Extension Option-GL
	@FindBy(how=How.ID,using="ddlExtension")
	public static WebElement eleExtnOptions;
	public LobDetailsPage selExtnOptions(String data){
		try {
			if (eleExtnOptions.isDisplayed()) {
				click(eleExtnOptions);
				selectDropDownUsingText(eleExtnOptions,data);	
			}
		} catch (WebDriverException e) {

		}

		return this;
	}


	//Loss Rated Policy
	@FindBy(how=How.ID,using="cboSRMLossRated")
	public static WebElement eleLossRatedPolicy;
	public LobDetailsPage selLossRatedPolicy(String data){
		try {
			if (eleLossRatedPolicy.isDisplayed()) {
				selectDropDownUsingText(eleLossRatedPolicy, data);
			}
		} catch (WebDriverException e) {
			System.out.println("Not Available");
		}

		return this;
	}

	//-----Policy Information----
	//Coverage Type - CF
	@FindBy(how=How.ID,using="ddlCfPolicyType")
	public static WebElement eleCoverageType;
	public LobDetailsPage selCoverageType(String data){
		selectDropDownUsingText(eleCoverageType, data);
		return this;
	}








	//Coverage Option -BOP
	@FindBy(how=How.XPATH,using="//div[@class='row']/following::select[@id='ddlCoverageOption']")
	public static WebElement eleCoverageOption;
	@FindBy(how=How.XPATH,using="//div[@class='row']/following::label[@id='lddlCoverageOption']")
	public static WebElement eleCoverageOptionTxt;
	public LobDetailsPage selCoverageOption(String data){
		System.out.println("--------"+eleCoverageOptionTxt.getText());
		selectDropDownUsingText(eleCoverageOption, data);
		return this;
	}
	//BOP Claims -BOP
	//Coverage Option -BOP
	@FindBy(how=How.ID,using="ddl3YrFree")
	public static WebElement eleBopClaims;
	public LobDetailsPage selBopClaims(String data){
		selectDropDownUsingText(eleBopClaims, data);
		return this;
	}
	@FindBy(how=How.LINK_TEXT,using="Next")
	public static WebElement eleNext;
	public LobDetailsPage clickNext(){
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next")));	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Next")));

		click(eleNext);
		return this;
	}
	@FindBy(how = How.ID, using = "NavNext")
	public static WebElement eleNavigateNext;

	public LobDetailsPage clickNavigateNext() {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", eleBtnNext);
		click(eleNavigateNext);
		return this;
	}

	//-----Extension Option-----
	//Verify Elite Pac Optional coverage is not avail - GL
	@FindBy(how=How.XPATH,using="//div[@class='formBox']")
	public static WebElement eleOptionalCoverages;
	public LobDetailsPage checkOptionalCoverages(){
		try {
			if(!(eleOptionalCoverages.getText()=="Elite Pac")){
				reportStep("Optional Coverage doesn't have Elite PAc ","PASS");	
			}} catch (WebDriverException e) {
				reportStep("Optional Coverage have Elite PAC", "FAIL");
			}
		return this;
	}


	//Click Edit on Policy Information
	@FindBy(how=How.ID,using="EditPolicyInfo")
	public static WebElement eleEditOnPolicyInfo;
	public LobDetailsPage clickEditOnPolicyInfo()
	{
		click(eleEditOnPolicyInfo);
		return this;
	}




	//-----Optional Coverages-----
	//Employee Benifits - GL
	@FindBy(how=How.ID,using="chkEmployeeBenefits")
	public static WebElement eleEmployeeBenefits;
	public LobDetailsPage selectEmployeeBenefits()
	{
		click(eleEmployeeBenefits);
		return this;
	}
	@FindBy(how=How.ID,using="cboNumEEs")
	public static WebElement eleNoOfEmps;
	public LobDetailsPage selectNoOFEmp()
	{
		selectDropDownUsingText(eleNoOfEmps, "50 - 99");
		return this;
	}
	@FindBy(how=How.ID,using="chkBeneSuppERPE")
	public static WebElement eleSuppERPE;
	public LobDetailsPage selSuppERPE(){
		click(eleSuppERPE);
		return this;
	}











	//-----City/Country Info-----
	//Protection Class - BOP
	@FindBy(how=How.ID,using="txtSwProtClass")
	public static WebElement eleProtClass;
	public LobDetailsPage enterSwProtectionClass(String data) 
	{
		eleProtClass.click();
		type(eleProtClass, data);
		return this;
	}
	//
	@FindBy(how=How.XPATH,using="(//label[@id='lCityHelp']/following::input)[2]")
	public static WebElement eleSearchCityHelp;
	@FindBy(how=How.ID,using="txtCityOverride_zipCode")
	public static WebElement eleCity;
	@FindBy(how=How.ID,using="txtCityOverride_searchOK")
	public static WebElement eleCityOverrideSearch;
	@FindBy(how=How.XPATH,using="(//div[@class='sigi-grid-item'])[1]")
	public static WebElement eleCityOverrideSearchtReslt;
	@FindBy(how=How.ID,using="txtCityOverride_listOK")
	public static WebElement eleCityOverrideSelect;

	public LobDetailsPage clickCityHelpSearch() {
		click(eleSearchCityHelp);
		eleCity.clear();
		click(eleCityOverrideSearch);
		click(eleCityOverrideSearchtReslt);
		click(eleCityOverrideSelect);
		return this;
	} 


	//Click on City/Country Information
	@FindBy(how=How.XPATH,using="//h2[text()='City/County Information ']")
	public static WebElement eleCityCountryInfo;
	public LobDetailsPage clickCitySerachBtn()
	{
		click(eleCityCountryInfo);
		return this;
	}
	//Click on City/Country Information
	@FindBy(how=How.XPATH,using="//h2[text()='City/County Information']")
	public static WebElement eleCityCountryInfoLink;
	public LobDetailsPage clickCityCountryInfo()
	{
		click(eleCityCountryInfoLink);
		return this;
	}
	//
	//Click on City/Country Information
	@FindBy(how=How.XPATH,using="(//div[@class='title'])[1]")
	public static WebElement eleCityCoutryInfo;
	public LobDetailsPage clickCityCountyInfo()
	{
		click(eleCityCoutryInfo);
		return this;
	}
	//Click on City/Country Information in Policy State Information Screen
	@FindBy(how=How.XPATH,using="(//h2[@class='expand'])[1]")
	public static WebElement eleCityCoutryInfoInPolicyScreen;
	public LobDetailsPage clickCityCountyInfoInPolicyScreen()
	{
		click(eleCityCoutryInfoInPolicyScreen);
		click(cityOverride);
		click(eleCitySearch1);
		eleCitySearch1.clear();
		type(eleCitySearch1, "DAYTONA BEACH");
		eleterritory.clear();
		type(eleterritory, "101");
		return this;
	}
	//Click on City/Country Information in vehicle or drivers screen
	@FindBy(how=How.XPATH,using="(//h2[@class='expand'])[1]")
	public static WebElement eleCityCoutryInfoInVehicleScreen;
	public LobDetailsPage clickCityCountyInfoInVehicleScreen()
	{
		click(eleCityCoutryInfoInVehicleScreen);
		return this;
	}
	//Territory 
	@FindBy(how=How.ID,using="hlpAuStTerr")
	public static WebElement eleTerr;
	public LobDetailsPage enterTerr()
	{
		type(eleTerr, "101");
		eleTerr.sendKeys(Keys.TAB);
		return this;
	}

	@FindBy(how=How.ID,using="cboTerritory")
	public static WebElement eleterritory;
	public LobDetailsPage enterTerritory(String data)
	{
		type(eleterritory, data);
		return this;
	}
	//Territory in vehicle screen
	@FindBy(how=How.ID,using="VC_hlpTerr")
	public static WebElement eleTerritoryVeh;
	public LobDetailsPage enterTerritoryinVehScreen(String data)
	{
		click(eleTerritoryVeh);

		type(eleTerritoryVeh, data);
		return this;
	}
	//Search city in City country info
	@FindBy(how=How.XPATH,using="(//div[@id='divCfCityKey']/input)[2]")
	public static WebElement eleCitySearch;
	@FindBy(how=How.ID,using="txtCfCityKey_searchOK")
	public static WebElement eleSearcht;
	@FindBy(how=How.XPATH,using="(//div[@class='sigi-grid-item'])[1]")
	public static WebElement eleSearchtReslt;
	@FindBy(how=How.ID,using="txtCfCityKey_listOK")
	public static WebElement eleSelect;
	public LobDetailsPage clickSelect() {
		click(eleCitySearch);
		click(eleSearcht);
		click(eleSearchtReslt);
		click(eleSelect);
		return this;
	} 


	//Search city in City country info
	@FindBy(how=How.XPATH,using="(//input[@id='txtCityHelp']/following-sibling::input)[1]")
	public static WebElement eleCitySearchButtn;
	@FindBy(how=How.ID,using="txtCityHelp_zipCode")
	public static WebElement eleZipCode;
	@FindBy(how=How.XPATH,using="(//div[@class='inlineButtons']/a)[1]")
	public static WebElement eleSearchButtn;
	@FindBy(how=How.XPATH,using="//table[@id='txtCityHelp_grid_grid']/tbody/tr")
	public static WebElement eleCitySearchtReslt;
	@FindBy(how=How.XPATH,using="(//div[@class='inlineButtons']/a)[3]")
	public static WebElement eleSelectNButtn;
	public LobDetailsPage clickSelectCity() {
		click(eleCitySearchButtn);
		//type(eleZipCode, "32114");
		click(eleSearchButtn);
		click(eleCitySearchtReslt);
		click(eleSelectNButtn);
		return this;
	} 
	//City Override chkCityOverride
	@FindBy(how=How.ID,using="chkCityOverride")
	public static WebElement eleCheckBoxCityHelp;
	public LobDetailsPage verifyCityHelpCheckBox() {
		verifySelected(eleCheckBoxCityHelp);
		return this;
	}
	//Click On City Override
	public LobDetailsPage clickCityHelpCheckBox() {
		click(eleCheckBoxCityHelp);
		return this;

	}

	//Garage Class Code
	@FindBy(how = How.ID, using = "txttxtAUGarClassCd")
	public static WebElement eleCityCode;
	public LobDetailsPage enterGarageClassCode() throws AWTException, InterruptedException {
		type(eleCityCode, "A");
		Robot city = new Robot();
		city.keyPress(KeyEvent.VK_ENTER);
		city.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@id='txttxtAUGarClassCd_grid_grid']//tr[2]//td[3]")).click();
		return this;
	}
	//Medical Payments 
	@FindBy(how = How.ID, using = "cboAuMedPayment")
	public static WebElement eleMedPayments;
	@FindBy(how = How.ID, using = "cboAUMedPayType")
	public static WebElement eleMedPaymentsType;
	public LobDetailsPage selectMedPayments(String data) {
		selectDropDownUsingText(eleMedPayments, data);
		return this;
	}
	//Medical Payments Type
	public LobDetailsPage selectMedPaymentsType(String data) {
		try
		{
			if (eleMedPaymentsType.isDisplayed()) {
				click(eleMedPaymentsType);
				moveToElement(eleMedPaymentsType);
				selectDropDownUsingText(eleMedPaymentsType, data);
				//selectDropDownUsingIndex(eleMedPaymentsType, 1);

			}
		}catch (WebDriverException e) {
			System.out.println("Not Available");
		}
		return this;
	}
	//Employee Class
	@FindBy(how = How.ID, using = "txtFT1A")
	public static WebElement eleEmployeeFullTimetextbox;
	public LobDetailsPage enterEmployeeFullTime() {
		try
		{
			if (eleEmployeeFullTimetextbox.isDisplayed()) {
				click(eleEmployeeFullTimetextbox);
				type(eleEmployeeFullTimetextbox, "1");
			}
		}catch (WebDriverException e) {
			System.out.println("Not Available");
		}


		return this;
	}
	//Building 001
	@FindBy(how = How.LINK_TEXT,using="Building 001")
	public static WebElement eleBuilding001;
	public LobDetailsPage clickBuilding() {
		click(eleBuilding001);

		return this;
	}
	//Dealers Physical damage 
	@FindBy(how = How.XPATH,using="//h2[contains(text(),'Dealers Physical Damage')]")
	public static WebElement eleDealersPhysicalDamage;
	public LobDetailsPage clickDealersPhysicalDamage() {
		click(eleDealersPhysicalDamage);
		return this;
	}
	//Dealers Physical damage - Limit
	@FindBy(how = How.ID,using="ddlFlsPrtnsLmt")
	public static WebElement eleFalsePretenseLimit;
	public LobDetailsPage selFalsePretenseLimit(String data) {
		click(eleFalsePretenseLimit);
		selectDropDownUsingText(eleFalsePretenseLimit, data);
		return this;
	}
	//False Pretense Covergae - Value 
	@FindBy(how = How.ID,using="txtFlsPrtnsVal")
	public static WebElement eleFalsePretenseValue;
	public LobDetailsPage enterFalsePretenseValue(String data) {
		click(eleFalsePretenseValue);
		type(eleFalsePretenseValue, data);
		return this;
	}
	//False Pretense Deductible 
	@FindBy(how = How.ID,using="ddlFlsPrtnsDeduct")
	public static WebElement eleFalsePretenseDeductible;
	public LobDetailsPage selFalsePretenseDeductible() {
		click(eleFalsePretenseDeductible);
		selectDropDownUsingIndex(eleFalsePretenseDeductible, 1);
		return this;
	}
	//Hired or Owned 
	//Non-Owned
	@FindBy(how = How.ID, using = "txtAuNonOwned")
	public static WebElement eleNonOwned;
	public LobDetailsPage enterNonOwned(String data) {
		click(eleNonOwned);
		type(eleNonOwned, data);
		eleNonOwned.sendKeys(Keys.TAB);
		return this;
	}

	@FindBy(how=How.XPATH,using="//input[@id='txtPfBasicGrp1']")
	public static WebElement elePFBasicGrp1;
	public LobDetailsPage checkPFBasicGrp1(String data){
		verifyPartialAttribute(elePFBasicGrp1, "value", data);
		return this;
	}

	@FindBy(how=How.XPATH,using="//input[@id='txtPfSpecTerr']")
	public static WebElement elePfSpecTerr;
	public LobDetailsPage checkPfSpecTerr1(String data){
		verifyPartialAttribute(elePfSpecTerr, "value", data);
		return this;
	}

	@FindBy(how=How.ID,using="txtPfTaxDist")
	public static WebElement eleTaxDistrict;
	public LobDetailsPage checkTaxDistrictFieldIsEnabled() 
	{
		verifyEnabled(eleTaxDistrict);
		return this;

	} 
	//-----Class code Information-----
	//Building limit - BOP 
	@FindBy(how=How.ID,using="txtbldglimit")
	public static WebElement eleBuildingLmt;
	public LobDetailsPage enterBuildingLmt(String data) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(eleBuildingLmt));
		type(eleBuildingLmt, data);
		return this;

	}
	//BPP limit
	@FindBy(how=How.ID,using="txtbpplimit")
	public static WebElement eleBPPLmt;
	public LobDetailsPage enterBPPLmt(String data) 
	{
		type(eleBPPLmt, data);
		return this;

	}
	//Apply Governing Class Code
	@FindBy(how=How.LINK_TEXT,using="Apply Governing Class Code")
	public static WebElement eleApplyGovClassCode;
	public LobDetailsPage clickApplyGovClassCode() 
	{
		click(eleApplyGovClassCode);
		return this;

	}

	//Habitational Exposure
	@FindBy(how=How.ID,using="radHabitYes")
	public static WebElement eleRadHabitYes;
	public LobDetailsPage clickHabitExposureYes() 
	{
		click(eleRadHabitYes);
		return this;
	}
	//Radio -Percent building occupied by Habitational
	@FindBy(how=How.ID,using="txtHabPcnt")
	public static WebElement eleHabPercent;
	public LobDetailsPage enterHabPercent(String data) 
	{
		type(eleHabPercent, data);
		return this;
	}
	//Habitational Units
	@FindBy(how=How.ID,using="txtHabUnit")
	public static WebElement eleHabUnits;
	public LobDetailsPage enterHabUnits(String data) 
	{
		type(eleHabUnits, data);
		return this;
	}
	//Radio - Hardwired Smoke
	@FindBy(how=How.ID,using="radHabHWYes")
	public static WebElement eleHabHWYes;
	public LobDetailsPage clickhabHWYes() 
	{
		click(eleHabHWYes);
		return this;
	}
	//Radio - Grease producing Cooking exposure
	@FindBy(how=How.ID,using="radCookingNo")
	public static WebElement eleGreaseCookinNo;
	public LobDetailsPage clickGreaseCookinNo() 
	{
		click(eleGreaseCookinNo);
		return this;
	}

	//----GL Classification---
	//Class code Information - ST env
	@FindBy(how=How.XPATH,using="(//input[@class='btnGo'])[2]")
	public static WebElement eleSearch;
	@FindBy(how=How.CLASS_NAME,using="sigi-grid-item")
	public static WebElement eleSearchResult;
	@FindBy(how=How.XPATH,using="//a[@id='classCodeLoc_select']/span/strong")
	public static WebElement eleBtnSelect;

	@FindBy(how=How.ID,using="classCodeLoc")
	public static WebElement eleEnterClassCode;
	public LobDetailsPage enterClassCode(String data)
	{
		type(eleEnterClassCode, data);
		click(eleSearch);
		click(eleSearchResult);
		click(eleBtnSelect);
		return this;
	}

	//Class code Information - SLT
	@FindBy(how=How.XPATH,using="(//input[@class='btnGo'])[2]")
	public static WebElement eleSearchBtn;
	@FindBy(how=How.CLASS_NAME,using="classCodeSearchText")
	public static WebElement eleEnterClassCodeSLT;
	@FindBy(how=How.ID,using="txtClassCode_search")
	public static WebElement eleSearchSLT;
	@FindBy(how=How.XPATH,using="//table[@id='txtClassCode_grid_grid']/tbody/tr")
	public static WebElement eleSearchResultSLT;
	@FindBy(how=How.ID,using="txtClassCode_select")
	public static WebElement eleBtnSelectSLT;
	public LobDetailsPage enterClassCodeinSLT(String data)
	{
		click(eleSearchBtn);
		type(eleEnterClassCodeSLT, data);
		click(eleSearchSLT);
		System.out.println("----"+eleSearchResultSLT.getText());
		click(eleSearchResultSLT);
		click(eleBtnSelectSLT);
		return this;
	}

	//Class code Search
	@FindBy(how=How.XPATH,using="//a[@class='ButtonStyle8']/span/strong")
	public static WebElement eleSearchBtnSLT;
	@FindBy(how=How.XPATH,using="(//table[@class='sigi-grid-table']/tbody/tr)[1]")
	public static WebElement eleSearchRslt;
	@FindBy(how=How.XPATH,using="(//div[@class='inlineButtons']/following::a)[1]")
	public static WebElement eleSelectSLT;
	public LobDetailsPage enterClassCodeSLT(String data)
	{
		click(eleSearchBtn);
		type(eleEnterClassCodeSLT, data);
		click(eleSearchBtnSLT);
		click(eleSearchRslt);
		click(eleSelectSLT);

		return this;
	}

	//Governing Class code - SLT - BOP
	@FindBy(how=How.XPATH,using="//input[@id='GovClassCode']/following-sibling::input")
	public static WebElement eleGovSearchBtn;
	@FindBy(how=How.ID,using="GovClassCode_classCodeText")
	public static WebElement eleEnterGovClassCodeSLT;
	@FindBy(how=How.ID,using="GovClassCode_chkFullText")
	public static WebElement eleGovClassCodeChk;
	@FindBy(how=How.ID,using="GovClassCode_search")
	public static WebElement eleGovSearchSLT;
	@FindBy(how=How.XPATH,using="//table[@id='GovClassCode_grid_grid']/tbody/tr")
	public static WebElement eleGovClassCodeSearchResultSLT;
	@FindBy(how=How.ID,using="GovClassCode_select")
	public static WebElement eleGovClassCodeSelectSLT;
	public LobDetailsPage enterGovClassCodeinSLT(String data)
	{
		click(eleGovSearchBtn);
		type(eleEnterGovClassCodeSLT, data);
		click(eleGovClassCodeChk);
		click(eleGovSearchSLT);
		//System.out.println("----"+eleSearchResultSLT.getText());
		click(eleGovClassCodeSearchResultSLT);
		click(eleGovClassCodeSelectSLT);
		return this;
	}
	//Protection Class
	@FindBy(how=How.ID,using="txtPfProtClass")
	public static WebElement eleProtectionClass;
	public LobDetailsPage enterProtectionClass(String data)
	{
		type(eleProtectionClass, data);
		click(eleSearch);
		click(eleSearchResult);
		click(eleBtnSelect);
		return this;
	}
	//Premium Basis - GL
	@FindBy(how=How.XPATH,using="(//input[@class='TextBox'])[1]")
	public static WebElement eleEnterPremiumBasis;
	public LobDetailsPage enterPremiumBasis(String data){
		click(eleEnterPremiumBasis);
		type(eleEnterPremiumBasis, data);
		return this;
	}

	//Year Built - BOP
	@FindBy(how=How.ID,using="txtYearBuilt")
	public static WebElement eleYrBuilt;
	public LobDetailsPage enterYrBuilt(String data){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(eleYrBuilt));
		eleYrBuilt.click();
		type(eleYrBuilt, data);
		return this;
	}

	//ProMetrix Year built Override reason 
	@FindBy(how=How.ID,using="txtYearBildOverride")
	public static WebElement eleProMetrixYrBuiltOverride;
	public LobDetailsPage enterProMetrixYrBuiltOverride(String data){
		type(eleProMetrixYrBuiltOverride, data);
		return this;
	}
	//ProMetrix Total building area Override reason 
	@FindBy(how=How.ID,using="txtSquareOverride")
	public static WebElement eleProMetrixSquareOverride;
	public LobDetailsPage enterProMetrixSquareOverride(String data){
		type(eleProMetrixSquareOverride, data);
		return this;
	}
	//ProMetrix Sprinkler Override reason 
	@FindBy(how=How.ID,using="txtSprinklerOverride")
	public static WebElement eleProMetrixSprinklerOverride;
	public LobDetailsPage enterProMetrixSprinklerOverride(String data){
		type(eleProMetrixSprinklerOverride, data);
		return this;
	}

	//ProMetrix Construction Override reason 
	@FindBy(how=How.ID,using="txtConstructionOverride")
	public static WebElement eleProMetrixConstructionOverride;
	public LobDetailsPage enterProMetrixConstructionOverride(String data){
		type(eleProMetrixConstructionOverride, data);
		return this;
	}

	//ProMetrix No of Stories Override reason 
	@FindBy(how=How.ID,using="txtNoStoriesOverride")
	public static WebElement eleProMtrxNoStoriesOverride;
	public LobDetailsPage enterProMtrxNoStoriesOverride(String data){
		type(eleProMtrxNoStoriesOverride, data);
		return this;
	}

	//Alternate Power Generation -YES
	@FindBy(how=How.ID,using="radSwEBAltPowerIndY")
	public static WebElement eleSWEPAltPowerGenYes;
	public LobDetailsPage clickAltPowergenYes(){
		click(eleSWEPAltPowerGenYes);
		return this;
	}

	//Alternate Power Generation - Wind Turbines, Fuel cells, Micro turbines
	@FindBy(how=How.ID,using="chkSwEBAltPowerPhoto")
	public static WebElement eleSWEBAltPowerPhoto;
	public LobDetailsPage clickSWEBAltPowerPhoto(){
		click(eleSWEBAltPowerPhoto);
		return this;
	}
	//Alternate Power Generation -  Fuel cells 
	@FindBy(how=How.ID,using="chkSwEBAltPowerFuel")
	public static WebElement eleSWEBAltPowerFuel;
	public LobDetailsPage clickSWEBAltPowerFuel(){
		click(eleSWEBAltPowerFuel);
		return this;
	}
	//Protective Classes -Other
	@FindBy(how=How.ID,using="chkAutoFire")
	public static WebElement eleAutoFire;
	public LobDetailsPage clickAutoFire(){
		click(eleAutoFire);
		return this;
	}

	//Alternate Power Generation supplement questionnare 
	@FindBy(how=How.ID,using="mskDateCompleted_Text")
	public static WebElement eleDateCompleted;
	public LobDetailsPage enterDateCompleted(String data){
		type(eleDateCompleted, data);
		return this;
	}
	//Update Button
	@FindBy(how=How.ID,using="btnDateUpdated")
	public static WebElement eleUpdate;
	public LobDetailsPage clickUpdate(){
		click(eleUpdate);
		return this;
	}
	//Questionnare Complete  -Yes
	@FindBy(how=How.XPATH,using="(//div[@class='ui-dialog-buttonset']/button)[1]")
	public static WebElement eleYes;
	public LobDetailsPage clickYes(){
		click(eleYes);
		return this;
	}

	//Property Type
	@FindBy(how=How.ID,using="ddlPropertyType")
	public static WebElement elePropertyType;
	public LobDetailsPage selectPropertyType(String data){
		selectDropDownUsingText(elePropertyType, data);
		return this;
	}

	//-----Equipment breakDown rated Information-----
	//HSB Premium
	@FindBy(how=How.ID,using="txtHSBFlat")
	public static WebElement eleHSBPremium;
	public LobDetailsPage enterHSBPremium(String data){
		type(eleHSBPremium, data);
		return this;
	}


	//------Building Updates-----
	//Percent Building Occupied by insured -BOP
	@FindBy(how=How.ID,using="txtPercent")
	public static WebElement eleBuildingPercent;
	public LobDetailsPage enterBuildingPercent(String data){
		type(eleBuildingPercent, data);
		return this;
	}
	//Total Building Units - BOP
	@FindBy(how=How.ID,using="txtSquare")
	public static WebElement eleBuildingUnits;
	public LobDetailsPage enterBuildingUnits(String data){
		type(eleBuildingUnits, data);
		return this;
	}
	//Sales/Rent -BOP
	@FindBy(how=How.ID,using="txtSales")
	public static WebElement eleSales;
	public LobDetailsPage enterSales(String data){
		type(eleSales, data);
		return this;
	}
	//Construction -BOP
	@FindBy(how=How.ID,using="ddlConstruct")
	public static WebElement eleBuildConstruction;
	public LobDetailsPage selectBuildConstruction(String data){
		selectDropDownUsingText(eleBuildConstruction, data);
		return this;
	}
	//txtNoStories
	@FindBy(how=How.ID,using="txtNoStories")
	public static WebElement eleNoOfStories;
	public LobDetailsPage enterStories(String data){
		type(eleNoOfStories, data);
		return this;
	}

	//ProMetrix Schedule

	@FindBy(how=How.XPATH,using="(//div[@class='ListView']/table/tbody/tr)[2]")
	public static WebElement elebuildAddrs;
	public LobDetailsPage selectBuildAddrs(){
		click(elebuildAddrs);
		return this;
	}

	//Tax District - Location Information - Cf
	@FindBy(how=How.ID,using="txtTaxDistrict")
	public static WebElement eleTaxDistrictCf;
	public LobDetailsPage enterTaxDistrict(){
		type(eleTaxDistrictCf, "1002");
		return this;
	}




	//Location Information
	@FindBy(how=How.XPATH,using="(//div[@id='divCityHelp']/input)[2]")
	public static WebElement eleCitySearchBtn;
	@FindBy(how=How.ID,using="txtCityOverride_searchOK")
	public static WebElement eleSearchOk;
	@FindBy(how=How.XPATH,using="(//div[@class='sigi-grid-item'])[1]")
	public static WebElement eleSearchtRslt;
	@FindBy(how=How.ID,using="txtCityOverride_listOK")
	public static WebElement eleSel;

	public LobDetailsPage clickCitySerach(){
		click(eleCitySearchBtn);
		click(eleSearchOk);
		click(eleSearchtRslt);
		click(eleSel);
		return this;
	}


	//Location Information

	@FindBy(how=How.XPATH,using="//h2[text()='Location Information ']")
	public static WebElement eleLocInfo;
	@FindBy(how=How.ID,using="cboTerritory")
	public static WebElement eleTerritory;
	public LobDetailsPage clickLocationInfo(){
		click(eleLocInfo);
		reportStep("The element "+ eleTerritory.isEnabled()+" is enabled","PASS");
		return this;
	}

	//Click on City OverRide checkBox
	@FindBy(how=How.ID,using="chkOverride")
	public static WebElement eleCityOverRide;
	public LobDetailsPage clickCityOverRide(){
		click(eleCityOverRide);
		return this;
	}
	//Clear Territory	
	@FindBy(how=How.ID,using="cboTerritory")
	public static WebElement eleTerritoryValue;
	public LobDetailsPage clearTerritory(){
		click(eleTerritoryValue);
		eleTerritoryValue.clear();
		return this;
	}
	//Type Special Territory
	@FindBy(how=How.ID,using="txtPfCspTerr")
	public static WebElement eleTerritoryCode;
	public LobDetailsPage typeTerritory(String data){
		click(eleTerritoryCode);
		type(eleTerritoryCode, data);
		return this;
	}

	//Clear Tax District
	@FindBy(how=How.ID,using="txtTaxDistrict")
	public static WebElement eleCfTaxDistrict;
	public LobDetailsPage clearTaxDistrict(){
		click(eleCfTaxDistrict);
		eleCfTaxDistrict.clear();
		return this;
	}

	//Location Coverage - Buisness Income - Educational Institution

	@FindBy(how=How.ID,using="chkpnlTu")
	public static WebElement eleChkboxBuisnessIncEduIns;
	public LobDetailsPage selectBuisnessIncEduIns(){
		click(eleChkboxBuisnessIncEduIns);
		return this;
	}
	//Click Edit on Buisness Income - Educational Institution
	@FindBy(how=How.XPATH,using="//a[@id='editpnlTu']")
	public static WebElement eleEditOnBIEI;
	public LobDetailsPage clickEditonBusIncEduIns(){
		click(eleEditOnBIEI);
		return this;
	}

	//Location Coverage - Buisness Income with Extra expense

	@FindBy(how=How.ID,using="chkpnlBI")
	public static WebElement eleChkboxBuisnessIncExtraExp;
	public LobDetailsPage selectBuisnessIncExtraExp(){
		click(eleChkboxBuisnessIncExtraExp);
		return this;
	}
	//Click Edit on Buisness Income with Extra expense
	@FindBy(how=How.XPATH,using="//a[@id='editpnlBI']")
	public static WebElement eleEditOnBIEE;
	public LobDetailsPage clickEditonBusIncExtraExp(){
		click(eleEditOnBIEE);
		return this;
	}


	@FindBy(how=How.ID,using="SIGI_DialogURL")
	public static WebElement eleFrame;
	@FindBy(how=How.XPATH,using="(//tr[@class='ListViewRow']/td)[1]")
	public static WebElement eleFirstResult;
	public LobDetailsPage clickFirstResult(){
		//switchToFrame(eleFrame);
		click(eleFirstResult);
		return this;
	}

	// vErify Cause of Loss Reason for - Buisness Income - Educational Institution
	@FindBy(how=How.XPATH,using="//label[@id='ltxtCauseOfLoss2']")
	public static WebElement eleCauseOfLossOnBIEI;
	public LobDetailsPage verifyCauseOfLossOnBIEI(){
		System.out.println("------------ "+eleCauseOfLossOnBIEI.getText());
		verifyPartialText(eleCauseOfLossOnBIEI, "SPECIAL (OTHER)");
		return this;
	}

	//vErify Cause of Loss Reason for - Buisness Income with Extra expense
	@FindBy(how=How.XPATH,using="//label[@id='ltxtCauseOfLoss2']")
	public static WebElement eleCauseOfLossOnBIEE;
	public LobDetailsPage verifyCauseOfLossOnBIEE(){
		System.out.println("------------ "+eleCauseOfLossOnBIEE.getText());
		verifyPartialText(eleCauseOfLossOnBIEE, "SPECIAL (OTHER)");
		return this;
	}

	//Cancel
	@FindBy(how=How.ID,using="btnCancel")
	public static WebElement eleBtnCancel;
	public LobDetailsPage clickCancel(){
		click(eleBtnCancel);
		return this;
	}


	//Optional Coverages - Broad form Products
	@FindBy(how=How.XPATH,using="//div/h4[text()='Optional Coverages ']")
	public static WebElement eleOptionalpac;
	public LobDetailsPage clickOptionalPac(){
		click(eleOptionalpac);
		return this;
	}
	//Verify Broad Form Products optional coverage avail
	@FindBy(how=How.XPATH,using="//div[@class='showhide_wrap shadow2']")
	public static WebElement eleCheckOptionalpac;
	public LobDetailsPage checkOptionalCoveragesForBroadFormProducts(){
		try {
			verifyPartialText(eleCheckOptionalpac, "Broad Form Products");
			reportStep("Optional Coverage have Broad Form Products optional coverage ","PASS");	
		} catch (WebDriverException e) {
			reportStep("Optional Coverage doesn't have Broad Form Products optional coverage", "FAIL");
		}

		return this;
	}
	//Base Rates

	@FindBy(how=How.XPATH,using="//div[@class='validation-fail-elem']/input")
	public static WebElement eleBaseRates;
	public LobDetailsPage enterBaseRates(String data){
		type(eleBaseRates, data);
		return this;
	}
	//----- Location Overides------
	//Base Rates -GL
	@FindBy(how=How.XPATH,using="(//div[@class='row']/label/following-sibling::input)[37]")
	public static WebElement eleBaseRate;
	public LobDetailsPage enterBaseRate(String data){
		type(eleBaseRate, data);
		return this;
	}
	//Enter Documentation
	@FindBy(how=How.XPATH,using="(//textarea[@class='MultLineTextBox'])[1]")
	public static WebElement eleTextAreaDoc;
	public LobDetailsPage enterDocumentation(String data){
		type(eleTextAreaDoc, data);
		return this;
	}
	//Base Rates -GL
	@FindBy(how=How.XPATH,using="(//div[@class='row']/label/following-sibling::input)[42]")
	public static WebElement eleBaseRte;
	public LobDetailsPage enterBaseRte(String data){
		type(eleBaseRte, data);
		return this;
	}
	//Enter Documentation
	@FindBy(how=How.XPATH,using=" (//textarea[@class='MultLineTextBox'])[2]")
	public static WebElement eleDoc;
	public LobDetailsPage enterDocumentations(String data){
		type(eleDoc, data);
		return this;
	}

	//Description
	@FindBy(how=How.XPATH,using="(//textarea[@class='MultLineTextBox'])[2]")
	public static WebElement eleDesc;
	public LobDetailsPage enterDescription(String data){
		type(eleDesc, data);
		return this;
	}

	//Filling Indicator
	@FindBy(how=How.XPATH,using="(//input[contains(text(),cboFilingInd_Text)])[149]")
	public static WebElement eleFillingInd;
	public LobDetailsPage enterFillingIndicator(String data){
		type(eleFillingInd, data);
		return this;
	}

	//Premium Basis
	@FindBy(how=How.XPATH,using="(//input[contains(text(),cboFilingInd_Text)])[151]")
	public static WebElement elePremiumBasis;
	public LobDetailsPage enterPremiumBasisr(String data){
		type(elePremiumBasis, data);
		return this;
	}

	//Rate Basis
	@FindBy(how=How.XPATH,using="(//input[contains(text(),cboFilingInd_Text)])[153]")
	public static WebElement eleRateBasis;
	public LobDetailsPage enterRateBasis(String data){
		type(eleRateBasis, data);
		return this;
	}


	//---Coverage Agreements---- 
	//Guest Property - in Safe Deposit Boxes - CF
	@FindBy(how=How.ID,using="chkspliCovGPIp")
	public static WebElement eleGuestProp;
	public LobDetailsPage clickCoverageAggGuestProp(){
		click(eleGuestProp);
		return this;
	}
	//Limit of Insurance
	@FindBy(how=How.ID,using="lLimitIns")
	public static WebElement eleLimitOFInsGPIP;
	public LobDetailsPage enterCoverAggrGPIp(String data){
		type(eleLimitOFInsGPIP, data);
		return this;
	}

	//Inside  premises - Theft of money & Securities Crime Fidelity - CF
	@FindBy(how=How.ID,using="chkspliCovItpTms")
	public static WebElement eleTheftOfMony;
	public LobDetailsPage clickThefOfmoneyAndSec(){
		click(eleTheftOfMony);
		return this;
	}
	//Insurance Lmt
	@FindBy(how=How.ID,using="txtLimit")
	public static WebElement eleInsLmt;
	public LobDetailsPage enterInsLin(){
		type(eleInsLmt, "425000");
		return this;
	}
	//Deductible
	@FindBy(how=How.ID,using="cboDeduct_Text")
	public static WebElement eleDeductible;
	public LobDetailsPage enterDeductible(){
		type(eleDeductible, "1000");
		return this;
	}

	//OK
	@FindBy(how=How.LINK_TEXT,using="OK")
	public static WebElement eleBttnOk;
	public LobDetailsPage clickOkBttn(){
		if (eleBttnOk.isDisplayed()) {
			click(eleBttnOk);
		}
		else
		{
			System.out.println("Not Available");
		}
		return this;
	}
	//OK in Auto Data Prefill

	@FindBy(how=How.XPATH,using="//span[@class='ui-button-text']")
	public static WebElement eleOkInAutoDataPreFill;
	public LobDetailsPage clickOkInAutoDataPrefill(){
		try {
			if (eleOkInAutoDataPreFill.isDisplayed()) {	
				click(eleOkInAutoDataPreFill);
				clickVehicleSummary();
			}

		} catch (Exception e) {
			System.out.println("Not Available");
		}

		return this;
	}
	public LobDetailsPage clickOkButton(){
		try {
			if (eleOkInAutoDataPreFill.isDisplayed()) {	
				click(eleOkInAutoDataPreFill);

			}

		} catch (Exception e) {
			System.out.println("Not Available");
		}

		return this;
	}
	@FindBy(how=How.XPATH,using="//span[@class='ui-button-text']")
	public static WebElement eleOkInStateLevelScreen;
	public LobDetailsPage clickOkInStateLevelScreen(){
		try {
			if (eleOkInStateLevelScreen.isDisplayed()) {	
				click(eleOkInStateLevelScreen);
				clickNext()
				;
			}

		} catch (Exception e) {
			System.out.println("Not Available");
		}

		return this;
	}
	//Click Ok on walkthrough
	@FindBy(how=How.XPATH,using="//a[@id='btnWalkThru']/span/strong")
	public static WebElement eleOk;
	public LobDetailsPage clickOk(){
		click(eleOk);
		return this;
	}
	@FindBy(how=How.XPATH,using="//a[@id='navForward']")
	public static WebElement eleButtonNext;
	public LobDetailsPage clickNextButton(){
		click(eleButtonNext);
		return this;
	}
	@FindBy(how=How.ID,using="btnNext")
	public static WebElement eleNextBtn;
	public LobDetailsPage clickNextBtn(){
		click(eleNextBtn);
		return this;
	}

	@FindBy(how=How.ID,using="navForward")
	public static WebElement eleNextBttn;
	public LobDetailsPage clickNextBttn(){
		click(eleNextBttn);
		return this;
	}

	//Next button in Location overrides screen
	@FindBy(how=How.XPATH,using="//a[@id='navForward']")
	public static WebElement eleNextt;
	public LobDetailsPage clickBtnNext(){
		click(eleNextt);
		return this;
	}
	//Next to Premium Summary
	@FindBy(how=How.LINK_TEXT,using="Next to Premium Summary")
	public static WebElement eleNextToPremiumSum;
	public LobDetailsPage clickNextToPremiumSum(){
		click(eleNextToPremiumSum);
		return this;
	}
	@FindBy(how=How.LINK_TEXT,using="Rate")
	public static WebElement eleBtnRate;
	public PremiumSummaryPage clickRate(){
		click(eleBtnRate);	
		try
		{
			if (eleBtnContinueRate.isDisplayed()) 
			{
				click(eleBtnContinueRate);
			}
		}catch (WebDriverException e) {
			System.out.println("Continue rating Button is Not dispalyed");
		}
		finally {
			premium
			.getPremmiumSummary();
		}

		return new PremiumSummaryPage(driver);
	}
	//Edit auto Lob
	@FindBy(how=How.LINK_TEXT,using="Edit Auto LOB")
	public static WebElement eleEditAutoLob;
	public LobDetailsPage clickEditAutoLob(){
		click(eleEditAutoLob);
		return this;
	}

	//Click No

	@FindBy(how=How.ID,using="btnNo")
	public static WebElement eleNoBtn;
	public ComLinesAutoSysPage clickNoBtn()
	{
		click(eleNoBtn);
		return new ComLinesAutoSysPage(driver);
	}

	//Click on Location Overrides
	@FindBy(how=How.XPATH,using="(//div[@class='showhide_wrap shadow2']/div/h4)[19]")
	public static WebElement eleLocationOverrides;
	public LobDetailsPage clickLocationOverrides()
	{
		click(eleLocationOverrides);
		return this;
	}

	//Navigate To Policy Details Tab
	@FindBy(how=How.LINK_TEXT,using="Policy Details")
	public static WebElement elePolicyDetails;
	public PolicyDetailsPage clickPolicyDetails()
	{
		click(elePolicyDetails);
		return new PolicyDetailsPage(driver);
	}
	//Edit Crime Fidelity Lob
	@FindBy(how=How.LINK_TEXT,using="Edit Crime Fidelity LOB")
	public static WebElement eleEditCFt;
	public LobDetailsPage clickEditCF()
	{
		click(eleEditCFt);
		return new LobDetailsPage(driver);
	}

	//PH LOB
	@FindBy(how=How.ID,using="cboOccurLimit")
	public static WebElement eleOccuranceLmt;
	public LobDetailsPage selOccuranceLmt(String data){
		selectDropDownUsingText(eleOccuranceLmt, data);
		return this;
	}
	@FindBy(how=How.ID,using="cboClass")
	public static WebElement eleClassCodeOrDesc;
	public LobDetailsPage selClassCode(String data){
		selectDropDownUsingText(eleClassCodeOrDesc, data);
		return this;
	}

	@FindBy(how=How.ID,using="txtExposure")
	public static WebElement eleExposure;
	public LobDetailsPage enterExposure(String data){
		type(eleExposure, data);
		return this;
	}
	//
	@FindBy(how=How.ID,using="cboDeductible")
	public static WebElement eleDdDeductible;
	public LobDetailsPage selDeductible(String data){
		selectDropDownUsingText(eleDdDeductible, data);
		return this;
	}

	//------Automobile LOB------
	//-----Liability-----
	//Liability Symbol


	@FindBy(how=How.XPATH,using="(//input[@id='txtAULiabSymbol']/following-sibling::input)")
	public static WebElement eleAULiabSymbol;
	@FindBy(how=How.XPATH,using="(//table[@id='txtAULiabSymbol_grid_grid']/tbody/tr)[6]")
	public static WebElement eleAULiabSymbolReslt;
	public LobDetailsPage enterAULiabSymbol()
	{
		click(eleAULiabSymbol);
		click(eleAULiabSymbolReslt);
		return this;
	}

	@FindBy(how=How.ID,using="txtAULiabSymbol")
	public static WebElement eleAULiabilitySymbol;
	public LobDetailsPage enterAULiabilitySymbol(String data)
	{
		click(eleAULiabilitySymbol);
		type(eleAULiabilitySymbol, data);
		eleAULiabilitySymbol.sendKeys(Keys.TAB);
		return this;
	}
	//Clear Liability symbol
	@FindBy(how=How.ID,using="txtAULiabSymbol")
	public static WebElement eleClearLiabilitySymbol;
	public LobDetailsPage clearAULiabilitySymbol()
	{
		click(eleClearLiabilitySymbol);
		eleClearLiabilitySymbol.clear();
		eleAULiabilitySymbol.sendKeys(Keys.TAB);
		return this;
	}
	//Liability Limit
	@FindBy(how=How.ID,using="ddAULiabLimit")
	public static WebElement eleLiabilityLimit;
	public LobDetailsPage selLiabilityLimit(String data){
		selectDropDownUsingText(eleLiabilityLimit, data);
		return this;
	}

	//Liability Ded type
	@FindBy(how=How.ID,using="ddAULiabDedType")
	public static WebElement eleLiabilityDedType;
	public LobDetailsPage selLiabilityDedType(String data){
		selectDropDownUsingText(eleLiabilityDedType, data);
		return this;
	}
	//Med Pay Symbol
	@FindBy(how=How.XPATH,using="//input[@id='txtAUMedPaySym']/following-sibling::input")
	public static WebElement eleMedPaySymbol;
	@FindBy(how=How.XPATH,using="(//table[@id='txtAUMedPaySym_grid_grid']/tbody/tr)[1]")
	public static WebElement eleSelMedPaySymbol;
	public LobDetailsPage selMedPaySymbol(){
		click(eleMedPaySymbol);
		click(eleSelMedPaySymbol);
		return this;
	}
	@FindBy(how=How.XPATH,using="(//table[@id='txtAUMedPaySym_grid_grid']/tbody/tr)[5]")
	public static WebElement eleSelectMedPaySymbol;
	public LobDetailsPage changeMedPaySymbol(){
		click(eleMedPaySymbol);
		click(eleSelectMedPaySymbol);
		return this;
	}
	//PIP Symbol
	@FindBy(how=How.XPATH,using="//input[@id='txtAUPipSymbol']/following-sibling::input") 
	public static WebElement elePipSymbol;
	@FindBy(how=How.XPATH,using="(//table[@id='txtAUPipSymbol_grid_grid']/tbody/tr)[1]")
	public static WebElement eleSelPipSymbol;
	public LobDetailsPage selPipSymbol(){
		click(elePipSymbol);
		click(eleSelPipSymbol);
		return this;
	}	
	//Verify PIP symbol is displayed
	public void verifyPipDisplayed()
	{
		verifyDisplayed(elePipSymbol);
	}
	//Additional PIP Symbol
	@FindBy(how=How.XPATH,using="//input[@id='txtAUAddPipSymbol']/following-sibling::input")
	public static WebElement eleAddPipSymbol;
	@FindBy(how=How.XPATH,using="(//table[@id='txtAUAddPipSymbol_grid_grid']/tbody/tr)[1]")
	public static WebElement eleSelAddPipSymbol;
	public LobDetailsPage selAddPipSymbol(){
		click(eleAddPipSymbol);
		click(eleSelAddPipSymbol);
		return this;
	}	
	//UM Symbol 
	@FindBy(how=How.ID,using="txtAUUninsuredSym")
	public static WebElement eleUMSymbol;
	public LobDetailsPage clickUMSymbol(){
		click(eleUMSymbol);
		type(eleUMSymbol, "2");
		return this;
	}

	//-----Physical Damage-----
	//Comprehensive
	@FindBy(how=How.XPATH,using="//input[@id='txtAUCompSymbol']")
	public static WebElement eleComprehensive;
	public LobDetailsPage selComprehensive(String data){
		type(eleComprehensive, data);
		return this;
	}
	//Collision
	@FindBy(how=How.XPATH,using="//input[@id='txtAUCollSymbol']")
	public static WebElement eleCollision;
	public LobDetailsPage enterCollision(String data){
		type(eleCollision, data);
		return this;
	}
	//Specified Perils
	@FindBy(how=How.XPATH,using="//input[@id='txtAUSpecPerils']/following-sibling::input")
	public static WebElement eleSpecifiedPerilsSearchButton;
	@FindBy(how=How.XPATH,using="(//table[@id='txtAUSpecPerils_grid_grid']/tbody/tr)[4]")
	public static WebElement eleSpecifiedPerilsValue;
	@FindBy(how=How.XPATH,using="(//table[@id='txtAUSpecPerils_grid_grid']/tbody/tr)[1]")
	public static WebElement eleGRSpecifiedPerilsValue;
	public LobDetailsPage selSelectPerils(){
		click(eleSpecifiedPerilsSearchButton);
		click(eleSpecifiedPerilsValue);
		return this;
	}
	public LobDetailsPage selGRSelectPerils(){
		click(eleSpecifiedPerilsSearchButton);
		click(eleGRSpecifiedPerilsValue);
		return this;
	}
	//Radio Button - Propelled Vehicled - No
	@FindBy(how=How.ID,using="rdoAUFltNonFltNonFleet")
	public static WebElement elePropVechicleNo;
	public LobDetailsPage selPropVechicleNo(){
		click(elePropVechicleNo);
		return this;
	}

	//Loss Rated Policy
	@FindBy(how=How.ID,using="ddlAULossRatedInd")
	public static WebElement eleAutoLossRatedInd;
	public LobDetailsPage selAutoLossRatedInd(String data){
		try
		{
			if (eleAutoLossRatedInd.isDisplayed()) {
				click(eleAutoLossRatedInd);
				selectDropDownUsingText(eleAutoLossRatedInd,data);		
			}
		}catch (WebDriverException e) {
			System.out.println("Loss Rated Policy not available");
		}finally
		{
			System.out.println("Loss Rated Policy not available");
		}

		return this;
	}
	//PIP-Deductible
	@FindBy(how = How.ID, using = "btnAuPipDedLimit")
	public static WebElement eleDeductobleField;

	@FindBy(how = How.XPATH, using = "//table[@id='DivAUPIPDedFloatingPanel_grid']//tbody//tr//td[2]//div")
	public static List<WebElement> eleDeductibleDEDcol;

	@FindBy(how = How.XPATH, using = "//table[@id='DivAUPIPDedFloatingPanel_grid']//tbody//tr//td[3]//div")
	public static List<WebElement> eleDeductibleDEDTypecol2;

	public LobDetailsPage clickDeductible() {
		JavascriptExecutor deduct = (JavascriptExecutor) driver;
		deduct.executeScript("arguments[0].click();", eleDeductobleField);
		// click(eleDeductobleField);

		List<String> DEDcol = new ArrayList<>();
		List<String> DEDTypecol = new ArrayList<>();
		System.out.println("MY DED is:" + eleDeductibleDEDcol);
		for (WebElement t2 : eleDeductibleDEDcol) {
			String t3 = t2.getText();
			System.out.println(t3);
			DEDcol.add(t3);

		}
		for (WebElement t2 : eleDeductibleDEDTypecol2) {
			String t3 = t2.getText();
			System.out.println(t3);
			DEDTypecol.add(t3);

		}

		Assert.assertEquals(DEDcol.get(0).toString(), "100");
		Assert.assertEquals(DEDcol.get(1).toString(), "200");
		Assert.assertEquals(DEDcol.get(2).toString(), "COMBINED");
		Assert.assertEquals(DEDTypecol.get(0).toString(), "MED EXP");
		Assert.assertEquals(DEDTypecol.get(1).toString(), "WORK LOSS");
		Assert.assertEquals(DEDTypecol.get(2), "COMBINED MED + WRK LOSS");
		return this;
	}
	//Select
	@FindBy(how = How.LINK_TEXT,using="Select")
	public static WebElement eleSelectCity;
	public LobDetailsPage clickSelectInCity()
	{
		try {
			if(eleSelectCity.isDisplayed())
				click(eleSelectCity);
		} finally {
			System.out.println("Select option is not available");
		}

		return this;
	}
	//PIP Deductible Value 
	@FindBy(how = How.ID, using = "cboAuPipDedLimit")
	public static WebElement eleDeductibleLimitValue;
	@FindBy(how = How.ID, using = "btnAuPipDedLimit")
	public static WebElement eleBtnDeductibleLimit;
	@FindBy(how = How.XPATH, using = "//table[@id='DivAUPIPDedFloatingPanel_grid']//tbody//tr[4]/td[1]")
	public static WebElement eleDeductibleDEDValue;
	public LobDetailsPage checkDeductible()
	{
		JavascriptExecutor deduct = (JavascriptExecutor) driver;
		deduct.executeScript("arguments[0].click();", eleDeductobleField);

		click(eleDeductibleDEDValue);
		//	type(eleDeductibleLimitValue, "500");
		return this;
	}
	//Edit Garage LOB
	@FindBy(how=How.LINK_TEXT,using="Edit Dealers/Garage LOB")
	public static WebElement eleEditGarageLOb;
	public LobDetailsPage clickEditGarageLob(){
		click(eleEditGarageLOb);
		return this;
	}
	//Edit Auto Non Dealer LOB
	@FindBy(how=How.LINK_TEXT,using="Edit Auto Non Dealer LOB")
	public static WebElement eleEditAutoNonDealerLOB;
	public LobDetailsPage clickEditAutoNonDealerLOB(){
		click(eleEditAutoNonDealerLOB);
		return this;
	}
	//Pip - Stacking
	@FindBy(how = How.ID,using = "pnlPIP_fieldSet")
	public static WebElement elePipStacking;
	public LobDetailsPage checkPipStackingNotDisplayed()
	{
		verifyNotDisplayed(elePipStacking);
		return this;
	}
	//Additional Pip Limit
	@FindBy(how = How.ID,using = "ddlAdditionalPip")
	public static WebElement eleAddlnPip;
	public LobDetailsPage verifyDdlAddlnPipLimit(String data)
	{
		click(eleAddlnPip);
		allDropDownValues(eleAddlnPip);
		selectDropDownUsingText(eleAddlnPip, data);

		return this;
	}

	//Work Loss Exclusion
	@FindBy(how = How.ID, using = "cboAuPipMisc2")
	public static WebElement eleWorkLossExclusion;
	public LobDetailsPage checkWorkLossExclusion(String data)
	{
		click(eleWorkLossExclusion);
		allDropDownValues(eleWorkLossExclusion);
		selectDropDownUsingText(eleWorkLossExclusion, data);
		return this;
	}
	public LobDetailsPage clickWorkLossExclusion()
	{
		click(eleWorkLossExclusion);

		selectDropDownUsingIndex(eleWorkLossExclusion, 3);
		return this;
	}
	public LobDetailsPage selWorkLossExclusion(String data)
	{
		click(eleWorkLossExclusion);

		selectDropDownUsingText(eleWorkLossExclusion, data);
		return this;
	}
	//Extended PIP
	@FindBy(how = How.ID, using = "chkAUExtendedPIP")
	public static WebElement eleChkBxExtendedPip;
	public LobDetailsPage verifyExtendedPipEnabled()
	{
		verifyEnabled(eleChkBxExtendedPip);
		moveToElement(eleChkBxExtendedPip);
		return this;
	}
	public LobDetailsPage verifyExtendedPipDisabled()
	{
		verifyNotDisplayed(eleChkBxExtendedPip);
		return this;
	}

	public LobDetailsPage clickExtendedPip()
	{
		try {
			if (!eleChkBxExtendedPip.isSelected()) {
				click(eleChkBxExtendedPip);
			}
		} catch (WebDriverException e) {
			System.out.println("Already Selected");
		}
		return this;
	}
	//Brd Pip
	@FindBy(how = How.ID, using = "txtAuBrdPip")
	public static WebElement eleTxtBrdPip;
	public LobDetailsPage verifyBrdPip(String data)
	{
		click(eleTxtBrdPip);
		moveToElement(eleTxtBrdPip);
		type(eleTxtBrdPip, data);
		eleTxtBrdPip.sendKeys(Keys.TAB);
		return this;
	}
	//Extended Brd PIP
	@FindBy(how = How.ID, using = "chkAUExtendedBroadenedPIP")
	public static WebElement eleChkBxExtendedBrdPip;
	public LobDetailsPage verifyExtendedBrdPipEnabled()
	{

		verifyDisplayed(eleChkBxExtendedBrdPip);
		verifyEnabled(eleChkBxExtendedBrdPip);
		return this;
	}
	public LobDetailsPage clickExtendedBrdPip()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chkAUExtendedBroadenedPIP")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkAUExtendedBroadenedPIP")));	
			if (eleChkBxExtendedBrdPip.isDisplayed()) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", eleChkBxExtendedBrdPip);
			}
		} catch (WebDriverException e) {
			System.out.println("Not available");
		}

		return this;
	}
	//Addn'l Brd PIP
	@FindBy(how = How.ID, using = "chkAUBrdAdditional")
	public static WebElement eleChkBxAddlBrdPip;
	public LobDetailsPage clickAddlBrdPip()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chkAUBrdAdditional")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkAUBrdAdditional")));	
			if (eleChkBxAddlBrdPip.isDisplayed()) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", eleChkBxAddlBrdPip);
			}
		} catch (WebDriverException e) {
			System.out.println("Not available");
		}

		return this;
	}
	//UM/UIM - Stacking Y 
	@FindBy(how = How.ID, using = "cboAUUMMisc")
	public static WebElement eleDdlUMStacking;
	public LobDetailsPage selDdlUMStackingY(String data)
	{
		selectDropDownUsingText(eleDdlUMStacking, data);
		return this;
	}
	public LobDetailsPage selDdlUMStackingN()
	{
		selectDropDownUsingIndex(eleDdlUMStacking, 2);
		return this;
	}
	//UM/UIM - Individual 
	@FindBy(how = How.ID, using = "chkAUIndivCpl")
	public static WebElement eleChkBxIndividual;
	public LobDetailsPage clickChkBxIndividual()
	{
		click(eleChkBxIndividual);
		return this;
	}
	//Next to Crime Fidelity
	@FindBy(how=How.LINK_TEXT,using="Next to Crime Fidelity")
	public static WebElement eleNxtToCrimeFidelity;
	public LobDetailsPage clickNxtToCrimeFidelity(){
		click(eleNxtToCrimeFidelity);
		return this;
	}
	//Delete LOB
	@FindBy(how=How.LINK_TEXT,using="Delete LOB")
	public static WebElement eleDeleteLob;
	public LobDetailsPage clickDeleteLob(){
		click(eleDeleteLob);
		return this;
	}

	//Yes 
	@FindBy(how=How.XPATH,using="(//span[@class='ui-button-text'])[1]")
	public static WebElement eleBtnYes;
	public LobDetailsPage clickBtnYes(){
		try
		{
			if(eleBtnYes.isDisplayed()) {				
				click(eleBtnYes);
			}


		}catch (WebDriverException e) {
			System.out.println("Yes Button is not displayed");
		}
		finally
		{
			System.out.println("Navigating to driver Info Screen");
		}
		return this;
	}
	//Status 
	@FindBy(how=How.ID,using="ddlTrans")
	public static WebElement eleStatus;
	public LobDetailsPage selStatus(){
		selectDropDownUsingIndex(eleStatus, 2);
		return this;
	}
	//Not taken reason 
	@FindBy(how=How.ID,using="ddlNotTaken")
	public static WebElement eleNotTaken;
	public LobDetailsPage selNotTakenReason(){
		selectDropDownUsingIndex(eleNotTaken, 2);
		return this;
	}
	//Process 
	@FindBy(how=How.LINK_TEXT,using="Process")
	public static WebElement eleProcess;
	public LobDetailsPage clickProcess(){
		click(eleProcess);
		return this;
	}
	//Lob Details
	//Premium Summary
	@FindBy(how=How.LINK_TEXT,using="Lob Details")
	public static WebElement eleLobDetails;
	public LobDetailsPage clickLobDetails(){
		click(eleLobDetails);
		return this;
	}
	//Premium Summary
	@FindBy(how=How.LINK_TEXT,using="Premium Summary")
	public static WebElement elePremiumSummary;
	public LobDetailsPage clickPremiumSummary(){
		click(elePremiumSummary);
		return this;
	}
	//Extension Option-GL
	@FindBy(how=How.ID,using="ddlAUExtensionOptions")
	public static WebElement eleAutoExtnOptions;
	public LobDetailsPage selAutoExtnOptions(String data){
		selectDropDownUsingText(eleAutoExtnOptions,data);
		return this;
	}

	//-----PIP-----
	//Click on PIP
	@FindBy(how=How.XPATH,using="//h2[text()='PIP']")
	public static WebElement elePIP;
	public LobDetailsPage clickPip(){
		click(elePIP);
		return this;
	}

	//PIP LIMIT
	@FindBy(how=How.ID,using="txtAUNoFaultPip")
	public static WebElement elePIPLimit;
	public LobDetailsPage verifyPIPLimit(){
		verifyNotEnabled(elePIPLimit);
		new Select(elePIPLimit).getAllSelectedOptions();
		return this;
	}
	//Add'l PIP LIMIT
	@FindBy(how=How.XPATH,using="//input[@id='btnAUAddPip']")
	public static WebElement eleAddlPIPLimit;
	@FindBy(how=How.XPATH,using="(//table[@id='DivbtnAUAddPipFloatingPanel_grid']/tbody/tr)[3]")
	public static WebElement eleAddlPIPLimitOptions;
	public LobDetailsPage verifyAddlPIPLimit(){
		click(eleAddlPIPLimit);
		click(eleAddlPIPLimitOptions);
		return this;
	}

	//Verify Work Loss Field, Med Expense Field, Med Expense DRopdown field is not available on State Input Screen
	@FindBy(how=How.XPATH,using="(//div[@class='content'])[5]")
	public static WebElement elePipScreen;
	public LobDetailsPage checkPipScreen(String data)
	{
		verifyPartialTextNotAvailable(elePipScreen, data);
		return this;
	}
	//State OverRides 

	@FindBy(how=How.XPATH,using="//h2[contains(text(),'State Override')]")
	public static WebElement eleStateOverRides;
	public LobDetailsPage clickStateOverRides()
	{
		click(eleStateOverRides);
		return this;
	}
	//StateOverRides - Liability 
	@FindBy(how=How.ID,using="txtAuLiabLcmOvrd")
	public static WebElement eleTxtStateOverRidesLiability;
	public LobDetailsPage enterTxtStateOverRidesLiability(String data){
		type(eleTxtStateOverRidesLiability, data);
		return this;
	}


	//StateOverRides - Physical Damage 
	@FindBy(how=How.ID,using="txtAuPdLcmOvrd")
	public static WebElement eleTxtStateOverRidesPhysicalDamage;
	public LobDetailsPage enterTxtStateOverRidesPhysicalDamage(String data){
		type(eleTxtStateOverRidesPhysicalDamage, data);
		return this;
	}


	//Click on Primary Hired car Liability/Physical damage
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Primary Hired Car Liability/ Physical Damage')]")
	public static WebElement eleLnkPrimaryHiredCarLiability;
	public LobDetailsPage clickPrimaryHiredCar()
	{
		click(eleLnkPrimaryHiredCarLiability);
		return this;
	}
	//
	@FindBy(how=How.ID,using="txtAUPrimaryHired")
	public static WebElement eleTxtPrimaryHiredLiability;
	public LobDetailsPage enterTxtPrimaryHiredLiability(String data){
		try {
			if (eleTxtPrimaryHiredLiability.isDisplayed()) {
				click(eleTxtPrimaryHiredLiability);
				type(eleTxtPrimaryHiredLiability, data);
			}
		} catch (WebDriverException e) {
			// TODO: handle exception
		}

		return this;
	}

	//Comprehensive - Value
	@FindBy(how=How.ID,using="txtAUHireCompValu")
	public static WebElement eleComprehensiveValue;
	public LobDetailsPage enterComprehensiveValue(String data){
		type(eleComprehensiveValue, data);
		driver.findElementById("txtAUHireCompValu").sendKeys(Keys.TAB);
		return this;
	}

	//Comprehensive - Ded
	@FindBy(how=How.ID,using="ddAUHireCompDed")
	public static WebElement eleAutoComDed;
	public LobDetailsPage selAutoComDed(String data){

		selectDropDownUsingText(eleAutoComDed,data);
		return this;
	}
	//Check box - Cost of Hire- mobile Equipment COst of Hire
	@FindBy(how=How.ID,using="chkMobileEquCostOfHire")
	public static WebElement eleMobileEquCostOfHire;
	public LobDetailsPage clickMobEquCostOfHire(){
		click(eleMobileEquCostOfHire);
		return this;
	}
	//Deductible Options in Collision Section under Mobile Equipment
	@FindBy(how=How.ID,using="ddlMobileCollisionDeductible")
	public static WebElement eleMobileCollisionDeductible;
	public LobDetailsPage verifyOptionsInMobCollDeductible(){
		allDropDownValues(eleMobileCollisionDeductible);
		eleMobileCollisionDeductible.click();
		selectDropDownUsingText(eleMobileCollisionDeductible,"250");
		/*try {
			Thread.sleep(2000);
			Robot robot = new Robot();
			File dest = new File("./Images/img.png");
			BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", dest);
		} catch (InterruptedException | AWTException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return this;
	}
	@FindBy(how=How.ID,using="ddlMobileDeductible")
	public static WebElement eleMobileCompDeductible;
	public LobDetailsPage verifyOptionsInMobCompDeductible(){
		allDropDownValues(eleMobileCompDeductible);
		click(eleMobileCompDeductible);
		selectDropDownUsingText(eleMobileCompDeductible, "50");
		return this;
	}

	//Comprehensive - Cost Of Hire
	@FindBy(how=How.ID,using="txtAUHaoCompCost")
	public static WebElement eleComprehensiveCostofHire;
	public LobDetailsPage enterComprehensiveCostHire(String data){
		type(eleComprehensiveCostofHire, data);
		eleComprehensiveCostofHire.sendKeys(Keys.TAB);
		return this;
	}
	//Collision - Value
	@FindBy(how=How.XPATH,using="//div[@id='divtxtAUHireCollValu']/label/following-sibling::input")
	public static WebElement eleCollisionValue;
	public LobDetailsPage enterCollisionValue(String data){
		type(eleCollisionValue, data);
		driver.findElementById("txtAUHireCollValu").sendKeys(Keys.TAB);
		return this;
	}

	//Comprehensive - Ded
	@FindBy(how=How.ID,using="ddAUHireCollDed")
	public static WebElement eleAutoCollisionDed;
	public LobDetailsPage selAutoCollisionDed(String data){
		selectDropDownUsingText(eleAutoCollisionDed,data);
		return this;
	}

	//Comprehensive - Cost Of Hire
	@FindBy(how=How.ID,using="txtAUHaoCollCost")
	public static WebElement eleCollisionCostofHire;
	public LobDetailsPage enterCollisionCostHire(String data){
		type(eleCollisionCostofHire, data);
		return this;
	}

	//Radio Button - Any vehicles added to this Policy -YES
	@FindBy(how=How.ID,using="rdoVehicleYes")
	public static WebElement eleVechicleAddedYes;
	public LobDetailsPage selVechicleAddedYes(){
		try {
			if(eleVechicleAddedYes.isDisplayed())
				click(eleVechicleAddedYes);
		} catch (WebDriverException e) {
			System.out.println("Yes button not displayed");
		}

		return this;
	}
	//Radio Button - Any Drivers added to this Policy -YES
	@FindBy(how=How.ID,using="rdoDriversYes")
	public static WebElement eleDrivereAddedYes;
	public LobDetailsPage selDriverAddedYes(){
		try {
			if(eleDrivereAddedYes.isDisplayed())
				click(eleDrivereAddedYes);
		} catch (WebDriverException e) {
			System.out.println("Yes button not displayed");
		}

		return this;
	}
	//Vehicle State
	@FindBy(how=How.ID,using="VC_cboState")
	public static WebElement eleVehicleState;
	public LobDetailsPage selectVehicleState(String data){
		try {
			if (eleVehicleState.isDisplayed()&& eleVehicleState.isEnabled()) {
				click(eleVehicleState);
				selectDropDownUsingText(eleVehicleState, data);
			}

		} catch (WebDriverException e) {
			System.out.println("Not Available");
		}

		return this;
	}

	//Vehicle Summary
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Vehicle Summary')]")
	public static WebElement eleVehicleSummary;
	public LobDetailsPage clickVehicleSummary(){
		click(eleVehicleSummary);
		return this;
	}
	//Coverages
	@FindBy(how=How.LINK_TEXT,using="Cov")
	public static WebElement eleVehicleCov;
	public LobDetailsPage clickVehicleCov(){
		click(eleVehicleCov);
		return this;
	}
	//Add Vehicle
	@FindBy(how=How.LINK_TEXT,using="Add Vehicle")
	public static WebElement eleAddVehicle;
	public LobDetailsPage clickAddVehicle(){
		click(eleAddVehicle);
		return this;
	}

	//Radio Button - Any Drivers added to this Policy -No
	@FindBy(how=How.ID,using="rdoDriversNo")
	public static WebElement eleDrivereAddedNo;
	public LobDetailsPage selDriverAddedNo(){
		click(eleDrivereAddedNo);
		return this;
	}
	//VIN
	@FindBy(how=How.ID,using="VC_txtVIN")
	public static WebElement eleVIN;
	public LobDetailsPage enterVIN(String data){
		click(eleVIN);
		type(eleVIN, data);
		return this;
	}
	//VIN Override - checkbox
	@FindBy(how=How.ID,using="VC_chkAuVINOvrdInd")
	public static WebElement eleVINOverRideChkBox;
	public LobDetailsPage clickOverrideVINChk(){
		try {
			if(eleVINOverRideChkBox.isEnabled()&!eleVINOverRideChkBox.isSelected())
				click(eleVINOverRideChkBox);
		} catch (WebDriverException e) {
			System.out.println("VIN Overrideis already selected");
		}

		return this;
	}

	//Vehicle Year
	@FindBy(how=How.ID,using="VC_txtVehYear")
	public static WebElement eleVehYear;
	public LobDetailsPage selVehYear(String data){
		type(eleVehYear, data);
		return this;
	}

	//Vehicle Make
	@FindBy(how=How.ID,using="VC_txtMake")
	public static WebElement eleVehMake;
	public LobDetailsPage selVehMake(String data){
		type(eleVehMake, data);
		return this;
	}

	//Vehicle Model
	@FindBy(how=How.ID,using="VC_txtModel")
	public static WebElement eleVehModel;
	public LobDetailsPage selVehModel(String data){
		type(eleVehModel, data);
		return this;
	}

	//Vehicle Model
	@FindBy(how=How.ID,using="VC_hlpVehType")
	public static WebElement eleVehType;
	public LobDetailsPage selVehType(String data){
		type(eleVehType, data);
		eleVehType.sendKeys(Keys.TAB);
		return this;
	}
	//Leased Auto
	@FindBy(how=How.ID,using="VC_cboLeasedAuto")
	public static WebElement eleVehLeasedAuto;
	public LobDetailsPage selLeasedAuto(String data){
		selectDropDownUsingText(eleVehLeasedAuto, data);
		return this;
	}
	//Free Form type 
	@FindBy(how=How.ID,using="VC_cboFFVehType")
	public static WebElement eleFreeFormType;
	public LobDetailsPage selFreeFormType(String data){
		selectDropDownUsingText(eleFreeFormType, data);
		return this;
	}
	//Hired/Leased Auto From
	@FindBy(how=How.ID,using="VC_cboHiredLeasedAutoForm")
	public static WebElement eleHiredLeasedAutoFrom;
	public LobDetailsPage selHiredLeasedAutoFrom(String data){
		selectDropDownUsingText(eleHiredLeasedAutoFrom, data);
		return this;
	}
	//Radio button - Class Code 
	//Enter and Validate Class Code
	@FindBy(how=How.ID,using="radEnterClassCode")
	public static WebElement eleRadioEnterClassCode;
	public LobDetailsPage selRadioEnterClassCode(){
		click(eleRadioEnterClassCode);
		return this;
	}
	//Class Code - Auto
	@FindBy(how=How.ID,using="txtAuClassCode")
	public static WebElement eleAUClassCode;
	public LobDetailsPage enterAUClassCode(String data){
		type(eleAUClassCode, data);
		return this;
	}
	//Validate Class Code
	//btnValClassCode
	@FindBy(how=How.ID,using="btnValClassCode")
	public static WebElement eleValidateClassCode;
	public LobDetailsPage clickValidateClassCode(){
		click(eleValidateClassCode);
		return this;
	}
	//Validate Class Code 
	@FindBy(how=How.LINK_TEXT,using="Validate Class Code")
	public static WebElement eleValidateClassCodeBtn;
	public LobDetailsPage clickBtnValidateClassCode(){
		click(eleValidateClassCodeBtn);
		return this;
	}
	//Generate Class Code- Radio Button
	@FindBy(how=How.ID,using="radGenClassCode")
	public static WebElement eleRadioGenerateClassCode;
	public LobDetailsPage selRadioGenerateClassCode(){
		click(eleRadioGenerateClassCode);
		return this;
	}
	//Vehicle weight
	@FindBy(how=How.ID,using="CC_ddAuVehSize")
	public static WebElement eleVehicleWt;
	public LobDetailsPage selVehiclewt()
	{
		try
		{	
			if(eleVehicleWt.isDisplayed())
			{
				click(eleVehicleWt);
				selectDropDownUsingIndex(eleVehicleWt, 1);
			}
		}
		catch (WebDriverException e) {
			System.out.println("Vehicle Weight is not available");
		}
		return this;
	}

	//Driver Trn Vehicle type
	@FindBy(how=How.XPATH,using="//div[@id='CC_divAuExtraInfo']/select")
	public static WebElement eleDriverTrn;
	public LobDetailsPage selDrivertrn(String data){
		//click(eleDriverTrn);
		selectDropDownUsingText(eleDriverTrn, data);
		//selectDropDownUsingIndex(eleDriverTrn, 1);
		return this;
	}

	//Vehicle Use
	@FindBy(how=How.ID,using="CC_ddAuVehUse")
	public static WebElement eleVehicleUse;
	public LobDetailsPage selVehicleUse(){
		try
		{	
			if(eleVehicleUse.isDisplayed())
			{
				click(eleVehicleUse);
				selectDropDownUsingIndex(eleVehicleUse, 1);
			}
		}
		catch (WebDriverException e) {
			System.out.println("Vehicle USE is not available");
		}

		return this;
	}
	//Check VehicleWeight
	public LobDetailsPage checkVehiclewt(){
		verifyNotDisplayed(eleVehicleWt);
		return this;
	}
	//Radius Of Use
	@FindBy(how=How.ID,using="CC_ddAuVehRadius")
	public static WebElement eleVehicleRadiusWt;
	public LobDetailsPage selVehicleRadiuswt(String data){
		try
		{	
			if(eleVehicleRadiusWt.isDisplayed())
			{
				click(eleVehicleRadiusWt);
				selectDropDownUsingText(eleVehicleRadiusWt, data);
			}
		}
		catch (WebDriverException e) {
			System.out.println("Radius of use is not available");
		}


		return this;
	}
	public LobDetailsPage selVehicleRadiusOfUse(){
		try
		{	
			if(eleVehicleRadiusWt.isDisplayed())
			{
				click(eleVehicleRadiusWt);
				selectDropDownUsingIndex(eleVehicleRadiusWt, 3);
			}
		}
		catch (WebDriverException e) {
			System.out.println("Radius of use is not available");
		}


		return this;
	}
	//Radius Of Use
	public LobDetailsPage selVehicleRadiusUse(){
		selectDropDownUsingIndex(eleVehicleRadiusWt, 1);
		return this;
	}
	//Edit
	@FindBy(how=How.LINK_TEXT,using="Edit")
	public static WebElement eleEdit;
	public LobDetailsPage clickEdit(){
		click(eleEdit);
		return this;
	}
	//School bus Owner CC_ddAuExtraInfo
	@FindBy(how=How.ID,using="CC_ddAuExtraInfo")
	public static WebElement eleSchoolBusOwner;
	public LobDetailsPage selSchoolBusOwner(){
		try
		{	
			if(eleSchoolBusOwner.isDisplayed())
			{
				click(eleSchoolBusOwner);
				selectDropDownUsingIndex(eleSchoolBusOwner, 1);

			}
		}
		catch (WebDriverException e) {
			System.out.println("Not available");
		}

		return this;
	}
	//PPT Use 
	@FindBy(how=How.ID,using="CC_ddAuPptUse")
	public static WebElement eleDdlPptUse;
	@FindBy(how=How.ID,using="CC_ddAuPptExper")
	public static WebElement eleDdlPptExper;
	public LobDetailsPage selPptUse(){
		try
		{	
			if(eleDdlPptUse.isDisplayed())
			{
				click(eleDdlPptUse);
				selectDropDownUsingIndex(eleDdlPptUse, 1);
				selectDropDownUsingIndex(eleDdlPptExper, 1);	
			}
		}
		catch (WebDriverException e) {
			System.out.println("Not available");
		}

		return this;
	}

	//Vehicle Equipped with mechanical Lift
	@FindBy(how=How.ID,using="CC_ddlAUMechLift")
	public static WebElement eleVehicleMechanicalLift;
	public LobDetailsPage selVehicleMechanicalLift(){
		try
		{	
			if(eleVehicleMechanicalLift.isDisplayed())
			{
				click(eleVehicleMechanicalLift);
				selectDropDownUsingIndex(eleVehicleMechanicalLift, 1);
			}
		}
		catch (WebDriverException e) {
			System.out.println("Not available");
		}
		return this;
	}
	//Territory Zone
	@FindBy(how=How.ID,using="CC_ddAuZone1")
	public static WebElement eleTerritoryZone;
	public LobDetailsPage selTerritoryZone(){
		try
		{	
			if(eleTerritoryZone.isDisplayed())
			{
				click(eleTerritoryZone);
				selectDropDownUsingIndex(eleTerritoryZone, 2);
			}
		}
		catch (WebDriverException e) {
			System.out.println("Not available");
		}
		return this;
	}
	//Terminal Zone 
	@FindBy(how=How.ID,using="CC_ddAuZone2")
	public static WebElement eleTerminalZone;
	public LobDetailsPage selTerminalZone(){
		try
		{	
			if(eleTerminalZone.isDisplayed())
			{
				click(eleTerminalZone);
				selectDropDownUsingIndex(eleTerminalZone, 2);
			}
		}
		catch (WebDriverException e) {
			System.out.println("Not available");
		}
		return this;
	}
	public LobDetailsPage selVehicleMechLift(String data){
		selectDropDownUsingText(eleVehicleMechanicalLift, data);
		return this;
	}
	//Taxi Cab Types
	@FindBy(how=How.ID,using="CC_ddAUMisc23")
	public static WebElement eleTaxiCabTypes;
	public LobDetailsPage selTaxiCabTypes(){
		try
		{	
			if(eleTaxiCabTypes.isDisplayed())
			{
				click(eleTaxiCabTypes);
				selectDropDownUsingIndex(eleTaxiCabTypes, 1);
			}
		}
		catch (WebDriverException e) {
			System.out.println("Not available");
		}
		//selectDropDownUsingText(eleTaxiCabTypes, data);
		return this;
	}
	//Seating cap Range
	@FindBy(how=How.ID,using="CC_ddAuSeatingCap")
	public static WebElement eleSeatingCapRange;
	public LobDetailsPage selSeatingCapRange(){
		try
		{	
			if(eleSeatingCapRange.isDisplayed())
			{
				click(eleSeatingCapRange);
				selectDropDownUsingIndex(eleSeatingCapRange, 1);

			}
		}
		catch (WebDriverException e) {
			System.out.println("Not available");
		}
		return this;
	}

	//Seating cap Range
	@FindBy(how=How.ID,using="CC_ddAUMisc23")
	public static WebElement eleParaTransit;
	public LobDetailsPage selParaTransit(String data){
		selectDropDownUsingText(eleParaTransit, data);
		return this;
	}
	//PIP Coverage 
	@FindBy(how=How.ID,using="chkspliAuPipCov")
	public static WebElement elePIPCoverage;
	public LobDetailsPage checkPipCoverage(){
		verifySelected(elePIPCoverage);

		return this;
	}

	public LobDetailsPage clickVehicleLevelPipCoverage(){
		try {
			if (!elePIPCoverage.isSelected()) {
				click(elePIPCoverage);		
			}
		} catch (WebDriverException e) {
			System.out.println("Not available");
		}


		return this;
	}
	@FindBy(how=How.ID,using="CC_btnAuSecondaryClas")
	public static WebElement eleSecondaryClassCodeBtn;
	@FindBy(how=How.XPATH,using="(//table[@class='sigi-grid-table']/tbody/tr/td)[3]")
	public static WebElement eleSecondaryClassCodeRslt;
	public LobDetailsPage enterSecondaryClassCode() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleSecondaryClassCodeBtn);
		click(eleSecondaryClassCodeBtn);
		Thread.sleep(1000);
		click(eleSecondaryClassCodeRslt);
		return this;

	}
	@FindBy(how=How.ID,using="CC_txtAuSecondaryClas")
	public static WebElement eleSecondaryClassCodeTxt;
	public LobDetailsPage typeSecClassCode(String data)
	{
		try
		{	
			if(eleSecondaryClassCodeTxt.isDisplayed())
			{
				click(eleSecondaryClassCodeTxt);
				type(eleSecondaryClassCodeTxt, data);
			}
		}
		catch (WebDriverException e) {
			System.out.println("Secondary class code is not available");
		}
		return this;
	}
	@FindBy(how=How.ID,using="CC_hlpAuMiscA")
	public static WebElement eleTowingUse;
	public LobDetailsPage enterTowingUse(){
		type(eleTowingUse, "1");
		return this;
	}

	@FindBy(how=How.XPATH,using="//h2[text()='Class Code ']")
	public static WebElement eleLnkClassCode;
	public LobDetailsPage clickClassCode(){
		click(eleLnkClassCode);
		return this;
	}
	//Button -Generate Class Code
	@FindBy(how=How.LINK_TEXT,using="Generate Class Code")
	public static WebElement eleBtnGenertaeClassCode;
	public LobDetailsPage clickBtnGenertaeClassCode(){
		click(eleBtnGenertaeClassCode);
		return this;
	}
	//UM Covergae
	@FindBy(how=How.ID,using="chkspliAuUmCoverage")
	public static WebElement eleChkBxUMCoverage;
	@FindBy(how=How.ID,using="chkUMIndiv")
	public static WebElement eleChkBxUMCoverageIndividual;
	public LobDetailsPage clickUMCoverage(){
		try {
			if (eleChkBxUMCoverage.isDisplayed()&&!eleChkBxUMCoverage.isSelected()) {
				click(eleChkBxUMCoverage);
				try {
					if (!eleChkBxUMCoverageIndividual.isSelected()) {
						click(eleChkBxUMCoverageIndividual);
					}
				} catch (WebDriverException e) {
					System.out.println("Not Avaialble");
				}


			}
		} catch (WebDriverException e) {
			System.out.println("Not Avaialble");
		}

		return this;
	}

	//PIP  - Vehicle Coverage
	@FindBy(how=How.ID,using="chkspliAuPipCov")
	public static WebElement eleChkBxPipCoverage;
	public LobDetailsPage verifyPipSelected(){
		verifySelected(eleChkBxPipCoverage);
		return this;
	}
	public LobDetailsPage verifyPipNotSelected(){
		verifyNotSelected(eleChkBxPipCoverage);
		return this;
	}
	//PIP - Location Coverage
	public LobDetailsPage clickPipCoverage(){
		try {
			if (eleChkBxPipCoverage.isDisplayed()&&!eleChkBxPipCoverage.isSelected()) {
				click(eleChkBxPipCoverage);
				clickBtnYes();
			}
		} catch (WebDriverException e) {
			System.out.println("Not Avaialble");
		}

		return this;
	}

	//Extended Pip  - Vehicle Coverage
	@FindBy(how=How.ID,using="chkspliAuExtendedPipCov")
	public static WebElement eleChkBxExtendedPipCoverage;
	public LobDetailsPage verifyExtendedPip(){
		WebDriverWait wait = new WebDriverWait(driver, 90);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chkspliAuExtendedPipCov")));
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkspliAuExtendedPipCov")));	
		try {
			if (eleChkBxExtendedPipCoverage.isDisplayed()&&!eleChkBxExtendedPipCoverage.isSelected()) {
				verifyDisplayed(eleChkBxExtendedPipCoverage);
				click(eleChkBxExtendedPipCoverage);
			}
		} catch (WebDriverException e) {
			System.out.println("Extended PIP Coverage Not Avaialble");
		}

		return this;
	}
	//Extended PI - State Level Coverage
	@FindBy(how=How.ID,using="")
	public static WebElement eleChkBxExtendedPipCoverageStateLevel;
	public LobDetailsPage verifyExtendedPipStateLevel(){
		try {
			if (eleChkBxExtendedPipCoverageStateLevel.isDisplayed()) {
				verifyDisplayed(eleChkBxExtendedPipCoverageStateLevel);
				click(eleChkBxExtendedPipCoverageStateLevel);
			}
		} catch (WebDriverException e) {
			System.out.println("Extended PIP Coverage Not Avaialble");
		}

		return this;
	}
	//APIP - State Level Coverage
	@FindBy(how=How.ID,using="")
	public static WebElement eleChkBxAPipCoverageStateLevel;
	public LobDetailsPage verifyAPipStateLevel(){
		try {
			if (eleChkBxAPipCoverageStateLevel.isDisplayed()) {
				verifyDisplayed(eleChkBxAPipCoverageStateLevel);
				click(eleChkBxAPipCoverageStateLevel);
			}
		} catch (WebDriverException e) {
			System.out.println("APIP Coverage Not Avaialble");
		}

		return this;
	}
	//APip  - Vehicle Coverage
	@FindBy(how=How.ID,using="chkspliAuAddedPipCov")
	public static WebElement eleChkBxAPipCoverage;
	public LobDetailsPage verifyAPip(){
		try {
			if (eleChkBxAPipCoverage.isDisplayed()&& !eleChkBxAPipCoverage.isSelected()) {
				verifyDisplayed(eleChkBxAPipCoverage);
				click(eleChkBxAPipCoverage);
			}
		} catch (WebDriverException e) {
			System.out.println("APIP Coverage Not Avaialble");
		}

		return this;
	}
	//Comprehensive - Location Coverage  cboCompDed
	@FindBy(how=How.ID,using="chkspliAuCompCov")
	public static WebElement eleChkBxCompCoverage;
	@FindBy(how=How.ID,using="txtCompCostNew")
	public static WebElement eleTxtCompCostNew;
	@FindBy(how=How.ID,using="cboCompDed")
	public static WebElement eleDdlCompDed;
	public LobDetailsPage clickCompCoverage(String data){
		try {
			if (eleChkBxCompCoverage.isDisplayed()&&eleChkBxCompCoverage.isSelected()) {
				//click(eleChkBxCompCoverage);
				//clickBtnYes();
				click(eleTxtCompCostNew);
				type(eleTxtCompCostNew, data);
				click(eleDdlCompDed);
				selectDropDownUsingIndex(eleDdlCompDed, 9);
				eleDdlCompDed.sendKeys(Keys.TAB);
			}
			else if (eleChkBxCompCoverage.isDisplayed()&&!eleChkBxCompCoverage.isSelected()) {
				click(eleChkBxCompCoverage);
				//clickBtnYes();
				click(eleTxtCompCostNew);
				type(eleTxtCompCostNew, data);
				click(eleDdlCompDed);
				selectDropDownUsingIndex(eleDdlCompDed, 9);
				eleDdlCompDed.sendKeys(Keys.TAB);
			}
		} catch (WebDriverException e) {
			System.out.println("Not Avaialble");
		}

		return this;
	}
	//Collision - Location Coverage  cboCompDed
	@FindBy(how=How.ID,using="chkspliAuCollCov")
	public static WebElement eleChkBxCollisionCoverage;
	@FindBy(how=How.ID,using="txtCollCostNew")
	public static WebElement eleTxtCollisionCostNew;
	@FindBy(how=How.ID,using="cboCollDed")
	public static WebElement eleDdlCollisionDed;
	public LobDetailsPage clickCollisionCoverage(String data){
		try {
			if (eleChkBxCollisionCoverage.isDisplayed()&&eleChkBxCompCoverage.isSelected()) {
				//click(eleChkBxCollisionCoverage);
				//clickBtnYes();
				if (eleTxtCollisionCostNew.isEnabled()) {					
					click(eleTxtCollisionCostNew);
					type(eleTxtCollisionCostNew, data);
				}
				click(eleDdlCollisionDed);
				selectDropDownUsingIndex(eleDdlCollisionDed, 10);
			}
			if (!eleChkBxCompCoverage.isSelected()) {
				//click(eleChkBxCollisionCoverage);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", eleChkBxCollisionCoverage);
				if (eleTxtCollisionCostNew.isEnabled()) {					
					click(eleTxtCollisionCostNew);
					type(eleTxtCollisionCostNew, data);
				}
				click(eleDdlCollisionDed);
				selectDropDownUsingIndex(eleDdlCollisionDed, 10);
			}
		} catch (WebDriverException e) {
			System.out.println("Not Avaialble");
		}

		return this;
	}

	//Click on Edit Details 
	@FindBy(how=How.LINK_TEXT,using="Edit Details")
	public static WebElement eleEditDetails;
	public InlandMarinePages clickEditDetails()
	{
		click(eleEditDetails);
		return new InlandMarinePages(driver);
	}
	//Med Pay - Vehicle Coverages 
	@FindBy(how=How.ID,using="chkspliAuMedPayCov")
	public static WebElement eleMedPayCoverage;
	public LobDetailsPage selMedPayCoverage(){
		try {
			if (eleMedPayCoverage.isDisplayed()&!eleMedPayCoverage.isSelected()) {
				click(eleMedPayCoverage);	
			}

		} catch (WebDriverException e) {
			System.out.println("MED PAY coverage is not Displayed/Already Selected");
		}
		return this;
	}
	//Liability - Vehicle Coverages 
	@FindBy(how=How.ID,using="chkspliAuLiabCov")
	public static WebElement eleLiabilityCoverage;

	public LobDetailsPage clickLiability()
	{
		try {
			if (eleLiabilityCoverage.isDisplayed()&!eleLiabilityCoverage.isSelected()) {
				click(eleLiabilityCoverage);	
			}

		} catch (WebDriverException e) {
			System.out.println("LIABILITY coverage is not Displayed/Already Selected");
		}
		return this;	
	}	@FindBy(how=How.ID,using="cboselNiName_Text")
	public static WebElement eleDriverName;
	public LobDetailsPage enterDriverName(String data){
		click(eleDriverName);
		type(eleDriverName, data);
		return this;
	}
	//Date of Birth 
	@FindBy(how=How.ID,using="calPwBirth_Text")
	public static WebElement eleDriverDob;
	public LobDetailsPage enterDriverDob(String data){
		type(eleDriverDob, data);
		return this;
	}
	//License State ddlPwDrLicState
	@FindBy(how=How.ID,using="ddlPwDrLicState")
	public static WebElement eleDriverLicenseState;
	public LobDetailsPage selDriverLicenseState(String data){
		selectDropDownUsingText(eleDriverLicenseState, data);

		return this;
	}
	//License No txtPwDrLicNum
	@FindBy(how=How.ID,using="txtPwDrLicNum")
	public static WebElement eleDriverLicenseNo;
	public LobDetailsPage enterDriverLicenseNo(String data){
		type(eleDriverLicenseNo, data);
		return this;
	}


	@FindBy(how = How.XPATH, using = "//a[@id='navForward']")
	public static WebElement eleBtnnNext;
	public LobDetailsPage clickBtnnNext() {


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", eleBtnnNext);
		//				click(eleBtnNext);
		return this;
	}

	@FindBy(how = How.ID, using = "notificationSection")
	public static WebElement eleNotification;
	public LobDetailsPage checknotifictaion() {
		getText(eleNotification);
		getTextValue(eleNotification);
		return this;
	}
	@FindBy(how = How.ID, using = "ddlExtension")
	public static WebElement eleExtnOptions1;

	public LobDetailsPage selExtnOptions1() {
		Select Extnoprtions1 = new Select(eleExtnOptions1);
		Extnoprtions1.selectByIndex(2);
		return this;
	}
	@FindBy(how = How.XPATH,using="(//label[@class='FormLabel']/following-sibling::input)[3]")
	public static WebElement classCode;
	@FindBy(how=How.XPATH,using="(//div[@class='sigi-grid-item'])[11]")
	public static WebElement eleClassCodeSearchResult;
	@FindBy(how=How.LINK_TEXT,using="Select")
	public static WebElement eleLnkTxtSelect;
	public LobDetailsPage classCode(String data) throws AWTException, InterruptedException {
		click(classCode);
		type(classCode, data);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		click(eleClassCodeSearchResult);
		click(eleLnkTxtSelect);
		return this;
	}

	public LobDetailsPage classCodeFL(String data) throws AWTException, InterruptedException {
		click(classCode);
		type(classCode, data);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		click(eleSearchResultSLT);
		Thread.sleep(1000);
		if (driver.findElement(By.id("FL0020010000001_ClassCode_select")).isDisplayed()) {
			click(driver.findElement(By.id("FL0020010000001_ClassCode_select")));
		}

		return this;

	}
	@FindBy(how = How.ID, using = "btnRate2")
	public static WebElement eleBtnRateButton;

	public LobDetailsPage clickRateButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", eleBtnRateButton);
		// click(eleBtnRateButton);
		return this;
	}

	// WC-Rate button

	@FindBy(how = How.ID, using = "btnRateNav")
	public static WebElement eleBtnRateButtonWC;

	public LobDetailsPage clickRateButtonWC() {
		click(eleBtnRateButtonWC);
		return this;
	}

	@FindBy(how = How.ID, using = "btnRate")
	public static WebElement eleBtnRate1Button;

	public LobDetailsPage clickRateButton1() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", eleBtnRate1Button);
		// click(eleBtnRateButton);
		return this;
	}

	@FindBy(how = How.LINK_TEXT,using="Continue with Rating")
	public static WebElement eleBtnContinueRate;

	public PremiumSummaryPage clickBtnContinuerating() {
		click(eleBtnContinueRate);
		return new PremiumSummaryPage(driver);
	}



	@FindBy(how = How.ID, using = "txtEmployees")
	public static WebElement eleNumEmployee;

	public LobDetailsPage enterNumEmployees(String Numemployee) {
		type(eleNumEmployee, Numemployee);
		return this;
	}

	@FindBy(how = How.ID, using = "ddlWsLossRatedInd")
	public static WebElement eleLossRate;

	public LobDetailsPage selectLossRate(String lossRate) {
		Select lossRatePolicy = new Select(eleLossRate);
		click(eleLossRate);
		lossRatePolicy.selectByValue(lossRate);
		return this;
	}

	@FindBy(how = How.ID, using = "cboSRMLossRated")
	public static WebElement eleLobLossRate;

	public LobDetailsPage selectLobLossRate(String lossRate) {
		Select lossRatePolicy = new Select(eleLobLossRate);
		click(eleLobLossRate);
		lossRatePolicy.selectByValue(lossRate);
		return this;
	}

	// Issue-Wc Loss rate policy dropdown

	@FindBy(how = How.ID, using = "ddlWsLossRatedInd")
	public static WebElement eleWCLossRate;

	public LobDetailsPage selectWCLossRate(String lossRate) {
		Select lossRatePolicy = new Select(eleWCLossRate);
		click(eleWCLossRate);
		lossRatePolicy.selectByValue(lossRate);
		return this;
	}

	@FindBy(how = How.CLASS_NAME, using = "TextBox")
	public static WebElement elePremiumBasics;

	public LobDetailsPage enterPremiumBasics(String premiumBasics) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", elePremiumBasics);
		type(elePremiumBasics, premiumBasics);
		return this;
	}

	// WC-Premium Basis
	@FindBy(how = How.NAME, using = "FL001001001$txtPremBasis")
	public static WebElement elePremiumBasicsWC;

	public LobDetailsPage enterPremiumBasicsWC(String premiumBasics) {

		type(elePremiumBasicsWC, premiumBasics);
		return this;
	}

	@FindBy(how = How.NAME, using = "txtExpMod")
	public static WebElement eleExpMod;

	public LobDetailsPage enterexpMod(String expMod) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.name("txtExpMod")));
		type(eleExpMod, expMod);
		return this;
	}

	@FindBy(how = How.ID, using = "ddlExpModStatus")
	public static WebElement eleExpModStatus;

	public LobDetailsPage enterexpModStatus(String expModStatus) {
		Select modStatus = new Select(eleExpModStatus);
		click(eleExpModStatus);
		modStatus.selectByValue(expModStatus);
		return this;
	}

	@FindBy(how = How.ID, using = "ddlDeductible")
	public static WebElement eleDeductible1;

	public LobDetailsPage selectDeductible(String deduct) {
		Select deductible = new Select(eleDeductible1);
		click(eleDeductible1);
		deductible.selectByValue(deduct);
		return this;
	}

	@FindBy(how = How.ID, using = "btnRateNav")
	public static WebElement lobRateButton;

	public LobDetailsPage clickLobRateButton() {
		click(lobRateButton);
		return this;
	}

	@FindBy(how = How.ID, using = "cboClaimAggrLimit")
	public static WebElement LimitAgg;

	public LobDetailsPage selectLimitAgg() {
		Select limitAgg = new Select(LimitAgg);
		click(LimitAgg);

		limitAgg.selectByIndex(1);
		return this;
	}

	@FindBy(how = How.ID, using = "txtExposure")
	public static WebElement SBExposure;

	public LobDetailsPage enterSBExposure(String data) {

		type(SBExposure, data);
		return this;
	}

	@FindBy(how = How.ID, using = "cboDeductible")
	public static WebElement SBDeductible;

	public LobDetailsPage selectDeductible() {
		Select deductible = new Select(SBDeductible);
		deductible.selectByIndex(2);
		return this;
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/button[1]/span")
	public static WebElement eleBtnYesOrNo;

	public LobDetailsPage clickYesOrNo() {
		// switchToWindow(1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", eleBtnYesOrNo);
		// click(eleBtnYesOrNo);
		return this;
	}

	@FindBy(how = How.ID, using = "rdoAULossExpDLR")
	public static WebElement elePolicyType;

	public LobDetailsPage clickPolicyType() {
		click(elePolicyType);
		return this;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='txtAULiabSymbol']//..//input[2]")
	public static WebElement eleSearchLiability;

	public LobDetailsPage searchLiability() {
		click(eleSearchLiability);
		return this;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"154582377220126486542\"]/td[3]/div")
	public static WebElement eleSelectLiability;

	public LobDetailsPage selectLiability() {
		click(eleSearchLiability);
		return this;
	}

	@FindBy(how = How.ID, using = "ddAULiabLimit")
	public static WebElement eleSelectLiabilityLimit;

	public LobDetailsPage selectLiabilityLimit() {
		click(eleSelectLiabilityLimit);
		Select liabilityLimit = new Select(eleSelectLiabilityLimit);
		liabilityLimit.selectByValue("1,000");
		return this;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='txtAUPipSymbol']//..//input[2]")
	public static WebElement elePipSymboll;

	public LobDetailsPage selectPIPSymbol() {
		click(elePipSymboll);
		driver.findElement(By.xpath("//table[@id='txtAUPipSymbol_grid_grid']//tr[2]//td[3]")).click();
		return this;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='txtAUAddPipSymbol']//..//input[2]")
	public static WebElement eleAddPipSymbol1;

	public LobDetailsPage selectAddPIPSymbol() {
		click(eleAddPipSymbol1);
		driver.findElement(By.xpath("//table[@id='txtAUAddPipSymbol_grid_grid']//tr[2]//td[3]")).click();
		return this;
	}

	@FindBy(how = How.ID, using = "txtAUMedPaySym")
	public static WebElement eleMedPaySym;

	public LobDetailsPage selectMedPaySym() {
		click(eleMedPaySym);
		driver.findElement(By.xpath("//*[@id=\"1545824563499610829513\"]/td[3]/div")).click();
		return this;
	}

	@FindBy(how = How.ID, using = "rdoAUFltNonFltNonFleet")
	public static WebElement eleNoFleet;

	public LobDetailsPage clickNoFleet() {
		click(eleNoFleet);
		return this;
	}

	@FindBy(how = How.ID, using = "ddlAULossRatedInd")
	public static WebElement eleLossRateGarage;

	public LobDetailsPage clickLossRate(String data) {
		click(eleNoFleet);
		Select lossRatePolicy = new Select(eleLossRateGarage);
		lossRatePolicy.selectByValue(data);
		return this;
	}

	@FindBy(how = How.ID, using = "cboAUAddPip")
	public static WebElement focusClick;
	@FindBy(how = How.ID, using = "chkCityOverride")
	public static WebElement cityOverride;

	@FindBy(how = How.ID, using = "txtCityHelp")
	public static WebElement eleCitySearch1;
	@FindBy(how = How.ID, using = "txtCityHelp_searchOK")
	public static WebElement eleCitySelectButton;
	@FindBy(how = How.ID, using = "txtCityHelp_listOK")
	public static WebElement eleCityPopupSelectButton;
	@FindBy(how = How.ID, using = "//div[@id='pnlCityInfo']//div[@class='title']//h2")
	public static WebElement expandCity;
	@FindBy(how = How.ID, using = "hlpAuStTerr")
	public static WebElement territoryOverwite;
	@FindBy(how = How.ID, using = "txtAuStZipCode")
	public static WebElement zipCode;

	public LobDetailsPage selectCitySearch() throws AWTException {
		click(focusClick);
		click(cityOverride);
		click(eleCitySearch1);
		eleCitySearch1.clear();
		type(eleCitySearch1, "SARASOTA");
		territoryOverwite.clear();
		type(territoryOverwite, "101");
		click(zipCode);
		zipCode.clear();
		type(zipCode, "34230");

		return this;

	}

	@FindBy(how = How.ID, using = "cboAUAddPip")
	public static WebElement focusClick1;
	@FindBy(how = How.ID, using = "chkCityOverride")
	public static WebElement cityOverride1;

	@FindBy(how = How.ID, using = "txtCityHelp")
	public static WebElement eleCitySearch11;
	@FindBy(how = How.ID, using = "txtCityHelp_searchOK")
	public static WebElement eleCitySelectButton1;
	@FindBy(how = How.ID, using = "txtCityHelp_listOK")
	public static WebElement eleCityPopupSelectButton1;
	@FindBy(how = How.ID, using = "//div[@id='pnlCityInfo']//div[@class='title']//h2")
	public static WebElement expandCity1;
	@FindBy(how = How.ID, using = "cboTerritory")
	public static WebElement territoryOverwite1;
	@FindBy(how = How.ID, using = "txtAuStZipCode")
	public static WebElement zipCode1;

	public LobDetailsPage selectCitySearch1() throws AWTException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cityOverride1);
		// click(cityOverride1);
		// click(eleCitySearch11);
		eleCitySearch11.clear();
		type(eleCitySearch11, "SARASOTA");
		territoryOverwite1.clear();
		type(territoryOverwite1, "101");
		click(territoryOverwite1);

		return this;

	}

	@FindBy(how = How.ID, using = "txttxtAUGarClassCd")
	public static WebElement eleCityCode1;

	public LobDetailsPage selectCityCode() throws AWTException, InterruptedException {
		type(eleCityCode1, "A");
		Robot city = new Robot();
		city.keyPress(KeyEvent.VK_ENTER);
		city.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@id='txttxtAUGarClassCd_grid_grid']//tr[2]//td[3]")).click();
		return this;
	}

	@FindBy(how = How.ID, using = "cboAuMedPayment")
	public static WebElement eleMedPayment;

	public LobDetailsPage selectMedPayments() {
		click(eleMedPayment);
		Select MedPay = new Select(eleMedPayment);
		MedPay.selectByVisibleText("3,000");
		return this;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='expLocation']/div[1]/div[2]/div/h2")
	public static WebElement expand;

	public LobDetailsPage expand() {
		click(expand);
		return this;
	}
	@FindBy(how = How.ID, using = "rdoVehicleNo")
	public static WebElement eleVehicleNoRadio;

	public LobDetailsPage clickVehicleNoRadio() {
		click(eleVehicleNoRadio);

		return this;
	}

	@FindBy(how = How.ID, using = "rdoDriversNo")
	public static WebElement eleDriverNoRadio;

	public LobDetailsPage clickDriverNoRadio() {
		click(eleDriverNoRadio);

		return this;
	}

	@FindBy(how = How.ID, using = "ddAUPolicyType")
	public static WebElement eleSRMPolicy;

	public LobDetailsPage selectSRMPolicy() {
		click(eleSRMPolicy);
		Select SRMPolicy = new Select(eleSRMPolicy);
		SRMPolicy.selectByIndex(1);

		return this;
	}

	@FindBy(how = How.ID, using = "btnRate1")
	public static WebElement eleEligibilityRate;

	public LobDetailsPage clickEligibilityRate() {
		click(eleEligibilityRate);

		return this;
	}


	@FindBy(how = How.ID, using = "txtAuBrdPip")
	public static WebElement eleBRDPip;

	public LobDetailsPage enterBrdPip() {
		type(eleBRDPip, "12345");
		// String BrdPip = eleBRDPip.getText();
		// Assert.assertTrue(BrdPip.length()==2);

		return this;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='pnlOptions']//div[@class='title']//h2")
	public static WebElement eleExpandOptionalCoverage;
	@FindBy(how = How.ID, using = "chkAdditionalInsuredsSC3504")
	public static WebElement AdditionalInsured;
	@FindBy(how = How.ID, using = "chkAllCostsExpensesSC0200")
	public static WebElement AllCost;
	@FindBy(how = How.ID, using = "chkConsenttoSettleSC3515")
	public static WebElement ConsentToSettle;
	@FindBy(how = How.ID, using = "chkConsenttoSettleSC3507")
	public static WebElement ConsentToSettleCoverage;
	@FindBy(how = How.ID, using = "chkEmploymentPracticesSC3513")
	public static WebElement EmploymentPractices;
	@FindBy(how = How.ID, using = "chkLimitedCivilLegalSC3508")
	public static WebElement LimitedCivil;

	public LobDetailsPage selectOptionalCoverage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", eleExpandOptionalCoverage);
		JavascriptExecutor AI = (JavascriptExecutor) driver;
		AI.executeScript("arguments[0].click();", AdditionalInsured);
		JavascriptExecutor AC = (JavascriptExecutor) driver;
		AC.executeScript("arguments[0].click();", AllCost);
		JavascriptExecutor CS = (JavascriptExecutor) driver;
		CS.executeScript("arguments[0].click();", ConsentToSettle);
		JavascriptExecutor CS_B = (JavascriptExecutor) driver;
		CS_B.executeScript("arguments[0].click();", ConsentToSettleCoverage);
		JavascriptExecutor EP = (JavascriptExecutor) driver;
		EP.executeScript("arguments[0].click();", EmploymentPractices);
		JavascriptExecutor LC = (JavascriptExecutor) driver;
		LC.executeScript("arguments[0].click();", LimitedCivil);

		return this;
	}

	@FindBy(how = How.ID, using = "cboLiabilityLimit")
	public static WebElement SSLimit;

	public LobDetailsPage selectSSLimit() {
		Select ssLimit = new Select(SSLimit);
		ssLimit.selectByVisibleText("100,000/300,000");

		return this;
	}

	@FindBy(how = How.ID, using = "chkpricov")
	public static WebElement elePriorActs;

	public LobDetailsPage clickPriorAct() {
		click(elePriorActs);

		return this;
	}

	@FindBy(how = How.ID, using = "txtOPVisits")
	public static WebElement eleOutPatients;

	public LobDetailsPage enterOutPatients() {
		type(eleOutPatients, "1");

		return this;
	}

	@FindBy(how = How.ID, using = "txtIPBeds")
	public static WebElement eleInBeds;

	public LobDetailsPage enterInBeds() {
		type(eleInBeds, "1");

		return this;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='expandCollapsePanelContainer'][3]/div/div/div/h4")
	public static WebElement eleExpandLocationPanel;
	@FindBy(how = How.ID, using = "FL0010010000001_txtPremBaseRates")
	public static WebElement elePremBaseRates;
	@FindBy(how = How.ID, using = "FL0010010000001_txtPremReferral")
	public static WebElement elePremrefferal;
	@FindBy(how = How.ID, using = "FL0010010000001_txtProdBaseRates")
	public static WebElement eleProdBaseRates;
	@FindBy(how = How.ID, using = "FL0010010000001_txtProdReferral")
	public static WebElement eleProdRfferal;
	@FindBy(how = How.NAME, using = "FL0010010000001$cboFilingInd_Text")
	public static WebElement eleFilgIndtext;
	@FindBy(how = How.NAME, using = "FL0010010000001$cboPremiumBasis_Text")
	public static WebElement elePremiumBasis11;
	@FindBy(how = How.NAME, using = "FL0010010000001$cboRateBasis_Text")
	public static WebElement eleRateBasisFl;

	public LobDetailsPage locationOverride() {
		click(eleExpandLocationPanel);
		type(elePremBaseRates, "0.5");
		type(elePremrefferal, "Test");
		type(eleProdBaseRates, "0.5");
		type(eleProdRfferal, "Test");
		JavascriptExecutor flgInd = (JavascriptExecutor) driver;
		flgInd.executeScript("arguments[0].click();", eleFilgIndtext);
		type(eleFilgIndtext, "1");

		JavascriptExecutor premBasis = (JavascriptExecutor) driver;
		premBasis.executeScript("arguments[0].click();", elePremiumBasis);
		type(elePremiumBasis11, "1");

		JavascriptExecutor rateBasis = (JavascriptExecutor) driver;
		rateBasis.executeScript("arguments[0].click();", eleRateBasisFl);
		type(eleRateBasisFl, "1");

		return this;
	}

	// 2nd loctaion override

	@FindBy(how = How.XPATH, using = "//div[@class='expandCollapsePanelContainer'][3]/div/div/div/h4")
	public static WebElement eleExpandLocationPanel1;
	@FindBy(how = How.ID, using = "FL0020010000001_txtPremBaseRates")
	public static WebElement elePremBaseRates1;
	@FindBy(how = How.ID, using = "FL0020010000001_txtPremReferral")
	public static WebElement elePremrefferal1;
	@FindBy(how = How.ID, using = "FL0020010000001_txtProdBaseRates")
	public static WebElement eleProdBaseRates1;
	@FindBy(how = How.ID, using = "FL0020010000001_txtProdReferral")
	public static WebElement eleProdRfferal1;
	@FindBy(how = How.NAME, using = "FL0020010000001$cboFilingInd_Text")
	public static WebElement eleFilgIndtext1;
	@FindBy(how = How.NAME, using = "FL0020010000001$cboPremiumBasis_Text")
	public static WebElement elePremiumBasis1;
	@FindBy(how = How.NAME, using = "FL0020010000001$cboRateBasis_Text")
	public static WebElement eleRateBasisFl1;

	public LobDetailsPage locationOverride2() {
		click(eleExpandLocationPanel1);
		type(elePremBaseRates1, "0.5");
		type(elePremrefferal1, "Test");
		type(eleProdBaseRates1, "0.5");
		type(eleProdRfferal1, "Test");
		JavascriptExecutor flgInd = (JavascriptExecutor) driver;
		flgInd.executeScript("arguments[0].click();", eleFilgIndtext1);
		type(eleFilgIndtext1, "1");

		JavascriptExecutor premBasis = (JavascriptExecutor) driver;
		premBasis.executeScript("arguments[0].click();", elePremiumBasis1);
		type(elePremiumBasis1, "1");

		JavascriptExecutor rateBasis = (JavascriptExecutor) driver;
		rateBasis.executeScript("arguments[0].click();", eleRateBasisFl1);
		type(eleRateBasisFl1, "1");

		return this;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"lobTabBar\"]//li[2]//div//a")
	public static WebElement eleLobHeaderClick;

	public LobDetailsPage clickLobHeader() {
		click(eleLobHeaderClick);

		return this;
	}

	// Next-NavNext

	@FindBy(how = How.ID, using = "NavNext")
	public static WebElement eleNextButton;

	public LobDetailsPage clickNextNavButton() {
		click(eleNextButton);

		return this;
	}

	@FindBy(how = How.ID, using = "btnEachAccLmt")
	public static WebElement elegeneralAggrLimit;
	@FindBy(how = How.XPATH, using = "//table[@id='txtGLGenlAggr_grid_grid']//tbody//tr[5]//td[1]")
	public static WebElement eleSelectAggrLimit;

	public LobDetailsPage selectAggrLimit() {
		click(elegeneralAggrLimit);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", eleSelectAggrLimit);

		return this;
	}

	// Issue-No of emp

	@FindBy(how = How.ID, using = "txtEmployees")
	public static WebElement eleNoOfEmp;
	public LobDetailsPage enterNoOfEmp() {
		type(eleNoOfEmp, "20");
		return this;
	}

	// Issue-No oF emp assign to location
	@FindBy(how = How.NAME, using = "txtLcEmployees")
	public static WebElement eleNoOfEmpAssign;
	public LobDetailsPage enterNoOfEmpToLoctaion() {
		click(eleNoOfEmpAssign);
		type(eleNoOfEmpAssign, "20");
		return this;
	}

	// Issue-Max No oF emp assign to location
	@FindBy(how = How.NAME, using = "txtLcMaxEmp")
	public static WebElement eleMaxNoOfEmpAssign;
	public LobDetailsPage enterMaxNoOfEmpToLoctaion() {
		click(eleMaxNoOfEmpAssign);
		type(eleMaxNoOfEmpAssign, "1");
		return this;
	}

	// Issue-coins type
	@FindBy(how = How.ID, using = "ddlCoinsType")
	public static WebElement eleCoinsType;

	public LobDetailsPage clickCoinsType() {
		click(eleCoinsType);

		return this;
	}
	//Edit GL LOB
	@FindBy(how=How.LINK_TEXT,using="Edit GL LOB")
	public static WebElement eleEditGlLOB;
	public LobDetailsPage clickEditGlLOB(){
		click(eleEditGlLOB);
		return this;
	}
	//Driver Other Car
	@FindBy(how = How.ID, using = "chkOptDoc")
	public static WebElement eleCovDriveOtherCar;
	public LobDetailsPage clickCovDriveOtherCar() {
		try {
			if(!eleCovDriveOtherCar.isSelected())
				click(eleCovDriveOtherCar);
		} catch (WebDriverException e) {
			System.out.println("DOC already selected");
		}

		return this;
	}
	//No of Individuals txtAUStDoc
	@FindBy(how = How.ID, using = "txtAUStDoc")
	public static WebElement eleNoOfIndividuals;
	public LobDetailsPage enterNoOfIndividuals(String data) {
		click(eleNoOfIndividuals);
		type(eleNoOfIndividuals, data);
		return this;
	}
	//Coverage Type 
	@FindBy(how = How.ID, using = "txtAUStDocCov")
	public static WebElement eleDocCoverageType;
	@FindBy(how = How.XPATH,using="(//input[@class='btnGo'])[1]")
	public static WebElement eleDocCoverageTypeSearchButton;
	@FindBy(how = How.XPATH,using="(//td[@class='sigi-grid-cell']/input)[2]")
	public static WebElement eleMedPay;
	@FindBy(how = How.XPATH,using="(//td[@class='sigi-grid-cell']/input)[4]")
	public static WebElement eleComp;
	//Select Items
	@FindBy(how = How.LINK_TEXT,using="Select Items")
	public static WebElement eleSelectItems;

	public LobDetailsPage selDocCoverageType() {
		click(eleDocCoverageTypeSearchButton);
		click(eleMedPay);
		//click(eleComp);
		click(eleSelectItems);

		return this;
	}
	//DOC- Med Pay Limit 
	@FindBy(how = How.ID, using = "cboAUDocMedLim")
	public static WebElement eleDdlMedPayLimit;
	public LobDetailsPage selDdlDocMedPayLimit() {
		try {
			if(eleCovDriveOtherCar.isEnabled())
				click(eleDdlMedPayLimit);
			selectDropDownUsingIndex(eleDdlMedPayLimit, 1);
		} catch (WebDriverException e) {
			System.out.println("MED PAY Disabled");
		}

		return this;
	}
	@FindBy(how = How.ID, using = "chkspliAuSpecPeril")
	public static WebElement eleChkBxCovSpecPerils;
	@FindBy(how = How.ID, using = "cboSPType")
	public static WebElement eleDdlSpecPerilsType;
	@FindBy(how = How.ID, using = "txtSPCostNew")
	public static WebElement eleTxtSpecPerilsCostNew;

	public void clickSpecPerils(String data,String data1) {
		try {
			if (eleChkBxCovSpecPerils.isDisplayed()&&eleChkBxCovSpecPerils.isEnabled()) {
				click(eleChkBxCovSpecPerils);
				click(eleDdlSpecPerilsType);
				selectDropDownUsingText(eleDdlSpecPerilsType, data);
				type(eleTxtSpecPerilsCostNew, data1);
			}

		} catch (WebDriverException e) {
			System.out.println("Spec Perils Covergae is not available");
		}


	}


}

