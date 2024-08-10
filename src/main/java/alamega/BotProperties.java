package alamega;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BotProperties {
    private static final Properties props = new Properties();

    static {
        try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
            props.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("Error loading config file: " + e.getMessage());
            System.exit(1);
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}
