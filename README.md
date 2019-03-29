# Project: NSW Service Centre Locator

This project is regarding a simple test of finding an NSW service centre by Suburb or Postcode.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Things should be pre-installed in order run this project

```
JDK 8
Maven (3 or later)
Git (1.8 or later)
```
### Get the source code for the first time

To get the source code, run git `clone git@github.com:alihozefa/bookingtest.git` in the folder where you want to clone the root folder.

### Build

* To build a UI project, run `mvn clean install` in the root folder.
* To build an individual submodule, run `mvn clean install` in the root folder of the submodule you want to build.

### Run

To run Test after it has been built, execute `mvn clean test` in the root folder of the submodule.

### IDE support

As Selenium is using a standard Maven 3 setup, building and running it from an IDE is usually very straight forward, as long as the IDE has good Maven support.

#### [IntelliJ IDEA](https://www.jetbrains.com/idea/)

### Data provider

To change the location address Open Config.properties file and:
* Change the value against variable: `serviceLocation`
* Change the value against variable: `expectedServiceCentre`

### Change properties
Open Config.properties file and:
* Change the browser type using variable: `browserType`
* Change the test URL using variable: `testURL`
* Change the wait timeout using variables: `implicitWait` and `explicitWait`
