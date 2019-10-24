package steps;

import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pageObjects.ArticlePage;
import pageObjects.NoResultsPage;
import pageObjects.WikipediaLanding;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
public class SearchSteps {

    private WikipediaLanding landingPage;
    private ArticlePage articlePage;
    private NoResultsPage noResultsPage;

    @Step("Type query into input field")
    public void typeAndSubmitQuery(String query) {
        WebElementFacade input = getSearchInput();
        input.clear();
        input.sendKeys(query);
        landingPage.getSubmit().click();
    }

    @Step("Get article title text")
    public String getTitle() {
        return articlePage.getArticleTitle().getText();
    }

    @Step("Get no results element")
    public WebElementFacade getNoResultsElement() {
        return noResultsPage.getResults();
    }

    @Step("Get article content")
    public WebElementFacade getContent() {
        return articlePage.getContent();
    }

    @Step("Get search input field")
    public WebElementFacade getSearchInput() {
        return landingPage.getInput();
    }

    @Step("Get new article creation link")
    public WebElementFacade getNewArticleLink() {
        return noResultsPage.getCreateLink();
    }

}
