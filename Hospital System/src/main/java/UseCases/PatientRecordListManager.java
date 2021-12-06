package UseCases;

import Entity.PatientRecords.PatientMedicalHistory;
import Entity.PatientRecords.PatientRecordList;
import Entity.PatientRecords.PatientRecords;
import Entity.Patients.Patient;
import Entity.Patients.PatientData;
import Entity.Staff.StaffData;

public class PatientRecordListManager {
    PatientRecordList patientRecordList;
    PatientData sessionData;

    /**
     * Constructor for patient record list manager when input is patient
     *
     * @param p patient
     */
    public ScheduleManager(Patient p) {
        sessionData = new PatientData();
        this.patientRecordList = p.getPRL();
    }

    public PatientRecordList getPatientRecordList() {return this.patientRecordList;}

    private void savePatientRecordList() {
        sessionData.saveData();
    }

    public void addRecord(PatientRecords record, String date) {
        patientRecordList.addRecord(record, date);
    }

    public void addHistory(PatientMedicalHistory history, String date) {
        patientRecordList.addHistory(history, date);
    }
}
