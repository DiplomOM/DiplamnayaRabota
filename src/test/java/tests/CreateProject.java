package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import steps.LoginSteps;

public class CreateProject extends BaseTest {

    @Test
    public void CreateProjectTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        AddProjectPage projectPage = new AddProjectPage(driver, true);
        projectPage.isPageOpened();
        projectPage.clickOnAddProjectButton();
        projectPage.setInputField("test");
        projectPage.clickAcceptButton();
    }
}
