package UseCases.PatientRecord;

import Entity.PatientRecords.PatientMedicalHistory;
import Entity.PatientRecords.PatientRecordList;
import Entity.PatientRecords.PatientRecords;
import Entity.Patients.Patient;
import Entity.Patients.PatientData;

import java.util.List;
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

    public PatientRecordList getPatientRecordList() {return this.patientRecordList;}

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
    //read a string denominating type of change and the input string that is to override the formertype
    public void editRecord(String num, String input){
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
    }public void newPatientRecord(String height, String weight, String sex, List<String> allergies, List<String> vaccinations, String date){
        PatientRecords patientRecords = new PatientRecords(height, weight, sex, allergies, vaccinations);
        addRecord(patientRecords, date);
    }

    public void newPatientHistory(String physicianName, String bloodPressure, String pulse, String temperature,
                                  List<String> currentMedications, String diagnosis, String treatment, String date){
        PatientMedicalHistory patientMedicalHistory = new PatientMedicalHistory(physicianName, bloodPressure, pulse,
                temperature, currentMedications, diagnosis, treatment);
        addHistory(patientMedicalHistory, date);
    }

    public boolean checkPatientRecordexists() {
        for (Map.Entry<String, Object> entry : PRL.getPatientRecords().entrySet()) {
            if (entry.getValue() instanceof PatientRecords) {
                return true;
            }
        }
        return false;
    }
}
