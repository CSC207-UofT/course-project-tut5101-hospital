

public class LoginSignup {
    PatientData pd = new PatientData();
    public Boolean check_if_patient_exists(int hcn){
        return (pd.searchHCN(hcn) != null);
    }public Boolean logIn(Patient p, int ipt_pwd){
        return p.checkPwd(ipt_pwd);
    }public Patient signUp(String name, String gender, int contactNum, int healthCardNum, int pwd){
        PatientManager pm = new PatientManager();
        Patient p=pm.newPatient(name, gender,contactNum, healthCardNum, pwd);
        pm.addPatient(p);
        return p;
    }
}