import base.Session;
import base.pojos.SessionProperties;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleTest {

    private SessionProperties sessionProperties;

    @BeforeClass
    public void setUp() {
        sessionProperties = new Session().setupTestSession(true);
        // code that will be invoked when this test is instantiated
    }

    @AfterClass
    public void tearDown() {

    }

    @Test(testName = "My first Test Case")
    public void aFastTest() {
        int a,b;
        a = 1;
        b = 2;
        String url = sessionProperties.urlUnderTest;
        Assert.assertEquals(1,1);
    }
}
