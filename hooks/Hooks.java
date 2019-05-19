package com.api.cucumber.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.api.cucumber.comMethods.ProjMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends ProjMethods{
	@Before
	public void before(Scenario sc) {
		System.out.println(sc.getName());
		System.out.println(sc.getId());
		startResult();
		startTestModule(sc.getName(), sc.getId());
		test = startTestCase(sc.getName());
		test.assignCategory("Regression");
		test.assignAuthor("Amirtha");
		startApp();
	}
	@After
	public void after(Scenario sc) {
		System.out.println(sc.getStatus());
		sc.write("FINISHED");
		if(sc.isFailed())
		{
			sc.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
//		closeAllBrowsers();
		endResult();
	}



}
