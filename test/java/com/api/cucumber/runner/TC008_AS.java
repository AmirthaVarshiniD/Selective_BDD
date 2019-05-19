package com.api.cucumber.runner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-reports/CucumberTestReport.json",
        retryCount = 2,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-reports/cucumber-usage.json",
        usageReport = false,
        toPDF = true,
      //  excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@US58037_TC5" },
        outputFolder = "target/cucumber-reports/extended-report")
@CucumberOptions(
		features={"src/main/java/com/api/cucumber/featurefile/Sprint11/US_59390_AS_FL.feature",
		"src/main/java/com/api/cucumber/featurefile/Sprint13/US#34861_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint14/US#20544_20549_21143_21269_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint14/US#20547_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint14/US#65782_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint14/US#65782_AS_FL_MultiState.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#21273_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#21273_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#21787_AS_FL_MultiState.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#20550_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#28680_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#58037_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#21294_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#21339_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#29223_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint17/US#21340_AS_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint17/US#21333_AS_FL.feature",
		},
		glue={"com.api.cucumber.pages","com.api.cucumber.readexcel","com.api.cucumber.testcases","com.api.cucumber.hooks","utils"},
		plugin={"rerun:rerun/failed_scenarios.txt",
		"html:target/CucumberReport"},
		tags="@US21333_TC7", //GLLCUftdev033
		dryRun=false,
		monochrome=true)


public class TC008_AS {

//true
	//false

}
