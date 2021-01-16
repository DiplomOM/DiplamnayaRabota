package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddProjectPage extends BasePage {

    private static String ENDPOINT = "/admin/projects/add/1";
    private static String ENDPOINT2 = "/admin/projects/overview";

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }


    @FindBy(id = "name")
    public WebElement inputField;

    @FindBy(id = "accept")
    public WebElement acceptButton;

    @FindBy(xpath = "//*[@class='content-inner goals-clear']//child::div[@class='message message-error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//button[@id='accept']")
    public WebElement addProjectButton;

    @FindBy(xpath = "//div[@class='message message-error']")
    public WebElement fieldNameErrorMessage;

    @FindBy(xpath = "//a[@id='inProgressLink']")
    public WebElement workingOnBtn;

    @FindBy(xpath = "//div[@id='helpDropdown']")
    public WebElement popUpMsg;

    @FindBy(xpath = "//div[@class='message message-success']")
    public WebElement successMsg;

    @FindBy(xpath = "//div[@class='icon-small-delete']")
    public WebElement deleteBtn;

    @FindBy(xpath = "//*[@class='icon-progress-inline']/following::input")
    public WebElement checkboxBtn;

    @FindBy(xpath = "//*[@class='icon-progress-inline']/following::a[1]")
    public WebElement okBtn;

    @Override
    protected void openPage() {
        driver.get(URL + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return true;
    }


    public void openProjectPage() {
        driver.get(URL + ENDPOINT2);
    }

    public void setInputField(String text) {
        inputField.sendKeys(text);
    }

    public void clickAcceptButton() {
        acceptButton.submit();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void clickOnAddProjectButton() {
        addProjectButton.submit();
    }

    public String getFieldNameErrorMsg() {
        return fieldNameErrorMessage.getText();
    }

    public void clickOnWorkingOnBtn() {
        workingOnBtn.click();
    }

    public void getPopUpMsg() {
        popUpMsg.isDisplayed();
    }

    public String getSuccessMsg() {
        return successMsg.getText();
    }

    public WebElement clickDeleteBtn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return deleteBtn;
    }

    public void clickCheckBoxBtn() {
        checkboxBtn.click();
    }

    public void clickOkBtn() {
        okBtn.click();
    }
}
