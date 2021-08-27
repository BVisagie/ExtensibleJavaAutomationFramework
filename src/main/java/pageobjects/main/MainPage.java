package pageobjects.main;

import base.pojos.SessionProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(id = "From_today's_featured_article")
    WebElement fromTodaysFeaturedArticleSectionXpath;
    @FindBy(id = "In_the_news")
    WebElement inTheNewsSectionXpath;
    @FindBy(id = "On_this_day")
    WebElement fromThisDaySectionXpath;
    @FindBy(id = "Did_you_know_...")
    WebElement didYouKnowSectionXpath;
    @FindBy(id = "Today's_featured_picture")
    WebElement todaysFeaturedPictureSectionXpath;

    public MainPage(SessionProperties testSession) {
        PageFactory.initElements(testSession.driver, this);
    }

    public boolean verifyMainPageElementsExist() {

        String fromTodaysFeaturedArticleSectionText = fromTodaysFeaturedArticleSectionXpath.getText();
        String inTheNewsSectionText = inTheNewsSectionXpath.getText();
        String fromThisDaySectionText = fromThisDaySectionXpath.getText();
        String didYouKnowSectionText = didYouKnowSectionXpath.getText();
        String todaysFeaturedPictureSectionText = todaysFeaturedPictureSectionXpath.getText();

        String expectedFromTodaysFeaturedArticleSectionText = "From today's featured article";
        String expectedInTheNewsSectionText = "In the news";
        String expectedFromThisDaySectionText = "On this day";
        String expectedDidYouKnowSectionText = "Did you know ...";
        String expectedTodaysFeaturedPictureSectionText = "Today's featured picture";

        return fromTodaysFeaturedArticleSectionText.equals(expectedFromTodaysFeaturedArticleSectionText) && inTheNewsSectionText.equals(expectedInTheNewsSectionText) &&
                fromThisDaySectionText.equals(expectedFromThisDaySectionText) && didYouKnowSectionText.equals(expectedDidYouKnowSectionText) && todaysFeaturedPictureSectionText.equals(expectedTodaysFeaturedPictureSectionText);

    }
}
