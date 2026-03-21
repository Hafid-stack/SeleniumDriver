package com.test.tests.tickets.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();
    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/application.properties");
            props.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
