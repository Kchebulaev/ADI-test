package pageObjects;

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
                @NamedUrl(name = "open.article", url = "/issues/{1}")
        }
)
public class ArticlePage extends PageObject {
    @FindBy(tagName = "h1")
    public WebElementFacade title;

    @FindBy(id = "mw-content-text")
    public WebElementFacade content;

    @WhenPageOpens
    public void waitUntilTitleAppears() {
        element(title).waitUntilVisible();
    }

}
