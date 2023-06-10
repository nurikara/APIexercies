package GetRequest;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class Get02 {

     /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get01() {
        //set the url
        String url =" https://restful-booker.herokuapp.com/booking/0";

//        ii) Set the expected data --> Beklenen veriyi kur

//        iii) Send the request and get the response --> Request yolla, response al
        Response response = given().get(url);
        response.prettyPrint();
//        iv) Do Assertion --> Doğrulama yap

        response.
                then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");

       // Response body contains "Not Found"
        assertTrue(response.toString().contains("Not Found"));

//        Response body does not contain "TechProEd"
        assertFalse(response.toString().contains("TechProEd"));



        //Server is "Cowboy"
        String server = response.header("Server");
        assertEquals("Cowboy", server);






    }
}
