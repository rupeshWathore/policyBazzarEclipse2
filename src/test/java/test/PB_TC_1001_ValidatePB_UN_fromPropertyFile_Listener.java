package test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.base_Normal_javaClass;
import pom.LoginPage_POM_4pkg;
import pom.MyAccountPage_POM_4pkg;
import utility.Utility_CommonMethods_pkg;

// commenting to run from suite
//@Listeners(test.Listener.class)
public class PB_TC_1001_ValidatePB_UN_fromPropertyFile_Listener extends base_Normal_javaClass
{
	
	LoginPage_POM_4pkg LogIn;
	MyAccountPage_POM_4pkg MyACC;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException, IOException 
	{
		Utility_CommonMethods_pkg.wait(500);
		LaunchBrowserUsingPropertyFile();
		LogIn =new LoginPage_POM_4pkg(driver);
		MyACC =new MyAccountPage_POM_4pkg(driver);
		
	}
	
	// reading data from property file
	@BeforeMethod
  public void LoginIntoPolicyBazzar() throws InterruptedException, EncryptedDocumentException, IOException 
  {
		Utility_CommonMethods_pkg.wait(1000);                             
		LogIn.clickOnHomePageSignInButton();
		Utility_CommonMethods_pkg.wait(1000); 
		
		LogIn.enterMobileNum(Utility_CommonMethods_pkg.readDataFromPropertyFile("UserName"));
		Utility_CommonMethods_pkg.wait(1000);  
		
		LogIn.clickOnSignInWithPassword();
		Utility_CommonMethods_pkg.wait(1000);  
		
		LogIn.enterPassword(Utility_CommonMethods_pkg.readDataFromPropertyFile("password"));
		Utility_CommonMethods_pkg.wait(2000);  
		
		LogIn.clickOnSignInButton();
		Utility_CommonMethods_pkg.wait(2000);  
		
		LogIn.clickOnMyAccountButton();
		Utility_CommonMethods_pkg.wait(2000);  
		
		LogIn.clickOnMyProfileButton();
		Utility_CommonMethods_pkg.wait(2000);  
		
		//new tab will be opened, we need to switch to new tab
		Set<String> allID = driver.getWindowHandles();
		List<String> al= new ArrayList<>(allID);
				
		//switching focus to myAccount page
		driver.switchTo().window(al.get(1));
		Thread.sleep(3000);
	  
    }
	
	@Test
	public void validateUsernamePB() throws EncryptedDocumentException, IOException
	{
		String ExpUserName = Utility_CommonMethods_pkg.readDataFromPropertyFile("ExpResult");
		String ActualUN = MyACC.validateUserName();
		Assert.assertEquals(ActualUN, ExpUserName,"ActualUN & ExpUserName are not matching,TC is failed");
	
		// commenting for taking ScreenShot of failed TC
		// Changing value of Expected result in property file--> for failing TC
		// WE GET AssertionError
		//	Utility_CommonMethods_pkg.capturedScreenshot(driver, ActualUN);
		
	}
	@AfterMethod
	public void LogOutPB() throws InterruptedException
	{
	Thread.sleep(2000);
		//Utility_CommonMethods_pkg.wait(3000);
		MyACC.LoggingOutFromPB();
	}
	
	@AfterClass
	public void ClosedChromeBrowser() throws InterruptedException
	{
		//Thread.sleep(5000);
		Utility_CommonMethods_pkg.wait(3000);
		ClosedBrowser();
	}
	
	
	
	
	
}
