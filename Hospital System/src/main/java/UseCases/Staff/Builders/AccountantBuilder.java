package UseCases.Staff.Builders;

import Entity.Staff.Accountant;

public class AccountantBuilder extends StaffBuilder {
    public AccountantBuilder() {
        this.s = new Accountant();
    }


    @Override
    public Accountant getResult() {
        return (Accountant) s;
    }
}
