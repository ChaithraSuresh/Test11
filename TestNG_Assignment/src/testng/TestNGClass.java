package testng;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.util.MyReports;

@Listeners(testng.MyListeners.class)


public class TestNGClass {
	public WebDriver driver ; 
	MyReports report = new MyReports();
	
	@BeforeTest
	public void launchSwiggy() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\001XXE744\\Downloads\\Module1_FST\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		//report.test.log(LogStatus.PASS, "opened chrome successfully");
	}
	
	@Test(priority = 0)
	public void findFood()  {
		driver.findElement(By.xpath("//div[@class='_1fiQt']")).click();
		//report.test.log(LogStatus.PASS, "find foof");
	}
	
	@Test(priority = 1, dataProvider = "myDP", dataProviderClass = DataproviderClass.class) 
	public void searchRestaurant(String res)   {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//span[normalize-space()='Search'])[1]")).click();
		driver.findElement(By.xpath("//input[@class = '_2BJMh']")).sendKeys(res);
		driver.findElement(By.xpath("//div[@class='_34T1N']//div[@class='GPl4U'][normalize-space()='Restaurant']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='Meghana Foods']")).click();
		//report.test.log(LogStatus.PASS, "Meghana restaurant");
		}
	
	@Test(priority = 2)
	public void verifyItem()  {
		driver.findElement(By.xpath("//div[@class='_1fiQt']")).click();
		WebElement item1 = driver.findElement(By.xpath("(//h3[contains(text(), 'Lemon Chicken')])[1]"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(item1.getText(), "Lemon Chicken");
		System.out.println("Assert passed for verifying item");
		//report.test.log(LogStatus.PASS, "verify item");
	}
	
	@Test(priority = 3)
	public void verifyPrice()  {
		WebElement itemprice = driver.findElement(By.xpath("//div[@id='h-1950595611']//div[9]//div[1]//div[1]//div[1]//div[3]//span[1]//span[1]"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(itemprice.getText(), "290");
		System.out.println("Assert passed for verifying price");
		//report.test.log(LogStatus.FAIL, "verify fail");
		//Assert.fail();
	}
	
	@Test(priority = 4)
	public void addfoodcart()  {
		driver.findElement(By.xpath("(//div[contains(text(), 'ADD')] [@class = '_1RPOp'])[6]")).click();
		report.test.log(LogStatus.PASS, "add to cart");
	}
	
	@Test(priority = 5)
	public void verifynumItem() {
		WebElement numitem = driver.findElement(By.xpath("//div [@class = '_1XFmX']"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(numitem.getText(), "1 ITEM");
		System.out.println("Assert passed for number of items");
		//report.test.log(LogStatus.PASS, "verify number items");
		
	}
	
	@AfterTest
	public void quite() {
		//report.reports.flush();
		//report.reports.endTest(report.test);
		driver.quit();
	}

}
