package pageobjects.main;

import base.pojos.SessionProperties;
import org.openqa.selenium.By;

public class MainPage {

    private final SessionProperties testSession;
    private final By fromTodaysFeaturedArticleSectionXpath = new By.ById("From_today's_featured_article");
    private final By inTheNewsSectionXpath = new By.ById("In_the_news");
    private final By fromThisDaySectionXpath = new By.ById("On_this_day");
    private final By didYouKnowSectionXpath = new By.ById("Did_you_know_...");
    private final By todaysFeaturedPictureSectionXpath = new By.ById("Today's_featured_picture");


    public MainPage(SessionProperties testSession) {
        this.testSession = testSession;
    }

    public boolean verifyMainPageElementsExist() {

        String fromTodaysFeaturedArticleSectionText = testSession.driver.findElement(fromTodaysFeaturedArticleSectionXpath).getText();
        String inTheNewsSectionText = testSession.driver.findElement(inTheNewsSectionXpath).getText();
        String fromThisDaySectionText = testSession.driver.findElement(fromThisDaySectionXpath).getText();
        String didYouKnowSectionText = testSession.driver.findElement(didYouKnowSectionXpath).getText();
        String todaysFeaturedPictureSectionText = testSession.driver.findElement(todaysFeaturedPictureSectionXpath).getText();

        String expectedFromTodaysFeaturedArticleSectionText = "From today's featured article";
        String expectedInTheNewsSectionText = "In the news";
        String expectedFromThisDaySectionText = "On this day";
        String expectedDidYouKnowSectionText = "Did you know ...";
        String expectedTodaysFeaturedPictureSectionText = "Today's featured picture";

        return fromTodaysFeaturedArticleSectionText.equals(expectedFromTodaysFeaturedArticleSectionText) && inTheNewsSectionText.equals(expectedInTheNewsSectionText) &&
                fromThisDaySectionText.equals(expectedFromThisDaySectionText) && didYouKnowSectionText.equals(expectedDidYouKnowSectionText) && todaysFeaturedPictureSectionText.equals(expectedTodaysFeaturedPictureSectionText);

    }
}
