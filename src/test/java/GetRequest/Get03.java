package GetRequest;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class Get03 {

     /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be “application/json”
And
    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
And
    “completed” is false
And
    “userId” is 2
   */

    @Test
    public void get01() {
        // Set the url

        String url = "https://jsonplaceholder.typicode.com/todos/23";

        // request and response(when)

        Response response = given().get(url);

        // do assertion(then)

        response.then().statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo("false")).
                body("userId", equalTo("2"));


    }
}
