package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserFactory;
import helper.DriverOperations;


public class SmartExtractPage extends BrowserFactory {
	
	
	//manage category button
	@FindBy(xpath = "//button[@id='btnManageCategories']")
	WebElement ManageCateBtn;
	
	//add category button
	@FindBy(xpath = "//span[@id='addCategory']")
	WebElement AddCateBtn;
	
	//category textbox
	@FindBy(xpath = "//input[@id='categoryname']")
	WebElement categoryTxt;
	
	//save category button
	@FindBy(xpath = "//button[@id='categorySave']")
	WebElement SaveCatebtn;
	
	//edit button for hr category
	@FindBy(xpath = "//td[text()='hr']//following-sibling::td//div//span[@title='Edit']")
	WebElement EditCategory;
	
	//delete for category
	@FindBy(xpath = "//td[text()='hr']//following-sibling::td//div//span[@title='Delete']")
	WebElement DeleteCategory;
	
	
	
	
	//manage queue button
	@FindBy(xpath = "//button[@id='btnManageQueue']")
	WebElement ManageQueue;
	
	//add queue
	@FindBy(xpath = "//span[@id='addQueue']")
	WebElement AddQueuebtn;
	
	//edit queue
	@FindBy(xpath = "//td[contains(text(),'queue1')]//following-sibling::td//div//span[@title='Edit']")
	WebElement EditQueue;
	
	//back button
	@FindBy(xpath= "//button[@id='btnBack']")
	WebElement Backbtn;
	
	//queue text box
	@FindBy(xpath = "//input[@id='queueName']")
	WebElement QueueTxt;
	
	//select category
	@FindBy(xpath = "//select[@id='categoryList']")
	WebElement SelectCategory;
	
	//enter email
	@FindBy(xpath = "//input[@id='Email']")
	WebElement EmailTxt;
	
	//save queue
	@FindBy(xpath = "//button[@id='queueSave']")
	WebElement SaveQueuebtn;
	
	//edit queue save
	
	@FindBy(xpath = "//button[@id='queueEdit']")
	WebElement SaveeditQueuebtn;
	
	
	
	//delete queue
	@FindBy(xpath = "//td[contains(text(),'Queue2')]//following-sibling::td//div//span[@title='Delete']")
	WebElement DeletQueue;
	
	//confirm delete
	@FindBy(xpath = "//span[@id='deleteBtn']")
	WebElement confirmDeletQueue;
	
	//home button
	@FindBy(xpath = "//button[@id='btnHome']")
	WebElement homebtn;
	
	//open document
	
	@FindBy(xpath = "//a[@title='2']")
	WebElement OpenDoc;
	
	//select smartExtract
	@FindBy(xpath = "//h4[text()='SmartExtract']")
	WebElement SmartExtractLink;
	
	
	public SmartExtractPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openSmartExtract() throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(SmartExtractLink);
		Thread.sleep(3000);
	}
	
	public void createcate(String cateName) throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(ManageCateBtn);
		Thread.sleep(2000);
		DriverOperations.clickWhenElementIsClickable(AddCateBtn);
		DriverOperations.clearFieldAndEnterStringData(categoryTxt, cateName);


		DriverOperations.clickWhenElementIsClickable(SaveCatebtn);
		Thread.sleep(3000);
	}
	
	public void createQueue(String queueName, String email) throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(ManageQueue);
		DriverOperations.clickWhenElementIsClickable(AddQueuebtn);
		DriverOperations.clearFieldAndEnterStringData(QueueTxt, queueName);
		DriverOperations.selectDropdownOptionByVisibleText(SelectCategory, "hr");
		DriverOperations.clearFieldAndEnterStringData(EmailTxt, email);
		DriverOperations.clickWhenElementIsClickable(SaveQueuebtn);
		Thread.sleep(3000);
	}
	
	public void editQueue(String editQueueName) throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(EditQueue);
		DriverOperations.clearFieldAndEnterStringData(QueueTxt, editQueueName);
		DriverOperations.clickWhenElementIsClickable(SaveeditQueuebtn);
		Thread.sleep(6000);
		DriverOperations.clickWhenElementIsClickable(Backbtn);
		
	}
	
	public void deleteQueue()
	{
		DriverOperations.clickWhenElementIsClickable(DeletQueue);
		DriverOperations.clickWhenElementIsClickable(confirmDeletQueue);
		DriverOperations.clickWhenElementIsClickable(homebtn);
	}
	
	public void documentOperations() throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(OpenDoc);
		Thread.sleep(6000);
	}
	
}
