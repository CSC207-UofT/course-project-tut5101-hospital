package Entity.PatientRecords;

import java.util.HashMap;

public class PatientRecordList implements java.io.Serializable {
    private HashMap<String, Object> patientRecords = new HashMap<String, Object>() {
    };  //takes in a list of all patient records and medical history

    public void addRecord(PatientRecords record, String date) {
        patientRecords.put(date, record);
    } //patient records are fix and only one file should be present in the list and should be the first file on the list

    public void addHistory(PatientMedicalHistory history, String date) {
        patientRecords.put(date, history);
    } //a new medical history file is added every time a patient comes to the hospital


    public HashMap<String, Object> getPatientRecords() {
        return patientRecords;
    }

    public void setPatientRecords(HashMap<String, Object> patientRecords) {
        this.patientRecords = patientRecords;
    }
}
