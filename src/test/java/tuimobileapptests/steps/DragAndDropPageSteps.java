package tuimobileapptests.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import tuimobileapptests.pages.DragAndDropPage;
import tuimobileapptests.validators.CommonValidators;

public class DragAndDropPageSteps implements En {

    @Autowired
    DragAndDropPage dragAndDropPage;

    @Autowired
    CommonValidators commonValidators;

    public DragAndDropPageSteps() {

        When("I drag \"Drag Me\" element and drop it to \"Drop here\" drop zone", () -> dragAndDropPage.dragElementToDropZone()
        );

        Then("Following success message is displayed {string}", (String expectedMessage) ->
                commonValidators.elementHasText(dragAndDropPage.getDragAndDropActionSuccessMessageText(), expectedMessage)
        );
    }

}
