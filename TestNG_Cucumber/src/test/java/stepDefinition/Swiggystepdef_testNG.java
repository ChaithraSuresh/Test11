package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

public class Swiggystepdef_testNG {
	WebDriver driver;
	
	@Before
    public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\001XXE744\\Downloads\\Module1_FST\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    }
	
	@Given("^I am on automationpractice$")
	public void i_am_on_www_automationpractice_com()  {
		driver.get("https://www.swiggy.com/");
	}
	
	@When("^I click on findfood link$")
	public void i_click_on_SignIn_link()  {
		driver.findElement(By.xpath("//div[@class='_1fiQt']")).click();
	}

	@When("^I search restaurant$")
	public void i_enter_username()  {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//span[normalize-space()='Search'])[1]")).click();
		driver.findElement(By.xpath("//input[@class = '_2BJMh']")).sendKeys("Meghana");
		driver.findElement(By.xpath("//div[@class='_34T1N']//div[@class='GPl4U'][normalize-space()='Restaurant']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='Meghana Foods']")).click();
		}

	
	@When("^I verify the item$")
	public void i_enter_password()  {
		WebElement item1 = driver.findElement(By.xpath("(//h3[contains(text(), 'Lemon Chicken')])[1]"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(item1.getText(), "Lemon Chicken");
		System.out.println("Assert passed");
			
	}

	@When("^I add food to cart$")
	public void i_click_SigIn_button()  {
		driver.findElement(By.xpath("(//div[contains(text(), 'ADD')] [@class = '_1RPOp'])[6]")).click();
		
	}

	@Then("^I verify number of items$")
	public void i_should_be_logged_in_to_the_application() {
		WebElement numitem = driver.findElement(By.xpath("//div [@class = '_1XFmX']"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(numitem.getText(), "1 ITEM");
		System.out.println("Assert passed");
		
	}
		
	@After
	public void teardown() {
		driver.quit();
		
	}
}
