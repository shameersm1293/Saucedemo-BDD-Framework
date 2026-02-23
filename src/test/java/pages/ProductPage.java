package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addBackpack;

	@FindBy(id = "shopping_cart_container")
	private WebElement cart;

	@FindBy(id = "checkout")
	private WebElement checkout;

	@FindBy(className = "shopping_cart_badge")
	private WebElement cartBadge;

	public ProductPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getAddBackpack() {
		return addBackpack;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getCartBadge() {
		return cartBadge;
	}

}
