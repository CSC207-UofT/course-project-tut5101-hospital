package Controllers.LoginSignUp;

import Entity.Staff.Staff;
import Entity.Schedule.Schedule;
import Exceptions.InvalidInputException;
import UseCases.Patient.PatientManager;
import Entity.Patients.Patient;
import UseCases.Patient.PatientManaging;
import UseCases.Schedule.ScheduleManager;
import UseCases.Schedule.ScheduleManaging;
import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;


public class LoginSignup {
    /**
     * Controller for login sign up
     */
    PatientManaging pm;
    StaffManaging sm;
    ScheduleManaging sms;

    /**
     * Constructor for login sign up
     */
    public LoginSignup() {
        this.pm = new PatientManager();
        this.sm = new StaffManager();
        this.sms = new ScheduleManager(new Schedule());
    }

    /**
     * Return boolean indicate if patient exists or not
     *
     * @param healthCardNumber health card number of the patient
     * @return if the patient with the healthCardNumber exist
     */
    public Boolean checkIfPatientExists(long healthCardNumber) {
        return (pm.checkIfPatientExist(healthCardNumber));
    }

    /**
     * Return boolean indicate if staff exists or not
     *
     * @param id id of the staff
     * @return if the staff with the id exist
     */
    public Boolean checkIfStaffExists(Long id) {
        return (sm.checkIfStaffExist(id));
    }

    /**
     * Login for patients
     *
     * @param healthCardNumber health card number of the patient
     * @param iptPwd           password of the patient
     * @return if the login for this patient is successful
     */
    public boolean LoginForPatients(long healthCardNumber, String iptPwd) {
        return pm.checkLoginInfo(healthCardNumber, iptPwd);
    }

    /**
     * Login for staff
     *
     * @param id      id of the staff
     * @param ipt_pwd password of the staff
     * @return if the login for this staff is successful
     */
    public boolean LoginForStaffs(long id, String ipt_pwd) {
        return sm.checkLoginInfo(id, ipt_pwd);
    }

    /**
     * Sign up for patients
     *
     * @param name          Name of the Patient
     * @param gender        Gender of the Patient
     * @param contactNum    contactNum of the Patient
     * @param healthCardNum healthCardNum of the Patient
     * @param pwd           password of the Patient
     */
    public void signUpForPatients(String name, String gender, long contactNum, long healthCardNum, String pwd, int fee) {
        pm.addPatient(name, gender, contactNum, healthCardNum, pwd, fee);
    }

    /**
     * Sign up for staff
     *
     * @param name        Name of the Staff
     * @param gender      Gender of the Staff
     * @param id          id of the staff
     * @param workingTime working schedule of the staff
     * @param pwd         password of the staff
     * @param baseSalary  base salary of the staff
     */
    public void signUpForDoctors(String name, String gender, long id, Schedule workingTime, String pwd, int baseSalary) {
        sm.addDoctor(name, gender, id, workingTime, pwd, baseSalary);
    }


    public Schedule makeWorkingTime(String event) throws InvalidInputException {
        return sms.staffSchedule(event);
    }

    /**
     * Return a patient by given a health card number
     *
     * @param healthCardNumber healthCardNumber of the patient
     * @return a patient with the healthcard number
     */
    public Patient initPatient(long healthCardNumber) {
        return pm.getPatient(healthCardNumber);
    }

    /**
     * Return a staff by given a stuff id
     *
     * @param id id of the staff
     * @return a staff with that id
     */
    public Staff initStaff(long id) {
        return sm.getStaff(id);
    }
}