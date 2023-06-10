package Post_Request;

import BaseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Post01 extends JsonPlaceHolderBaseUrl {
     /*
     Given
       1)  https://jsonplaceholder.typicode.com/todos
       2)  {
 "userId": 55,
 "title": "Tidy your room",
 "completed": false
            }
    When
     I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "": 201
                                }
 */

    @Test
    public void post01() {

        // set the url
        spec.pathParam("pp1", "todos");

        // set the expected data type

        String payLoad = "{\n" +
                " \"userId\": 55,\n" +
                " \"title\": \"Tidy your room\",\n" +
                " \"completed\": false,\n" +
                " \"\": 201\n" +
                " }";
        //send the  request get the response

        Response response = given(spec).body(payLoad).post("{pp1}");

        response.prettyPrint();

        // do assertions

        response.then().statusCode(201);
        JsonPath jsonPath = response.jsonPath();
        assertEquals("Tidy your room", jsonPath.getString("title"));
        assertFalse(jsonPath.getBoolean("completed"));
        assertEquals(55, jsonPath.getInt("userId"));
    }

    @Test
    public void post02() {

        // set the url
        spec.pathParam("pp1", "todos");

        // set the expected data type

      Map<String,Object> payLoad = new HashMap<>();
      payLoad.put("title", "Tidy your room");
      payLoad.put("userId", 55);
      payLoad.put("completed", false);
        //send the  request get the response

        Response response = given(spec).body(payLoad).post("{pp1}");

        response.prettyPrint();

        // do assertions

        response.then().statusCode(201);
        JsonPath jsonPath = response.jsonPath();
        assertEquals(payLoad.get("title"), jsonPath.getString("title"));
        assertFalse(jsonPath.getBoolean("completed"));
        assertEquals(payLoad.get("userId"), jsonPath.getInt("userId"));
    }

}
