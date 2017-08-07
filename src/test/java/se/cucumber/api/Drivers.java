package se.cucumber.api;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Drivers {

    public static PhantomJSDriver newPhantomJSDriver() {
        String pathToBinary = "./src/test/resources/phantomjs.exe";

        DesiredCapabilities caps = new DesiredCapabilities();

        List<String> cliArgsCap = new ArrayList<String>();
        cliArgsCap.add("--web-security=false");
        cliArgsCap.add("--ssl-protocol=any");
        cliArgsCap.add("--ignore-ssl-errors=true");

        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability("localToRemoteUrlAccessEnabled", true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, new String[]{"--logLevel=2"});
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                pathToBinary
        );

        PhantomJSDriver driver = new PhantomJSDriver(caps);
        driver.manage().window().setSize(new Dimension(1200, 800));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        return driver;
    }

}
