package com.api.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/main/java/com/api/cucumber/featurefile/IR.feature",
				"src/main/java/com/api/cucumber/featurefile/PF_FL_NBIS.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint11/US_24563_IR.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint11/US_24563_IR_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint11/US_24584_IR.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint11/US_24584_IR_MultiState.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint11/US_24584_IR_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint12/US#24645_61590_IR.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint12/US#26815_61590_IR_MultiState.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint12/US#24645_61590_IR_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint12/US#48444_IR_GL.feature"},
		glue={"com.api.cucumber.pages","com.api.cucumber.readexcel","com.api.cucumber.testcases","com.api.cucumber.hooks","utils"},
		plugin={"rerun:rerun/failed_scenarios.txt","html:target/CucumberReport"},
		monochrome=true,
		dryRun=false,
		tags="@US24645_61590_TC4"
		)

public class TC002_IR {

}
//false