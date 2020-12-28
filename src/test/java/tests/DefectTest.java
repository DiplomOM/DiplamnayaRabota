package tests;

import baseEntities.BaseTest;
import baseEntities.TestCaseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestCasePage;
import steps.LoginSteps;
import steps.TestCaseSteps;

public class DefectTest extends BaseTest {

    @Test(priority = 0)
    public void openPage() {
        new LoginSteps(driver).login(readProperties.getUserName(), readProperties.getPassword());
    }

    @Test
    public void testCreateTestCase() {
        TestCaseSteps testCaseSteps = new TestCaseSteps(driver);
        TestCasePage resultPage = testCaseSteps.createTestCase(TestCaseModel.builder()
                .title(readProperties.getTitle())
                .estimate("-10")
                .build());
        Assert.assertEquals(resultPage.getErrorMessage(), "Field Estimate is not in a valid time span format.");
    }
}
