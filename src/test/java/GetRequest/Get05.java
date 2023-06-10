package GetRequest;

import BaseUrl.HerokuAppUrl;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class Get05 extends HerokuAppUrl {
     /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
        (Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı)
 */


    @Test
    public void get01() {

        // set url
        spec.pathParam("first", "booking").
                queryParams("firstname", "Sally", "lastname", "Brown");
        // send the request get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        // assertions

        response.then().statusCode(200).body("bookingid", hasSize(greaterThan(0)));

        Assert.assertTrue(response.asString().contains("bookingid"));

    }


}
