package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.Utility_CommonMethods_pkg;

public class base_Normal_javaClass 
{
	// Normal java class
	
    // By extending this class anyone can access driver object
	// making driver object as Protected and Static
	// --> to Access them from other packages and static--> To make them fixed/permanent
	
   protected static WebDriver driver;   // declaring driver Object as globally
	
	public void LaunchBrowser()
	{
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get("https://www.policybazaar.com/");
		Reporter.log("Opening browser and Launching URL-->PB", true);
	}
	public void LaunchBrowserUsingPropertyFile() throws IOException
	{
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get(Utility_CommonMethods_pkg.readDataFromPropertyFile("url"));
		Reporter.log("Opening browser and Launching URL-->PB", true);
	}
	
	
	public void ClosedBrowser() throws InterruptedException
	{
		Utility_CommonMethods_pkg.wait(3000);
		driver.quit();
		Reporter.log("Closing Browser", true);
	
		
	}
}
