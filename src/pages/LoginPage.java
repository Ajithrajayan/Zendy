package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import config.InputValues;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	private By loginHomeButton = By.cssSelector("button[class='jss27 jss1 jss3 jss6 css-1ipkqoe']");
	private By loginPopUp = By.xpath("//*[@id=\'mainDialogDiv\']/div[2]");
	private By emailTextbox = By.id("email");
	private By passwordTextbox = By.id("password");
	private By loginButton = By.id("sign_in_btn");
	private By googleSignInButton = By.id("google_sign_in_button");
	private By facebookSignInButton = By.id("facebook_sign_in_button");
	private By loginUnexpectedAlertLabel = By.xpath("//*[@id=\'mainDialogDiv\']/div[2]/div[1]");
	private By loginIncorrectCredentialsAlertLabel = By.xpath("//*[@id=\'mainDialogDiv\']/div[2]/div[1]");
	private By loginForgotPasswordButton = By.xpath("//*[@id=\'mainDialogDiv\']/div[2]/div[5]/div[2]/button");
	private By loginFBEmailTextbox = By.id("email_container");
	// private By loginFBPasswordTextbox = By.id("pass");
	// private By loginFBloginButton = By.id("loginbutton");
	private By loginGooglePageTitle = By.xpath("//*[@id=\"initialView\"]/div[2]/div/div[1]/div");
	private By eyeButton = By.xpath("//*[local-name()='svg' and @data-prefix=\'fas\']/*[local-name()='path']");
	private By checkMailAlertLabel = By.xpath("//*[@id=\'mainDialogDiv\']/div[2]/h2");
	private By sendMailAgainButton = By.xpath("//*[@id=\'mainDialogDiv\']/div[2]/div[2]/div/button"); 
	private By enterRegisteredMailAlertLabel = By.xpath("//*[@id=\'mainDialogDiv\']/div[2]/div[1]");
	private By couldNotResetAlert = By.xpath("//span[.='Could not reset the password for the account, please contact support or try again.']");//*[@id="mainDialogDiv"]/div[2]/div[1]
	private By alertForgotPassUnregUser = By.xpath("//div[@class='css-1tryzzb']/span");
	private By alertForgotPassUnregUserSendMailButton = By.className("css-1dypfp9");

	public LoginPage(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;
	}

	public void validate_email_textbox_is_enabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextbox));
		Assert.assertTrue(
				(driver.findElement(emailTextbox).isDisplayed() && driver.findElement(emailTextbox).isEnabled()),
				"Email textbox in login popup is disabled");

		//System.out.println("Email Textbox in login popup is visible and enabled");
	}

	public void validate_password_textbox_is_enabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextbox));
		Assert.assertTrue(
				(driver.findElement(passwordTextbox).isDisplayed() && driver.findElement(passwordTextbox).isEnabled()),
				"Password textbox in login popup is disabled");

	}

	public void validate_login_button_is_disabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		Assert.assertTrue(
				!(driver.findElement(loginButton).isDisplayed() && driver.findElement(loginButton).isEnabled()),
				"Login button in login popup is enabled");

		
	}
	
	public void validate_login_button_is_enabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		Assert.assertTrue(
				(driver.findElement(loginButton).isDisplayed() && driver.findElement(loginButton).isEnabled()),
				"Login button in login popup is disabled");

	}

	public void click_and_type_valid_email(String validEmail) {

		//driver.findElement(emailTextbox).sendKeys(InputValues.USER_1_EMAIL_ID);
		driver.findElement(emailTextbox).sendKeys(validEmail);
	}

	public void click_and_type_valid_password() {

		driver.findElement(passwordTextbox).sendKeys(InputValues.PASSWORD);
	}

	public void click_login_button() {

		//driver.findElement(loginButton).click();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginButton))));
		
	}

	public void click_and_type_invalid_email() {

		driver.findElement(emailTextbox).sendKeys(InputValues.USER_INVALID_EMAIL_1);
		
		
	}

	public void click_and_type_invalid_email2() {

		driver.findElement(emailTextbox).sendKeys(InputValues.USER_INVALID_EMAIL_2);
	}

	public void click_and_type_unregistered_email() {

		driver.findElement(emailTextbox).sendKeys(InputValues.USER_UNREGISTERED_EMAIL);

	}

	public void click_and_type_unregistered_password() {

		driver.findElement(passwordTextbox).sendKeys(InputValues.USER_UNREGISTERED_PASSWORD);

	}

	public void click_and_type_invalid_password() {

		driver.findElement(passwordTextbox).sendKeys(InputValues.USER_INVALID_PASSWORD);
	}

	public void validate_login_with_facebook_button() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(facebookSignInButton));
		Assert.assertTrue(
				(driver.findElement(facebookSignInButton).isDisplayed()
						&& driver.findElement(facebookSignInButton).isEnabled()),
				"Facebook sign in button in login popup is disabled");

		System.out.println("Facebook sign in button in login popup is visible and enabled");

	}

	public void click_login_with_facebook_button() {

		driver.findElement(facebookSignInButton).click();

	}

	public void validate_login_with_google_button() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(googleSignInButton));
		Assert.assertTrue(
				(driver.findElement(googleSignInButton).isDisplayed()
						&& driver.findElement(googleSignInButton).isEnabled()),
				"Google sign in button in login popup is disabled");

		
	}

	public void click_login_with_google_button() {

		driver.findElement(googleSignInButton).click();

	}

	public void alert_unexpected_error() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(loginUnexpectedAlertLabel));
		Assert.assertTrue(
				(driver.findElement(loginUnexpectedAlertLabel).getText().contains(InputValues.LOGIN_ALERT_MSG_1)),
				"Alert : 'unexpected error...' is not displyaed");

		System.out.println("Alert : 'unexpected error...' is displyaed");

	}

	public void alert_incorrect_credentials() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(loginIncorrectCredentialsAlertLabel));
		Assert.assertTrue(
				(driver.findElement(loginIncorrectCredentialsAlertLabel).getText()
						.contains(InputValues.LOGIN_ALERT_MSG_2)),
				"Alert : 'Incorrect credentials...' is not displyaed");

		System.out.println("Alert : 'Incorrect credentials...' is displyaed");

	}

	public void validate_eye_button_is_enabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(eyeButton));
		Assert.assertTrue((driver.findElement(eyeButton).isDisplayed() && driver.findElement(eyeButton).isEnabled()),
				"Eye button in login popup is disabled");

		System.out.println("Eye button in login popup is visible and enabled");

	}

	public String get_password_type() {

		return driver.findElement(passwordTextbox).getAttribute("type");
	}

	
	public void click_eye_button() {

		driver.findElement(eyeButton).click();

	}

	public void confirm_password_field_type_before_eye_click(String typeBeforeEyeClick) {

		Assert.assertTrue((typeBeforeEyeClick.equalsIgnoreCase("password")),
				" The password field type is not 'password', not invisisble ");
		System.out.println(" The password field type is 'password', password text is invisisble before eye click ");

	}

	public void confirm_password_field_type_after_eye_click(String typeAfterEyeClick) {

		Assert.assertTrue((typeAfterEyeClick.equalsIgnoreCase("text")),
				" The password field type is not 'text', not visisble ");
		System.out.println(" The password field type is 'text', password text is visisble after eye click ");

	}

	public void validate_forgot_password_button_is_enabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(loginForgotPasswordButton));
		Assert.assertTrue(
				(driver.findElement(loginForgotPasswordButton).isDisplayed()
						&& driver.findElement(loginForgotPasswordButton).isEnabled()),
				"Forgot-password-button in login popup is disabled");

		System.out.println("Forgot-password-button in login popup is visible and enabled");

	}

	public void click_forgot_password_button() {

		driver.findElement(loginForgotPasswordButton).click();

	}

	public void valid_alert_for_forgot_password_button_click() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(checkMailAlertLabel));
		Assert.assertTrue(
				(driver.findElement(checkMailAlertLabel).getText()
						.equalsIgnoreCase(InputValues.LOGIN_ALERT_CHECK_MAIL)),
				"Email for reset password by forgot-password-click is not sent ");
		System.out.println(" Email for reset password by forgot-password-click is sent ");

	}

	public void validate_send_email_again_button_is_enabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(sendMailAgainButton));
		Assert.assertTrue(
				(driver.findElement(sendMailAgainButton).isDisplayed()
						&& driver.findElement(sendMailAgainButton).isEnabled()),
				"Send-mail-again-button in login popup is disabled");

		System.out.println("Send-mail-again-button in login popup is visible and enabled");

	}

	public void click_send_email_again_button() {

		driver.findElement(alertForgotPassUnregUserSendMailButton).click();

	}

	public void confirm_alert_to_enter_email() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(enterRegisteredMailAlertLabel));
		Assert.assertTrue(
				(driver.findElement(enterRegisteredMailAlertLabel).getText()
						.equalsIgnoreCase(InputValues.LOGIN_ALERT_ENTER_REGISTERED_MAIL)),
				"Enter-Registered-Mail-Alert is not displyaed");
		System.out.println("Enter-Registered-Mail-Alert is displyaed");

	}

	public void could_not_reset_password_alert() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(alertForgotPassUnregUser));
		Assert.assertTrue(
				(driver.findElement(alertForgotPassUnregUser).getText().equalsIgnoreCase(InputValues.LOGIN_ALERT_FORGOT_P_COULD_NOT_RESET)),
				"could-not-reset-password-Alert is not displyaed");
		System.out.println("could-not-reset-password-Alert is displyaed");

	}

	public void clear_email_text_box() {
		
		driver.findElement(emailTextbox).clear();
		
	}
    public void clear_password_text_box() {
		
    	driver.findElement(passwordTextbox).clear();
		
	}

	

	
	
	
	
	

}
