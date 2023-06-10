package Post_Request;

import BaseUrl.JsonPlaceHolderBaseUrl;
import org.junit.Test;

public class Post05_ObjeMepper_Map extends JsonPlaceHolderBaseUrl {

    /*
       Given
         1) https://jsonplaceholder.typicode.com/todos
         2) {
               "userId": 55,
               "title": "Tidy your room",
               "completed": false
             }


          I send POST Request to the Url
      Then
          Status code is 201
      And
          response body is like {
                                  "userId": 55,
                                  "title": "Tidy your room",
                                  "completed": false,
                                  "id": 201
                                  }
   */
    @Test
    public void post05() {

        // set the url

        spec.pathParam("pp1","todos");

        //Set the expected Data
     


    }
}
