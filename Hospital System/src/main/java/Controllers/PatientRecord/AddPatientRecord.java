package Controllers.PatientRecord;

import UseCases.Patient.PatientManager;
import UseCases.PatientRecord.PatientRecordListManager;

import java.util.List;

public class AddPatientRecord {
    PatientManager patientManager = PatientManager.getInstance();
    PatientRecordListManager pRLmanager;

    public AddPatientRecord(long healthCardNumber) {
        pRLmanager = patientManager.getPatientRecordListManager(healthCardNumber);
    }

    public void newPatientRecord(String height, String weight, String sex, List<String> allergies, List<String> vaccinations, String date) {
        pRLmanager.newPatientRecord(height, weight, sex, allergies, vaccinations, date);
    }
}
