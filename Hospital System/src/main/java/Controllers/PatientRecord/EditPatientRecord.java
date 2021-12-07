package Controllers.PatientRecord;

import Entity.PatientRecords.PatientRecordList;
import UseCases.Patient.PatientManager;
import UseCases.PatientRecord.PatientRecordListManager;

//edit the patient record given a patient's ID
public class EditPatientRecord {
    PatientManager patientManager = PatientManager.getInstance();
    PatientRecordList prl;
    PatientRecordListManager pRLmanager;

    public EditPatientRecord(long healthCardNumber) {
        pRLmanager = patientManager.getPatientRecordListManager(healthCardNumber);
        prl = pRLmanager.getPatientRecordList();
    }
    //change height in record
    public void editHeight(String c){
        pRLmanager.editRecord("1",c);
    }
    public void editWeight(String c){
        pRLmanager.editRecord("2",c);
    }
    public void editAllergy(String c){
        pRLmanager.editRecord("3",c);
    }
    public void editVaccination(String c){
        pRLmanager.editRecord("4",c);
    }

    public boolean checkPatientRecordexists() {
        return pRLmanager.checkPatientRecordexists();
    }
}
