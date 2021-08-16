package coidcx.com.genric;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseLib {


		   public WebDriver driver;
		    
			@BeforeMethod
			@Parameters("Browsers")
			public void PreCondtion(String BrowserName) throws IOException, Exception 
			{
			  if(BrowserName.equalsIgnoreCase("Chrome")) {
				  WebDriverManager.chromedriver().setup();
				  driver= new ChromeDriver();
				  
			  }
			  else if(BrowserName.equalsIgnoreCase("Edge")) {
				  WebDriverManager.edgedriver().setup();
				  driver= new EdgeDriver();
			  }
			  else if(BrowserName.equalsIgnoreCase("FireFox"))
			  {
				  WebDriverManager.firefoxdriver().setup();
				  driver=new FirefoxDriver();
			  }
			  
			  driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
			  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			  driver.get(GetPropertyFile.getProperty("CoinDcxUrl"));
			 
			  
			}
			
			
			@AfterMethod
			 public void postCondtion(ITestResult result) throws IOException
			 
			 {
				if(result.isSuccess()) {
					Reporter.log("Scripts Passed ", true);
				}
		       else{
					String fileName = result.getMethod().getMethodName();
					Reporter.log(fileName+" Falied ", true);
					ScreenShotLib ssl= new ScreenShotLib();
					ssl.getScreenShot(driver, fileName);
					
				}
				}

}
