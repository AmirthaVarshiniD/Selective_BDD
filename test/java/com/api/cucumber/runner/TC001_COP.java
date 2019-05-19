package com.api.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-reports/CucumberTestReport.json",
        retryCount = 3,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-reports/cucumber-usage.json",
        usageReport = false,
        toPDF = true,
      //  excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@Reg190319" },
        outputFolder = "target/cucumber-reports/extended-report")
@CucumberOptions(
		features={"src/main/java/com/api/cucumber/featurefile/COP.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint11/US_59341_COP.feature",
		"src/main/java/com/api/cucumber/featurefile/Sprint13/US#59338_59336_COP_FL.feature"},
		glue={"com.api.cucumber.pages","com.api.cucumber.readexcel","com.api.cucumber.testcases","com.api.cucumber.hooks","utils"},
		plugin={"rerun:rerun/failed_scenarios.txt","html:target/CucumberReport"},
		monochrome=true,
		dryRun=false,
		tags="@Reg16"
		)

public class TC001_COP {

}
