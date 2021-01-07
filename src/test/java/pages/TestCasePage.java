package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestCasePage extends BasePage {

    private static String End_Point = "/cases/add/1";

    public static final Integer PRECONDITIONS_UPLOAD_BUTTON_ORDER = 0;
    public static final Integer STEPS_UPLOAD_BUTTON_ORDER = 1;
    public static final Integer EXPECTED_RESULT_UPLOAD_BUTTON_ORDER = 2;


    @FindBy(id = "title")
    WebElement inputForm;

    @FindAll(@FindBy(xpath = "//*[@class='icon-markdown-image']/ancestor::a"))
    List<WebElement> uploadButtons;

    @FindBy(id = "attachmentDropzone")
    WebElement attachmentDropzone;

    @FindBy(id = "attachmentSubmit")
    WebElement addButton;

    @FindBy(id = "estimate")
    private WebElement estimateElement;

    @FindBy(id = "accept")
    WebElement acceptButton;

    @FindBy(xpath ="//div[contains(text(),'Field Estimate is not in a valid time span format.')]")
    public WebElement errorMessage;


    public TestCasePage(WebDriver driver, boolean openPageByUrl) {

        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {

        driver.get(URL + End_Point);
    }

    @Override
    public boolean isPageOpened() {

        return inputForm.isDisplayed();
    }

    public void setInputForm(String title) {

        this.inputForm.sendKeys(title);
    }

    public void openPreconditionsForm() {

        uploadButtons.get(PRECONDITIONS_UPLOAD_BUTTON_ORDER).click();
    }

    public void uploadFile(String path) {
//        attachmentDropzone.click();
//        attachmentDropzone.sendKeys(Keys.ALT,Keys.);

    }

    public void submitAddButton(){

        addButton.submit();
    }

    public void setEstimate(String estimate) {
        estimateElement.sendKeys(estimate);
    }

    public void submitAcceptButton(){

        acceptButton.submit();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}

