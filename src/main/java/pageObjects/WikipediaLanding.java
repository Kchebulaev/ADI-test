package pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * @author Kirill_Chebulaev
 */
@DefaultUrl("https://en.wikipedia.org/wiki/MAIN_PAGE")
public class WikipediaLanding extends PageObject {
    @FindBy(id = "searchInput")
    public WebElementFacade input;

    @FindBy(id = "searchButton")
    public WebElementFacade submit;

}
