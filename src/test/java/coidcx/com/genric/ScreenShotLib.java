package coidcx.com.genric;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenShotLib {
	public void getScreenShot(WebDriver driver, String fileName) throws IOException {
		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		File srcFile = efw.getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				"C:\\Users\\jitendratiwari\\git\\CoinDcxTest\\CoinDcxTest\\coidcx.com\\target\\" + fileName + ".png");
		FileUtils.copyFile(srcFile, destFile);

	}

}
