package stepdefenitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.springframework.util.StringUtils;
import steps.NavigationSteps;
import steps.SearchSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchDefinitionStep {

    @Steps
    SearchSteps searchSteps;

    @Steps
    NavigationSteps navigation;

    @Given("I am on the Wikipedia landing page")
    public void open() {
        navigation.openWiki();
    }

    @When("^I search for (.*)$")
    public void typeQuery(String query) {
        searchSteps.typeAndSubmitQuery(query);
    }

    @Then("^I get article with title (.*)$")
    public void verifyTitle(String query) {
        assertThat((searchSteps.getTitle()).equals(query));
    }

    @Then("^I get error message(.*)$")
    public void checkErrorMessage(String errorMessage) {
        searchSteps.verifyErrorMessage(errorMessage);
    }

    @And("^I see content of the page$")
    public void iSeeContentOfThePage() {
        assertThat(searchSteps.getContent().isDisplayed());
    }

    @And("^I see link for page creation$")
    public void iSeeLinkForPageCreation() {
        assertThat(searchSteps.getNewArticleLink().isDisplayed());
    }

    @Then("^I see search input$")
    public void iSeeSearchInput() {
        assertThat(searchSteps.getSearchInput().isDisplayed());
    }

    @And("^Search input in empty$")
    public void searchInputInEmpty() {
        assertThat(StringUtils.isEmpty(searchSteps.getSearchInput().getValue()));
    }

}
