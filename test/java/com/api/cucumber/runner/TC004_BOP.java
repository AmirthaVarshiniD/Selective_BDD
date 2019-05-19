package com.api.cucumber.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//@Test(dataProvider="fetchData")
@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/main/java/com/api/cucumber/featurefile/TC013_Bop_Agent.feature"},
		glue={"com.api.cucumber.pages","com.api.cucumber.readexcel","com.api.cucumber.testcases","com.api.cucumber.hooks","utils"},
		plugin={"rerun:rerun/failed_scenarios.txt",
		"html:target/CucumberReport"},
		monochrome=true)


public class TC004_BOP {



}
