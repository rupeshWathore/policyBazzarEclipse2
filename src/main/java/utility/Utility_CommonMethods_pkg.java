package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility_CommonMethods_pkg 
{

	 // Normal java class
	
	// Utility pkg--> Common methods
	// 1) wait
	// 2) Screenshot
	// 3) scrolling
	// 4) readDataFromExcel
	// 5) readData from properties file
	
	static String TCID="PB100";
	
	// 1) wait -- wait
	
		public static void wait(int timeOmS) throws InterruptedException
		{
			Thread.sleep(timeOmS);         // we can modify this like-->1000ms*2
			Reporter.log("Using wait Time-->"+timeOmS, true);  
			
			
		}
			
	    // 2) Screenshot
		public static void capturedScreenshot(WebDriver driver,String SSname) throws IOException
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\rupes\\eclipse-workspace\\policyBazzar\\screenshots\\"+TCID+SSname+".png");
			FileHandler.copy(src, dest);
			Reporter.log("taking ScreenShot and location of storage is-->"+dest, true);
			Reporter.log("ScreenShot name-->"+TCID+SSname, true);
			
		}
		
		// 3) scrolling 
		public static void scrollIntoView(WebDriver driver, WebElement element)
		{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element );
		Reporter.log("Scrolling into view to element-->"+element, true);
		Reporter.log("Scrolling into view to element-->"+element, true);
		}
		
		// 4) readDataFromExcel
		public static String readDataFromExcel(int rowNum, int cellNum) throws EncryptedDocumentException, IOException
		{
		Reporter.log("getting data from Excel->row number "+rowNum+"Cell number "+cellNum, true);
	    FileInputStream myFile= new FileInputStream("E:\\\\Excel file-Selenium\\\\myExcel-1.xlsx"); 
		String value = WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
		 
		}
		
		// 5) readData from properties file
		
		public static String readDataFromPropertyFile(String key) throws IOException
		{
			
			FileInputStream MyFile=new FileInputStream("C:\\Users\\rupes\\eclipse-workspace\\policyBazzar\\MyTestDataPropertyFile1.properties");
		    Properties prop=new Properties();
		    prop.load(MyFile);
		    String value = prop.getProperty(key);
		    Reporter.log("reading data from property file and data is key--> "+key, false);
			return value;
		}
	
}
