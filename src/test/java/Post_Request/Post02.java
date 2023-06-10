package Post_Request;

import BaseUrl.ReqresURL;
import Pojos.PetStotePojo;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Post02 extends ReqresURL {
    //2)

  /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void post02() {

        // set the url
        spec.pathParams("pp1","api","pp2","users");

        // set the expected data

        Map<String, Object> expectedMap = new HashMap<>();

        expectedMap.put("name", "morpheus");
        expectedMap.put("job", "leader");

        // send the request get the response
        Response response =given(spec).body(expectedMap).post("{pp1}/{pp2}");
        response.prettyPrint();

        // do assertions

        assertEquals(201,response.getStatusCode());
        Map<String,Object> actualsMap = response.as(Map.class);
        assertEquals(expectedMap.get("name"),actualsMap.get("name"));
        assertEquals(expectedMap.get("job"),actualsMap.get("job"));
        assertTrue(actualsMap.containsKey("createdAt"));


        PetStotePojo al= new PetStotePojo();

       al.setEmail("nuri");



    }

}
