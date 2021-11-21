package Controllers;
import Entity.Staff.Staff;
import Schedule.Schedule;
import UseCases.PatientManager;
import Entity.Patients.Patient;
import UseCases.StaffManager;


public class LoginSignup {
    PatientManager pm ;
    StaffManager sm;
    public LoginSignup(){
        this.pm = new PatientManager();
        this.sm = new StaffManager();
    }

    public Boolean check_if_patient_exists(int hcn){
        return (pm.checkIfPateintExist(hcn));
    }

    public Boolean check_if_staff_exists(int id){
        return (sm.checkIfStaffExist(id));
    }

    public boolean LoginForPatients(int hcn, String ipt_pwd){
        return pm.checkLoginInfo(hcn, ipt_pwd);
    }

    public boolean LoginForStaffs(int id, String ipt_pwd){
        return sm.checkLoginInfo(id, ipt_pwd);
    }

    public void signUpForPatients(String name, String gender, int contactNum, int healthCardNum, String pwd){
        pm.addPatient(name, gender, contactNum, healthCardNum, pwd);
    }

    public void signUpForStaffs(String name, String gender, Integer id, Schedule workingTime, String pwd, int base_salary){
        sm.addStaff(name, gender, id, workingTime, pwd, base_salary);
    }

    public Patient initPatient(int hcn){
        return pm.getPatient(hcn);
    }

    public Staff initStaff(int id){
        return sm.getStaff(id);
    }
}