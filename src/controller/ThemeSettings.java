package controller;

import java.io.*;
import java.util.Properties;

public class ThemeSettings {
    private static final String PATH = "src/theme.properties";
    private static final String DarkMode = "dark.mode";

    private final Properties properties = new Properties();

    public ThemeSettings() {
        load();
    }

    public void load() {
        properties.clear();
        File file = new File(PATH);

        if (file.exists()) {
            try (InputStream in = new FileInputStream(file)) {
                properties.load(in);
                return;
            } catch (IOException e) {
                System.err.println("Failed to load " + PATH + ": " + e.getMessage());
            }
        }

        try (InputStream classpathIn = getClass().getClassLoader().getResourceAsStream(PATH)) {
            if (classpathIn != null) {
                properties.load(classpathIn);
            }
        } catch (IOException e) {
            System.err.println("Failed to load default properties: " + e.getMessage());
        }
    }


    public void save() {
        try (OutputStream out = new FileOutputStream(PATH)) {
            properties.store(out, "Application Settings");
        } catch (IOException e) {
            System.err.println("Failed to save " + PATH + ": " + e.getMessage());
        }
    }

    public boolean isDarkMode() {
        String value = properties.getProperty(DarkMode,"false");
        return Boolean.parseBoolean(value.trim());
    }

    public void setDarkMode(boolean bool) {
        properties.setProperty(DarkMode, Boolean.toString(bool));
        save();
    }
}
