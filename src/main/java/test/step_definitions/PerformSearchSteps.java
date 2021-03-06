package test.step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import site.pages.ResultPage;
import site.pages.SearchPage;
import site.SiteContext;

public class PerformSearchSteps {

    private SearchPage searchPage;
    private ResultPage resultPage;
    private SiteContext siteContext;

    @Before
    public void getContext(){
        siteContext = SiteContext.getInstance();
        searchPage = siteContext.getSearchPage();
    }

    @When("I perform a search with {string}, {string} values")
    public void i_perform_a_search_with(String departureDate, String returningDate) {
        searchPage.setDeparting(departureDate);
        searchPage.setReturning(returningDate);
        searchPage.clickSubmitButton();

    }

    @Then("I should see the result page with the {string}")
    public void i_should_see_the_successful_result_page(String resultMessage) {
        resultPage = siteContext.getResultPage();
        String formattedResult = resultPage.getSearchResultContent();
        Assert.assertEquals(formattedResult, resultMessage);
    }
}
