package com.api.cucumber.testcases.Auto;

import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
public class TC001_Auto extends ProjMethods {


	LoginPage2 login = new LoginPage2();
	QuickLinksPage quickLinks = new QuickLinksPage(driver);
	AccountInfoTabPage accInfo = new AccountInfoTabPage(driver);
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	LocationsPage locPage = new LocationsPage(driver);
	LobDetailsPage lobPage = new LobDetailsPage(driver);
	PremiumSummaryPage premiumPage= new PremiumSummaryPage(driver);







	@And("^Select AUTO LOB \"([^\"]*)\"$")
	public void policyDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBAuto()
		.selectSICCoide(data.get(3).get(10).toString())
		.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		//.clickNext()
		//.clickLocation()		
		//		/.enterBillingDesc("TEST")
		.clickLobDetails()
		//		/.clickNextToLobDetails()
		;

	}
	@And("^Select AUTO LOB in Agent \"([^\"]*)\"$")
	public void policyDetailsAgent(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		policyDetails
		.selectLOBAuto()
		//.selectSICCoide(data.get(3).get(10).toString())
		//.selectMarijuanaQuest()
		.selectPriorCarrier(data.get(5).get(0).toString())
		.clickNext()
		.clickNextButton();

	}
	@And("^Navigate to Auto LOB page \"([^\"]*)\"$") 
	public void lobDetails(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage		
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString())
		.selComprehensive(data.get(5).get(4).toString())
		.enterCollision(data.get(5).get(5).toString())
		.selPropVechicleNo()
		.selLossFreeYears(data.get(5).get(6).toString())
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.selAutoExtnOptions(data.get(5).get(8).toString())
		.clickNext();
	}
	@And("^Navigate to Auto LOB details page \"([^\"]*)\"$") 
	public void checkAutoStateInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
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
		.clickUMSymbol()
		.selLossFreeYears(data.get(5).get(6).toString())
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.selAutoExtnOptions(data.get(5).get(8).toString())
		.clickNext()
		.clickSelectInCity()
		;
	}
	@And("^Navigate to Auto LOB details page and Select PIP,Med Pay \"([^\"]*)\"$") 
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
		//.selComprehensive(data.get(5).get(4).toString())
		//.enterCollision(data.get(5).get(5).toString())
		.selPropVechicleNo()
		.clickUMSymbol()
		.selLossFreeYears(data.get(5).get(6).toString())
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.selAutoExtnOptions(data.get(5).get(8).toString())
		.clickNext()
		.clickSelectInCity()
		;
	}
	@And("^Navigate to Auto LOB details page and select Comprehensive and collision \"([^\"]*)\"$") 
	public void checkAutoLobStateInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
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
		.clickUMSymbol()
		.selLossFreeYears(data.get(5).get(6).toString())
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.selAutoExtnOptions(data.get(5).get(8).toString())
		.clickNext()
		.clickSelectInCity()
		;
	}
	@And("^Navigate to Auto State Information and Enter Comprehensive and Collision Values \"([^\"]*)\"$") 
	public void enterCompCollison(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.clickPrimaryHiredCar()
		.enterTxtPrimaryHiredLiability("950000")
		.enterComprehensiveValue(data.get(5).get(9).toString())
		.selAutoComDed(data.get(5).get(10).toString())
		.enterComprehensiveCostHire(data.get(7).get(0).toString())
		.enterCollisionValue(data.get(7).get(1).toString())
		.selAutoCollisionDed(data.get(7).get(2).toString())		
		.enterCollisionCostHire(data.get(7).get(3).toString())
		;
	}
	@And("^Enter State OverRides Value$")
	public void enterStateOverRidesValue()
	{
		lobPage
		.clickStateOverRides()
		.enterTxtStateOverRidesLiability("1000")
		.enterTxtStateOverRidesPhysicalDamage("100")
		;
	}
	@And("^Navigate to Auto LOB \"([^\"]*)\"$") 
	public void NavigateToAutoLob(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.enterAULiabilitySymbol(data.get(5).get(1).toString())
		.selLiabilityLimit(data.get(5).get(2).toString())
		.selLiabilityDedType(data.get(5).get(3).toString());
	}
	@And("^Navigate to Auto LOB State Level Screen \"([^\"]*)\"$") 
	public void NavigateToAutoLobStateScreen(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage
		.selPropVechicleNo()
		.clickUMSymbol()
		.selLossFreeYears(data.get(5).get(6).toString())
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.selAutoExtnOptions(data.get(5).get(8).toString())
		.clickNext()
		.clickSelectInCity()
		;
	}
	@And("^Select Specified Perils$")
	public void selSpecifiedPerils()
	{
		lobPage
		.selSelectPerils()
		;
	}
	@And("^Select GR Specified Perils$")
	public void selGRSpecifiedPerils()
	{
		lobPage
		.selGRSelectPerils()

		;
	}
	@And("^Select Covergae Spec Perils \"([^\"]*)\"$")
	public void selCoverageSpecPerils(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.clickSpecPerils(data.get(9).get(3).toString(),data.get(9).get(4).toString())
		;
	}

	@And("^Navigate to Auto State Information \"([^\"]*)\"$") 
	public void autoStateInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.clickSelectInCity()
		.clickPrimaryHiredCar()
		.enterComprehensiveValue(data.get(5).get(9).toString())
		.selAutoComDed(data.get(5).get(10).toString())
		.enterComprehensiveCostHire(data.get(7).get(0).toString())
		.enterCollisionValue(data.get(7).get(1).toString())
		.selAutoCollisionDed(data.get(7).get(2).toString())		
		.enterCollisionCostHire(data.get(7).get(3).toString())
		.clickNext()
		.clickNext();
	}

	@When("^Selecting Med Pay Symbol$")
	public void selMedPay()
	{
		lobPage
		.selMedPaySymbol()
		;
	}

	@And("^Verify Pip Deductible$") 
	public void checkDeductible()
	{
		lobPage		
		.checkDeductible();
	}
	@Then("^Verify Stacking is not displayed on State level Screen$") 
	public void verifyStackingInPip()
	{
		lobPage		
		.checkPipStackingNotDisplayed();
	}
	@And("^Verify Additional Pip limit \"([^\"]*)\"$") 
	public void verifyAddlnPip(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.clickExtendedPip()
		.verifyDdlAddlnPipLimit(data.get(11).get(1).toString()) //25,000 //10,000 //40,000 //90,000
		;
	}
	@And("Select UM coverage-Stacking value as Y")
	public void selStackingYInUMCoverage()
	{
		lobPage		
		.selDdlUMStackingY("Y")
		;
	}
	@And("Select Individual Checkbox in UM")
	public void selChkBxIndividual()
	{
		lobPage		
		.clickChkBxIndividual()
		;
	}
	@And("Select UM coverage-Stacking value as N")
	public void selStackingNInUMCoverage()
	{
		lobPage		
		.selDdlUMStackingN()
		;
	}
	@And("^Navigating to next Screen$") 
	public void navnext()
	{
		lobPage	
		.clickNext()
		.clickOkButton()
		.clickNext();
	}
	@And("^Moving to next Screen$") 
	public void movnext()
	{
		lobPage	
		.clickNext()
		;
	}
	@When("^Navigate to Vehicles and Drivers Screen \"([^\"]*)\"$") 
	public void vehiclesDriverInfo(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.selVechicleAddedYes()
		.selDriverAddedYes()
		.clickNext()
		.clickOkInAutoDataPrefill()
		.selectVehicleState(data.get(1).get(4).toString())
		.enterVIN(data.get(7).get(4).toString())
		.clickOverrideVINChk()
		.selVehYear(data.get(7).get(5).toString())
		.selVehMake(data.get(7).get(6).toString())
		.selVehModel(data.get(7).get(7).toString())
		.selVehType(data.get(7).get(8).toString())
		.selLeasedAuto(data.get(7).get(9).toString())
		.clickNext();
	}

	@When("^In Vehicles and Drivers Screen \"([^\"]*)\"$")
	public void vehTypeWithFreeFormType(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.selVechicleAddedYes()
		.selDriverAddedYes()
		.clickNext()
		.enterVIN(data.get(7).get(4).toString())
		.clickOverrideVINChk()
		.selVehYear(data.get(7).get(5).toString())
		.selVehMake(data.get(7).get(6).toString())
		.selVehModel(data.get(7).get(7).toString())
		.selVehType(data.get(7).get(8).toString())
		.selFreeFormType(data.get(9).get(4).toString())
		.selLeasedAuto(data.get(7).get(9).toString())
		.clickNext();
	}
	@And("^Verify the user is able to navigate from Vehicle class code screen through validation class code \"([^\"]*)\"$") 
	public void enterClassCode(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.selRadioEnterClassCode()
		.enterAUClassCode(data.get(7).get(10).toString())
		.clickValidateClassCode()
		.clickEdit()
		.selVehicleMechanicalLift()
		.clickBtnValidateClassCode()
		.clickNext()
		;

	}
	@Then("^Validate options for Deductible field in collision section under Mobile Equipment panel \"([^\"]*)\"$") 
	public void validateDeductibleOptInColl(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.clickSelectCity()
		.clickPrimaryHiredCar()
		.clickMobEquCostOfHire()
		.verifyOptionsInMobCollDeductible();
	}
	@Then("^Validate options for Deductible field in Comprehensive section under Mobile Equipment panel \"([^\"]*)\"$") 
	public void validateDeductibleOptInComp(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.clickSelectCity()
		.clickPrimaryHiredCar()
		.clickMobEquCostOfHire()
		.verifyOptionsInMobCompDeductible();

	}
	@Then("^Verify PIP limit Dropdown is default to SEE ENDT,disabled and select value from Add'l PIP limit dropdown \"([^\"]*)\"$") 
	public void verfifyPip(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
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
		.selLossFreeYears(data.get(5).get(6).toString())
		//.selAutoLossRatedInd(data.get(5).get(7).toString())
		.selAutoExtnOptions(data.get(5).get(8).toString())
		.clickNext()
		.clickSelectCity()
		.verifyPIPLimit()
		.verifyAddlPIPLimit();
	}


	@Then("^Verify the user is able to navigate from Vehicle class code screen  through Generate class code functionality \"([^\"]*)\"$") 
	public void verifyGenerateClassCode(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.selRadioGenerateClassCode()
		.selVehiclewt()
		.selVehicleUse()
		.selVehicleRadiuswt(data.get(9).get(1).toString())
		//.selSeatingCapRange(data.get(9).get(2).toString())
		//.enterSecondaryClassCode()
		.typeSecClassCode("21")
		//.enterTowingUse()
		.clickBtnGenertaeClassCode()
		//.clickClassCode()
		//.clickClassCode()
		.clickNext();
	}
	@Then("^Verify the user is able to navigate from Vehicle class code screen  through Generate class code \"([^\"]*)\"$")
	public void verifyGenClassCode(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.selRadioGenerateClassCode()
		.selVehicleRadiuswt(data.get(9).get(1).toString())
		.selSeatingCapRange()
		//.selSchoolBusOwner()
		.selVehicleMechanicalLift()
		.clickBtnGenertaeClassCode()
		.clickClassCode()
		.clickClassCode()
		.clickNext();
	}
	@Then("^Verify Generate class code \"([^\"]*)\"$")
	public void validateGenerateClassCode(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
		lobPage	
		.selRadioGenerateClassCode()
		.selVehicleRadiuswt(data.get(9).get(1).toString())
		.selSeatingCapRange()
		.selVehicleMechanicalLift()
		.clickBtnGenertaeClassCode()
		.clickClassCode()
		.clickClassCode()
		.clickNext();
	}


	@Then("^Verify Vehicle weight field is available on Class code information section \"([^\"]*)\"$")
	public void verifyVehicleWeight(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		lobPage	
		.selRadioGenerateClassCode()
		.selVehiclewt()
		.clickBtnGenertaeClassCode()
		.clickClassCode()
		.clickClassCode()
		.clickNext()
		;
	}
	@Then("^Verify Generate class code for vehicle type 28 \"([^\"]*)\"$")
	public void verifyGarageClassCode(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		lobPage	
		.selRadioGenerateClassCode()
		.selDrivertrn(data.get(9).get(4).toString())
		.clickBtnGenertaeClassCode()
		.clickClassCode()
		.clickClassCode()
		.clickNext()
		;
	}
	@Then("^Verify generate class code on Class code information section \"([^\"]*)\"$")
	public void checkGenClassCode(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		lobPage	
		.selRadioGenerateClassCode()
		.clickBtnGenertaeClassCode()
		.clickClassCode()
		.clickClassCode()
		.clickNext()
		;
	}
	@Then("^Verify generate class code functiona;ity for vehicle type 13 \"([^\"]*)\"$")
	public void verifyClassCode(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
	{
		List<List<String>> data = table.raw();

		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}

		lobPage	
		.selRadioGenerateClassCode()
		.selVehicleRadiuswt(data.get(9).get(1).toString())
		.selTaxiCabTypes()
		.selVehicleMechLift(data.get(9).get(5).toString())
		.clickBtnGenertaeClassCode()
		.clickClassCode()
		.clickClassCode()
		.clickNext()
		;
	}
	@Then("^Verify Work Loss Field, Med Expense Field, Med Expense DRopdown field is not available on State Input Screen \"([^\"]*)\"$") 
	public void verfifyPIPScreen(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable
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
		.selLossFreeYears(data.get(5).get(6).toString())
		.selAutoLossRatedInd(data.get(5).get(7).toString())
		.selAutoExtnOptions(data.get(5).get(8).toString())
		.clickNext()
		.clickSelectCity()
		.clickPip()
		.clickPip()
		.checkPipScreen("Work Loss")
		.checkPipScreen("Med Expense")
		.checkPipScreen("Med Expense")
		.verifyAddlPIPLimit();
	}



}
