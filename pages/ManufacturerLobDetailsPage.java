package com.api.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.api.cucumber.comMethods.ProjMethods;

public class ManufacturerLobDetailsPage extends ProjMethods {

	public ManufacturerLobDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Per Claim Limit/Aggregate Limit
	@FindBy(how = How.ID, using = "ddlLimits")
	public static WebElement elePerClaimLimit;

	public ManufacturerLobDetailsPage selectPerClaimLimit() {
		Select perClaimLimit = new Select(elePerClaimLimit);
		perClaimLimit.selectByIndex(1);
		return this;

	}

	// Deductible
	@FindBy(how = How.ID, using = "ddlDeductible")
	public static WebElement eleDeductible;

	public ManufacturerLobDetailsPage selectDeductible() {
		Select deductible = new Select(eleDeductible);
		deductible.selectByIndex(1);
		return this;

	}

	// Optional Coverages
	@FindBy(how = How.XPATH, using = "//div[@id='stkOptions']//div[@class='title']//h2")
	public static WebElement eleExpandOPtionalCoverage;

	public ManufacturerLobDetailsPage expandOptionalcoverage() {
		click(eleExpandOPtionalCoverage);
		return this;

	}

	// Consent50
	@FindBy(how = How.ID, using = "chkpl7095")
	public static WebElement eleConsentPL7095;

	public ManufacturerLobDetailsPage CheckConsentPL7095() {
		click(eleConsentPL7095);
		return this;

	}

	// Consent100
	// @FindBy(how = How.ID, using = "chkpl7094")
	// public static WebElement eleConsentPL7094;
	//
	// public MPLobDetailsPage CheckConsentPL7094() {
	// click(eleConsentPL7094);
	// return this;
	//
	// }

	// Defense outside of limits checkbox
	@FindBy(how = How.ID, using = "chkpl7097")
	public static WebElement eleDefenseOutsideOfLimits;

	public ManufacturerLobDetailsPage CheckDefenseOutsideOfLimits() {
		click(eleDefenseOutsideOfLimits);
		return this;

	}

	// Punitive Damages
	@FindBy(how = How.ID, using = "chkpl7091")
	public static WebElement elePunitiveDamages;

	public ManufacturerLobDetailsPage CheckPunitiveDamages() {
		click(elePunitiveDamages);
		return this;

	}

	// Additional7090 checkbox
	@FindBy(how = How.ID, using = "chkpl7090")
	public static WebElement eleAdditional7090;

	public ManufacturerLobDetailsPage CheckAdditional7090() {
		click(eleAdditional7090);
		return this;

	}

	// Additional Quantity7090
	@FindBy(how = How.ID, using = "txtQuantity7090")
	public static WebElement eleAdditional7090Quantity;

	public ManufacturerLobDetailsPage EnterAdditional7090Quantity() {
		type(eleAdditional7090Quantity, "100");
		return this;

	}

	// Additional7104 checkbox
	@FindBy(how = How.ID, using = "chkpl7104")
	public static WebElement eleAdditional7104;

	public ManufacturerLobDetailsPage CheckAdditional7104() {
		click(eleAdditional7104);
		return this;

	}

	// Additional Quantity7104
	@FindBy(how = How.ID, using = "txtQuantity7104")
	public static WebElement eleAdditional7104Quantity;

	public ManufacturerLobDetailsPage EnterAdditional7104Quantity() {
		type(eleAdditional7104Quantity, "200");
		return this;

	}

}
