package Gateways;

import Entity.Patients.PatientData;

public class PatientGateWay {
    public void saveSession(PatientData sessionData) {
        sessionData.saveData();
    }
}
