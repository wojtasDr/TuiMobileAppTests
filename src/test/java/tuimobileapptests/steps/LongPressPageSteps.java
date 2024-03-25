package tuimobileapptests.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import tuimobileapptests.pages.LongPressPage;

public class LongPressPageSteps implements En {

    @Autowired
    LongPressPage longPressPage;

    public LongPressPageSteps() {

        When("I press long \"Long Press Me\" button", () -> longPressPage.pressLongLongPressMeButton()
        );
    }

}
