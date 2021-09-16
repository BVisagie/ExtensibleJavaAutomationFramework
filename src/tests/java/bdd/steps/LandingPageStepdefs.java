package bdd.steps;

import base.Session;
import base.pojos.SessionProperties;
import helpers.Utilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.*;


public class LandingPageStepdefs {

    private SessionProperties testSession;
    private String actualPageTitle;

    @Given("I navigate to the landing page of the application")
    public void iNavigateToTheLandingPageOfTheApplication() {
        testSession = new Session().setupTestSession(true);
        testSession.driver.navigate().to(testSession.urlUnderTest);
    }

    @And("I retrieve the landing page title")
    public void iRetrieveTheLandingPageTitle() {
        actualPageTitle = testSession.driver.getTitle();
    }

    @Then("The title should be equal to {string}")
    public void theTitleShouldBeEqualTo(String expectedPageTitle) {
        Assertions.assertEquals(actualPageTitle,expectedPageTitle);
        new Utilities().tearDown(testSession);
    }
}
