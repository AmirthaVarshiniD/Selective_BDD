package com.api.cucumber.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.api.cucumber.comMethods.ProjMethods;


public class EnterNamePage extends ProjMethods{
	public EnterNamePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);

	@FindBy(how=How.ID,using="SIGI_DialogURL")
	public static WebElement eleSwitchToFrame;
	@FindBy(how=How.ID,using="AccountName")
	public static WebElement eleAccountName;
	public EnterNamePage enterAccName(String data) throws IOException
	{
		switchToFrame(eleSwitchToFrame);
		type(eleAccountName, data);
		writeXLSXFile();
		return this;
	}
	@FindBy(how=How.ID,using="btnSubmit")
	public static WebElement eleBtnNext;
	public EnterNamePage clickNext() throws InterruptedException
	{
		click(eleBtnNext);
		return this;
	}
	@FindBy(how=How.XPATH,using="/html/body/div[2]/div[2]/div/button[2]")
	public static WebElement eleBtnYesOrNo;
	public AccountInfoTabPage clickYesOrNo()
	{
		try
		{
			if(eleBtnYesOrNo.isDisplayed())
			{			
				click(eleBtnYesOrNo);
			}
		}catch (WebDriverException e) {
			System.out.println("No Button is not displayed");
		}
		finally {
			System.out.println("Navigate to Account Info page");
		}
		return new AccountInfoTabPage(driver);
	}

}
