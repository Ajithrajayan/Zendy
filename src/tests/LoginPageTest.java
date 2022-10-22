package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.LaunchPage;
import pages.LoginPage;
import pages.SignUpPopUp;

public class LoginPageTest extends BasePage {

	LaunchPage launchPage;
	LoginPage loginPage;
	HomePage homePage;
	SignUpPopUp signUpPopUp;

	@Test(description = "verify login with invalid credentials : invalid Email, no password and no email invalid password ")
	public void loginWithInvalidEmail() {

		try {

			launchPage = new LaunchPage(driver, wait);
			loginPage = new LoginPage(driver, wait);

			launchPage.validate_login_button_is_enabled();
			launchPage.click_on_login_button();

			loginPage.validate_email_textbox_is_enabled();
			loginPage.click_and_type_invalid_email();
			loginPage.validate_login_button_is_disabled();
			loginPage.clear_email_text_box();	
			loginPage.validate_password_textbox_is_enabled();
			loginPage.click_and_type_invalid_password();
			loginPage.validate_login_button_is_disabled();
			
			launchPage.page_refresh();

		} catch (Exception e) {
			Assert.fail(" loginWithInvalidEmail() Exception: " + e.getMessage());
		}

	}

	@Test(description = "verify login with invalid credentials : invalid Email, valid password ")
	public void loginWithInvalidEmailAndValidPassword() {
		try {

			launchPage = new LaunchPage(driver, wait);
			loginPage = new LoginPage(driver, wait);

			launchPage.validate_login_button_is_enabled();
			launchPage.click_on_login_button();

			loginPage.validate_email_textbox_is_enabled();
			loginPage.click_and_type_invalid_email2();
			loginPage.validate_password_textbox_is_enabled();
			loginPage.click_and_type_valid_password();
			loginPage.validate_login_button_is_enabled();
			loginPage.click_login_button();

			loginPage.alert_unexpected_error();

			launchPage.page_refresh();

		} catch (Exception e) {
			Assert.fail(" loginWithInvalidEmailAndValidPassword() Exception: " + e.getMessage());
		}

	}

	@Test(description = "verify login with invalid credentials : valid Email, invalid password ")
	public void loginWithValidEmailAndInvalidPassword() {

		try {

			launchPage = new LaunchPage(driver, wait);
			loginPage = new LoginPage(driver, wait);

			launchPage.validate_login_button_is_enabled();
			launchPage.click_on_login_button();

			loginPage.validate_email_textbox_is_enabled();
			String validEmail = "public@gmail.com" ;
			loginPage.click_and_type_valid_email(validEmail);
			loginPage.validate_password_textbox_is_enabled();
			loginPage.click_and_type_invalid_password();
			loginPage.validate_login_button_is_enabled();
			loginPage.click_login_button();

			loginPage.alert_incorrect_credentials();

			launchPage.page_refresh();

		} catch (Exception e) {
			Assert.fail(" loginWithValidEmailAndInvalidPassword() Exception: " + e.getMessage());
		}

	}

	@Test(description = "verify login with invalid credentials : Unregistered Email and password ")
	public void loginWithUnRegisteredEmailAndPassword() {

		try {

			launchPage = new LaunchPage(driver, wait);
			loginPage = new LoginPage(driver, wait);

			launchPage.validate_login_button_is_enabled();
			launchPage.click_on_login_button();

			loginPage.validate_email_textbox_is_enabled();
			loginPage.click_and_type_unregistered_email();
			loginPage.validate_password_textbox_is_enabled();
			loginPage.click_and_type_unregistered_password();
			loginPage.validate_login_button_is_enabled();
			loginPage.click_login_button();

			loginPage.alert_incorrect_credentials();

			launchPage.page_refresh();

		} catch (Exception e) {
			Assert.fail(" loginWithUnRegisteredEmailAndPassword() Exception: " + e.getMessage());
		}

	}

	@Test(description = " Password eye-click visibility ")
	public void loginEyeClickValidation() {

		try {

			launchPage = new LaunchPage(driver, wait);
			loginPage = new LoginPage(driver, wait);

			launchPage.validate_login_button_is_enabled();
			launchPage.click_on_login_button();

			loginPage.validate_password_textbox_is_enabled();
			loginPage.click_and_type_valid_password();
			loginPage.confirm_password_field_type_before_eye_click(loginPage.get_password_type());
			loginPage.validate_eye_button_is_enabled();
			loginPage.click_eye_button();
			loginPage.confirm_password_field_type_after_eye_click(loginPage.get_password_type());

			launchPage.page_refresh();

		} catch (Exception e) {

			Assert.fail(" loginEyeClickValidation() Exception: " + e.getMessage());
		}

	}

	@Test(description = "verify forgot-password-button without email address")
	public void loginWithForgotPasswordButtonWithoutEmail() {

		try {

			launchPage = new LaunchPage(driver, wait);
			loginPage = new LoginPage(driver, wait);

			launchPage.validate_login_button_is_enabled();
			launchPage.click_on_login_button();

			loginPage.validate_forgot_password_button_is_enabled();
			loginPage.click_forgot_password_button();
			loginPage.confirm_alert_to_enter_email();

			launchPage.page_refresh();

		} catch (Exception e) {
			Assert.fail(" loginWithForgotPasswordButtonWithoutEmail() Exception: " + e.getMessage());
		}

	}

	@Test(description = "verify forgot-password-button with valid email")
	public void loginWithForgotPasswordButton() {

		try {

			launchPage = new LaunchPage(driver, wait);
			loginPage = new LoginPage(driver, wait);

			launchPage.validate_login_button_is_enabled();
			launchPage.click_on_login_button();

			loginPage.validate_email_textbox_is_enabled();
			String validEmail = "private@gmail.com" ;
			loginPage.click_and_type_valid_email(validEmail);
			loginPage.validate_forgot_password_button_is_enabled();
			loginPage.click_forgot_password_button();
			loginPage.valid_alert_for_forgot_password_button_click();
			loginPage.validate_send_email_again_button_is_enabled();
			loginPage.click_send_email_again_button();

			launchPage.page_refresh();

		} catch (Exception e) {
			Assert.fail(" loginWithForgotPasswordButton() Exception: " + e.getMessage());
		}

	}

//////	@Test(description = "verify forgot-password-button with unregistered email")
//////	public void loginWithForgotPasswordButtonWithUnRegisteredMail() {
//////		
//////		try {
//////			
//////			launchPage = new LaunchPage(driver, wait);
//////			loginPage = new LoginPage(driver, wait); 
//////
//////			launchPage.validate_login_button_is_enabled();
//////			launchPage.click_on_login_button();
//////
//////			loginPage.validate_email_textbox_is_enabled();
//////			loginPage.click_and_type_unregistered_email();
//////			loginPage.validate_forgot_password_button_is_enabled();
//////			loginPage.click_forgot_password_button();
//////			loginPage.could_not_reset_password_alert();
//////			loginPage.click_send_email_again_button();
//////			//loginPage.could_not_reset_password_alert();
//////			
//////			launchPage.page_refresh();
//////
//////			
//////		}catch (Exception e) {
//////			
//////			Assert.fail(" loginWithForgotPasswordButtonWithUnRegisteredMail() Exception: " + e.getMessage());
//////		}
//////		
//////	}
////
////	@Test(description = "verify login with facebook id")
////	public void loginWithFacebook() {
////
////		try {
////
////			launchPage = new LaunchPage(driver, wait);
////			loginPage = new LoginPage(driver, wait);
////			homePage = new HomePage(driver, wait);
////
////			launchPage.validate_login_button_is_enabled();
////			launchPage.click_on_login_button();
////
////			loginPage.validate_login_with_facebook_button();
////			loginPage.click_login_with_facebook_button();
////			homePage.wait_for_home_page_load();
////			homePage.confirm_FB_login_user();
////			// launchPage.navigate_back();
////			// homePage.validate_navigate_back_fb();
////			// launchPage.navigate_forward();
////			// homePage.validate_navigate_forward_fb();
////			homePage.user_logout();
////			// loginPage.login_to_user_home_using_fb();
////			launchPage.page_refresh();
////
////		} catch (Exception e) {
////			Assert.fail(" loginWithFacebook() Exception: " + e.getMessage());
////		}
////
////	}
//
////	@Test(description = "verify login with google id")
////	public void loginWithGoogle() {
////
////		try {
////
////			launchPage = new LaunchPage(driver, wait);
////			loginPage = new LoginPage(driver, wait);
////
////			launchPage.validate_login_button_is_enabled();
////			launchPage.click_on_login_button();
////
////			loginPage.validate_login_with_google_button();
////			loginPage.click_login_with_google_button();
////			homePage.wait_for_home_page_load();
////			homePage.confirm_google_login_user();
////			homePage.user_logout();
////
////		} catch (Exception e) {
////			Assert.fail(" loginWithGoogle() Exception: " + e.getMessage());
////		}
////
////	}

	@Test(description = "user sign up")
	public void signup() {

		try {

			homePage = new HomePage(driver, wait);

			launchPage = new LaunchPage(driver, wait);
			loginPage = new LoginPage(driver, wait);
			signUpPopUp = new SignUpPopUp(driver, wait);

			launchPage.validate_signup_button_is_enabled();
			launchPage.click_on_signup_button();

			signUpPopUp.validate_username_textbox_is_visible();
			signUpPopUp.click_and_type_username();
			signUpPopUp.click_and_type_emailAddress();
			signUpPopUp.click_and_type_password();
			signUpPopUp.click_on_signUpButton();
			homePage.user_logout();
			launchPage.page_refresh();

		} catch (Exception e) {
			Assert.fail(" signup() Exception: " + e.getMessage());
			launchPage.page_refresh();
		}
	}

	@Test(description = "verify login with valid credentials")
	public void login() {

		try {
			launchPage = new LaunchPage(driver, wait);
			loginPage = new LoginPage(driver, wait);

			launchPage.validate_login_button_is_enabled();
			launchPage.click_on_login_button();

			loginPage.validate_email_textbox_is_enabled();
			String validEmail = "practice@gmail.com";
			loginPage.click_and_type_valid_email(validEmail);
			loginPage.validate_password_textbox_is_enabled();
			loginPage.click_and_type_valid_password();
			loginPage.validate_login_button_is_enabled();
			loginPage.click_login_button();

		} catch (Exception e) {

			Assert.fail(" login() Exception: " + e.getMessage());

		}

	}

}
