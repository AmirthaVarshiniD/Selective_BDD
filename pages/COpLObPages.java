package com.api.cucumber.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.api.cucumber.comMethods.ProjMethods;


public class COpLObPages extends ProjMethods {
	public COpLObPages(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//-----Policy Information-----
	//Category
	@FindBy(how=How.ID,using="ddlCpCategory")
	public static WebElement eleDdlCategory;
	public COpLObPages checkDdlCategory(String data) throws InterruptedException
	{
		eleDdlCategory.click();
		Thread.sleep(2000);
		/*try {
			eleDdlCategory.click();
			Thread.sleep(2000);
			//TakesScreenshot.
			Robot robot = new Robot();
			File dest = new File("./Images/img.png");
			BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", dest);
		} catch (InterruptedException | AWTException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		checkDropDownValue(eleDdlCategory, data);
		//selectDropDownUsingText(eleDdlCategory, data);
		return this;
	}
	//Select category
	public COpLObPages selectCategory(String data)
	{
		selectDropDownUsingText(eleDdlCategory, data);
		return this;
	}
	//Error message for Habitational Category -FL
	@FindBy(how=How.XPATH,using="//div[@class='errorContainer']/h3/label")
	public static WebElement eleErrorMsg;
	public void checkErrMsg()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleErrorMsg);
		getText(eleErrorMsg);
	}
	//Error message in Location Tab 
	@FindBy(how=How.ID,using="notificationSection")
	public static WebElement eleErrorMsgInLoc;
	public void checkErrMsgINLoc()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleErrorMsgInLoc);
		getText(eleErrorMsgInLoc);
	}
	
	//Classification
	@FindBy(how=How.ID,using="ddlCpClassification")
	public static WebElement eleDdlClassification;
	public COpLObPages selectClassification(String data)
	{
		click(eleDdlClassification);
		selectDropDownUsingText(eleDdlClassification, data);
		return this;
	}
	//Net worth Check Box 
		@FindBy(how=How.ID,using="CpNetWorthInd")
		public static WebElement eleChkBxNetWorth;
		public COpLObPages clickChkBxNetWorth()
		{
			try
			{
				if(eleChkBxNetWorth.isDisplayed())
				{
					click(eleChkBxNetWorth);
				}
			}
			catch (WebDriverException e) {
				e.printStackTrace();
			}
			finally
			{
				System.out.println("Net Worth Not available");
			}
			return this;
		}
		//Net Revenue 
		@FindBy(how=How.ID,using="CpNetRevenueInd")
		public static WebElement eleChkBxNetRevenue;
		public COpLObPages clickChkBxNetRevenue()
		{
			
			try
			{
				if(eleChkBxNetRevenue.isDisplayed())
				{
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView();", eleChkBxNetRevenue);
					js.executeScript("arguments[0].click();", eleChkBxNetRevenue);
				}
			}
			catch (WebDriverException e) {
				e.printStackTrace();
			}
			finally
			{
				System.out.println("Net Revenue Not available");
				
			}
			return this;
		}
	//Construction
	@FindBy(how=How.ID,using="cboCpConstSym")
	public static WebElement eleDdlConstruction;
	public COpLObPages selectConstruction(String data)
	{
		selectDropDownUsingText(eleDdlConstruction, data);
		return this;
	}
	//Number of Stories 
	@FindBy(how=How.ID,using="txtCpNoOfStories")
	public static WebElement eleNoOfStories;
	public COpLObPages enterNoOfStories(String data)
	{
		type(eleNoOfStories, data);
		return this;
	}
	//Year Built 
	@FindBy(how=How.ID,using="txtCpYearConstr")
	public static WebElement eleYearBuilt;
	public COpLObPages enterYearBuilt(String data)
	{
		type(eleYearBuilt, data);
		return this;
	}
	//Main Location Indicator - Yes Button
	@FindBy(how=How.XPATH,using="(//div[@class='ui-dialog-buttonset']/button)[1]")
	public static WebElement eleMainLocIndYes;
	public COpLObPages clickYesInMainLocInd()
	{
		click(eleMainLocIndYes);
		return this;
	}
	//Limits - Building Insured Limit 
	@FindBy(how=How.ID,using="txtCpLocPfLimitBldg")
	public static WebElement eleBuildInsrLmt;
	public COpLObPages enterBuildInsuredLimit(String data)
	{
		type(eleBuildInsrLmt, data);
		return this;
	}
	//ITV Calculations 
	@FindBy(how=How.XPATH,using="(//div[@class='ui-dialog-buttonset']/button)[1]")
	public static WebElement eleITVCalcYes;
	public COpLObPages clickYesInITVCal()
	{
		click(eleITVCalcYes);
		return this;
	}
	//ITV Occupancy Code  
	@FindBy(how=How.XPATH,using="//input[@class='btnGo']")
	public static WebElement eleITVGo;
	@FindBy(how=How.XPATH,using="(//table[@class='sigi-grid-table']/tbody/tr)[2]")
	public static WebElement eleITVOccCodeVal;
	@FindBy(how=How.XPATH,using="(//table[@id='hlpOccupCode_grid_grid']/tbody/tr)[2]")
	public static WebElement eleITVOccCodeValue;
	public COpLObPages clickITVgo()
	{
		click(eleITVGo);
		click(eleITVOccCodeVal);
		click(eleITVOccCodeValue);
		return this;
	}
	//Gross Floor Area 
	@FindBy(how=How.ID,using="txtFloorArea")
	public static WebElement eleGrossFloorArea;
	public COpLObPages enterGrossFloorArea(String data)
	{
		type(eleGrossFloorArea, data);
		return this;
	}
	//Blanket Type 
	@FindBy(how=How.ID,using="ddlCpPfBlanketLmtCode")
	public static WebElement eleBlanketType;
	public COpLObPages selBlanketType(String data)
	{
		selectDropDownUsingText(eleBlanketType, data);
		return this;
	}
	//Covered Utility
	//Power 
	@FindBy(how=How.XPATH,using="//input[@id='chkPower']")
	public static WebElement elePower;
	public COpLObPages clickPower()
	{
		click(elePower);
		return this;
	}
	//Disaster Exposure  
	@FindBy(how=How.ID,using="rdoMultiDisasterExpo1")
	public static WebElement eleChkBxDisasterExp;
	public COpLObPages clickChkBxDisasterExp()
	{
		click(eleChkBxDisasterExp);
		return this;
	}
	//Climatical hazards  
	@FindBy(how=How.ID,using="rdoMultiClimHaz1")
	public static WebElement eleChkBxClimaticalhazards;
	public COpLObPages clickChkBxClimaticalHazards()
	{
		click(eleChkBxClimaticalhazards);
		return this;
	}
	//Special Occupancy hazards  
	@FindBy(how=How.ID,using="rdoMultiSOHPC1")
	public static WebElement eleSpclOccupancyhazards;
	public COpLObPages clickSpclOccupancyhazards()
	{
		click(eleSpclOccupancyhazards);
		return this;
	}
	//lack of Private Protection  
	@FindBy(how=How.ID,using="rdoMultiLackPP1")
	public static WebElement eleLackOfPrivateProt;
	public COpLObPages clickLackOfPrivateProt()
	{
		click(eleLackOfPrivateProt);
		return this;
	}
	//Earth Movement  
	@FindBy(how=How.ID,using="rdoMultiEarthMove1")
	public static WebElement eleEarthMovement;
	public COpLObPages clickEarthMovement()
	{
		click(eleEarthMovement);
		return this;
	}
	//Inadequate Public Protection  
	@FindBy(how=How.ID,using="rdoMultiInadqPP1")
	public static WebElement eleInadequatePubPro;
	public COpLObPages clickInadequatePubPro()
	{
		click(eleInadequatePubPro);
		return this;
	}
	//Water Damage  
	@FindBy(how=How.ID,using="rdoMultiWaterDamg1")
	public static WebElement eleWaterDamage;
	public COpLObPages clickWaterDamage()
	{
		click(eleWaterDamage);
		return this;
	}
	//Lower deductible  
	@FindBy(how=How.ID,using="rdoMultiLowerDeduc1")
	public static WebElement eleLowerDeductible;
	public COpLObPages clickLowerDeductible()
	{
		click(eleLowerDeductible);
		return this;
	}


	//Combustibility & Susceptibility  
	@FindBy(how=How.ID,using="rdoMultiComSus1")
	public static WebElement eleCombSusceptibility;
	public COpLObPages clickCombSusceptibility()
	{
		click(eleCombSusceptibility);
		return this;
	}
	//Transit & floating Equipment  
	@FindBy(how=How.ID,using="rdoMultiTranFE1")
	public static WebElement eleTransitFloatingEquip;
	public COpLObPages clickTransitFloatingEquip()
	{
		click(eleTransitFloatingEquip);
		return this;
	}
	//Construction  
	@FindBy(how=How.ID,using="rdoMultiConstruc1")
	public static WebElement eleConstruction;
	public COpLObPages clickConstruction()
	{
		click(eleConstruction);
		return this;
	}
	//External Exposure  
	@FindBy(how=How.ID,using="rdoMultiExteExp1")
	public static WebElement eleExternalExp;
	public COpLObPages clickExternalExp()
	{
		click(eleExternalExp);
		return this;
	}
	//Arrangement of Specific Insurance  
	@FindBy(how=How.ID,using="rdoMultiArrngSI1")
	public static WebElement eleArrangementOfSpecIns;
	public COpLObPages clickArrangementOfSpecIns()
	{
		click(eleArrangementOfSpecIns);
		return this;
	}
	//
	//Description
	@FindBy(how=How.ID,using="taNetCop")
	public static WebElement eleDesc;
	public COpLObPages enterDesc()
	{
		type(eleDesc, "TEST");
		return this;
	}
	//	/Calculate
	@FindBy(how=How.LINK_TEXT,using="Calculate")
	public static WebElement eleCalculate;
	public COpLObPages clickCalculate()
	{
		click(eleCalculate);
		return this;
	}
	//Next Button 
	@FindBy(how=How.LINK_TEXT,using="Rate")
	public static WebElement eleRate;
	public COpLObPages clickRate()
	{
		click(eleRate);
		return this;
	}
	//Rate Button 
	@FindBy(how=How.LINK_TEXT,using="Next")
	public static WebElement eleNext;
	public COpLObPages clickNext()
	{
		click(eleNext);
		return this;
	}
	//Continue with Rating
	@FindBy(how=How.LINK_TEXT,using="Continue with Rating")
	public static WebElement eleContRating;
	public COpLObPages clickContRating()
	{
		click(eleContRating);
		return this;
	}
	//Cancel Button
	@FindBy(how=How.LINK_TEXT,using="Cancel")
	public static WebElement eleCancel;
	public LocationsPage clickCancel()
	{
		click(eleCancel);
		return new LocationsPage(driver);
	}
	//Click on Edit Inland Marine LOb 
	@FindBy(how=How.LINK_TEXT,using="Edit COP LOB")
	public static WebElement eleEditCopLOB;
	public COpLObPages clickEditCopLob()
	{
		click(eleEditCopLOB);
		return this;
	}
}
