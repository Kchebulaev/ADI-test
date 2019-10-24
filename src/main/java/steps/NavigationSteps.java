package steps;

import net.thucydides.core.annotations.Step;
import pageObjects.WikipediaLanding;

public class NavigationSteps {

    WikipediaLanding landing;

    @Step("Navigate to Wikipedia")
    public void openWiki() {
        landing.open();
    }

}
