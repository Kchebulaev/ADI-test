package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pageObjects.ArticlePage;
import pageObjects.NoResultsPage;
import pageObjects.WikipediaLanding;

public class SearchSteps {
    private WikipediaLanding landingPage;
    private ArticlePage articlePage;
    private NoResultsPage noResultsPage;

    @Step("Type query into input field")
    public void typeAndSubmitQuery(String query) {
        WebElementFacade input = getSearchInput();
        input.clear();
        input.sendKeys(query);
        landingPage.submit.click();
    }

    @Step("Get article title text")
    public String getTitle() {
        return articlePage.title.getText();
    }

    @Step("Verify error message is displayed and has the right text")
    public void verifyErrorMessage(String errorText) {
        Assertions.assertThat(noResultsPage.results.isDisplayed());
        Assertions.assertThat(noResultsPage.results.getText().contains(errorText));
    }

    @Step("Get article content")
    public WebElementFacade getContent() {
        return articlePage.content;
    }

    @Step("Get search input field")
    public WebElementFacade getSearchInput() {
        return landingPage.input;
    }

    @Step("Get new article creation link")
    public WebElementFacade getNewArticleLink() {
        return noResultsPage.createLink;
    }

}