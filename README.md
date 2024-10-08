# BanglaShoppers Automated Tests (Selenium) - Login UI & Functional Testing

This repository houses automated test scripts leveraging Selenium WebDriver to verify the functionality and user interface (UI) of the BanglaShoppers e-commerce website's login process.

## Getting Started


### Test Document

Test Document can be found in `./TestDocument/BanglashoppersAutomatedTestingDocument.xlsx`


### Technologies Used

This project utilizes the following technologies:

- **Selenium WebDriver**: Used for automating web application testing and interacting with browsers.
- **Java**: The primary programming language for writing the test scripts.
- **TestNG**: Framework used for structuring and managing test cases, and generating reports.
- **Maven**: Used as the build automation tool for managing dependencies and executing tests.
- **Git**: Version control system for tracking changes and collaboration.
- **ChromeDriver**: WebDriver implementation for automating Chrome browser interactions.


### Prerequisites

* **Programming Language:** Java (version 8 or later recommended)
* **Maven:** Maven is required for project build and dependency management. Download and install from https://maven.apache.org/.
* **Allure Framework:** Allure is used for generating visual test reports. Install it using your preferred package manager.



### Running the tests

Execute the test by running command: 
   ```bash
      mvn test
   ```
This command runs the custom configured testing.xml file via the <b>Maven Surefire Plugin.</b>

### HTML Report Generation
Generate HTML report by running command:
```bash
   allure generate ./allure-results
```

Html Test report can be found at `./allure-report`

### Open HTML Report
Open HTML report by running command:
```bash
   allure open ./allure-report
```

<b>Then, open the link given at the command line.</b>

### <b><u>Report Screenshots</u></b>

#### Overview
![Dashboard](https://img001.prntscr.com/file/img001/__b_9dLbSUODlVcAzV6yPw.png)

#### Functional Tests
![FunctionalTests](https://img001.prntscr.com/file/img001/vlCKfrbsRAGjTy7AvZU98w.png)

#### UI Tests
![AutomatedUITest](https://github.com/user-attachments/assets/cc725565-ce55-41a0-bb0e-12b5ff3115bb)
