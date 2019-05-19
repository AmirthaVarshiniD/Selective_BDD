package com.api.cucumber.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.api.cucumber.comMethods.ProjMethods;


public class PFPage extends ProjMethods {
	PolicyDetailsPage policyDetails = new PolicyDetailsPage(driver);
	public PFPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//Building Coinsurance - PF
	@FindBy(how=How.ID,using="ddlpfpolbldgcoins")
	public static WebElement eleBuildingCoinsurance;
	public PFPage checkBuildingCoinsurance(String data) throws InterruptedException{
		click(eleBuildingCoinsurance);
		Thread.sleep(3000);
		verifyPartialTextNotAvailable(eleBuildingCoinsurance, data);
		//selectDropDownUsingText(eleBuildingCoinsurance, data);
		return this;
	}
	//BPP Coinsurance - PF
	@FindBy(how=How.ID,using="ddlpfpolbppcoins")
	public static WebElement eleBppCoinsurance;
	public PFPage checkBppCoinsurance(String data) throws InterruptedException{
		click(eleBppCoinsurance);
		Thread.sleep(3000);
		verifyPartialTextNotAvailable(eleBppCoinsurance, data);
		//selectDropDownUsingText(eleBuildingCoinsurance, data);
		return this;
	}
	//Loss free Year
	@FindBy(how=How.ID,using="ddlLossFreeYr")
	public static WebElement eleLossFreeYears;
	public PFPage selLossFreeYears(String data){
		selectDropDownUsingText(eleLossFreeYears, data);
		return this;
	}

	// Predominant cause of Loss 
	@FindBy(how=How.ID,using="ddlPFPolCol")
	public static WebElement elePredCauseOfLoss;
	public PFPage selPredCauseOfLoss(String data){
		selectDropDownUsingText(elePredCauseOfLoss, data);
		return this;
	}

	//Building Attributes - PF
	@FindBy(how=How.ID,using="cboPfConstSym")
	public static WebElement eleConstruction;
	public PFPage selectConstruction(String data){
		selectDropDownUsingText(eleConstruction, data);
		return this;
	}
	//Year Built -PF
	@FindBy(how=How.ID,using="txtPfYearConstr")
	public static WebElement eleYearBuilt;
	public PFPage enterYearBuilt(String data){
		type(eleYearBuilt, data);
		return this;
	}


	//Building rate Type
	@FindBy(how=How.ID,using="cboPfBgiRateTyp")
	public static WebElement elePfBuildingRateType;
	public PFPage selectBuildingRateType(String data){
		selectDropDownUsingText(elePfBuildingRateType, data);
		return this;
	}
	//Estimation reason 
	@FindBy(how=How.ID,using="txtEstimateReason")
	public static WebElement eleEstimationReason;
	public PFPage enterEstimationReason(String data){
		try
		{
			if(eleEstimationReason.isDisplayed())
			{			
				type(eleEstimationReason, data);	
			}
			else if(!eleEstimationReason.isDisplayed())
			{			
				System.out.println("Not Available");
			}
		}
		catch (WebDriverException e) {
			e.printStackTrace();
		}
		finally
		{
			policyDetails.getQuoteNo();
		}
		return this;
	}
	//Cause Of Loss
	@FindBy(how=How.ID,using="cboLocCol")
	public static WebElement eleCauseOfLoss;
	public PFPage selLocationCauseOfLoss(String data){
		selectDropDownUsingText(eleCauseOfLoss, data);
		return this;
	}
	//Wind/Hail Deductible cboPfWindInd
	@FindBy(how=How.ID,using="cboPfWindInd")
	public static WebElement eleWindHailDeductible;
	public PFPage SelWindHailDeductible(String data){
		selectDropDownUsingText(eleWindHailDeductible,data);
		return this;
	}
	//Alternate Power Generation No radPfEBAltPowerIndN
	@FindBy(how=How.ID,using="radPfEBAltPowerIndN")
	public static WebElement eleAlternatePowerGenerationNo;
	public PFPage clickcAlternatePowerGenerationNo(){
		click(eleAlternatePowerGenerationNo);
		return this;
	}
	
	@FindBy(how=How.ID,using="ddlGreenPacICLmt")
	public static WebElement eleGPIncreasedCostLmt;
	public PFPage selectGreenPacICLmt()
	{
		selectDropDownUsingText(eleGPIncreasedCostLmt, "25,000 / 25,000");
		return this;
	}

	@FindBy(how=How.ID,using="ddlGreenPacSCLmt")
	public static WebElement eleGPSoftCosts;
	public PFPage selectGreenPacSCLmt()
	{
		selectDropDownUsingText(eleGPSoftCosts, "25,000 / 25,000");
		return this;
	}

	//verify coverage - club professional is available 
	@FindBy(how=How.ID,using="lblpnlClubProfessional")
	public static WebElement eleClubProfCoverage;
	public PFPage verifyClubProf(){
		verifyPartialText(eleClubProfCoverage, "Club Professional");
		return this;
	}

	//Verify club professional check box is available
	@FindBy(how=How.ID,using="chkpnlClubProfessional")
	public static WebElement eleChkClubProfCoverage;
	public PFPage clickClubProf(){
		click(eleChkClubProfCoverage);
		return this;
	}

	//Crisis Response - PF 
	@FindBy(how=How.ID,using="chkpnlCrisisResponse")
	public static WebElement eleCrisisResponse;
	public PFPage selectCrisisResponse()
	{
		click(eleCrisisResponse);
		return this;
	}
	@FindBy(how=How.ID,using="ddlCRBIEELmt")
	public static WebElement eleBuisIncomeExtraExpense;
	public PFPage selectCRBIEE()
	{
		selectDropDownUsingText(eleBuisIncomeExtraExpense, "25,000/25,000");
		return this;
	}
	//Green Pac - PF 
	@FindBy(how=How.ID,using="chkpnlGreenPac")
	public static WebElement eleGreenPac;
	public PFPage selectGreenPac()
	{
		click(eleGreenPac);
		return this;
	}
	//Florida Sinkhole Loss Coverage
	@FindBy(how=How.ID,using="chkpnlPfSinkHoleLoss")
	public static WebElement eleChkBxFloridaSinkHoleLossCoverage;
	public PFPage selectChkBxFloridaSinkHoleLossCoverage()
	{
		click(eleChkBxFloridaSinkHoleLossCoverage);
		return this;
	}
	//Special Classes 
	@FindBy(how=How.ID,using="chkpnlSpec")
	public static WebElement eleSpclClasses;
	public PFPage selectSpecialClasses()
	{
		click(eleSpclClasses);
		return this;
	}
	//Amusement Equipment in the OPen
	@FindBy(how=How.ID,using="chkpnlAMUS")
	public static WebElement eleChkBxAmusementEquipment;
	public PFPage selectChkBxAmusementEquipment()
	{
		click(eleChkBxAmusementEquipment);
		return this;
	}
	//Amusement - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecAMUS_tLimit")
	public static WebElement eleTextAmusementLimit;
	public PFPage enterTextAmusementLimit(String data)
	{
		type(eleTextAmusementLimit, data);
		return this;
	}
	//Amusement-CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecAMUS_ddlCoinsOverride")
	public static WebElement eleDdlAmusementCoInsurance;
	public PFPage selDdlAmusementCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlAmusementCoInsurance, data);
		return this;
	}
	//Amusement-Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecAMUS_ddlConstructionType")
	public static WebElement eleDdlAmusementConstructionType;
	public PFPage selDdlAmusementConstructionType(String data)
	{
		selectDropDownUsingText(eleDdlAmusementConstructionType, data);

		return this;
	}

	//Artificial Turf
	@FindBy(how=How.ID,using="chkpnlTURF")
	public static WebElement eleChkBxArtificialTurf;
	public PFPage selChkBxArtificialTurf()
	{
		click(eleChkBxArtificialTurf);
		return this;
	}
	//Artificial Turf - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecTURF_tLimit")
	public static WebElement eleTextArtificialTurfLimit;
	public PFPage enterTextArtificialTurfLimit(String data)
	{
		type(eleTextArtificialTurfLimit, data);
		return this;
	}
	//Artificial TURF -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecTURF_ddlCoinsOverride")
	public static WebElement eleDdlArtificialTurfCoInsurance;
	public PFPage selDdlArtificialTurfCoInsurance()
	{
		click(eleDdlArtificialTurfCoInsurance);
		selectDropDownUsingIndex(eleDdlArtificialTurfCoInsurance, 2);
		return this;
	}
	//Artificial Turf- basic Group II 
	@FindBy(how=How.ID,using="uCtrlPFSpecTURF_tBGII")
	public static WebElement eleTxtArtificialTurfBasicGrpII;
	public PFPage clickArtificialTurfBasicGrpII()
	{
		click(eleTxtArtificialTurfBasicGrpII);
		return this;
	}
	//Awnings and Canopies
	@FindBy(how=How.ID,using="chkpnlAwnCanopies")
	public static WebElement eleChkBxAwningsAndCanopies;
	public PFPage selChkBxAwningsAndCanopies()
	{
		click(eleChkBxAwningsAndCanopies);
		return this;
	}
	//Awnings and Canopies - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecAWNS_tLimit")
	public static WebElement eleTextAwningsAndCanopiesLimit;
	public PFPage enterTextAwningsAndCanopiesLimit(String data)
	{
		type(eleTextAwningsAndCanopiesLimit, data);
		return this;
	}
	//Awnings and Canopies-CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecAWNS_ddlCoinsOverride")
	public static WebElement eleDdlAwningsAndCanopiesCoInsurance;
	public PFPage selDdlAwningsAndCanopiesCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlAwningsAndCanopiesCoInsurance, data);
		return this;
	}
	//Awnings and Canopies-Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecAWNS_ddlConstructionType")
	public static WebElement eleDdlAwningsAndCanopiesConstructionType;
	public PFPage selDdlAwningsAndCanopiesConstructionType(String data)
	{
		selectDropDownUsingText(eleDdlAwningsAndCanopiesConstructionType, data);
		return this;
	}
	//Billboards and Signs
	@FindBy(how=How.ID,using="chkpnlBillSigns")
	public static WebElement eleChkBxBillBoardsAndSigns;
	public PFPage selChkBxBillBoardsAndSigns()
	{
		click(eleChkBxBillBoardsAndSigns);
		return this;
	}
	//Billboards and Signs - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecBBRD_tLimit")
	public static WebElement eleTextBillBoardsAndSignsLimit;
	public PFPage enterTextBillBoardsAndSignsLimit(String data)
	{
		type(eleTextBillBoardsAndSignsLimit, data);
		return this;
	}
	//Billboards and Signs-CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecBBRD_ddlCoinsOverride")
	public static WebElement eleDdlBillBoardsAndSignsCoInsurance;
	public PFPage selDdlBillBoardsAndSignsCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlBillBoardsAndSignsCoInsurance, data);
		return this;
	}
	//Billboards and Signs-Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecBBRD_ddlConstructionType")
	public static WebElement eleDdlBillBoardsAndSignsConstructionType;
	public PFPage selDdlBillBoardsAndSignsConstructionType(String data)
	{
		selectDropDownUsingText(eleDdlBillBoardsAndSignsConstructionType, data);
		return this;
	}
	//Bleachers
	@FindBy(how=How.ID,using="chkpnlBleachers")
	public static WebElement eleChkBxBleachers;
	public PFPage selChkBxBleachers()
	{
		click(eleChkBxBleachers);
		return this;
	}
	// Bleachers - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecBLCH_tLimit")
	public static WebElement eleTextBleachersLimit;
	public PFPage enterTextBleachersLimit(String data)
	{
		type(eleTextBleachersLimit, data);
		return this;
	}
	// Bleachers -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecBLCH_ddlCoinsOverride")
	public static WebElement eleDdlBleachersCoInsurance;
	public PFPage selDdlBleachersCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlBleachersCoInsurance, data);
		return this;
	}
	// Bleachers- basic Group II 
	@FindBy(how=How.ID,using="uCtrlPFSpecBLCH_ddlCoinsOverride")
	public static WebElement eleTxtBleachersBasicGrpII;
	public PFPage clickBleachersBasicGrpII()
	{
		click(eleTxtBleachersBasicGrpII);
		return this;
	}
	//Electronic Transformers
	@FindBy(how=How.ID,using="chkpnlElectTrans")
	public static WebElement eleChkBxElectronicTransformers;
	public PFPage selChkBxElectronicTransformers()
	{
		click(eleChkBxElectronicTransformers);
		return this;
	}
	//  Electronic Transformers - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecELEC_tLimit")
	public static WebElement eleTextElectronicTransformersLimit;
	public PFPage enterTextElectronicTransformersLimit(String data)
	{
		type(eleTextElectronicTransformersLimit, data);
		return this;
	}
	//Electronic Transformers -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecELEC_ddlCoinsOverride")
	public static WebElement eleDdlElectronicTransformersCoInsurance;
	public PFPage selDdlElectronicTransformersCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlElectronicTransformersCoInsurance, data);
		return this;
	}
	//Electronic Transformers -Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecELEC_ddlConstructionType")
	public static WebElement eleDdlElectronicTransformersConstructionType;
	public PFPage selDdlElectronicTransformersConstructionType(String data)
	{
		selectDropDownUsingIndex(eleDdlElectronicTransformersConstructionType, 1);
		return this;
	}
	//Exhibit Stands
	@FindBy(how=How.ID,using="chkpnlExhibitStands")
	public static WebElement eleChkBxExhibitStands;
	public PFPage selChkBxExhibitStands()
	{
		click(eleChkBxExhibitStands);
		return this;
	}
	//  Exhibit Stands - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecEXHI_tLimit")
	public static WebElement eleTextExhibitStandsLimit;
	public PFPage enterTextExhibitStandsLimit(String data)
	{
		click(eleTextExhibitStandsLimit);
		type(eleTextExhibitStandsLimit, data);
		return this;
	}
	//Exhibit Stands -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecEXHI_ddlCoinsOverride")
	public static WebElement eleDdlExhibitStandsCoInsurance;
	public PFPage selDdlExhibitStandsCoInsurance(String data)
	{
		click(eleDdlExhibitStandsCoInsurance);
		selectDropDownUsingIndex(eleDdlExhibitStandsCoInsurance, 2);
		return this;
	}
	//Exhibit Stands -Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecEXHI_ddlConstructionType")
	public static WebElement eleDdlExhibitStandsConstructionType;
	public PFPage selDdlExhibitStandsConstructionType(String data)
	{
		selectDropDownUsingText(eleDdlExhibitStandsConstructionType, data);
		return this;
	}
	//Fences and Arbors
	@FindBy(how=How.ID,using="chkpnlFencesArbors")
	public static WebElement eleChkBxFencesArbors;
	public PFPage selChkBxFencesArbors()
	{
		click(eleChkBxFencesArbors);
		return this;
	}
	//  Fences and Arbors - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecFENC_tLimit")
	public static WebElement eleTextFencesArborsLimit;
	public PFPage enterTextFencesArborsLimit(String data)
	{
		type(eleTextFencesArborsLimit, data);
		return this;
	}
	//Fences and Arbors -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecFENC_ddlCoinsOverride")
	public static WebElement eleDdlFencesArborsCoInsurance;
	public PFPage selDdlFencesArborsCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlFencesArborsCoInsurance, data);
		return this;
	}
	//Fences and Arbors -Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecFENC_ddlConstructionType")
	public static WebElement eleDdlFencesArborsConstructionType;
	public PFPage selDdlFencesArborsConstructionType(String data)
	{
		selectDropDownUsingText(eleDdlFencesArborsConstructionType, data);
		return this;
	}
	//Nursery Stock in the Open
	@FindBy(how=How.ID,using="chkpnlNurseStock")
	public static WebElement eleChkBxNurseryStock;
	public PFPage selChkBxNurseryStock()
	{
		click(eleChkBxNurseryStock);
		return this;
	}
	// Nursery Stock - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecNURS_tLimit")
	public static WebElement eleTextNurseryStockLimit;
	public PFPage enterTextNurseryStockLimit(String data)
	{
		type(eleTextNurseryStockLimit, data);
		return this;
	}
	// Nursery Stock -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecNURS_ddlCoinsOverride")
	public static WebElement eleDdlNurseryStockCoInsurance;
	public PFPage selDdlNurseryStockCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlNurseryStockCoInsurance, data);
		return this;
	}
	// Nursery Stock- basic Group II 
	@FindBy(how=How.ID,using="uCtrlPFSpecNURS_tBGII")
	public static WebElement eleTxtNurseryStockBasicGrpII;
	public PFPage clickNurseryStockBasicGrpII()
	{
		click(eleTxtNurseryStockBasicGrpII);
		type(eleTxtNurseryStockBasicGrpII, "B");
		return this;
	}
	//Property in the Open
	@FindBy(how=How.ID,using="chkpnlProp")
	public static WebElement eleChkBxPropertyInOpen;
	public PFPage selChkBxPropertyInOpen()
	{
		click(eleChkBxPropertyInOpen);
		return this;
	}
	//Property in the Open - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecPROP_tLimit")
	public static WebElement eleTextPropertyInOpenLimit;
	public PFPage enterTextPropertyInOpenLimit(String data)
	{
		type(eleTextPropertyInOpenLimit, data);
		return this;
	}
	//Property in the Open -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecPROP_ddlCoinsOverride")
	public static WebElement eleDdlPropertyInOpenCoInsurance;
	public PFPage selDdlPropertyInOpenCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlPropertyInOpenCoInsurance, data);
		return this;
	}
	//Property in the Open -Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecPROP_ddlConstructionType")
	public static WebElement eleDdlPropertyInOpenConstructionType;
	public PFPage selDdlPropertyInOpenConstructionType(String data)
	{
		selectDropDownUsingText(eleDdlPropertyInOpenConstructionType, data);
		return this;
	}
	//Street Lights
	@FindBy(how=How.ID,using="chkpnlStrtLights")
	public static WebElement eleChkBxStreetLights;
	public PFPage selChkBxStreetLights()
	{
		click(eleChkBxStreetLights);
		return this;
	}
	//Street Lights - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecLGHT_tLimit")
	public static WebElement eleTextStreetLightsLimit;
	public PFPage enterTextStreetLightsLimit(String data)
	{
		type(eleTextStreetLightsLimit, data);
		return this;
	}
	//Street Lights -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecLGHT_ddlCoinsOverride")
	public static WebElement eleDdlStreetLightsCoInsurance;
	public PFPage selDdlStreetLightsCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlStreetLightsCoInsurance, data);
		return this;
	}
	//Street Lights -Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecLGHT_ddlConstructionType")
	public static WebElement eleDdlStreetLightsConstructionType;
	public PFPage selDdlStreetLightsConstructionType(String data)
	{
		selectDropDownUsingText(eleDdlStreetLightsConstructionType, data);
		return this;
	}
	//Swimming Pools
	@FindBy(how=How.ID,using="chkpnlSwimPools")
	public static WebElement eleChkBxSwimmingPools;
	public PFPage selChkBxSwimmingPools()
	{
		click(eleChkBxSwimmingPools);
		return this;
	}
	//Swimming Pools - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecSWIM_tLimit")
	public static WebElement eleTextSwimmingPoolsLimit;
	public PFPage enterTextSwimmingPoolsLimit(String data)
	{
		type(eleTextSwimmingPoolsLimit, data);
		return this;
	}
	//Swimming Pools -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecSWIM_ddlCoinsOverride")
	public static WebElement eleDdlSwimmingPoolsCoInsurance;
	public PFPage selDdlSwimmingPoolsCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlSwimmingPoolsCoInsurance, data);
		return this;
	}
	//Swimming Pools -Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecSWIM_ddlConstructionType")
	public static WebElement eleDdlSwimmingPoolsConstructionType;
	public PFPage selDdlSwimmingPoolsConstructionType(String data)
	{
		selectDropDownUsingText(eleDdlSwimmingPoolsConstructionType, data);
		return this;
	}
	//Radio and TV Antenna
	@FindBy(how=How.ID,using="chkpnlRadioTV")
	public static WebElement eleChkBxRadioAntenna;
	public PFPage selChkBxRadioAntenna()
	{
		click(eleChkBxRadioAntenna);
		return this;
	}
	//Radio and TV Antenna - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecRATV_tLimit")
	public static WebElement eleTextRadioAntennaLimit;
	public PFPage enterTextRadioAntennaLimit(String data)
	{
		type(eleTextRadioAntennaLimit, data);
		return this;
	}
	//Radio and TV Antenna -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecRATV_ddlCoinsOverride")
	public static WebElement eleDdlRadioAntennaCoInsurance;
	public PFPage selDdlRadioAntennaCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlRadioAntennaCoInsurance, data);
		return this;
	}
	//Radio and TV Antenna -Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecRATV_ddlConstructionType")
	public static WebElement eleDdlRadioAntennaConstructionType;
	public PFPage selDdlRadioAntennaConstructionType(String data)
	{
		selectDropDownUsingText(eleDdlRadioAntennaConstructionType, data);
		return this;
	}
	//Tents and Fabrics
	@FindBy(how=How.ID,using="chkpnlTentsFabrics")
	public static WebElement eleChkBxTentsFabrics;
	public PFPage selChkBxTentsFabrics()
	{
		click(eleChkBxTentsFabrics);
		return this;
	}
	//Tents and Fabrics - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecTENT_tLimit")
	public static WebElement eleTextTentsFabricsLimit;
	public PFPage enterTextTentsFabricsLimit(String data)
	{
		type(eleTextTentsFabricsLimit, data);
		return this;
	}
	//Tents and Fabrics -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecTENT_ddlCoinsOverride")
	public static WebElement eleDdlTentsFabricsCoInsurance;
	public PFPage selDdlTentsFabricsCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlTentsFabricsCoInsurance, data);
		return this;
	}
	//Tents and Fabrics -Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecTENT_ddlConstructionType")
	public static WebElement eleDdlTentsFabricsConstructionType;
	public PFPage selDdlTentsFabricsConstructionType(String data)
	{
		selectDropDownUsingText(eleDdlTentsFabricsConstructionType, data);
		return this;
	}
	//Water/Sewage Lift Pumps
	@FindBy(how=How.ID,using="chkpnlWaterSewagePumps")
	public static WebElement eleChkBxWaterSewageLiftPumps;
	public PFPage selChkBxWaterSewageLiftPumps()
	{
		click(eleChkBxWaterSewageLiftPumps);
		return this;
	}
	//Water/Sewage Lift Pumps - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecLIFT_tLimit")
	public static WebElement eleTextWaterSewageLiftPumpsLimit;
	public PFPage enterTextWaterSewageLiftPumpsLimit(String data)
	{
		type(eleTextWaterSewageLiftPumpsLimit, data);
		return this;
	}
	//Water/Sewage Lift Pumps -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecLIFT_ddlCoinsOverride")
	public static WebElement eleDdlWaterSewageLiftPumpsCoInsurance;
	public PFPage selDdlWaterSewageLiftPumpsCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlWaterSewageLiftPumpsCoInsurance, data);
		return this;
	}
	//Water/Sewage Lift Pumps -Construction Type 
	@FindBy(how=How.ID,using="uCtrlPFSpecLIFT_ddlConstructionType")
	public static WebElement eleDdlWaterSewageLiftPumpsConstructionType;
	public PFPage selDdlWaterSewageLiftPumpsConstructionType(String data)
	{
		selectDropDownUsingText(eleDdlWaterSewageLiftPumpsConstructionType, data);
		eleDdlWaterSewageLiftPumpsConstructionType.sendKeys(Keys.TAB);
		return this;
	}
	//Rafts and Floating Equipment
	@FindBy(how=How.ID,using="chkpnlRaftsFloatEquip")
	public static WebElement eleChkBxRaftsFloatingEquipment;
	public PFPage selChkBxRaftsFloatingEquipment()
	{
		click(eleChkBxRaftsFloatingEquipment);
		return this;
	}
	// Rafts and Floating Equipment - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecRAFT_tLimit")
	public static WebElement eleTextRaftsFloatingEquipmentLimit;
	public PFPage enterTextRaftsFloatingEquipmentLimit(String data)
	{
		type(eleTextRaftsFloatingEquipmentLimit, data);
		return this;
	}
	// Rafts and Floating Equipment -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecRAFT_ddlCoinsOverride")
	public static WebElement eleDdlRaftsFloatingEquipmentCoInsurance;
	public PFPage selDdlRaftsFloatingEquipmentCoInsurance(String data)
	{
		selectDropDownUsingText(eleDdlRaftsFloatingEquipmentCoInsurance, data);
		return this;
	}
	// Rafts and Floating Equipment- basic Group II 
	@FindBy(how=How.ID,using="uCtrlPFSpecRAFT_tBGII")
	public static WebElement eleTxtRaftsFloatingEquipmentBasicGrpII;
	public PFPage clickRaftsFloatingEquipmentBasicGrpII()
	{
		click(eleTxtRaftsFloatingEquipmentBasicGrpII);
		return this;
	}
	//Special Class - NOC
	@FindBy(how=How.ID,using="chkpnlSpeclClassNOC")
	public static WebElement eleChkBxSpecialClassNOC;
	public PFPage selChkBxSpecialClassNOC()
	{
		click(eleChkBxSpecialClassNOC);
		return this;
	}
	// Special Class - NOC - Limit 
	@FindBy(how=How.ID,using="uCtrlPFSpecSPEC_tLimit")
	public static WebElement eleTextSpecialClassNOCLimit;
	public PFPage enterTextSpecialClassNOCLimit(String data)
	{
		type(eleTextSpecialClassNOCLimit, data);
		return this;
	}
	// Special Class - NOC -CoInsurance 
	@FindBy(how=How.ID,using="uCtrlPFSpecSPEC_ddlCoinsOverride")
	public static WebElement eleDdlSpecialClassNOCCoInsurance;
	public PFPage selDdlSpecialClassNOCCoInsurance(String data)
	{
		click(eleDdlSpecialClassNOCCoInsurance);
		selectDropDownUsingIndex(eleDdlSpecialClassNOCCoInsurance, 2);
		return this;
	}
	// Special Class - NOC- basic Group II 
	@FindBy(how=How.ID,using="uCtrlPFSpecSPEC_tBGII")
	public static WebElement eleTxtSpecialClassNOCBasicGrpII;
	public PFPage clickSpecialClassNOCBasicGrpII()
	{
		click(eleTxtSpecialClassNOCBasicGrpII);
		type(eleTxtSpecialClassNOCBasicGrpII, "B");
		return this;
	}
	//Trees, Shrubs, plants
	@FindBy(how=How.ID,using="pnlPFSpecList_fieldSet")
	public static WebElement eleSpclClassesCoverages;
	public PFPage verifyTreesShrubsPlantsNotAvail(String data)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleSpclClassesCoverages);
		verifyPartialTextNotAvailable(eleSpclClassesCoverages, data);
		return this;
	}
	public PFPage verifySolarPanelNotAvail(String data)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleSpclClassesCoverages);
		verifyPartialTextNotAvailable(eleSpclClassesCoverages, data);
		return this;
	}

	//Special Classes coverage - check Not available
	@FindBy(how=How.XPATH,using="//div[@id='pnlPFSpecList_fieldSet']")
	public static WebElement eleSpecialClasses;
	public PFPage verifySpecialClasees(String data)
	{
		verifyPartialTextNotAvailable(eleSpecialClasses, data);
		return this;
	}
	//Swimming Pools
	@FindBy(how=How.ID,using="chkpnlSwimPools")
	public static WebElement eleSwimmingPools;
	public PFPage clickSwimPool()
	{
		click(eleSwimmingPools);
		return this;
	}
	@FindBy(how=How.ID,using="uCtrlPFSpecSWIM_tLimit")
	public static WebElement eleLimitSwimmingPools;
	public PFPage enterLimitsSwimPool(String data)
	{
		type(eleLimitSwimmingPools, data);
		return this;
	}
	//Construction type 
	@FindBy(how=How.ID,using="uCtrlPFSpecSWIM_ddlConstructionType")
	public static WebElement eleConstructionType;
	public PFPage selConstructionType()
	{
		selectDropDownUsingIndex(eleConstructionType, 2);
		return this;
	}
	//Basic Group2 symbol
	@FindBy(how=How.ID,using="uCtrlPFSpecSWIM_tBGII")
	public static WebElement eleBasicGrp2sym;
	public PFPage enterBasicGrp2sym(String data)
	{
		type(eleBasicGrp2sym, data);
		return this;
	}
	//Buisness Income with Extra Expense
	@FindBy(how=How.ID,using="chkpnlBI")
	public static WebElement eleBuisIncomeWithExtraExp;
	public PFPage clickBuisIncomeWithExtraExp()
	{
		click(eleBuisIncomeWithExtraExp);
		return this;
	}
	//Limit 
	@FindBy(how=How.ID,using="txtPfBincLim")
	public static WebElement eleLimit;
	public PFPage enterLimit(String data)
	{
		type(eleLimit, data);
		return this;
	}
	//Risk type 
	@FindBy(how=How.ID,using="ddlPfBincType")
	public static WebElement eleRiskType;
	public PFPage selRiskType(String data){
		selectDropDownUsingText(eleRiskType,data);
		return this;
	}
	//Class code
	@FindBy(how=How.ID,using="ClassCode")
	public static WebElement eleEnterClassCode;
	@FindBy(how=How.XPATH,using="(//input[@class='btnGo'])[2]")
	public static WebElement eleSearch;
	@FindBy(how=How.XPATH,using="(//table[@id='ClassCode_grid_grid']/tbody/tr)[2]")
	public static WebElement eleSearchResult;
	@FindBy(how=How.LINK_TEXT,using="Select")
	public static WebElement eleBtnSelect;
	public PFPage enterClassCode(String data)
	{
		type(eleEnterClassCode, data);
		click(eleSearch);
		click(eleSearchResult);
		click(eleBtnSelect);
		return this;
	}
	//Coinsurance Percentage 
	@FindBy(how=How.ID,using="ddlPfBincCoinPerc")
	public static WebElement eleCoInsurancePer;
	public PFPage selCoInsurancePer(String data){
		selectDropDownUsingText(eleCoInsurancePer,data);
		return this;
	}
	//Indemnity Type 
	@FindBy(how=How.ID,using="ddlPfBincIndmType")
	public static WebElement eleIndemnityTpe;
	public PFPage selIndemnityTpe(String data){
		selectDropDownUsingIndex(eleIndemnityTpe,1);
		return this;
	}
	
	//-----Optional Coverages-----
	//Extende period of Indemnity 
	@FindBy(how=How.ID,using="chkpnlPerIndem")
	public static WebElement eleExtPerOfIndemnity;
	public PFPage clickExtPerOfIndemnity(){
		click(eleExtPerOfIndemnity);
		return this;
	}
	//Number Of Days 
	@FindBy(how=How.ID,using="ddlPfIndmDays")
	public static WebElement eleNoOfDays;
	public PFPage selNoOfDays(String data){
		selectDropDownUsingText(eleNoOfDays,data);
		return this;
	}
	//BPP 
	@FindBy(how=How.ID,using="chkpnlBPP")
	public static WebElement eleBpp;
	public PFPage clickBpp(){
		click(eleBpp);
		return this;
	}

	//Limit - BPP 
	@FindBy(how=How.ID,using="txtPfBppLim1")
	public static WebElement eleBPPLimit;
	public PFPage enterBPPLimit(String data)
	{
		click(eleBPPLimit);
		type(eleBPPLimit, data);
		return this;
	}
	//BPP CLass Code 
	@FindBy(how=How.ID,using="txtPfBppClassCd")
	public static WebElement eleBPPClassCode;
	public PFPage enterBPPClassCode(String data)
	{
		click(eleBPPClassCode);
		type(eleBPPClassCode, data);
		return this;
	}
	//BPP-Basic Group I Rate
	@FindBy(how=How.ID,using="txtPfBppRateVal")
	public static WebElement elePfBppRateVal;
	public PFPage enterPfBppBasicGrpIRateVal(String data)
	{
		try
		{
			if(elePfBppRateVal.isDisplayed() && elePfBppRateVal.isEnabled())
			{
				type(elePfBppRateVal, data);
			}
		}
		catch (WebDriverException e) {
			e.printStackTrace();
		}
		finally
		{
			clickNextBtn();
		}

		return this;
	}
	//Legal Liability (Real Property)
	@FindBy(how=How.ID,using="chkoptLegalLiab")
	public static WebElement eleLegalLiabilityRealProp;
	public PFPage verifyLegalLiabilityRealProp(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleLegalLiabilityRealProp);
		verifyDisplayed(eleLegalLiabilityRealProp);
		return this;
	}
	//Building Glass Under Tenant's Policy
	@FindBy(how=How.ID,using="chkoptBppBldgGlassTnts")
	public static WebElement eleBuildingGlassTnentsPolicy;
	public PFPage clickBuildingGlassTnentsPolicy(){
		click(eleBuildingGlassTnentsPolicy);
		return this;
	}
	//Limit 
	@FindBy(how=How.ID,using="txtPfBldgLim")
	public static WebElement eleBuildingLmt;
	public PFPage enterBuildingLmt(String data){
		type(eleBuildingLmt, data);
		return this;
	}
	//Building Class Code txtPfBldgClass

	public PFPage enterBuildingClassCode(String data){
		type(eleBuildingTypeClassCode, data);
		return this;
	}
	//CoIsurance 
	@FindBy(how=How.XPATH,using="//img[@id='cboPfBldgCoinOvrd_button']")//cboPfBldgCoinOvrd_button
	public static WebElement eleBuildingCoInsurance;
	@FindBy(how=How.XPATH,using="(//ul[@id='cboPfBldgCoinOvrd_Options']/li)[3]")
	public static WebElement eleBuildingCoInsuranceValue;
	public PFPage enterBuildingCoInsurance(){
		click(eleBuildingCoInsurance);
		click(eleBuildingCoInsuranceValue);
		return this;
	}
	//Verify No Deductible is not available 
	@FindBy(how=How.CLASS_NAME,using="showhide_wrap shadow2")
	public static WebElement eleBuildingGlassTenentsPolicy;
	@FindBy(how=How.ID,using="pnlItemBPPCov1_fieldSet")
	public static WebElement eleBuildGlassTenentsPolicy;
	public PFPage verifyDeductible(String data){
		try {
			if (eleBuildingGlassTenentsPolicy.isDisplayed()) {			
				verifyPartialTextNotAvailable(eleBuildingGlassTenentsPolicy, data);
			}
			else if(eleBuildGlassTenentsPolicy.isDisplayed()) {			
				verifyPartialTextNotAvailable(eleBuildGlassTenentsPolicy, data);
			}
		}catch(WebDriverException e)
		{
			System.out.println("Not Available");
		}
		return this;
	}
	//Buisness Income Education Institution
	@FindBy(how=How.ID,using="chkpnlTu")
	public static WebElement eleBuisnessIncEduInst;
	public PFPage clickBuisnessIncEduInst(){
		click(eleBuisnessIncEduInst);
		return this;
	}
	//Limit - Buisness Income Education Institution
	@FindBy(how=How.ID,using="txtPfTuitLimit")
	public static WebElement eleBuisIncEdInsLmt;
	public PFPage enterBuisIncEdInsLmt(String data){
		type(eleBuisIncEdInsLmt, data);
		return this;
	}
	//CoIsurance - Buisness Income Education Institution
	@FindBy(how=How.ID,using="ddlPfTuitCoins")
	public static WebElement eleBuisIncEduInsCoInsurance;
	public PFPage selBuisIncEducInsCoInsurance(String data){
		selectDropDownUsingText(eleBuisIncEduInsCoInsurance, data);
		return this;
	}
	//Civil Authority Increased Coverage Period
	@FindBy(how=How.ID,using="chkOptCvlAthDays")
	public static WebElement eleCivilAthIncCovPerd;
	public PFPage clickCivilAthIncCovPerd(){
		click(eleCivilAthIncCovPerd);
		return this;
	}
	//Number oF Days - Civil Authority Increased Coverage Period 
	@FindBy(how=How.ID,using="ddlTuitCvlAthDays")
	public static WebElement eleNoOfDaysCivlAuth;
	public PFPage selNoOfDaysCivlAuth(String data){
		click(eleNoOfDaysCivlAuth);
		selectDropDownUsingText(eleNoOfDaysCivlAuth, data);
		return this;
	}
	//Extra Expense
	@FindBy(how=How.ID,using="chkpnlExExps")
	public static WebElement eleExtraExpense;
	public PFPage clickExtraExpense(){
		click(eleExtraExpense);
		return this;
	}
	//Off Premises Utilities 
	@FindBy(how=How.ID,using="chkpnlOffPrem")
	public static WebElement eleOffPremisesUtilities;
	public PFPage clickOffPremisesUtilities(){
		click(eleOffPremisesUtilities);
		return this;
	}
	//Select Limit Type 
	@FindBy(how=How.ID,using="chkPfUtlSvcsLmtIndF")
	public static WebElement eleOffPremisesLimitTypeFull;
	public PFPage clickOffPremisesLimitTypeFull(){
		click(eleOffPremisesLimitTypeFull);
		click(eleOffPremisesLimitTypeFull);
		click(eleOffPremisesLimitTypeFull);
		return this;
	}
	//Utility Service -Water ddlPfOfprWater
	@FindBy(how=How.ID,using="ddlPfOfprWater")
	public static WebElement eleUtilityServiceWater;
	public PFPage clickUtilityServiceWater(String data){
		click(eleUtilityServiceWater);
		selectDropDownUsingText(eleUtilityServiceWater, data);
		return this;
	}
	//Utility Service -Communication
	@FindBy(how=How.ID,using="ddlPfOfprCommun")
	public static WebElement eleUtilityServiceCommunication;
	public PFPage clickUtilityServiceCommunication(String data){
		click(eleUtilityServiceCommunication);
		selectDropDownUsingText(eleUtilityServiceCommunication, data);
		return this;
	}

	//Utility Service -Power
	@FindBy(how=How.ID,using="ddlPfOfprPower")
	public static WebElement eleUtilityServicePower;
	public PFPage clickUtilityServicePower(String data){
		click(eleUtilityServicePower);
		selectDropDownUsingText(eleUtilityServicePower, data);
		return this;
	}
//OverHead Communication Lines 
	@FindBy(how=How.ID,using="chkPfOfprCommLine")
	public static WebElement eleUtilityServiceCommunicationLines;
	public PFPage clickUtilityServiceCommunicationLines(){
		click(eleUtilityServiceCommunicationLines);
				return this;
	}
	//OverHead Power Lines 
		@FindBy(how=How.ID,using="chkPfOfprPwrLine")
		public static WebElement eleUtilityServicePowerLines;
		public PFPage clickUtilityServicePowerLines(){
			click(eleUtilityServicePowerLines);
					return this;
		}
	//Building 
	@FindBy(how=How.ID,using="chkpnlBLDG")
	public static WebElement eleBuilding;
	public PFPage clickBuilding(){
		click(eleBuilding);
		return this;
	}
	//Limit - Building 
	@FindBy(how=How.ID,using="txtPfBldgLim")
	public static WebElement eleBuildingLimit;
	public PFPage enterBuildingLimit(String data)
	{
		type(eleBuildingLimit, data);
		return this;
	}
	
	// Buisness Income Education Institution w/o Extra Expense
	@FindBy(how = How.ID, using = "chkpnlTUnoEE")
	public static WebElement eleChkBxBuisnessIncEduInstExtraExpense;

	public PFPage clickChkBxBuisnessIncEduInstExtraExpense() {
		click(eleChkBxBuisnessIncEduInstExtraExpense);
		return this;
	}
	//Legal Liaility- Building 
	@FindBy(how=How.ID,using="lblpnlFireLgl")
	public static WebElement eleLegalLiabilityBuildingCov;
	public PFPage clickLegalLiabilityBuildingCov(){
		click(eleLegalLiabilityBuildingCov);
		return this;
	}
	//Legal Liaility- Building 
	@FindBy(how=How.ID,using="txtPfBldgLim")
	public static WebElement eleLegalLiabilityBuildingLmt;
	public PFPage enterLegalLiabilityBuildingLmt(String data){
		type(eleLegalLiabilityBuildingLmt, data);
		return this;
	}
	//CoIsurance - Legal Liaility- Building 
	@FindBy(how=How.ID,using="cboPfBldgCoinOvrd_Text")
	public static WebElement eleTxtLegalLiabilityBuildingCoInsurance;
	public PFPage selLegalLiabilityBuildingCoInsurance(String data){
		click(eleTxtLegalLiabilityBuildingCoInsurance);
		type(eleTxtLegalLiabilityBuildingCoInsurance, "90");
		return this;
	}
	@FindBy(how=How.ID,using="txtPfBldgClass")
	public static WebElement eleTxtLegalLiabilityBuildingClassCode;
	public PFPage changeLegalLiabilityBuildingClassCode(String data) {
		click(eleTxtLegalLiabilityBuildingClassCode);
		type(eleTxtLegalLiabilityBuildingClassCode, data);
		return this;
	}
	// Business Income with Extra Expense
	@FindBy(how = How.ID, using = "chkpnlBI")
	public static WebElement eleBuisnessIncomeWithExtraExpense;

	public PFPage clickBuisnessIncomeWithExtraExpense() {
		click(eleBuisnessIncomeWithExtraExpense);

		return this;
	}

	// Edit for Business Income with Extra Expense
	@FindBy(how = How.XPATH, using = "//a[@id='editpnlBI']")
	public static WebElement eleBtnEditBIEE;

	public PFPage clickBtnEditBIEE() {
		click(eleBtnEditBIEE);
		return this;
	}

	// Edit BPP-
	@FindBy(how = How.ID, using = "editpnlBPP")
	public static WebElement eleEditBpp;

	public PFPage clickEditBpp() {
		click(eleEditBpp);
		return this;
	}

	// Monthly Limit
	@FindBy(how = How.ID, using = "ddlPfBincIndLim")
	public static WebElement eleDdMonthlyLimit;

	public PFPage selDdMonthlyLimit(String data) {
		selectDropDownUsingText(eleDdMonthlyLimit, data);
		return this;
	}

	// Number oF Days - Civil Authority Increased Coverage Period - Business Income
	// with Extra Expense
	@FindBy(how = How.ID, using = "ddlBincCvlAthDays")
	public static WebElement eleNoOfDaysCivlAuthBIEE;

	public PFPage selNoOfDaysCivlAuthBIEE(String data) {
		click(eleNoOfDaysCivlAuthBIEE);
		selectDropDownUsingText(eleNoOfDaysCivlAuthBIEE, data);
		return this;
	}

	// Limit-BPP-
	@FindBy(how = How.ID, using = "txtPfBppLim1")
	public static WebElement eleTxt_BPPLimit;

	public PFPage entertxtBPPLmt(String data) {
		type(eleTxt_BPPLimit, data);
		return this;
	}
	// BPP -class Code

	@FindBy(how = How.XPATH, using = "(//label[@id='ltxtPfBppClassCd']/following-sibling::input)[2]")
	public static WebElement eleBppSearchClassCode;
	@FindBy(how = How.XPATH, using = "(//table[@id='txtPfBppClassCd_grid_grid']/tbody/tr)[3]")
	public static WebElement eleBppSearchRslt;
	@FindBy(how = How.LINK_TEXT, using = "Select")
	public static WebElement eleBppSelect;
	@FindBy(how = How.ID, using = "txtPfBppClassCd")
	public static WebElement eleBppTypeClassCode;

	public PFPage typeBppClassCode(String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", eleBppSearchClassCode);
		type(eleBppTypeClassCode, data);
		click(eleBppSearchClassCode);
		click(eleBppSearchRslt);
		click(eleBppSelect);
		return this;
	}

	// Class Code-Building
	@FindBy(how = How.XPATH, using = "(//label[@id='ltxtPfBldgClass']/following-sibling::input)[2]")
	public static WebElement eleBldngSearchClassCode;
	@FindBy(how = How.XPATH, using = "(//table[@id='txtPfBldgClass_grid_grid']/tbody/tr)[3]")
	public static WebElement eleBldngSearchRslt;
	@FindBy(how = How.LINK_TEXT, using = "Select")
	public static WebElement eleBldngSelect;
	@FindBy(how = How.ID, using = "txtPfBldgClass")
	public static WebElement eleBldngTypeClassCode;

	public PFPage typeBldngClassCode(String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", eleBldngSearchClassCode);
		type(eleBldngTypeClassCode, data);
		click(eleBldngSearchClassCode);
		click(eleBldngSearchRslt);
		click(eleBldngSelect);
		return this;
	}

	// Civil Authority Increased Coverage Period - Business Income with Extra
	// Expense
	@FindBy(how = How.ID, using = "chkpnlCvlAthDays")
	public static WebElement eleCivilAthIncCovPerdBIEE;

	public PFPage clickCivilAthIncCovPerdBIEE() {
		click(eleCivilAthIncCovPerdBIEE);
		return this;
	}

	// Edit for Business Institute w/o Extra Expense
	@FindBy(how = How.XPATH, using = "//a[@id='editpnlTUnoEE']")
	public static WebElement eleEditBtnExtraExpense;

	public PFPage clickEditInBiExtraExpense() {
		click(eleEditBtnExtraExpense);
		return this;
	}
	// Location class code

	@FindBy(how = How.XPATH, using = "(//label[@id='ltxtPfTuitClassCd']/following-sibling::input)[2]")
	public static WebElement eleLocationSearchClassCode;
	@FindBy(how = How.XPATH, using = "//table[@id='txtPfTuitClassCd_grid_grid']//tbody//tr[3]")
	public static WebElement eleLocationSearchRslt;
	@FindBy(how = How.XPATH, using = "//div[@class='inlineButtons']//a[@id='txtPfTuitClassCd_select']")
	public static WebElement eleLocationSelect;
	@FindBy(how = How.ID, using = "txtPfTuitClassCd")
	public static WebElement eletxtLocationTypeClassCode;

	public PFPage typeLocationClassCode(String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", eleLocationSearchClassCode);
		type(eletxtLocationTypeClassCode, data);
		click(eleLocationSearchClassCode);
		click(eleLocationSearchRslt);
		click(eleLocationSelect);
		return this;
	}
	public PFPage changeBIEIClassCode(String data) {
		click(eletxtLocationTypeClassCode);
		type(eletxtLocationTypeClassCode, data);
		return this;
	}
	//Building Class code Information 
	@FindBy(how=How.XPATH,using="(//input[@id='txtPfBldgClass']/following-sibling::input)[1]")
	public static WebElement eleBuildingSearchClassCode;
	@FindBy(how=How.XPATH,using="(//table[@id='txtPfBldgClass_grid_grid']/tbody/tr)[2]")
	public static WebElement eleBuildingSearchRslt;
	@FindBy(how=How.LINK_TEXT,using="Select")
	public static WebElement eleBuildingSelect;
	@FindBy(how=How.LINK_TEXT,using="Search")
	public static WebElement eleBuildingSearch;
	@FindBy(how=How.ID,using="txtPfBldgClass")
	public static WebElement eleBuildingTypeClassCode;
	public PFPage typeBuildingClassCode(String data)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleBuildingSearchClassCode);
		type(eleBuildingTypeClassCode, data);
		click(eleBuildingSearchClassCode);
		click(eleBuildingSearchRslt);
		click(eleBuildingSelect);
		return this;
	}
	//Building - Basic Group I Rate
	@FindBy(how=How.ID,using="txtPfBldgRateVal")
	public static WebElement elePfBldgRateVal;
	public PFPage enterPfBldgBasicGrpIRateVal(String data)
	{
		try
		{
			if(elePfBldgRateVal.isDisplayed() && elePfBldgRateVal.isEnabled())
			{
				type(elePfBldgRateVal, data);
			}
		}
		catch (WebDriverException e) {
			e.printStackTrace();
		}
		
		return this;
	}

	//Legal Liability 
	@FindBy(how=How.ID,using="chkoptLegalLiab")
	public static WebElement eleBuildingLegalLiability;
	public PFPage selChkBxLegalLiability(){
		click(eleBuildingLegalLiability);
		return this;
	}
	//Limit - Legal Liability 
	@FindBy(how=How.ID,using="txtLLLmt")
	public static WebElement eleLegalLiabilityLimit;
	public PFPage enterTxtLegalLiabilityLimit(String data)
	{
		type(eleLegalLiabilityLimit, data);
		return this;
	}
	//Premium - Legal Liability 
	@FindBy(how=How.ID,using="txtLLPrem")
	public static WebElement eleLegalLiabilityPremium;
	public PFPage enterTxtLegalLiabilityPremium(String data)
	{
		type(eleLegalLiabilityPremium, data);
		return this;
	}
	//BPP- Limit - Legal Liability 
	@FindBy(how=How.ID,using="txtPfBppLeglLimit")
	public static WebElement eleBppLegalLiabilityLimit;
	public PFPage enterTxtBppLegalLiabilityLimit(String data)
	{
		click(eleBppLegalLiabilityLimit);
		type(eleBppLegalLiabilityLimit, data);
		return this;
	}
	//Premium - Legal Liability 
	@FindBy(how=How.ID,using="txtPfBppLeglPrem")
	public static WebElement eleBppLegalLiabilityPremium;
	public PFPage enterTxtBppLegalLiabilityPremium(String data)
	{
		type(eleBppLegalLiabilityPremium, data);
		return this;
	}
	//Demolition Cost 
	@FindBy(how=How.ID,using="chkoptDemolitionCost")
	public static WebElement eleBuildingDemolitionCost;
	public PFPage selChkBxBuildingDemolitionCost(){
		click(eleBuildingDemolitionCost);
		return this;
	}
	//Limit - Demolition Cost 
	@FindBy(how=How.ID,using="txtDemoLmt")
	public static WebElement eleDemolitionLimit;
	public PFPage enterTxtDemolitionLimit(String data)
	{
		type(eleDemolitionLimit, data);
		return this;
	}
	//Verify Roof Surfacing Not Available
	@FindBy(how=How.XPATH,using="//div[@id='pnlExpandOptionalCovs_fieldSet']")
	public static WebElement eleRoofInBuilding;
	public PFPage verifyRoofSurfacingInBuilding(String data){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleRoofInBuilding);
		verifyPartialTextNotAvailable(eleRoofInBuilding, data);
		return this;
	}
	//Legeal Liability  
	@FindBy(how=How.ID,using="chkoptLegalLiab")
	public static WebElement eleLegalLiability;
	public PFPage verifyLegalLiability(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleLegalLiability);
		verifyDisplayed(eleLegalLiability);
		return this;
	}

	//Legal Liability - Building 
	@FindBy(how=How.ID,using="chkpnlFireLgl")
	public static WebElement eleLegalLiabilityBuilding;
	public PFPage verifyLegalLiabilityBuilding(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleLegalLiabilityBuilding);
		verifyDisplayed(eleLegalLiabilityBuilding);
		return this;
	}
	public PFPage clickLegalLiabilityBuilding(){
		click(eleLegalLiabilityBuilding);
		return this;
	}
	// Exclusion - Building
	@FindBy(how=How.XPATH,using="(//div[@class='title']/h2)[2]")
	public static WebElement eleExclusion;
	public PFPage clickExclusion(){
		click(eleExclusion);
		return this;
	}
	// Exclusion - BPP
	@FindBy(how=How.XPATH,using="(//div[@class='title']/h2)[3]")
	public static WebElement eleExclusionBpp;
	public PFPage clickExclusionBpp(){
		click(eleExclusionBpp);
		return this;
	}
	//Verify Optional Coverages in BPP
	@FindBy(how=How.ID,using="pnlLocBPPOptCoverExtenMain_fieldSet") 
	public static WebElement eleOptionalCovBpp;
	public PFPage verifyOptionalCoveragesBpp(String data){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleOptionalCovBpp);
		verifyPartialText(eleOptionalCovBpp, data);
		return this;
	}
	//Increase In Rebuilding Expenses Following Disaster
	@FindBy(how=How.XPATH,using="//div[@id='pnlExpandOptionalCovs_fieldSet']")
	public static WebElement eleIncInRebuildExpFollowDisaste;
	public PFPage verifyIncInRebuildExpFollowDisaste(String data){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleIncInRebuildExpFollowDisaste);
		verifyPartialTextNotAvailable(eleIncInRebuildExpFollowDisaste, data);
		return this;
	}
	//Vaction Options 
	@FindBy(how=How.XPATH,using="(//div[@class='title']/h2)[3]")
	public static WebElement eleVacationOptions;
	public PFPage clickVacationOptions(){
		click(eleVacationOptions);
		return this;
	}
	//Minimum Percentage Rented/Used 
	@FindBy(how=How.ID,using="txtPfBldgPctRntUsd")
	public static WebElement eleMinPecRentedUsed;
	public PFPage verifyMinPecRentedUsed(){
		verifyNotEnabled(eleMinPecRentedUsed);
		return this;
	}
	//Vacant CheckBox 
	@FindBy(how=How.XPATH,using="//input[@id='chkPfBldgVac']")
	public static WebElement eleVacant;
	public PFPage clickVacant(){
		click(eleVacant);
		return this;
	}
	//Vacancy Permit CheckBox 
	@FindBy(how=How.XPATH,using="//input[@id='chkPfBldgVacPrmt']")
	public static WebElement eleVacancyPermit;
	public PFPage clickVacancyPermit(){
		click(eleVacancyPermit);
		return this;
	}
	//Vacancy Changes CheckBox 
	@FindBy(how=How.XPATH,using="//input[@id='chkPfBldgVacChng']")
	public static WebElement eleVacancyChanges;
	public PFPage clickVacancyChanges(){
		click(eleVacancyChanges);
		return this;
	}
	public PFPage verifyEnabledVacanct() {
		verifyEnabled(eleVacant);
		return this;
	}
	public PFPage verifyEnabledVacancyPermit() {
		verifyEnabled(eleVacancyPermit);
		return this;
	}
	public PFPage verifyDisabledVacancyChanges() {
		verifyNotEnabled(eleVacancyChanges);
		return this;
	}
	//Loss Payee 
	@FindBy(how=How.ID,using="chkpnlPfLossPay")
	public static WebElement eleLossPayee;
	public PFPage clickLossPayee(){
		click(eleLossPayee);
		return this;
	}
	//Loss Assessment Coverage
	@FindBy(how=How.ID,using="chkpnlLaMr")
	public static WebElement eleLossAssessment;
	public PFPage clickLossAssessment(){
		click(eleLossAssessment);
		return this;
	}
	//
	@FindBy(how=How.ID,using="cboPfLossLimit_Text")
	public static WebElement eleLossAssessmentCoverage;
	public PFPage checkLossAssessmentCoverage(){
		click(eleLossAssessmentCoverage);
		return this;
	}

	@FindBy(how=How.XPATH,using="//div[@id='pnlLaMr_fieldSet']")
	public static WebElement eleLossAssessmentMiscRealProp;
	public PFPage checkLossAssessmentMiscRealProp(String data){
		verifyPartialTextNotAvailable(eleLossAssessmentMiscRealProp, data);
		return this;
	}
	//TIB 
	@FindBy(how=How.ID,using="chkpnlTnts")
	public static WebElement eleTib;
	public PFPage clickTIB(){
		click(eleTib);
		return this;
	}
	//Limit - TIB 
	@FindBy(how=How.ID,using="txtPfBldgLim")
	public static WebElement eleTibLimit;
	public PFPage enterTibLimit(String data)
	{
		type(eleTibLimit, data);
		return this;
	}
	//Inflation Guard
	@FindBy(how=How.ID,using="chkoptInflationGuard")
	public static WebElement eleTibInflationGuard;
	public PFPage selChkBxTibInflationGuard(){
		click(eleTibInflationGuard);
		return this;
	}
	//Inflation Guard Dropdown
	@FindBy(how=How.ID,using="ddlBDInflGrd")
	public static WebElement eleDdlTibInflationGuard;
	public PFPage selDdlTibInflationGuard(String data){
		click(eleDdlTibInflationGuard);
		//selectDropDownUsingText(eleDdlTibInflationGuard, data);
		selectDropDownUsingIndex(eleDdlTibInflationGuard, 3);
		return this;
	}
	//Inflation Guard- BPP
	@FindBy(how=How.ID,using="chkoptInflGrd") 
	public static WebElement eleBppInflationGuard;
	public PFPage selChkBxBppInflationGuard(){
		click(eleBppInflationGuard);
		return this;
	}
	//Inflation Guard Dropdown - BPP
	@FindBy(how=How.ID,using="ddlPfBppInflaGrd")
	public static WebElement eleDdlBppInflationGuard;
	public PFPage selDdlBppInflationGuard(){
		click(eleDdlBppInflationGuard);
		//selectDropDownUsingText(eleDdlTibInflationGuard, data);
		selectDropDownUsingIndex(eleDdlBppInflationGuard, 3);
		return this;
	}
	//Earthquake Sprinkler
	@FindBy(how=How.ID,using="chkoptEQSprinkler")
	public static WebElement eleTibEarthquakeSprinkler;
	public PFPage selChkBxTibEarthquakeSprinkler(){
		click(eleTibEarthquakeSprinkler);
		return this;
	}
	//Earthquake Construction
	@FindBy(how=How.ID,using="ddlEqSprConstr")
	public static WebElement eleDdlTibEarthQuakeConstruction;
	public PFPage selDdlTibEarthQuakeConstruction(String data){
		click(eleDdlTibEarthQuakeConstruction);
		selectDropDownUsingIndex(eleDdlTibEarthQuakeConstruction, 3);
		return this;
	}

	//Verify Optional Coverages in TIB
	@FindBy(how=How.ID,using="pnlExpandOptionalCovs_fieldSet") 
	public static WebElement eleOptionalCov;
	public PFPage verifyOptionalCoverages(String data){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleOptionalCov);
		verifyPartialTextNotAvailable(eleOptionalCov, data);
		return this;
	}
	public PFPage verifyOptionalCoveragesAvail(String data){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleOptionalCov);
		verifyPartialText(eleOptionalCov, data);
		return this;
	}
	// Legal Liability – Personal Property
	@FindBy(how=How.XPATH,using="//div[@id='pnlLocCoverageB_fieldSet']")
	public static WebElement eleOptionalCoverages;
	public PFPage verifyLegalLiabilityPersProp(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleLossPayee);
		verifyPartialTextNotAvailable(eleOptionalCoverages, "Legal Liability Personal Property");
		return this;
	}
	//Verify Debris Removal Additional Insurance is not available
	public PFPage verifyDebrisRemovalAddIns(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleLossPayee);
		verifyPartialTextNotAvailable(eleOptionalCoverages, "Debris Removal Additional Insurance");
		return this;
	}
	//Limit 
	@FindBy(how=How.ID,using="txtPfExxpLim")
	public static WebElement eleExtraExpLimit;
	public PFPage enterExtraExpLimit(String data)
	{
		type(eleExtraExpLimit, data);
		return this;
	}
	//ClassCode
	@FindBy(how=How.ID,using="ClassCode")
	public static WebElement eleExtraExpClassCode;
	public PFPage enterExtraExpClassCode(String data)
	{
		type(eleExtraExpClassCode, data);
		return this;
	}
	//Expand Limit
	@FindBy(how=How.ID,using="ddlPfExxpExpndLim")
	public static WebElement eleExpandLimit;
	public PFPage selExpandLimit(String data){
		selectDropDownUsingText(eleExpandLimit, data);
		return this;
	}

	//Class code Information - ST env
	@FindBy(how=How.XPATH,using="(//label[@id='lclassCodeLoc']/following-sibling::input)[2]")
	public static WebElement eleSearchClassCode;
	@FindBy(how=How.XPATH,using="(//table[@id='classCodeLoc_grid_grid']/tbody/tr)[2]")
	public static WebElement eleSearchRslt;
	@FindBy(how=How.LINK_TEXT,using="Select")
	public static WebElement eleSelect;
	@FindBy(how=How.ID,using="classCodeLoc")
	public static WebElement eleTypeClassCode;
	public PFPage typeClassCode(String data)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleSearchClassCode);
		type(eleTypeClassCode, data);
		click(eleSearchClassCode);
		click(eleSearchRslt);
		click(eleSelect);
		return this;
	}
	// Buisness Income Dependent Properties 
	@FindBy(how=How.ID,using="chkpnlBiD")
	public static WebElement eleBuisnessIncomeDepProp;
	public PFPage clickBuisnessIncomeDepProp()
	{
		click(eleBuisnessIncomeDepProp);
		return this;
	}

	//Limit-  Buisness Income From Dependent Property
	@FindBy(how=How.ID,using="txtPfBincLim")
	public static WebElement eleLimitBuisIncDepProp;
	public PFPage enterLimitBuisIncDepProp(String data)
	{
		type(eleLimitBuisIncDepProp, data);
		return this;
	}
	//Coinsurance Buisness Income From Dependent Property 
	@FindBy(how=How.ID,using="ddlPfBincCoinPerc")
	public static WebElement eleCoInsuranceBusIncDepProp;
	public PFPage selCoInsuranceBuisIncDepPro(String data){
		selectDropDownUsingText(eleCoInsuranceBusIncDepProp,data);
		return this;
	}
	//Premiums 
	//Basic Group 1
	@FindBy(how=How.ID,using="txtPfBincBg1Prm")
	public static WebElement eleBasicGroup1;
	@FindBy(how=How.ID,using="txtPfBincBg2Prm")
	public static WebElement eleBasicGroup2;
	@FindBy(how=How.ID,using="txtPfBincColPrm")
	public static WebElement eleBasicGroup3;
	public PFPage enterBasicGropup(String data)
	{
		type(eleBasicGroup1, data);
		type(eleBasicGroup2, data);
		type(eleBasicGroup3, data);
		return this;
	}

	//Territory 
	@FindBy(how=How.ID,using="txtPfCspTerr")
	public static WebElement eleTerritory;
	public PFPage enterTerritory(String data)
	{
		eleTerritory.clear();
		type(eleTerritory, data);
		return this;
	}
	//ISO LookUp
	@FindBy(how=How.ID,using="SIGI_DialogURL")
	public static WebElement eleFrameIsoCity;
	@FindBy(how=How.XPATH,using="(//table[@id='divISOInformationals_grid']/tbody/tr/td)[1]")
	public static WebElement eleISOCity;
	@FindBy(how=How.LINK_TEXT,using="OK")
	public static WebElement eleISOCityOk;
	public PFPage selIsoCity()
	{
		try {
			if(eleFrameIsoCity.isDisplayed())
			{
				driver.switchTo().frame("SIGI_DialogURL");
				//click(eleISOCity);
				click(eleISOCityOk);
				driver.switchTo().defaultContent();
			}	
		} catch (WebDriverException e) {
			System.out.println("ISO city Not displayed");
		}

		return this;
	}

	//Basic Gropu 1 Territory 
	@FindBy(how=How.ID,using="txtPfBasicGrp1")
	public static WebElement eleBasicGrp1Territory;
	public PFPage enterBasicGrp1Territory(String data)
	{
		eleBasicGrp1Territory.clear();
		click(eleBasicGrp1Territory);
		type(eleBasicGrp1Territory, data);
		return this;
	}
	//Basic Gropu 2 Territory 
	@FindBy(how=How.ID,using="txtPfBasicGrpii")
	public static WebElement eleBasicGrp2Territory;
	public PFPage enterBasicGrp2Territory(String data)
	{
		eleBasicGrp2Territory.clear();
		type(eleBasicGrp2Territory, data);
		return this;
	}

	//Click on City/Country Information
	@FindBy(how=How.XPATH,using="(//div[@class='title']/h2)[1]")
	public static WebElement eleCityCountryInfo;
	public PFPage clickCityCounty()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='title']/h2)[1]")));

		click(eleCityCountryInfo);
		return this;
	}

	//Prometrix Schedule
	@FindBy(how=How.XPATH,using="(//div[@id='lvLocList']/table/tbody/tr)[2]")
	public static WebElement eleProMetrixSchedule;
	public PFPage selectPrometrixSchedule(){
		//driver.switchTo().frame("SIGI_DialogURL");
		try
		{
			if(eleProMetrixSchedule.isDisplayed()) {
				click(eleProMetrixSchedule);
				click(eleEdit);
			}
		}
		catch (WebDriverException e) {
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Prometrix not available");
		}
		return this;
	}
	//Limit-  Buisness Income Education Institution
	@FindBy(how=How.ID,using="txtPfTuitLimit")
	public static WebElement eleLimitBuisInEduInst;
	public PFPage enterLimitBusIncEduIns(String data)
	{
		type(eleLimitBuisInEduInst, data);
		return this;
	}
	//Coverage Type 
	@FindBy(how=How.ID,using="ddlTuRntlValCovType")
	public static WebElement eleCovType;
	public PFPage selCovType(String data){
		selectDropDownUsingText(eleCovType,data);
		return this;
	}
	//Coinsurance 
	@FindBy(how=How.ID,using="ddlPfTuitCoins")
	public static WebElement eleCoInsurance;
	public PFPage selCoInsurance(String data) throws InterruptedException{
		eleCoInsurance.click();
		Thread.sleep(1000);
		selectDropDownUsingText(eleCoInsurance,data);
		return this;
	}
	//Extension Option - PF
	@FindBy(how=How.ID,using="propertyElitePac")
	public static WebElement elePLExtnOption;
	public PFPage selPLExtnOptions(String data){
		if(elePLExtnOption.isDisplayed())
		{
			selectDropDownUsingText(elePLExtnOption,data);
		}
		else
		{
			System.out.println("Extension Option Not Available");
		}
		return this;
	}
	public PFPage optionsInEXtn()
	{
		allDropDownValues(elePLExtnOption);
		return this;
	}
	//Prometrix Year Built Override reason
	@FindBy(how=How.ID,using="txtYearBuildOverride")
	public static WebElement eleProMetrixOverrideReason;
	public PFPage enterProMetrixOverrideReason(String data){
		type(eleProMetrixOverrideReason, data);
		return this;
	}
	//Next Button
	@FindBy(how=How.LINK_TEXT,using="Next")
	public static WebElement eleNextBtn;
	public PFPage clickNextBtn(){
		click(eleNextBtn);
		return this;
	}
	//Edit
	@FindBy(how=How.LINK_TEXT,using="Edit")
	public static WebElement eleEdit;
	public PFPage clickEdit(){
		try {
			if (eleEdit.isDisplayed()) {
				click(eleEdit);	
			}
		} catch (WebDriverException e) {
			System.out.println("Not Available");
		}

		return this;
	}
	//Edit for Buisness Income from Dependent Properties 
	@FindBy(how=How.XPATH,using="//a[@id='editpnlBiD']")
	public static WebElement eleEditBtn;
	public PFPage clickEditInBiDp(){
		click(eleEditBtn);
		return this;
	}
	//Cancel
	@FindBy(how=How.LINK_TEXT,using="Cancel")
	public static WebElement eleCancel;
	public PFPage clickCancel(){
		click(eleCancel);
		return this;
	}

	//Yes Button 
		@FindBy(how=How.XPATH,using="(//span[@class='ui-button-text'])[1]")
		public static WebElement eleYes;
		public PFPage clickYes(){
			try {
				if (eleYes.isDisplayed()) {			
					click(eleYes);
				}
			} catch (WebDriverException e) {
				System.out.println("YES button not displayed");
			}
			return this;
		}
		//Yes Button 
		@FindBy(how=How.XPATH,using="(//span[@class='ui-button-text'])[2]")
		public static WebElement eleNo;
		public PFPage clickNo(){
			try {
				if (eleNo.isDisplayed()) {			
					click(eleNo);
				}
			} catch (WebDriverException e) {
				System.out.println("No button not displayed");
			}
			return this;
		}
	//Next to Property Policy Details
	@FindBy(how=How.LINK_TEXT,using="Next to Property Policy Details")
	public static WebElement eleNextToPropertyPolicyDetails;
	public PFPage clickPropPolicyDetail(){
		click(eleNextToPropertyPolicyDetails);
		return this;
	}
	//Next to Property
	@FindBy(how=How.LINK_TEXT,using="Next to Property")
	public static WebElement eleNextToProperty;
	public PFPage clickNextToProperty(){
		click(eleNextToProperty);
		return this;
	}
	//Coverages
	@FindBy(how=How.LINK_TEXT,using="Coverages")
	public static WebElement eleCoverages;
	public PFPage clickCoverages(){
		click(eleCoverages);
		return this;
	}
	//Building 001
	@FindBy(how=How.LINK_TEXT,using="Building 001")
	public static WebElement eleBuilding001;
	public PFPage clickBuilding001(){
		click(eleBuilding001);
		return this;
	}

	//Building 002
	@FindBy(how=How.LINK_TEXT,using="Building 002")
	public static WebElement eleBuilding002;
	public PFPage clickBuilding002(){
		click(eleBuilding002);
		return this;
	}
	//View ProMetrix loss cost details
	@FindBy(how=How.LINK_TEXT,using="View ProMetrix loss cost details")
	public static WebElement eleProMetrixLossCostDetails;
	public PFPage clickProMetrixLossCostDetails(){
		click(eleProMetrixLossCostDetails);
		return this;
	}
	//ELA Distribution DAte 
	@FindBy(how=How.ID,using="txtELAdisdate")
	public static WebElement eleELADistributionDate;
	public PFPage getELADistributionDate(){
		driver.switchTo().frame("SIGI_DialogURL");
		getText(eleELADistributionDate);
		return this;
	}
	// expand city and county Information
	@FindBy(how = How.XPATH, using = "//div[@class='content']//h2[@class='expand']")
	public static WebElement eleExpandCityInformation;

	public PFPage clickExpandCityInformation() {
		// click(eleExpandCityInformation);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", eleExpandCityInformation);
		return this;
	}
	//Delete Property LOB
	@FindBy(how=How.LINK_TEXT,using="Delete Property LOB")
	public static WebElement eleDeletePropertyLOB;
	public PFPage clickDeleteProperty(){
		click(eleDeletePropertyLOB);
		return this;
	}

	//Property
	@FindBy(how=How.LINK_TEXT,using="Property")
	public static WebElement eleProperty;
	public PFPage clickProperty(){
		click(eleProperty);
		return this;
	}
	//Policy details
	@FindBy(how=How.LINK_TEXT,using="Policy Details")
	public static WebElement elePolicyDetails;
	public PolicyDetailsPage clickPolicyDetails(){
		click(elePolicyDetails);
		return new PolicyDetailsPage(driver);
	}
}
