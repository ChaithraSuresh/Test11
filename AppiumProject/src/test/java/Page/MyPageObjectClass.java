package Page;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import Base.MyBaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import methods.MyMethodClass;

public class MyPageObjectClass {
	
	public MyPageObjectClass(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(7)), this);
	}

	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility\"]")
	private AndroidElement accessLink;
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Custom View\"]")
	private AndroidElement contextlink;
	
    MyMethodClass method = new MyMethodClass();
	
	public void goTOTheme() {
		method.clickOnElement(accessLink);
		method.clickOnElement(contextlink);
		
}
}
