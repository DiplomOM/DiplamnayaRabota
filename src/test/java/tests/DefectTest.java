package tests;

import baseEntities.BaseTest;
import baseEntities.TestCaseModel;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.TestCaseSteps;

public class DefectTest extends BaseTest {


    @Test
    public void testCreateTestCase() {
        new LoginSteps(driver).login(readProperties.getUserName(), readProperties.getPassword());
        TestCaseSteps testCaseSteps = new TestCaseSteps(driver);
        testCaseSteps.createTestCaseWithNegativeEstimate(TestCaseModel.builder()
                .title(readProperties.getTitle())
                .estimate("-10")
                .build());
    }
}
