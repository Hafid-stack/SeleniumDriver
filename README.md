# SeleniumDriver
# Selenium Test Automation Framework


This project is a test automation framework built using Selenium WebDriver and TestNG.

It covers end-to-end testing scenarios such as login and add-to-cart functionality on a demo e-commerce website.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- ChromeDriver

- ## Project Structure
- BaseTest: Handles driver setup, teardown, and utilities
- Tests: Contains test cases (Login, Add to Cart, etc.)
- Utilities: Reusable methods for interactions (click, type, waits)

- ## Features
- Explicit waits for stability
- Reusable utility methods (click, type, wait)
- ChromeOptions configuration to disable popups
- Clean test structure using BaseTest

- ## Example Test Flow
1. Open browser
2. Navigate to base URL
3. Enter username and password
4. Click login
5. Verify successful login

6. ## Future Improvements
- Implement Page Object Model (POM)
- Add screenshot capture on test failure
- Integrate with CI/CD (GitHub Actions)
- Add reporting (Allure or ExtentReports)
