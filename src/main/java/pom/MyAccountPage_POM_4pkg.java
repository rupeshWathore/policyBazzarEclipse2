package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyAccountPage_POM_4pkg 
  {

//variable 
	@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement userName; 
	
	@FindBy(className = "h_l") private WebElement logoutFromPolicyBazzar; 
	
	
//constructor
	public MyAccountPage_POM_4pkg(WebDriver driver)
	{
	  PageFactory.initElements(driver, this);
	}
	
//methods
	public String validateUserName()
	{
	  Reporter.log("Validating username", true);
	  String actualUN = userName.getText();
	  Reporter.log("username-->"+actualUN, true);
	  return actualUN;
	  
     }           
	
	public void LoggingOutFromPB()
	{
		Reporter.log("Log out from Policy bazzar", true);
		logoutFromPolicyBazzar.click();
	}
	
	public void ClosedBrowserPB(WebDriver driver)
	{
		Reporter.log("Closing chrome browser", true);
		driver.quit();
	}
	
	
	

 }
