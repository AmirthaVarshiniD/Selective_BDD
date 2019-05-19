package com.api.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.api.cucumber.comMethods.ProjMethods;


public class EndorsementPage extends ProjMethods{
	public EndorsementPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//Effective Date
	@FindBy(how=How.ID,using="txtEffDate_Text")
	public static WebElement eleEffcDate;
	public EndorsementPage enterEffcDate(String data) 
	{
		click(eleEffcDate);
		type(eleEffcDate, data);
		return this;
	}
	//Transaction description 
	@FindBy(how=How.ID,using="txtTransDesc")
	public static WebElement eleTransDesc;
	public EndorsementPage enterTransDesc(String data) 
	{
		type(eleTransDesc, data);
		return this;
	}
	//Received Date
	@FindBy(how=How.ID,using="txtRcvDate_Text")
	public static WebElement eleReceivedDate;
	public EndorsementPage enterReceivedDate(String data)
	{
		type(eleReceivedDate, data);
		return this;
	}
	//Next
	@FindBy(how=How.LINK_TEXT,using="Next")
	public static WebElement eleNext;
	public AccountInfoTabPage clickNext()
	{
		click(eleNext);
		return new AccountInfoTabPage(driver);
	}


}
