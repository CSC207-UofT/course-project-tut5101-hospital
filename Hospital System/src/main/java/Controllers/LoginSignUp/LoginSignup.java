package Controllers.LoginSignUp;
import Entity.Staff.Staff;
import Entity.Schedule.Schedule;
import UseCases.Patient.PatientManager;
import Entity.Patients.Patient;
import UseCases.Staff.StaffManager;


public class LoginSignup {
    PatientManager pm ;
    StaffManager sm;
    public LoginSignup(){
        this.pm = new PatientManager();
        this.sm = new StaffManager();
    }

    public Boolean checkIfPatientExists(int hcn){
        return (pm.checkIfPateintExist(hcn));
    }

    public Boolean checkIfStaffExists(int id){
        return (sm.checkIfStaffExist(id));
    }

    public boolean LoginForPatients(int hcn, String iptPwd){
        return pm.checkLoginInfo(hcn, iptPwd);
    }

    public boolean LoginForStaffs(int id, String ipt_pwd){
        return sm.checkLoginInfo(id, ipt_pwd);
    }

    public void signUpForPatients(String name, String gender, int contactNum, int healthCardNum, String pwd){
        pm.addPatient(name, gender, contactNum, healthCardNum, pwd);
    }

    public void signUpForStaffs(String name, String gender, Integer id, Schedule  workingTime, String pwd, int baseSalary){
        sm.addStaff(name, gender, id, workingTime, pwd, baseSalary);
    }

    public Patient initPatient(int hcn){
        return pm.getPatient(hcn);
    }

    public Staff initStaff(int id){
        return sm.getStaff(id);
    }
}