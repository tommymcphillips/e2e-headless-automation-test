package test.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.ResultPage;
import page.SearchPage;

public class PerformSearchSteps {

    private WebDriver driver;
    private SearchPage searchPage;

    @Before
    public void setup(){
        ChromeWebDriver chromeWebDriver = ChromeWebDriver.getInstance();
        driver = chromeWebDriver.driver;
        searchPage = new SearchPage(driver);
    }

    @When("I perform a search with {string}, {string} values")
    public void i_perform_a_search_with(String departureDate, String returningDate) {
        searchPage.setDeparting(departureDate);
        searchPage.setReturning(returningDate);
        searchPage.clickSubmitButton();

    }

    @Then("I should see the successful result page")
    public void i_should_see_the_successful_result_page() {
        ResultPage resultPage = new ResultPage(driver);
        resultPage.getResultText();
    }
}
