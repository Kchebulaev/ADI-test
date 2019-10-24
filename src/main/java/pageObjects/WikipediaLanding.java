package pageObjects;

import lombok.Data;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@Data
@DefaultUrl("https://en.wikipedia.org/wiki/MAIN_PAGE")
public class WikipediaLanding extends PageObject {

    @FindBy(id = "searchInput")
    private WebElementFacade input;

    @FindBy(id = "searchButton")
    private WebElementFacade submit;

}
