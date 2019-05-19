package com.api.cucumber.pages;


import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.api.cucumber.comMethods.ProjMethods;


public class InlandMarinePages extends ProjMethods {
	public InlandMarinePages(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//Next Coverages
	@FindBy(how=How.LINK_TEXT,using="Next Coverages")
	public static WebElement eleNextCoverages;
	public InlandMarinePages clickNextCoverages()
	{
		click(eleNextCoverages);
		return this;
	}
	//Verify Coverage is not available in Policy Coverages Section
	@FindBy(how=How.XPATH,using="//div[@class='formBox']")
	public static WebElement elePolicyCoverages;
	public InlandMarinePages verfyPolicyCoverages(String data)
	{
		verifyPartialTextNotAvailable(elePolicyCoverages, data);
		return this;
	}
	//Coverages - Contractors Equipment
	@FindBy(how=How.ID,using="chkspliContEquip")
	public static WebElement eleContractorsEquipment;
	public InlandMarinePages clickContractorsEquipment()
	{
		click(eleContractorsEquipment);
		return this;
	}
	//Contractors Equipment -Schedule
	//Description of Scheduled Property
	@FindBy(how=How.XPATH,using="(//div[@class='sigi-grid-item']/input)[1]")
	public static WebElement eleSchPropDesc;
	public InlandMarinePages enterScheduledPropDesc(String data)
	{
		//eleSchPropDesc.click();
		type(eleSchPropDesc, data);
		return this;
	}
	//Limit of Insurance
	@FindBy(how=How.XPATH,using="(//div[@class='sigi-grid-item']/input)[2]")
	public static WebElement eleLimitOfInsurance;
	public InlandMarinePages enterLimitOfInsurance(String data)
	{
		type(eleLimitOfInsurance, data);
		eleLimitOfInsurance.sendKeys(Keys.TAB);
		eleLimitOfInsurance.sendKeys(Keys.TAB);
		return this;
	}

	//Rate
	@FindBy(how=How.ID,using="txtIrMpESchRate")
	public static WebElement eleRateMachEquip;
	public InlandMarinePages enterRateMachEquip(String data)
	{
		type(eleRateMachEquip, data);
		//eleLimitOfInsurance.sendKeys(Keys.TAB);
		return this;
	}
	//Equipment Leased/Rented from Others
	@FindBy(how=How.XPATH,using="//input[@id='chkUnScheduled']")
	public static WebElement eleChkBxEquLeasedRented;
	public InlandMarinePages clickChkBxEquLeasedRented()
	{
		click(eleChkBxEquLeasedRented);
		return this;
	}
	//Equipment Leased or Rented from Others per Item
	@FindBy(how=How.XPATH,using="//input[@id='txtUnSchItem']")
	public static WebElement eleEquLeasedRentedPerItem;
	public InlandMarinePages enterEquLeasedRentedPerItem(String data)
	{
		type(eleEquLeasedRentedPerItem, data);
		return this;
	}
	//Total Equipment Limit
	@FindBy(how=How.XPATH,using="//input[@id='txtUnSchLim']")
	public static WebElement eleTotalEquLimit;
	public InlandMarinePages enterTotalEquLimit(String data)
	{
		type(eleTotalEquLimit, data);
		return this;
	}

	//Type
	@FindBy(how=How.ID,using="ddlType")
	public static WebElement eleType;
	public InlandMarinePages selectType()
	{
		selectDropDownUsingIndex(eleType,1);
		return this;
	}
	//Leased/Rental Expenditures/Fees
	@FindBy(how=How.ID,using="txtLesRenExpFee")
	public static WebElement eleLeasedRentalExpFees;
	public InlandMarinePages enterLeasedRentalExpFees(String data)
	{
		type(eleLeasedRentalExpFees, data);
		return this;
	}

	//Rental Fee Rate
	@FindBy(how=How.ID,using="txtUnSchRent")
	public static WebElement eleRentalFeeRate;
	public InlandMarinePages enterRentalFeeRate(String data)
	{
		type(eleRentalFeeRate, data);
		return this;
	}
	//Deposit Prem
	@FindBy(how=How.ID,using="txtUnSchDepPrem")
	public static WebElement eleDepositPrem;
	public InlandMarinePages enterDepositPrem(String data)
	{
		type(eleDepositPrem, data);
		return this;
	}
	//Contractors Equipment Rental Reimbursment
	@FindBy(how=How.XPATH,using="//input[@id='chkRentExp']")
	public static WebElement eleContractorsEquipRentalReimbursmnt;
	public InlandMarinePages clickContractorsEquipRentalReimbursmnt()
	{
		click(eleContractorsEquipRentalReimbursmnt);
		return this;
	}
	//Per Day Limit
	@FindBy(how=How.ID,using="txtRentDayLmt")
	public static WebElement elePerDayLimit;
	public InlandMarinePages enterPerDayLimit(String data)
	{
		type(elePerDayLimit, data);
		return this;
	}
	//Total Rental limit
	@FindBy(how=How.ID,using="txtTentTotLmt")
	public static WebElement eleTotalRemntalLimit;
	public InlandMarinePages enterTotalRemntalLimit(String data)
	{
		type(eleTotalRemntalLimit, data);
		return this;
	}
	//Rental Rate
	@FindBy(how=How.ID,using="txtRentRate")
	public static WebElement eleRentalRate;
	public InlandMarinePages enterRentalRate(String data)
	{
		type(eleRentalRate, data);
		return this;
	}
	//Premium
	@FindBy(how=How.ID,using="txtRentPrem")
	public static WebElement elePremium;
	public InlandMarinePages enterPremium(String data)
	{
		type(elePremium, data);
		return this;
	}

	//Contractors Equipment Buisness Income and Extra Expense
	@FindBy(how=How.XPATH,using="//input[@id='chkBusIncEe']")
	public static WebElement eleChkBxContEquBuisIncExtraExpense;
	public InlandMarinePages clickChkBxContEquBuisIncExtraExpense()
	{
		click(eleChkBxContEquBuisIncExtraExpense);
		return this;
	}
	//Contractors Equipment Weight of Load Endorsment
	@FindBy(how=How.XPATH,using="//input[@id='chkWtLossEnd']")
	public static WebElement eleChkBxLossEnd;
	public InlandMarinePages clickChkBxLossEnd()
	{
		click(eleChkBxLossEnd);
		return this;
	}
	//Contractors Equipment Riggers Liability Endorsment
	@FindBy(how=How.XPATH,using="//input[@id='chkReggrLiab']")
	public static WebElement eleChkBxReggrLiab;
	public InlandMarinePages clickChkBxReggrLiab()
	{
		click(eleChkBxReggrLiab);
		return this;
	}
	//Coverages - Golf Maintenance Equipment
	@FindBy(how=How.ID,using="chkspliGolfMaintEquip")
	public static WebElement eleGolfMaintenanceEquipment;
	public InlandMarinePages clickGolfMaintenanceEquipment()
	{
		click(eleGolfMaintenanceEquipment);
		return this;
	}

	//chkRentExp
	@FindBy(how=How.ID,using="chkRentExp")
	public static WebElement eleChkBxGolfMaintenanceRentReimbursment;
	public InlandMarinePages clickGolfMaintenanceRentReim()
	{
		click(eleChkBxGolfMaintenanceRentReimbursment);
		return this;
	}
	//Per Day Limit
	@FindBy(how=How.ID,using="txtPerDayLmt")
	public static WebElement eleGolfPerDayLimit;
	public InlandMarinePages enterGolfPerDayLimit(String data)
	{
		type(eleGolfPerDayLimit, data);
		return this;
	}
	//Total Rental limit
	@FindBy(how=How.ID,using="txtRentTotLmt")
	public static WebElement eleGolfTotalRemntalLimit;
	public InlandMarinePages enterGolfTotalRemntalLimit(String data)
	{
		type(eleGolfTotalRemntalLimit, data);
		return this;
	}

	//-----Coverages----- 
	//Miscellaneous Prop Tools
	@FindBy(how=How.ID,using="chkspliMiscProp")
	public static WebElement eleMiscPropTools;
	public InlandMarinePages clickMiscPropTools()
	{
		click(eleMiscPropTools);
		return this;
	}
	//Machinery/Equipment
	@FindBy(how=How.ID,using="spliMPEquip")
	public static WebElement eleMachineryEquipment;
	public InlandMarinePages clickMachineryEquipment()
	{
		click(eleMachineryEquipment);
		return this;
	}
	//Miscellaneous NOC
	@FindBy(how=How.ID,using="spliIrMPNoc")
	public static WebElement eleMiscellaneousNoc;
	public InlandMarinePages clickMiscNoc()
	{
		click(eleMiscellaneousNoc);
		return this;
	}
	//Paraphernalia
	@FindBy(how=How.ID,using="spliMPParaph")
	public static WebElement eleParaphernalia;
	public InlandMarinePages clickParaphernalia()
	{
		click(eleParaphernalia);
		return this;
	}

	//Radio
	@FindBy(how=How.ID,using="spliMPRadio")
	public static WebElement eleRadio;
	public InlandMarinePages clickRadio()
	{
		click(eleRadio);
		return this;
	}
	//Tools
	@FindBy(how=How.ID,using="spliMPTools")
	public static WebElement eleTools;
	public InlandMarinePages clickTools()
	{
		click(eleTools);
		return this;
	}
	//Sales Representative Floater
	@FindBy(how=How.ID,using="spliIrMPSalesRepFloater")
	public static WebElement eleSalesRepFloater;
	public InlandMarinePages clickSalesRepFloater()
	{
		click(eleSalesRepFloater);
		return this;
	}
	//Pattern Floater
	@FindBy(how=How.ID,using="spliIrMPPatternFloater")
	public static WebElement elePatternFloater;
	public InlandMarinePages clickPatternFloater()
	{
		click(elePatternFloater);
		return this;
	}
	//Exhibition Floater
	@FindBy(how=How.ID,using="spliIrMPExhibitFloater")
	public static WebElement eleExhibitionFloater;
	public InlandMarinePages clickExhibitionFloater()
	{
		click(eleExhibitionFloater);
		return this;
	}
	//-----Miscellaneous Machinery Equipment Coverage-----
	//Scheduled Property -Check Box  
	@FindBy(how=How.ID,using="chksplScheduleMEGrid")
	public static WebElement eleChkBxScheduleME;
	public InlandMarinePages clickScheduleME()
	{
		click(eleChkBxScheduleME);
		return this;
	}
	//Deductible
	@FindBy(how=How.XPATH,using="//input[@id='btntxtIrMpESchDed']")
	public static WebElement eleMESchDed;
	@FindBy(how=How.XPATH,using="(//table[@id='divtxtIrMpESchDed_grid']/tbody/tr)[2]")
	public static WebElement eleMESchDedValue;
	public InlandMarinePages clickMESchDeductible()
	{
		click(eleMESchDed);
		click(eleMESchDedValue);
		return this;
	}

	//UnScheduled Property -Check Box 
	@FindBy(how=How.ID,using="chksplitemUSchME")
	public static WebElement eleChkBxUnScheduleME;
	public InlandMarinePages clickUnScheduleME()
	{
		click(eleChkBxUnScheduleME);
		return this;
	}
	//Description of UnScheduled Property
	@FindBy(how=How.XPATH,using="//input[@id='txtUDesc']")
	public static WebElement eleMEUnSchedulePropDesc;
	public InlandMarinePages enterMEUnSchedulePropDesc(String data)
	{
		type(eleMEUnSchedulePropDesc, data);
		return this;
	}
	//UnScheduled Limit
	@FindBy(how=How.ID,using="txtIrMpEUSchLmt")
	public static WebElement eleMEUnScheduledLimit;
	public InlandMarinePages enterMEUnScheduledLimit(String data)
	{
		type(eleMEUnScheduledLimit, data);
		return this;
	}
	//One Item Limit
	@FindBy(how=How.ID,using="txtIrMpEUSchItem")
	public static WebElement eleMEOneItemLimit;
	public InlandMarinePages enterMEOneItemLimit(String data)
	{
		type(eleMEOneItemLimit, data);
		return this;
	}
	//Rate
	@FindBy(how=How.ID,using="txtIrMpEUSchRate")
	public static WebElement eleRateUnScMachEquip;
	public InlandMarinePages enterRateUnScMachEquip(String data)
	{
		type(eleRateUnScMachEquip, data);
		//eleLimitOfInsurance.sendKeys(Keys.TAB);
		return this;
	}
	//Edit Button
	@FindBy(how=How.LINK_TEXT,using="Edit")
	public static WebElement eleEdit;
	public InlandMarinePages clickEdit()
	{
		click(eleEdit);
		return this;
	} 

	//Next Button
	@FindBy(how=How.LINK_TEXT,using="Next")
	public static WebElement eleNext;
	public InlandMarinePages clickNext()
	{
		click(eleNext);
		return this;
	}
	//Back Button
	@FindBy(how=How.LINK_TEXT,using="Back")
	public static WebElement eleBack;
	public InlandMarinePages clickBack()
	{
		click(eleBack);
		return this;
	}
	//Ok Button
	@FindBy(how=How.XPATH,using="//span[@class='ui-button-text']")
	public static WebElement eleOk;
	public InlandMarinePages clickOk()
	{
		click(eleOk);
		return this;
	}
	//Ok Button on Location confirmation 
	@FindBy(how=How.XPATH,using="//a[@id='btnExit']")
	public static WebElement eleOkBtn;
	public InlandMarinePages clickOkBtn()
	{
		driver.switchTo().frame("SIGI_DialogURL");
		click(eleOkBtn);
		return this;
	}
	//Yes or No
	@FindBy(how=How.XPATH,using="(//span[@class='ui-button-text'])[1]")
	public static WebElement eleYes;
	public InlandMarinePages clickYes()
	{
		click(eleYes);
		return this;
	}
	//Yes or No
	@FindBy(how=How.XPATH,using="(//div[@class='ui-dialog-buttonset']/button)[1]")
	public static WebElement eleBtnYes;
	public InlandMarinePages clickBttnYes()
	{
		click(eleBtnYes);
		return this;
	}
	@FindBy(how=How.CLASS_NAME,using="btnGo")
	public static WebElement eleBtnSearch;
	@FindBy(how=How.LINK_TEXT,using="Search")
	public static WebElement eleBttnSearch;
	@FindBy(how=How.XPATH,using="//div[@id='divtxtIrCityLocKeye']/input")
	public static WebElement eleSearchBtn;
	@FindBy(how=How.XPATH,using="(//td[@class='sigi-grid-cell ']/div)[1]")
	public static WebElement eleSearchResultLoc;
	@FindBy(how=How.LINK_TEXT,using="Select")
	public static WebElement eleBttnSelect;
	public InlandMarinePages clickSearch()
	{
		click(eleBtnSearch);
		click(eleBttnSearch);
		click(eleSearchResultLoc);
		click(eleBttnSelect);
		return this;
	}
	//Click on Edit Inland Marine LOb 
	@FindBy(how=How.LINK_TEXT,using="Edit Inland Marine LOB")
	public static WebElement eleEditInlandMarineLOB;
	public InlandMarinePages cliclEditInlandMarineLOB()
	{
		click(eleEditInlandMarineLOB);
		return this;
	}
	//Click on Location Info
	@FindBy(how=How.XPATH,using="(//div[@class='title']/h2)[1]")
	public static WebElement eleLocationInfo;
	public InlandMarinePages clickLocationInfo()
	{
		click(eleLocationInfo);
		return this;
	}
	//chkCityOverride
	@FindBy(how=How.ID,using="chkCityOverride")
	public static WebElement eleCityOverride;
	public InlandMarinePages clickCityOverride()
	{
		click(eleCityOverride);
		return this;
	}

	//Basic Gropup Territory I
	@FindBy(how=How.ID,using="cboIrBasicGrp1")
	public static WebElement eleBasicGrpTerritory;
	public InlandMarinePages enterBasicGrpTerritory(String data)
	{
		type(eleBasicGrpTerritory, data);
		return this;
	}

	//misc
	@FindBy(how=How.ID,using="txtIrMiscInd")
	public static WebElement eleMisc;
	public InlandMarinePages enterMisc(String data)
	{
		type(eleMisc, data);
		return this;
	}

	//Protection Class 
	@FindBy(how=How.ID,using="txtIrProtClass")
	public static WebElement eleProtectionClass;
	public InlandMarinePages enterProtectionClass(String data)
	{
		type(eleProtectionClass, data);
		return this;
	}
	//Location Class Code Information
	//Construction
	@FindBy(how=How.ID,using="cboIrConstSym")
	public static WebElement eleConstruction;
	public InlandMarinePages selectConstruction(String data){
		selectDropDownUsingText(eleConstruction, data);
		return this;
	}
	//Rate type
	@FindBy(how=How.ID,using="cboIrBgiRateTyp")
	public static WebElement eleRateType;
	public InlandMarinePages selectRateType(String data){
		selectDropDownUsingText(eleRateType, data);
		return this;
	}
	//BDII Symbol
	@FindBy(how=How.ID,using="cboIrBgiiSym")
	public static WebElement eleBGSymbol;
	public InlandMarinePages selectBGSymbol(String data){
		selectDropDownUsingText(eleBGSymbol, data);
		return this;
	}
	//Class Code
	@FindBy(how=How.ID,using="txtIrBppClassCd")
	public static WebElement eletxtClassCode;
	@FindBy(how=How.XPATH,using="(//input[@class='btnGo'])[2]")
	public static WebElement eleSearch;
	@FindBy(how=How.XPATH,using="(//table[@id='txtIrBppClassCd_grid_grid']/tbody/tr)[3]")
	public static WebElement eleSearchResult;
	@FindBy(how=How.XPATH,using="//a[@id='txtIrBppClassCd_select']/span/strong")
	public static WebElement eleBtnSelect;
	public static WebElement eleEnterClassCode;
	public InlandMarinePages enterClassCode(String data) throws AWTException, InterruptedException
	{
		type(eletxtClassCode, "OFF");
		Robot classCode = new Robot();
		classCode.keyPress(KeyEvent.VK_ENTER);
		classCode.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		click(eleSearchResult);
		click(eleBtnSelect);
		return this;
	}
	//Next To Coverages
	@FindBy(how=How.LINK_TEXT,using="Next to Coverages")
	public static WebElement eleNextToCoverages;
	public InlandMarinePages clickNextToCoverages()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		//System.out.println(ele);
		wait.until(ExpectedConditions.elementToBeClickable(eleNextToCoverages));
		click(eleNextToCoverages);
		/*WebDriverWait wait = new WebDriverWait(driver, 90);
		//System.out.println(ele);
		wait.until(ExpectedConditions.elementToBeClickable(eleNextToCoverages));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", eleNextToCoverages);*/
		return this;
	}
	//Prometrix Schedule
	@FindBy(how=How.XPATH,using="(//div[@id='lvLocList']/table/tbody/tr)[2]")
	public static WebElement eleProMetrixSchedule;
	public InlandMarinePages selectPrometrixSchedule(){
		//driver.switchTo().frame("SIGI_DialogURL");
		click(eleProMetrixSchedule);
		return this;
	}
	//ProMetrix Override reason
	@FindBy(how=How.ID,using="txtPMClassOverDesc")
	public static WebElement eleProMetrixOveRRideReason;
	public InlandMarinePages enterPrometrixOverRideReason(String data)
	{
		type(eleProMetrixOveRRideReason, data);
		return this;
	}
	//Verify Coverage is available in Location Coverages Sec
	@FindBy(how=How.XPATH,using="//div[@class='formBox']")
	public static WebElement eleLocCoverages;
	public InlandMarinePages verfyLocCoverages(String data)
	{
		verifyPartialText(eleLocCoverages, data);
		return this;
	}
	//Location Coverages - Physicians Surgeons equipment
	@FindBy(how=How.ID,using="chksplioptPsE")
	public static WebElement elePhysicianSurEqu;
	public InlandMarinePages clickPhysicianSurEqu()
	{
		click(elePhysicianSurEqu);
		return this;
	}
	//Discard Coverage - Yes
	@FindBy(how=How.XPATH,using="(//div[@class='ui-dialog-buttonset']/button)[1]")
	public static WebElement eleYesBtn;
	public InlandMarinePages clickYesBtn()
	{
		click(eleYesBtn);
		return this;
	}
	//Deductible in Physicians Surgeon Equipment
	@FindBy(how=How.XPATH,using="//input[@id='btntxtIrPsDedOcc']")
	public static WebElement elePSeDed;
	@FindBy(how=How.XPATH,using="(//table[@id='divtxtIrPsDedOcc_grid']/tbody/tr)[3]")
	public static WebElement elePSeDedValue;
	public InlandMarinePages clickPSeDeductible()
	{
		click(elePSeDed);
		click(elePSeDedValue);
		return this;
	}
	//Deductible Factor
	@FindBy(how=How.ID,using="txtIrPsDedFacOcc")
	public static WebElement eleDeductibleFactor;
	public InlandMarinePages verifyDeductibleFactor()
	{
		verifyNotEnabled(eleDeductibleFactor);
		return this;
	}
	//Limit
	@FindBy(how=How.ID,using="txtIrPsCoverLim")
	public static WebElement elePSLimit;
	public InlandMarinePages enterPSLimit(String data)
	{
		type(elePSLimit, data);
		return this;
	}
	//Equipment Dealers
	@FindBy(how=How.ID,using="chksplioptEquipDeal")
	public static WebElement eleChkBxEquipDealer;
	public InlandMarinePages clickEquipDealer()
	{
		click(eleChkBxEquipDealer);
		return this;
	}
	//-----Policy Wide Coverage Information-----
	//Info icon
	@FindBy(how=How.XPATH,using="(//span[@class='panelInfo'])[1]")
	public static WebElement elePolicyWideCovInfoIcon;
	public InlandMarinePages clickPolicyWideCovInfoIcon()
	{
		click(elePolicyWideCovInfoIcon);
		return this;
	}
	//Close Button 
	@FindBy(how=How.LINK_TEXT,using="Close")
	public static WebElement eleBtnClose;
	public InlandMarinePages clickBtnClose()
	{
		driver.switchTo().frame("SIGI_DialogURL");
		click(eleBtnClose);
		return this;
	}

	//Equipment Dealers - Class Code
	@FindBy(how=How.ID,using="cboEquipClassCode")
	public static WebElement eleEquDealerClassCode;
	public InlandMarinePages selectClassCode(String data)
	{
		//	driver.switchTo().frame("PopupShim");
		selectDropDownUsingText(eleEquDealerClassCode,data);
		return this;
	}
	//Equipment Dealers - Class Code - 235
	public InlandMarinePages selectOtherClassCode()
	{
		selectDropDownUsingIndex(eleEquDealerClassCode, 2);
		return this;
	}
	//Deductible - default value 
	@FindBy(how=How.ID,using="txtEquipDeductible")
	public static WebElement eleEdDeductibleTxt;
	public InlandMarinePages clickEdDeductibleTxt()
	{
		getTextValue(eleEdDeductibleTxt);
		return this;
	}
	//Deductible 
	@FindBy(how=How.ID,using="btntxtEquipDeductible")
	public static WebElement eleEdDeductible;
	@FindBy(how=How.XPATH,using="(//table[@id='DivtxtEquipDeductible_grid']/tbody/tr)[2]")
	public static WebElement eleEdDeductibleValue;
	public InlandMarinePages clickEdDeductibleValue()
	{
		click(eleEdDeductible);
		click(eleEdDeductibleValue);
		return this;
	}


	//Property Not at your Premises
	@FindBy(how=How.ID,using="txtEquipPropNotAtyourPremise")
	public static WebElement eleEquipPropNotAtYourPremise;
	public InlandMarinePages enterEquipPropNotAtYourPremise(String data)
	{
		type(eleEquipPropNotAtYourPremise, data);
		return this;
	}
	//Clear Property Not at Your Premises
	public InlandMarinePages clearEquipPropNotAtYourPremises()
	{
		eleEquipPropNotAtYourPremise.clear();
		return this;
	}

	@FindBy(how=How.XPATH,using="//div[@id='pnlEquipDealers_fieldSet']")
	public static WebElement elePolicyCovInfo;

	//Verify Reporting Premium Adjustment is not avail in PolicyWide Coverage Information Screen
	public InlandMarinePages verifyReportingPremAdjNotAvail(String data)
	{
		verifyPartialTextNotAvailable(elePolicyCovInfo, data);
		return this;
	}
	//Verify Reporting is not avail in PolicyWide Coverage Information Screen
	public InlandMarinePages verifyReportingNotAvailInPolicyCovInfo(String data)
	{
		verifyPartialTextNotAvailable(elePolicyCovInfo, data);
		return this;
	}
	//Reporting Period
	@FindBy(how=How.ID,using="cboEquipReportingPeriod")
	public static WebElement eleReportingPeriod;
	public InlandMarinePages selectReportingPeriod(String data)
	{
		click(eleReportingPeriod);
		selectDropDownUsingText(eleReportingPeriod, data);
		return this;
	}
	//Reporting Period Adjustment
	@FindBy(how=How.ID,using="cboEquipReportingPremAdj")
	public static WebElement eleReportingPremAdj;
	public InlandMarinePages selectReportingPreAdj(String data)
	{
		click(eleReportingPremAdj);
		selectDropDownUsingText(eleReportingPremAdj, data);
		return this;
	}

	//Deposit Premium
	@FindBy(how=How.ID,using="txtEquipDepositPrem")
	public static WebElement eleEquipDepositPrem;
	public InlandMarinePages enterEquipDepositPrem(String data)
	{
		type(eleEquipDepositPrem, data);
		return this;
	}
	//Premium base
	@FindBy(how=How.ID,using="txtEquipPremBasis")
	public static WebElement elePremiumBase;
	public InlandMarinePages enterPremiumBase(String data)
	{
		type(elePremiumBase, data);
		return this;
	}
	//Camera Dealers
	@FindBy(how=How.ID,using="chksplioptCamera")
	public static WebElement eleChkBxCameraDealers;
	public InlandMarinePages clickCameraDealer()
	{
		click(eleChkBxCameraDealers);
		return this;
	}
	//Camera Dealers-class Code
	@FindBy(how=How.ID,using="cboCameraClass")
	public static WebElement eleCameraDealerClassCode;
	public InlandMarinePages selectCameraDealersClassCode()
	{
		//	driver.switchTo().frame("PopupShim");
		//selectDropDownUsingText(eleCameraDealerClassCode,data);
		selectDropDownUsingIndex(eleCameraDealerClassCode, 1);
		return this;
	}
	//Premium
	@FindBy(how=How.ID,using="txtCameraPrem")
	public static WebElement elePremiumCamDealers;
	public InlandMarinePages enterPremiumCamDealers(String data)
	{
		type(elePremiumCamDealers, data);
		return this;
	}

	//Deductible - Camera Dealers
	@FindBy(how=How.XPATH,using="//input[@id='btntxtCameraDed']")
	public static WebElement eleCamDealersDed;
	@FindBy(how=How.XPATH,using="(//table[@id='divtxtCameraDed_grid']/tbody/tr)[5]")
	public static WebElement eleCamDealersDedValue;
	public InlandMarinePages clickCamDealersDeductible()
	{
		click(eleCamDealersDed);
		click(eleCamDealersDedValue);
		return this;
	}
	//Rate
	@FindBy(how=How.ID,using="txtEquipRatefield")
	public static WebElement eleRate;
	public InlandMarinePages enterRate(String data)
	{
		type(eleRate, data);
		return this;
	}
	//-----Location/building Specific Information-----
	//Inside Building
	@FindBy(how=How.ID,using="txtIrEquipInsideBldg")
	public static WebElement eleInsideBuild;
	public InlandMarinePages enterInsideBuild(String data)
	{
		type(eleInsideBuild, data);
		return this;
	}
	//Outside Building
	@FindBy(how=How.ID,using="txtEquipOutsideBldg")
	public static WebElement eleOutsideBuild;
	public InlandMarinePages enterOutsideBuild(String data)
	{
		type(eleOutsideBuild, data);
		return this;
	}
	//Property in transit
	@FindBy(how=How.ID,using="txtEquipPropInTraEqDeit")
	public static WebElement elePropInTransit;
	public InlandMarinePages enterPropInTransit(String data)
	{
		type(elePropInTransit, data);
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
	//Next to Premium Summary
	@FindBy(how=How.LINK_TEXT,using="Next to Premium Summary")
	public static WebElement eleNextToPremiumSum;
	public InlandMarinePages clickNextToPremiumSum(){
		click(eleNextToPremiumSum);
		return this;
	}

	//Next to Premium Summary
		@FindBy(how=How.LINK_TEXT,using="Next to Inland Marine")
		public static WebElement eleNextToInlandMarine;
		public InlandMarinePages clickNextToInlandMarine(){
			click(eleNextToInlandMarine);
			return this;
		}

	
}
