package UseCases;

import Entity.Patients.Patient;
import Entity.Patients.PatientData;

public class PatientManager {
    PatientData sessionData = new PatientData();
    public Patient newPatient(String name, String gender, int contactNum, int healthCardNum, String pwd){
        return new Patient(name, gender, contactNum, healthCardNum, pwd);
    }public void addPatient(String name, String gender, int contactNum, int healthCardNum, String pwd) {
        Patient p = new Patient(name, gender, contactNum, healthCardNum, pwd);
        sessionData.add_or_modify_Patient(p);
        saveSession();
    }private void saveSession(){
        sessionData.saveData();
    }public Patient getPatient(int healthCardNum){
            return sessionData.searchHCN(healthCardNum);
    }public boolean checkIfPateintExist(int hcn){
        return (sessionData.searchHCN(hcn)!=null);
    }public boolean checkLoginInfo(int hcn, String pwd){
        if(sessionData.searchHCN(hcn)!=null){
            return sessionData.searchHCN(hcn).checkPwd(pwd);
        }return false;
        
    }
    
}