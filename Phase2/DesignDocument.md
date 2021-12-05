# Design Document

## SOLID
1. Single Responsibility Principle:  
   In general we have strived to make sure classes are only responsible for one stakeholder. This is best demonstrated with the Facade classes for operations in the usecases. In order to have the class not simultaneously responsible for multiple stakeholders we have made it so that it calls methods from different "component" classes that are only responsible for one actor and thus have only one source of change. `OperationFeeCalculator` for patients and `OperationBonusCalculator` for doctors. 
2. Open-closed principle.  
   We have followed this principle by making sure that new features can be added without modifying large part of the source code. For example strategy pattern is used to make sure that adding a new way to find a best employee is easy and can be done without modifying other part of the code. 
3. Liskov Substitution Principle
   This principle is pretty much enforced by Java, but we have made sure the all methods in a superclass are present in subclasses, thus the subtypes could always be substitutable for the super types.
4. Interface Segregation Principle
   We have made sure that no classes inherit methods that it does not need by checking through the inheritance. We al split interfaces up and have differentiate classes with somewhat similar architecture but still inherently different, like `Patient` and `Staff` where they share some properties but have different methods and functions. We choose our inheritance cautiously and did not abuse OOP.
5. Dependency Inversion Principle
   In major boundaries like from usecases to controller we have interfaces of the lower level that both the higher level classes and the lower level implementation depend upon. Since we identified the usecases-databse part as most likely subjects of change we have decided to eliminate direct dependency from upper level classes by making both the higher level and the lower level object depend on the abstraction instead so the upper level object does not need to be modified when the lower level object is changed. We do not have interfaces for every layer because according to the prof, there would be too many interfaces.


## Clean Architecture
1. UML diagram  
2. Scenario Walkthrough:  
   Say the management staff wants to look for the best staff in the hospital. They would first interact with the UI which upon receiving an input will call a presenter that 


## Design Patterns
 1. Facade Design pattern in `UseCases.OpertionFacade` package: [x]  
    * implemented in `finished operation facade` commit. 
    * Uses facade design pattern to calculate fees and salaries for patients and doctors so that 
    there is a single class for each stakeholders. (Single responsibility rule). The facade class creates new classes like a logger, a fee calculator and a bonus calculator to use. 
 2. Builder Design Pattern in ```Entity``` packages: [x]  
    * `PatientBuilder`, `StaffBuilder` and other builders for different types of staffs are used to 
    eliminate the long parameter list used to initialize the entities. The two classes are inited with information by constructing a new builder object and calling the setters in the builders and then the `getResult()` method which returns the object.
 4. State Pattern [x]  
    In `UI.MenuForStaff` we have a state design pattern where the `MenuForStaff` class acts as the context class with other sub menus for each type of staffs as the states.
    This way it would be easier to add new staff types thus following the open-closed principle and would be easier to switch from state to state at run time.
    It uses `MenuForStaff` as context instead which there is a `Menu` state whose execution method could set the state for context and call its execution method, which in turn will call the states' execution method.
 5. Command Design Pattern [x]  
    Implemented in `Presenter` classes as they all import a `Printable` interface and implement an execute method.
    This way the methods would be made into stand-alone objects which would make injecting the methods bundled
    with other objects easier and would help if we are to add a feature where the user could see past presenters called.
 6. Strategy Design Pattern [x]:  
    Implemented in `Controllers.Admin.FindBestStaff` where 3 different concrete strategies of finding the
    best staff inherits an interface which is called in a context class with a `setStrategy()` function and 
    a `execute()` function that executes the said strategy. This way it would be easier to switch from one strategy to another at runtime.
 7. Singleton Design pattern[x]:
    Singleton Design pattern is used to provide access to a single instance of `PatientManager` and `StaffManager`
    for the program. This way we can avoid more of the lengthy initialization of these two classes and makes it easier to manage the data in them.
    The classes are called by calling a public static `getInstance()` method which calls a private constructor. This way we could make sure all calls to get a new object of the class refers to the same object in heap.
## Use of GitHub Features
   We have used the [Github project feature](https://github.com/CSC207-UofT/course-project-tut5101-hospital/projects/1) to 
   track the works shared and we uses issues to highlight the features we want to work on. We also linked the issues to corresponding pull request where the feature is implemented. We have set up a CodeQL workflow action to analysis our code. We also created an empty wiki page on GitHub.
## Code Style and Documentation
## Testing
## Refactoring
## Code Organization
   ~ Packging Strategy: Files are packaged by layer and then by feature. This packaging reminds group members to follow clean architecture and keeps the packages small and manageable.
## Functionality

The scope of this project is pretty adequate for a group of 4 people. Since the member count dropped to 4 we had to make adjustments and forego some of the progress we made when we have more members, which also took some time and resources. Overall it the members of this group all put effort into the project and the workload is fair.  
The program can persist(store, read, update) entities including patients, staffs and operations and such. 
## Progress Report
1. Tom: Doing features about admin and accountant staff, admin can check doctor's schedule and find the best staff. Account can find the total hospital profit. Link to pull request: https://github.com/CSC207-UofT/course-project-tut5101-hospital/pull/33. This is important because this is major part of the staff features in our hospital. Also it shows some example to the rest of group member how to implement Clean Architecture because I created new UI, UseCase, Controllers and Presenters to implement those features.
2. Fion:
3. Jeremy:
4. Chiatzen:
