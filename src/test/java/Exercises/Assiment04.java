package Exercises;

import BaseUrl.HerokuAppUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class Assiment04 extends HerokuAppUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Jane" and lastname is "Doe"
			(Data içinde firstname "Jane" ve lastname "Doe" olan bir booking olduğunu doğrulayın)

     */

    @Test
    public void ex04() {
        // set the url
        spec.pathParam("pp1","booking").
                queryParams("firstname","Jane","lastname","Doe");
        //    Set the expected data

        // send the request get the response

        Response response = given(spec).get("{pp1}");

        response.prettyPrint();

        // do assertions

        response.then().
                statusCode(200).
                body("bookingid", hasSize(greaterThan(0)));







    }
}
