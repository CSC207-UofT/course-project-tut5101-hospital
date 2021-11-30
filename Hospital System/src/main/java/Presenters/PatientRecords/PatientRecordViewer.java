package Presenters.PatientRecords;

import UseCases.Patient.PatientManager;


public class PatientRecordViewer {
    /**
     * Presenter to view patient record
     */

    PatientManager patientManager = new PatientManager();

    /**
     * Call use case to return patient record
     *
     * @param healthCardNumber Health card number of that patient
     * @return A string
     */
    public String print(int healthCardNumber) {
        return patientManager.getPatientRecord(healthCardNumber);
    }


}
