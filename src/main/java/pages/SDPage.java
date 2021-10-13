package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserFactory;
import helper.DriverOperations;

public class SDPage extends BrowserFactory {
	
	//String filepath = "D:\\Laxman PC\\D Drive\\Laxman\\Projects\\Document Management\\Invoices_with_Issues\\1.1 VAT Number\\1.1.6a.TIF";
		String filepath1 = "c:\\2005.pdf";
		String filepath2 = "D:\\Laxman PC\\D Drive\\Laxman\\Projects\\Document Management\\Invoices_with_Issues\\1.2 Totals\\1.2.2.TIF";
		String successMessageForSingleDocumentDeposit = "Document Deposited Successfully";
		String successMessageForMultipleDocumentDeposit = "Documents Deposited Successfully";
		
		@FindBy(xpath = "//input[@id='UploadedFile']")
		WebElement BrowseFile;
		
		@FindBy(xpath = "//select[@id='depositTableSelect']")
		WebElement SelectDocumentType;
		
		@FindBy(xpath = "//button[@id='btnDepositDocument']")
		WebElement DepositDocumentButton;
		
		@FindBy(xpath = "//button[@id='btnDepositAllDocument']")
		WebElement DepositALLDocument;
		
		@FindBy(xpath = "//input[@id='DP_ARCH_DATE']")
		WebElement ArchiveDate;
		
		@FindBy(xpath = "//div[contains(text(),'SmartDeposit')]")
		WebElement SmartDepositLink;
		
		@FindBy(xpath = "//div[contains(@class,'ng-binding ng-scope')]")
		WebElement SuccessMessage;
		
		// Initializing the Page Objects:
		public SDPage() {
			PageFactory.initElements(driver, this);
		}
		
		public void depositSingleDocument() throws InterruptedException	{
			
			//SmartDepositLink.click();
			//DriverOperations.clickWhenElementIsClickable(SmartDepositLink);
			//Thread.sleep(2000);
			DriverOperations.getWhenElementVisible(BrowseFile);
			BrowseFile.sendKeys(filepath1);
			Thread.sleep(2000);
//			oSelect=new Select(SelectDocumentType);
//			oSelect.selectByVisibleText("Purchase");
			DriverOperations.selectDropdownOptionByVisibleText(SelectDocumentType, "purchase");
			//DepositDocumentButton.click();
			DriverOperations.clearFieldAndEnterStringData(ArchiveDate, "12/24/2018");
			DriverOperations.waitandClick(DepositDocumentButton);
			Thread.sleep(2000);
			DriverOperations.getWhenElementContainsText(SuccessMessage,successMessageForSingleDocumentDeposit);
			SuccessMessage.click();
			Thread.sleep(2000);
		}
		
		public void depositMultipleDocument() throws InterruptedException	{
			
			//SmartDepositLink.click();
			DriverOperations.clickWhenElementIsClickable(SmartDepositLink);
			//Thread.sleep(2000);
			DriverOperations.getWhenElementVisible(BrowseFile);
			BrowseFile.sendKeys(filepath1);
			Thread.sleep(2000);
			DriverOperations.selectDropdownOptionByVisibleText(SelectDocumentType, "Purchase");
			BrowseFile.sendKeys(filepath2);
			Thread.sleep(2000);
//			oSelect=new Select(SelectDocumentType);
//			oSelect.selectByVisibleText("Purchase");
			DriverOperations.selectDropdownOptionByVisibleText(SelectDocumentType, "Purchase");
			//Thread.sleep(5000);
			DriverOperations.moveToElement(DepositALLDocument);
			//DepositALLDocument.click();
			DriverOperations.waitandClick(DepositALLDocument);
			//DriverOperations.getWhenElementVisible(SuccessMessage);
			DriverOperations.getWhenElementContainsText(SuccessMessage,successMessageForMultipleDocumentDeposit);
			//SuccessMessage.click();
			Thread.sleep(2000);
		}

}
