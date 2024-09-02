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
            System.err.println("Создайте файл \"config.properties\" и задайте в нем необходимые значения переменных.");
            System.exit(1);
        }
    }

    public static String getProperty(String key) {
        if (props.containsKey(key)) {
            return props.getProperty(key);
        } else {
            System.err.println("Задайте значение переменной " + key + " в файле настроек.");
            System.exit(1);
            return null;
        }
    }
}
