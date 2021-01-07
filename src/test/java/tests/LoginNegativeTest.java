package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void negativeTest(){
        LoginSteps loginSteps = new LoginSteps(driver);
        LoginPage resultPage = loginSteps.login(readProperties.getUserName(), " ");
        Assert.assertEquals(resultPage.getLoginPageMessage(), "Password is required.");
    }
}
