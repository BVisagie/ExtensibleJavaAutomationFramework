package pageobjects.landing;

import base.pojos.SessionProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LandingPage {

    @FindBy(xpath = "//select[@id='searchLanguage']")
    WebElement supportedLanguagesDropDownSelectXpath;
    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement mainSearchInputXpath;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement mainSearchButtonXpath;
    @FindBy(xpath = "//a[@id='js-link-box-en']")
    WebElement englishMainPageLinkXpath;

    public LandingPage(SessionProperties testSession) {
        PageFactory.initElements(testSession.driver, this);
    }

    /**
     * @return the number of languages found within the supported language drop down
     */
    public int getSupportedLanguageCountFromDropDown() {
        Select dropDownSelect = new Select(supportedLanguagesDropDownSelectXpath);
        List<WebElement> webElementList = dropDownSelect.getOptions();
        return webElementList.size();
    }

    public LandingPage inputSearchValue(String searchValue) {

        mainSearchInputXpath.sendKeys(searchValue);
        return this;
    }

    public LandingPage clickSearch() {

        mainSearchButtonXpath.click();
        return this;
    }

    public LandingPage clickEnglishMainPageLink() {
        englishMainPageLinkXpath.click();
        return this;
    }
}
