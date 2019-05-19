package com.api.cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.api.cucumber.comMethods.ProjMethods;

public class EPLLobPageDetails extends ProjMethods{
	
	//
	public EPLLobPageDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Total number of employees
	@FindBy(how = How.ID, using = "txtFTE")
	public static WebElement eleTotalEmployees;

	public EPLLobPageDetails EnterTotalEmployees() {
		type(eleTotalEmployees, "17");
		eleTotalEmployees.clear();
		type(eleTotalEmployees, "21");
		return this;

	}
	
	// Expand coverages
		@FindBy(how = How.XPATH, using = "//div[@id='OptCoverage']//div[@class='title']//h2")
		public static WebElement eleExpandCoverage;
		@FindBy(how = How.NAME, using = "chkchkoptPriorActs")
		public static WebElement elePriorActsCoverage;
		@FindBy(how = How.NAME, using = "chkchkoptSerp")
		public static WebElement eleSupplementalExtendedCoverage;
		@FindBy(how = How.NAME, using = "chkchkThrdPartyCvg")
		public static WebElement eleThirdPartyCoverage;
		@FindBy(how = How.XPATH, using = "//div[@class='fieldset stackingPanelContent']//div[@class='stackingPanelItem']//div[@contenttype='SubContent']//div//label")
		public static List<WebElement> eleSelectCoverages;
		@FindBy(how = How.ID, using = "mskPriorDt_Text")
		public static WebElement elePriorCoverageDate;
		@FindBy(how = How.ID, using = "txtPriorlmt")
		public static WebElement elePriorAggregateLimit;
		@FindBy(how = How.ID, using = "cboRtpprd")
		public static WebElement eleSupplementalReportingPeriod;
		@FindBy(how = How.ID, using = "cboEPFrm2407BusnsClass")
		public static WebElement eleClassOfBusiness;
		public EPLLobPageDetails selectCoverage() throws InterruptedException {
		
			click(eleExpandCoverage);
			Thread.sleep(2000);
//			for(WebElement  i :eleSelectCoverages) {
//				String coverage = i.getText();
//				if(!(coverage.equals(" "))) {
//					i.click();
//				}
//				else {
//					break;
//				}
//			}
//			
			click(elePriorActsCoverage);
			type(elePriorCoverageDate,"101119");
			type(elePriorAggregateLimit,"1200");
			click(eleSupplementalExtendedCoverage);
			Thread.sleep(1000);
			Select supplementalperiord = new Select(eleSupplementalReportingPeriod);
			supplementalperiord.selectByIndex(1);
			Thread.sleep(1000);
			click(eleThirdPartyCoverage);
			Thread.sleep(1000);
			Select classOfBusiness = new Select(eleClassOfBusiness);
			classOfBusiness.selectByIndex(1);
			return this;

		}

}
