package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.base_Normal_javaClass;
import utility.Utility_CommonMethods_pkg;

public class Listener extends base_Normal_javaClass implements ITestListener
{
  
	// override ITestListener methods
	// 1)onTestFailure--> for failed TC --> SCREENSHOT
	// WE GET AssertionError
	
	@Override
public void onTestFailure(ITestResult result) 
  {
	
	  try {
		Utility_CommonMethods_pkg.capturedScreenshot(driver, result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
	// 2)onTestSuccess--> when TC passed sucessfully
	
  @Override
 public void onTestSuccess(ITestResult result) 
  {
	Reporter.log("TC"+result.getName()+"Passed sucessfully--> from Listener class", true);
  }
  
  // 3)onTestStart--> 
  @Override
public void onTestStart(ITestResult result) 
  {
	Reporter.log("TC execution started for Tc --> "+result.getName()+"--> from Listener class", true);
 }
  
}
