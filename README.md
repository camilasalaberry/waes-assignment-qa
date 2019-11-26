# waes-assignment-qa

Description: This is a selenium java project using framework cucumber to write UI tests.

### Prerequisites
Suposing that you have windows os in your machine:
1. To run this project is necessary to have vscode ide installed with plugins:
    * Java Extension Pack
    * Cucumber Gherkin full support
    * Maven for java
    [See how to install vscode](https://code.visualstudio.com/docs/setup/windows)

 2. Apache Maven installed on your machine [See how to install Apache Maven](https://maven.apache.org/install.html)
 3. Java jdk 1.8.0_231 installed on your machine and configured JAVA_HOME [How to configure JAVA_HOME](https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html)

### Run tests
##### By vscode terminal:
      
        "mvn test"  will execute all tests in firefox browser by default;
        "mvn verify" will execute all tests and generate a cucumber report with detailed information about them;
        "mvn verify -Dbrowser=headless"  or  "mvn test -Dbrowser=headless"  will execute all tests in firefox headless mode;
######  

### Report
        The cucumber report will be located project's target folder /cucumber-report-html/cucumber-html-reports/overview-features.html
       **Obs.: If a test fail a embed screenshot will be taken and attached to cucumber report**

