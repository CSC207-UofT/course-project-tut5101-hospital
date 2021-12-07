package Controllers.PatientRecord;

import UseCases.Patient.PatientManager;
import UseCases.PatientRecord.PatientRecordListManager;

import java.util.List;

public class AddPatientMH {
    PatientManager patientManager = PatientManager.getInstance();
    PatientRecordListManager pRLmanager;

    public AddPatientMH(long healthCardNumber){
        patientManager = PatientManager.getInstance();
        pRLmanager = patientManager.getPatientRecordListManager(healthCardNumber);
    }

    public void newPatientMH(String physicianName, String bloodPressure, String pulse, String temperature,
                             List<String> currentMedications, String diagnosis, String treatment, String date) {
        pRLmanager.newPatientHistory(physicianName, bloodPressure, pulse, temperature, currentMedications,
                diagnosis, treatment, date);
    }
}
