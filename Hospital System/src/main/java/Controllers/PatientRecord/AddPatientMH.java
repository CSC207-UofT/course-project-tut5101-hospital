package Controllers.PatientRecord;

import UseCases.Patient.PatientManager;
import UseCases.PatientRecord.PatientRecordListManager;

public class AddPatientMH {
    PatientManager patientManager = PatientManager.getInstance();
    PatientRecordListManager pRLmanager;

    public AddPatientMH(long healthCardNumber){

        pRLmanager = patientManager.getPatientRecordListManager(healthCardNumber);
        pRLmanager.addHistory(patientMedicalHistory, date);
    }
}
