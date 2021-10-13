package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BrowserFactory;
import helper.DriverOperations;
import pages.HomePage;
import pages.LoginPage;
import pages.SDPage;
import testbase.TestBase;

public class SDPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	SDPage smartDepositPage;
	//SmartRetrievePage smartRetrievePage;
	

	public SDPageTest(){
		super();
	}
	
	@BeforeMethod(groups = { "SmartRetrieve"})
	public void setUp() throws Exception {
		BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
		Thread.sleep(2000);
		loginPage = new LoginPage();
		smartDepositPage = new SDPage();
		//smartRetrievePage =  new SmartRetrievePage();
		homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Thread.sleep(2000);
		DriverOperations.expandTopNavigationMenuAndPerformNavitation("Select application", "SmartDeposit");
		Thread.sleep(3000);
	}
	
//	@Test(priority=1, groups = { "SmartRetrieve" })
//	public void ClickSmartRetriveLinkFromTopNavBar() throws Exception{
//		smartRetrievePage.ClickSmartRetrieveLink();
//	}
	
	@Test(priority=1, groups = { "SmartRetrieve" })
	public void searchDocuments() throws Exception{
		smartDepositPage.depositSingleDocument();
	}
	

	
	@AfterMethod(groups = { "SmartRetrieve" })
	public void tearDown() throws Exception{
		
		DriverOperations.logOut();
	}

}
