package se.cucumber.api;

import org.openqa.selenium.remote.RemoteWebDriver;

public class World {

    private RemoteWebDriver driver;

    public Object currentPage;

    public World() {
    }

    public World(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }

    public <T> T getCurrentPage() {
        return (T) currentPage;
    }

    public void setCurrentPage(Object currentPage) {
        this.currentPage = currentPage;
    }
}
