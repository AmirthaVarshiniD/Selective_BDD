package com.api.cucumber.comMethods;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.java.en.Given;

public class BasicExtentReport {
	public static RemoteWebDriver driver;
	//builds a new report using the html template 
	ExtentHtmlReporter html;

	ExtentReports extent;
	//helps to generate the logs in test report.
	public static ExtentTest test, suiteTest;
	public String testCaseName, testNodes, testDescription, category, authors;

	@BeforeMethod
	public void beforeMethod(){
		//test = startTestCase(testNodes);
		test.assignCategory(category);
		test.assignAuthor(authors);
		//startApp();		
	}
	@BeforeTest
	public void startReport() {
		//testCaseName = "TC001";
		//testDescription="NEW TEST";
		authors = "Amirtha";
		category = "smoke";
	}
	@BeforeSuite
	public void startResult(){
		html = new ExtentHtmlReporter(System.getProperty("user.dir") +"/reports/result.html");
		html.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	//To add system or environment info by using the setSystemInfo method.
	//   extent.setSystemInfo("OS", OS);
	//extent.setSystemInfo("Browser", browser);

	//configuration items to change the look and feel
	//add content, manage tests etc
	/*html.config().setChartVisibilityOnOpen(true);
        html.config().setDocumentTitle("Extent Report Demo");
        html.config().setReportName("Test Report");
        html.config().setTestViewChartLocation(ChartLocation.TOP);
        html.config().setTheme(Theme.STANDARD);
        html.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");*/


	@BeforeClass
	public void testCase1() {
		//suiteTest = extent.createTest(testCaseName, testDescription);
		//test = 	suiteTest.createNode(testNodes);
		test = extent.createTest("TC001", "Pass");
		Assert.assertTrue(true);
	}
	@Given("StartApp")
	public void startAp()
	{
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://lttest1.selectiveinsurance.com/WebApplications/Enterprise/Authentication/Login.aspx");
		driver.findElementById("UserName").sendKeys("qa2_field");
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
		}
		else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
	}
}