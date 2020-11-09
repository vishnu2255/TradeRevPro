package com.utilities.reader;

public interface PropertyReader {

    String getProp(String key);

    void setPropertyFile(String propertyFilePath);

}