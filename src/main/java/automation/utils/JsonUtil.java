package automation.utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonUtil {

    public JSONObject convertJsonToJsonObject(String filePath) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try {
            Reader reader = new FileReader(System.getProperty("user.dir") + filePath);
            jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static <T extends Object> T convertJsonToObject(String filePath, Class<T> objectClass) {
        T object = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            //JSON file to Java object
            object = mapper.readValue(new File(System.getProperty("user.dir") + filePath), objectClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

}
