ENGINEERING NOTES:

1. Why did you choose this framework structure?

	The framework is organized into clear layers:
* 	Feature files: Contain business-readable scenarios written in Gherkin.
* 	Step definitions: Map Gherkin steps to executable Java code. We can merger baseclass Methods and pom into it
* 	Support utilities(/Support): Provide reusable components like driver factory, hooks, screenshot capture, wait utilities, and DB connection helpers.
* 	Runner class: Central entry point for executing scenarios.


2. 	How does your wait strategy prevent flakiness?

	The framework uses explicit waits(e.g, 'WebDriverWait' with conditions like 'elementToBeClickable') instead of arbitrary 'Thread.sleep()'.  
- 	Explicit waits ensure synchronization between the test and the application under test.  
- 	This prevents flakiness caused by timing issues, slow page loads, or dynamic elements.  
- 	The wait utilities are centralized in '/support', so they can be reused consistently across scenarios.


3. 	How does your locator strategy improve stability?

- 	Preferred locators use 'data-test' attributes, which are stable and designed for automation.  
- 	Fallback locators use relative XPath with product names, avoiding brittle index-based selection.  
- 	This approach ensures that tests remain resilient even if the UI layout changes, reducing maintenance overhead.


4.	How would you scale this to 50+ scenarios?

- 	Reusable step definitions: Common actions like login, add to cart, and checkout are written once and reused across scenarios.  
- 	Page Object Model (POM): Encapsulates locators and actions, making it easy to add new scenarios without duplicating code.  
- 	Tagging: Scenarios can be grouped with tags ('@smoke', '@regression') to run subsets of tests efficiently.  
- 	Parallel execution: The framework can be configured with TestNG or JUnit to run scenarios in parallel, reducing execution time.


5. How would you execute this in CI/CD?

- 	Integrate with a CI/CD tool (e.g, Jenkins, GitHub Actions, or Azure DevOps).  
- 	Configure the pipeline to:
 1. Pull the latest code from the repository.
 2. Install dependencies (Maven build).
 3. Run the Cucumber tests (`mvn test`).
 4. Archive the generated reports (`ExtentReport.html`, screenshots).
-	 Reports can be published as build artifacts or displayed directly in the CI/CD dashboard.




	SUMMARY:

	This framework structure was chosen for clarity, maintainability, and scalability.  
- 	Wait strategies reduce flakiness.  
- 	Locator strategies improve stability.  
- 	The design supports scaling to 50+ scenarios and seamless CI/CD integration.  
- 	With more time, cloud execution and advanced reporting would further strengthen the framework.


---------------------------------------------------------------------------------------------------------------------------------------------------



	Locator Strategy for Adding "Sauce Labs Backpack" :

	- When automating the step to add the "Sauce Labs Backpack" to the cart,
 	it is important to use a locator strategy that is both "ROBUST" and "MAINTAINABLE". Below are the approaches used:

 1.) Preferred Locator Strategy (Robust):
 
 	Use a "data-test attribute" or a unique identifier provided by the application. 
	'This is stable and less likely to break if the UI changes'. 
 
 	Example (working code): java // Using data-test attribute 
 	WebElement backpackAddButton = driver.findElement(By.cssSelector("button[data-test='add-to-cart-sauce-labs-backpack']")); 
 	backpackAddButton.click();
 
 	Why this is preferred:
* 	Data-test attributes are designed for automation.
* 	They are stable and not affected by layout or styling changes.
* 	Easy to read and understand.

2.) Fallback Locator Strategy (Acceptable but Less Ideal):

	If the data-test attribute is not available, use a visible text locator (button text).
	'This is acceptable but may break if the button label changes'.

	Example, 
	WebElement backpackAddButton = driver.findElement(By.xpath("//button[text()='Add to cart']")); 
	backpackAddButton.click();

	Why this is less ideal:
* 	Relies on exact text match.
* 	If the text changes (e.g., "Add" → "Add Item"), the locator will fail.
* 	Still better than index-based or long brittle XPath chains.


-----------------------------------------------------------------------------------------------------------------------------------------------

SETUP INSTRUCTIONS:

	This repository contains a scalable automation framework built with "Selenium WebDriver", "Cucumber (BDD)", and "Java". 

1.) SETUP INSTRUCTIONS 

-- 	Clone the repository: 
	For Git bash, "git clone https://github.com/username/Saucedemo-BDD-Framework.git"

-- 	Import the project into Eclipse:

	Go to File → Import → Existing Maven Project.
  	Select the project folder.

-- 	Ensure the following are installed:

	Java JDK 8+
  	Apache Maven
  	Eclipse IDE (with Maven support)

  
 2.) INSTALL DEPENDENCIES
 
 	mvn clean install
 	This will download all required dependencies defined in pom.xml:

 	Selenium WebDriver
	Cucumber (BDD)
	TestNG/JUnit
	WebDriverManager
	Apache Commons io, 
	

3.) HOW TO RUN TESTS

	From Eclipse,
	Right click on the "Test Runner class" → Run As → JUnit Test.
	

	Reports:	
	Cucumber Reports: Generated in /target/cucumber-reports/
	Screenshots: Saved in /target/screenshots for failed scenarios
	
	
4.) HOW TO CHANGE BROWSER / HEADLESS MODE

	Open Hooks.java (inside /support):
	
	
5.) ASSUMPTIONS MADE

	Test data is static and defined in JSON files under /src/test/java/testdata/.
	Application under test is stable and accessible at the given URL.
	Locators are primarily based on data-test attributes for stability.
	Framework is designed to run on Chrome by default, but supports Edge and Firefox.
	Screenshots are captured only when scenarios fail.


-------------------------------------------------------------------------------------------------------------------------------------------------
	
	NOTES: 

	The framework uses Page Object Model (POM) for maintainability.
	Scenarios are tagged (@smoke, @regression) for selective execution.
	Wait strategy uses explicit waits to avoid flakiness.