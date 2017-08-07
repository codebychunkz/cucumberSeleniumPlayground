package se.cucumber.api;

import org.openqa.selenium.remote.RemoteWebDriver;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class DriverFactory {

    @Produces
    @Named("phantomJS")
    @ApplicationScoped
    public RemoteWebDriver newDriver() {
        return Drivers.newPhantomJSDriver();
    }

    public void close(@Disposes @Named("phantomJS") RemoteWebDriver driver) {
        driver.quit();
    }
}
