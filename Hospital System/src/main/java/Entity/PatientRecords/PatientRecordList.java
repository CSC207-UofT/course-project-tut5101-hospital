package Entity.PatientRecords;

import java.util.ArrayList;
import java.util.List;

public class PatientRecordList {
    List<Object> patientRecords = new ArrayList();  //takes in a list of all patient records and medical history

    public void addRecord(PatientRecords record) {
        patientRecords.add(record);
    } //patient records are fix and only one file should be present in the list and should be the first file on the list
    public void addHistory(PatientMedicalHistory history) {
        patientRecords.add(history);
    } //a new medical history file is added every time a patient comes to the hospital
}
