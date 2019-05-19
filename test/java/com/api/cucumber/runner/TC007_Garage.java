package com.api.cucumber.runner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-reports/CucumberTestReport.json",
        retryCount = 0,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-reports/cucumber-usage.json",
        usageReport = false,
        toPDF = true,
      //  excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@US29218_TC2" },
        outputFolder = "target/cucumber-reports/extended-report")
@CucumberOptions(
		features={"src/main/java/com/api/cucumber/featurefile/Garage_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/US_56561_Garage_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint11/US_59390_Garage_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/US_56112_Garage_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint14/US#20544_20549_21143_21269_Garage_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint14/US#20547_Garage_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint14/US#65782_Garage_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint14/US#22525_Garage_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#21273_GARAGE_FL.feature"		,
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#21787_GARAGE_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#20550_GARAGE_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#28680_GARAGE_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#58037_GARAGE_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#29218_Garage_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#21294_GARAGE_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#21339_GARAGE_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#29223_GARAGE_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint17/US#21340_GARAGE_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint17/US#21333_GARAGE_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint17/US#57516_GARAGE_FL.feature",
				
		},
		glue={"com.api.cucumber.pages","com.api.cucumber.readexcel","com.api.cucumber.testcases","com.api.cucumber.hooks","utils"},
		plugin={"rerun:rerun/failed_scenarios.txt",
		"html:target/CucumberReport"},
		tags="@US57516_TC6",
		dryRun=false,
		monochrome=true)


public class TC007_Garage {

//true
	//false

}
