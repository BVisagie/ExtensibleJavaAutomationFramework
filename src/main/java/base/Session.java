package base;

import base.enums.ConfigurationProperties;
import base.enums.SupportedBrowsers;
import base.pojos.SessionProperties;
import helpers.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.LoggerFactory;

public class Session {

    public SessionProperties setupTestSession(boolean uiTestCase) {

        var testSession = new SessionProperties();
        var utils = new Utilities();

        testSession.logger = LoggerFactory.getLogger("Session");

        testSession.uiTestCase = uiTestCase;
        testSession.logger.info("Ui Test Case: " + testSession.uiTestCase);

        String isPipeLineRun = utils.getConfigurationProperty(ConfigurationProperties.PIPELINERUN);
        if (utils.stringValidBoolean(isPipeLineRun)) {
            testSession.pipelineRun = Boolean.parseBoolean(isPipeLineRun);
            testSession.logger.info("Is this a pipeline run: " + testSession.pipelineRun);
        } else {
            testSession.logger.error("An exception has occurred while trying to parse config value related to: PIPELINERUN");
            testSession.logger.error("Test setup cannot continue.");
            return null;
        }

        if (uiTestCase) {

            String browserIncognitoResult = utils.getConfigurationProperty(ConfigurationProperties.BROWSERINCOGNITO);
            if (utils.stringValidBoolean(browserIncognitoResult)) {
                testSession.browserIncognito = Boolean.parseBoolean(browserIncognitoResult);
                testSession.logger.info("Browser Incognito: " + testSession.browserIncognito);
            } else {
                testSession.logger.error("An exception has occurred while trying to parse config value related to: BROWSERINCOGNITO");
                testSession.logger.error("Test setup cannot continue.");
                return null;
            }

            String uiTestRunHeadlessResult = utils.getConfigurationProperty(ConfigurationProperties.UITESTRUNHEADLESS);
            if (utils.stringValidBoolean(uiTestRunHeadlessResult)) {
                testSession.uiTestRunHeadless = Boolean.parseBoolean(uiTestRunHeadlessResult);
                testSession.logger.info("Browser Run Headless: " + testSession.uiTestRunHeadless);
            } else {
                testSession.logger.error("An exception has occurred while trying to parse config value related to: UITESTRUNHEADLESS");
                testSession.logger.error("Test setup cannot continue.");
                return null;
            }

            String browser = utils.getConfigurationProperty(ConfigurationProperties.BROWSER);
            testSession.selectedBrowser = Enum.valueOf(SupportedBrowsers.class, browser.toUpperCase());

            switch (testSession.selectedBrowser) {
                case EDGE -> testSession.driver = SetupEdgeWebdriver(testSession);
                case CHROME -> testSession.driver = SetupChromeWebdriver(testSession);
                case FIREFOX -> testSession.driver = SetupFireFoxWebdriver(testSession);
                case SAFARI -> testSession.driver = SetupSafariWebdriver(testSession);
            }
        }

        testSession.urlUnderTest = utils.getConfigurationProperty(ConfigurationProperties.URLUNDERTEST);
        testSession.logger.info("URL Under Test: " + testSession.urlUnderTest);

        return testSession;
    }

    private WebDriver SetupEdgeWebdriver(SessionProperties testSession) {

        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();

        if (testSession.browserIncognito) {
            edgeOptions.addArguments("incognito");
        }

        if (testSession.uiTestRunHeadless) {
            edgeOptions.addArguments("headless");
        }

        if (testSession.pipelineRun) {
            edgeOptions.addArguments("disable-gpu");
        }

        edgeOptions.addArguments("start-maximized");

        testSession.logger.info("Now loading Edge options: " + edgeOptions);
        return new EdgeDriver(edgeOptions);
    }

    private WebDriver SetupChromeWebdriver(SessionProperties testSession) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        if (testSession.browserIncognito) {
            chromeOptions.addArguments("incognito");
        }

        if (testSession.uiTestRunHeadless) {
            chromeOptions.addArguments("headless");
        }

        chromeOptions.addArguments("start-maximized");

        testSession.logger.info("Now loading Chrome options: " + chromeOptions);
        return new ChromeDriver(chromeOptions);

    }

    private WebDriver SetupFireFoxWebdriver(SessionProperties testSession) {

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        if (testSession.browserIncognito) {
            firefoxOptions.addArguments("incognito");
        }

        if (testSession.uiTestRunHeadless) {
            firefoxOptions.setHeadless(true);
        }

        firefoxOptions.addArguments("start-maximized");

        testSession.logger.info("Now loading Firefox options: " + firefoxOptions);
        return new FirefoxDriver(firefoxOptions);
    }

    private WebDriver SetupSafariWebdriver(SessionProperties testSession) {

        WebDriverManager.safaridriver().setup();

        /* No useful options known of at this stage
        SafariOptions safariOptions = new SafariOptions();
        testSession.logger.info("Now loading Safari options: " + safariOptions);
        return new SafariDriver(safariOptions);
        */

        return new SafariDriver();
    }

}
