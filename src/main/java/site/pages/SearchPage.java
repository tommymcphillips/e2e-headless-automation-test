package site.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;

    private WebElement departing;
    private WebElement returning;
    private WebElement promotional_code;
    @FindBy(how = How.XPATH, using = "//dl[4]/dd/input")
    private WebElement submitButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]")
    private WebElement formContent;

    private final static int TWO_SECONDS = 2000;

    public SearchPage(WebDriver driver) {
        this.driver = driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void getSeachPage() {
        driver.get("https://marsair.thoughtworks-labs.net/thomasmcphillips");
    }

    public void setDeparting(String month) {
        departing.sendKeys(month);
    }

    public void setReturning(String month) {
        returning.sendKeys(month);
    }

    public void setPromotionalCode(String code) {
        promotional_code.sendKeys(code);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public Select getDeparting() {
        return new Select (departing);
    }

    public Select getReturning() {
        return new Select(returning);
    }


    public WebElement getFormContent() {
        return formContent;
    }

    public String getTitle() throws InterruptedException {
        waitRender();
        return driver.getTitle();
    }

    private void waitRender() throws InterruptedException {
        Thread.sleep(TWO_SECONDS);
    }

}



