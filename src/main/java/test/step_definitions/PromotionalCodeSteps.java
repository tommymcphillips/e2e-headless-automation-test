package test.step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import site.pages.ResultPage;
import site.pages.SearchPage;
import site.SiteContext;

public class PromotionalCodeSteps {

    private SearchPage searchPage;
    private ResultPage resultPage;
    private SiteContext siteContext;

    @Before
    public void getContext(){
        siteContext = SiteContext.getInstance();
        searchPage = siteContext.getSearchPage();
    }

    @When("I perform a search with {string}, {string}, and {string} values")
    public void i_perform_a_search_with_promotional_code(String departureDate, String returningDate, String promotionCode) {
        searchPage.setDeparting(departureDate);
        searchPage.setReturning(returningDate);
        searchPage.setPromotionalCode(promotionCode);
        searchPage.clickSubmitButton();

    }

    @Then("I should see the promotion result page with the {string}")
    public void i_should_see_the_promotion_result_page(String resultMessage) {
        resultPage = siteContext.getResultPage();
        String formattedResult = resultPage.getPromotionResultSearchMessage();
        Assert.assertEquals(formattedResult, resultMessage);
    }
}
