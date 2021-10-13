package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BrowserFactory;
import helper.DriverOperations;
import helper.TestUtility;
import pages.HomePage;
import pages.LoginPage;
import pages.SmartDepositPage;
import testbase.TestBase;

public class SmartDepositPageTest extends TestBase {
	
	SmartDepositPage smartDepositPage;
	LoginPage loginPage;
	HomePage homePage;
	
	String DepositSheet = "depositSingle";
	String DepositMultiSheet = "depositMultiple";
	public SmartDepositPageTest()
	{
		super();
	}
	
	@BeforeMethod(groups = { "SmartDeposit" })
	public void setUp() throws Exception {
		BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
		loginPage = new LoginPage();
		smartDepositPage = new SmartDepositPage();
		homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));	
		Thread.sleep(2000);
		//smartDepositPage = homePage.clickDepositLink();
		DriverOperations.expandTopNavigationMenuAndPerformNavitation1("Select application", "SmartDeposit");
		Thread.sleep(3000);
		
	}
	
	
	
	/*@DataProvider
	public static Object[][] getdepositTestData(){
		Object data[][] = TestUtility.getTestData(DepositSheet);
		return data;
	}*/
	
	@DataProvider
	public  Object[][] getdepositTestData(){
		Object data[][] = TestUtility.getTestData(DepositSheet);
		return data;
	}
	@DataProvider
	public Object[][] getdepositTestDataMulti(){
		Object data[][] = TestUtility.getTestData(DepositMultiSheet);
		return data;
	}
	
	
	@Test(priority=1,dataProvider = "getdepositTestData", groups = { "SmartDeposit" } ) // single document deposit
	public void selectFile(String ExcelFilepath, String ExcelDocumentType ) throws Exception{
		/*System.out.println("**********************************");
		System.out.println(ExcelFilepath);
		System.out.println(ExcelDocumentType);*/
		smartDepositPage.depositSingleDocument(ExcelFilepath, ExcelDocumentType);
	}
	
	
	/*@Test(dataProvider = "getdepositTestDataMulti", priority=2)*/
	@Test(priority=2,groups = { "SmartDeposit" } )// for depositing documents one by one form the excel sheet
	public void selectFilemultiFile() throws Exception{
		System.out.println("**********************************");
	
		Object data[][] = getdepositTestDataMulti();
		smartDepositPage.depositMultipleDoc1(data);	
		
		
		// for depositing documents one by one form the excel sheet
		/*for (int i = 0; i < data.length; i++) {
			
			Filepath = (String) data[i][0];
			DocuemntType = (String) data[i][1];
			smartDepositPage.depositMultipleDoc(Filepath, DocuemntType);	

		}*/

	}
	
	
	@AfterMethod(groups = { "SmartDeposit" })
	public void tearDown() throws Exception{
		DriverOperations.logOut();
	}
	
}
