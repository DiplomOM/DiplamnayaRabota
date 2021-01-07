package steps;

import baseEntities.TestCaseModel;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.TestCasePage;

public class TestCaseSteps {

    private final WebDriver driver;

    public TestCaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public TestCasePage createTestCase(TestCaseModel testCase) {
        final TestCasePage testCasePage = new TestCasePage(driver, true);
        if (testCase.getTitle() != null) {
            testCasePage.setInputForm(testCase.getTitle());
        }
        if (testCase.getEstimate() != null) {
            testCasePage.setEstimate(testCase.getEstimate());
        }
        if (testCase.getFilePath() != null) {
            //        testCasePage.openPreconditionsForm();
//        testCasePage.uploadFile("C:/Users/user/Downloads/Telegram Desktop/Screenshot_1.png");
//        testCasePage.submitAddButton();
        }
        testCasePage.submitAcceptButton();
        return testCasePage;
    }

}
