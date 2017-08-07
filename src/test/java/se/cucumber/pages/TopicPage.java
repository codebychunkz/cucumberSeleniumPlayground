package se.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class TopicPage {

    private final WebDriver driver;

    public TopicPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(By.id("firstHeading")).getText();
    }

    public List<String> getContent() {
        return driver.findElement(By.id("toc")).findElements(By.className("toctext"))
                .stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
}
