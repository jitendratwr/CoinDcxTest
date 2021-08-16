package coindcx.scripts;

import org.testng.annotations.Test;

import coidcx.com.genric.BaseLib;
import coindcx.page.LandingPage;
import coindcx.page.SignIn_SignUppage;

public class SignUpCoinDcx extends BaseLib {
	
	@Test
	public void signUPValid() {
		LandingPage lp = new LandingPage(driver);
		lp.clickOnLoginLink(driver);
		SignIn_SignUppage signUP = new SignIn_SignUppage(driver);
		signUP.signupCoinDcx();
		signUP.selectCaptcha(driver);
		signUP.ClickOnRegisterBttn(driver);
		
	}
	
    
}
