package UseCases.Staff.Builders;

import Entity.Staff.OtherStaff;

public class OtherStaffBuilder extends StaffBuilder {
    /**
     * Other Staff builder for other staff.
     */

    public OtherStaffBuilder() {
        this.s = new OtherStaff();
    }

    @Override
    public OtherStaff getResult() {
        return (OtherStaff) s;
    }

    public void setRole(String role) {
        ((OtherStaff) s).setRole(role);
    }
}
