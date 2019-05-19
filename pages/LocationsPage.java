package com.api.cucumber.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.api.cucumber.comMethods.ProjMethods;


public class LocationsPage extends ProjMethods{
	public LocationsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//input[@class='TextBox'][1]")
	public static WebElement eleBillingDesc;
	public LocationsPage enterBillingDesc(String data)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 70);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='TextBox'][1]")));	
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='TextBox'][1]")));	
			if(eleBillingDesc.isDisplayed()) {
				click(eleBillingDesc);	
			}
			else if(!eleBillingDesc.isDisplayed())
			{
				driver.navigate().refresh();
				click(eleBillingDesc);

			}
		}
		catch (WebDriverException e) {
			e.printStackTrace();
		}
		finally
		{
			type(eleBillingDesc, data);
		}
		return this;
	}
	//Edit Location
	@FindBy(how=How.LINK_TEXT,using="Edit Location")
	public static WebElement eleEditLocation;
	public LocationsPage clickEditLocation()
	{
		click(eleEditLocation);
		return this;
	}
	//Add New Location
	@FindBy(how=How.LINK_TEXT,using="Add New Location")
	public static WebElement eleAddNewLocation;
	public LocationsPage clickAddNewLocation()
	{
		click(eleAddNewLocation);
		return this;
	}
	//Delete
	@FindBy(how=How.LINK_TEXT,using="Delete")
	public static WebElement eleDelete;
	public LocationsPage clickDelete()
	{
		click(eleDelete);
		return this;
	}
	@FindBys(@FindBy(how=How.XPATH,using="//div[@class='threeColumnDivItem']/span/input"))
	List<WebElement> eleLOBSChkBox;
	public LocationsPage clickLOBTab()
	{
		for (WebElement ele : eleLOBSChkBox) 
		{
			if (!ele.isSelected()) {		
				ele.click();
			}
		}
		return this;

	}
	//Propert - Not Selected
	@FindBy(how=How.XPATH,using="(//input[@class='CheckBox'])[2]")
	public static WebElement eleChkBxPF;
	public LocationsPage checkPF(){
		try
		{
			if(eleChkBxPF.isDisplayed()) {				
				verifyNotSelected(eleChkBxPF);
			}


		}catch (WebDriverException e) {
			System.out.println("LOB Selected");
		}
		return this;
	}
	//Yes 
	@FindBy(how=How.XPATH,using="(//span[@class='ui-button-text'])[1]")
	public static WebElement eleBtnYes;
	public LocationsPage clickBtnYes(){
		try
		{
			if(eleBtnYes.isDisplayed()) {				
				click(eleBtnYes);
			}


		}catch (WebDriverException e) {
			System.out.println("Yes Button is not displayed");
		}
		return this;
	}
	//No 
	@FindBy(how=How.XPATH,using="(//span[@class='ui-button-text'])[2]")
	public static WebElement eleNo;
	public LocationsPage clickBtnNo(){
		try
		{
			if(eleNo.isDisplayed()) {				
				click(eleNo);
			}


		}catch (WebDriverException e) {
			System.out.println("Yes Button is not displayed");
		}
		return this;
	}

	//Add new location
	@FindBy(how=How.ID,using="btnAddLocation")
	public static WebElement eleAddLocation;
	public LocationsPage clickAddLocation()
	{
		click(eleAddLocation);
		return this;
	}
	@FindBy(how=How.XPATH,using="(//input[@class='TextBox'])[2]")
	public static WebElement eleAddress;
	public LocationsPage enterAddress(String data)
	{
		type(eleAddress, data);
		return this;
	}

	@FindBy(how=How.XPATH,using="(//select[@class='DropDownList'])[2]")
	public static WebElement eleSelectState;
	public LocationsPage selectState(String data)
	{
		try
		{
			if(eleSelectState.isEnabled())
			{
				selectDropDownUsingText(eleSelectState,data);
			}
		}
		catch (WebDriverException e) {
			e.printStackTrace();
		}
		finally
		{
			click(eleBtnSearch);
		}
		return this;
	}

	@FindBy(how=How.XPATH,using="//label[text()='City']/following-sibling::input")
	public static WebElement eleCity;
	public LocationsPage enterCity(String data)
	{
		type(eleCity, data);
		return this;
	}
	@FindBy(how=How.XPATH,using="//label[text()='Zip Code']/following-sibling::input")
	public static WebElement eleCityZipCode;
	public LocationsPage clearCityZipCode()
	{
		eleCityZipCode.clear();
		return this;
	}
	@FindBy(how=How.CLASS_NAME,using="btnGo")
	public static WebElement eleBtnSearch;
	public LocationsPage clickButtonSearch()
	{
		click(eleBtnSearch);
		return this;
	}


	@FindBy(how=How.XPATH,using="//a[@class='ButtonStyle8']/span/strong")
	public static WebElement eleSearch;
	public LocationsPage clickSearch()
	{
		click(eleSearch);
		return this;
	}



	@FindBy(how=How.XPATH,using="(//td[@class='sigi-grid-cell ']/div)[1]")
	public static WebElement eleSearchResult;
	public LocationsPage clickSearchResult()
	{
		click(eleSearchResult);
		return this;
	}

	@FindBy(how=How.XPATH,using="(//a[@class='ButtonStyle8'])[3]")
	public static WebElement eleBtnSelect;
	public LocationsPage clickSelect()
	{
		click(eleBtnSelect);
		return this;
	}
	//Address Validation  - check Box
	@FindBy(how=How.ID,using="chkOverride")
	public static WebElement eleChkBxOverride;
	public LocationsPage clickChkBxOverride()
	{
		driver.switchTo().frame("SIGI_DialogURL");
		click(eleChkBxOverride);
		return this;
	}
	//Ok Button - 
	@FindBy(how=How.ID,using="btnOK")
	public static WebElement eleBtnOk;
	public LocationsPage clickBtnOk()
	{
		click(eleBtnOk);
		driver.switchTo().defaultContent();
		return this;
	}
	@FindBy(how=How.XPATH,using="(//div[@class='ui-dialog-buttonset']/button)[2]")
	public static WebElement eleBtnNo;
	public LocationsPage clickNo()
	{
		//	driver.switchTo().frame("TooltipShim");
		try {
			if (eleBtnNo.isDisplayed()) {
				click(eleBtnNo);
			}
		} catch (WebDriverException e) {
			System.out.println("Not Available");
		}
		return this;
	}
	public LobDetailsPage clickNextToLobDetails()
	{
		driver.findElementByXPath("//a[@id='navForward']").click();
		return new LobDetailsPage(driver);
	}

	//Exit To DashBoard
	@FindBy(how=How.LINK_TEXT,using="Exit To Dashboard")
	public static WebElement eleExitToDashBoard;
	public ComLinesAutoSysPage clickExitToDashBoard()
	{
		try {
			Thread.sleep(2000);
			click(eleExitToDashBoard);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ComLinesAutoSysPage(driver);
	}
	//Dashboard
	@FindBy(how=How.LINK_TEXT,using="Dashboard")
	public static WebElement eleDashBoard;
	public ComLinesAutoSysPage clickDashBoard()
	{
		click(eleDashBoard);
		return new ComLinesAutoSysPage(driver);
	}
	//Add new address1
	@FindBy(how=How.XPATH,using="(//input[@class='TextBox'][1])[2]")
	public static WebElement eletxtAddress1;
	public LocationsPage enterTxtAddress1(String data)
	{
		eletxtAddress1.click();
		type(eletxtAddress1, data);
		return this;
	}

	//Add new address2
	@FindBy(how=How.XPATH,using="(//input[@class='TextBox'][1])[3]")
	public static WebElement eletxtAddress2;
	public LocationsPage enterTxtAddress2(String data)
	{
		eletxtAddress2.click();
		type(eletxtAddress2, data);
		return this;
	}

	@FindBy(how = How.CLASS_NAME, using = "TextBox") 
	public static WebElement eleBuildingDesc;

	public LocationsPage enetrDesc(String Desc) {
		click(eleBuildingDesc);
		type(eleBuildingDesc, Desc);
		return this;
	}

	@FindBy(how = How.ID, using = "CheckBox")
	public static WebElement eleLob;

	public LocationsPage clickLob() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();",
		// driver.findElement(By.name("001001$chkGL")));
		js.executeScript("arguments[0].click();", driver.findElement(
				By.xpath("//div[@class='fieldset itemContent']//div[2]//div[@class='threeColumnDivItem']//..//label")));

		return this;
	}

	@FindBy(how = How.ID, using = "CheckBox")
	public static WebElement eleLobGR;

	public LocationsPage clickLobGR() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//div[@class='threeColumnDivItem']//span//label")));
		// click(eleLob);

		return this;
	}

	// Add new loctaion
	@FindBy(how = How.ID, using = "btnAddLocation")
	public static WebElement eleAddLocationButton;

	public LocationsPage clickAddLocationButton() {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();",
		// driver.findElement(By.xpath("//div[@class='threeColumnDivItem']//span//label")));
		click(eleAddLocationButton);

		return this;
	}

	// Add address2
	@FindBy(how = How.NAME, using = "002001$txtStreet1")
	public static WebElement eleAddress1;

	public LocationsPage enterAddress1() {
		click(eleAddress1);
		type(eleAddress1, "901 2nd Ave N");

		return this;
	}

	// Add state

	@FindBy(how = How.NAME, using = "002001$ddlState")
	public static WebElement eleState;

	public LocationsPage selectState() {
		Select state = new Select(eleState);
		state.selectByValue("TN");

		return this;
	}

	// Add city

	@FindBy(how = How.NAME, using = "002001_txtCity") 
	public static WebElement eleCity2;
	@FindBy(how = How.XPATH, using = "//input[@id='002001_txtCity_cityName']")
	public static WebElement eleCityName;
	@FindBy(how = How.XPATH, using = "//a[@id='002001_txtCity_searchOK']")
	public static WebElement eleSearchCity;
	@FindBy(how = How.XPATH, using = "//table[@id='002001_txtCity_grid_grid']//tbody//tr[1]//td[1]")
	public static WebElement eleSelectCityName;
	@FindBy(how = How.XPATH, using = "//a[@id='002001_txtCity_listOK']")
	public static WebElement eleCitySelect;
	@FindBy(how = How.XPATH, using = "//input[@id='002001_txtCity_zipCode']")
	public static WebElement eleZipCodeCity;

	public LocationsPage enterCity() {
		click(eleCity2);
		type(eleCityName, "Nashville");
		type(eleZipCodeCity, "37201");
		click(eleSearchCity);
		click(eleSelectCityName);
		click(eleCitySelect);

		return this;
	}

	// Add zipcode
	@FindBy(how = How.NAME, using = "002001_txtZip_Zip5")
	public static WebElement eleZipcode;

	public LocationsPage enterZipCode() {
		type(eleZipcode, "37201");

		return this;
	}

	// Add country
	@FindBy(how = How.ID, using = "003001_txtCounty")
	public static WebElement eleCountry;

	public LocationsPage enetrCountry() {
		type(eleCountry, "Davidson");

		return this;
	}

	// Issue-Insure name
	@FindBy(how = How.XPATH,using="(//input[@class='TextBox'])[6]")
	public static WebElement eleInsuedName;
	public LocationsPage enterInsuredName() {
		click(eleInsuedName);
		type(eleInsuedName, "TEST");
		return this;
	}

	//Issue-FED id
	@FindBy(how = How.XPATH,using="(//input[@class='TextBox'])[7]")
	public static WebElement eleFedId;
	public LocationsPage enterFedId() {
		click(eleFedId);
		type(eleFedId, "F520187124");
		return this;
	}



}



