package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import eventlistener.WebEventListener;

public class BrowserFactory {
	
	public static WebDriver driver;
	static String ChromeDriverPath = ".//Drivers//chromedriver.exe";
	static String IEDriverServerPath = ".//Drivers//IEDriverServer.exe";
	static String EdgeDriverServerPath = ".//Drivers//MicrosoftWebDriver.exe";
	
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public WebDriver getDriver() {
        return driver;
    }
	
	public BrowserFactory(){
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

	public static WebDriver launchApplication(String browserName, String url)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{

			System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("IE"))
		{
			
			System.setProperty("webdriver.ie.driver", IEDriverServerPath);
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver",EdgeDriverServerPath); 
			driver = new EdgeDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		long Pageload_wait = Long.parseLong(prop.getProperty("PageloadWait"));
		long Implicit_wait = Long.parseLong(prop.getProperty("ImplicitWait"));
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Pageload_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Implicit_wait, TimeUnit.SECONDS);

		driver.get(url);
		return driver;	
	}


}
