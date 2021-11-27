package Entity.PatientRecords;

import java.util.ArrayList;
import java.util.List;

public class PatientRecordList {
    List<Object> patientRecords = new ArrayList();  //takes in a list of all patient records and medical history

    public void addRecord(PatientRecords record) {
        patientRecords.add(record);
    }
    public void addHistory(PatientMedicalHistory history) {
        patientRecords.add(history);
    }
}
