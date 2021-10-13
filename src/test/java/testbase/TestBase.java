package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import base.BrowserFactory;
import helper.DriverOperations;
import pages.DepositAutoITPage;
import pages.HomePage;
import pages.LoginPage;

public class TestBase extends BrowserFactory {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./Properties/v1core.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeSuite(alwaysRun = true)
	public void initiateSute() throws Exception
	{ 
//		DeleteExcelFile.deleteExcel();
//		ExcelWriteUtility.writeDataToExcel();
//		TestUtility.deleteFilesAndSubFoldersNotTheDirectory();
//		TestUtility.createScreenShotsDirectory();
		
		BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
		loginPage = new LoginPage();
		//depositAutoITPage = new DepositAutoITPage();
		homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));	
		Thread.sleep(2000);
		//smartDepositPage = homePage.clickDepositLink();
	//DriverOperations.expandTopNavigationMenuAndPerformNavitation1("Select application", "SmartDeposit");
		Thread.sleep(3000);
	}
	
		
	@AfterSuite(alwaysRun = true)
	public void sendReportEmailAndCompleteTestSuite() throws  Exception
	{
//		//TestUtility.sendEmail();	
	
	DriverOperations.logOut();
	driver.close();
	
//		}

			

	}
}