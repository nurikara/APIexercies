package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;

public class HerokuAppUrl {

   protected RequestSpecification spec;
   @Before
    public void setUp() {
       spec = new RequestSpecBuilder().
                addHeader("Cookie","token=3fac5afae49d0a6").
                setContentType(ContentType.JSON).setBaseUri("https://restful-booker.herokuapp.com/").
                build();

    }
}
