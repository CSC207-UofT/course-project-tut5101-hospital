package Entity.Patients;

public class PatientBuilder {
    /**
     * Builder for patient entity
     */
    private Patient p;

    public PatientBuilder() {
        this.p = new Patient();
    }

    public void setName(String n) {
        p.setName(n);
    }

    public void setGender(String n) {
        p.setGender(n);
    }

    //set contact number
    public void setContactNumber(int c) {
        p.setContactNum(c);
    }

    public void setHcn(int h) {
        p.setHealthCardNum(h);
    }

    public void setPwd(String pwd) {
        p.setPwd(pwd);
    }

    public void setFee(int fee) {
        p.setFee(fee);
    }

    public Patient getPatient() {
        return p;
    }
}
