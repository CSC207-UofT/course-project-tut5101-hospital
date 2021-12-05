package UseCases.Staff.MethodsForStaffManager;

import Entity.Patients.Patient;
import Entity.Schedule.Schedule;
import Entity.Staff.*;
import UseCases.Staff.Builders.*;

public class NewStaffs {
    public Staff newAdmin(String name, String gender, Long ID, Schedule workingTime, String pwd, int fixedSalary) {
        AdminBuilder adm = new AdminBuilder();
        setProperties(adm, name, gender, ID, workingTime, pwd, fixedSalary);
        return adm.getResult();
    }

    public Staff newNurse(String name, String gender, Long ID, Schedule workingTime, String pwd, int fixedSalary) {
        NurseBuilder adm = new NurseBuilder();
        setProperties(adm, name, gender, ID, workingTime, pwd, fixedSalary);
        return adm.getResult();
    }

    public Staff newDoctor(String name, String gender, Long ID, Schedule workingTime, String pwd, int fixedSalary) {
        DoctorBuilder adm = new DoctorBuilder();
        setProperties(adm, name, gender, ID, workingTime, pwd, fixedSalary);
        return adm.getResult();
    }

    public Staff newAccountant(String name, String gender, Long ID, Schedule workingTime, String pwd, int fixedSalary) {
        AccountantBuilder adm = new AccountantBuilder();
        setProperties(adm, name, gender, ID, workingTime, pwd, fixedSalary);
        return adm.getResult();
    }

    //set properties of the new staff
    public void setProperties(StaffBuilder sm, String name, String gender, Long ID, Schedule workingTime, String pwd, int fixedSalary) {
        sm.setName(name);
        sm.setGender(gender);
        sm.setWorkingTime(workingTime);
        sm.setId(ID);
        sm.setPwd(pwd);
        sm.setSalary(fixedSalary);
    }
}
