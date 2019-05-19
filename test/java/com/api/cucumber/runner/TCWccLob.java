package com.api.cucumber.runner;

import org.junit.runner.RunWith;

import com.api.cucumber.comMethods.ProjMethods;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/main/java/com/api/cucumber/featurefile/TcWcc_Lob.feature"},
		glue={"com.api.cucumber.pages","com.api.cucumber.readexcel","com.api.cucumber.testcases","com.api.cucumber.hooks","utils"},
		plugin={"pretty","html:./Cucumber_Reports"},monochrome=true)

public class TCWccLob extends ProjMethods {
	

}