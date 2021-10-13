package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserFactory;
import helper.DriverOperations;

public class SmartRetentionPage extends BrowserFactory {
	
	// create rule
	@FindBy(xpath = "//button[@id='newRule']")
	WebElement NewRuleButton;

	@FindBy(xpath = "//input[@id='ruleCode']")
	WebElement RuleCodeText;
	
	@FindBy(xpath = "//input[@id='ruleName']")
	WebElement RuleNameText;
	
	@FindBy(xpath = "//input[@id='ruleReason']")
	WebElement RuleReasonText;
	
	@FindBy(xpath = "//select[@id='allowDelete']")
	WebElement allowMenualdeleteOption;
	
	@FindBy(xpath = "//input[@id='autoDelete']")
	WebElement Checkboxdelete;
	
	@FindBy(xpath = "//select[@id='autoDeleteOn']")
	WebElement DateAutoDelete;
	
	@FindBy(xpath = "//select[@id='autoDeletePeriodType']")
	WebElement ChooseAnOptionDrop;
	
	@FindBy(xpath = "//input[@id='autoDeletePeriod']")
	WebElement DeletePeriod;
	
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement SaveRule;
	
	// delete rule
	@FindBy(xpath = "//h4[contains(text(),'teshj (tejj)')]/following-sibling::span")
	WebElement DeleteRule;
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div[2]/button[2]")
	WebElement YesDelete;
	
	//Document type default
	@FindBy(xpath = "//*[@id='mainPortal']/ul/li[2]/a")
	WebElement DocumentTypeDeTab;
	
	@FindBy(xpath = "//h4[text()='PO_test']/parent::div/following-sibling::div/select")
	WebElement SelectRuleToAssociate;
	
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement SaveAssociation;
	
	
	@FindBy(xpath = "//*[@id='mainPortal']/ul/li[3]/a")
	WebElement DeletionCandTab;
	
	@FindBy(xpath = "//*[@id='filterRuleCode']")
	WebElement SelectRule;
	
	@FindBy(xpath = "//*[@id='btnGenCandidates']")
	WebElement candidatebtn;
	
	@FindBy(xpath = "//div[@class='modal-footer']/button[@data-bb-handler='confirm']")
	WebElement YesForgenerateCandi;
	
	
	@FindBy(xpath = "//input[@id='UploadedFile']")
	WebElement upload;
	
	
	@FindBy(xpath = "//select[@id='depositTableSelect']")
	WebElement DocumentType;
	
	@FindBy(xpath = "//button[@id='btnDepositDocument']")
	WebElement depositDoc;
	
	@FindBy(xpath = "//button[@id='btnDepositAllDocument']")
	WebElement depositDocAll;
	
	@FindBy(xpath = "//input[@id='DP_ARCH_DATE']")
	WebElement ArchiveDate;
	
	//select application
	@FindBy(xpath = "//a[@title='Go to the portal']")
	WebElement portalLink;
	
	//select retention
	@FindBy(xpath = "//h4[text()='SmartRetentions']")
	WebElement SmartretentionLink;
	
	
	public SmartRetentionPage()
	{
		PageFactory.initElements(driver, this);
	}
//-------------------for opening module	
	/*public void openRetention() throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(SmartretentionLink);
	}*/
//----------------	
	public void createRule(String Rulecode, String RuleName, String Reason, String NoOf ) throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(NewRuleButton);
		Thread.sleep(2000);
		DriverOperations.clearFieldAndEnterStringData(RuleCodeText, Rulecode);
		DriverOperations.clearFieldAndEnterStringData(RuleNameText, RuleName);
		DriverOperations.clearFieldAndEnterStringData(RuleReasonText, Reason);
		DriverOperations.selectDropdownOptionByVisibleText(allowMenualdeleteOption, "Yes");
		Checkboxdelete.click();
		DriverOperations.selectDropdownOptionByVisibleText(DateAutoDelete, "Creation date");
		DriverOperations.selectDropdownOptionByVisibleText(ChooseAnOptionDrop, "Days");
		DriverOperations.clearFieldAndEnterStringData(DeletePeriod, NoOf);
		DriverOperations.clickWhenElementIsClickable(SaveRule);
		Thread.sleep(3000);
	}
	
	public void deleteRule() throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(DeleteRule);
		DriverOperations.clickWhenElementIsClickable(YesDelete);
		Thread.sleep(3000);
	}
	
	public void Setrule() throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(DocumentTypeDeTab);
		Thread.sleep(2000);
		DriverOperations.selectDropdownOptionByVisibleText(SelectRuleToAssociate, "test (testcode)");
		DriverOperations.clickWhenElementIsClickable(SaveAssociation);
		Thread.sleep(3000);
		
		DriverOperations.expandTopNavigationMenuAndPerformNavitation("SmartRetentions", "SmartDeposit");
		DriverOperations.getWhenElementVisible(upload);
		upload.sendKeys("c:\\2005.pdf");
		Thread.sleep(2000);
		DriverOperations.selectDropdownOptionByVisibleText(DocumentType, "PO_test");
		DriverOperations.clearFieldAndEnterStringData(ArchiveDate, "02/05/2018");
		Thread.sleep(2000);
		DriverOperations.waitandClick(depositDoc);
		Thread.sleep(2000);
		
		DriverOperations.expandTopNavigationMenuAndPerformNavitation("SmartDeposit", "SmartRetentions");
		DriverOperations.clickWhenElementIsClickable(DeletionCandTab);
		DriverOperations.selectDropdownOptionByVisibleText(SelectRule, "test (testcode)");
		DriverOperations.clickWhenElementIsClickable(candidatebtn);
		DriverOperations.clickWhenElementIsClickable(YesForgenerateCandi);
		Thread.sleep(2000);
	}
}

