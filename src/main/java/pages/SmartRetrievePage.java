package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserFactory;
import helper.DriverOperations;

public class SmartRetrievePage extends BrowserFactory{
	
	
	@FindBy(xpath = "//input[@id='srch-term-input']")
	WebElement quickSearch;
	

	@FindBy(xpath = "//div[@class='mc-form__input-group-append']")
	WebElement ShowResultQuickSearch;
	

	@FindBy(xpath = "//select[@id='retrieveTableSelect']")
	WebElement RetrieveDocumentType;
	
	@FindBy(xpath = "//input[@id='searchValue0']")
	WebElement Searchvalue;
	
	@FindBy(xpath = "//mosaic-button[@id='btnShowResults btnShowResults ']")
	WebElement ShowResult;
	
	//@FindBy(xpath = "//button[@id='btnSaveSearch']")
	@FindBy(xpath = "//mosaic-button[@id='btnSaveSearch btnSaveSearch ']")
	WebElement SaveSearchButton;
	
	@FindBy(xpath = "//input[@id='searchName']")
	WebElement SearchName;
	
	
	@FindBy(xpath = "//mosaic-button[@class='btn mc-btn__button--info ng-binding mc-btn']//following-sibling::mosaic-button//child::button//child::div[contains(text(),'Save')]")
	//@FindBy(xpath = "//mosaic-button[@id='btnSaveSearch btnSaveSearch ']")
	WebElement SaveSearch; 

	//mosaic-button[@class='btn mc-btn__button--info ng-binding mc-btn']//following-sibling::mosaic-button//child::button//child::div[contains(text(),'Update')]
	
	@FindBy(xpath = "//button[@class='mc-btn__button mc-btn__button--primary mc-btn__button--rounded mc-btn__button--icon-only']")
	WebElement UpdateSearchButton;
	
	
	
	//@FindBy(xpath = "//mosaic-button[@class='btn mc-btn__button--info ng-binding mc-btn']//following-sibling::mosaic-button//child::button//child::div[contains(text(),'Update search')]")
	
	@FindBy(xpath = "//button[@class='mc-btn__button mc-btn__button--info ']")
	WebElement UpdateSearchinner;
	
	@FindBy(xpath = "//mosaic-button[@class='btn mc-btn__button--info ng-binding mc-btn']//following-sibling::mosaic-button//child::button//child::div[contains(text(),'Update')]")
	WebElement UpdateSearch;
	
	@FindBy(xpath = "//button[@class='mc-btn__button mc-btn__button--info mc-btn__button--rounded mc-btn__button--icon-only']")
	WebElement CopysearchButton;
	
	@FindBy(xpath = "//mosaic-button[@class='btn mc-btn__button--info ng-binding mc-btn']//following-sibling::mosaic-button//child::button//child::div[contains(text(),'Copy')]")
	WebElement CopySearch;
	
	//@FindBy(xpath = "//*[@id='savedSearches']/div/span[2]/div/a[4]")
	@FindBy(xpath = "//button[@class='mc-btn__button mc-btn__button--danger mc-btn__button--rounded mc-btn__button--icon-only']")
	WebElement delete;
		 
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement YesDelete;
	
	@FindBy(xpath = "//button[@id='btnRetrieveHome']")
	WebElement clickHome;

	
	public SmartRetrievePage()
	{
		PageFactory.initElements(driver, this);
	}

	
	//using property value
	/*public void QuickSearching(String keyword) throws InterruptedException
	{
		DriverOperations.clearFieldAndEnterStringData(quickSearch, keyword);
		DriverOperations.clickWhenElementIsClickable(ShowResultQuickSearch);
		Thread.sleep(3000);
		//return new SmartRetrievePage();
	}
	
	
	//using property value
	public void AdvanceSearching(String SearchValue) throws InterruptedException
	{
		DriverOperations.selectDropdownOptionByVisibleText(RetrieveDocumentType, "inv_header");
		DriverOperations.clearFieldAndEnterStringData(Searchvalue, SearchValue);
		DriverOperations.clickWhenElementIsClickable(ShowResult);
		Thread.sleep(3000);
	}
	*/
	//direct value
	public void QuickSearching() throws InterruptedException
	{

		DriverOperations.clearFieldAndEnterStringData(quickSearch,"adm");
		DriverOperations.clickWhenElementIsClickable(ShowResultQuickSearch);
		Thread.sleep(3000);
		//return new SmartRetrievePage();
	}
	//direct value
	public void AdvanceSearching() throws InterruptedException
	{
		//driver.navigate().back();
		DriverOperations.clickWhenElementIsClickable(clickHome);
		DriverOperations.selectDropdownOptionByVisibleText(RetrieveDocumentType, "doc1");
		DriverOperations.clearFieldAndEnterStringData(Searchvalue, "administrator");
		
		/*List<WebElement> list1 = driver.findElements(By.xpath("//div[contains(@class,'mc-btn__div ng-binding') and contains(@ng-class, 'mc-btn__div')]"));
		for(int i=0;i<list1.size();i++)
		{
		 //System.out.println(i+" "+list1.getText());
		 //this can be used incase number of elements is more and no time to count there index
		}
		list1.get(4).click();*/
		Thread.sleep(2000);
		DriverOperations.clickWhenElementIsClickable(ShowResult);
		Thread.sleep(2000);
	}
	
	public void sipmleSaveSearch(String SearchValue, String searchName) throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(clickHome);
		DriverOperations.selectDropdownOptionByVisibleText(RetrieveDocumentType, "doc1");
		DriverOperations.clearFieldAndEnterStringData(Searchvalue, SearchValue);
		Thread.sleep(2000);
		/*List<WebElement> list1 = driver.findElements(By.xpath("//div[contains(@class,'mc-btn__div ng-binding') and contains(@ng-class, 'mc-btn__div')]"));
		for(int i=0;i<list1.size();i++)
		{
		 //System.out.println(i+" "+list1.getText());
		 //this can be used incase number of elements is more and no time to count there index
		}
		list1.get(2).click();*/
		
		DriverOperations.clickWhenElementIsClickable(SaveSearchButton);
		DriverOperations.clearFieldAndEnterStringData(SearchName, searchName);
		DriverOperations.clickWhenElementIsClickable(SaveSearch);
		Thread.sleep(3000);
	}
	
	public void UpdateSearch(String searchName) throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(UpdateSearchButton);
		Thread.sleep(3000);
		DriverOperations.clickWhenElementIsClickable(UpdateSearchinner);
		DriverOperations.clearFieldAndEnterStringData(SearchName, searchName);
		DriverOperations.clickWhenElementIsClickable(UpdateSearch);
	}
	
	public void CopySearch(String searchName) throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(CopysearchButton);
		DriverOperations.clearFieldAndEnterStringData(SearchName, searchName);
		DriverOperations.clickWhenElementIsClickable(CopySearch);
	}
	
	public void deleteSearch() throws InterruptedException
	{
		DriverOperations.clickWhenElementIsClickable(delete);
		DriverOperations.clickWhenElementIsClickable(YesDelete);
		Thread.sleep(3000);
	}
	
	
}
