package pages;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BrowserFactory;
import helper.DriverOperations;

public class SoftwareDownloadPage extends BrowserFactory{
	
	
	private static String downloadPath = "C:\\Users\\disha.shah\\Downloads";
	
	@FindBy(xpath = "//*[@id='refreshDownload']")
	WebElement RefreshBtn;
	
	@FindBy(xpath = "//*[@id='dbAdminConsole']")
	WebElement LoginAdminConsole;
	
	
	public SoftwareDownloadPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void DownloadSoftware() throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(RefreshBtn);
		DriverOperations.clickWhenElementIsClickable(LoginAdminConsole);
		Thread.sleep(2000);
		
		/*File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		Assert.assertTrue(fileName.equals("DbLoginAdminConsole.msi"), "Downloaded file name is not matching with expected file name");*/
	}
	
	/*private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
		return dir;
	}*/

}
