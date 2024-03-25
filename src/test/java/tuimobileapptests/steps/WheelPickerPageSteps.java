package tuimobileapptests.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import tuimobileapptests.pages.WheelPickerPage;
import tuimobileapptests.validators.CommonValidators;

public class WheelPickerPageSteps implements En {

    @Autowired
    WheelPickerPage wheelPickerPage;

    @Autowired
    CommonValidators commonValidators;

    public WheelPickerPageSteps() {

        Then("Following color is set {string}", (String expectedColor) ->
                commonValidators.elementContainsText(wheelPickerPage.getCurrentColorLabel(), expectedColor)
        );

        When("I set following spinner color {string}", (String color) -> wheelPickerPage.setColorOnSpinner(color));
    }

}
