package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BrowserFactory;
import helper.DriverOperations;
import org.openqa.selenium.Keys;
public class DepositAutoITPage extends BrowserFactory {
	
	/*@FindBy(xpath = "//input[@id='UploadedFileBtn']")
	WebElement upload;*/
	
	
	@FindBy(xpath = "//button[@id='UploadedFileBtn']")
	WebElement upload;
	
	@FindBy(xpath = "//select[@id='depositTableSelect']")
	WebElement DocumentType;
	
	@FindBy(xpath = "//button[@id='btnDepositDocument']")
	WebElement depositDoc;
	
	@FindBy(xpath = "//button[@id='btnDepositAllDocument']")
	WebElement depositDocAll;
	
	
	@FindBy(xpath = "//button[@id='btnDepositAllDocumentss']")
	WebElement depositDocAll1;
	
	@FindBy(xpath = "//input[@id='DP_ARCH_DATE']")
	WebElement ArchiveDate;
/*
	@FindBy(xpath = "//div[contains(@class,'ng-binding ng-scope')]")
	WebElement SuccessMessage;*/
	
	@FindBy(xpath = "//span[contains(text(),'✖')]")
	WebElement cancel;
	
	public DepositAutoITPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void depositDo() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		DriverOperations.clickWhenElementIsClickable(upload);
	Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\AutoIT\\FileUpload.exe");
		Thread.sleep(2000);
		DriverOperations.selectDropdownOptionByVisibleText(DocumentType, "doc1");
		DriverOperations.clearFieldAndEnterStringData(ArchiveDate, "12/24/2019");
		Thread.sleep(2000);
		DriverOperations.waitandClick(depositDoc);
		Thread.sleep(2000);
		DriverOperations.waitandClick(cancel);
		Thread.sleep(2000);
	}
	
	public void depositMultiDo() throws IOException, InterruptedException  
	{
		Thread.sleep(2000);
		DriverOperations.clickWhenElementIsClickable(upload);
		Thread.sleep(2000);
		
		
		Runtime.getRuntime().exec("D:\\AutoIT\\FileUploadMulti1.exe");
		
		
		/*Runtime.getRuntime().exec("D:\\AutoIT\\FileUpload.exe");
		Thread.sleep(1000);
		System.out.println("one uploaded-------------------------------------------------");
		Thread.sleep(1000);
		DriverOperations.clickWhenElementIsClickable(upload);
		Thread.sleep(1000);
		System.out.println("multi uploaded-------------------------------------------------");
		Runtime.getRuntime().exec("D:\\AutoIT\\FileUpload.exe");*/
		
		/*Runtime.getRuntime().exec("D:\\AutoIT\\FileUpload.exe" + " " + 2 + " " + "D:\tfs\colors.TIF" "D:\tfs\colors1.TIF");*/
		Thread.sleep(3000);
		DriverOperations.selectDropdownOptionByVisibleText(DocumentType, "doc1");
		DriverOperations.clearFieldAndEnterStringData(ArchiveDate, "12/24/2019");
		Thread.sleep(2000);
		DriverOperations.waitandClick(depositDocAll);
		Thread.sleep(2000);
		DriverOperations.waitandClick(cancel);
		Thread.sleep(2000);
	}
	public void testToFail() throws InterruptedException, IOException
	{
		//Thread.sleep(2000);
		//DriverOperations.clickWhenElementIsClickable(upload);
		Thread.sleep(2000);

		//Runtime.getRuntime().exec("D:\\AutoIT\\FileUpload.exe");
		Thread.sleep(1000);
		DriverOperations.waitandClick(depositDocAll1);
	}
	
}
