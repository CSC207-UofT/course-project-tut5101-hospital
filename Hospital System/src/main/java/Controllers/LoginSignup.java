package Controllers;


import Entity.Patients.Patient;
import UseCases.PatientManager;

public class LoginSignup {
    PatientManager pm = new PatientManager();

    public LoginSignup() {
    }

    public Boolean check_if_patient_exists(int var1) {
        return this.pm.checkIfPateintExist(var1);
    }

    public boolean logIn(int var1, String var2) {
        return this.pm.checkLoginInfo(var1, var2);
    }

    public void signUp(String var1, String var2, int var3, int var4, String var5) {
        PatientManager var6 = new PatientManager();
        var6.addPatient(var1, var2, var3, var4, var5);
    }

    public Patient initPatient(int var1) {
        return this.pm.getPatient(var1);
    }
}
