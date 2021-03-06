package helpers;

import base.enums.ConfigurationProperties;
import base.pojos.SessionProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
    public String getConfigurationProperty(ConfigurationProperties targetConfigItem) {

        Properties prop = new Properties();
        String fileNameAndPath = "src/main/resources/config.properties";

        try (FileInputStream fis = new FileInputStream(fileNameAndPath)) {
            prop.load(fis);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop.getProperty(targetConfigItem.name());

    }

    public boolean stringValidBoolean(String inputString) {
        return inputString.equalsIgnoreCase("true") || inputString.equalsIgnoreCase("false");
    }

    public void tearDown(SessionProperties testSession) {
        testSession.driver.quit();
    }
}
