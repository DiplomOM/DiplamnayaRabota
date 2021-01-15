package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.ProjectSteps;

public class CreateProject extends BaseTest {
    private ProjectSteps projectSteps;

    @Test
    public void CreateProjectTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        projectSteps = new ProjectSteps(driver);
        projectSteps.createPositiveProject("mikeProject");
    }
}
