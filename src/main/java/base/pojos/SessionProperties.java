package base.pojos;

import base.enums.SupportedBrowsers;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public class SessionProperties {
    public WebDriver driver;
    public SupportedBrowsers selectedBrowser;
    public Logger logger;
    public String urlUnderTest;
    public boolean uiTestCase;
    public boolean uiTestRunHeadless;
    public boolean browserIncognito;
    public boolean pipelineRun;
}
