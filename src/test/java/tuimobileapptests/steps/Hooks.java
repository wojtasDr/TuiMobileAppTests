package tuimobileapptests.steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import tuimobileapptests.pages.CommonPage;
import tuimobileapptests.utils.WaitUtils;

import static tuimobileapptests.datastructure.PageTitles.LOGIN_PAGE;
import static tuimobileapptests.datastructure.PageTitles.SAMPLES_LIST_PAGE;

public class Hooks {
    private final AppiumDriver driver;

    @Autowired
    CommonPage commonPage;

    @Autowired
    WaitUtils waitUtils;

    public Hooks(AppiumDriver driver) {
        this.driver = driver;
    }

    @After(order = 2)
    public void takeScreenShotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "snapshot");
        }
    }

    @After(order = 1)
    public void resetApp() throws InterruptedException {
        String actualPage = commonPage.getPageTitle().getText().trim();

        if (actualPage.equalsIgnoreCase(SAMPLES_LIST_PAGE.getPageTitle())) {
            commonPage.clickBackButton();
        } else if (!actualPage.equalsIgnoreCase(LOGIN_PAGE.getPageTitle())) {
            commonPage.clickBackButton();
            Thread.sleep(500);
            commonPage.clickBackButton();
        }

        waitUtils.waitUntilElementHasText(10, commonPage.getPageTitle(), LOGIN_PAGE.getPageTitle());
    }
}
