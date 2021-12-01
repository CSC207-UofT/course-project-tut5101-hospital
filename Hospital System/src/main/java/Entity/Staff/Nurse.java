package Entity.Staff;

import Entity.Patients.Patient;


import java.util.*;

public class Nurse extends Staff implements java.io.Serializable {
    /**
     * Nurse Entity
     */
    private ArrayList<Patient> patients;

    public Nurse() {

    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }
}
