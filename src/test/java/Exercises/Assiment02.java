package Exercises;

import BaseUrl.ReqresURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Assiment02 extends ReqresURL {
/*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void ex2() {
        //Set the url
        spec.pathParams("pp1", "api", "pp2", "users", "pp3", 23);
        //Set the expected data

        // send the request get the response
        Response response = given(spec).get("{pp1}/{pp2}/{pp3}");
        response.prettyPrint();

        // assertions

        response.
                then().
                statusCode(404).body("id",hasSize(greaterThan(0))).
                statusLine("HTTP/1.1 404 Not Found");

        assertEquals(response.getHeader("Server"), "cloudflare");
        assertFalse(response.getBody().asString().contains("id"));


    }
}
