package GetRequest;

import BaseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get07 extends JsonPlaceHolderBaseUrl {
    /*
 Given
     https://jsonplaceholder.typicode.com/todos
 When
     I send GET Request to the URL == > URL'e Get Request gonderin
 Then
     1)Status code is 200 == > Status kodu 200 olmali

     2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
       Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin

     3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
       Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
     4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
       Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
       basliginin "delectus aut autem" icerdigini dogrulayin
*/

   @Test
    public void test01() {
        // i)  set url
        // https://jsonplaceholder.typicode.com/todos

        spec.pathParam("pp1", "todos");
        //   ii) Set the expected data --> Beklenen veriyi kur
        //Send the request and get the response

        Response response = given(spec).get("{pp1}");
       // response.prettyPrint();


        // do assertions
        response.then().statusCode(200);


        JsonPath jsonPath = response.jsonPath();
        List<Integer> idList = jsonPath.getList("findAll{it.id>190}.id");

        // Print all ids greater than 190 on the console
        System.out.println("idList = " + idList);

        // Assert that there are 10 ids
        assertEquals(10,idList.size());

        // Print all userIds whose ids are less than 5 on the console

        List<Integer> userIdlist =jsonPath.getList("findAll{it.userId<5}.userId");

        System.out.println("userIdlist = " + userIdlist);
        List<String> titlelist =jsonPath.getList("findAll{it.userId<5}.title");
        Assert.assertTrue(titlelist.contains("delectus aut autem"));


    }
}
