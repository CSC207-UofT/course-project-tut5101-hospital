package Entity.Staff.Builders;

import Entity.Patients.Patient;
import Entity.Staff.Builders.StaffBuilder;
import Entity.Staff.Nurse;

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
