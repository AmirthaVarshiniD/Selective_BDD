package com.api.cucumber.testcases.MiniLines;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.api.cucumber.comMethods.CommonMethods;
import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.ComLinesAutoSysPage;
import com.api.cucumber.pages.DashboardPage;
import com.api.cucumber.pages.EnterNamePage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;

public class LoginStepDefs extends ProjMethods {
	CommonMethods commonMenthods = new CommonMethods();
	LoginPage2 login = new LoginPage2();
	LocationsPage locationPage = new LocationsPage(driver);
	LobDetailsPage lob = new LobDetailsPage(driver);
	PremiumSummaryPage premium = new PremiumSummaryPage(driver);
	DashboardPage dashBoard = new DashboardPage(driver);
	ComLinesAutoSysPage comLine = new ComLinesAutoSysPage(driver); 
	EnterNamePage name = new EnterNamePage(driver);
	ComLinesAutoSysPage com = new ComLinesAutoSysPage(driver);

	@Given("^I login to the \"([^\"]*)\" environment$")
	public void i_login_to_the_environment(String arg1) throws Throwable {
		commonMenthods.environmnet(arg1);

	}

	@Given("^login as user for CLAS app from data at \"([^\"]*)\"$")
	public void enterLoginDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
			System.out.println("My username is:" + data.get(1).get(0).toString());
		}
		Thread.sleep(2000);
		login
		.enterUserName(data.get(1).get(0).toString())
		.enterPassword(data.get(1).get(1).toString())
				.clickLoginBtnInSLT();
		Thread.sleep(3000);
		if(data.get(1).get(0).toString().equals("user_field")) {
				com.clickGo()
				.enterAccName(data.get(1).get(2).toString())
				.clickNext()
				.clickYesOrNo();
				}
		
		else {
			com.clickGoinAgent()
			.enterAccName(data.get(1).get(2).toString())
			.clickNext()
			.clickYesOrNo();
			
		}

	}
	
	@Given("^login as user for CLAS app to create issue from data at \"([^\"]*)\"$")
	public void enterLoginDetailsRCIS(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
			System.out.println("My username is:" + data.get(1).get(0).toString());
		}
		Thread.sleep(2000);
		login.enterUserName(data.get(1).get(0).toString());
		login.enterPassword(data.get(1).get(1).toString());
		login.clickLoginBtnInSLT();
		Thread.sleep(5000);
		switchToWindow(1);
		Thread.sleep(3000);
		comLine.clicksearchBox();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		login.clickBusinessDropdown();
		comLine.clickGoButton();
		name.enterAccName(data.get(1).get(2).toString());
		name.clickNext();
		name.clickYesOrNo();

	}

	@Given("^I enter the loctaion details to create new quote \"([^\"]*)\"$")
	public void enterLocationLobdetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
			System.out.println("My username is:" + data.get(1).get(0).toString());
		}
		WebElement Quote= driver.findElement(By.xpath("//*[@id=\"accountInfoBar\"]/ul/li[1]"));
		
		locationPage.enetrDesc(data.get(1).get(0).toString());
		locationPage.clickNextToLobDetails();
		lob.enterNumEmployees(data.get(1).get(1).toString());
		lob.selectLossRate(data.get(1).get(2).toString());
		lob.clickNext();
		lob.enterClassCodeinSLT("A");
		lob.enterPremiumBasics(data.get(1).get(3).toString());
		lob.clickNext();
		lob.enterexpMod(data.get(1).get(4).toString());
		lob.enterexpModStatus(data.get(1).get(5).toString());
		lob.selectDeductible(data.get(1).get(6).toString());
		lob.clickNext();
		lob.clickLobRateButton();
		premium.verifyPremiumValue();
	}

	
}