package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class NegativeDataTest extends BaseTest {

    @Test(priority = 1)
    public void inputIncorrectData() {
        new LoginSteps(driver).login(readProperties.getUserName(), readProperties.getPassword());
        final ProjectSteps projectSteps = new ProjectSteps(driver);
        final AddProjectPage resultPage = projectSteps.createProject(" ");
        Assert.assertEquals(resultPage.getErrorMessage(), "Field Name is a required field.");
    }


}
