# gatling-spring-petclinic
Gatling project to load test the spring petclinic application. This project is used for learning how to write gatling test scenarios and, therefore, keeps the scenario complexity to a minimum.

## Prerequisites
1. spring-petclinic project, which can be found [here](https://github.com/spring-projects/spring-petclinic)
2. Gatling, available [here](http://gatling.io/) 
3. (optional) your favorite IDE with Scala for editing the source code.

## Setup
1. Download and extract the latest version of Gatling. The directory where you extract the tool is referred as GATLING_HOME from now on.
2. Navigate to the GATLING_HOME/user-files/simulations directory
3. Checkout the test scenarios with the following command:
```
git clone https://github.com/ermanno-pirotta/gatling-spring-petclinic.git
```

## Run the tests
1. Navigate to the GATLING_HOME/bin directory
2. Execute `gatling.sh` or `gatling.bat` depending on your operative system.
3. Select *org.piro84.performance.petclinic.AddVisitSimulation* by typing the relative number