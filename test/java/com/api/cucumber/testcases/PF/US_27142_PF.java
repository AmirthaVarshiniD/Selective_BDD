package com.api.cucumber.testcases.PF;

import java.util.List;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.ComLinesAutoSysPage;
import com.api.cucumber.pages.InlandMarinePages;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PFPage;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class US_27142_PF extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);
	InlandMarinePages ir = new InlandMarinePages(driver);
	ComLinesAutoSysPage com = new ComLinesAutoSysPage(driver);
	PFPage pf = new PFPage(driver);

	
	@And("^Change value in number of days dropdown and select value \"([^\"]*)\"$")
	public void change_value_in_number_of_days_dropdown_and_select_value(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable 
		{
			List<List<String>> data = table.raw();

			for(int i=0;i<data.size();i++){
				System.out.println(data.get(i).toString());
			}
		ir.clickEdit()
		  .clickNext();
		
		pf.clickExpandCityInformation();
		Thread.sleep(1000);
		pf.enterBasicGrp1Territory("001")
		.enterBasicGrp2Territory("001")
		.clickCityCounty()
		.typeClassCode(data.get(5).get(5).toString())
		//.enterTxt_ProMetrixClassOverrideReason("TEST")
		.selectConstruction(data.get(5).get(4).toString())
		//.enterTxt_ProMetrixConstOverrideReason("TEST")
		.enterYearBuilt(data.get(5).get(6).toString())
		//.enterProMetrixOverrideReason("TEST")
		.selectBuildingRateType(data.get(5).get(7).toString())
		//.selCauseOfLoss(data.get(7).get(5).toString())
		.clickNextBtn();
		
		 ir.clickNext();
		  //.clickNext();
		pf
		.selNoOfDaysCivlAuth(data.get(9).get(7).toString());
		ir.clickNext();
		
	    
	}
	@And("^Exit to Dashboard$")
	public void requote_the_policy() throws Throwable {
		com.clickBtnExitToDashBoard();
		
	    
	}
	@Then("^Verify user is able to select Business Income Educational Institution w/o Extra Expense \"([^\"]*)\"$")
	public void verify_user_is_able_to_select_Business_Income_Educational_Institution_w_o_Extra_Expense(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable 
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		
		pf
		.clickChkBxBuisnessIncEduInstExtraExpense()
		.clickEditInBiExtraExpense()
		.selectPrometrixSchedule()
		.clickEditInBiExtraExpense()
		.enterBuisIncEdInsLmt(data.get(9).get(4).toString())
		.typeLocationClassCode(data.get(5).get(5).toString())
		.selBuisIncEducInsCoInsurance(data.get(9).get(5).toString())
		;
	}
	@And("^Verify user is able to select Business Income with Extra Expense and able to select Civil authority increased coverage period \"([^\"]*)\"$")
	public void verify_user_is_able_to_select_Business_Income_with_Extra_Expense(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable 
		{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
	}
        pf
        .clickBuisnessIncomeWithExtraExpense()
        .clickBtnEditBIEE()
        .selectPrometrixSchedule()
        .clickBtnEditBIEE()
        .enterLimitBuisIncDepProp(data.get(9).get(4).toString())
        .selRiskType(data.get(5).get(10).toString())
        .enterClassCode(data.get(5).get(5).toString())
        .selIndemnityTpe(data.get(7).get(3).toString())
        .selDdMonthlyLimit(data.get(9).get(8).toString())
        .clickCivilAthIncCovPerdBIEE()
        .selNoOfDaysCivlAuthBIEE(data.get(9).get(6).toString());
        
        

	}
	@And("^Selecting PF LOB in agent  \"([^\"]*)\"$")
	public void selecting_PF_LOB_in_agent(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBPF()
		//.selectSICCoide(data.get(3).get(10).toString())
		//.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickNextButton();
//		.enterBillingDesc(data.get(5).get(1).toString())
//		.clickLOBTab()
//		.clickNextToLobDetails();  
	}
	@And("^Verify whether user is able to select Building Coverage and Business Personal Property Coverage \"([^\"]*)\"$")
	public void verify_whether_user_is_able_to_select_Building_Coverage(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		pf
		//.clickBuilding()
	    .clickBpp()
		.clickEditBpp()
		//.clickBtnEditBuilding()
		.selectPrometrixSchedule()
		.clickEditBpp();
		//.clickBtnEditBuilding();
		Thread.sleep(1000);
//		pf.enterBuildingLmt(data.get(9).get(4).toString())
//		  .typeBldngClassCode(data.get(5).get(5).toString())
//		 
		//  .clickChkBxTheftExcl()
		  //.clickNextBtn();
//		Thread.sleep(1000);
		pf.entertxtBPPLmt(data.get(9).get(4).toString())
		  .typeBppClassCode(data.get(5).get(5).toString())
		  //.clickChkBxTheftExcl()
		  .clickNextBtn();
		Thread.sleep(1000);
		
	}
	
	@And("^Verify the details in Renewal and Endorsement Issue \"([^\"]*)\"$")
	public void verify_the_details_in_Renewal_Issue(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
//		ir.clickEdit()
//		  .clickNext();
		
		pf.clickExpandCityInformation();
		Thread.sleep(1000);
		pf.enterBasicGrp1Territory("001")
		.enterBasicGrp2Territory("001")
		.clickCityCounty()
		.typeClassCode(data.get(5).get(5).toString())
		//.enterTxt_ProMetrixClassOverrideReason("TEST")
		.selectConstruction(data.get(5).get(4).toString())
		//.enterTxt_ProMetrixConstOverrideReason("TEST")
		.enterYearBuilt(data.get(5).get(6).toString())
		//.enterProMetrixOverrideReason("TEST")
		.selectBuildingRateType(data.get(5).get(7).toString())
		//.selCauseOfLoss(data.get(7).get(5).toString())
		.clickNextBtn();
		
		 ir.clickNext();
		 pf.enterBuildingLmt(data.get(9).get(4).toString())
		  .typeBldngClassCode(data.get(5).get(5).toString())
		   .clickNextBtn();
		Thread.sleep(1000);
		pf.entertxtBPPLmt(data.get(9).get(4).toString())
		  .typeBppClassCode(data.get(5).get(5).toString())
		  .clickNextBtn();
		Thread.sleep(1000);
		
	}


	


}
