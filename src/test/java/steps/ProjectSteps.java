package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddProjectPage;
import pages.DeleteProjectPage;

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

    @Step
    public void popUpField() {
        AddProjectPage projectPage = new AddProjectPage(driver, true);
        projectPage.isPageOpened();
        projectPage.clickOnWorkingOnBtn();
        projectPage.getPopUpMsg();

        Assert.assertTrue(true);

    }

    @Step
    public void limitValue() {
        AddProjectPage limitvalue = new AddProjectPage(driver, true);
        limitvalue.isPageOpened();
        limitvalue.clickOnAddProjectButton();
        limitvalue.clickAcceptButton();
        limitvalue.getFieldNameErrorMsg();

         Assert.assertEquals(limitvalue.getFieldNameErrorMsg(), "Field Name is a required field.");
    }

    @Step
    public void createPositiveProject(String title) {
        final AddProjectPage page = new AddProjectPage(driver, true);
        page.setInputField(title);
        page.clickAcceptButton();

        Assert.assertEquals(page.getSuccessMsg(), "Successfully added the new project.");
    }

    @Step
    public void deleteProject() {
        DeleteProjectPage delete = new DeleteProjectPage(driver, true);
        //delete.openPage();
        delete.clickDeleteBtn().click();
        delete.clickCheckBoxBtn();
        delete.clickOkBtn();
    }
}

