package Controllers.LoginSignUp.StaffSignUp;

import Entity.Schedule.Schedule;

public interface StaffSignUp {
    void signUp(String name, String gender, long ID, Schedule workingTime, String pwd, int fixedSalary);
}
