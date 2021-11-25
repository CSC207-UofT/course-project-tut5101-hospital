package UseCases.Patient;

import Entity.Patients.Patient;
import Entity.Patients.PatientBuilder;
import Entity.Patients.PatientData;
import UseCases.Schedule.ScheduleManager;

public class PatientManager implements PatientManaging {
    PatientData sessionData = new PatientData();

    public Patient newPatient(String name, String gender, int contactNum, int healthCardNum, String pwd) {
        PatientBuilder pm = new PatientBuilder();
        pm.setCtctn(contactNum);
        pm.setGender(gender);
        pm.setHcn(healthCardNum);
        pm.setPwd(pwd);
        pm.setName(name);
        return pm.getPatient();
    }

    public void addPatient(String name, String gender, int contactNum, int healthCardNum, String pwd) {
        PatientBuilder pm = new PatientBuilder();
        pm.setCtctn(contactNum);
        pm.setGender(gender);
        pm.setHcn(healthCardNum);
        pm.setPwd(pwd);
        pm.setName(name);
        Patient p = pm.getPatient();
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