package com.api.cucumber.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.api.cucumber.comMethods.ProjMethods;

public class FinalizePolicyPage extends ProjMethods {
	public FinalizePolicyPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.LINK_TEXT,using="Next")
	public static WebElement eleNext;
	public FinalizePolicyPage clickNext()
	{
		click(eleNext);
		return this;
	}

	//Under Rating Review - Question 1 - yes
	@FindBy(how=How.XPATH,using="(//input[@class='RadioButton'])[1]")
	public static WebElement eleYesQues1;
	public FinalizePolicyPage clickYesQues1()
	{
		try
		{
			if(eleYesQues1.isDisplayed())
			{
				click(eleYesQues1);
			}
		}catch(WebDriverException e)
		{
			System.out.println("Question 1 not available");
		}
		return this;
	}
	//Under Rating Review - Question 2 - yes
	@FindBy(how=How.XPATH,using="(//input[@class='RadioButton'])[3]")
	public static WebElement eleYesQues2;
	public FinalizePolicyPage clickYesQues2()
	{
		click(eleYesQues2);
		return this;
	}
	//Under Rating Review - Question 3 - yes
	@FindBy(how=How.XPATH,using="(//input[@class='RadioButton'])[5]")
	public static WebElement eleYesQues3;
	public FinalizePolicyPage clickYesQues3()
	{
		click(eleYesQues3);
		return this;
	}

	//Next To Eligibility results
	@FindBy(how=How.LINK_TEXT,using="Next to Eligibility Results")
	public static WebElement eleNextToEligibilityResults;
	public FinalizePolicyPage clickNextToEligibilityResults()
	{
		try {
			if(eleNextToEligibilityResults.isDisplayed())
			{
				click(eleNextToEligibilityResults);	
			}
		} catch (WebDriverException e) {
			System.out.println("Not Available");
		}
		
		return this;
	}

	//Producer Appointment
	@FindBy(how=How.LINK_TEXT,using="Next to Producer Appointment")
	public static WebElement eleNextToProducerAppointment;
	public FinalizePolicyPage clickNextToProducerAppointment()
	{
		click(eleNextToProducerAppointment);
		return this;
	}
	//Next to Billing
	@FindBy(how=How.LINK_TEXT,using="Next to Billing")
	public static WebElement eleNextToBilling;
	public FinalizePolicyPage clickNextToBilling()
	{
		click(eleNextToBilling);
		return this;
	}

	//Direct Bill - radio Button
	@FindBy(how=How.ID,using="rdoDirectBill_Label")
	public static WebElement eleDirectBill;
	public FinalizePolicyPage selectDirectBill()
	{
		click(eleDirectBill);
		return this;
	}

	//Payment Plan Drop down
	@FindBy(how=How.ID,using="ddlPayPlan")
	public static WebElement elePayPlan;
	public FinalizePolicyPage selectPayPlan(String data)
	{
		selectDropDownUsingText(elePayPlan, data);
		return this;
	}
	//Check Box- New Bill Account
	@FindBy(how=How.ID,using="chkNewBillAcct")
	public static WebElement eleNewBillAccount;
	public FinalizePolicyPage clickNewBillAccount()
	{
		click(eleNewBillAccount);
		return this;
	}

	//Next //Complete Form //Deposit Premium //Return to Forms List
	@FindBy(how=How.LINK_TEXT,using="Next")
	public static WebElement eleNextButton;
	@FindBy(how=How.LINK_TEXT,using="Complete Form")
	public static WebElement eleCompleteForm;
	@FindBy(how=How.XPATH,using="(//input[@class='TextBox'])[5]")
	public static WebElement eleDepositPremium;
	@FindBy(how=How.LINK_TEXT,using="Return to Forms List")
	public static WebElement eleReturnToFormList;
	public FinalizePolicyPage clickNextButton()
	{
		if(eleCompleteForm.isDisplayed())
		{
			click(eleCompleteForm);
			type(eleDepositPremium, "$5");
			click(eleReturnToFormList);
			click(eleNextButton);

		}
		else if(eleNextButton.isDisplayed())
		{
			click(eleNextButton);
		}

		return this;
	}
	//Next to Commission
	@FindBy(how=How.LINK_TEXT,using="Next to Commission")
	public static WebElement eleNextToCommission;
	public FinalizePolicyPage clickNextToCommission()
	{
		click(eleNextToCommission);
		return this;
	}

	//Click on Commission
		@FindBy(how=How.LINK_TEXT,using="Commission")
		public static WebElement eleCommission;
		public FinalizePolicyPage clickCommission()
		{
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Commission")));	
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Commission")));
			click(eleCommission);
			return this;
		}
//DSS
		@FindBy(how=How.LINK_TEXT,using="DSS")
		public static WebElement eleDss;
		public FinalizePolicyPage clickDss()
		{
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("DSS")));	
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("DSS")));
			click(eleDss);
			return this;
		}
	//Commision Value check
	@FindBy(how=How.XPATH,using="//label[@id='lblCfComm']/following-sibling::input")
	public static WebElement eleCommissioninfo;
	public FinalizePolicyPage checkCommisionInfo()
	{
		eleCommissioninfo.getText();
		reportStep("Commision Information: "+eleCommissioninfo.getText(), "PASS");
		return this;
	}
	//Next to Market Size Info
	@FindBy(how=How.LINK_TEXT,using="Next to Market Size Info")
	public static WebElement eleNextToMarketSizeInfo;
	public FinalizePolicyPage clickNextToMarketSizeInfo()
	{
		click(eleNextToMarketSizeInfo);
		return this;
	}
	//Next to Special Claims Handling Instr.
	@FindBy(how=How.LINK_TEXT,using="Next to Special Claims Handling Instr.")
	public static WebElement eleNextToSpecialClaims;
	public FinalizePolicyPage clickNextToSpecialClaims()
	{
		click(eleNextToSpecialClaims);
		return this;
	}
	//Next to DSS
	@FindBy(how=How.LINK_TEXT,using="Next to DSS")
	public static WebElement eleNextToDSS;
	public FinalizePolicyPage clickNextToDSS()
	{
		try {
			if (eleNextToDSS.isDisplayed()) {			
				click(eleNextToDSS);
			}
		} catch (WebDriverException e) {
		System.out.println("DSS not displayed");
		}
		return this;
	}
	//Dashboard
			@FindBy(how=How.LINK_TEXT,using="Dashboard")
			public static WebElement eleDashBoard;
			public FinalizePolicyPage clickDashBoard()
			{
				click(eleDashBoard);
				return this;
			}
			//Next to DSS
			@FindBy(how=How.LINK_TEXT,using="Next to Social Services Employee Info")
			public static WebElement eleNextToSocialServicesEmployeeInfo;
			public FinalizePolicyPage clickNextToSocialServicesEmployeeInfo()
			{
				if(eleNextToSocialServicesEmployeeInfo.isDisplayed())
				{
					click(eleNextToSocialServicesEmployeeInfo);
				}
				else
					System.out.println(" Not displayed");
				return this;
			}
	//Print Auto ID cards
		//Print/Return to Finalize
		@FindBy(how=How.LINK_TEXT,using="Print Auto ID cards")
		public static WebElement elePrintAutoIDCards;
		@FindBy(how=How.LINK_TEXT,using="Print/Return to Finalize")
		public static WebElement elePrintReturnToFinalize;
		public FinalizePolicyPage clickPrintAutoIDCards()
		{
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Print Auto ID cards")));	
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Print Auto ID cards")));
			
			if(elePrintAutoIDCards.isDisplayed())
			{
				click(elePrintAutoIDCards);
				click(elePrintReturnToFinalize);
			}
			else
				System.out.println(" Not displayed");
			return this;
		}
	
	//Complete Form //a[text()='Complete Form']
		
		@FindBy(how=How.XPATH,using="(//input[@class='TextBox'])[1]")
		public static WebElement eleLimitOfInsurance;
		public FinalizePolicyPage enterFalsePretenseFormDetails()
		{
			try
			{
			if(eleCompleteForm.isDisplayed())
			{
				click(eleCompleteForm);
				click(eleLimitOfInsurance);
				type(eleLimitOfInsurance, "$100");
				click(eleReturnToFormList);
			}
			}
			catch(WebDriverException e)
			{
				System.out.println(" Not displayed");
			}
			return this;
		}
		
	
	//# of Paid employees
	@FindBy(how=How.ID,using="txtEmployees")
	public static WebElement elePaidEmployees;
	public FinalizePolicyPage enterTxtPaidEmployees(String data)
	{
		click(elePaidEmployees);
		type(elePaidEmployees, data);
		return this;
	}
	//# Volunteers
	@FindBy(how=How.ID,using="txtVols")
	public static WebElement eleVolunteers;
	public FinalizePolicyPage enterTxtVolunteers(String data)
	{
		click(eleVolunteers);
		type(eleVolunteers, data);
		return this;
	}
	//Next to Forms
	@FindBy(how=How.LINK_TEXT,using="Next to Forms")
	public static WebElement eleNextToForms;
	public FinalizePolicyPage clickNextToForms()
	{
		try {
			if (eleNextToForms.isDisplayed()) {
				click(eleNextToForms);
			}
		} catch (WebDriverException e) {
			System.out.println("Forms Not Available");
		}
		
		return this;
	}
	//Documentation
	@FindBy(how=How.LINK_TEXT,using="Next to Documentation")
	public static WebElement eleNextToDocumentation;
	public FinalizePolicyPage clickNextToDocumentation()
	{
		click(eleNextToDocumentation);
		return this;
	}
	//Click review/Issue
	@FindBy(how=How.LINK_TEXT,using="Review / Issue")
	public static WebElement eleReviewIssue;
	public FinalizePolicyPage clickReviewIssue()
	{
		try {
			if (eleReviewIssue.isDisplayed()) {
				click(eleReviewIssue);
			}
		} catch (WebDriverException e) {
			System.out.println("Not Available");
		}
		
		return this;
	}
	//No Button 
	@FindBy(how=How.ID,using="rdoIssueScNo")
	public static WebElement eleNoinAgencyCode;
	public FinalizePolicyPage clickNoinAgencyCode()
	{
		try {
			if (eleNoinAgencyCode.isDisplayed()) {
				click(eleNoinAgencyCode);
			}
		} catch (Exception e) {
			System.out.println("Not Available");
		}
		
		return this;
	}
	//Click on Issue
	@FindBy(how=How.LINK_TEXT,using="Issue")
	public static WebElement eleIssue;
	public ComLinesAutoSysPage clickIssue()
	{
		click(eleIssue);
		return new ComLinesAutoSysPage(driver);
	}
	//Click No
	@FindBy(how=How.LINK_TEXT,using="No")
	public static WebElement eleNo;
	public ComLinesAutoSysPage clickNo()
	{
		click(eleNo);
		return new ComLinesAutoSysPage(driver);
	}

	//Notepad
	@FindBy(how=How.LINK_TEXT,using="Notepad")
	public static WebElement eleNotePad;
	public FinalizePolicyPage clickNotePad()
	{
		click(eleNotePad);
		return this;
	}
	//Safety Management Analysis 
	@FindBy(how=How.ID,using="chkcovLossCA1")
	public static WebElement eleChkBxSafetyMangAnalysis;
	public FinalizePolicyPage clickChkBxSafetyMangAnalysis()
	{
		click(eleChkBxSafetyMangAnalysis);
		return this;
	}
	//Survey Contact
	@FindBy(how=How.XPATH,using="(//table[@class='InputTable']/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/input)[1]")
	public static WebElement eleSurveyContact;
	public FinalizePolicyPage enterSurveyContact(String data)
	{
		System.out.println("No OF Frames ------- "+driver.findElementsByXPath("//iframe").size());

		driver.switchTo().frame("iframe1");
		type(eleSurveyContact, data);
		return this;
	}
	//Safety Management not Needed 
	@FindBy(how=How.XPATH,using="//input[@id='chkUwLcNeed']")
	public static WebElement eleChkBxSafetyMangNotNeeded;
	public FinalizePolicyPage clickChkBxSafetyMangNotNeeded()
	{
		click(eleChkBxSafetyMangNotNeeded);
		return this;
	};
	//Reason 
	@FindBy(how=How.ID,using="cboSftyMgmtNotNeeded")
	public static WebElement eleReason;
	public FinalizePolicyPage selReason(String data)
	{
		selectDropDownUsingText(eleReason, data);
		//selectDropDownUsingIndex(eleReason, 1);
		return this;
	} 
	//
	@FindBy(how=How.ID,using="txtUwLcDateText")
	public static WebElement eleTxtDate;
	public FinalizePolicyPage enterTxtDate(String data)
	{
		type(eleTxtDate, data);
		return this;
	} 

	//Is Account on Safety Management service - No Radio Button 
	@FindBy(how=How.ID,using="rdoLCServiceNo")
	public static WebElement eleNoSafetyMangService;
	public FinalizePolicyPage clickNoSafetyMangService()
	{
		click(eleNoSafetyMangService);
		return this;
	} 
	//Order Safety Management 
	@FindBy(how=How.XPATH,using="//input[@id='btnordsaf']")
	public static WebElement eleOrderSafetyMang;
	public FinalizePolicyPage clickOrderSafetyMang() throws AWTException
	{
		click(eleOrderSafetyMang);
		Robot enter = new Robot();
		enter.keyPress(KeyEvent.VK_ENTER);
		return this;
	}
	//Safety Management Contact
	@FindBy(how=How.ID,using="txtLcContactName")
	public static WebElement eleSafetyMangContact;
	public FinalizePolicyPage enterSafetyMangContact(String data)
	{
		type(eleSafetyMangContact, data);
		return this;
	} 
	//Producer Name 
	@FindBy(how=How.ID,using="txtLcProducerName")
	public static WebElement eleProducerName;
	public FinalizePolicyPage enterProducerName(String data)
	{
		type(eleProducerName, data);
		return this;
	} 
	//Order Survey 
	@FindBy(how=How.ID,using="btnOrderSurvey")
	public static WebElement eleOrderSurvey;
	public FinalizePolicyPage clickOrderSurvey() throws AWTException
	{
		click(eleOrderSurvey);
		Robot enter = new Robot();
		enter.keyPress(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
		return this;
	}

	@FindBy(how=How.XPATH,using="(//input[@class='CheckBox'])[1]")
	public static WebElement eleLOcChkBox1;
	@FindBy(how=How.XPATH,using="(//input[@class='CheckBox'])[2]")
	public static WebElement eleLOcChkBox2;
	@FindBys(@FindBy(how=How.CLASS_NAME,using="CheckBox"))
	List<WebElement> eleLocChkBox;
	public FinalizePolicyPage clickLoc()
	{
		for (WebElement ele : eleLocChkBox) 
			if(!ele.isSelected())
			{
				ele.click();
			}

		return this;
	}
	//Return To LOB/Common
	@FindBy(how=How.LINK_TEXT,using="Return to LOB/Common")
	public static WebElement eleReturnToLob;
	public FinalizePolicyPage clickReturnToLob()
	{
		try {
			if (eleReturnToLob.isDisplayed()) {				
				
				click(eleReturnToLob);
				
			}
		} catch (WebDriverException e) {
			System.out.println("Not Available");
		}
		return this;
	}
	//
	@FindBy(how=How.LINK_TEXT,using="Forms")
	public static WebElement eleForms;
	public FinalizePolicyPage clickForms()
	{
		click(eleForms);
		return this;
	}
	//Documentation
	@FindBy(how=How.LINK_TEXT,using="Documentation")
	public static WebElement eleDocumentation;
	public NotePad clickDocumentation()
	{
		click(eleDocumentation);
		return new NotePad(driver);
	}
	//Change Narrative
	@FindBy(how=How.LINK_TEXT,using="Change Narrative")
	public static WebElement eleChangeNarrative;
	public FinalizePolicyPage clickChangeNarrative()
	{
		click(eleChangeNarrative);
		return this;
	}
	//Return to Forms Processing
	@FindBy(how=How.LINK_TEXT,using="Return to Forms Processing")
	public static WebElement eleReturnFormsProcessing;
	public FinalizePolicyPage clickReturnFormsProcessing()
	{
		click(eleReturnFormsProcessing);
		return this;
	}
	
}
