# TW Assessment Automated Test Suit

## BDD tests automated in Java 
This project is an end2end suite test for MarsAir WebApp developed in POM (Page object model) 

##  Languagues & Tools

 - Java
 - Cucumber (BDD + Gherkin)
 - Selenium (WebDriver)
 - Chrome Headless (Browser)
 - Gradle (Build Tool)

## Requirements Installation

**Chrome browser(78.0.3904.97):** Upgrade or download the last version of [Google Chrome Browser](https://www.google.com/chrome/)

**ChromeDriver(78.0.3904.70):** Download the version [78.0.3904.70 ](https://chromedriver.storage.googleapis.com/index.html?path=78.0.3904.70/) since other latest version are giving erroes in run time.

on **Mac** OS move the executable to: `/usr/local/bin`
on **Windows** OS  add a the executable to the `PATH` on Windows  


## How to Use
**Build**
Run `gradle build`in the root folder

**Running test**
The suite have differents ways to be executed , 
    
 1. Scenarios can be run by tag feature:
 Run the feature required in root folder 
./gradle cucumber -Dcucumber.options="--tags @smoketest"
./gradle cucumber -Dcucumber.options="--tags @linktohomepage"
./gradle cucumber -Dcucumber.options="--tags @basicsearch"
./gradle cucumber -Dcucumber.options="--tags @promotionalcode"
./gradle cucumber -Dcucumber.options="--tags @invalidreturndates"
./gradle cucumber -Dcucumber.options="--tags @linktohomepage"

 2. Run all scenarios
 Run in the root folder 
 ./gradle cucumber

The code will open a headless chrome browser and will be executed in there.
 
## Results

Results can be observed in the console output meanwhile scenarios are being executed, after the execution of all features/scenarios a HTML report will be created in the path `/target/cucumber-html-reports`  


# Suite Structure
### Files

 - **Features,** contains and orders the test cases, is the first layer of execution through cucumber commands.
 - **Step,** Each Feature communicates with a step, this file contains the test cases in Java, it will be executed in the same order inside the feature.
 - **Page Object**, this class will contain all the properties/actions usable of a page, that Steps uses, this class is responsible handling driver (Selenium -> Chrome).
 
 
## Debug tests

With Intellij, add a new Run/Debug configuration

 - **Main:** io.cucumber.core.cli.Main
 - **Glue:** test.step_definitions
 - **Feature:** /tw-assessment/src/main/java/test/features/ (can specify a sigle feature /PromotionalCode.feature) 
 - **Program arguments:** --plugin org.jetbrains.plugins.cucumber.java.run.CucumberJvm3SMFormatter --plugin pretty


