package com.api.cucumber.testcases.Garage;

import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import com.api.cucumber.comMethods.ProjMethods;
import com.api.cucumber.pages.AccountInfoTabPage;
import com.api.cucumber.pages.LobDetailsPage;
import com.api.cucumber.pages.LocationsPage;
import com.api.cucumber.pages.LoginPage2;
import com.api.cucumber.pages.PolicyDetailsPage;
import com.api.cucumber.pages.PremiumSummaryPage;
import com.api.cucumber.pages.QuickLinksPage;
import com.api.cucumber.transform.ExcelDataToDataTable;

//To validate the Group A state scan edits validation for PF LOB VT state
public class TC001_Garage extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);

	
	@And("^Select Garage LOB \"([^\"]*)\"$")
	public void selectLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBGarage()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickLocation()
		.enterBillingDesc(data.get(9).get(3).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}
	@And("^Select Garage LOB in Agent \"([^\"]*)\"$")
	public void selectLobInAgent(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBGarage()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickLocation()
		.enterBillingDesc(data.get(9).get(3).toString())
		.clickLOBTab()
		.clickNextToLobDetails();
	}


	@Then("^Verify Work Loss Field, Med Expense Field, Med Expense DRopdown field is not available on State Input Screen for Garage \"([^\"]*)\"$") 
	public void verfifyPIPScreenforGarage(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPipSymbol()
		.selAddPipSymbol()
		.selPropVechicleNo()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext()
		.clickNext()
		.clickSelectCity()
		.clickPip()
		.clickPip()
		.checkPipScreen("Work Loss")
		.checkPipScreen("Med Expense")
		.checkPipScreen("Med Expense")
		.verifyAddlPIPLimit();
	}
	@Then("^Verify PIP limit Dropdown is default to SEE ENDT,disabled and select value from Add'l PIP limit dropdown for Garage \"([^\"]*)\"$") 
	public void verfifyPipForGarage(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPipSymbol()
		.selAddPipSymbol()
		.selPropVechicleNo()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext()
		.clickNext()
		.clickSelectCity()
		.verifyPIPLimit()
		.verifyAddlPIPLimit();
	}
	@Then("^Navigate to Garage LOB \"([^\"]*)\"$")
	public void checkGarageDeductible(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPipSymbol()
		.selAddPipSymbol()
		.selPropVechicleNo()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext();
		Thread.sleep(1000);
		lobPage
		.clickNext()
		.clickSelectInCity()
		.enterGarageClassCode()
		;
	}
	@Then("^Navigate to Garage LOB and select Med Pay and PIP \"([^\"]*)\"$")
	public void selMedPayPip(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPipSymbol()
		.selAddPipSymbol()
		.selMedPaySymbol()
		.selPropVechicleNo()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext();
		Thread.sleep(1000);
		lobPage
		.clickNext()
		.clickSelectInCity()
		.enterGarageClassCode()
		;
	}
	@Then("^Navigate to Garage LOB and select Collision and Comprehensive \"([^\"]*)\"$")
	public void selGarage(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPipSymbol()
		.selAddPipSymbol()
		.selComprehensive(data.get(5).get(4).toString())
		.enterCollision(data.get(5).get(5).toString())
		.selPropVechicleNo()
		//.clickUMSymbol()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext();
		Thread.sleep(1000);
		lobPage
		.clickNext()
		.clickSelectInCity()
		.enterGarageClassCode()
		;
	}
	@Then("^In Garage LOB \"([^\"]*)\"$")
	public void navToGRLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPropVechicleNo();
	}
	@Then("^In Garage LOB State Screen \"([^\"]*)\"$")
	public void navToGRLobStateScreen(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		//.clickUMSymbol()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext()
		.clickNext()
		.clickNext()
		.clickSelectInCity()
		.enterGarageClassCode()
		;
	}

	@And("^Edit Garage Lob$")
	public void editGarage()
	{
		lobPage
		.clickEditGarageLob();
	}

	@And("^Verify Pip applicability \"([^\"]*)\"$")
	public void verifyPipApplicability(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.clearAULiabilitySymbol()
		.clickNext()
		.checknotifictaion()
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.clickNext()
		.clickNext()
		;
	}
	@Then("^Add New Vehicle \"([^\"]*)\"$")
	public void addVehicle(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.clickVehicleSummary()
		.clickAddVehicle()
		.selectVehicleState(data.get(11).get(2).toString())
		.enterVIN(data.get(7).get(4).toString())
		.clickOverrideVINChk()
		.selVehYear(data.get(7).get(5).toString())
		.selVehMake(data.get(7).get(6).toString())
		.selVehModel(data.get(7).get(7).toString())
		.selVehType(data.get(11).get(0).toString())
		.selLeasedAuto(data.get(7).get(9).toString())
		.clickNext();
		;
	}
	@And("^Unselect PIP Coverage if selected by default$")
	public void unCheckPIP()
	{
		lobPage
		.clickPipCoverage()
		;
	}
	@Then("^Verify Pip Coverage is selected \"([^\"]*)\"$")
	public void checkPip(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.clickVehicleSummary()
		.clickNext()
		.clickOverrideVINChk()
		.selVehType(data.get(11).get(0).toString())
		.clickYes()
		;
	}
	@Then("^Navigate to Vehicle level Coverages Screen$")
	public void navigateToCov()
	{
		lobPage
		.clickVehicleSummary()
		.clickVehicleCov()
		;
	}
	@And("^Navigate to Garage LOB details page \"([^\"]*)\"$") 
	public void checkGarage(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selPropVechicleNo()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext()
		.clickNext()
		.clickSelectInCity()
		.enterGarageClassCode()
		.checkDeductible()
		.clickNext()
		.clickNext()
		.enterEmployeeFullTime()
		.clickNext()
		.clickNext()
		;
	}
	@And("^Generate Class Code \"([^\"]*)\"$")
	public void generateClassCode(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.selRadioGenerateClassCode()
		.selVehiclewt()
		.selVehicleUse()
		.selVehicleRadiusOfUse()
		.selSeatingCapRange()
		.typeSecClassCode("02")
		.selSchoolBusOwner()
		.selTaxiCabTypes()
		.selVehicleMechanicalLift()
		.selPptUse()
		.selTerritoryZone()
		.selTerminalZone()
		.clickBtnGenertaeClassCode()
		.clickNext()
		;
	}
	@And("^Select UM Coverage$")
	public void selectUMCoverage()
	{
		lobPage
		.clickUMCoverage();
	}
	@But("^Verify Vehicle weight field is not available on Class code information section$")
	public void checkVehicleWeight()
	{
		lobPage	
		.selRadioGenerateClassCode()
		.checkVehiclewt();
	}

	@And("^Navigate to Garage LOB details page and select Med Symbol \"([^\"]*)\"$") 
	public void checkGaragewithMedSym(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selMedPaySymbol()
		.selPropVechicleNo()
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.clickNext()
		.clickNext()
		.clickSelectInCity()
		.enterGarageClassCode()
		;
	}
	@And("^Change Med Pay Symbol$")
	public void changeMedPaySymbol()
	{
		lobPage
		.changeMedPaySymbol()
		;
	}
	@And("^Verify Medical Payments Type \"([^\"]*)\"$") 
	public void selMedicalPayments(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		//		.selectMedPayments(data.get(9).get(4).toString())
		.selectMedPayments(data.get(11).get(1).toString())
		//.selectMedPaymentsType(data.get(9).get(9).toString())
		.selectMedPaymentsType(data.get(11).get(2).toString())
		;
	}
	

	@And("^Navigate to Next Screen$")
	public void navNext() throws InterruptedException
	{
		lobPage
		.clickNext()
		.clickNext()
		.enterEmployeeFullTime()
		.clickNext();
Thread.sleep(1000);
		lobPage
		.clickNext()
		;
	}
	@And("^Select false Pretense Coverage in dealers Physical Damage Screen \"([^\"]*)\"$")
	public void selDealersPhysicalDamage(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.enterEmployeeFullTime()
		.clickDealersPhysicalDamage()
		.selFalsePretenseLimit(data.get(11).get(7).toString())
		.enterFalsePretenseValue(data.get(11).get(6).toString())
		.selFalsePretenseDeductible()
		;
	}
	@And("^Change False Pretense Coverage limit in dealers Physical Damage Screen \"([^\"]*)\"$")
	public void changefalsePretenseLimit(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.clickBuilding()
		.clickDealersPhysicalDamage()
		.selFalsePretenseLimit(data.get(11).get(7).toString())
		;
	}
	@And("^Select UM coverage Limit$")
	public void selUMCovValues() throws InterruptedException
	{
		lobPage
		.selDdlUMStackingY("Y")
		.clickChkBxIndividual()
		.clickNext()
		.clickNext()
		//.clickCityCountyInfoInPolicyScreen()
		.enterEmployeeFullTime()

		.clickNext();

		lobPage
		.clickNext()
		;
	}
	@Then("^Verify Driver Other car Coverage$")
	public void verifyWorkLossExclusion()
	{
		lobPage
		.clickNext()
		.clickCovDriveOtherCar()
		.enterNoOfIndividuals("10")
		.selDocCoverageType()
		.selDdlDocMedPayLimit()
		.clickNext()
		;
	}
	@Then("^Verify DOC Coverage$")
	public void verifyDoc()
	{
		lobPage
		.clickNext()
		.clickCovDriveOtherCar()
		.enterNoOfIndividuals("10")
		.selDocCoverageType()
		//.selDdlDocMedPayLimit()
		.clickNext()
		;
	}
	@And("^Enter Employee Full Time and Navigate next$")
	public void navigateNext()
	{
		lobPage
		.enterEmployeeFullTime()
		.clickNext()
		.clickNext()
		;
	}
	@Then("^Verify Med Pay coverage is available on Vehicle Optional Coverages Page$")
	public void selMedPayCov()
	{
		lobPage
		.selMedPayCoverage()
		//.clickNext()
		;
	}
	@And("^Select Liability Coverage$")
	public void selLiability()
	{
		lobPage
		.clickLiability()
		;
	}
	@And("^Enter Driver Information \"([^\"]*)\"$")
	public void enterDriverInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.clickNext()
		.clickBtnYes()
		.enterDriverName(data.get(9).get(5).toString())
		.enterDriverDob(data.get(9).get(6).toString())
		.selDriverLicenseState(data.get(9).get(7).toString()) 
		.enterDriverLicenseNo(data.get(9).get(8).toString())
		.clickNext()
		;
	}


}
