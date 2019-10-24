package pageObjects;

import lombok.Data;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@Data
public class NoResultsPage extends PageObject {

    @FindBy(className = "searchresults")
    private WebElementFacade results;

    @FindBy(className = "mw-search-createlink")
    private WebElementFacade createLink;

}
