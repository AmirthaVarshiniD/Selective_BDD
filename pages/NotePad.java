package com.api.cucumber.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.api.cucumber.comMethods.ProjMethods;


public class NotePad extends ProjMethods {
	public NotePad(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//Notepad
	@FindBy(how=How.LINK_TEXT,using="Notepad")
	public static WebElement eleNotePad;
	public NotePad clickNotePad()
	{
		click(eleNotePad);
		return this;
	}
	//Credit / Debit
	@FindBy(how=How.LINK_TEXT,using="Credit / Debit")
	public static WebElement eleCreditDebit;
	public NotePad clickCreditDebit()
	{
		click(eleCreditDebit);
		return this;
	}
	//Add
	@FindBy(how=How.ID,using="btnAdd")
	public static WebElement eleBttnAdd;
	public NotePad clickAdd()
	{
		click(eleBttnAdd);
		return this;
	}
	//LOB 
	@FindBy(how=How.ID,using="ddlLob")
	public static WebElement eleDdlLob;
	public NotePad selDdlLob(String data)
	{
		click(eleDdlLob);
		selectDropDownUsingText(eleDdlLob, data);
		return this;
	}
	//Propert IRPM 
	@FindBy(how=How.XPATH,using="//tr[@id='lvSelections_Property IRPM']")
	public static WebElement elePropertyIrpm;
	public NotePad clickPropertyIrpm()
	{
		click(elePropertyIrpm);
		click(elePropertyIrpm);
		return this;
	}
	//GL IRPM 
	@FindBy(how=How.XPATH,using="(//div[@id='lvSelections']/table/tbody/tr/td)[14]")
	public static WebElement eleGlIrpmSelection;
	public NotePad clickGlIrpmSelection()
	{
		click(eleGlIrpmSelection);
		return this;
	}
	//GL Schedule Mod 
	@FindBy(how=How.XPATH,using="(//div[@id='lvSelections']/table/tbody/tr/td)[15]")
	public static WebElement eleGlScheduleModSelection;
	public NotePad clickGlScheduleModSelection()
	{
		click(eleGlScheduleModSelection);
		return this;
	}
	//GL Schedule Mod
	@FindBy(how=How.LINK_TEXT,using="GL Schedule Mod")
	public static WebElement eleGlScheduleMod;
	public NotePad clickGlScheduleMod()
	{
		click(eleGlScheduleMod);
		return this;
	}
	//Return to Credit / Debit Summary
	@FindBy(how=How.LINK_TEXT,using="Return to Credit / Debit Summary")
	public static WebElement eleReturnToCreditDebitSummary;
	public NotePad clickReturnToCreditDebitSummary()
	{
		click(eleReturnToCreditDebitSummary);
		eleReturnToCreditDebitSummary.sendKeys(Keys.ENTER);
		return this;
	}
	//Return To LOB/Common
		@FindBy(how=How.LINK_TEXT,using="Return to LOB/Common")
		public static WebElement eleReturnToLob;
		public NotePad clickReturnToLob()
		{
			//driver.switchTo().defaultContent();
			click(eleReturnToLob);
			return new NotePad(driver);
		}
	//OK
	@FindBy(how=How.ID,using="OK")
	public static WebElement eleOK;
	public NotePad clickOK()
	{
		driver.switchTo().frame("SIGI_DialogURL");
		click(eleOK);
		driver.switchTo().defaultContent();
		return this;
	}
	//Location 
	@FindBy(how=How.ID,using="txtCreditDebit1")
	public static WebElement eleCreditLocation;
	public NotePad enterCreditLocation(String data)
	{
		//click(eleCreditLocation);
		type(eleCreditLocation, data);
		return this;
	}
	//Exposure Outside Premises 
	@FindBy(how=How.ID,using="txtCreditDebit2")
	public static WebElement eleCreditExposureOutsidePremises;
	public NotePad enterCreditExposureOutsidePremises(String data)
	{
		//click(eleCreditExposureOutsidePremises);
		type(eleCreditExposureOutsidePremises, data);
		
		return this;
	}
	//Premises 
	@FindBy(how=How.ID,using="txtCreditDebit3")
	public static WebElement eleCreditPremises;
	public NotePad enterCreditPremises(String data)
	{
		//click(eleCreditPremises);
		type(eleCreditPremises, data);
		return this;
	}
	//Equipment 
	@FindBy(how=How.ID,using="txtCreditDebit4")
	public static WebElement eleCreditEquipment;
	public NotePad enterCreditEquipment(String data)
	{
		//click(eleCreditEquipment);
		type(eleCreditEquipment, data);
		return this;
	}
	//Classification Pecularities 
	@FindBy(how=How.ID,using="txtCreditDebit5")
	public static WebElement eleClassificationPecularities;
	public NotePad enterClassificationPecularities(String data)
	{
		//click(eleClassificationPecularities);
		type(eleClassificationPecularities, data);
		return this;
	}
	//Employees 
	@FindBy(how=How.ID,using="txtCreditDebit6")
	public static WebElement eleEmployees;
	public NotePad enterEmployees(String data)
	{
		//click(eleEmployees);
		type(eleEmployees, data);
		return this;
	}
	//Cooperation 
	@FindBy(how=How.ID,using="txtCreditDebit7")
	public static WebElement eleCooperation;
	public NotePad enterCooperation(String data)
	{
		//click(eleCooperation);
		type(eleCooperation, data);
		return this;
	}
	//Safety Program 
		@FindBy(how=How.ID,using="txtCreditDebit8")
		public static WebElement eleSafetyProgram;
		public NotePad enterSafetyProgram(String data)
		{
			//click(eleSafetyProgram);
			type(eleSafetyProgram, data);
			return this;
		}
	//Next
	@FindBy(how=How.LINK_TEXT,using="Next")
	public static WebElement eleNext;
	public NotePad clickNext()
	{
		click(eleNext);
		return this;
	}
	//Error message 
	@FindBy(how=How.ID,using="Page")
	public static WebElement eleErrorMessage;
	public NotePad checkErrorMessage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Page")));	
		getText(eleErrorMessage);
		eleErrorMessage.sendKeys(Keys.ESCAPE);
		return this;
	}
	//Cancel
	@FindBy(how=How.LINK_TEXT,using="Cancel")
	public static WebElement eleCancel;
	public NotePad clickCancel()
	{
		click(eleCancel);
		return this;
	}
}
