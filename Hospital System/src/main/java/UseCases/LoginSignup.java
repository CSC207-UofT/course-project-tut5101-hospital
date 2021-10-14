package UseCases;
import Patients.PatientManager;
import Patients.Patient;





public class LoginSignup {
    PatientManager pm ;
    public LoginSignup(){
        this.pm = new PatientManager();
    }
    public Boolean check_if_patient_exists(int hcn){
        return (pm.checkIfPateintExist(hcn));
    }public boolean logIn(int hcn, String ipt_pwd){
        return pm.checkLoginInfo(hcn, ipt_pwd);
            
    }public void signUp(String name, String gender, int contactNum, int healthCardNum, String pwd){
        pm.addPatient(name, gender, contactNum, healthCardNum, pwd);
        
    }public Patient initPatient(int hcn){
        return pm.getPatient(hcn);
    }
}