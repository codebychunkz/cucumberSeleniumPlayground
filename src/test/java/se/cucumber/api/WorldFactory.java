package se.cucumber.api;

import org.openqa.selenium.remote.RemoteWebDriver;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

public class WorldFactory {

    @Inject
    @Named("phantomJS")
    RemoteWebDriver driver;

    @Produces
    @Named("myWorld")
    @ApplicationScoped
    public World newWorld() {
        return new World(driver);
    }

}
