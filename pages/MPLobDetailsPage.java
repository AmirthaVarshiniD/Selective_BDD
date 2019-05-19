package com.api.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.api.cucumber.comMethods.ProjMethods;

public class MPLobDetailsPage extends ProjMethods {

	public MPLobDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// MP Questions1
	@FindBy(how = How.ID, using = "ctl29")
	public static WebElement eleFirstQuestionNoRadio;

	public MPLobDetailsPage ClickFirstQuestionNoRadio() {
		click(eleFirstQuestionNoRadio);
		return this;

	}

	// MP Questions2
	@FindBy(how = How.ID, using = "ctl33")
	public static WebElement eleSecondQuestionNoRadio;

	public MPLobDetailsPage ClickSecondQuestionNoRadio() {
		click(eleSecondQuestionNoRadio);
		return this;

	}

	// MP Questions3
	@FindBy(how = How.ID, using = "ctl37")
	public static WebElement eleThirdQuestionNoRadio;

	public MPLobDetailsPage ClickThirdQuestionNoRadio() {
		click(eleThirdQuestionNoRadio);
		return this;

	}

	// MP Questions4
	@FindBy(how = How.ID, using = "ctl41")
	public static WebElement eleFourthQuestionNoRadio;

	public MPLobDetailsPage ClickFourthQuestionNoRadio() {
		click(eleFourthQuestionNoRadio);
		return this;

	}

	// MP Questions5
	@FindBy(how = How.ID, using = "ctl44")
	public static WebElement eleFifthQuestionYesRadio;

	public MPLobDetailsPage ClickFifthQuestionYesRadio() {
		click(eleFifthQuestionYesRadio);
		return this;

	}

	// MP Questions6A
	@FindBy(how = How.ID, using = "ctl48")
	public static WebElement eleSixthAQuestionYesRadio;

	public MPLobDetailsPage ClickSixthAQuestionYesRadio() {
		click(eleSixthAQuestionYesRadio);
		return this;

	}

	// MP Questions6B
	@FindBy(how = How.ID, using = "ctl52")
	public static WebElement eleSixthBQuestionYesRadio;

	public MPLobDetailsPage ClickSixthBQuestionYesRadio() {
		click(eleSixthBQuestionYesRadio);
		return this;

	}

	// MP Questions6C
	@FindBy(how = How.ID, using = "ctl56")
	public static WebElement eleSixthCQuestionYesRadio;

	public MPLobDetailsPage ClickSixthCQuestionYesRadio() {
		click(eleSixthCQuestionYesRadio);
		return this;

	}

	// MP Questions6D
	@FindBy(how = How.ID, using = "ctl60")
	public static WebElement eleSixthDQuestionYesRadio;

	public MPLobDetailsPage ClickSixthDQuestionYesRadio() {
		click(eleSixthDQuestionYesRadio);
		return this;

	}

	// MP Questions7
	@FindBy(how = How.ID, using = "ctl65")
	public static WebElement eleSeventhQuestionNoRadio;

	public MPLobDetailsPage ClickSeventhQuestionNoRadio() {
		click(eleSeventhQuestionNoRadio);
		return this;

	}

	// MP Submit button
	@FindBy(how = How.ID, using = "btnSubmit")
	public static WebElement eleSubmitButton;

	public MPLobDetailsPage ClickSubmitButton() {
		click(eleSubmitButton);
		return this;

	}

	// MP Add Class code
	@FindBy(how = How.ID, using = "btnAddNewClassCode_1")
	public static WebElement eleAddNewClassCode;

	public MPLobDetailsPage ClickAddNewClassCode() {
		click(eleAddNewClassCode);
		return this;

	}
	// Professional Service
	@FindBy(how = How.ID, using = "CC1_ddlProfService")
	public static WebElement eleProfessionalService;

	public MPLobDetailsPage SelectProfessionalService() {
		Select professionalService = new Select(eleProfessionalService);
		professionalService.selectByIndex(1);
		return this;

	}
	
	//Class Code
	@FindBy(how = How.ID, using = "CC1_ddlClassCode")
	public static WebElement eleClassCode;

	public MPLobDetailsPage SelectClassCode() {
		Select classCode = new Select(eleClassCode);
		classCode.selectByIndex(1);
		return this;

	}
	
	//Premium Basis
	@FindBy(how = How.ID, using = "CC1_txtPremiumBasis")
	public static WebElement elePremiumBasis;

	public MPLobDetailsPage EnterPremiumBasis() {
		type(elePremiumBasis,"1200");
		return this;

	}
	//Consent50
	@FindBy(how = How.ID, using = "chkpl7095")
	public static WebElement eleConsentPL7095;

	public MPLobDetailsPage CheckConsentPL7095() {
		click(eleConsentPL7095);
		return this;

	}
	
	//Consent100
	//@FindBy(how = How.ID, using = "chkpl7094")
//	public static WebElement eleConsentPL7094;
//
//	public MPLobDetailsPage CheckConsentPL7094() {
//		click(eleConsentPL7094);
//		return this;
//
//	}
	
	//Defense outside of limits checkbox
	@FindBy(how = How.ID, using = "chkpl7097")
	public static WebElement eleDefenseOutsideOfLimits;

	public MPLobDetailsPage CheckDefenseOutsideOfLimits() {
		click(eleDefenseOutsideOfLimits);
		return this;

	}
	
	//Punitive Damages
	@FindBy(how = How.ID, using = "chkpl7091")
	public static WebElement elePunitiveDamages;

	public MPLobDetailsPage CheckPunitiveDamages() {
		click(elePunitiveDamages);
		return this;

	}
	
	//Additional7090 checkbox
	@FindBy(how = How.ID, using = "chkpl7090")
	public static WebElement eleAdditional7090;

	public MPLobDetailsPage CheckAdditional7090() {
		click(eleAdditional7090);
		return this;

	}
	
	//Additional Quantity7090	
	@FindBy(how = How.ID, using = "txtQuantity7090")
	public static WebElement eleAdditional7090Quantity;

	public MPLobDetailsPage EnterAdditional7090Quantity() {
		type(eleAdditional7090Quantity,"100");
		return this;

	}
	
	//Additional7104 checkbox
	@FindBy(how = How.ID, using = "chkpl7104")
	public static WebElement eleAdditional7104;

	public MPLobDetailsPage CheckAdditional7104() {
		click(eleAdditional7104);
		return this;

	}
	
	//Additional Quantity7104
	@FindBy(how = How.ID, using = "txtQuantity7104")
	public static WebElement eleAdditional7104Quantity;

	public MPLobDetailsPage EnterAdditional7104Quantity() {
		type(eleAdditional7104Quantity,"200");
		return this;

	}
	
	

}
