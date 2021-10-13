package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserFactory;
import helper.DriverOperations;

public class HomePage extends BrowserFactory {

	@FindBy(xpath = "//div[contains(text(),'SmartDeposit')]")
	WebElement SmartDepositLink;
	
	@FindBy(xpath = "//div[contains(text(),'SmartRetrieve')]")
	WebElement SmartRetrieveLink;
	
	@FindBy(xpath = "//html")
	WebElement blank;
	
	@FindBy(xpath = "//mosaic-app-name[@class='mc-app-name']")
	WebElement clickHome;
	@FindBy(xpath = "//div[contains(text(),'Select application')]")
	WebElement Selectapplication;
	@FindBy(xpath = "//div[contains(text(),'SmartRetrieve')]")
	WebElement smrt;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		
	}

	public boolean verifydepositlink(){
		blank.click();
		return DriverOperations.isDisplayed(SmartDepositLink);
	}

	public DepositAutoITPage clickDepositLink() {
		DriverOperations.expandTopNavigationMenuAndPerformNavitation1("Select application", "SmartDeposit");
		return new DepositAutoITPage();
	}
	public SmartRetrievePage clickRetrieveLink() throws InterruptedException {
		
		DriverOperations.clickWhenElementIsClickable(clickHome);
		Thread.sleep(2000);
		/*DriverOperations.clickWhenElementIsClickable(Selectapplication);
		DriverOperations.clickWhenElementIsClickable(smrt);*/
		
		DriverOperations.expandTopNavigationMenuAndPerformNavitation1("Select application", "SmartRetrieve");
		return new SmartRetrievePage();
	}
	
}
