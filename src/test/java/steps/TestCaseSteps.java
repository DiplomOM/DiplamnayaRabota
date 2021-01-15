package steps;

import baseEntities.TestCaseModel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.TestCasePage;


public class TestCaseSteps {

    private final WebDriver driver;

    public TestCaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void createTestCaseWithNegativeEstimate(TestCaseModel testCase) {
        final TestCasePage testCasePage = new TestCasePage(driver, true);
        testCasePage.setInputForm(testCase.getTitle());
        testCasePage.setEstimate(testCase.getEstimate());
        testCasePage.submitAcceptButton();

        Assert.assertEquals(testCasePage.getErrorMessage(), "Field Estimate is not in a valid time span format.");
    }

    @Step
    public void uploadFile(TestCaseModel testCase) {
        final TestCasePage testCasePage = new TestCasePage(driver, true);
        testCasePage.setInputForm(testCase.getTitle());
        testCasePage.openPreconditionsForm();
        testCasePage.uploadFile(testCase.getFilePath());
        testCasePage.submitAddButton();
        testCasePage.submitAcceptButton();

        Assert.assertEquals(driver.findElement(By.className("message-success")).getText(),
                "Successfully added the new test case. Add another");
    }
}
