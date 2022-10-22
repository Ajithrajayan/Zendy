package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPopUp {

	Faker faker = new Faker();

	public By userNameTextbox = By.id("firstName");
	public By emailAddressTextbox = By.id("email");
	public By passwordTextbox = By.id("password");
	public By signUpButton = By.id("sign_up_btn");

	WebDriver driver;
	WebDriverWait wait;

	public SignUpPopUp(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void validate_username_textbox_is_visible() {

		if (driver.findElement(userNameTextbox).isDisplayed()) {
			System.out.println("User name text is Visible");
		} else {
			System.out.println("User name text is Visible");
		}
	}

	public void click_and_type_username() {
		driver.findElement(userNameTextbox).sendKeys(faker.name().firstName());
	}

	public void click_and_type_password() {
		driver.findElement(passwordTextbox).sendKeys(faker.internet().password() + "T");
	}

	public void click_and_type_emailAddress() {
		driver.findElement(emailAddressTextbox).sendKeys(faker.internet().emailAddress());
	}

	public void click_on_signUpButton() {
		// driver.findElement(signUpButton).click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signUpButton))));

	}

}
