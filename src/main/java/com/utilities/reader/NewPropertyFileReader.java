package com.utilities.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class NewPropertyFileReader implements PropertyReader {

    private String propertyFile;

    public void setPropertyFile(String propertyFile) {
        this.propertyFile = propertyFile;
    }

    public String getProp(String key) {
        return getProperties().getProperty(key);
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        try {
            File file = new File(propertyFile);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
