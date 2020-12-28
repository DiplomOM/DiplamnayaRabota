package tests;

import baseEntities.BaseTest;
import baseEntities.TestCaseModel;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.TestCaseSteps;

public class FileUploadTest extends BaseTest {


    @Test(priority = 0)
    public void openPage() {
        new LoginSteps(driver).login(readProperties.getUserName(), readProperties.getPassword());
    }

    @Test(priority = 1)
    public void fileUploadTest() {
        final TestCaseSteps testCaseSteps = new TestCaseSteps(driver);
        testCaseSteps.createTestCase(TestCaseModel.builder().title(readProperties.getTitle()).filePath("").build());
    }

}
