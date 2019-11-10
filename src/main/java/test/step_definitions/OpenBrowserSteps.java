package test.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.SearchPage;

public class OpenBrowserSteps {

    private WebDriver driver;
    private SearchPage searchPage;

    @Before
    public void setup(){
        ChromeWebDriver chromeWebDriver = ChromeWebDriver.getInstance();
        driver = chromeWebDriver.driver;
        searchPage = new SearchPage(driver);
    }

    @After
    public void close() {
        //driver.close();
        ChromeWebDriver.killInstance();
    }

    @When("I navigate to search Marsair page")
    public void i_navigate_to_search_marsair_page() throws Exception {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.getSeachPage();
    }
}
