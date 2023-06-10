package Exercises.Gmi;

import BaseUrl.GmiUrl;
import Pojos.HerOkuPojo.GmiPojo;
import Pojos.HerOkuPojo.Gmi_Name_State_pojo;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Gmi_PutRequest extends GmiUrl {

    /*
     Given :
   https://gmibank.com/api/tp-countries

    And :
{
  "name": "New Country",
  "states": [
    { "id": 1,
    "tpcountry": null,
     "name": "string"},
      {"name": "State 2"},
    {"name": "State 3"}
  ]
}
When:
Send post request

Then:

Status code: 200

And:

Body:
"bookingid": 6583,
   {
    "id": 187397,
    "name": "New Country",
    "states": [
        {
            "id": 1,
            "name": "string",
            "tpcountry": null
        },
        {
            "id": 2,
            "name": "State 2",
            "tpcountry": null
        },
        {
            "id": 3,
            "name": "State 3",
            "tpcountry": null
        }
    ]
}
}
}*/

    @Test
    public void putRequest() {

        //Set the Url
        spec.pathParam("pp1", "tp-countries");

        //Set the expected Dat
//
//        GmiPojo exState1 = new GmiPojo(132432134, "Istanbul", null);
//        GmiPojo exState2 = new GmiPojo(2132412341, "Bolu", null);
//        GmiPojo exState3 = new GmiPojo(31234123, "Ankara", null);
//
//        List<GmiPojo> stateList = new ArrayList<>();
//        stateList.add(exState1);
//        stateList.add(exState2);
//        stateList.add(exState3);
//
//        Gmi_Name_State_pojo expectedData = new Gmi_Name_State_pojo("Turkey", stateList);

        String expectedData ="{\n" +
                "  \"name\": \"Turkey\",\n" +
                "  \"states\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"Istanbul\",\n" +
                "            \"tpcountry\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"name\": \"Bolu\",\n" +
                "            \"tpcountry\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"name\": \"Ankara\",\n" +
                "            \"tpcountry\": null\n" +
                "        }\n" +
                " \n" +
                "  ]\n" +
                "}";


//        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response

        Response response = given(spec).body(expectedData).post("{pp1}");

        response.prettyPrint();


    }
}
