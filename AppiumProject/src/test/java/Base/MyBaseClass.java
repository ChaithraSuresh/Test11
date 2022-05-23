package Base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import qatools.AppiumProject.MyConstantsClass;
import qatools.AppiumProject.MyPropertyReaderClass;


public class MyBaseClass {
	public AndroidDriver<MobileElement> driver;
	@BeforeSuite
	public void setupDriver() throws MalformedURLException {
		MyPropertyReaderClass pReader = new MyPropertyReaderClass();
		DesiredCapabilities cap = new DesiredCapabilities();
		URL appiumURL = new URL("http://127.0.0.1:4724/wd/hub/");
		
		  cap.setCapability(MyConstantsClass.platform_name, pReader.getPropertyValue(MyConstantsClass.platform_name));
		  cap.setCapability(MyConstantsClass.device_name, pReader.getPropertyValue(MyConstantsClass.device_name));
		  cap.setCapability(MyConstantsClass.platform_version, pReader.getPropertyValue(MyConstantsClass.platform_version));
		  cap.setCapability(MyConstantsClass.app_activity, pReader.getPropertyValue(MyConstantsClass.app_activity));
		  cap.setCapability(MyConstantsClass.app_package,pReader.getPropertyValue(MyConstantsClass.app_package));
		 
		  driver = new AndroidDriver<MobileElement>(appiumURL, cap);
	}
	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}
	
}
