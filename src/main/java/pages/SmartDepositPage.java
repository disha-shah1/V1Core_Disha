package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserFactory;
import helper.DriverOperations;
import helper.TestUtility;

public class SmartDepositPage extends BrowserFactory {
	
	String successMessageForSingleDocumentDeposit = "Document Deposited Successfully";
	
	@FindBy(xpath = "//button[@id='UploadedFileBtn']")
	WebElement upload;
	
	
	@FindBy(xpath = "//select[@id='depositTableSelect']")
	WebElement DocumentType;
	
	@FindBy(xpath = "//button[@id='btnDepositDocument']")
	WebElement depositDoc;
	
	@FindBy(xpath = "//button[@id='btnDepositAllDocument']")
	WebElement depositDocAll;
	
	@FindBy(xpath = "//input[@id='DP_ARCH_DATE']")
	WebElement ArchiveDate;

	@FindBy(xpath = "//div[contains(@class,'ng-binding ng-scope')]")
	WebElement SuccessMessage;
	
	//TestUtility testUtility = new TestUtility();
	
	public SmartDepositPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	/*public String verifyDepositPageTitle()
	{
		return driver.getTitle();
		
	}*/
	
	/*public void clickOnBrowse()
	{
		DriverOperations.clickWhenElementIsClickable(upload);
		//upload.sendKeys("C:/Users/disha.shah/Desktop/Tf/2005.pdf");
		//return new SmartDepositPage();
	}*/
	
	// for depositing single document
	
	/*public void testSD()
	{
		depositSingleDocument()
		
	}*/
	public void depositSingleDocument(String path, String doctype) throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(upload);
		upload.sendKeys(path);
		Thread.sleep(2000);
		DriverOperations.selectDropdownOptionByVisibleText(DocumentType, doctype);
		DriverOperations.clearFieldAndEnterStringData(ArchiveDate, "12/24/2018");
		Thread.sleep(2000);
		DriverOperations.waitandClick(depositDoc);
		Thread.sleep(2000);
		DriverOperations.getWhenElementContainsText(SuccessMessage,successMessageForSingleDocumentDeposit);
		SuccessMessage.click();
		Thread.sleep(2000);
		
	}
	
	/*public void depositSingleDocument1(Object path, Object doctype) throws InterruptedException
	{
		DriverOperations.getWhenElementVisible(upload);
		upload.sendKeys((CharSequence[]) path);
		Thread.sleep(2000);
		DriverOperations.selectDropdownOptionByVisibleText(DocumentType, doctype);
		DriverOperations.clearFieldAndEnterStringData(ArchiveDate, "12/24/2018");
		Thread.sleep(2000);
		DriverOperations.waitandClick(depositDoc);
		Thread.sleep(2000);
		DriverOperations.getWhenElementContainsText(SuccessMessage,successMessageForSingleDocumentDeposit);
		//SuccessMessage.click();
		Thread.sleep(2000);
		
	}*/
	
	
	
	
	/*public void depositMultipleDoc(String path, String doctype) throws InterruptedException
	{
		
		
		DriverOperations.getWhenElementVisible(upload);
		upload.sendKeys(path);
		Thread.sleep(2000);
		DriverOperations.selectDropdownOptionByVisibleText(DocumentType, doctype);
		DriverOperations.clearFieldAndEnterStringData(ArchiveDate, "12/24/2018");
		Thread.sleep(2000);
		DriverOperations.waitandClick(depositDoc);
		Thread.sleep(2000);
		DriverOperations.getWhenElementContainsText(SuccessMessage,successMessageForSingleDocumentDeposit);
		//SuccessMessage.click();
		Thread.sleep(2000);
		
	}*/
	
	//for depositing multiple document 
	public void depositMultipleDoc1(Object data[][]) throws InterruptedException
	{
		String path;
		String DocuemntType;
		for (int i = 0; i < data.length; i++) {
			
			path = (String) data[i][0];
			DocuemntType = (String) data[i][1];
			DriverOperations.getWhenElementVisible(upload);
			upload.sendKeys(path);
			Thread.sleep(2000);
			DriverOperations.selectDropdownOptionByVisibleText(DocumentType, DocuemntType);
			DriverOperations.clearFieldAndEnterStringData(ArchiveDate, "12/24/2018");
			Thread.sleep(2000);

		}
		
	
		DriverOperations.waitandClick(depositDocAll);
		Thread.sleep(2000);
		//DriverOperations.getWhenElementContainsText(SuccessMessage,successMessageForSingleDocumentDeposit);

		//Thread.sleep(2000);
		
	}
	
	
	
}
