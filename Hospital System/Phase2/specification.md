Specification:

Running the project starts a system that allows the user to interact with a hospital system that shows in the system terminal, before you get in the system, you need to choose whether you are a staff or a patient.
While running, the program prints a few choices to let users choose what they want to do:

For patients inputs:

    Signup or Login (phase 0)

    Make or View Appointment (phase 0)
    
    forgot password
    
    choose which staff and what time they want the appointment.
    
    Book operation
    
    

For staff inputs:

    Signup or Login

    forgot password

    View or change Schedule

    View Patient Records
    
    
For System inputs other than patient and staff:

    print out all staff. After patient chooses one of them, print out all the avaliable timing for the chosen staff.

    assign operation to staff that patient have chosen
    
    calculate patient fees after patient chooses what illness they have.
    
    calculate staff salaries
    
    Calculate the financial overview of the system (patient fee subtract staff salary)
    
    Best staff (who worked the most)
    

Every user input should be able to be typed into the console as a command line format.

Signup or Login: Entity.Patients.Patient create an account, patient login to their account (phase 0)

Make or View Appointment: Entity.Patients.Patient check their appointment, patients change their appointment, patients cancel the appointment. (phase 0)

Signup or Login: Entity.Patients.Patient create an account, patient login to their account. (phase 0)

View Patient Records: Entity.Staff gets Patient medical records from the system. 

View Schedule: Entity.Staff views their work schedule. Appointments are based on their schedule.

Exit: Quit the program
