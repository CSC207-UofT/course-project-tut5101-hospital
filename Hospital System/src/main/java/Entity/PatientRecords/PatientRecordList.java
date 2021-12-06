package Entity.PatientRecords;

import java.util.HashMap;


public class PatientRecordList implements java.io.Serializable {
    /**
     * This file contains the class Patient Record List and is used to get a hashmap of all
     * patient medical history and patient records.
     */

    private HashMap<String, Object> patientRecords = new HashMap<>();

    public void addRecord(PatientRecords record, String date) {
        this.patientRecords.put(date, record);
    }

    public void addHistory(PatientMedicalHistory history, String date) {
        this.patientRecords.put(date, history);
    }

    /**
     * Get a hashmap of all patient medical history and patient records.
     *
     * @return A hashmap
     */
    public HashMap<String, Object> getPatientRecords() {
        return this.patientRecords;
    }

    public void setPatientRecords(HashMap<String, Object> patientRecords) {
        this.patientRecords = patientRecords;
    }
}
