package common;

import java.io.*;
import java.util.Properties;

public class Settings {
    private static Settings settings;
    private static Properties properties;
    public Setting DEFAULT_DATABASE;

    private Settings() {
        properties = new Properties();
        try {
            var propertiesFile = new FileInputStream("src/main/resources/config.properties");
            var inputStream = new InputStreamReader(propertiesFile, "UTF-8");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DEFAULT_DATABASE = new Setting("default_database");
    }

    public static Settings getSettings() {
        if (settings == null)
            settings = new Settings();

        return settings;
    }

    public String getSetting(String key) {
        return properties.getProperty(key);
    }
}
