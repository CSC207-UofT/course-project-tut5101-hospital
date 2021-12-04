package Entity.Staff;

import Entity.Patients.Patient;

import java.util.ArrayList;

//build doctor, uses staffbuilders methods and return a nurse
public class NurseBuilder extends StaffBuilder {
    Nurse n;

    public NurseBuilder() {
        this.s = new Nurse();
        this.n = (Nurse) s;
    }

    @Override
    public Nurse getResult() {
        return n;
    }

    public void setPatients(ArrayList<Patient> patients) {

        n.setPatients(patients);
    }
}
