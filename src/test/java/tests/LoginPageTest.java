package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BrowserFactory;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;

	
	public LoginPageTest(){
		super();
	}

	@BeforeMethod(groups = { "login" })
	public void setUp() throws Exception
	{	
		BrowserFactory.launchApplication(prop.getProperty("Browser"), prop.getProperty("URL"));
		loginPage = new LoginPage();
	}

//	@Test(priority=0, groups = { "Login" })
//	public void loginPageTitleTest(){
//		String title = loginPage.validateLoginPageTitle();
//		String expectedLoginPageTitle = "Consensus";
//		Assert.assertEquals(title, expectedLoginPageTitle);
//	}
	
	/*@Test(priority=1, groups = { "login" })
	public void advancedLogoImageTest() throws Exception{
		boolean flag = loginPage.validateV1Image();
		Assert.assertTrue(flag);
		Thread.sleep(3000);
	}
	*/
	@Test(groups = { "login" })
	public void verifiedValidLogin() throws Throwable {
		homePage =  loginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Thread.sleep(3000);

	}

	@AfterMethod(groups = { "login" })
	public void tearDown()
	{
		driver.quit();
		
	}
	

}
