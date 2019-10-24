# ADI-test
Project was implemented based on **Serenity BDD** tutorial
Tools used: 
* **Serenity BDD** as Selenium webdriver supplier and reporting tool
* **Cucumber** framework as Gherkin language interpreter
* **JUnit** as a test runner
* **Gradle** as a build tool

---
**Project structure**:
* Test layer
    * Feature files
* Step definition layer
    * Step libraries
    * Step definitions
* Runner layer
    * Suite runners
* Page Object layer
    * Page Object definitions
    * Composite elements
    
___
**Test execution**

`gradle clean test`

Also tests can be run via runners located in `src/test/java`

---
**Build dependencies**

Project requires Lombok plugin