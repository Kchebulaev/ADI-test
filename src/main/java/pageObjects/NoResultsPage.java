package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class NoResultsPage extends PageObject {
    @FindBy(className = "searchresults")
    public WebElementFacade results;

    @FindBy(className = "mw-search-createlink")
    public WebElementFacade createLink;


}
