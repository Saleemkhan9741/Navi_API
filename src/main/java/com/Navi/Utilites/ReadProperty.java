package com.Navi.Utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperty {

    public static String getValueForGivenKey(String key) throws Throwable {
        FileInputStream fis = new FileInputStream("src/test/testConfig.properties");
        Properties properties = new Properties();
        properties.load(fis);
        String value=properties.getProperty(key);
        return value;
    }
}
