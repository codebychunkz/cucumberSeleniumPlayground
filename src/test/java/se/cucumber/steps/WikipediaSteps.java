package se.cucumber.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import se.cucumber.api.World;
import se.cucumber.pages.TopicPage;
import se.cucumber.pages.WikipediaMainPage;

import javax.inject.Inject;
import javax.inject.Named;

public class WikipediaSteps {

    @Inject
    @Named("myWorld")
    private World world;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown(Scenario scenario) {
        //ReportUtil.addScreenshot(scenario, (TakesScreenshot) driver);
    }

    @Given("I navigate to Wikipedia")
    public void i_navigate_to_Wikipedia() {
        world.setCurrentPage(WikipediaMainPage.Open(world.getDriver()));
    }

    @When("I search for the following term (.*)")
    public void i_search_for_the_following_terms(String term) {
        WikipediaMainPage page = world.getCurrentPage();
        world.setCurrentPage(page.directSearch(term));
    }

    @Then("the headline should be (.*)")
    public void the_headline_should_be(String headline) {
        TopicPage page = world.getCurrentPage();
        Assert.assertEquals(headline, page.getTitle());
    }

    @Then("^the topics should contain (.*)")
    public void the_topics_should_contain_a(String topic) throws Throwable {
        TopicPage page = world.getCurrentPage();
        Assert.assertTrue(page.getContent().contains(topic));
    }

}
