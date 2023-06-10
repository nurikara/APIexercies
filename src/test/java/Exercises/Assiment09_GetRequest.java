package Exercises;

import BaseUrl.HerokuAppUrl;
import Pojos.HerOkuPojo.HerOkuDataPojo;
import Pojos.HerOkuPojo.HerOkuPojo;
import Utils.ObjeMapperUtils;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static Exercises.Assiment09_Create.Id;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class Assiment09_GetRequest extends HerokuAppUrl {
    @Test
    public void getRequest() {
        // Set the url
        spec.pathParams("pp1","booking","pp2",2210);

        // expect(getRequest) data
        HerOkuDataPojo exData = new HerOkuDataPojo("2023-05-30", "2023-03-06");
        HerOkuPojo exBooking = new HerOkuPojo("Nuri", "Kara", 120, true, exData, "Kahvalti");

        // send The request get the response
        Response response =given(spec).get("{pp1}/{pp2}");
        response.prettyPrint();

        // do assertions

        HerOkuPojo actualData = ObjeMapperUtils.convertJsonToJava(response.asString(),HerOkuPojo.class);

        assertEquals(200,response.statusCode());

        assertEquals(exBooking.getFirstname(), actualData.getFirstname());
        assertEquals(exBooking.getLastname(), actualData.getLastname());
        assertEquals(exBooking.getTotalprice(), actualData.getTotalprice());
        assertEquals(exBooking.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(exBooking.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());



    }




}
