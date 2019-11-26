# waes-assignment-qa

Description: This is a selenium java project using framework cucumber to write UI tests.

### Pre requisites
Suposing that you have windows os in your machine:
1. To run this project is necessary to have vscode ide installed with plugins:
    * Java Extension Pack
    * Cucumber Gherkin full support
    * Maven for java

 2. apache maven installed on your machine
 3. java jdk installed on your machine

### Run tests
##### By vscode terminal:
      
        "mvn test"  will execute all tests in firefox browser by default;
        "mvn verify" will execute all tests and generate a cucumber report with detailed information about them;
        "mvn verify -Dbrowser=headless"  or  "mvn test -Dbrowser=headless"  will execute all tests in firefox headless mode;
######  

### Report
        The cucumber report will be located project's target folder /cucumber-report-html/cucumber-html-reports/overview-features.html
       **Obs.: If a test fail a embed screenshot will be taken and attached to cucumber report**

