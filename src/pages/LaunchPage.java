package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LaunchPage {

	private WebDriver driver;
	private WebDriverWait wait;

	private By signUpButton = By.xpath("//button[@datatest='submit-signup']");
	private By loginButton = By.cssSelector("button[class='jss27 jss1 jss3 jss6 css-1ipkqoe']");
	private By loginPopUp = By.xpath("//*[@id=\'mainDialogDiv\']/div[2]");
	private By signupPopUp = By.xpath("//*[@id=\'mainDialogDiv\']/div[2]/div");

	public LaunchPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void validate_signup_button_is_enabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
		Assert.assertTrue(
				(driver.findElement(signUpButton).isDisplayed() && driver.findElement(signUpButton).isEnabled()),
				"Signup button in launch page is disabled");

		System.out.println("Signup button in launch page is visible and enabled");

	}

	public void click_on_signup_button() {

		driver.findElement(signUpButton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopUp));
		Assert.assertTrue(driver.findElement(signupPopUp).isDisplayed(),
				"Signup button click in launch page is not working");
		//System.out.println("Signup button click in launch page, signup popup displayed");
	}

	public void validate_login_button_is_enabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		Assert.assertTrue(
				(driver.findElement(loginButton).isDisplayed() && driver.findElement(loginButton).isEnabled()),
				"Login button in launch page is disabled");

		//System.out.println("Login button in launch page is visible and enabled");

	}

	public void click_on_login_button() {

		//driver.findElement(loginButton).click();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginButton))));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPopUp));
		Assert.assertTrue(driver.findElement(loginPopUp).isDisplayed(),
				"Login button click in launch page is not working");
		//System.out.println("Login button click in launch page, login popup displayed");

	}

	public void navigate_forward() {

		driver.navigate().forward();
	}

	public void navigate_back() {

		driver.navigate().back();
	}

	public void page_refresh() {
		
		driver.navigate().refresh();

	}

}
