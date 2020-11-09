package com.utilities.reader;

/**
 * Class to represent reading Test Data at environment level, and global level based on the defined file structure.
 */
public class TestDataReader {

    private static final String globaldata;

    static {
       globaldata = "data";

    }

    private static final String fileExtension = ".properties";
    PropertyReader reader = new NewPropertyFileReader();

    private String getGlobalDataFolderPath() {
        return this.getClass().getClassLoader().getResource("data/").getPath();
    }


    private String getTestData(String key) {
        reader.setPropertyFile(getGlobalDataFolderPath() + globaldata + fileExtension);
        String value = reader.getProp(key);
        try {
            if (value == null) {
                throw new RuntimeException("Add key - " + key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public String readData(String key) {
        return getTestData(key).trim();
    }

}
