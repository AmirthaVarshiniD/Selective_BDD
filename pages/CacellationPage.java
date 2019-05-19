package com.api.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.api.cucumber.comMethods.ProjMethods;

public class CacellationPage extends ProjMethods {

	public CacellationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//OK Button 
	@FindBy(how=How.XPATH,using="(//span[@class='ui-button-text'])[1]")
	public static WebElement eleButtonOk;
	public CacellationPage clickButtonOk(){
		try {
			if (eleButtonOk.isDisplayed()) {
				click(eleButtonOk);
			}
		} catch (WebDriverException e) {
			System.out.println("OK Button Not Displayed");
		}
		
		return new CacellationPage(driver);
	}
	//Effective Date
	@FindBy(how=How.ID,using="txtEffDate_Text")
	public static WebElement eleEffcDate;
	public CacellationPage enterEffectiveDate(String data) 
	{
		click(eleEffcDate);
		type(eleEffcDate, data);
		return this;
	}
	//How to Cancel
	@FindBy(how=How.ID,using="cboHowCancel")
	public static WebElement eleDdlHowTocancel;
	public CacellationPage selectDdlHowToCancel(String data) 
	{
		click(eleDdlHowTocancel);
		selectDropDownUsingText(eleDdlHowTocancel, data);
		return this;
	}
	//
	@FindBy(how=How.ID,using="cboReason")
	public static WebElement eleDdlReason;
	public CacellationPage selectDdlReason(String data) 
	{
		click(eleDdlReason);
		selectDropDownUsingText(eleDdlReason, data);
		return this;
	}			

	//Received Date
	@FindBy(how=How.ID,using="txtRcvDate_Text")
	public static WebElement eleReceivedDate;
	public CacellationPage enterReceivedDate(String data) 
	{
		click(eleReceivedDate);
		type(eleReceivedDate, data);
		return this;
	}
	//Click Rate BUtton
	@FindBy(how=How.LINK_TEXT,using="Rate")
	public static WebElement eleBtnRate;
	public PremiumSummaryPage clickRate()
	{
		click(eleBtnRate);
		return new PremiumSummaryPage(driver);
	}

}
