package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import config.DriverUtil;
import config.TimeOut;

public class BasePage {
	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeTest
	public void setUp() {
		DriverUtil driverUtil = new DriverUtil();
		driver = driverUtil.setupWebDriver();
		wait = driverUtil.getWebDriverWait(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeOut.MID.getValue()));
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
