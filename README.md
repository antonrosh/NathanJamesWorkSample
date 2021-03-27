# Nathan James Work Sample
# Introduction: 
This Test Automation Framework is created using Java + Selenium Web Driver + TestNG. Which can be used across different web-based applications. In this approach, the endeavor is to build a lot of applications with independent reusable keyword components so that they can directly be used for another web application without spending any extra effort. With this framework in place, whenever we need to automate a web-based application, we would not need to start from scratch, but use the application-independent keyword components to the extent possible and create application-specific components for the specific needs.

# Example:
Video example is uploaded on Youtube. Video has visibility parameter as unlisted and can be found by the [link](https://www.youtube.com/watch?v=XaUJovUyjj4) only. 

# Prerequisites:
* Java JDK 1.8 or higher (update Java version in POM.xml file, current implementataion is JDK 11 LTS)
* Apache Maven 3 or higher

# Environment:
There are 4 different browsers configuration set up [Google Chrome, Mozilla Firefox, Microsoft Edge, Opera]

# Execution:
* Clone the repository.
* Open command prompt and go to web-test directory.
* Navigate to \NathanJamesWorkSample\src\test\java\testSuites to find Test Suites for each browser.

# Logging:
* log4j configured to capture the test execution logs
* Configuration file is located in the \NathanJamesWorkSample\src\test\resources
* Execution log is captured in the \NathanJamesWorkSample\logs

# Screenshot:
* Most of the time we think to Capture Screenshot in WebDriver when some kind of error or exception surfaces while practicing testing, to resolve the same the framework has a method.
* Screenshots are store it in the \NathanJamesWorkSample\screenShots
