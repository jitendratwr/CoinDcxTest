package coidcx.com.genric;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetPropertyFile {

	public static String getProperty(String key) {
		String value = "";
		Properties prop = new Properties();
		String path = "C:\\Users\\jitendratiwari\\git\\CoinDcxTest\\CoinDcxTest\\coidcx.com\\src\\test\\resources\\Config.properties";
		try {
			prop.load(new FileInputStream(new File(path)));
			value = prop.getProperty(key);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return value;
	}

}
