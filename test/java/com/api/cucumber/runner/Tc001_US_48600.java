package com.api.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/main/java/com/api/cucumber/featurefile/TC_US#48600.feature"},
		glue={"com.api.cucumber.pages","com.api.cucumber.readexcel","com.api.cucumber.testcases","com.api.cucumber.hooks","utils"},
		plugin={"pretty","html:./Cucumber_Reports"},
		monochrome=true)

public class Tc001_US_48600 {

}
