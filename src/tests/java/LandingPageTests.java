import base.Session;
import base.pojos.SessionProperties;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.landing.LandingPage;
import pageobjects.searchresult.SearchResultsPage;

public class LandingPageTests {

    private SessionProperties testSession;

    @BeforeClass
    public void setUp() {
        testSession = new Session().setupTestSession(true);
    }

    @AfterClass
    public void tearDown() {
        testSession.driver.quit();
    }

    @Test(testName = "Landing Page Title Test")
    public void landingPageTitleTest() {

        testSession.driver.navigate().to(testSession.urlUnderTest);

        String expectedPageTitle = "Wikipedia";
        String actualPageTitle = testSession.driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
    }

    @Test(testName = "Landing Page Supported Languages Test")
    public void landingPageSupportedLanguagesTest() {

        testSession.driver.navigate().to(testSession.urlUnderTest);

        int expectedSupportedLanguageCount = 70;
        int actualSupportedLanguageCount = new LandingPage(testSession).getSupportedLanguageCountFromDropDown();
        Assert.assertEquals(actualSupportedLanguageCount,expectedSupportedLanguageCount);
    }

    @Test(testName = "Landing Page Basic Search Test")
    public void landingPageBasicSearchTest() {

        testSession.driver.navigate().to(testSession.urlUnderTest);

        new LandingPage(testSession).inputSearchValue("Tesla").clickSearch();

        String expectedPageTitle = "Tesla - Wikipedia";
        String actualPageTitle = testSession.driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);

        boolean valueFoundInResultsPage = new SearchResultsPage(testSession).GivenSearchValuePresentAndEnabledInResultPage("Tesla, Inc.");
        Assert.assertTrue(valueFoundInResultsPage);
    }
}
