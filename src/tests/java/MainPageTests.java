import base.Session;
import base.pojos.SessionProperties;
import org.junit.jupiter.api.*;
import pageobjects.landing.LandingPage;
import pageobjects.main.MainPage;

public class MainPageTests {

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
    @DisplayName("Main Page Title Test")
    public void mainPageTitleTest() {

        testSession.driver.navigate().to(testSession.urlUnderTest);

        new LandingPage(testSession).clickEnglishMainPageLink();

        String expectedPageTitle = "Wikipedia, the free encyclopedia";
        String actualPageTitle = testSession.driver.getTitle();
        Assertions.assertEquals(actualPageTitle, expectedPageTitle);

        boolean mainPageElementsFound = new MainPage(testSession).verifyMainPageElementsExist();
        Assertions.assertTrue(mainPageElementsFound);
    }

    @Test
    @DisplayName("Main Page Elements Present Test")
    public void mainPageElementTest() {

        testSession.driver.navigate().to(testSession.urlUnderTest);

        new LandingPage(testSession).clickEnglishMainPageLink();

        boolean mainPageElementsFound = new MainPage(testSession).verifyMainPageElementsExist();
        Assertions.assertTrue(mainPageElementsFound);
    }
}
