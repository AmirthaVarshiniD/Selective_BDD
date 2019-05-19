package com.api.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.api.cucumber.comMethods.ProjMethods;





public class LoginPage2 extends ProjMethods {

	public LoginPage2(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.CLASS_NAME,using="DropDownList")
	public static WebElement eleLogInAs;

	public LoginPage2 selectLogInAs(String login)
	{
		if (login.equals("Employee")) {
			selectDropDownUsingText(eleLogInAs, "Employee");
		} else if (login.equals("Agent")) {
			selectDropDownUsingText(eleLogInAs, "Agent");
		}
		return this;
	}

	@FindBy(how=How.ID,using="UserName")
	public static WebElement eleUserName;
	public LoginPage2 enterUserName(String data)
	{	
		type(eleUserName, data);
		return this;
	}

	@FindBy(how=How.ID,using="Password")
	public static WebElement elePassword;
	public LoginPage2 enterPassword(String data)
	{		
		type(elePassword, data);
		return this;
	}

	@FindBy(how=How.ID,using="btnLogin")
	public static WebElement eleBtnLogin;
	public QuickLinksPage clickLogin()
	{				
		click(eleBtnLogin);
		return new QuickLinksPage(driver);
	}

	@FindBy(how=How.XPATH,using="//div[@class='ButtonStyle1']/span")
	public static WebElement eleLoginButton;
	public ComLinesAutoSysPage clickLoginBtnInSLT()
	{				
		click(eleLoginButton);
		return new ComLinesAutoSysPage(driver);
	}
	@FindBy(how = How.ID, using = "cboNBType") 
	public static WebElement selectBusinessRCIS;

	public LoginPage2 clickBusinessDropdown() {
		click(selectBusinessRCIS);
		Select business = new Select(selectBusinessRCIS);
		business.selectByValue("NBIssue");
		return this;
	}

}





