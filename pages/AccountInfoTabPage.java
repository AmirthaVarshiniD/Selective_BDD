package com.api.cucumber.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.api.cucumber.comMethods.ProjMethods;


public class AccountInfoTabPage extends ProjMethods {
	PolicyDetailsPage policy = new PolicyDetailsPage(driver);
	public AccountInfoTabPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="/html/body/div[2]/div[2]/div/button[2]")
	public static WebElement eleBtnYesOrNo;
	@FindBy(how=How.ID,using="txtAgentCode")
	public static WebElement eleAgentCode;
	public AccountInfoTabPage enterAgentCode(String data)
	{
		type(eleAgentCode, data);
		return this;
	}

	@FindBy(how=How.ID,using="ddlPredState")
	public static WebElement eleSelectPredState;
	public AccountInfoTabPage selectPredState(String data)
	{
		selectDropDownUsingText(eleSelectPredState, data);
		return this;
	}

	//Multi state check Box
	@FindBy(how=How.ID,using="chkMultiSt")
	public static WebElement eleChkBoxMultiState;
	public AccountInfoTabPage selectMultiState()
	{
		click(eleChkBoxMultiState);
		return this;
	}

	@FindBy(how=How.ID,using="txtMailAddr1")
	public static WebElement eleMailAddress1;
	public AccountInfoTabPage enterMailAddrs1(String data)
	{
		type(eleMailAddress1, data);
		return this;
	}

	@FindBy(how=How.ID,using="txtMailAddr2")
	public static WebElement eleMailAddress2;
	public AccountInfoTabPage enterMailAddrs2(String data)
	{
		type(eleMailAddress2, data);
		return this;
	}
	@FindBy(how=How.ID,using="txtZipCode_Zip5")
	public static WebElement eleZipCode1;
	public AccountInfoTabPage enterZipCode1(String data){
		eleZipCode1.click();
		type(eleZipCode1, data);
		return this;
	}
	@FindBy(how=How.ID,using="txtZipCode_Zip4")
	public static WebElement eleZipCode2;
	public AccountInfoTabPage enterZipCode2(String data){
		eleZipCode2.click();
		type(eleZipCode2, data);
		return this;
	}

	@FindBy(how=How.ID,using="txtCity")
	public static WebElement eleCity;
	public AccountInfoTabPage enterCity(String data){
		eleCity.click();
		type(eleCity, data);
		return this;
	}

	@FindBy(how=How.ID,using="ddlMailState")
	public static WebElement eleSelectMailState;
	public AccountInfoTabPage selectMailState(String data)
	{
		selectDropDownUsingText(eleSelectMailState, data);
		return this;
	}


	@FindBy(how=How.ID,using="txtPhone_AreaCode")
	public static WebElement eleAreaCode;
	public AccountInfoTabPage enterPhoneAreaCode(String data)
	{
		eleAreaCode.click();
		type(eleAreaCode, data);
		return this;
	}

	@FindBy(how=How.ID,using="txtPhone_Exchange")
	public static WebElement elePhoneExchange;
	public AccountInfoTabPage enterPhoneExchange(String data)
	{
		elePhoneExchange.click();
		type(elePhoneExchange, data);
		return this;
	}

	@FindBy(how=How.ID,using="txtPhone_LastDigits")
	public static WebElement elePhoneLastDigits;
	public AccountInfoTabPage enterPhoneLastDigits(String data)
	{
		elePhoneLastDigits.click();
		type(elePhoneLastDigits, data);
		return this;
	}
	//rdoEmailStatusAsNone

	@FindBy(how=How.ID,using="rdoEmailStatusAsNone")
	public static WebElement eleEmailNone;
	public AccountInfoTabPage selectEmailAsNone()
	{
		click(eleEmailNone);
		return this;
	}
	//Account New To Agency- no
	@FindBy(how=How.ID,using="radNewToAgencyNo")
	public static WebElement eleBtnNewToAgencyNo;
	public AccountInfoTabPage clickRadioBtnNewToAgencyNo()
	{
		click(eleBtnNewToAgencyNo);
		return this;
	}
	//Account New To Agency- Yes
	@FindBy(how=How.ID,using="radNewToAgencyYes")
	public static WebElement eleBtnNewToAgencyYes;
	public AccountInfoTabPage clickRadioBtnNewToAgency()
	{
		click(eleBtnNewToAgencyYes);
		return this;
	}

	@FindBy(how=How.ID,using="txtTargPremium")
	public static WebElement elePremiumsize;
	public AccountInfoTabPage enterPreminumSize(String data)
	{
		type(elePremiumsize, data);
		return this;
	}

	@FindBy(how=How.ID,using="txtEffDate_Text")
	public static WebElement eleEffcDate;
	public AccountInfoTabPage enterEffectDate(String data){
		eleEffcDate.click();
		type(eleEffcDate, data);
		eleEffcDate.sendKeys(Keys.TAB);
		return this;
	}

	//Expiration Date
	@FindBy(how=How.ID,using="txtExpDate_Text")
	public static WebElement eleExpDate;
	public AccountInfoTabPage enterExpDate(String data){
		eleExpDate.click();
		type(eleExpDate, data);
		eleExpDate.sendKeys(Keys.TAB);
		return this;
	}

	@FindBy(how=How.XPATH,using="//input[@id='chkCPPEMP']")
	public static WebElement eleCpp;
	public AccountInfoTabPage selectCPP()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.id("chkCPPEMP")));
		return this;
	}
	//Monoline Crime fidelity - short term
	//	/chkMonoFidelityEMP
	@FindBy(how=How.ID,using="chkMonoFidelityEMP")
	public static WebElement eleMonoCrimeFidelityShtTerm;
	public AccountInfoTabPage selectMonolineCrimeFidelityShortTerm()
	{
		click(eleMonoCrimeFidelityShtTerm);

		return this;
	}
	//Monoline Crime Fidelity
	@FindBy(how=How.ID,using="chkMonoFidelityContuEMP")
	public static WebElement eleMonoCrimeFidelity;

	@FindBy(how=How.ID,using="SIGI_DialogURL")
	public static WebElement eleIframe;
	@FindBy(how=How.ID,using="rdoAnnual")
	public static WebElement eleRdoAnnual;
	@FindBy(how=How.ID,using="btnSave")
	public static WebElement eleSave;
	public AccountInfoTabPage selectMonolineCrimeFidelity()
	{
		click(eleMonoCrimeFidelity);
		switchToFrame(eleIframe);
		click(eleRdoAnnual);
		click(eleSave);
		return this;
	}


	//Select CPP in Agent Login
	@FindBy(how=How.ID,using="chkCPPQQ")
	public static WebElement eleCPPinAgent;
	public AccountInfoTabPage selectCPPinAgent()
	{
		click(eleCPPinAgent);
		return this;
	}

	@FindBy(how=How.XPATH,using="(//div[@class='formButtons']/a)[4]")
	public static WebElement eleBtnNext;
	public AccountInfoTabPage clickNext()
	{
		click(eleBtnNext);
		return this;
	}

	//In Agent
	@FindBy(how=How.XPATH,using="//div[@class='ui-dialog-buttonset']/button/span")
	public static WebElement eleBtnOk;
	public PolicyDetailsPage clickOk()
	{
		click(eleBtnOk);
		return new PolicyDetailsPage(driver);
	}

	@FindBy(how=How.LINK_TEXT,using="Next to Policy Details")
	public static WebElement eleBtnNextToPolDet;
	public PolicyDetailsPage clickNextToPolDet()
	{
		try
		{
			if (eleBtnNextToPolDet.isDisplayed()) {
				driver.switchTo().frame("SIGI_DialogURL");
				//switchToFrame(eleSwitchFrame);
				click(eleBtnNextToPolDet);

			} else {

			}
		}catch (WebDriverException e) {
			System.out.println("Not Available");
		}

		return new PolicyDetailsPage(driver);
	}






	//Next to Policy Details
	@FindBy(how=How.LINK_TEXT,using="Next to Policy Details")
	public static WebElement eleBtnNextToPolicyDet;
	public PolicyDetailsPage clickNextToPolicyDet()
	{
		click(eleBtnNextToPolicyDet);
		return new PolicyDetailsPage(driver);
	}
	//click On Lob Details Tab
	@FindBy(how=How.LINK_TEXT,using="Lob Details")
	public static WebElement eleLobDetails;
	public LobDetailsPage clickLobDetails()
	{
		click(eleLobDetails);
		return new LobDetailsPage(driver);
	}
	//click On Premmium Summary Tab
		@FindBy(how=How.LINK_TEXT,using="Premium Summary")
		public static WebElement elePremmiumSummary;
		public PremiumSummaryPage clickPremmiumSummary()
		{
			click(elePremmiumSummary);
			return new PremiumSummaryPage(driver);
		}
	
	@FindBy(how = How.XPATH, using = "//input[@id='chkCPPEMP']")
	public static WebElement eleApplicablePolicy;
	public AccountInfoTabPage selectApplicablePolicy() throws InterruptedException {
		// wait(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.id("chkCPPEMP")));
		return this;
	}
	//Dashboard
	@FindBy(how=How.LINK_TEXT,using="Dashboard")
	public static WebElement eleDashBoard;
	public ComLinesAutoSysPage clickDashBoard()
	{
		click(eleDashBoard);
		return new ComLinesAutoSysPage(driver);
	}


	@FindBy(how = How.XPATH, using = "//input[@id='chkMonoWCEMP']")
	public static WebElement eleWCPolicy;

	public AccountInfoTabPage selectWCPolicy() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.id("chkMonoWCEMP")));
		// click(eleWCPolicy);
		return this;
	}

	// selecting policy by list
	@FindBy(how = How.CSS, using = "#EmployeePolicyTypes ul li")
	public static List<WebElement> elePolicyList;

	public AccountInfoTabPage choosePolicy(String string) throws InterruptedException {
		if (string.equals("Management Liability")) {
			selectApplicablePolicy();
		} else if (string.equals("WC")) {
			selectWCPolicy();
		} else if (string.equals("CPPQ")) {
			selectCPPolicyAgent();
		} else {

			selectApplicablePolicy();
		}
		return this;

	}

	// SELECTING POLICY FOR AGENT LOGIN
	@FindBy(how = How.XPATH, using = "//input[@id='chkCPPQQ']")
	public static WebElement eleCPPolicyAgent;

	public AccountInfoTabPage selectCPPolicyAgent() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", eleCPPolicyAgent);
		return this;
	}



	/*@FindBy(how = How.XPATH, using = "//*[@id=\"accountInfoBar\"]/ul/li[1]")
	public static WebElement getQuoteNum;

	public accountNameContext setPolicyNum() {
		String quote = getQuoteNum.getText();
		setPolicyNum();
		return null;

	}
	 */

	@FindBy(how = How.ID, using = "ddlPrevPolType1")
	public static WebElement elePreviousPolicy;

	public AccountInfoTabPage SelectPreviousPolicy() {
		click(elePreviousPolicy);
		Select previousPolicy = new Select(elePreviousPolicy);
		previousPolicy.selectByValue("CPP");
		return this;
	}

	@FindBy(how = How.ID, using = "txtPrevPolPrefix1")
	public static WebElement elePreviousPolicyField1;

	public AccountInfoTabPage enetrPreviousPolicyField1() {
		type(elePreviousPolicyField1, "S");
		return this;
	}

	@FindBy(how = How.ID, using = "txtPrevPolNbr1")
	public static WebElement elePreviousPolicyField2;

	public AccountInfoTabPage enetrPreviousPolicyField2() {
		click(elePreviousPolicyField2);
		type(elePreviousPolicyField2, "5689452");
		return this;
	}

	@FindBy(how = How.ID, using = "txtPrevPolSuffix1")
	public static WebElement elePreviousPolicyField3;

	public AccountInfoTabPage enetrPreviousPolicyField3() {
		click(elePreviousPolicyField3);
		type(elePreviousPolicyField3, "00");
		return this;
	}
	//Agent-Accout Page Ok or Cancel popup

	@FindBy(how = How.CLASS_NAME, using = "ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover")
	public static WebElement eleOKButton;

	public AccountInfoTabPage clickOKPopupButton() {
		click(eleOKButton);
		return this;
	}

	@FindBy(how = How.ID, using = "rdoEmailStatusAsNone")
	public static WebElement eleMailStatusNone;

	public AccountInfoTabPage clickRadioBtnMailStatus() {
		click(eleMailStatusNone);
		return this;

	}

	@FindBy(how = How.ID, using = "txtExpDate")
	public static WebElement eleExpcDate;

	public AccountInfoTabPage enterExpectDate() throws InterruptedException {
		eleExpcDate.click();
		return this;
	}



}
