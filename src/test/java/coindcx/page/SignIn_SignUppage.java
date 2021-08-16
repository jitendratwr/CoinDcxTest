package coindcx.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn_SignUppage {

	@FindBy(id = "register-btn")
	private WebElement clickONRgister;
	@FindBy(name = "firstName")
	private WebElement enterName;
	@FindBy(name = "lastName")
	private WebElement enterLastName;
	@FindBy(name = "email")
	private WebElement enterEmail;
	@FindBy(name = "password")
	private WebElement enterPAssword;
	@FindBy(name = "phone")
	private WebElement enterPhone;
	@FindBy(xpath = "//button/span[contains(text(),'REGISTER')]")
	private WebElement submitButton;

	@FindBy(xpath = "//iframe[@title='reCAPTCHA']")
	private WebElement IframeCaptch;
	@FindBy(id = "recaptcha-anchor")
	private WebElement clickCheckBx;
	private Boolean isCaptchaInvisible = Boolean.FALSE;

	public SignIn_SignUppage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void signupCoinDcx() {
		clickONRgister.click();
		enterName.sendKeys("Jitendra");
		enterLastName.sendKeys("Tiwari");
		enterEmail.sendKeys("vajaf26252@error57.com");
		enterPAssword.sendKeys("Coin@1234");
		enterPhone.sendKeys("8896918773");

	}

	public void selectCaptcha(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IframeCaptch));
		try {
			clickCheckBx.click();
			System.out.println("CHECKED I am not a robot box. That's not invisible captcha");
		} catch (Exception e) {
			System.out.println("Invisible ReCaptcha detected");
			isCaptchaInvisible = Boolean.TRUE;
			driver.switchTo().defaultContent();
		}
	}

	public void ClickOnRegisterBttn(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		submitButton.click();

	}

}
