package coindcx.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class LandingPage {
	@FindBy(xpath="//div[contains(@class,'header-right-section')]//a[text()='Login']")
	private WebElement clickOnLoginlink;

	
	public  LandingPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginLink(WebDriver driver) {
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", clickOnLoginlink);
		
		
	}
	

}

