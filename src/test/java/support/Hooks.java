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
		ExtentTestManager.startTest(scenario.getName());

		String browser = ConfigReader.get("BROWSER").toLowerCase();
		boolean headless = Boolean.parseBoolean(ConfigReader.get("HEADLESS"));

		switch (browser) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			if (headless)
				chromeOptions.addArguments("--headless=new");
			chromeOptions.addArguments("--disable-save-password-bubble");
			chromeOptions.addArguments("--disable-password-manager");
			driver = new ChromeDriver(chromeOptions);
			break;

		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			if (headless)
				edgeOptions.addArguments("--headless=new");
			driver = new EdgeDriver(edgeOptions);
			break;

		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (headless)
				firefoxOptions.addArguments("--headless");
			driver = new FirefoxDriver(firefoxOptions);
			break;

		default:
			throw new RuntimeException("Unsupported browser: " + browser);
		}

//		ChromeOptions options = new ChromeOptions();
//		
//		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@After
	public void teardown(Scenario scenario) {
		if (scenario.isFailed()) { 
			String screenshotPath = ScreenshotUtils.captureScreenshot(driver, scenario.getName());
			ExtentTestManager.getTest().fail("Scenario failed: " + scenario.getName()).addScreenCaptureFromPath(screenshotPath); // Optionally attach screenshot here 
			} 
		else { ExtentTestManager.getTest().pass("Scenario passed: " + scenario.getName()); 
		} ExtentTestManager.endTest();
		if (Hooks.driver != null) {
			Hooks.driver.quit();
		}
	}

	}
