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
import pages.SmartDepositPage;
import pages.SmartRetentionPage;
import testbase.TestBase;

public class SmartRetentionPageTest extends TestBase{
	
	SmartRetentionPage smartRetentionPage;
	LoginPage loginPage;
	HomePage homePage;
	
	String RetentionRuleSheet = "RetentionRule";
	
	public SmartRetentionPageTest()
	{
		super();
	}

	
	@BeforeClass(groups = { "SmartRetention" })
	public void setUp() throws Exception {
		BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
		loginPage = new LoginPage();
		smartRetentionPage = new SmartRetentionPage();
		homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));	
		Thread.sleep(2000);
		//smartDepositPage = homePage.clickDepositLink();
	//	DriverOperations.expandTopNavigationMenuAndPerformNavitation("Select application", "SmartRetentions");
		//Thread.sleep(3000);
		
	}
	
	@DataProvider
	public Object[][] getRetentionData(){
		Object data[][] = TestUtility.getTestData(RetentionRuleSheet);
		return data;
	}
	
	
	// for opening retention module
	/*@Test()
	public void openRetention() throws InterruptedException
	{
		smartRetentionPage.openRetention();
	}*/
	
	@Test(priority=1,dataProvider = "getRetentionData",  groups = { "SmartRetention" }) 
	public void CreateNewRule(String ExcelRuleCode, String ExcelRuleName, String ExcelReason, String ExcelPeriod ) throws Exception{
		
		smartRetentionPage.createRule(ExcelRuleCode, ExcelRuleName,ExcelReason, ExcelPeriod);
	}
	
	@Test(priority=2,groups = { "SmartRetention" })
	public void setAsociation() throws InterruptedException
	{
		smartRetentionPage.Setrule();
	}
	
	@Test(priority=3, groups = { "SmartRetention" })
	public void DeleteRule() throws InterruptedException
	{
		smartRetentionPage.deleteRule();
	}
	
	@AfterClass(groups = { "SmartRetention" })
	public void tearDown() throws Exception{
		DriverOperations.logOut();
	}

}
