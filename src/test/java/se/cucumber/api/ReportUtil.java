package se.cucumber.api;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportUtil {

    public static void addScreenshot(Scenario scenario, TakesScreenshot screenShotter) {
        try {
            if (scenario.isFailed()) {
                byte[] pic = ((TakesScreenshot) screenShotter).getScreenshotAs(OutputType.BYTES);
                scenario.embed(pic, "image/png");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
