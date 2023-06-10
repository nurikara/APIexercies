package Exercises;

import BaseUrl.PetStoreUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Assiment07 extends PetStoreUrl {

    @Test
    public void assiment07()  {

        //1) https://petstore.swagger.io/ dokumanını kullanarak statüsü "available" olan "pet"
        // sayısını bulup 100'den fazla olduğunu assert eden bir otomasyon testi yazınız.

        // set the url
        // https://petstore.swagger.io/v2/pet/findByStatus?status=available

        spec.pathParams("pp1", "pet","pp2","findByStatus").
                queryParam("status","available");

        //set expected data

        // send respond and get request

        Response response = given(spec).get("{pp1}/{pp2}");

       // response.prettyPrint();

        JsonPath jsonPath =response.jsonPath();

        List<String> availableList=jsonPath.getList("findAll{it.status == 'available'}.status");

        System.out.println(availableList);

        System.out.println("availableList.size() = " + availableList.size());

        assertTrue(availableList.size()>100);


    }
}
