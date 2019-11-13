package site.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultPage {

    private WebDriver driver;


    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]")
    private WebElement resultContent;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2")
    private WebElement searchResultTitle;
    @FindAll(@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/p[not(child::a)]"))
    private List<WebElement> searchResultContents;
    @FindBy(how = How.XPATH, using = "//*[@class='promo_code']\n")
    private WebElement promotionResultSearchMessage;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/h1/a")
    private WebElement logo;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Back")
    private WebElement backButton;

    private final static int TWO_SECONDS = 2000;

    public ResultPage(WebDriver driver){
        this.driver = driver;
        //Initialise Elements

        PageFactory.initElements(driver, this);
    }

    public String getSearchResultContent() {
        List<String> searchResultContent = new ArrayList<>();
        for (WebElement element : searchResultContents){
            searchResultContent.add(element.getText());
        }

        return String.join(" ", searchResultContent);
    }

    public String getPromotionResultSearchMessage() {
        return promotionResultSearchMessage.getText();
    }

    public void clickBackButton() throws InterruptedException {
        waitRender();
        backButton.click();
    }

    public void clickLogoMars() throws InterruptedException {
        waitRender();
        logo.click();
    }

    private void waitRender() throws InterruptedException {
        Thread.sleep(TWO_SECONDS);
    }




}



