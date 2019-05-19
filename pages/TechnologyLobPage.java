package com.api.cucumber.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.api.cucumber.comMethods.ProjMethods;

public class TechnologyLobPage extends ProjMethods {
	public TechnologyLobPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "ddlAggrLimit")
	public static WebElement eleTechAggrLimit;

	public TechnologyLobPage selectTechAgrLimit() {
		Select AggrlimitTechLob = new Select(eleTechAggrLimit);
		AggrlimitTechLob.selectByIndex(1);
		return this;
	}

	@FindBy(how = How.ID, using = "ddlPerClaimLmt")
	public static WebElement eleTechPerClaimLimit;

	public TechnologyLobPage selectTechPerClaimLimit() {
		Select perClaimLimit = new Select(eleTechPerClaimLimit);
		perClaimLimit.selectByIndex(1);
		return this;
	}

	@FindBy(how = How.ID, using = "ddlDeductible")
	public static WebElement eletechdeductible;

	public TechnologyLobPage selectTechdeductible() {
		Select deductible = new Select(eletechdeductible);
		deductible.selectByIndex(1);
		return this;
	}

	@FindBy(how = How.ID, using = "lvClassCode_textbox_4_0_357101")
	public static WebElement eleGrossSales;

	public TechnologyLobPage enterGrossSales() {
		type(eleGrossSales, "1");
		return this;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='splOptions']//div[@class='title']//h2")
	public static WebElement eleExpandOptionalCoverage;
	@FindBy(how = How.ID, using = "chkspliAddlInsrd")
	public static WebElement eleAddInsured_DEOrPerson;
	@FindBy(how = How.ID, using = "chkspliDefenseCost")
	public static WebElement eleSpldefenceCost;
	@FindBy(how = How.ID, using = "chkspliAmendCovTerr")
	public static WebElement eleSplAmendCost;
	@FindBy(how = How.ID, using = "chkspliAmendRetroDate")
	public static WebElement eleSplAmendRetro;
	@FindBy(how = How.ID, using = "chkspliExclDesigProd")
	public static WebElement eleSplExclDesignprod;
	@FindBy(how = How.ID, using = "chkspliExclDesigProf")
	public static WebElement eleSplExclDesignprof;
	@FindBy(how = How.ID, using = "chkspliExclDevRisk")
	public static WebElement eleSplExclDevRisk;
	@FindBy(how = How.ID, using = "chkspliExclElecTrnsfr")
	public static WebElement eleSplExclEleTransfer;
	@FindBy(how = How.ID, using = "chkspliExclFailWork")
	public static WebElement eleSplExclFailWork;
	@FindBy(how = How.ID, using = "chkspliUnAuthUse")
	public static WebElement eleSplUnauth;
	
	

	public TechnologyLobPage selectOptionalCoveragetech() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", eleExpandOptionalCoverage);
		JavascriptExecutor jsDEOrPerson = (JavascriptExecutor) driver;
		jsDEOrPerson.executeScript("arguments[0].click();", eleAddInsured_DEOrPerson);
		JavascriptExecutor jsSpldefCost = (JavascriptExecutor) driver;
		jsSpldefCost.executeScript("arguments[0].click();", eleSpldefenceCost);
		JavascriptExecutor jsSplAmendCost = (JavascriptExecutor) driver;
		jsSplAmendCost.executeScript("arguments[0].click();", eleSplAmendCost);
		JavascriptExecutor jsSplAmendretro = (JavascriptExecutor) driver;
		jsSplAmendretro.executeScript("arguments[0].click();", eleSplAmendRetro);
		JavascriptExecutor jsSpldesignProd = (JavascriptExecutor) driver;
		jsSpldesignProd.executeScript("arguments[0].click();", eleSplExclDesignprod);
		JavascriptExecutor jsSpldesignProf = (JavascriptExecutor) driver;
		jsSpldesignProf.executeScript("arguments[0].click();", eleSplExclDesignprof);
		JavascriptExecutor jsSplExclDevRisk = (JavascriptExecutor) driver;
		jsSplExclDevRisk.executeScript("arguments[0].click();", eleSplExclDevRisk);
		JavascriptExecutor jsSplExclEleTransfer = (JavascriptExecutor) driver;
		jsSplExclEleTransfer.executeScript("arguments[0].click();", eleSplExclEleTransfer);
		JavascriptExecutor jsSplExclFailWork = (JavascriptExecutor) driver;
		jsSplExclFailWork.executeScript("arguments[0].click();", eleSplExclFailWork);
		JavascriptExecutor jsSplUnauth = (JavascriptExecutor) driver;
		jsSplUnauth.executeScript("arguments[0].click();", eleSplUnauth);
		return this;
	}

}
