package com.api.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.api.cucumber.comMethods.ProjMethods;

public class ContractorLobDetailsPage extends ProjMethods {
	
	public ContractorLobDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(how = How.ID, using = "cboOccurLimit")
	public static WebElement eleContractorLimit;

	public ContractorLobDetailsPage selectContractorLimit() {
		Select contractorLimit = new Select(eleContractorLimit);
		contractorLimit.selectByIndex(1);

		return this;
	}
	
	@FindBy(how = How.ID, using = "cboDeductible")
	public static WebElement eleContractordeductible;

	public ContractorLobDetailsPage selectContractorDeductible() {
		Select contractorDeductible = new Select(eleContractordeductible);
		contractorDeductible.selectByIndex(1);

		return this;
	}
	
	@FindBy(how = How.ID, using = "CityHelp1")
	public static WebElement eleContractorCitySearch;
	@FindBy(how = How.ID, using = "CityHelp1_zipCode")
	public static WebElement eleContractorZipCode;
	@FindBy(how = How.ID, using = "//a[@id='CityHelp1_searchOK']//span")
	public static WebElement elecontractorCitySearch;
	@FindBy(how = How.ID, using = "//div[@id='CityHelp1_grid']//tbody//tr[1]//td[1]//div")
	public static WebElement eleSearchResultsSelect;
	@FindBy(how = How.ID, using = "//a[@id='CityHelp1_listOK']//span")
	public static WebElement eleSelectButton;

			
	public ContractorLobDetailsPage clickContractorCitySearch() {
		click(eleContractorCitySearch);
		type(eleContractorZipCode, "19720");
		click(elecontractorCitySearch);
		click(eleSearchResultsSelect);
		click(eleSelectButton);
		return this;
	}

}
