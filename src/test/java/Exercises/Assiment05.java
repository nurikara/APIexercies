package Exercises;

import BaseUrl.ReqresURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Assiment05 extends ReqresURL {
       /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "#BF1932": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void ex05() {

        // set the url
        spec.pathParams("pp1", "api", "pp2", "unknown", "pp3", 3);


        //    Set the expected data

        // send the request get the response
        Response response = given(spec).get("{pp1}/{pp2}/{pp3}");
        response.prettyPrint();

        // do assertions
        response.then().statusCode(200).contentType(ContentType.JSON);
        JsonPath jsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsonPath.getInt("data.id"), 3, "Id uyusmadi");
        softAssert.assertEquals(jsonPath.getString("data.name"), "true red", "name  uyusmadi");
        softAssert.assertEquals(jsonPath.getInt("data.year"), 2002, "yil  uyusmadi");
        softAssert.assertEquals(jsonPath.getString("data.color"),"#BF1932" , "Renk   uyusmadi");

        softAssert.assertEquals(jsonPath.getString("data.#BF1932"),"19-1664" , "Mesaj yok");

        softAssert.assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading", "Mesaj yok");
        softAssert.assertEquals(jsonPath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!" , "Mesaj yok");


    }
}
