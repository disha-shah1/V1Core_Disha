package tests;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.mail.smtp.SMTPMessage;

import base.BrowserFactory;
import helper.DriverOperations;
import helper.TestUtility;
import pages.DepositAutoITPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SmartDepositPage;
import pages.SmartRetentionPage;
import pages.SmartRetrievePage;
import testbase.TestBase;

public class MasterTest extends TestBase {
	
	
	SmartDepositPage smartDepositPage;
	SmartRetrievePage smartRetrievePage;
	SmartRetentionPage smartRetentionPage;
	LoginPage loginPage;
	HomePage homePage;
	SmartDepositPageTest smartDepositPageTest;
	SmartRetentionPageTest smartRetentionPageTest;
	DepositAutoITtest depositAutoITtest;
	DepositAutoITPage depositAutoITPage;
	
	public MasterTest()
	{
		super();
	}
	
	@BeforeClass()
	
		public void setUp() throws Exception {
			BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
			loginPage = new LoginPage();
			smartDepositPage = new SmartDepositPage();
			smartDepositPageTest = new SmartDepositPageTest();
			depositAutoITPage = new DepositAutoITPage();
			depositAutoITtest = new DepositAutoITtest();
			smartRetrievePage = new SmartRetrievePage();
			smartRetentionPage = new SmartRetentionPage();
			smartRetentionPageTest = new SmartRetentionPageTest();
			homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));	
			Thread.sleep(2000);
			
		
	}
	/*@Test(priority=1)
	public void testSmartDeposit() throws InterruptedException
	{
		DriverOperations.expandTopNavigationMenuAndPerformNavitation("Select application", "SmartDeposit");
		Object data [] [] = smartDepositPageTest.getdepositTestData();
		String path = data [0][0].toString();
		String doctype = data [0][1].toString();
		
		smartDepositPage.depositSingleDocument(path, doctype);
		Thread.sleep(5000);
		Object data1 [] [] = smartDepositPageTest.getdepositTestDataMulti();
		smartDepositPage.depositMultipleDoc1(data1);
		WebElement home = driver.findElement(By.xpath("//img/parent::a[@id='portalHomeSelector']"));
		DriverOperations.clickWhenElementIsClickable(home);
	}*/
	
	@Test(priority=1)
	public void testSmartDeposit() throws InterruptedException, IOException
	{
		DriverOperations.expandTopNavigationMenuAndPerformNavitation1("Select application", "SmartDeposit");
		System.out.println("---------------------------------");
		/*Object data [] [] = smartDepositPageTest.getdepositTestData();
		String path = data [0][0].toString();
		String doctype = data [0][1].toString();
		*/
		depositAutoITPage.depositDo();
		Thread.sleep(5000);
		depositAutoITPage.depositMultiDo();
		/*Object data1 [] [] = smartDepositPageTest.getdepositTestDataMulti();
		smartDepositPage.depositMultipleDoc1(data1);*/
		WebElement home = driver.findElement(By.xpath("//div[@class='mc-app-name__inner']"));
		DriverOperations.clickWhenElementIsClickable(home);
		Thread.sleep(1000);
	}
	
	@Test(priority=2)
	public void testSmartRetrieve() throws InterruptedException
	{
		System.out.println("---------------------------------");
		Thread.sleep(1000);
		DriverOperations.expandTopNavigationMenuAndPerformNavitation1("Select application", "SmartRetrieve");
		Thread.sleep(3000);
	 	smartRetrievePage.QuickSearching();	
	 	System.out.println("---------------------------------");
	 	smartRetrievePage.AdvanceSearching();
	 	Thread.sleep(500);
	 	/*WebElement home = driver.findElement(By.xpath("//div[@class='mc-app-name__inner']"));
		DriverOperations.clickWhenElementIsClickable(home);*/
		smartRetrievePage.sipmleSaveSearch(prop.getProperty("AdvanceSearchkeyword"),prop.getProperty("SearchName"));
		Thread.sleep(200);
		smartRetrievePage.UpdateSearch(prop.getProperty("SearchNameUpdate"));
		Thread.sleep(200);
		smartRetrievePage.CopySearch(prop.getProperty("SearchNameCopy"));
		Thread.sleep(200);
		smartRetrievePage.deleteSearch();
		Thread.sleep(500);
	}
	/*
	@Test(priority=3)
	public void testSmartRetention() throws InterruptedException
	{
		DriverOperations.expandTopNavigationMenuAndPerformNavitation("Select application", "SmartRetentions");
		
		Object data[][] = smartRetentionPageTest.getRetentionData();
		String Rulecode;
		String RuleName;
		String Reason;
		String NoOf;
		
		for(int i=0;i<data.length;i++)
		{
			 Rulecode = data [i] [0].toString();
			 RuleName =  data [i][1].toString();
			 Reason = data [i][2].toString();
			 NoOf = data [i][3].toString();
			smartRetentionPage.createRule(Rulecode, RuleName, Reason, NoOf);
		}	
		smartRetentionPage.deleteRule();
		smartRetentionPage.Setrule();
		
	}*/
	
	@AfterClass(groups = { "MasterTestCase" })
	public void tearDown() throws Exception{
		DriverOperations.logOut();
	}
}
