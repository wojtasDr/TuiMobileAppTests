package tuimobileapptests.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import tuimobileapptests.pages.DoubleTapPage;

public class DoubleTapPageSteps implements En {

    @Autowired
    DoubleTapPage doubleTapPage;

    public DoubleTapPageSteps() {

        When("I double tab \"Double Tap Me\" button", () -> doubleTapPage.doubleTapDoubleTapMeButton()
        );
    }

}
