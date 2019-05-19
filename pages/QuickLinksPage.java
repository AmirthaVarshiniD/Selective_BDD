package com.api.cucumber.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.api.cucumber.comMethods.ProjMethods;


public class QuickLinksPage extends ProjMethods  {
	public QuickLinksPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="Commercial Lines - CLAS")
	public static WebElement eleLinkCLAS;
	public ComLinesAutoSysPage selectComLink() throws InterruptedException
	{				
		click(eleLinkCLAS);
		Thread.sleep(5000);
		//switchToWindow(1);
		return new ComLinesAutoSysPage(driver);
	}



}
