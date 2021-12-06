package UseCases.Patient;

import Entity.PatientRecords.PatientMedicalHistory;
import Entity.PatientRecords.PatientRecordList;
import Entity.PatientRecords.PatientRecords;
import Entity.Patients.Patient;
import Entity.Patients.PatientBuilder;
import Entity.Patients.PatientData;
import UseCases.PatientRecordListManager;
import UseCases.Schedule.ScheduleManager;

import java.util.HashMap;
import java.util.Map;

public class PatientManager implements PatientManaging, java.io.Serializable {
    /**
     * Patient manager
     */
    PatientData sessionData = new PatientData();
    private static PatientManager pm =null;

    private PatientManager(){

    }
    public static PatientManager getInstance() {
        if(pm == null){
            pm = new PatientManager();
        }return pm;
    }


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
    public Patient newPatient(String name, String gender, long contactNum, long healthCardNum, String pwd, int fee) {
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
    public void addPatient(String name, String gender, long contactNum, long healthCardNum, String pwd, int fee) {
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
    public void saveSession() {
        sessionData.saveData();
    }

    /**
     * Get patient by given a health card number
     *
     * @param healthCardNum health card number
     * @return A patient
     */
    public Patient getPatient(long healthCardNum) {
        return sessionData.searchHCN(healthCardNum);
    }

    /**
     * Get patient Schedule manager
     *
     * @param healthCardNum health card number
     * @return ScheduleManager
     */
    public ScheduleManager getPatientScheduleManager(long healthCardNum) {
        return new ScheduleManager(sessionData.searchHCN(healthCardNum));
    }

    /**
     * Get patient record list manager
     *
     * @param healthCardNum health card number
     * @return Patient Record List Manager
     */
    public PatientRecordListManager getPatientRecordListManager(long healthCardNum) {
        return new PatientRecordListManager(sessionData.searchHCN(healthCardNum));
    }

    /**
     * Check if patient exist
     *
     * @param healthCardNumber health card number
     * @return Boolean
     */
    public boolean checkIfPatientExist(long healthCardNumber) {
        return (sessionData.searchHCN(healthCardNumber) != null);
    }

    /**
     * Check login information
     *
     * @param healthCardNumber health card number
     * @param password         Password
     * @return Boolean
     */
    public boolean checkLoginInfo(long healthCardNumber, String password) {
        if (sessionData.searchHCN(healthCardNumber) != null) {
            return sessionData.searchHCN(healthCardNumber).checkPwd(password);
        }
        return false;

    }

    /**
     * Get patient medical record
     *
     * @param healthCardNumber Health card number for that patient
     * @return A string
     */
    public String getPatientMedicalRecord(long healthCardNumber) {
        Patient patient = getPatient(healthCardNumber);
        PatientRecordList patientRecordList = patient.getPRL();
        String record = "";
        HashMap<String, Object> patientRecords =  patientRecordList.getPatientRecords();

        for (Object value: patientRecords.values()) {
            if (value instanceof PatientMedicalHistory) {
                record+=(((PatientMedicalHistory) value).getPatientMH());
            }
        }
        return record;
    }

    /**
     * Get patient record
     *
     * @param healthCardNumber Health card number for that patient
     * @return A string
     */
    public String getPatientRecord(long healthCardNumber) {
        Patient patient = getPatient(healthCardNumber);
        PatientRecordList patientRecordList = patient.getPRL();
        String record = "";
        HashMap<String, Object> patientRecords =  patientRecordList.getPatientRecords();
        for (Object value: patientRecords.values()) {
            if (value instanceof PatientRecords) {
                record+=(((PatientRecords) value).getPatientRecord());
            }
        }
        return record;
    }


}