package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import config.InputValues;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class HomePage {

	private WebDriverWait wait;
	private WebDriver driver;
	private By userButton = By.xpath("//*[@id=\'root\']/div[1]/div[3]/button");
	private By userButtonText = By.cssSelector("p[class='css-1gj503q']");
	private By menuListItems = By.xpath("//li[@role=\"menuitem\"]");
	private By userSearchTextBox = By.cssSelector("input[type='search']");
	private By searchSubmitButton = By.xpath("//*[@id=\'home-seach-btn\']/div/button");
	private By searchResultListView = By.cssSelector("div[class='css-1vov7xd-search-result-root']");
	private By searched3rdItem = By.id("search-result-2");
	private By ducumentDownloadButton = By.id("downloadLinkBtn");
	private By resultItem = By.xpath("(//*[@class='MuiPaper01215 MuiPaper01219 MuiPaper01216 MuiCard01214 css-46pc45 css-l5ioss-root'])");

	public HomePage(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;

	}

	public void wait_for_home_page_load() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(userButton));
	}

	public void confirm_login_user() {

		Assert.assertTrue(driver.findElement(userButtonText).getText().equalsIgnoreCase(InputValues.USER_1_NAME),
				"Login to user home page was unsuccess");

	}

	public void confirm_FB_login_user() {
		Assert.assertTrue(driver.findElement(userButtonText).getText().equalsIgnoreCase(InputValues.FB_LOGIN_USER),
				"Login to user home page was unsuccess");

	}

	public void validate_search_keyword_textbox_is_enabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(userSearchTextBox));
		Assert.assertTrue((driver.findElement(userSearchTextBox).isDisplayed()
				&& driver.findElement(userSearchTextBox).isEnabled()));
		System.out.println("Search textbox in user home page is visible and enabled");

	}

	public void click_and_type_keyword() {

		driver.findElement(userSearchTextBox).sendKeys(InputValues.USER_SEARCH_KEY);
	}

	public void validate_search_submit_button_is_enabled() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSubmitButton));
		Assert.assertTrue((driver.findElement(searchSubmitButton).isDisplayed()
				&& driver.findElement(searchSubmitButton).isEnabled()));
		System.out.println("Search submit button in user home page is visible and enabled");
	}

	public void click_search_submit_button() {

		// driver.findElement(searchSubmitButton).click();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchSubmitButton))));

	}

	public void display_search_result_of_keyword() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultListView));
		Assert.assertTrue((driver.findElement(searchResultListView).isDisplayed()),
				"Search result view in user home page is not displyaed");
		System.out.println("Search result view in user home page is displyaed");

	}

	public WebElement select_item_from_displayed_search_result() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(searched3rdItem));
		wait.until(ExpectedConditions.visibilityOfElementLocated(resultItem));
		List<WebElement> menuList = driver.findElements(resultItem);
		if(menuList.size()>=3) {
			
			WebElement selectedDoc = menuList.get(2);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectedDoc);
			System.out.println("3rd item in the search result in user home page is displyaed");
			
			return selectedDoc;
		}
		else {
			Assert.assertTrue((menuList.size()>=3), "Search result size less than 3");
			return null;
		}
		
	}

	public String click_download_button_in_selected_item(WebElement selectedDocument) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(ducumentDownloadButton));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ducumentDownloadButton))));

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterat = windows.iterator();
		String homePageId = iterat.next();
		String downloadPageId = iterat.next();
		driver.switchTo().window(downloadPageId);

		return homePageId;

	}

	public void confim_new_window_for_doc_is_opend(String homePageId) {

		wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("about:blank")));

		Assert.assertTrue((driver.getCurrentUrl().equals(InputValues.DOCUMENT_URL)),
				"new window for doc is not opened");

		System.out.println(" New window for doc is opened ");

		driver.switchTo().window(homePageId);

	}

	public void user_logout() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(userButton))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(menuListItems));

		List<WebElement> menuList = driver.findElements(menuListItems);

		for (int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i).getText().equalsIgnoreCase("Log Out")) {

				menuList.get(i).click();

			}
		}

	}

	public void validate_navigate_back_fb() {

		wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("about:blank")));
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://test-app.zendy.io/"),
				"validate_navigate_back_fb:When Fb login user click back button, it load a \"error\":\"Not Authorized\"- blank page");

	}

	public void validate_navigate_forward_fb() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(userButton));
		Assert.assertTrue(driver.findElement(userButtonText).getText().equalsIgnoreCase(InputValues.FB_LOGIN_USER),
				"validate_navigate_forward_fb::Navigate forward is not success ");
	}

	public void confirm_google_login_user() {
		Assert.assertTrue(driver.findElement(userButtonText).getText().equalsIgnoreCase(InputValues.GOOGLE_LOGIN_USER),
				"Login to user home page was unsuccess");
	}

}
