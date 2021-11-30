# Design Document

## Specification

## Design Decisions

## Clean Architecture
1. 
## Packaging Strategies
Files are packaged by layer and then by feature. This packaging reminds group members to follow clean architecture and keeps the packages small and manageable.
## Design Patterns
 1. Facade Design pattern in `UseCases.OpertionFacade` package: [x]  
    * implemented in `finished operation facade` commit. 
    * Uses facade design pattern to calculate fees and salaries for patients and doctors so that 
    there is a single class for each stakeholders. (Single responsibility rule)
 2. Builder Design Pattern in ```Entity``` packages: [x]  
    * `PatientBuilder`, `StaffBuilder` and other builders for different types of staffs are used to 
    eliminate the long parameter list used to initialize the entities.
 3. Template Method Design Pattern [x]  
    In ```LoginSignUp``` where two subclasses `PatientSignUp` and `StaffSignUp` inherit a skeleton abstract class `SignUp`
    And enrich and differ it by overriding and adding new steps to the main method. this way duplicate codes are 
    contained in the superclass so we would not need to change the same code twice if we have to change something.
 4. Dependency Injection Pattern []  
    In UI class where injectors inject a controller, presenter and lower level classes.
 5. Command Design Pattern []
    Implemented in `Presenter` classes as they all import a `Printable` interface and implement an execute method.
    This way the methods would be made into stand-alone objects which would make injecting the methods bundled
    with other objects easier and would help if we are to add a feature where the user could see past presenters called.
 6. Strategy Design Pattern [x]:  
    Implemented in `Controllers.Admin.FindBestStaff` where 3 different concrete strategies of finding the
    best staff inherits an interface which is called in a context class with a `setStrategy()` function and 
    a `execute()` function that executes the said strategy. This way it would be easier to switch from one strategy to another at runtime.
## Progress Report

