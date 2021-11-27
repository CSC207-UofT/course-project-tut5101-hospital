package UseCases.Patient;

import Entity.Patients.Patient;
import Entity.Patients.PatientBuilder;
import Entity.Patients.PatientData;
import UseCases.Schedule.ScheduleManager;

public class PatientManager implements PatientManaging {
    /**
     * Patient manager
     */
    PatientData sessionData = new PatientData();

    /**
     * For new patient
     * @param name
     * @param gender
     * @param contactNum
     * @param healthCardNum
     * @param pwd
     * @return
     */
    public Patient newPatient(String name, String gender, int contactNum, int healthCardNum, String pwd) {
        PatientBuilder pm = new PatientBuilder();
        pm.setContactNumber(contactNum);
        pm.setGender(gender);
        pm.setHcn(healthCardNum);
        pm.setPwd(pwd);
        pm.setName(name);
        return pm.getPatient();
    }

    /**
     * Add patient
     * @param name
     * @param gender
     * @param contactNum
     * @param healthCardNum
     * @param pwd
     */
    public void addPatient(String name, String gender, int contactNum, int healthCardNum, String pwd) {
        PatientBuilder pm = new PatientBuilder();
        pm.setContactNumber(contactNum);
        pm.setGender(gender);
        pm.setHcn(healthCardNum);
        pm.setPwd(pwd);
        pm.setName(name);
        Patient p = pm.getPatient();
        sessionData.addOrModifyPatient(p);
        saveSession();
    }

    /**
     * Save session
     */
    private void saveSession() {
        sessionData.saveData();
    }

    /**
     * Get patient by given a health card number
     * @param healthCardNum
     * @return
     */
    public Patient getPatient(int healthCardNum) {
        return sessionData.searchHealthCardNumber(healthCardNum);
    }

    /**
     * Get patient Schedule manager
     * @param healthCardNum
     * @return
     */
    public ScheduleManager getPatientSm(int healthCardNum) {
        return new ScheduleManager(sessionData.searchHealthCardNumber(healthCardNum));
    }

    /**
     * Check if patient exist
     * @param hcn
     * @return
     */
    public boolean checkIfPatientExist(int hcn) {
        return (sessionData.searchHealthCardNumber(hcn) != null);
    }

    /**
     * Check login information
     * @param healthCardNumber
     * @param pwd
     * @return
     */
    public boolean checkLoginInfo(int healthCardNumber, String pwd) {
        if (sessionData.searchHealthCardNumber(healthCardNumber) != null) {
            return sessionData.searchHealthCardNumber(healthCardNumber).checkPwd(pwd);
        }
        return false;

    }

}