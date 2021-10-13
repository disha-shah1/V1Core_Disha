package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BrowserFactory;
import helper.DriverOperations;
import pages.HomePage;
import pages.LoginPage;
import pages.SmartRetrievePage;
import pages.SoftwareDownloadPage;
import testbase.TestBase;

public class SoftwareDownloadPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	SoftwareDownloadPage softwareDownloadPage;
	public SoftwareDownloadPageTest()
	{
		super();
	}
	
	@BeforeMethod(groups = { "SmartRetrieve" })
	public void setUp() throws Exception {
		BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
		loginPage = new LoginPage();
		homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		softwareDownloadPage = new SoftwareDownloadPage();
		Thread.sleep(2000);
		//smartDepositPage = homePage.clickDepositLink();
		DriverOperations.expandTopNavigationMenuAndPerformNavitation("Select application", "Software Download");
		Thread.sleep(3000);
		
	}
	@Test(priority=1)
	public void Downloadsoftware() throws InterruptedException
	{
		softwareDownloadPage.DownloadSoftware();
		Thread.sleep(3000);
	}
}
