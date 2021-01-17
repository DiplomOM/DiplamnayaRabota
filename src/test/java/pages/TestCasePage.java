package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestCasePage extends BasePage {

    private static final String JS_DROP_FILE = "var target = arguments[0]," +
            "    offsetX = arguments[1]," +
            "    offsetY = arguments[2]," +
            "    document = target.ownerDocument || document," +
            "    window = document.defaultView || window;" +
            "" +
            "var input = document.createElement('INPUT');" +
            "input.type = 'file';" +
            "input.style.display = 'none';" +
            "input.onchange = function () {" +
            "  var rect = target.getBoundingClientRect()," +
            "      x = rect.left + (offsetX || (rect.width >> 1))," +
            "      y = rect.top + (offsetY || (rect.height >> 1))," +
            "      dataTransfer = { files: this.files };" +
            "" +
            "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
            "    var evt = document.createEvent('MouseEvent');" +
            "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
            "    evt.dataTransfer = dataTransfer;" +
            "    target.dispatchEvent(evt);" +
            "  });" +
            "" +
            "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
            "};" +
            "document.body.appendChild(input);" +
            "return input;";

    private static String ENDPOINT = "/cases/add/16";

    public static final Integer PRECONDITIONS_UPLOAD_BUTTON_ORDER = 0;


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

    @FindBy(xpath = "//div[contains(text(),'Field Estimate is not in a valid time span format.')]")
    WebElement errorMessage;


    public TestCasePage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(URL + ENDPOINT);
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
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, attachmentDropzone, 0, 0);

        input.sendKeys(path);
        waits.waitUntilRedrawDOM(driver.findElement(By.className("blockUI")));
    }

    public void submitAddButton() {
        addButton.submit();
    }

    public void setEstimate(String estimate) {
        estimateElement.sendKeys(estimate);
    }

    public void submitAcceptButton() {
        acceptButton.submit();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
