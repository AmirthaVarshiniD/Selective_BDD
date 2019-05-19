package com.api.cucumber.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
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



public class PremiumSummaryPage extends ProjMethods {
	public PremiumSummaryPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//Exit DashBoard
	@FindBy(how=How.XPATH,using="//a[@id='btnExitToDashboard']/span/strong")
	public static WebElement eleBtnExitDashBoard;
	public ComLinesAutoSysPage clickExiTToDashBoard()
	{
		try {
			if (eleBtnExitDashBoard.isDisplayed()) {
				click(eleBtnExitDashBoard);		
			}

		} catch (WebDriverException e) {
			System.out.println("Not available");
		}

		return new ComLinesAutoSysPage(driver);
	}
	//Next To Finalize Policy
	@FindBy(how=How.LINK_TEXT,using="Next to Finalize Policy")
	public static WebElement eleNextToFinalizePolicy;
	public FinalizePolicyPage clickNextToFinalizePolicy()
	{
		click(eleNextToFinalizePolicy);
		return new FinalizePolicyPage(driver);
	}



	@FindBy(how=How.ID,using="lnkRatingWorksheet")
	public static WebElement eleRatingWorkSheet;
	@FindBy(how=How.LINK_TEXT,using="Worksheets")
	public static WebElement eleBtnWorksheet;
	@FindBy(how=How.XPATH,using="//a[@id='btnPrint']/span/strong")
	public static WebElement eleBtnPrint;
	@FindBy(how=How.ID,using="TextAreaWorksheetOutput")
	public static WebElement eleWorkSheetText;
	@FindBy(how=How.LINK_TEXT,using="Close")
	public static WebElement eleBtnClose;
	public PremiumSummaryPage clickRatingWorkSheet(String data)
	{
		click(eleRatingWorkSheet);
		switchToWindow(2);
		driver.manage().window().maximize();
		click(eleBtnWorksheet);
		verifyPartialText(eleWorkSheetText,data);
		//		verifyPartialTextNotAvailable(eleWorkSheetText,data);
		click(eleBtnPrint);
		/*try {
			Runtime.getRuntime().exec(".\\accordsave.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(eleBtnClose);*/
		return this;
	}
	public PremiumSummaryPage checkRatingWorkSheet()
	{
		click(eleRatingWorkSheet);
		switchToWindow(2);
		//driver.manage().window().maximize();
		click(eleBtnWorksheet);
		//	verifyPartialTextNotAvailable(eleWorkSheetText,data);
		click(eleBtnPrint);
		try {
			Runtime.getRuntime().exec("C:\\Users\\duraia1\\Desktop\\cucumber_Merge\\accordsave.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		switchToWindow(1);

		return this;
	}
	//Quote Proposal
	@FindBy(how=How.LINK_TEXT,using="Quote Proposal")
	public static WebElement eleQuoteProposal;
	public PremiumSummaryPage clickQuoteProposal()
	{
		switchToWindow(1);
		click(eleQuoteProposal);
		return this;
	}
	//Create Quote Proposal 
	@FindBy(how=How.LINK_TEXT,using="Create Quote Proposal")
	public static WebElement eleCreateQuoteProposal;
	public PremiumSummaryPage clickCreateQuoteProposal()
	{
		click(eleCreateQuoteProposal);
		return this;
	}
	public PremiumSummaryPage verifyQuoteProposal()
	{
		switchToWindow(2);
		try {
			Runtime.getRuntime().exec("C:\\Users\\duraia1\\Desktop\\Cucumber\\cucumber-master\\quoteproposalsave.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//click(eleBack);
		//switchToWindow(1);
		//click(eleFinalizePolicy);
		//click(elePremmiumSum);
		return this;
	}
	//Pricing
	@FindBy(how=How.LINK_TEXT,using="Pricing")
	public static WebElement elePricing;
	public PremiumSummaryPage clickPricing()
	{
		click(elePricing);
		return this;
	}
	//Experience Rating
	@FindBy(how=How.LINK_TEXT,using="Experience Rating")
	public static WebElement eleExperienceRating;
	public PremiumSummaryPage clickExperienceRating()
	{
		click(eleExperienceRating);
		return this;
	}
	//Auto Liability
	@FindBy(how=How.LINK_TEXT,using="Auto Liability")
	public static WebElement eleAutoLiability;
	public PremiumSummaryPage clickAutoLiability()
	{
		click(eleAutoLiability);
		return this;
	}
	//Number Of Years 
	@FindBy(how=How.ID,using="rdoYearsone")
	public static WebElement eleNoOfYearsOne;
	public PremiumSummaryPage clickYearsOne()
	{
		click(eleNoOfYearsOne);
		return this;
	}
	//Calculate MSL
	@FindBy(how=How.LINK_TEXT,using="Calculate MSL")
	public static WebElement eleCalculateMSL;
	public PremiumSummaryPage clickCalculateMSL()
	{
		try {
			if (eleCalculateMSL.isDisplayed()) {
				click(eleCalculateMSL);	
			}

		} catch (WebDriverException e) {
			System.out.println("Not Available");
		}

		return this;
	}
	//Get Claims
	@FindBy(how=How.LINK_TEXT,using="Get Claims")
	public static WebElement eleGetClaims;
	public PremiumSummaryPage clickGetClaims()
	{

		try {
			if (eleGetClaims.isDisplayed()) {
				click(eleGetClaims);	
			}

		} catch (WebDriverException e) {
			System.out.println("Not Available");
		}

		return this;
	}
	//Claims Year one no 
	@FindBy(how=How.ID,using="rdoclmsYNYear1No")
	public static WebElement eleClaimsYearsOneNo;
	public PremiumSummaryPage clickYearsOneNo()
	{
		click(eleClaimsYearsOneNo);
		return this;
	}
	//Experience Rate
	@FindBy(how=How.LINK_TEXT,using="Experience Rate")
	public static WebElement eleExperienceRate;
	public PremiumSummaryPage clickExperienceRate()
	{
		click(eleExperienceRate);
		return this;
	}
	//Return To Pricing
	@FindBy(how=How.LINK_TEXT,using="Return To Pricing")
	public static WebElement eleReturnToPricing;
	public PremiumSummaryPage clickReturnToPricing()
	{
		click(eleReturnToPricing);
		return this;
	}
	//Check IRPM field is enabled in Pricing screen 
	@FindBy(how=How.XPATH,using="(//input[@class='TextBox'])[1]")
	public static WebElement eleIrpm;
	public PremiumSummaryPage checkIrpmEnabled(String data)
	{
		//driver.switchTo().frame("SIGI_DialogURL");
		eleIrpm.click();
		type(eleIrpm, data);
		return this;
	}
	public PremiumSummaryPage checkIrpmNotEnable()
	{
		//driver.switchTo().frame("SIGI_DialogURL");
		verifyNotEnabled(eleIrpm);
		return this;
	}

	public PremiumSummaryPage cleraIrpm() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleIrpm);
		//driver.switchTo().frame("SIGI_DialogURL");
		Thread.sleep(2000);
		eleIrpm.clear();
		return this;
	}
	//Error Form Error: 
	@FindBy(how=How.LINK_TEXT,using="Form Error:")
	public static WebElement eleError;
	public PremiumSummaryPage checkError()
	{
		getText(eleError);
		return this;
	}
	//Check IRPM field is enabled in Pricing screen 
	public PremiumSummaryPage checkIrpmNotEnabled()
	{
		verifyNotEnabled(eleIrpm);
		return this;
	}
	//Click back
	@FindBy(how=How.LINK_TEXT,using="Back")
	public static WebElement eleBack;
	public PremiumSummaryPage clickBack()
	{
		click(eleBack);
		return this;
	}
	//Verify Premmium Summary Value 
	@FindBy(how=How.XPATH,using="//h1[@id='h1StPAnprem']")
	public static WebElement elePremmiumSummaryValue;
	public PremiumSummaryPage verifyPremmiumSummary(String data)
	{
		verifyPartialText(elePremmiumSummaryValue, data);
		return new PremiumSummaryPage(driver);
	}
	public PremiumSummaryPage getPremmiumSummary()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@id='h1StPAnprem']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='h1StPAnprem']")));
		getText(elePremmiumSummaryValue);
		return new PremiumSummaryPage(driver);
	}
	//Click on Locations 
	@FindBy(how=How.LINK_TEXT,using="LOCATIONS (1)")
	public static WebElement eleLocations;
	public LocationsPage clickLocations()
	{
		click(eleLocations);
		return new LocationsPage(driver);
	}
	//Click on Inland Marine 
	@FindBy(how=How.LINK_TEXT,using="Inland Marine")
	public static WebElement eleInlandMarine;
	public InlandMarinePages clickInlandMarine()
	{
		click(eleInlandMarine);
		return new InlandMarinePages(driver);
	}
	//close Button
	@FindBy(how=How.LINK_TEXT,using="Close")
	public static WebElement eleClose;
	public PremiumSummaryPage clickClose()
	{
		click(eleClose);
		return this;
	}
	//Rate Button
	@FindBy(how=How.LINK_TEXT,using="Rate")
	public static WebElement eleRate;
	public PremiumSummaryPage clickRate()
	{
		click(eleRate);
		return this;
	}
	//Finalize Policy
	@FindBy(how=How.XPATH,using="//span[text()='Premium Summary']")
	public static WebElement elePremmiumSum;
	public FinalizePolicyPage clickPremiumSummary()
	{
		click(elePremmiumSum);
		return new FinalizePolicyPage(driver);
	}
	//Continue Rating
	@FindBy(how=How.LINK_TEXT,using="Continue with Rating")
	public static WebElement eleBtnContinueRate;
	public PremiumSummaryPage clickBtnContinuerating()
	{
		try
		{
			if(eleBtnContinueRate.isDisplayed())
			{
				click(eleBtnContinueRate);
				getPremmiumSummary();
			}
		}
		catch (WebDriverException e) {
			System.out.println("Not Available");
		}
		finally
		{
			getPremmiumSummary();
		}
		return new PremiumSummaryPage(driver);
	}
	//CAT Management  
	@FindBy(how=How.CLASS_NAME,using="ui-button-text")
	public static WebElement eleRadioBtnYesInCATManagemen;
	@FindBy(how=How.LINK_TEXT,using="CAT Management")
	public static WebElement eleCATManagement;
	@FindBy(how=How.LINK_TEXT,using="Detailed Review")
	public static WebElement eleDetailedReview;
	@FindBy(how=How.ID,using="btnAddText")
	public static WebElement eleAddText;
	@FindBy(how=How.CLASS_NAME,using="MultLineTextBox")
	public static WebElement eleComments;
	@FindBy(how=How.ID,using="btnOK")
	public static WebElement eleBtnOK;
	@FindBy(how=How.LINK_TEXT,using="Return to CAT Summary")
	public static WebElement eleReturnToCATSummary;

	public PremiumSummaryPage clickCATManagement()
	{
		try
		{
			if(eleRadioBtnYesInCATManagemen.isDisplayed())
			{
				click(eleRadioBtnYesInCATManagemen);
				driver.switchTo().frame("SIGI_DialogURL");
				click(eleDetailedReview);
				click(eleAddText);
				type(eleComments, "test");
				click(eleBtnOK);
				click(eleReturnToCATSummary);
				click(eleClose);
				driver.switchTo().defaultContent();

			}
		}
		catch (WebDriverException e) {
			System.out.println("Not Available");
		}

		return this;
	}
	//Premmium Summary
	@FindBy(how=How.ID,using="navForward")
	public static WebElement eleFinalizePolicy;
	public FinalizePolicyPage clickFinalizePolicy()
	{
		click(eleFinalizePolicy);
		return new FinalizePolicyPage(driver);
	}
	@FindBy(how = How.ID, using = "h1StPAnprem")
	public static WebElement premiumValue;

	public PremiumSummaryPage verifyPremiumValue() {
		String premium[] = premiumValue.getText().split("\\$");
		Assert.assertTrue(!premium[1].equals("0"));
		return this;
	}



	@FindBy(how = How.XPATH, using = "//ul[@id='mainTabBar']//li[2]//div//a")
	public static WebElement elepolicyTab;
	@FindBy(how = How.ID, using = "EditPolicyType")
	public static WebElement elePolicyEdit;


	public PremiumSummaryPage clickPolicyTab() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", elepolicyTab);
		Thread.sleep(3000);
		JavascriptExecutor PE = (JavascriptExecutor) driver;
		PE.executeScript("arguments[0].click();", elePolicyEdit);
		return this;
	}

	/*public void testVerifyPDFInURL() {
			driver.get("http://www.princexml.com/samples/");
			driver.findElement(By.linkText("PDF flyer")).click();
			String getURL = driver.getCurrentUrl();
			Assert.assertTrue(getURL.contains(".pdf"));
		}


		public boolean verifyPDFContent(String strURL, String reqTextInPDF) {

			boolean flag = false;

			PDFTextStripper pdfStripper = null;
			PDDocument pdDoc = null;
			COSDocument cosDoc = null;
			String parsedText = null;

			try {
				URL url = new URL(strURL);
				BufferedInputStream file = new BufferedInputStream(url.openStream());
				PDFParser parser = new PDFParser(file);

				parser.parse();
				cosDoc = parser.getDocument();
				pdfStripper = new PDFTextStripper();
				pdfStripper.setStartPage(1);
				pdfStripper.setEndPage(1);

				pdDoc = new PDDocument(cosDoc);
				parsedText = pdfStripper.getText(pdDoc);
			} catch (MalformedURLException e2) {
				System.err.println("URL string could not be parsed "+e2.getMessage());
			} catch (IOException e) {
				System.err.println("Unable to open PDF Parser. " + e.getMessage());
				try {
					if (cosDoc != null)
						cosDoc.close();
					if (pdDoc != null)
						pdDoc.close();
				} catch (Exception e1) {
					e.printStackTrace();
				}
			}

			System.out.println("+++++++++++++++++");
			System.out.println(parsedText);
			System.out.println("+++++++++++++++++");

			if(parsedText.contains(reqTextInPDF)) {
				flag=true;
			}

			return flag;
		}

		@AfterClass
		public void tearDown() {
			driver.quit();
		}
	}*/

}
