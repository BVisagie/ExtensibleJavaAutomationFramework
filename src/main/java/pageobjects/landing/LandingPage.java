package pageobjects.landing;

import base.pojos.SessionProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LandingPage {

    private final SessionProperties testSession;
    private final By supportedLanguagesDropDownSelectXpath = new By.ByXPath("//select[@id='searchLanguage']");
    private final By mainSearchInputXpath = new By.ByXPath("//input[@id='searchInput']");
    private final By mainSearchButtonXpath = new By.ByXPath("//button[@type='submit']");
    private final By englishMainPageLinkXpath = new By.ByXPath("//a[@id='js-link-box-en']");

    public LandingPage(SessionProperties testSession) {
        this.testSession = testSession;
    }

    /**
     * @return the number of languages found within the supported language drop down
     */
    public int getSupportedLanguageCountFromDropDown() {
        Select dropDownSelect = new Select(testSession.driver.findElement(supportedLanguagesDropDownSelectXpath));
        List<WebElement> webElementList = dropDownSelect.getOptions();
        return webElementList.size();
    }

    public LandingPage inputSearchValue(String searchValue) {

        testSession.driver.findElement(mainSearchInputXpath).sendKeys(searchValue);
        return this;
    }

    public LandingPage clickSearch() {

        testSession.driver.findElement(mainSearchButtonXpath).click();
        return this;
    }

    public LandingPage clickEnglishMainPageLink() {
        testSession.driver.findElement(englishMainPageLinkXpath).click();
        return this;
    }
}
