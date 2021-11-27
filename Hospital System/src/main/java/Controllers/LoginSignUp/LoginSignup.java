package Controllers.LoginSignUp;

import Entity.Staff.Staff;
import Entity.Schedule.Schedule;
import UseCases.Patient.PatientManager;
import Entity.Patients.Patient;
import UseCases.Patient.PatientManaging;
import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;


public class LoginSignup {
    /**
     * Controller for login sign up
     */
    PatientManaging pm;
    StaffManaging sm;

    /**
     * Constructor for login sign up
     */
    public LoginSignup() {
        this.pm = new PatientManager();
        this.sm = new StaffManager();
    }

    /**
     * Return boolean indicate if patient exists or not
     *
     * @param healthCardNumber
     * @return
     */
    public Boolean checkIfPatientExists(int healthCardNumber) {
        return (pm.checkIfPatientExist(healthCardNumber));
    }

    /**
     * Return boolean indicate if staff exists or not
     *
     * @param id
     * @return
     */
    public Boolean checkIfStaffExists(int id) {
        return (sm.checkIfStaffExist(id));
    }

    /**
     * Login for patients
     *
     * @param healthCardNumber
     * @param iptPwd
     * @return
     */
    public boolean LoginForPatients(int healthCardNumber, String iptPwd) {
        return pm.checkLoginInfo(healthCardNumber, iptPwd);
    }

    /**
     * Login for staff
     * @param id
     * @param ipt_pwd
     * @return
     */
    public boolean LoginForStaffs(int id, String ipt_pwd) {
        return sm.checkLoginInfo(id, ipt_pwd);
    }

    /**
     * Sign up for patients
     *
     * @param name
     * @param gender
     * @param contactNum
     * @param healthCardNum
     * @param pwd
     */
    public void signUpForPatients(String name, String gender, int contactNum, int healthCardNum, String pwd) {
        pm.addPatient(name, gender, contactNum, healthCardNum, pwd);
    }

    /**
     * Sign up for staff
     *
     * @param name
     * @param gender
     * @param id
     * @param workingTime
     * @param pwd
     * @param baseSalary
     */
    public void signUpForStaffs(String name, String gender, Integer id, Schedule workingTime, String pwd, int baseSalary) {
        sm.addStaff(name, gender, id, workingTime, pwd, baseSalary);
    }

    /**
     * Return a patient by given a health card number
     *
     * @param healthCardNumber
     * @return
     */
    public Patient initPatient(int healthCardNumber) {
        return pm.getPatient(healthCardNumber);
    }

    /**
     * Return a staff by given a stuff id
     *
     * @param id
     * @return
     */
    public Staff initStaff(int id) {
        return sm.getStaff(id);
    }
}