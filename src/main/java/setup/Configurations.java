package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
    public static String BROWSER;
    public static String BASE_URL;
    static Properties props;
    static FileInputStream inputStream;

    static {
        try {
            props = new Properties();
            inputStream = new FileInputStream("src/main/resources/configs/configuration.properties");
            props.load(inputStream);
            BROWSER = props.getProperty("run.browser");
            BASE_URL = props.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
