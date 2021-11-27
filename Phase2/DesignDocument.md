# Design Document

## Specification

## Design Decisions

## Clean Architecture
1. 
## Packaging Strategies
Files are packaged by layer and then by feature. This packaging reminds group members to follow clean architecture and keeps the packages small and manageable.
## Design Patterns
 1. Facade Design pattern in `UseCases.OpertionFacade` package: 
    * implemented in `finished operation facade` commit. 
    * Uses facade design pattern to calculate fees and salaries for patients and doctors so that 
    there is a single class for each stakeholders. (Single responsibility rule)
 2. Builder Design Pattern in ```Entity``` packages:
    * `PatientBuilder`, `StaffBuilder` and other builders for different types of staffs are used to 
    eliminate the long parameter list used to initialize the entities.
 3. Template Method Design Pattern []
    In ```LoginSignUp``` where two subclasses `PatientSignUp` and `StaffSignUp` inherit a skeleton abstract class `SignUp`
    And enrich and differ it by overriding and adding new steps to the main method.
 4. Dependency Injection Pattern []
    In UI class where injectors inject a controller, presenter and lower level classes.
 5. Facade Design Pattern []
    Financial Overview, Management, accountant and others
 6. 
## Progress Report

