import Schedule.ScheduleManager;
import UI.Menu;
import UseCases.LoginSignup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMenu {

    private LoginSignup loginSignup;

    @Before
    public void setUp() throws Exception {
        loginSignup = new LoginSignup();
        loginSignup.signUp("Harry", "Male", 1, 2, "3");
    }

    @Test
    public void TestLoginSignUpHCNexist() {
        Assert.assertTrue("Health card should be added into the system as part of the signup", loginSignup.check_if_patient_exists(2));
    }


}
