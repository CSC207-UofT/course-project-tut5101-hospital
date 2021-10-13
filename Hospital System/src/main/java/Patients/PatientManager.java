package Patients;
public class PatientManager {
    PatientData sessionData = new PatientData();
    public Patient newPatient(String name, String gender, int contactNum, int healthCardNum, String pwd){
        return new Patient(name, gender, contactNum, healthCardNum, pwd);
    }public void addPatient(Patient patient) {
        sessionData.add_or_modify_Patient(patient);
        saveSession();
    }private void saveSession(){
        sessionData.saveData();
    }public Patient getPatient(int healthCardNum){
            return sessionData.searchHCN(healthCardNum);
    }
}