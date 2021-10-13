package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import base.BrowserFactory;
import helper.DriverOperations;
import helper.TestUtility;
import pages.HomePage;
import pages.LoginPage;
import pages.SmartExtractPage;

import testbase.TestBase;


public class SmartExtractPageTest extends TestBase
{
		
	SmartExtractPage smartExtractPage;
	LoginPage loginPage;
	HomePage homePage;
	
	String CategorySheet = "Category";
	String QueueSheet = "Queue";
	String EditQueueSheet ="EditQueue";
	public SmartExtractPageTest()
	{
		super();
	}
	
	@DataProvider
	public Object[][] getcategoryData(){
		Object data[][] = TestUtility.getTestData(CategorySheet);
		return data;
	}
	@DataProvider
	public Object[][] getQueueData(){
		Object data[][] = TestUtility.getTestData(QueueSheet);
		return data;
	}
	@DataProvider
	public Object[][] getEditQueueData(){
		Object data[][] = TestUtility.getTestData(EditQueueSheet);
		return data;
	}
	
	@BeforeClass(groups = { "SmartExtract" })
	public void setUp() throws Exception {
		BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
		loginPage = new LoginPage();
		smartExtractPage = new SmartExtractPage();
		homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));	
		Thread.sleep(2000);
		//smartDepositPage = homePage.clickDepositLink();
		//DriverOperations.expandTopNavigationMenuAndPerformNavitation("Select application", "SmartExtract");
		//Thread.sleep(3000);
		
	}
	
	@Test(priority=1)
		public void openSmartExtract() throws InterruptedException
		{
			smartExtractPage.openSmartExtract();
			Thread.sleep(3000);
		}
		
	
	@Test(priority=2,dataProvider = "getcategoryData",  groups = { "SmartExtract" }) 
	public void Createcategory(String ExcelcateName ) throws Exception{
		
		smartExtractPage.createcate(ExcelcateName);
		Thread.sleep(5000);
	}
	
	@Test(priority=3,dataProvider = "getQueueData",  groups = { "SmartExtract" }) 
	public void createQueue(String ExcelqueueName, String Excelemail ) throws Exception{
		
		smartExtractPage.createQueue(ExcelqueueName,Excelemail);
		Thread.sleep(6000);
	}
	
	@Test(priority=4,dataProvider = "getEditQueueData",  groups = { "SmartExtract" }) 
	public void editDeleteQueue(String ExcelEditQueue) throws Exception{
		
		smartExtractPage.editQueue(ExcelEditQueue);
		smartExtractPage.deleteQueue();
	}
	
	@AfterClass(groups = { "SmartExtract" })
	public void tearDown() throws Exception{
		DriverOperations.logOut();
	}
}
