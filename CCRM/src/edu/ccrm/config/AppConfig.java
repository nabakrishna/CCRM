package edu.ccrm.config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class AppConfig {
    private static AppConfig instance;
    private Properties properties;
    private Path dataFolderPath;
    private Path backupFolderPath;

    private AppConfig() {
        properties = new Properties();
        initializeDefaults();
    }

    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    private void initializeDefaults() {
        properties.setProperty("data.folder", "data");
        properties.setProperty("backup.folder", "backups");
        properties.setProperty("max.credits.per.semester", "24");
        properties.setProperty("date.format", "yyyy-MM-dd");

        dataFolderPath = Paths.get(properties.getProperty("data.folder"));
        backupFolderPath = Paths.get(properties.getProperty("backup.folder"));
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public Path getDataFolderPath() { return dataFolderPath; }
    public Path getBackupFolderPath() { return backupFolderPath; }
}