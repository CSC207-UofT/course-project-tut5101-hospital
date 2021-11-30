package UseCases.Patient;

import Entity.PatientRecords.PatientMedicalHistory;
import Entity.PatientRecords.PatientRecordList;
import Entity.PatientRecords.PatientRecords;
import Entity.Patients.Patient;
import Entity.Patients.PatientBuilder;
import Entity.Patients.PatientData;
import UseCases.Schedule.ScheduleManager;

import java.util.Map;

public class PatientManager implements PatientManaging {
    /**
     * Patient manager
     */
    PatientData sessionData = new PatientData();

    /**
     * For new patient
     *
     * @param name          Name of the patient
     * @param gender        Gender of the patient
     * @param contactNum    Contact Number of the patient
     * @param healthCardNum Health card number of the patient
     * @param pwd           Password of the patient
     * @return A patient
     */
    public Patient newPatient(String name, String gender, int contactNum, int healthCardNum, String pwd, int fee) {
        PatientBuilder pm = new PatientBuilder();
        pm.setContactNumber(contactNum);
        pm.setGender(gender);
        pm.setHcn(healthCardNum);
        pm.setPwd(pwd);
        pm.setName(name);
        pm.setFee(fee);
        return pm.getPatient();
    }

    /**
     * Add patient
     *
     * @param name          Name of the patient
     * @param gender        Gender of the patient
     * @param contactNum    Contact Number of the patient
     * @param healthCardNum Health card number of the patient
     * @param pwd           Password of the patient
     */
    public void addPatient(String name, String gender, int contactNum, int healthCardNum, String pwd, int fee) {
        PatientBuilder pm = new PatientBuilder();
        pm.setContactNumber(contactNum);
        pm.setGender(gender);
        pm.setHcn(healthCardNum);
        pm.setPwd(pwd);
        pm.setName(name);
        pm.setFee(fee);
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
     *
     * @param healthCardNum health card number
     * @return A patient
     */
    public Patient getPatient(int healthCardNum) {
        return sessionData.searchHCN(healthCardNum);
    }

    /**
     * Get patient Schedule manager
     *
     * @param healthCardNum health card number
     * @return ScheduleManager
     */
    public ScheduleManager getPatientScheduleManager(int healthCardNum) {
        return new ScheduleManager(sessionData.searchHCN(healthCardNum));
    }

    /**
     * Check if patient exist
     *
     * @param healthCardNumber health card number
     * @return Boolean
     */
    public boolean checkIfPatientExist(int healthCardNumber) {
        return (sessionData.searchHCN(healthCardNumber) != null);
    }

    /**
     * Check login information
     *
     * @param healthCardNumber health card number
     * @param password         Password
     * @return Boolean
     */
    public boolean checkLoginInfo(int healthCardNumber, String password) {
        if (sessionData.searchHCN(healthCardNumber) != null) {
            return sessionData.searchHCN(healthCardNumber).checkPwd(password);
        }
        return false;

    }

    /**
     * Get patient medical record
     *
     * @param healthCardNumber Healthcard number for that patient
     * @return A string
     */
    public String getPatientMedicalRecord(int healthCardNumber) {
        Patient patient = getPatient(healthCardNumber);
        PatientRecordList patientRecordList = patient.getPRL();
        StringBuilder list = new StringBuilder();
        for (Map.Entry<String, Object> entry : patientRecordList.getPatientRecords().entrySet()) {
            if (entry.getValue() instanceof PatientMedicalHistory) {
                list.append(((PatientMedicalHistory) entry.getValue()).getPatientMH());
            }
        }
        return list.toString();
    }

    /**
     * Get patient record
     *
     * @param healthCardNumber Healthcard number for that patient
     * @return A string
     */
    public String getPatientRecord(int healthCardNumber) {
        StringBuilder list = new StringBuilder();
        Patient patient = getPatient(healthCardNumber);
        PatientRecordList patientRecordList = patient.getPRL();
        for (Map.Entry<String, Object> entry : patientRecordList.getPatientRecords().entrySet()) {
            if (entry.getValue() instanceof PatientRecords) {
                list.append(((PatientRecords) entry.getValue()).getPatientRecord());
            }
        }
        return list.toString();
    }


}