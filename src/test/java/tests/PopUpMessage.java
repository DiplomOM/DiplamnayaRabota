package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class PopUpMessage extends BaseTest {
    private ProjectSteps projectSteps;

    @Test
    public void popUpMessageTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        projectSteps = new ProjectSteps(driver);
        projectSteps.popUpField();
    }
}
