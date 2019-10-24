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
        assertThat((searchSteps.getTitle()).equals(query)).as("Title should be '%s', but actual is '%s'",
                query, searchSteps.getTitle()).isTrue();
    }

    @Then("^I get error message(.*)$")
    public void checkErrorMessage(String errorMessage) {
        assertThat(searchSteps.getNoResultsElement().isDisplayed()).as("Error message is displayed").isTrue();
        assertThat(searchSteps.getNoResultsElement().getTextContent().contains(errorMessage))
                .as("Error message contains %s", errorMessage).isTrue();
    }

    @And("^I see table of content of the page$")
    public void iSeeTableOfContentOfThePage() {
        assertThat(searchSteps.getTableOfContent().isDisplayed()).as("Content is displayed").isTrue();
    }

    @And("^I see link for page creation$")
    public void iSeeLinkForPageCreation() {
        assertThat(searchSteps.getNewArticleLink().isDisplayed()).as("Create new article link is displayed")
                .isTrue();
    }

    @Then("^I see search input$")
    public void iSeeSearchInput() {
        assertThat(searchSteps.getSearchInput().isDisplayed()).as("Search input form is displayed").isTrue();
    }

    @And("^Search input in empty$")
    public void searchInputIsEmpty() {
        assertThat(StringUtils.isEmpty(searchSteps.getSearchInput().getValue()))
                .as("Serach input field should be empty, but actual contains value '%s'",
                        searchSteps.getSearchInput().getValue()).isTrue();
    }

}
