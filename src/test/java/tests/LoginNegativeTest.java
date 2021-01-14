package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import steps.LoginSteps;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void negativeTest() {
        LoginSteps loginSteps = new LoginSteps(driver);

        loginSteps.wrongPasswordLogin(readProperties.getUserName(), " ");
    }
}
