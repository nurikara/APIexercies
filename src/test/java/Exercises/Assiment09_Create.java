package Exercises;

import BaseUrl.HerokuAppUrl;
import Pojos.HerOkuPojo.HerOkuDataPojo;
import Pojos.HerOkuPojo.HerOkuObjetPojo;
import Pojos.HerOkuPojo.HerOkuPojo;



import io.restassured.response.Response;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Assiment09_Create extends HerokuAppUrl {

    /*
   "https://restful-booker.herokuapp.com/apidoc/index.html" dökümanını kullanarak;

    , o booking'i güncelleyen ve sonra silen ve bu adımları doğrulayan positif ve negatif testler içeren bir otomasyon testi yazınız.

*/
    static int Id;
    @Test
    public void creatBooking() {
        // Bir booking oluşturan
        // set the url

        spec.pathParam("pp1", "booking");
        // set the expected data

        HerOkuDataPojo exData = new HerOkuDataPojo("2023-05-30", "2023-03-06");
        HerOkuPojo exBooking = new HerOkuPojo("Nuri", "Kara", 120, true, exData, "Kahvalti");
        HerOkuObjetPojo expectedData = new HerOkuObjetPojo(exBooking);

        // sen the request get the respond
        Response response = given(spec).body(exBooking).post("{pp1}");

        response.prettyPrint();

        //do assertions

        HerOkuObjetPojo actualData = response.as(HerOkuObjetPojo.class);

        // System.out.println("actualData = " + actualData);

        assertEquals(200, response.getStatusCode());
        assertEquals(exBooking.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(exBooking.getLastname(), actualData.getBooking().getLastname());
        assertEquals(exBooking.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(exBooking.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(exData.getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(exData.getCheckout(), actualData.getBooking().getBookingdates().getCheckout());



        Map<String, Object> actualDataMap = response.as(HashMap.class);

        Id = (int)(actualDataMap.get("bookingid"));
        System.out.println("Id = " + Id);
    }


}
