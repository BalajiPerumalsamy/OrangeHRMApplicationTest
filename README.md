# OrangeHRM Test Automation Framework

An end-to-end UI test automation framework for the [OrangeHRM demo application](https://opensource-demo.orangehrmlive.com/), built with **Java**, **Selenium WebDriver**, **TestNG** and **Maven**, following the **Page Object Model (POM)** design pattern.

---

## Table of Contents

- [Tech Stack](#tech-stack)
- [Features](#features)
- [Modules Covered](#modules-covered)
- [Test Coverage](#test-coverage)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup & Execution](#setup--execution)
- [Reports](#reports)
- [Author](#author)

---

## Tech Stack

| Area | Tool / Library | Version |
|---|---|---|
| Language | Java | 11 |
| Build Tool | Maven | 3.x |
| Automation | Selenium WebDriver | 4.22.0 |
| Test Framework | TestNG (with assertions) | 7.9.0 |
| Data-Driven Testing | Apache POI (Excel) | 5.4.1 |
| Reporting | Extent Reports | 5.1.1 |
| Logging | SLF4J Simple | 2.0.9 |

---

## Features

- Page Object Model (separate page classes and test classes)
- `BaseClass` for common browser setup and teardown
- Screenshots captured during execution
- Positive and negative test scenarios
- Assertions to validate expected vs actual results (page titles, success and error messages, element visibility)
- Data-driven testing using Excel (Apache POI)
- TestNG Listeners for test execution events
- Extent HTML reports for detailed results
- Reusable and maintainable code structure

---

## Modules Covered

| Page Class | Description |
|---|---|
| `Login_Page` | Login to the application |
| `Logout_Page` | Logout from the application |
| `ForgotPassword_Page` | Forgot password flow |
| `Dashboard_Page` | Dashboard verification |
| `PIM_Page` | PIM module navigation |
| `AddEmployee_Page` | Add a new employee |
| `EmployeeList_Page` | Search and view employees |
| `DeleteEmployee_Page` | Delete an employee |
| `ChangePassword_Page` | Change password with validations |
| `Buzz_Page` | Post on Buzz newsfeed |
| `DeleteBuzzNewsFeedPage` | Delete a Buzz newsfeed post |
| `Reports_Page` | Reports module |

---

## Test Coverage

### Positive Tests

| Test Class | Scenario |
|---|---|
| `LoginPageTest` | Login with valid credentials |
| `LogoutPageTest` | Logout successfully |
| `ForgotPasswordPageTest` | Forgot password flow |
| `DashboardPageTest` | Dashboard loads and elements are verified |
| `PIMPageTest` | PIM module navigation |
| `AddEmployeePageTest` | Add employee with valid details |
| `EmployeeListPageTest` | Search employee in the list |
| `DeleteEmployeePageTest` | Delete an employee |
| `BuzzPageTest` | Create a Buzz post |
| `DeleteBuzzNewsFeedPageTest` | Delete a Buzz post |
| `ChangePasswordPageTest` | Change password successfully |
| `ChangeWeakPasswordTest` | Change to a weak (valid) password |
| `ChangeBetterPasswordTest` | Change to a better password |
| `ChangeStrongPasswordTest` | Change to a strong password |
| `ChangeStrongestPasswordTest` | Change to the strongest password |

### Negative Tests

| Test Class | Scenario |
|---|---|
| `LoginPageTest` | Login with invalid credentials |
| `AddEmployeePageTest` | Add employee with invalid or missing data |
| `EmployeeListPageTest` | Search with invalid data |
| `ChangePasswordEmptyFieldTest` | Submit with empty fields |
| `ChangePasswordIncorrectCurrentPasswordTest` | Incorrect current password |
| `ChangePasswordLessCharacterPasswordTest` | New password shorter than minimum length |
| `ChangePasswordMinimumOneLowerCaseLetterTest` | New password without a lowercase letter |
| `ChangePasswordMinimumOneNumberPasswordTest` | New password without a number |
| `ChangePasswordMisMatchPasswordTest` | New and confirm passwords do not match |

---

## Project Structure

```
OrangeHRMApplicationTest
├── Screenshots                         # Screenshots captured during execution
├── src
│   ├── main
│   │   ├── java/com
│   │   │   ├── BassPage
│   │   │   │   └── BaseClass.java      # Browser setup and teardown
│   │   │   ├── orangeHRMPages          # Page Object classes
│   │   │   │   ├── AddEmployee_Page.java
│   │   │   │   ├── Buzz_Page.java
│   │   │   │   ├── ChangePassword_Page.java
│   │   │   │   ├── Dashboard_Page.java
│   │   │   │   ├── DeleteBuzzNewsFeedPage.java
│   │   │   │   ├── DeleteEmployee_Page.java
│   │   │   │   ├── EmployeeList_Page.java
│   │   │   │   ├── ForgotPassword_Page.java
│   │   │   │   ├── Login_Page.java
│   │   │   │   ├── Logout_Page.java
│   │   │   │   ├── PIM_Page.java
│   │   │   │   └── Reports_Page.java
│   │   │   └── utils
│   │   │       └── ExcelUtils.java     # Excel read/write helper
│   │   └── resources
│   │       └── Input_Data              # Excel test data
│   └── test/java/com
│       ├── Listeners
│       │   └── MyListener.java         # TestNG listener
│       ├── negativeTests               # Negative test classes
│       ├── positiveTests               # Positive test classes
│       └── reports
│           └── ReportManager.java      # Extent report setup
├── ExtentReport.html                   # Generated execution report
├── Testing.xml                         # TestNG suite file
├── pom.xml
├── .gitignore
└── README.md
```

---

## Prerequisites

- JDK 11 or higher
- Maven 3.x
- Google Chrome (latest). Selenium 4.22 manages the ChromeDriver automatically via Selenium Manager
- An IDE such as IntelliJ IDEA or Eclipse

---

## Setup & Execution

1. **Clone the repository**
   ```bash
   git clone https://github.com/BalajiPerumalsamy/OrangeHRMApplicationTest.git
   cd OrangeHRMApplicationTest
   ```

2. **Install dependencies**
   ```bash
   mvn clean install -DskipTests
   ```

3. **Run the tests**
   - From the IDE: right-click `Testing.xml` and choose **Run as TestNG Suite**.
   - From the command line:
     ```bash
     mvn test
     ```
     This runs the suite defined in `Testing.xml` through the Maven Surefire plugin. To run a different suite file:
     ```bash
     mvn test -DsuiteXmlFile=<suite-file>.xml
     ```

---

## Reports

- After execution, the Extent HTML report is generated as `ExtentReport.html` in the project root. Open it in any browser to view pass/fail status and details for each test.
- Screenshots are saved in the `Screenshots` folder.

---

## Author

- **Name:** Balaji Perumalsamy
- **Role:**  Junior QA Engineer 
- **GitHub:** [BalajiPerumalsamy](https://github.com/BalajiPerumalsamy)
