package Exercises;

import BaseUrl.AutomationexerciseUrl;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Assiment08 extends AutomationexerciseUrl {

    /*2)
    Given
        https://automationexercise.com/api/productsList
    When
        User sends Get request
    Then
        Assert that number of "Women" usertype is 12
        (Kadın usertype sayısının 12 olduğunu doğrulayın)

    Not: Yazdırmayı jsonPath kullanarak yapınız: response.jsonPath().prettyPrint();

*/

    @Test
    public void assiment08() {
        //set url


        spec.pathParams("pp1","productsList");






        // send response get request
        Response response = given(spec).get("{pp1}");

       // response.prettyPrint();

        //do assertion

        JsonPath jsonPath= response.jsonPath();

        List<Object> womenList = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}");

        System.out.println("womenList = " + womenList.size());

        Assert.assertEquals(12, womenList.size());




    }
}
