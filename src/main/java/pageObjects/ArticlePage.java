package pageObjects;

import lombok.Data;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://en.wikipedia.org")
@NamedUrls(
        {
                @NamedUrl(name = "open.article", url = "/wiki/{1}")
        }
)
@Data
public class ArticlePage extends PageObject {

    @FindBy(tagName = "h1")
    private WebElementFacade articleTitle;

    @FindBy(id = "mw-content-text")
    private WebElementFacade content;

    @WhenPageOpens
    public void waitUntilTitleAppears() {
        element(getArticleTitle()).waitUntilVisible();
    }

}
