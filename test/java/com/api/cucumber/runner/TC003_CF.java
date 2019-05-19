package com.api.cucumber.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/main/java/com/api/cucumber/featurefile/US_30557_FL_CF.feature",
		"src/main/java/com/api/cucumber/featurefile/US_30557_FL_CF_Agent.feature",
		"src/main/java/com/api/cucumber/featurefile/Sprint12/US_45636_FL_CF.feature"},
		glue={"com.api.cucumber.pages","com.api.cucumber.readexcel","com.api.cucumber.testcases","com.api.cucumber.hooks","utils"},
		plugin={"rerun:rerun/failed_scenarios.txt",
		"html:target/CucumberReport"},
		tags="@US30557_TC1",
		monochrome=true)


public class TC003_CF {



}
