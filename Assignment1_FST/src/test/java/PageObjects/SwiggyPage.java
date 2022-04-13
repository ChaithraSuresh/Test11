package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwiggyPage {

	public SwiggyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id = 'location']")
	private WebElement findfoodlink;
	
	@FindBy(xpath = "//div[@class='_1fiQt']")
	private WebElement locationselect1;
	
	@FindBy(xpath = "(//span[normalize-space()='Search'])[1]")
	private WebElement searchbutton;
	
	@FindBy(xpath = "//input[@class = '_2BJMh']")
	private WebElement restaurantbar;
	
	@FindBy(xpath = "//div[@class='_34T1N']//div[@class='GPl4U'][normalize-space()='Restaurant']")
	private WebElement restaurant;
	
	@FindBy(xpath = "//div[normalize-space()='Meghana Foods']")
	private WebElement restaurantname;
	
	@FindBy(xpath = "(//h3[contains(text(), 'Lemon Chicken')])[1]")
	private WebElement item;
	
	@FindBy(xpath = "(//div[@class='_1RPOp'][normalize-space()='ADD'])[9]")
	private WebElement additem;
	
	@FindBy(xpath = "//div[@class = '_1XFmX']")
	private WebElement numberofitem;
	
	@FindBy(xpath = "//div[@id='h-1950595611']//div[9]//div[1]//div[1]//div[1]//div[3]//span[1]//span[1]")
	private WebElement Price;
	
	
	
	
	@FindBy(id = "email")
	private WebElement emailTextBox;
	@FindBy(id = "passwd")
	private WebElement passwordTextBox;
	@FindBy(id="SubmitLogin")
	private WebElement submitButton;
	@FindBy(css = "div[class='alert alert-danger'] ol li")
	private WebElement validationErrorMessage;
	
	public void clickOnSignIn() {
		findfoodlink.click();
		//findfoodlink.sendKeys("bangalore");
		
	}
	
	public void searchrestaurant() {
		searchbutton.click();
		restaurantbar.sendKeys("Meghana");
		
	}
	public void selectrestaurant() {
		restaurant.click();
		restaurantname.click();
		
	}
	public void addfooditem() {
		additem.click();
		
	}
	public String countitem() {
		return numberofitem.getText();
		
	}
	
	/*public void loginToApplication(String username, String password) {
		emailTextBox.clear();
		emailTextBox.sendKeys(username);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		submitButton.click();
	}*/
	public String getValidationMessage() {
		return item.getText();
	}
	public void clickOnFindFood() {
		locationselect1.click();
		
	}

	public String verifyPrice() {
		return Price.getText();
	}
	
}
