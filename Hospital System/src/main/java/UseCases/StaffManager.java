package UseCases;

import Entity.Staff.StaffData;
import Entity.Staff.Staff;
import Schedule.Schedule;

// This is based on PatientManager with changes that would modify the class, so that Staff can use it
public class StaffManager {

    StaffData sessionData = new StaffData();

    public Staff newStaff(String name, String gender, Integer ID, Schedule workingTime, String pwd,int fixed_salary){
        return new Staff(name, gender, ID, workingTime, pwd, fixed_salary);
    }

    public void addStaff(String name, String gender, Integer ID, Schedule workingTime, String pwd,int fixed_salary) {
        Staff s = new Staff(name, gender, ID, workingTime, pwd, fixed_salary);
        sessionData.add_or_modify_Staff(s);
        saveSession();
    }

    private void saveSession(){
        sessionData.saveData();
    }

    public Staff getStaff(Integer ID){
        return sessionData.searchID(ID);
    }

    public boolean checkIfStaffExist(Integer ID){
        return (sessionData.searchID(ID)!=null);
    }

    public boolean checkLoginInfo(Integer ID, String pwd){
        if(sessionData.searchID(ID)!=null){
            return sessionData.searchID(ID).checkPwd(pwd);
        }return false;

    }

}