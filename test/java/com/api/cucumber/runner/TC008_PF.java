package com.api.cucumber.runner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-reports/CucumberTestReport.json",
        retryCount = 1,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-reports/cucumber-usage.json",
        usageReport = false,
        toPDF = true,
      //  excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@US36527_TC2" },
        outputFolder = "target/cucumber-reports/extended-report")
@CucumberOptions(
		features={"src/main/java/com/api/cucumber/featurefile/TC002_PFLobVTState.feature",
				"src/main/java/com/api/cucumber/featurefile/US#_PF_AL.feature",
				"src/main/java/com/api/cucumber/featurefile/PF_FL_NBIS.feature",
				"src/main/java/com/api/cucumber/featurefile/US#53677_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/US#27142_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint12/US#26815_PF_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint12/US#26815_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint12/US#27243_PF_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint12/US#27243_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint13/US#37244_37246_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint13/US_27142_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint13/US_27142_PF_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint13/US_27248_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint13/US_27248_PF_FL_Agent.feature",
				//"src/main/java/com/api/cucumber/featurefile/Sprint13/US_26865_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint13/US#37244_37246_PF_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint13/US#33776_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint13/US#33776_PF_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#28686_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#28686_PF_FL_Agent.feature"		,
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#43064_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#43064_PF_FL_Sec.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint15/US#43064_PF_ImpactAnalysis.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#66135_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#36527_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint16/US#36527_PF_FL_Agent.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint17/US#36477_PF_FL.feature",
				"src/main/java/com/api/cucumber/featurefile/Sprint17/US#80833_PF_FL.feature",
		},
		glue={"com.api.cucumber.pages","com.api.cucumber.readexcel","com.api.cucumber.testcases","com.api.cucumber.hooks","utils"},
		plugin={"rerun:rerun/failed_scenarios.txt",
		"html:target/CucumberReport"},
		monochrome=true,
		dryRun=false,
		tags="@US80833_TC5")

public class TC008_PF {

}
//true
//false


