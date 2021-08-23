package base;

import base.enums.ConfigurationProperties;
import base.pojos.SessionProperties;
import helpers.Utilities;
import org.slf4j.LoggerFactory;

public class Session {

    public SessionProperties setupTestSession(boolean uiTestCase) {

        var testSession = new SessionProperties();
        var utils = new Utilities();

        testSession.logger = LoggerFactory.getLogger("Session");

        testSession.uiTestCase = uiTestCase;
        testSession.logger.info("Ui Test Case: " + testSession.uiTestCase);

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
        }

        testSession.urlUnderTest = utils.getConfigurationProperty(ConfigurationProperties.URLUNDERTEST);
        testSession.logger.info("URL Under Test: " + testSession.urlUnderTest);

        return new SessionProperties();
    }


}
