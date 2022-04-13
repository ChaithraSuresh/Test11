package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.SwiggyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SwiggyPageStepDef {

	WebDriver driver;
	SwiggyPage swiggyPage ;
	
	@Given("^I am on automationpractice$")
	public void i_am_on_www_automationpractice_com()  {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\001XXE744\\Downloads\\Module1_FST\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		
	}
	
	@When("^I click on findfood link$")
	public void i_click_on_SignIn_link()  {
		swiggyPage = new SwiggyPage(driver);
		//swiggyPage.clickOnSignIn();
		swiggyPage.clickOnFindFood();
	}

	@When("^I search restaurant$")
	public void i_enter_username()  {
		swiggyPage = new SwiggyPage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		swiggyPage.searchrestaurant();
		swiggyPage.selectrestaurant();
		
		}

	
	@When("^I verify the item$")
	public void i_enter_password()  {
		swiggyPage = new SwiggyPage(driver);
		Assert.assertEquals(swiggyPage.getValidationMessage(), "Lemon Chicken");
		System.out.println("Assert passed for verifying item name");
		
	}
	
	@When("^I verify the price$")
	public void i_verify_price()  {
		swiggyPage = new SwiggyPage(driver);
		Assert.assertEquals(swiggyPage.verifyPrice(), "290");
		System.out.println("Assert passed for price");
			
	}

	@When("^I add food to cart$")
	public void i_click_SigIn_button()  {
		swiggyPage = new SwiggyPage(driver);
		swiggyPage.addfooditem();
		
	}
	
	@When("^I add one more item to cart$")
	public void i_add_onemore_item()  {
		swiggyPage = new SwiggyPage(driver);
		swiggyPage.addfooditem();
		
	}

	@Then("^I verify number of items$")
	public void i_should_be_logged_in_to_the_application() {
		swiggyPage = new SwiggyPage(driver);
		Assert.assertEquals(swiggyPage.countitem(), "2 ITEMS");
		System.out.println("Assert passed for verifying number of item");
	}
	
	@After
	public void quite() {
		driver.quit();
	}
}
