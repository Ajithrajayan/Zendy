package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;

public class HomePageTest extends BasePage {

	HomePage homePage;

	@Test(description = "Confirm the logined user")
	public void confirmLoginedUser() {

		try {

			homePage = new HomePage(driver, wait);

			homePage.wait_for_home_page_load();
			homePage.confirm_login_user();

		} catch (Exception e) {
			Assert.fail(" confirmLoginedUser() Exception: " + e.getMessage());
		}

	}

	@Test(description = "Enter keyword to search")
	public void searchTheKeyword() {

		try {

			homePage = new HomePage(driver, wait);

			homePage.wait_for_home_page_load();
			homePage.validate_search_keyword_textbox_is_enabled();
			homePage.click_and_type_keyword();
			homePage.validate_search_submit_button_is_enabled();
			homePage.click_search_submit_button();

			homePage.display_search_result_of_keyword();

		} catch (Exception e) {

			Assert.fail(" searchTheKeyword() Exception: " + e.getMessage());

		}

	}

	@Test(description = "Select 3rd item from search-result-list ")
	public void selectItemFromResult() {

		try {

			homePage = new HomePage(driver, wait);

			WebElement selectedDocument = homePage.select_item_from_displayed_search_result();
			if (selectedDocument != null) {

				String parentPageId = homePage.click_download_button_in_selected_item(selectedDocument);
				homePage.confim_new_window_for_doc_is_opend(parentPageId);
			}

		} catch (Exception e) {
			Assert.fail(" selectItemFromResult() Exception: " + e.getMessage());
		}

	}

	@Test(description = "Logout from user logined page")
	public void logout() {

		try {

			homePage = new HomePage(driver, wait);
			homePage.wait_for_home_page_load();
			homePage.user_logout();

		} catch (Exception e) {

			Assert.fail(" logout() Exception: " + e.getMessage());
		}

	}

}
