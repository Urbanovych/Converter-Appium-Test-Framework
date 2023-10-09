package org.urbanovych.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    public static Properties getPropertiesFromPath(String path) throws IOException {
        Properties appiumDriverProperties = new Properties();
        FileInputStream appiumFileInputStream = new FileInputStream(path);
        appiumDriverProperties.load(appiumFileInputStream);
        return appiumDriverProperties;
    }
}
