package Test;

import org.testng.annotations.Test;

import Base.MyBaseClass;
import Page.MyPageObjectClass;


public class MyTestNGClass extends MyBaseClass{
	
	@Test
	public void appimMethod() throws InterruptedException {
		MyPageObjectClass page1 = new MyPageObjectClass(driver);
		page1.goTOTheme();
		
		Thread.sleep(3000);
	}

}
