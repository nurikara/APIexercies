package Exercises;

import BaseUrl.HerokuAppUrl;
import Pojos.HerOkuPojo.HerOkuPojo;
import Utils.HerokuAppTestData;
import Utils.ObjeMapperUtils;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Assiment09_Patch extends HerokuAppUrl {

    @Test
    public void pathRequest() {
        // Set the url
        spec.pathParams("pp1","booking","pp2",888);

        Map<String,Object> testtt= new HerokuAppTestData().expectedDataMapMethod(null,
                "Kara",null,null,null,null,null);

        Response response = given(spec).body(testtt).patch("{pp1}/{pp2}");

        response.prettyPrint();

        HerOkuPojo expectedData = ObjeMapperUtils.convertJsonToJava(response.toString(), HerOkuPojo.class);

        System.out.println("expectedData = " + expectedData);


    }
}
