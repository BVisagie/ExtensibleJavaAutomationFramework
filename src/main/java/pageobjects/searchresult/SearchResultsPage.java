package pageobjects.searchresult;

import base.pojos.SessionProperties;
import org.openqa.selenium.By;

public class SearchResultsPage {

    private final SessionProperties testSession;

    public SearchResultsPage(SessionProperties testSession) {
        this.testSession = testSession;
    }

    public boolean GivenSearchValuePresentAndEnabledInResultPage(String searchTerm) {
        By linkListItem = new By.ByXPath("//div[@id='mw-content-text']/div/ul/li/a[contains(text(),'"+searchTerm+"')]");

        return testSession.driver.findElement(linkListItem).isEnabled();
    }
}
