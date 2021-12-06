package UseCases;

import Entity.PatientRecords.PatientMedicalHistory;
import Entity.PatientRecords.PatientRecordList;
import Entity.PatientRecords.PatientRecords;
import Entity.Patients.Patient;
import Entity.Patients.PatientData;
import Entity.Staff.StaffData;

import java.util.Map;

public class PatientRecordListManager {
    PatientRecordList patientRecordList;
    PatientData sessionData;

    /**
     * Constructor for patient record list manager when input is patient
     *
     * @param p patient
     */
    public PatientRecordListManager(Patient p) {
        sessionData = new PatientData();
        this.patientRecordList = p.getPRL();
    }

    public PatientRecordList getPatientRecordList() {
        return this.patientRecordList;
    }

    private void savePatientRecordList() {
        sessionData.saveData();
    }

    public void addRecord(PatientRecords record, String date) {
        patientRecordList.addRecord(record, date);
        savePatientRecordList();
    }

    public void addHistory(PatientMedicalHistory history, String date) {
        patientRecordList.addHistory(history, date);
        savePatientRecordList();
    }

    public void editRecord(String num, String input) {
        for (Map.Entry<String, Object> entry : patientRecordList.getPatientRecords().entrySet()) {
            if (entry.getValue() instanceof PatientRecords) {
                if (num.equals("1")) {
                    ((PatientRecords) entry.getValue()).changeHeight(input);
                    savePatientRecordList();
                }
                if (num.equals("2")) {
                    ((PatientRecords) entry.getValue()).changeWeight(input);
                    savePatientRecordList();
                }
                if (num.equals("3")) {
                    ((PatientRecords) entry.getValue()).addAllergy(input);
                    savePatientRecordList();
                }
                if (num.equals("4")) {
                    ((PatientRecords) entry.getValue()).addVaccination(input);
                    savePatientRecordList();
                }
            }
        }
    }

}
