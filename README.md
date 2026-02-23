<<<<<<< HEAD
ENGINEERING NOTES:

1. Why did you choose this framework structure?

The framework is organized into clear layers:
* Feature files: Contain business-readable scenarios written in Gherkin.
* Step definitions: Map Gherkin steps to executable Java code. We can merger baseclass Methods and pom into it
* Support utilities(/Support): Provide reusable components like driver factory, hooks, screenshot capture, wait utilities, and DB connection helpers.
* Runner class: Central entry point for executing scenarios.


2. How does your wait strategy prevent flakiness?

The framework uses explicit waits(e.g, 'WebDriverWait' with conditions like 'elementToBeClickable') instead of arbitrary 'Thread.sleep()'.  
- Explicit waits ensure synchronization between the test and the application under test.  
- This prevents flakiness caused by timing issues, slow page loads, or dynamic elements.  
- The wait utilities are centralized in '/support', so they can be reused consistently across scenarios.


3. How does your locator strategy improve stability?

- Preferred locators use 'data-test' attributes, which are stable and designed for automation.  
- Fallback locators use relative XPath with product names, avoiding brittle index-based selection.  
- This approach ensures that tests remain resilient even if the UI layout changes, reducing maintenance overhead.


4. How would you scale this to 50+ scenarios?

- Reusable step definitions: Common actions like login, add to cart, and checkout are written once and reused across scenarios.  
- Page Object Model (POM): Encapsulates locators and actions, making it easy to add new scenarios without duplicating code.  
- Tagging: Scenarios can be grouped with tags ('@smoke', '@regression') to run subsets of tests efficiently.  
- Parallel execution: The framework can be configured with TestNG or JUnit to run scenarios in parallel, reducing execution time.


5. How would you execute this in CI/CD?

- Integrate with a CI/CD tool (e.g, Jenkins, GitHub Actions, or Azure DevOps).  
- Configure the pipeline to:
  1. Pull the latest code from the repository.
  2. Install dependencies (Maven build).
  3. Run the Cucumber tests (`mvn test`).
  4. Archive the generated reports (`ExtentReport.html`, screenshots).
- Reports can be published as build artifacts or displayed directly in the CI/CD dashboard.




SUMMARY:

This framework structure was chosen for clarity, maintainability, and scalability.  
- Wait strategies reduce flakiness.  
- Locator strategies improve stability.  
- The design supports scaling to 50+ scenarios and seamless CI/CD integration.  
- With more time, cloud execution and advanced reporting would further strengthen the framework.
=======
# Saucedemo-BDD-Framework
>>>>>>> ba305b43eb455ec0ac2b91d6733db3d309486931
