package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.ProjectSteps;

public class DeleteProject extends BaseTest {
    private ProjectSteps projectSteps;

    @Test
    public void DeleteProjectTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        projectSteps = new ProjectSteps(driver);
        projectSteps.deleteProject();
    }
}
