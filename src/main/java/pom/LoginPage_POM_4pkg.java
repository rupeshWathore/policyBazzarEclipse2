package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage_POM_4pkg 
{
//variable 
	@FindBy(xpath = "//a[text()='Sign in']") private WebElement signInButtonHomePage;
	
	@FindBy(xpath = "(//input[@type='number'])[2]")private WebElement mobileNumberFiled;
	
	@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]") private WebElement signInWithPassword; 
	
	@FindBy(name = "password") private WebElement passwordField;
	
	@FindBy(xpath = "//span[text()='Sign in']") private WebElement signInButton;
	
	@FindBy(xpath = "//div[text()='My Account']") private WebElement myAccountButton;
	
	@FindBy(xpath = "//span[text()=' My profile ']")private WebElement myProfile;
	
	
//constructor
	public LoginPage_POM_4pkg(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
//methods
	public void clickOnHomePageSignInButton()
	{
	    Reporter.log("clicking On Home Page SignIn Button", true);
		signInButtonHomePage.click();
	}
	
	public void enterMobileNum(String mobNum)
	{
		Reporter.log("entering Mobile Number", true);
		mobileNumberFiled.sendKeys(mobNum);
	}
	
	public void clickOnSignInWithPassword()
	{
		Reporter.log("clicking On SignIn With Password", true);
		signInWithPassword.click();
	}
	
	public void enterPassword(String password)
	{
	  Reporter.log("entering Password", true);
	  passwordField.sendKeys(password);
	}
	public void clickOnSignInButton()
	{
		Reporter.log("clicking On SignIn Button", true);
		signInButton.click();
	}
	public void clickOnMyAccountButton()
	{
		Reporter.log("clicking On MyAccount Button", true);
		myAccountButton.click();
	}
	public void clickOnMyProfileButton()
	{
		Reporter.log("clicking On MyProfile Button", true);
		myProfile.click();
	}
	
	
}
