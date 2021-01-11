package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import steps.LoginSteps;

public class PopUpMessage extends BaseTest {

    @Test
    public void popUpMessageTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        AddProjectPage projectPage = new AddProjectPage(driver, true);
        projectPage.isPageOpened();
        projectPage.clickOnWorkingOnBtn();
        projectPage.getPopUpMsg();
    }
}
