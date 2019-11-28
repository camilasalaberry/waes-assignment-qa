# waes-assignment-qa

Description: This is a selenium java test project using framework cucumber to write UI tests. This project is part of the hiring process for WAES company.

### Dependencies
Suposing that you have windows OS in your machine:
1. To run this project is necessary to have vscode IDE installed with the following plugins:
    * Java Extension Pack
    * Cucumber Gherkin full support
    * Maven for java
    [See how to install vscode](https://code.visualstudio.com/docs/setup/windows)

 2. Apache Maven installed on your machine. [See how to install Apache Maven](https://maven.apache.org/install.html)
 3. Java jdk 1.8.0_231 installed on your machine and JAVA_HOME configured. [How to configure JAVA_HOME](https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html)

### Running tests
##### By vscode terminal:
      
        "mvn test"  will execute all tests in firefox browser by default;
        "mvn verify" will execute all tests and generate a cucumber report with detailed information about them;
        "mvn verify -Dbrowser=headless"  or  "mvn test -Dbrowser=headless"  will execute all tests in firefox headless mode;
######  

### Report
        The cucumber report will be located in the target folder project /cucumber-report-html/cucumber-html-reports/overview-features.html
       **Obs.: If a test fail an embed screenshot will be taken and attached to cucumber report**

### Code
I used clean code as my base, trying to create methods that are self explaining into test scenarios. I used Hooks to reuse @before and @after methods to cucumber's scenarios, and also a class to configure in which mode webdriver will run when maven command is called.Independent test concept was applied.

About the packages of this project:


| Package       | Info          |
| ------------- |:-------------:|
| page objects  | Pages of heros profiles app converted into classes with their fields mapped as selenium objects |
| runner        | There is a runner class that runs cucumber features      |
| steps | There are classes of steps of feature scenarios      |
|resources |There are two folders: features * features with their test scenarios and drivers that contains firefox webdriver. driver - The folder driver was created to make the execution of this project easier to whom will receive this app|


### Future Improvements
* Use parallel testing to reduce test execution time using zallenium testing tool
* Distributed testing using Selenium Grid to cross-browser testing
* Visual testing using galen or applitools

 
