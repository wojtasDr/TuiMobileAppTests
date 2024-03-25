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

        Then("The {string} color is set", (String expectedColor) ->
                commonValidators.elementContainsText(wheelPickerPage.getCurrentColorLabel(), expectedColor)
        );

        When("^I set spinner color to \"(black|blue|green|red)\"$", (String color) -> wheelPickerPage.setColorOnSpinner(color));
    }

}
