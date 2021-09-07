import base.Session;
import base.pojos.SessionProperties;
import org.junit.jupiter.api.*;
import pageobjects.landing.LandingPage;
import pageobjects.searchresult.SearchResultsPage;

public class LandingPageTests {

    private SessionProperties testSession;

    @BeforeEach
    public void setUp() {
        testSession = new Session().setupTestSession(true);
    }

    @AfterEach
    public void tearDown() {
        testSession.driver.quit();
    }

    @Test
    @DisplayName("Landing Page Title Test")
    public void landingPageTitleTest() {

        testSession.driver.navigate().to(testSession.urlUnderTest);

        String expectedPageTitle = "Wikipedia";
        String actualPageTitle = testSession.driver.getTitle();
        Assertions.assertEquals(actualPageTitle,expectedPageTitle);
    }

    @Test
    @DisplayName("Landing Page Supported Languages Test")
    public void landingPageSupportedLanguagesTest() {

        testSession.driver.navigate().to(testSession.urlUnderTest);

        int expectedSupportedLanguageCount = 70;
        int actualSupportedLanguageCount = new LandingPage(testSession).getSupportedLanguageCountFromDropDown();
        Assertions.assertEquals(actualSupportedLanguageCount,expectedSupportedLanguageCount);
    }

    @Test
    @DisplayName("Landing Page Basic Search Test")
    public void landingPageBasicSearchTest() {

        testSession.driver.navigate().to(testSession.urlUnderTest);

        new LandingPage(testSession).inputSearchValue("Tesla").clickSearch();

        String expectedPageTitle = "Tesla - Wikipedia";
        String actualPageTitle = testSession.driver.getTitle();
        Assertions.assertEquals(actualPageTitle,expectedPageTitle);

        boolean valueFoundInResultsPage = new SearchResultsPage(testSession).GivenSearchValuePresentAndEnabledInResultPage("Tesla, Inc.");
        Assertions.assertTrue(valueFoundInResultsPage);
    }
}
