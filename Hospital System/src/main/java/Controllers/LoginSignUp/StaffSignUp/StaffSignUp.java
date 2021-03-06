package Controllers.LoginSignUp.StaffSignUp;
// Avoid Clean Ar

import Entity.Schedule.Schedule;

public interface StaffSignUp {
    /**
     * Controller interface to sign up doctor
     *
     * @param name        name
     * @param gender      gender
     * @param ID          id
     * @param workingTime working time
     * @param password    password
     * @param fixedSalary fixed salary
     */
    void signUp(String name, String gender, long ID, Schedule workingTime, String password, int fixedSalary);
}
