package config;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {

	public WebDriver setupWebDriver() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOut.MID.getValue()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeOut.MID.getValue()));
		driver.get(AppConstants.ZENDY_URL_HOME);
		return driver;
	}

	public WebDriverWait getWebDriverWait(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOut.HIGH.getValue()));
		return wait;
	}
}
