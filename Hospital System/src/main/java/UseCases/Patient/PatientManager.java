package UseCases.Patient;

import Entity.Patients.Patient;
import Entity.Patients.PatientData;
import UseCases.Schedule.ScheduleManager;

public class PatientManager {
    PatientData sessionData = new PatientData();

    public Patient newPatient(String name, String gender, int contactNum, int healthCardNum, String pwd, int fee) {
        return new Patient(name, gender, contactNum, healthCardNum, pwd, fee);
    }

    public void addPatient(String name, String gender, int contactNum, int healthCardNum, String pwd, int fee) {
        Patient p = new Patient(name, gender, contactNum, healthCardNum, pwd, fee);
        sessionData.addOrModifyPatient(p);
        saveSession();
    }

    private void saveSession() {
        sessionData.saveData();
    }

    public Patient getPatient(int healthCardNum) {
        return sessionData.searchHCN(healthCardNum);
    }

    public ScheduleManager getPatientSm(int healthCardNum) {
        return new ScheduleManager(sessionData.searchHCN(healthCardNum));
    }

    public boolean checkIfPateintExist(int hcn) {
        return (sessionData.searchHCN(hcn) != null);
    }

    public boolean checkLoginInfo(int hcn, String pwd) {
        if (sessionData.searchHCN(hcn) != null) {
            return sessionData.searchHCN(hcn).checkPwd(pwd);
        }
        return false;

    }

}