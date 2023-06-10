package Post_Request;

import BaseUrl.PetStoreUrl;
import Pojos.PetStotePojo;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Post04 extends PetStoreUrl {

/*
   "https://petstore.swagger.io/" dökümanını kullanarak 'user' oluşturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.
*/

    @Test
    public void post04() {

        // set the url
        spec.pathParam("pp1", "user");

        // set expected data

        PetStotePojo expected =
                new PetStotePojo(0, "nurikara",
                        "nuri", "kara", "nurikara@yahoo.com",
                        "4344", 0506, 0);
        // send request get response

        Response response = given(spec).body(expected).post("{pp1}");

        response.prettyPrint();

        // do Assert
        response.then().statusCode(200);

        Map actualMap = response.as(Map.class);

        assertEquals(actualMap.get("code"), 200.0);
        assertEquals(actualMap.get("type"), "unknown");
        assertTrue(actualMap.containsKey("message"));
    }
}

