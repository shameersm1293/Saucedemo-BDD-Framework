package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.Scenario;
import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	public static WebDriver driver;

	@Before
	public void setup(Scenario scenario) {

		String browser = ConfigReader.get("BROWSER").toLowerCase();
//		boolean headless = Boolean.parseBoolean(ConfigReader.get("HEADLESS"));

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Unsupported browser: " + browser);
		}
		driver.manage().window().maximize();
	}

	@After
	public void teardown(Scenario scenario) {
		
		if (scenario.isFailed()) { ScreenshotUtils.captureScreenshot(driver, scenario.getName()); }
		if (Hooks.driver != null) {
			Hooks.driver.quit();
		}
	}

}
