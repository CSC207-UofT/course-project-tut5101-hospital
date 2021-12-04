package Presenters.PatientRecords;


import UseCases.Patient.PatientManager;


public class PatientMedicalRecordViewer {
    /**
     * Presenter to view patient medical record
     */

    PatientManager patientManager = new PatientManager();

    /**
     * Call use case to return patient medical record
     *
     * @param healthCardNumber Health card number of that patient
     * @return A string
     */
    public String print(long healthCardNumber) {
        return patientManager.getPatientMedicalRecord(healthCardNumber);

    }

}
