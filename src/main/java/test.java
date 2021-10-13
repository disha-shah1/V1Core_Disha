import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class test {

	public static void main(String[] args) {
		
				// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver","D://Automation//V1Core//Drivers//MicrosoftWebDriver.exe"); 
		 
        WebDriver driver = new EdgeDriver();
        
        //driver.navigate.to("https://www.softwaretestingmaterial.com/software-testing-interview-questions-free-ebook/");
        driver.get("http://localhost:5002");
        
        System.out.println("Selenium Webdriver Script to launch edge browser using Microsoft WebDriver | Software Testing Material");
        
        //driver.close();

	}

}
