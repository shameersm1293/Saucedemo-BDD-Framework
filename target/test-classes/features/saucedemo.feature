Feature: SauceDemo Purchase Flow

@valid
Scenario: Successful purchase of a single product
Given I am on the SauceDemo login page
When I login with valid username
And I login with valid password
And I click on the login button
And I add "Sauce Labs Backpack" to the cart
And I checkout with valid customer details
Then I should see the order confirmation page



@invalid
Scenario: Invalid login shows error
Given I am on the SauceDemo login page
When I login with invalid username
And I login with invalid password
And I click on the login button
Then I should see an authentication error message