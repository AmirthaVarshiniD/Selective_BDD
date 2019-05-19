package com.api.cucumber.pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.api.cucumber.comMethods.ProjMethods;


public class PolicyDetailsPage extends ProjMethods {
	public PolicyDetailsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}


	@FindBy(how=How.XPATH,using="//div[@id='accountInfoBar']")
	public static WebElement eleQuote;
	public PolicyDetailsPage getQuote(){
		String quoteTxt = eleQuote.getText();
		int quoteNum= Integer.parseInt(quoteTxt.replaceAll("[^0-9]",""));
		quoteNo=Integer.toString(quoteNum);
		if(quoteNo.length()>8)
		{
			quoteNo= quoteNo.substring(quoteNo.length()-8);	
		}
		System.out.println("Quote No...."+quoteNo);
		return this;

	}

	public PolicyDetailsPage getQuoteNo() {
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(eleQuote.getText());
		while (m.find()) {
			no = m.group();
			//int quote_No= Integer.parseInt(no.replaceAll(" ",""));
			System.out.println("No..... "+no);
		}
		return this;

	}

	@FindBy(how=How.ID,using="ddlBusinessType")
	public static WebElement eleBuisnessType;
	public PolicyDetailsPage selectBuisnessType(String data)
	{
		click(eleBuisnessType);
		selectDropDownUsingText(eleBuisnessType, data);
		return this;
	}


	@FindBy(how=How.ID,using="txtNatureOfBus")
	public static WebElement eleNatureOfBuisness;
	public PolicyDetailsPage enterNatureOfBus(String data)
	{
		type(eleNatureOfBuisness, data);
		return this;
	}

	@FindBy(how=How.ID,using="txtBusYear")
	public static WebElement eleYear;
	public PolicyDetailsPage enterYear(String data)
	{
		type(eleYear, data);
		return this;
	}

	@FindBy(how=How.ID,using="cboOwnership_Text")
	public static WebElement eleOwnershipr;
	public PolicyDetailsPage enterOwnership(String data)
	{
		//String Value="CORPORATION";
		click(eleOwnershipr);
		type(eleOwnershipr, data);
		return this;
	}

	@FindBy(how=How.ID,using="ddlProgCode")
	public static WebElement eleMarketSeg;
	public PolicyDetailsPage selectrMarketSegment(String data)
	{
		selectDropDownUsingText(eleMarketSeg, data);
		return this;
	}

	public PolicyDetailsPage checkDropDownValue(String data)
	{

		checkValuesInDropDownList(eleMarketSeg, data);
		return this;
	}
	@FindBy(how=How.ID,using="ddlInsCo")
	public static WebElement eleInsComp;
	public PolicyDetailsPage selectInsComp(String data)
	{
		selectDropDownUsingText(eleInsComp, data);
		return this;
	}


	public PolicyDetailsPage findListOfInsComp()
	{
		allDropDownValues(eleInsComp);
		return this;
	}

	@FindBy(how=How.ID,using="UC_ProductInfoLobSection_chkGL")
	public static WebElement eleLobGL;
	public PolicyDetailsPage selectLOBGL(){
		click(eleLobGL);
		return this;
	}

	@FindBy(how=How.ID,using="UC_ProductInfoLobSection_chkPF")
	public static WebElement eleLobPF;
	public PolicyDetailsPage selectLOBPF(){
		click(eleLobPF);
		return this;
	}
	//AUTO LOB
	@FindBy(how=How.ID,using="UC_ProductInfoLobSection_chkAU")
	public static WebElement eleLobAuto;
	public PolicyDetailsPage selectLOBAuto(){
		click(eleLobAuto);
		return this;
	}
	//Garage LOB
	@FindBy(how = How.NAME, using = "UC_ProductInfoLobSection$chkGR")
	public static WebElement eleLobGarage;
	public PolicyDetailsPage selectLOBGarage() {
		click(eleLobGarage);
		return this;
	}
	//Auto Non Dealer LOB
	@FindBy(how = How.NAME, using = "UC_ProductInfoLobSection$chkAS")
	public static WebElement eleLobAutoNonDealer;
	public PolicyDetailsPage selectLOBAutoNonDealer() {
		click(eleLobAutoNonDealer);
		return this;
	}
	//IR LOB
	@FindBy(how = How.ID,using="UC_ProductInfoLobSection_chkIR")
	public static WebElement eleLobIR;
	public PolicyDetailsPage selectLOBInlandMarine() {
		click(eleLobIR);
		return this;
	}
	//COP LOB
	@FindBy(how = How.ID,using="UC_ProductInfoLobSection_chkCP")
	public static WebElement eleLobCOP;
	public PolicyDetailsPage selectLOBCop() {
		click(eleLobCOP);
		return this;
	}
	//PH LOB
	@FindBy(how=How.ID,using="UC_ProductInfoLobSection_chkPH_Label")
	public static WebElement eleLobPH;
	public PolicyDetailsPage selectLOBPH(){
		click(eleLobPH);
		return this;
	}

	@FindBy(how=How.ID,using="UC_ProductInfoLobSection_chkCF")
	public static WebElement eleLobCF;
	public PolicyDetailsPage selectLOBCF(){
		click(eleLobCF);
		return this;
	}

	@FindBy(how=How.ID,using="UC_ProductInfoLobSection_chkSW")
	public static WebElement eleLobBOP;
	public PolicyDetailsPage selectLOBBOP(){
		click(eleLobBOP);
		return this;
	}
	@FindBy(how=How.ID,using="UC_ProductInfoLobSection_chkCP")
	public static WebElement eleLobCP;
	public PolicyDetailsPage selectLOBCP(){
		click(eleLobCP);
		return this;
	}

	@FindBy(how=How.ID,using="UC_ProductInfoLobSection_chkAS")
	public static WebElement eleLobAS;
	public PolicyDetailsPage selectLOBAS(){
		click(eleLobAS);
		return this;
	}

	@FindBy(how=How.ID,using="txtSicCode")
	public static WebElement eleSICCode;
	@FindBy(how=How.ID,using="btnSicGo")
	public static WebElement eleSICCodeSearch;
	@FindBy(how=How.XPATH,using="//input[@name='sicTable_grid_rdg']")
	public static WebElement eleSearchResult;

	public PolicyDetailsPage selectSICCoide(String data){
		type(eleSICCode, data);
		click(eleSICCodeSearch);
		click(eleSearchResult);
		return this;
	}

	//Terrorism Exclusion 
	@FindBy(how=How.ID,using="chkTerrorExcl")
	public static WebElement eleTerrorismExcl;
	public PolicyDetailsPage clickTerrorismExcl()
	{
		click(eleTerrorismExcl);
		return this;
	}

	//	/
	@FindBy(how=How.ID,using="rdoTerrorismExclQuestYes")
	public static WebElement eleTerrExclQuestYes;
	public PolicyDetailsPage selTerrExclQuestYes()
	{
		click(eleTerrExclQuestYes);
		return this;
	}


	@FindBy(how=How.ID,using="rdoIsMarijuanaQuestNo")
	public static WebElement eleMarijuanaQuestNo;
	public PolicyDetailsPage selectMarijuanaQuest()
	{
		try {
			if (eleMarijuanaQuestNo.isDisplayed()) {
				click(eleMarijuanaQuestNo);		
			}
		} catch (WebDriverException e) {
			System.out.println("Not Available");
		}

		return this;
	}

	//Additional coverage Option
	@FindBy(how=How.ID,using="rdoQuestCpSafetyNo")
	public static WebElement eleAdditionalCoverNo;
	public PolicyDetailsPage selectAdditionalCovgNO()
	{
		click(eleAdditionalCoverNo);
		return this;
	}


	//rdoQuestCpSafetyNo

	@FindBy(how=How.ID,using="rdoQuestCpSafetyNo")
	public static WebElement eleAHLAMember;
	public PolicyDetailsPage selectAHLAMemNO()
	{
		click(eleAHLAMember);
		return this;
	}

	@FindBy(how=How.ID,using="ddlPolicyPriorCarrier")
	public static WebElement elePolicyPriorCarrier;
	public PolicyDetailsPage selectPriorCarrier(String data)
	{
		selectDropDownUsingText(elePolicyPriorCarrier, data);
		return this;
	}

	@FindBy(how=How.ID,using="navForward")
	public static WebElement eleNextBtn;
	public PolicyDetailsPage clickNext(){
		click(eleNextBtn);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", eleNextBtn);
		return this;
	}
	//Click Next To Lob details
	@FindBy(how=How.LINK_TEXT,using="Next to LOB Details")
	public static WebElement eleNextToLobDetails;
	public PolicyDetailsPage clickNextToLobDetails(){
		click(eleNextToLobDetails);
		return this;
	}
	//Click Lob details Tab
	@FindBy(how=How.LINK_TEXT,using="Lob Details")
	public static WebElement eleLobDetails;
	public PolicyDetailsPage clickLobDetails(){
		click(eleLobDetails);
		return this;
	}



	@FindBy(how=How.ID,using="navForward")
	public static WebElement eleNextButton;
	public LocationsPage clickNextButton() throws InterruptedException
	{
		//driver.navigate().refresh();
		Thread.sleep(2000);
		click(eleNextButton);
		/*WebDriverWait wait = new WebDriverWait(driver, 90);

		wait.until(ExpectedConditions.elementToBeClickable(eleNextButton));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", eleNextButton);*/
		return new LocationsPage(driver);
	}
	//Click Next on Policy Details-Eligibility Ques
	@FindBy(how=How.ID,using="navForward")
	public static WebElement eleNextBtnInEligQues;
	public LocationsPage clickNextInPolicyDetailsPage(){
		click(eleNextBtnInEligQues);
		return new LocationsPage(driver);
	}
	//Click Edit
	@FindBy(how=How.LINK_TEXT,using="Edit")
	public static WebElement eleEdit;
	public PolicyDetailsPage clickEdit()
	{
		click(eleEdit);
		return this;
	}

	//Click Locations Tab
	@FindBy(how=How.LINK_TEXT,using="Locations")
	public static WebElement eleLocations;
	public LocationsPage clickLocation()
	{
		click(eleLocations);
		return new LocationsPage(driver);
	}
	//Edit Location
	@FindBy(how=How.LINK_TEXT,using="Edit Location")
	public static WebElement eleEditLocations;
	public LocationsPage clickEditLocation()
	{
		click(eleEditLocations);
		return new LocationsPage(driver);
	}
	//Verify LOBs		
	@FindBy(how=How.XPATH,using="(//div[@class='formBox'])[2]")
	public static WebElement eleLobs;
	public PolicyDetailsPage verifyLobs(String data)
	{
		try {
			if(!getText(eleLobs).equals(data)) {
				reportStep("The text: "+getText(eleLobs)+" doesn't matches with the value :"+data,"PASS");
			}else {
				reportStep("The text "+getText(eleLobs)+" matches the actual "+data,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 
		return this;
	}	
	public PolicyDetailsPage verifyLobAvail(String data)
	{
		verifyPartialText(eleLobs, data);
		return this;
	}
	public void verifyLOBPH(String data)
	{
		verifyPartialText(eleLobPH, data);
	}
	//Cancel Button
	@FindBy(how=How.LINK_TEXT,using="Cancel")
	public static WebElement eleCancel;
	public PolicyDetailsPage clickCancel()
	{
		click(eleCancel);
		return this;
	}
	//Edit Policy Details
	@FindBy(how=How.LINK_TEXT,using="Edit Policy Details")
	public static WebElement eleEditPolicyDetails;
	public PolicyDetailsPage clickEditPolicyDetails()
	{
		click(eleEditPolicyDetails);
		return this;
	}
	//	(//div[@class='ui-dialog-buttonset']/button)[1]
	@FindBy(how=How.XPATH,using="(//div[@class='ui-dialog-buttonset']/button)[1]")
	public static WebElement eleYes;
	public AccountInfoTabPage clickYes()
	{
		click(eleYes);
		return new AccountInfoTabPage(driver);
	}
	@FindBy(how = How.ID, using = "txtNatureOfBus")
	public static WebElement eleNatureofBuisness;

	public PolicyDetailsPage enterNatureOfBus() {
		type(eleNatureofBuisness, "TEST");
		return this;
	}

	@FindBy(how = How.ID, using = "cboOwnership_button")
	public static WebElement eleOwnership;
	@FindBy(how = How.XPATH,using="(//span[@id='cboOwnership_OptionsDiv']/ul/li)[3]")
	public static WebElement eleOwnershipVal;
	public PolicyDetailsPage selectOwnership(String data) {
		click(eleOwnership);
		click(eleOwnershipVal);
		return this;
	}

	@FindBy(how = How.ID, using = "UC_ProductInfoLobSection_chkSB")
	public static WebElement eleSBLob;
	public PolicyDetailsPage selectSBLob() {
		click(eleSBLob);
		return this;
	}

	@FindBy(how = How.ID, using = "UC_ProductInfoLobSection_chkSS")
	public static WebElement eleSSLob;
	public PolicyDetailsPage selectSSLob() {
		click(eleSSLob);
		return this;
	}

	@FindBy(how = How.NAME, using = "UC_ProductInfoLobSection$chkGR")
	public static WebElement eleGarage;
	public PolicyDetailsPage selectGarage() {
		click(eleGarage);
		return this;
	}

	@FindBy(how = How.NAME, using = "UC_ProductInfoLobSection$chkCN")
	public static WebElement eleContractor;
	public PolicyDetailsPage selectContractor() {
		click(eleContractor);
		return this;
	}

	@FindBy(how = How.NAME, using = "UC_ProductInfoLobSection$chkTY")
	public static WebElement eleTechnology;

	public PolicyDetailsPage selectTechnologyLob() {
		click(eleTechnology);
		return this;
	}

	public PolicyDetailsPage selectLOBs(String LOB) {
		//		selectContractor();
		if (LOB.equals("GL")) {
			selectLOBGL();

		} else if (LOB.equals("SB")) {

			selectSBLob();
		} else if (LOB.equals("GR")) {
			selectGarage();
		} else if (LOB.equals("Con")) {
			selectContractor();
		} else if (LOB.equals("Tech")) {
			selectTechnologyLob();
		}

		return this;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='UC_ProductInfoLobSection_divLobContainer']//div//span//label")
	public static List<WebElement> eleLOBList;

	public PolicyDetailsPage verifyLobList() {

		for (WebElement lobs : eleLOBList) {
			String LobVal = lobs.getText();
			System.out.println(LobVal);
			Assert.assertTrue(!(LobVal.equals("Assisted Living Professional Liability")));

		}

		return this;
	}

	public PolicyDetailsPage verifyLobListsecondary() {

		for (WebElement lobs : eleLOBList) {
			String LobVal = lobs.getText();
			System.out.println(LobVal);
			Assert.assertTrue((LobVal.equals("Assisted Living Professional Liability")));

		}

		return this;
	}
	//OK 
	@FindBy(how=How.XPATH,using="//span[@class='ui-button-text']")
	public static WebElement eleOkButton;
	public AccountInfoTabPage clickOkButton() {
		try {
			if (eleOkButton.isDisplayed()) {
				click(eleOkButton);
			}
		} catch (WebDriverException e) {
			System.out.println("Ok Buton Not Available");
		}

		return new AccountInfoTabPage(driver);
	}

}
