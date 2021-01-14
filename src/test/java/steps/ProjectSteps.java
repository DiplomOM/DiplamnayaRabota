package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddProjectPage;

public class ProjectSteps {

    private final WebDriver driver;

    public ProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void createProject(String title) {
        final AddProjectPage page = new AddProjectPage(driver, true);
        page.setInputField(title);
        page.clickAcceptButton();

        Assert.assertEquals(page.getErrorMessage(), "Field Name is a required field.");
    }
}
