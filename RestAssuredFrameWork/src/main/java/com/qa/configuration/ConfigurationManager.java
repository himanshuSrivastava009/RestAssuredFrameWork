package com.qa.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {

    Properties prop;
    FileInputStream ip;

    public Properties initProp() {
        prop = new Properties();

        try {
            ip = new FileInputStream("./src/test/resources/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prop;
    }
}
