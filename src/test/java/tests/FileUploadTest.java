package tests;

import baseEntities.BaseTest;
import baseEntities.TestCaseModel;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.TestCaseSteps;

import java.io.File;

public class FileUploadTest extends BaseTest {

    @Test(priority = 1)
    public void fileUploadTest() {
        new LoginSteps(driver).login(readProperties.getUserName(), readProperties.getPassword());

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("Screenshot_1.png").getFile());

        final TestCaseSteps testCaseSteps = new TestCaseSteps(driver);
        testCaseSteps.uploadFile(TestCaseModel.builder()
                .title(readProperties.getTitle())
                .filePath(file.getAbsolutePath())
                .build()
        );
    }

}
