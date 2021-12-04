package UseCases.Staff.Builders;

import Entity.Staff.Accountant;
import Entity.Staff.Admin;

public class AccountantBuilder extends StaffBuilder{
    public AccountantBuilder() {
        this.s = new Accountant();
    }


    public Admin getResult() {
        return (Admin) s;
    }
}
