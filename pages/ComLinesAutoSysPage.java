package com.api.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.api.cucumber.comMethods.ProjMethods;


public class ComLinesAutoSysPage extends ProjMethods {

	public ComLinesAutoSysPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	LoginPage2 login = new LoginPage2();
	//Go Button for Employee Login 
	@FindBy(how=How.ID,using="btnFieldQuoteGo")
	public static WebElement eleBtnGo;
	public EnterNamePage clickGo()
	{

		switchToWindow(1);
		driver.manage().window().maximize();
		click(eleBtnGo);
		return new EnterNamePage(driver);
	}
	//Go In Agent
	@FindBy(how=How.ID,using="cboType")
	public static WebElement eleBttnnGo;
	public EnterNamePage clickBttnGo()
	{

		switchToWindow(1);
		driver.manage().window().maximize();
		click(eleBttnnGo);
		return new EnterNamePage(driver);
	}


	@FindBy(how=How.ID,using="ddlLocations")
	public static WebElement eleRegions;
	public ComLinesAutoSysPage selRegions(String data)
	{
		switchToWindow(1);
		driver.manage().window().maximize();
		selectDropDownUsingText(eleRegions, data);
		return this;
	}
	@FindBy(how=How.XPATH,using="//div[@id='uniform-cboNBType']/select")
	public static WebElement eleDropDown;
	public EnterNamePage selectBuisnessIssue()
	{
		switchToWindow(1);
		driver.manage().window().maximize();
		selectDropDownUsingText(eleDropDown, "New Business Issue");
		click(eleBtnGo);
		return new EnterNamePage(driver);
	}
	public EnterNamePage selectTransaction(String transaction)
	{
		switchToWindow(1);
		driver.manage().window().maximize();
		if (transaction.equals("NBIS")) {
			selectDropDownUsingText(eleDropDown, "New Business Issue");
			click(eleBtnGo);

		} else if (transaction.equals("NBQU")) {

			click(eleBtnGo);
		}
		return new EnterNamePage(driver);
	}



	//	/Policy Details
	@FindBy(how=How.XPATH,using="//div[@id='uniform-ddlSearchType']/select")
	public static WebElement eleDDSearch;

	@FindBy(how=How.ID,using="ddlSearchType")
	public static WebElement eleDDSearchType;
	@FindBy(how=How.XPATH,using="//input[@id='txtSearchBox']")
	public static WebElement eleSearchBox;
	@FindBy(how=How.ID,using="btnSearch")
	public static WebElement eleSearch;

	@FindBy(how=How.LINK_TEXT,using="Policy Details")
	public static WebElement elePolDet;
	public ComLinesAutoSysPage enterQuoteNo()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(eleDDSearchType));
		wait.until(ExpectedConditions.elementToBeClickable(eleDDSearch));
		try {
			if (eleDDSearchType.isDisplayed()) {
				selectDropDownUsingText(eleDDSearchType, "Quote");
				click(eleSearchBox);
				type(eleSearchBox,no);
				click(eleSearch);
			}
			else if (eleDDSearch.isDisplayed()) {
				selectDropDownUsingText(eleDDSearch, "Quote");
				type(eleSearchBox,no);
				click(eleSearch);	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return this;
	}
	public ComLinesAutoSysPage enterName(String data)
	{
		switchToWindow(1);
		driver.manage().window().maximize();
		//selectDropDownUsingText(eleDDSearch, "Quote");
		click(eleSearchBox);
		type(eleSearchBox, data);
		click(eleSearch);
		return this;
	}
	//Get Policy Number
	@FindBy(how=How.XPATH,using="(//table[@id='divGrid_grid']/tbody/tr/td[3])[1]")
	public static WebElement elePolicyNumber;
	public ComLinesAutoSysPage getPolicyNo() {
		WebDriverWait wait = new WebDriverWait(driver, 90);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//table[@id='divGrid_grid']/tbody/tr/td[3])[1]")));	
		System.out.println("PolicyNOO..... "+elePolicyNumber.getText());
		PolicyNum = elePolicyNumber.getText();
		String policy = elePolicyNumber.getText().replace(" ", "  ");
		policyNo = policy.replace("-", "");
		System.out.println("PolicyNumber..... "+policyNo);

		return this;

	}
	@FindBy(how=How.LINK_TEXT,using="Next")
	public static WebElement eleNext;
	public ComLinesAutoSysPage clickNext(){
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next")));	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Next")));

		click(eleNext);
		return this;
	}
	//Finalize Policy
	@FindBy(how=How.LINK_TEXT,using="Finalize Policy")
	public static WebElement eleFinalizePolicy;
	public ComLinesAutoSysPage clickFinalizePolicy(){
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Finalize Policy")));	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Finalize Policy")));

		click(eleFinalizePolicy);
		return this;
	}
	@FindBy(how=How.XPATH,using="(//div[@class='sigi-fl-peakItem']/a)[1]")
	public static WebElement eleMore;
	@FindBy(how=How.LINK_TEXT,using="More")
	public static WebElement eleLinkMore;
	@FindBy(how=How.LINK_TEXT,using="New Business Log Update")
	public static WebElement eleNewBuisnessLogUpdate;
	//Click More --> New Buisness Log Update
	public ComLinesAutoSysPage clickNewBuisnessLogUpdate() {
		try
		{
			if (eleMore.isDisplayed()) {
				click(eleMore);
				click(eleNewBuisnessLogUpdate);
			}
			else if (eleLinkMore.isDisplayed()) {
				click(eleLinkMore);
				click(eleNewBuisnessLogUpdate);
			}
		}catch(WebDriverException e)
		{
			System.out.println("Not Available");
		}

		return this;
	}

	//View
	@FindBy(how=How.LINK_TEXT,using="View")
	public static WebElement eleView;
	public AccountInfoTabPage clickView() {
		click(eleView);
		return new AccountInfoTabPage(driver);
	}
	//NEW BUSINESS ISSUE
	@FindBy(how=How.LINK_TEXT,using="NEW BUSINESS ISSUE")
	public static WebElement eleTxnNewBuisnessIssue;
	@FindBy(how=How.LINK_TEXT,using="CANCELLATION")
	public static WebElement eleTxnCancellation;
	@FindBy(how=How.LINK_TEXT,using="REINSTATEMENT")
	public static WebElement eleTxnReinstatement;
	public AccountInfoTabPage clickTxnNewBuisnessIssue() {
		try {
			if (eleTxnNewBuisnessIssue.isDisplayed())
			{
				click(eleTxnNewBuisnessIssue);
			}

		} catch (WebDriverException e) {
			System.out.println("Transactions Not Available");
		}

		return new AccountInfoTabPage(driver);
	}

	@FindBy(how=How.XPATH,using="(//a[text()='View'])[4]")
	public static WebElement eleViewARPolicy;
	public ComLinesAutoSysPage clickViewARPolicy() {
		click(eleViewARPolicy);
		return this;
	}		
	@FindBy(how=How.LINK_TEXT,using="Renewal (Issue)")
	public static WebElement eleRenewalIssue;
	//More-->Renewal(Issue)
	public ComLinesAutoSysPage clickRenewal() {
		click(eleMore);
		click(eleRenewalIssue);
		return this;
	}
	//UW-Center
	@FindBy(how=How.XPATH,using="//li[@id='acContainer']")
	public static WebElement eleUWCenter;
	public ComLinesAutoSysPage clickUWCenter() {
		//Actions action = new Actions(driver);
		//action.moveToElement(eleUWCenter).click(eleRenewalBatchJob).build().perform();
		click(eleUWCenter);
		return this;
	}
	//RENEWAL ISSUE
	@FindBy(how=How.LINK_TEXT,using="RENEWAL ISSUE")
	public static WebElement eleRenewalIssuePolicy;
	public AccountInfoTabPage clickRenewalIssuePolicy() {

		try {
			if (eleRenewalIssuePolicy.isDisplayed()) {

				click(eleRenewalIssuePolicy);
			}
		} catch (WebDriverException e) {
			System.out.println("Renewal Issue not available");
		}

		return new AccountInfoTabPage(driver);
	}
	//Renewal Batch Job
	@FindBy(how=How.LINK_TEXT,using="Renewal Batch Job")
	public static WebElement eleRenewalBatchJob;
	public ComLinesAutoSysPage clickRenewalBatchJob() {
		//switchToWindow(2);
		click(eleRenewalBatchJob);
		return this;
	}
	//Policy Number 
	@FindBy(how=How.ID,using="txtPolQt")
	public static WebElement eleTxtPolicyNumber;
	public ComLinesAutoSysPage enterPolicyNumber(String data)
	{
		switchToWindow(2);
		driver.manage().window().maximize();
		try {
			if(eleTxtPolicyNumber.isDisplayed()) {
				click(eleTxtPolicyNumber);
				type(eleTxtPolicyNumber, data);
			}
		}
		catch(WebDriverException e)
		{
			System.out.println("Not Available");
		}
		return this;
	}
	//Transaction Serial 
	@FindBy(how=How.ID,using="txtTranSerial")
	public static WebElement eleTxtTransactionSerial;
	public ComLinesAutoSysPage enterTransactionSerial(String data)
	{

		click(eleTxtTransactionSerial);
		type(eleTxtTransactionSerial, data);
		return this;
	}
	//Execute
	@FindBy(how=How.LINK_TEXT,using="Execute")
	public static WebElement eleExecute;
	public ComLinesAutoSysPage clickExecute() throws InterruptedException {
		click(eleExecute);
		Thread.sleep(90000);
		//driver.close();
		return this;
	}
	//Special Notes -OK 
	@FindBy(how=How.LINK_TEXT,using="OK")
	public static WebElement eleOk;
	public AccountInfoTabPage clickOk() {
		driver.switchTo().frame("SIGI_DialogURL");
		click(eleOk);
		return new AccountInfoTabPage(driver);
	}

	//Endorse
	@FindBy(how=How.XPATH,using="(//a[text()='Endorse'])[2]")
	public static WebElement eleEndorse;
	public EndorsementPage clickEndorse() {
		try {
			if (eleEndorse.isDisplayed()) {
				click(eleEndorse);
			}
		} catch (WebDriverException e) {
			System.out.println("Not Available");
		}

		return new EndorsementPage(driver);
	}
	//More-->Issue
	@FindBy(how=How.LINK_TEXT,using="Issue")
	public static WebElement eleIssue;
	public ComLinesAutoSysPage selectIssue() {
		click(eleMore);
		click(eleIssue);
		click(elePolDet);
		return this;
	}
	//More-->Void Endorsement
	@FindBy(how=How.XPATH,using="//a[text()='Void Endorsement']")
	public static WebElement eleVoidEndorsement;
	public ComLinesAutoSysPage clickVoidEndorsement() {
		click(eleMore);
		click(eleVoidEndorsement);

		return this;
	}
	//OK
	@FindBy(how=How.XPATH,using="//span[@class='ui-button-text']")
	public static WebElement eleOK;
	public ComLinesAutoSysPage clickOK() {
		click(eleOK);
		return this;
	}
	//Click No
	@FindBy(how=How.ID,using="btnNo")
	public static WebElement eleNoBtn;
	public ComLinesAutoSysPage clickNoBtn()
	{
		try {
			if(eleNoBtn.isDisplayed()) {
				click(eleNoBtn);
			}
		}
		catch(WebDriverException e)
		{
			System.out.println("No Button is Not Available");
		}
		return new ComLinesAutoSysPage(driver);
	}
	//Go Button for Agent Login
	@FindBy(how=How.ID,using="cboType")
	public static WebElement eleBtnAgentGo;

	public EnterNamePage clickGoinAgent()
	{
		switchToWindow(1);
		driver.manage().window().maximize();
		click(eleBtnAgentGo);
		return new EnterNamePage(driver);
	}
	//Update Status
	@FindBy(how=How.LINK_TEXT,using="Update Status")
	public static WebElement eleUpdateStatus;
	public ComLinesAutoSysPage clickUpdateStatus() {
		click(eleUpdateStatus);
		return this;
	}
	//Select new Status DropDown 
	@FindBy(how=How.ID,using="ddlStatusList")
	public static WebElement eleSelectNewStatus;
	public ComLinesAutoSysPage selNewStatus(String data)
	{
		driver.switchTo().frame("SIGI_DialogURL");
		selectDropDownUsingText(eleSelectNewStatus, data);
		return new ComLinesAutoSysPage(driver);
	}

	//Status
	@FindBy(how=How.XPATH,using="((//tbody[@class='ListViewBody']/tr)[2]/td/select)[1]")
	public static WebElement eleStatus;
	public ComLinesAutoSysPage selStatus(String data)
	{
		selectDropDownUsingText(eleStatus, data);
		return new ComLinesAutoSysPage(driver);
	}
	//Return To Detail
	@FindBy(how=How.LINK_TEXT,using="Return To Detail")
	public static WebElement eleReturnToDetail;
	public ComLinesAutoSysPage clickReturnToDetail() {
		click(eleReturnToDetail);
		return this;
	}
	//Add Comments
	@FindBy(how=How.LINK_TEXT,using="Add Comments")
	public static WebElement eleAddComments;
	public ComLinesAutoSysPage clickAddComments() {
		click(eleAddComments);
		return this;
	}
	//Return To Dashboard 
	@FindBy(how=How.XPATH,using="(//div[@class='formButtons']/a)[1]")
	public static WebElement eleReturnToDashBoard;
	public ComLinesAutoSysPage clickReturnToDashBoard() throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		click(eleReturnToDashBoard);
		return this;
	}
	//Requote
	@FindBy(how=How.LINK_TEXT,using="Requote")
	public static WebElement eleRequote;
	public AccountInfoTabPage clickRequote() {

		click(eleRequote);
		return new AccountInfoTabPage(driver);
	}
	//Exit to dashboard-

	@FindBy(how=How.XPATH,using="//div[@class='formButtons']//a[@name='btnExitToDashboard']")
	public static WebElement elebtnExitToDashBoard;
	public ComLinesAutoSysPage clickBtnExitToDashBoard() throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		click(elebtnExitToDashBoard);
		return this;
	}
	@FindBy(how = How.ID, using = "btnFieldQuoteGo")
	public static WebElement eleBtnGo1;

	public ComLinesAutoSysPage clickGoButton() {
		click(eleBtnGo1);
		return this;
	}
	//Cancel Policy
	@FindBy(how=How.XPATH,using="//a[text()='Cancellation']")
	public static WebElement eleCancellation;
	public CacellationPage clickCancellation() {
		click(eleMore);
		click(eleCancellation);
		return new CacellationPage(driver);
	}
	//Cacel renewal Policy 

	@FindBy(how=How.XPATH,using="(//a[text()='More'])[2]")
	public static WebElement eleRenewalMore;
	public CacellationPage clickCancelOnRenewalPolicy()
	{
		click(eleRenewalMore);
		click(eleCancellation);
		return new CacellationPage(driver);
	}
	@FindBy(how=How.ID,using="ddlSearchType")
	public static WebElement eleSearchType;


	public CacellationPage selSearchType() {
		click(eleSearchType);
		selectDropDownUsingText(eleSearchType, "Policy");
		click(eleSearchBox);
		type(eleSearchBox, PolicyNum);
		click(eleSearch);
		return new CacellationPage(driver);
	}
	//Reinstate Policy
	@FindBy(how=How.LINK_TEXT,using="Reinstate")
	public static WebElement eleReinstate;
	public CacellationPage clickReinstate() {

		click(eleReinstate);
		return new CacellationPage(driver);
	}
	@FindBy(how = How.CLASS_NAME, using = "TextBox")
	public static WebElement eelSearch;

	public ComLinesAutoSysPage clicksearchBox() {
		click(eelSearch);
		return this;
	}		

	@FindBy(how = How.CSS, using = "#pageHeader ul li:nth-child(1) a")
	public static WebElement dashboardLink;

	public ComLinesAutoSysPage clickDashboardLink() {
		click(dashboardLink);
		return this;
	}

	// Page header- Notepad link

	@FindBy(how = How.CSS, using = "#pageHeader ul li:nth-child(4) a")
	public static WebElement notepadLink;

	public ComLinesAutoSysPage clickNotepadLink() {
		click(notepadLink);
		return this;
	}

	// WC documnetation tab
	@FindBy(how = How.CSS, using = "//div[@id='TabBar']//li[5]")
	public static WebElement WCDocumentationTab;

	public ComLinesAutoSysPage clickDocumentationTab() {
		click(WCDocumentationTab);
		return this;
	}
	//Close
	@FindBy(how=How.LINK_TEXT,using="Close")
	public static WebElement eleClose;
	public void clickClose() {
		try {
			if (eleResult.isDisplayed()) {
				click(eleClose);
			}
		} catch (WebDriverException e) {
			System.out.println("Not Displayed");
		}

	}
	//Result 
	@FindBy(how=How.ID,using="lblResult")
	public static WebElement eleResult;

}
