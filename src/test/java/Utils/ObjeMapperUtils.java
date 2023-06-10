package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjeMapperUtils {

    //Map<String, Object> actualData = new ObjectMapper().readValue(response.asString(), HashMap.class);

    public static <T> T convertJsonToJava(String json,Class<T> type) {


        try {
            return new ObjectMapper().readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
