package com.api.cucumber.runner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "./target/cucumber-reports/CucumberTestReport.json",
        retryCount = 2,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "./target/cucumber-reports/cucumber-usage.json",
        usageReport = false,
        toPDF = true,
      //  excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@reg_200319" },
        outputFolder = "target/cucumber-reports/extended-report")
@CucumberOptions(
		features={"src/main/java/com/api/cucumber/featurefile/TC014_GL.feature",
				"src/main/java/com/api/cucumber/featurefile/TC008_GL_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint13/US#20511_20530_20517_GL_FL.feature",
		"src/main/java/com/api/cucumber/featurefile/Sprint13/US#20511_20530_20517_GL_FL_Agent.feature"},
		glue={"com.api.cucumber.pages","com.api.cucumber.readexcel","com.api.cucumber.testcases","com.api.cucumber.hooks","utils"},
		plugin={"rerun:rerun/failed_scenarios.txt",
		"html:target/CucumberReport"},
		tags="@Reg16",
		monochrome=true)


public class TC005_GL {



}
