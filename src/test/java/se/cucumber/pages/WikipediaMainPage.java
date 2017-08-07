package se.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikipediaMainPage {

    private final RemoteWebDriver webDriver;

    public static WikipediaMainPage Open(RemoteWebDriver webDriver) {

        WikipediaMainPage page = new WikipediaMainPage(webDriver);
        page.startMenu();

        return page;
    }

    private WikipediaMainPage(RemoteWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public TopicPage directSearch(String term) {
        webDriver.findElement(By.id("searchInput")).sendKeys(term);
        webDriver.findElement(By.id("searchButton")).submit();


        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        boolean b = wait.until(e -> ((JavascriptExecutor) e).executeScript("return document.readyState").equals("complete"));

        return new TopicPage(webDriver);
    }

    public void startMenu() {
        webDriver.get("https://en.wikipedia.org");

        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        boolean b = wait.until(e -> ((JavascriptExecutor) e).executeScript("return document.readyState").equals("complete"));
    }
}
