package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class LimitValueTest extends BaseTest {

    @Test
    public void LimitValueTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        AddProjectPage projectPage = new AddProjectPage(driver, true);
        projectPage.clickOnAddProjectButton();
        projectPage.clickAcceptButton();

        Assert.assertEquals(projectPage.getFieldNameErrorMsg(),"Error in Name Field");
    }
}
