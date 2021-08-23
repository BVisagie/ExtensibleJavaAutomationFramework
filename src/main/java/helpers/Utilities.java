package helpers;

import base.enums.ConfigurationProperties;

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
        if (inputString.equalsIgnoreCase("true") || inputString.equalsIgnoreCase("false")) {
            return true;
        } else {
            return false;
        }
    }
}
