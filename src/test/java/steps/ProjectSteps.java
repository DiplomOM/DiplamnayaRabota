package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;

public class ProjectSteps {

    private final WebDriver driver;

    public ProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public AddProjectPage createProject(String title) {
        final AddProjectPage page = new AddProjectPage(driver, true);
        page.setInputField(title);
        page.clickAcceptButton();
        return page;
    }
}
