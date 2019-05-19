package com.api.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.api.cucumber.comMethods.ProjMethods;

public class DashboardPage extends ProjMethods {

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "#sigiGridInfo_1545383511063668539643 tbody tr td:nth-child(4) a")
	public static WebElement eleMoreLink;

	public DashboardPage clickMoreLink() {
		click(eleMoreLink);
		return this;
	}

	@FindBy(how = How.CSS, using = "#fl_sigiGridInfo_1545383511063668539643 div:nth-child(2) a")
	public static WebElement eleIssueLink;

	public DashboardPage clickIssueLink() {
		click(eleIssueLink);
		return this;
	}
	
	@FindBy(how = How.CSS, using = "uniform-ddlSearchType")
	public static WebElement eleSearch;

	public DashboardPage clickSearch() {
		click(eleSearch);
		return this;
	}
	
	 

}
