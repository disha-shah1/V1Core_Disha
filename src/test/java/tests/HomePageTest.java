package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BrowserFactory;
import helper.DriverOperations;
import pages.HomePage;
import pages.LoginPage;
import pages.SmartDepositPage;
import testbase.TestBase;

public class HomePageTest  extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	SmartDepositPage smartDepositPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod(groups = { "HomePage" })
	public void setUp() throws Exception {
		BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
		loginPage = new LoginPage();
		homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));	
		Thread.sleep(2000);
	}
	
	/*@Test(priority=1, groups = { "HomePage" })
	public void verifydepositLink() throws Exception{
		boolean flag = homePage.verifydepositlink();
		Assert.assertTrue(flag);
	}*/
	
	/*@Test(groups = { "HomePage" })
	public void verifyDepositlinkclick() throws Exception{
		 smartDepositPage = homePage.clickDepositLink();
	}*/
	
	/*@AfterMethod(groups = { "HomePage" })
	public void tearDown() throws Exception{
		DriverOperations.logOut();
	}*/
}
