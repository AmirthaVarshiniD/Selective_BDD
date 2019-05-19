package com.api.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/main/java/com/api/cucumber/featurefile/US_28113_EPL.feature" }, glue = {
		"com.api.cucumber.pages", "com.api.cucumber.readexcel", "com.api.cucumber.testcases", "com.api.cucumber.hooks",
		"utils" }, plugin = { "pretty", "html:./Cucumber_Reports" }, monochrome = true, tags="@user28113_TC06")

public class TC_EPLLob {

}
