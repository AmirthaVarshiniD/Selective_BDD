package com.api.cucumber.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/main/java/com/api/cucumber/featurefile/Auto_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/US_56561_Auto_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/US_56112_Auto_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/US_56112_Auto_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint14/US#20544_20549_21143_21269_20547_AU_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#21273_AU_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#21787_AU_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#21273_AU_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#20550_AU_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#28680_AU_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#58037_AU_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#21294_AU_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#21339_AU_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#29223_AU_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint17/US#21340_AU_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint17/US#21333_AU_FL.feature",
				
		},
		glue={"com.api.cucumber.pages","com.api.cucumber.readexcel","com.api.cucumber.testcases","com.api.cucumber.hooks","utils"},
		plugin={"rerun:rerun/failed_scenarios.txt",
		"html:target/CucumberReport"},
		tags="@US21333_TC2",
		monochrome=true,
		dryRun=false)


public class TC006_Auto {



}
//false