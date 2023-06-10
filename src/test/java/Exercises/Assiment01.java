package Exercises;

import BaseUrl.ReqresURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Assiment01 extends ReqresURL {


  /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void ex1() {
//Set the url
        spec.pathParams("pp1", "api", "pp2", "users", "pp3", 3);

        //Set the expected data

        // send the request get the response

        Response response = given(spec).get("{pp1}/{pp2}/{pp3}");

        response.prettyPrint();


        // assertions
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");


    }

}
