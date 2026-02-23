package steps;

import org.json.simple.JSONObject;

import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PomManager;
import support.Hooks;
import support.TestDataReader;
import support.WaitUtils;

public class stepdefinition {

	PomManager po;

	@Given("I am on the SauceDemo login page")
	public void i_am_on_the_sauce_demo_login_page() {
		Hooks.driver.get(ConfigReader.get("BASE_URL"));
		po = new PomManager(Hooks.driver);

	}


	@When("I login with valid username")
	public void i_login_with_valid_username() {
		JSONObject users = TestDataReader.getData("users.json");
		JSONObject validUser = (JSONObject) users.get("validUser");
		po.SauceTesting().getUser().sendKeys((String) validUser.get("username"));
	}

	@When("I login with valid password")
	public void i_login_with_valid_password() throws InterruptedException {
		JSONObject users = TestDataReader.getData("users.json");
		JSONObject validUser = (JSONObject) users.get("validUser");
		po.SauceTesting().getPass().sendKeys((String) validUser.get("password"));
	}
	


	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		po.SauceTesting().getLogin().click();


	}

	@When("I add {string} to the cart")
	public void i_add_to_the_cart(String string) throws InterruptedException {
		WaitUtils.waitForElement(Hooks.driver, po.product().getAddBackpack(), 10);
		po.product().getAddBackpack().click();

		WaitUtils.waitForElement(Hooks.driver, po.product().getCartBadge(), 10);
		assert po.product().getCartBadge().getText().equals("1");

	}

	@When("I checkout with valid customer details")
	public void i_checkout_with_valid_customer_details() throws InterruptedException {

		JSONObject checkout = TestDataReader.getData("checkout.json");

		JSONObject customer = (JSONObject) checkout.get("customer");

		po.product().getCart().click();
		WaitUtils.waitForElement(Hooks.driver, po.product().getCheckout(), 10);
		po.product().getCheckout().click();
		WaitUtils.waitForElement(Hooks.driver, po.Checkout().getFirstName(), 10);
		po.Checkout().getFirstName().sendKeys((String) customer.get("firstName"));
		po.Checkout().getLastName().sendKeys((String) customer.get("lastName"));
		po.Checkout().getPostalCode().sendKeys((String) customer.get("postalCode"));
		po.Checkout().getContinueBtn().click();
		po.Checkout().getFinishBtn().click();

	}

	@Then("I should see the order confirmation page")
	public void i_should_see_the_order_confirmation_page() {
		WaitUtils.waitForElement(Hooks.driver, po.Checkout().getConfirmationMsg(), 5);
		assert po.Checkout().getConfirmationMsg().isDisplayed();
	}

	@When("I login with invalid username")
	public void i_login_with_invalid_username() {
		JSONObject users = TestDataReader.getData("users.json");
		JSONObject invalidUser = (JSONObject) users.get("invalidUser");
		po.SauceTesting().getUser().sendKeys((String) invalidUser.get("username"));
	}

	@When("I login with invalid password")
	public void i_login_with_invalid_password() {
		JSONObject users = TestDataReader.getData("users.json");
		JSONObject invalidUser = (JSONObject) users.get("invalidUser");
		po.SauceTesting().getPass().sendKeys((String) invalidUser.get("password"));
	}
	
	@Then("I should see an authentication error message")
	public void i_should_see_an_authentication_error_message() throws InterruptedException {
		WaitUtils.waitForElement(Hooks.driver, po.Checkout().getErrorMsg(), 5);
		assert po.Checkout().getErrorMsg().isDisplayed();

		WaitUtils.waitForElement(Hooks.driver, po.SauceTesting().getLogin(), 5);
		assert po.SauceTesting().getLogin().isDisplayed();

	}
}
