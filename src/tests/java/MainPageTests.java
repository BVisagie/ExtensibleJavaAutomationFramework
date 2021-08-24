import base.Session;
import base.pojos.SessionProperties;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.landing.LandingPage;
import pageobjects.main.MainPage;

public class MainPageTests {

    private SessionProperties testSession;

    @BeforeClass
    public void setUp() {
        testSession = new Session().setupTestSession(true);
    }

    @AfterClass
    public void tearDown() {
        testSession.driver.quit();
    }

    @Test(testName = "Main Page Title Test")
    public void mainPageTitleTest() {

        testSession.driver.navigate().to(testSession.urlUnderTest);

        new LandingPage(testSession).clickEnglishMainPageLink();

        String expectedPageTitle = "Wikipedia, the free encyclopedia";
        String actualPageTitle = testSession.driver.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        boolean mainPageElementsFound = new MainPage(testSession).verifyMainPageElementsExist();
        Assert.assertTrue(mainPageElementsFound);
    }

    @Test(testName = "Main Page Elements Present Test")
    public void mainPageElementTest() {

        testSession.driver.navigate().to(testSession.urlUnderTest);

        new LandingPage(testSession).clickEnglishMainPageLink();

        boolean mainPageElementsFound = new MainPage(testSession).verifyMainPageElementsExist();
        Assert.assertTrue(mainPageElementsFound);
    }
}
