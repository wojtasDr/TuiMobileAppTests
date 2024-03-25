package tuimobileapptests.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import tuimobileapptests.pages.SamplesListPage;

public class SamplesListPageSteps implements En {

    @Autowired
    SamplesListPage samplesListPage;

    public SamplesListPageSteps() {

        When("^I go to \"(carousel|double tap|drag and drop|long press|native|photo|slider|vertical swipe|web|wheel picker)\" view$", (String vieName) ->
                samplesListPage.goToView(vieName)
        );
    }

}
