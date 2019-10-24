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
        assertThat((searchSteps.getTitle()).equals(query)).isTrue();
    }

    @Then("^I get error message(.*)$")
    public void checkErrorMessage(String errorMessage) {
        assertThat(searchSteps.getNoResultsElement().isDisplayed()).isTrue();
        assertThat(searchSteps.getNoResultsElement().getTextContent().contains(errorMessage)).isTrue();
    }

    @And("^I see content of the page$")
    public void iSeeContentOfThePage() {
        assertThat(searchSteps.getContent().isDisplayed()).isTrue();
    }

    @And("^I see link for page creation$")
    public void iSeeLinkForPageCreation() {
        assertThat(searchSteps.getNewArticleLink().isDisplayed()).isTrue();
    }

    @Then("^I see search input$")
    public void iSeeSearchInput() {
        assertThat(searchSteps.getSearchInput().isDisplayed()).isTrue();
    }

    @And("^Search input in empty$")
    public void searchInputIsEmpty() {
        assertThat(StringUtils.isEmpty(searchSteps.getSearchInput().getValue())).isTrue();
    }

}
