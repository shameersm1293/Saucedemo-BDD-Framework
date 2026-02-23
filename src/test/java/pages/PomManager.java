package pages;

import org.openqa.selenium.WebDriver;

public class PomManager {
	
	public WebDriver driver;

	private SauceDemoLogin sd;
	private ProductPage pp;
	private CheckoutPage cp;



	public PomManager(WebDriver driver2) {
		this.driver=driver2;
	}


	public SauceDemoLogin SauceTesting() {
		if (sd == null) {
			sd = new SauceDemoLogin(driver);
		}
		return sd;
	}
	
	public ProductPage product() {
		if (pp == null) {
			pp = new ProductPage(driver);
		}
		return pp;
	}
	
	public CheckoutPage Checkout() {
		
		if (cp == null) {
			cp = new CheckoutPage(driver);
		}
		return cp;
	}
	
}
