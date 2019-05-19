package com.api.cucumber.comMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.api.cucumber.utils.Reporter;

public class CommonMethods extends Reporter {
	public static RemoteWebDriver driver;
	public String sUrl;
	public String lUrl;
	public Properties prop;
	public static String quoteNo;
	public static String no;
	public static String policyNo;
	public static String PolicyNum;
	public static String accName;
	public static String accountName;
	public static String acc_Name;
	
	public CommonMethods() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			
			lUrl = prop.getProperty("LTURL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startApp() {
		try{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//	driver.get("https://lttest1.selectiveinsurance.com/WebApplications/Enterprise/Authentication/Login.aspx?Application=eSelect&ReturnUrl=https://lthome.selectiveinsurance.com/WebApplications/EDS/eSelect/Home.aspx&Reason=-6");
			driver.get(lUrl);
			//driver.get("https://gbury-ltdev.selectiveinsurance.com/webapplications/enterprise/authentication/Login_Dev.aspx?Application=CLAS&ReturnUrl=http%3a%2f%2fclas-ltdev2.selectiveinsurance.com%2fwebclas%2fclas_start.asp");
			reportStep("The browser  launched successfully", "PASS");
		} catch (WebDriverException e) {			
			reportStep("The browser could not be launched", "FAIL");
		}
	}
	public void environmnet(String environment) {
		try {
			if (environment.equals("SLT")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// driver.get("https://sttest1.selectiveinsurance.com/WebApplications/Enterprise/Authentication/Login.aspx");
				driver.get(
						"https://gbury-ltdev.selectiveinsurance.com/webapplications/enterprise/authentication/Login_Dev.aspx?Application=CLAS&ReturnUrl=http%3a%2f%2fclas-ltdev2.selectiveinsurance.com%2fwebclas%2fclas_start.asp");
				reportStep("The browser  launched successfully", "PASS");
			} else {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// driver.get("https://sttest1.selectiveinsurance.com/WebApplications/Enterprise/Authentication/Login.aspx");
				driver.get(
						"https://lttest1.selectiveinsurance.com/WebApplications/Enterprise/Authentication/Login.aspx?Application=eSelect&ReturnUrl=https://lthome.selectiveinsurance.com/WebApplications/EDS/eSelect/Home.aspx&Reason=-6");
				reportStep("The browser  launched successfully", "PASS");
			}
		} catch (WebDriverException e) {
			reportStep("The browser could not be launched", "FAIL");
		}
	}
	/*public void launchApp() {
		try{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			//driver = new InternetExplorerDriver();
			File src = new File("C:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, src.getAbsolutePath());
			//caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
			driver =  new PhantomJSDriver(caps);
			//System.setProperty("phantomjs.binary.path", src.getAbsolutePath());

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.get("https://sttest1.selectiveinsurance.com/WebApplications/Enterprise/Authentication/Login.aspx");
			driver.get("https://gbury-ltdev.selectiveinsurance.com/webapplications/enterprise/authentication/Login_Dev.aspx?Application=CLAS&ReturnUrl=http%3a%2f%2fclas-ltdev2.selectiveinsurance.com%2fwebclas%2fclas_start.asp");
			reportStep("The browser  launched successfully", "PASS");
		} catch (WebDriverException e) {			
			reportStep("The browser could not be launched", "FAIL");
		}
	}*/


	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case("id"): return driver.findElementById(locValue);
			case("link"): return driver.findElementByLinkText(locValue);
			case("xpath"):return driver.findElementByXPath(locValue);
			case("name"): return driver.findElementByName(locValue);
			case("class"): return driver.findElementByClassName(locValue);
			case("tag"):return driver.findElementByTagName(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			String x = ""+ele.getText();
			reportStep("The data: "+data+" entered successfully in the field :"+x, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
	}
	public void typeKeys(WebElement ele, Keys key) {
		try {
			ele.clear();
			ele.sendKeys(key);
			String x = ""+ele;
			reportStep("The data: "+key+" entered successfully in the field :"+x, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+key+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+key+" in the field :"+ele, "FAIL");
		}
	}

	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			System.out.println(ele);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();

			reportStep("Clicked on  "+text, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("Could not be clicked on "+text, "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		} 
	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));	
			text = ele.getText();
			ele.click();			
			reportStep("The element :"+text+"  is clicked.", "PASS",false);
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "FAIL",false);
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :","FAIL",false);
		} 
	}

	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
			reportStep("The element: "+ele+" Text value: ", "PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
		return bReturn;
	}

	public String getTitle() {		
		String bReturn = "";
		try {
			bReturn =  driver.getTitle();
		} catch (WebDriverException e) {
			reportStep("Unknown Exception Occured While fetching Title", "FAIL");
		} 
		return bReturn;
	}
	

	public String getAttribute(WebElement ele, String attribute) {		
		String bReturn = "";
		try {
			bReturn=  ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		} 
		return bReturn;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			reportStep("The dropdown is selected with text "+value,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}

	}
	public void moveToElement(WebElement ele) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			reportStep("Element on Focus"+ele.getText(),"PASS");
		} catch (WebDriverException e) {
			reportStep("Element couldn't be focused", "FAIL");
		}

	}
	//Value not availble in drop down
	public void checkDropDownValue(WebElement ele, String value) {
		try {
			Select dropDownList = new Select(ele);
			List<WebElement> options = dropDownList.getOptions();
			for (WebElement allOptions : options) {
				if(!allOptions.getText().contains(value)) {
					reportStep("The dropdown doesn't have given value - "+value,"PASS");
				}
			}

		} catch (WebDriverException e) {
			reportStep("The dropdown has given value-"+value, "FAIL");
		}

	}
	public void selectedDropDownValue(WebElement ele) {
		String value = ele.getText();
		try {
			new Select(ele).getAllSelectedOptions();
			reportStep("The dropdown is selected with text "+value,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}

	}
	public void checkValuesInDropDownList(WebElement ele,String data)
	{
		new Select(ele);
		List<WebElement> allOptions = new Select(ele).getOptions();
		for (WebElement options : allOptions){
			if (!options.getText().contains(data))
			{
				System.out.println("No such value availble i dropdown");
				reportStep("The dropdown doesn't have the mentioned value "+data,"PASS");
				break;
			}
		}
	}

	public void allDropDownValues(WebElement ele)
	{
		try {
			List<WebElement> allOptions = new Select(ele).getOptions();
			for (WebElement options : allOptions)
			{
				String text = options.getText();
				System.out.println(options.getText());
				reportStep("The dropdown Options are:"+ text,"PASS");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			reportStep("The dropdown is selected with index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		} 

	}

	public boolean verifyTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		} 
		return bReturn;
	}

	public void getTextValue(WebElement ele) {
		ele.getText();
		reportStep("The text: "+getText(ele),"PASS");


	}
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).equals(expectedText)) {
				reportStep("The text: "+getText(ele)+" matches with the value :"+expectedText,"PASS");
			}else {
				reportStep("The text "+getText(ele)+" doesn't matches the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				reportStep("The expected text contains the actual "+expectedText,"PASS");
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 
	}
	public void verifyPartialTextNotAvailable(WebElement ele, String expectedText) {
		try {
			if(!getText(ele).contains(expectedText)) {
				reportStep("The expected text doesn't contains the actual "+expectedText,"PASS");
			}else {
				reportStep("The expected text contain the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).equals(value)) {
				reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"PASS");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		} 

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).contains(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"PASS");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		}
	}
	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				reportStep("The element "+ele+" is selected","PASS");
			} else {
				reportStep("The element "+ele+" is not selected","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}
	public void verifyNotSelected(WebElement ele) {
		try {
			if(!ele.isSelected()) {
				reportStep("The element "+ele+" is Not selected","PASS");
			} else {
				reportStep("The element "+ele+" is selected","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}

	
	public void verifyEnabled(WebElement ele) {
		try {
			if(ele.isEnabled()) {
				reportStep("The element "+ele+" is enabled","PASS");
			} else {
				reportStep("The element "+ele+" is not enabled","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}
	public void verifyNotEnabled(WebElement ele) {
		try {
			if(!ele.isEnabled()) {
				reportStep("The element "+ele+" is not enabled","PASS");
			} else {
				reportStep("The element "+ele+" is enabled","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				reportStep("The element "+ele+" is visible","PASS");
			} else {
				reportStep("The element "+ele+" is not visible","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}
	public void verifyNotDisplayed(WebElement ele) {
		try {
			if(!ele.isDisplayed()) {
				reportStep("The element "+ele+" is not visible","PASS");
			} else {
				reportStep("The element "+ele+" is visible","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not move to the given window by index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportStep("switch In to the Frame "+ele,"PASS");
		} catch (NoSuchFrameException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}

	public void acceptAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}  
	}

	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			reportStep("The alert "+text+" is dismissed.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 

	}

	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
		return text;
	}

	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}
	public static void writeXLSXFile() throws IOException {
		try {
			File dataSheet = new File(".\\TestData\\AccountInfo.xlsx");
			FileInputStream file = new FileInputStream(dataSheet);

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell = null;

			//Update the value of cell
			cell = sheet.getRow(1).getCell(2);
			cell.setCellValue(accountName);

			file.close();

			FileOutputStream outFile =new FileOutputStream(dataSheet);
			workbook.write(outFile);
			outFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","PASS", false);
		} catch (Exception e) {
			reportStep("The browser could not be closed","FAIL", false);
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed","PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","FAIL", false);
		}
	}

}
