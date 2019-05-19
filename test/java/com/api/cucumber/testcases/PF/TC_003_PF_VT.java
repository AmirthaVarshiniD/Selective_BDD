package com.api.cucumber.testcases.PF;

import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PFPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

//Given PF LOB with Selective Insurance Company of South East effective  10/01/19 and market segment as Govermental
public class TC_003_PF_VT extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	PFPage pf = new PFPage(driver);


	@And("^Select LOB PF \"([^\"]*)\"$")
	public void policyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.enterYear(data.get(3).get(5).toString());
	}
	@And("Select Market segment as (.*)")
	public void selectmarketsegment(String data){

		policyDetails
		.selectrMarketSegment(data);
	}
	@And("^Select Insurance company is Selective Insurance Company of South East \"([^\"]*)\"$")
	public void selectInsComp(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectInsComp(data.get(3).get(7).toString())
		.findListOfInsComp()
		.selectLOBPF();
	}

	@And("Select SIC Code as (.*)")
	public void selectSICCode(String data){
		policyDetails
		.selectSICCoide(data);
	}

	@And("^Navigate to PF LOB \"([^\"]*)\"$")
	public void pfLobDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
			
		pf
		.selPredCauseOfLoss(data.get(7).get(5).toString())
		.selLossFreeYears(data.get(5).get(0).toString())
		.selPLExtnOptions(data.get(5).get(1).toString());
		//.clickNextBtn();
	}
	
	@And("^Navigate to LOB details page \"([^\"]*)\"$")
	public void lobDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		locPage
		.enterBillingDesc(data.get(7).get(10).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
		
		pf
		.selPredCauseOfLoss(data.get(7).get(5).toString())
		.selLossFreeYears(data.get(5).get(0).toString())
		.selPLExtnOptions(data.get(5).get(1).toString());
		//.clickNextBtn();
	}
	@And("^Navigate to Location page and change city \"([^\"]*)\"$")
	public void changeCity(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		locPage
		.enterBillingDesc(data.get(7).get(10).toString())
		.clickLOBTab()
		.clickButtonSearch()
		.enterCity(data.get(9).get(10).toString())
		.clearCityZipCode()
		.clickSearch()
		.clickSearchResult()
		.clickSelect()
		.clickChkBxOverride()
		.clickBtnOk()		
		.clickNextToLobDetails();
		
		pf
		.selPredCauseOfLoss(data.get(7).get(5).toString())
		.selLossFreeYears(data.get(5).get(0).toString())
		.selPLExtnOptions(data.get(5).get(1).toString());
		//.clickNextBtn();
	}
	@And("^Verify FLAT option is not displaying in Building Coinsurance and Business Personal Property Coinsurance fields \"([^\"]*)\"$")
	public void checkCoinsurance(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		.checkBuildingCoinsurance("FLAT")
		.checkBppCoinsurance("FLAT")
		;
	}

}
