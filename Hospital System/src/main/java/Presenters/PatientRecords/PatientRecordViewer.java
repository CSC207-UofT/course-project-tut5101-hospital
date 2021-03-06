package Presenters.PatientRecords;

import UseCases.Patient.PatientManager;


public class PatientRecordViewer {
    /**
     * Presenter to view patient record
     */

    PatientManager patientManager = PatientManager.getInstance();

    /**
     * Call use case to return patient record, return ""No Record found"" if there are no records
     *
     * @param healthCardNumber Health card number of that patient
     * @return A string
     */
    public String print(long healthCardNumber) {
        return patientManager.getPatientRecord(healthCardNumber);
    }


}
