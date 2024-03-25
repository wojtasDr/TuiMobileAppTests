package tuimobileapptests.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import tuimobileapptests.pages.CommonPage;
import tuimobileapptests.utils.ActionsUtils;
import tuimobileapptests.utils.WaitUtils;
import tuimobileapptests.validators.CommonValidators;

public class CommonSteps implements En {

    @Autowired
    CommonValidators commonValidators;

    @Autowired
    CommonPage commonPage;

    @Autowired
    WaitUtils waitUtils;

    @Autowired
    ActionsUtils actionsUtils;

    public CommonSteps() {

        Given("{string} page is displayed", (String expectedPageTitle) -> {
                    Thread.sleep(1000);
                    waitUtils.waitUntilElementHasText(30, commonPage.getPageTitle(), expectedPageTitle);
                }
        );

        When("I log out", () -> {
                    commonPage.clickBackButton();
                    Thread.sleep(500);
                    commonPage.clickBackButton();
                }
        );

        Then("I can vertically swipe down to element with text {string}", (String elementText) -> actionsUtils.scrollToElement(elementText));

        When("I click OK to close alert", () -> commonPage.closeSuccessAlert());

        Then("Following alert message is displayed {string}", (String expectedMessage) ->
                commonValidators.elementHasText(commonPage.getAlertMessage(), expectedMessage)
        );
    }
}
