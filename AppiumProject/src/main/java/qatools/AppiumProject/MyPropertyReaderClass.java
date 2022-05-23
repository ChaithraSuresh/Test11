package qatools.AppiumProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MyPropertyReaderClass {
	
	public String getPropertyValue(String key) {
		String propValue;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/java/props/parameters.properties")));
			propValue = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			propValue = null;
			e.printStackTrace();
		} catch (IOException e) {
			propValue = null;
			e.printStackTrace();
		}
		
		return propValue;
	}

}
