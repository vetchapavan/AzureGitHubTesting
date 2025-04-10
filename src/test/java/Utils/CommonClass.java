package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonClass {
	
	public static String getproperties(String Key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Utils//url.properties");
		prop.load(fis);
		return prop.getProperty(Key);
		
	}

}
