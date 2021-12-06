# Design Document

## SOLID

### Single Responsibility Principle:

In general we have strived to make sure classes are only responsible for one stakeholder. This is best demonstrated with
the Facade classes for operations in the usecases. In order to have the class not simultaneously responsible for
multiple stakeholders we have made it so that it calls methods from different "component" classes that are only
responsible for one actor and thus have only one source of change. `OperationFeeCalculator` for patients
and `OperationBonusCalculator` for doctors. In general we have strived to make sure classes are only responsible for one
stakeholder. This is best demonstrated with the Facade classes for operations in the usecases. In order to have the
class not simultaneously responsible for multiple stakeholders we have made it so that it calls methods from different "
component" classes that are only responsible for one actor and thus have only one source of
change. `OperationFeeCalculator` for patients and `OperationBonusCalculator` for doctors.

### Open-closed principle.

We have followed this principle by making sure that new features can be added without modifying large part of the source
code. For example strategy pattern is used to make sure that adding a new way to find a best employee is easy and can be
done without modifying other part of the code.

### Liskov Substitution Principle

This principle is pretty much enforced by Java, but we have made sure the all methods in a superclass are present in
subclasses, thus the subtypes could always be substitutable for the super types.

### Interface Segregation Principle

We have made sure that no classes inherit methods that it does not need by checking through the inheritance. We al split
interfaces up and have differentiate classes with somewhat similar architecture but still inherently different,
like `Patient` and `Staff` where they share some properties but have different methods and functions. We choose our
inheritance cautiously and did not abuse OOP.

### Dependency Inversion Principle

In major boundaries like from usecases to controller we have interfaces of the lower level that both the higher level
classes and the lower level implementation depend upon. Since we identified the usecases-databse part as most likely
subjects of change we have decided to eliminate direct dependency from upper level classes by making both the higher
level and the lower level object depend on the abstraction instead so the upper level object does not need to be
modified when the lower level object is changed. We do not have interfaces for every layer because according to the
prof, there would be too many interfaces.

## Clean Architecture

1. [UML diagram](uml.pdf)
2. Scenario Walkthrough:  
   Say the management staff(Admin) wants to look for the best staff in the hospital. They would first interact with
   the `Menu.Ui`
   which upon receiving an input will call a presenter `AdminMenuPresenter` which prints out the options. If the ui
   detects a choice that requires interacting with lower level classes such as `find best staff` it then calls a
   presenter and controller, in this case `FindBestStaff` and `FindBestStaffPresenter`. The controller then calls
   the `UseCases.GetBestStrategy` interface which has 3 concrete implementations that calls a method to find the best
   staff in `Usecases.ScheduleManager`. The schedule manager then interacts with the database to find the best staff.
   After controller passes the `ID` of the best staff to `UI` the `Menu` then calls the presenter to return a string
   description of the best staff, which `Menu` prints out to the user.

3. Some part of the code is avoiding Clean Architecture such that `DoctorMenu` and we don't have time to fix it before . 
   presentation. 
## Design Patterns

1. ***Facade Design pattern*** in `UseCases.OpertionFacade` package: [x]
   * implemented in `finished operation facade` commit.
   * Uses facade design pattern to calculate fees and salaries for patients and doctors so that there is a single class
     for each stakeholders. (Single responsibility rule). The facade class creates new classes like a logger, a fee
     calculator and a bonus calculator to use.
2. ***Builder Design Pattern*** in ```Entity``` packages: [x]
   * `PatientBuilder`, `StaffBuilder` and other builders for different types of staffs are used to eliminate the long
     parameter list used to initialize the entities. The two classes are inited with information by constructing a new
     builder object and calling the setters in the builders and then the `getResult()` method which returns the object.
4. ***State Design Pattern*** [x]  
   In `UI.MenuForStaff` we have a state design pattern where the `MenuForStaff` class acts as the context class with
   other sub menus for each type of staffs as the states. This way it would be easier to add new staff types thus
   following the open-closed principle and would be easier to switch from state to state at run time. It
   uses `MenuForStaff` as context instead which there is a `Menu` state whose execution method could set the state for
   context and call its execution method, which in turn will call the states' execution method.
5. ***Command Design Pattern*** [x]  
   Implemented in `Presenter` classes as they all import a `Printable` interface and implement an execute method. This
   way the methods would be made into stand-alone objects which would make injecting the methods bundled with other
   objects easier and would help if we are to add a feature where the user could see past presenters called.
6. ***Strategy Design Pattern*** [x]:  
   Implemented in `Controllers.Admin.FindBestStaff` where 3 different concrete strategies of finding the best staff
   inherits an interface which is called in a context class with a `setStrategy()` function and a `execute()` function
   that executes the said strategy. This way it would be easier to switch from one strategy to another at runtime.
7. ***Singleton Design pattern***[x]:  
   Singleton Design pattern is used to provide access to a single instance of `PatientManager` and `StaffManager`
   for the program. This way we can avoid more of the lengthy initialization of these two classes and makes it easier to
   manage the data in them. The classes are called by calling a public static `getInstance()` method which calls a
   private constructor. This way we could make sure all calls to get a new object of the class refers to the same object
   in heap.

## Use of GitHub Features

We have used the [***Github project
feature***](https://github.com/CSC207-UofT/course-project-tut5101-hospital/projects/1) to track the works shared.  
We use ***issues*** to highlight the features we want to work on.   
We also linked the issues to corresponding ***pull request*** where the feature is implemented.  
We have set up a ***CodeQL workflow action*** to analysis our code. We also created an empty wiki page on GitHub.

## Code Style and Documentation

***Javadocs*** are used to marks parameters and exceptions thrown.  
***Warnings*** in IDE are largely fixed.  
We used ***camel case*** naming convention and our classes and methods are well documented by their ***names*** and ***
comments***.

## Testing
Most basic part of our system are tested such as Entity and UseCases layer. But due to our design, some part of code such as UI and 
presenters are very hard to test. So we just decide to leave it without test. And for controller, it just called usecases, so if usecases works, 
controllers will works too.
## Refactoring

In phase 2 we tried to eliminate code smells and apply design patterns to our work.

The pull request [setting up builder patterns](https://github.com/CSC207-UofT/course-project-tut5101-hospital/pull/10)
sees us implementing builder patterns for creating entity objects to get rid of the long parameter list in higher level
functions that used to call the constructors with 5 parameters.

The pull request [add interfaces for DIP](https://github.com/CSC207-UofT/course-project-tut5101-hospital/pull/20) has us
refactoring the code to follow the dependency inversion principle by adding abstraction interfaces that both the
usecases `PatientManager` and `StaffManager` and upper level classes depend upon.

### Flaws/code smells that we don't have the time to fix:

Some long parameter lists when calling constructors for entities in higher level classes.  
Some code that is partly shared between methods are repeated.

## Code Organization

### Packging Strategy:

Files are packaged by layer and then by feature. This packaging reminds group members to follow clean architecture and
keeps the packages small and manageable.

## Functionality

The scope of this project is pretty adequate for a group of 4 people. Since the member count dropped to 4 we had to make
adjustments and forego some of the progress we made when we have more members, which also took some time and resources.
Overall it the members of this group all put effort into the project and the workload is fair.  
The program can persist(store, read, update) entities including patients, staffs and operations and such.

## Progress Report

### Chiatzen:

#### Phase 0:

Usecases and schedule class, responsible for controllers of making appointments and view appointments,
made `PatientManager`
`StaffManager`(usecases), custom exceptions, serialization for the program and a basic cli.

#### Phase 1:

tried to implement a webUI with `h2`, `SpringBoot` and `React.js`, abandoned since we would not finish the program in
time with now just 4 people. Added more features like `logInSignUp`.

#### Phase 2:

Responsible for implementing design
patterns [(example)](https://github.com/CSC207-UofT/course-project-tut5101-hospital/pull/10)
, [commit example](https://github.com/CSC207-UofT/course-project-tut5101-hospital/commit/f7da84f7da3fe3957dc37e0f1ccfb175c4f0b844)
.   
Added `Operation` and features.  
General debugging and fixing stuff.  
Writing the design document.  
Implemented feature: sign up and log in as different type
staffs. [Commit](https://github.com/CSC207-UofT/course-project-tut5101-hospital/commit/b59bbe3a270f59c2d90deb735769fbdb76727f3a)

### Tom: Doing features about admin and accountant staff. 
Admin can check doctor's schedule and find the best staff. Accountant can find the total hospital profit. Link to pull
request: https://github.com/CSC207-UofT/course-project-tut5101-hospital/pull/33. This is important because this is major
part of the staff features in our hospital. Also it shows some example to the rest of group member how to implement
Clean Architecture because I created new UI, UseCase, Controllers and Presenters to implement those features.

### Fion: In charge of Patient Medical Record, Patient Record and Patient Record list entity classes and PatientRecordListManager use case
(Made the classes, made the tests and implemented them into menu). Create a patient record and patient medical record while storing
them by date created into patient record list. Created tests for UseCases. Filled out the Accessibility Report. I did
not really use pull requests as I had a lot of trouble with it during phase 1. Instead, we divided up tasks in Github
tracker and opened and assigned issues. Link to pull request from phase 1: 
https://github.com/CSC207-UofT/course-project-tut5101-hospital/pull/1

### Jeremy: Making sign up and login for staff and patient up to date. Patient can make appointment and staff can confirm/ cancel the appointment
Made the tests for entity package. Since we have changed our program's base quit often. I don't have a pull request that
contains all of them. This link to the https://github.com/CSC207-UofT/course-project-tut5101-hospital/pull/38. 
I have also been working on debugging throughout the past week. I have also split up the UI into multiple parts instead of a single UI class.

