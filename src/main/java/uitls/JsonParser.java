package uitls;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonParser {

    protected static final Logger logger = LogManager.getLogger(JsonParser.class.getSimpleName());

    public static <T> T deserializeJsonFile(String filePath, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        File json = new File(filePath);
        T data = null;
        try {
            data = objectMapper.readValue(json, clazz);
            logger.info("JSON file is successfully deserialized to " + data.getClass().getName() + " class object");
        } catch (IOException e) {
            logger.error("JSON file deserialization failed for " + clazz.getClass().getName() + " class object");
            e.printStackTrace();
        }
        return data;
    }

    public static void serializeJsonFile(Object jsonObject) {
        ObjectMapper objectMapper = new ObjectMapper();
        File json = new File(jsonObject.getClass().getName() + ".json");
        try {
            objectMapper.writeValue(json, jsonObject);
            logger.info("JSON file is successfully serialized to " + json.getAbsolutePath());
        } catch (IOException e) {
            logger.error("JSON file deserialization failed for " + jsonObject.getClass().getName() + " class object");
            e.printStackTrace();
        }
    }

}
