package UI;

import Schedule.ScheduleManager;
import UseCases.LoginSignup;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class MenuTest {
    private static final LoginSignup ls = new LoginSignup();

    @Test
    public void testLoginSignup(){
        String userInput = String.format("1%sHarry%sMale%s111111%s222222%s333333%s1%sill%s" +
                        "2020-12-01 12:00%s2020-12-01 13:00%s2%s222222%s333333%s2",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        MenuTest.main(null);

        ls.signUp("Harry", "Male", 111111, 222222, "333333");
        ScheduleManager sm = new ScheduleManager(ls.initPatient(222222));
        String actual = sm.getScheduleString();

        String expected = "Start-End:\t2020-12-01 12:00 Tue\t2020-12-01 13:00 Tue\t\tEvent:ill";
        // checkout output
        Assert.assertEquals(expected,actual);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.loginSignup();
        menu.activities();
        menu.loginSignup();
        menu.activities();
    }
}
