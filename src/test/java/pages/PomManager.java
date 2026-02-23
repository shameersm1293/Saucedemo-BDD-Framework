package pages;

import org.openqa.selenium.WebDriver;

public class PomManager {

	public WebDriver driver;

	private SauceDemoLogin sd;
	private ProductPage pp;
	private CheckoutPage cp;

	public PomManager(WebDriver driver2) {
		this.driver = driver2;
	}

	public SauceDemoLogin SauceTesting() {

		sd = new SauceDemoLogin(driver);
		return sd;
	}

	public ProductPage product() {
		pp = new ProductPage(driver);
		return pp;
	}

	public CheckoutPage Checkout() {

		cp = new CheckoutPage(driver);
		return cp;
	}

}
