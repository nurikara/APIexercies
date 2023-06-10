package Exercises;

import BaseUrl.HerokuAppUrl;
import Pojos.HerOkuPojo.HerOkuDataPojo;
import Pojos.HerOkuPojo.HerOkuPojo;
import Utils.ObjeMapperUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Assiment09_Update extends HerokuAppUrl {
    @Test
    public void upDateBooking() {
        // https://restful-booker.herokuapp.com/booking/:id


        // set the Url
        spec.pathParams("pp1","booking","pp2",1387);

        // Set the expected data
        HerOkuDataPojo exData = new HerOkuDataPojo("2023-05-30", "2023-03-06");
        HerOkuPojo exBooking = new HerOkuPojo("Eren", "Kara", 120, true, exData, "Kahvalti");


        // Send the response get the request
        Response response = given(spec).body(exBooking).put("{pp1}/{pp2}");
        response.prettyPrint();

        // do asseertion

        HerOkuPojo actualData = ObjeMapperUtils.convertJsonToJava(response.asString(),HerOkuPojo.class);

       assertEquals(200,response.statusCode());

        assertEquals(exBooking.getFirstname(), actualData.getFirstname());
       assertEquals(exBooking.getLastname(), actualData.getLastname());
       assertEquals(exBooking.getTotalprice(), actualData.getTotalprice());
       assertEquals(exBooking.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
       assertEquals(exBooking.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());




    }
}
