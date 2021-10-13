package tests;

import java.io.IOException;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BrowserFactory;
import helper.DriverOperations;
import helper.TestUtility;
import pages.DepositAutoITPage;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;

public class DepositAutoITtest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage ;
	//DepositAutoITPage depositAutoITPage = new DepositAutoITPage();
	DepositAutoITPage depositAutoITPage;
	
	/*String DepositSheet = "depositSingle";
	String DepositMultiSheet = "depositMultiple";*/
	
	public DepositAutoITtest() {
		// TODO Auto-generated constructor stub
		super();
	}

	
	@BeforeClass(groups = { "SmartDeposit" })
	public void setUp() throws Exception {
		/*BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
		loginPage = new LoginPage();
		depositAutoITPage = new DepositAutoITPage();
		homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));	
		Thread.sleep(2000);*/
		//smartDepositPage = homePage.clickDepositLink();
		HomePage homePage = new HomePage();
		depositAutoITPage=homePage.clickDepositLink();
		//DriverOperations.expandTopNavigationMenuAndPerformNavitation1("Select application", "SmartDeposit");
		Thread.sleep(3000);
		
	}
	
	
	
	
	/*@DataProvider
	public  Object[][] getdepositTestData(){
		Object data[][] = TestUtility.getTestData(DepositSheet);
		return data;
	}
	@DataProvider
	public Object[][] getdepositTestDataMulti(){
		Object data[][] = TestUtility.getTestData(DepositMultiSheet);
		return data;
	}
	*/
	
	
	@Test(priority = 1)
	public void depositDoc() throws IOException, InterruptedException
	{
		//DepositAutoITPage depositAutoITPage1 = new DepositAutoITPage();
		depositAutoITPage.depositDo();
		Thread.sleep(200);
	}
	
	/*@Test(priority = 2)
	public void Tofail() throws IOException, InterruptedException
	{
		depositAutoITPage.testToFail();
		Thread.sleep(200);
	}*/
	@Test(priority = 2)
	public void depositMultiDoc() throws IOException, InterruptedException
	{
		//DepositAutoITPage depositAutoITPage2 = new DepositAutoITPage();
		depositAutoITPage.depositMultiDo();
		Thread.sleep(200);
	}
	
	/*@AfterClass(groups = { "SmartDeposit" })
	public void tearDown() throws Exception{
		DriverOperations.logOut();
		driver.close();
	}*/
	
}
