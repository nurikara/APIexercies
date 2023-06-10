package Utils;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {

    public  Map<String, String> bookingdatesMapMethod(String checkin, String checkout){

        Map<String, String> bookingdatesMap = new HashMap<>();

        bookingdatesMap.put("checkin",checkin );
        bookingdatesMap.put("checkout", checkout);

        return bookingdatesMap;
    }

    public Map<String, Object> expectedDataMapMethod(Map<String,String> bookingdatesMap,
                                                     String firstname, String lastname,
                                                     Integer totalprice,Boolean depositpaid,String breakfast,String additionalneeds){

        Map<String, Object> expectedData = new HashMap<>();

        if (firstname!=null){
            expectedData.put("firstname", firstname);
        }
        if (lastname!=null){
            expectedData.put("lastname", lastname);
        }

        if (depositpaid!=null){
            expectedData.put("depositpaid", depositpaid);
        }
        if (bookingdatesMap!=null){
            expectedData.put("bookingdates", bookingdatesMap);
        }

        if (additionalneeds != null) {
            expectedData.put("additionalneeds", additionalneeds);
        }

        if (totalprice!=null){
            expectedData.put("totalprice", totalprice);
        }




        return expectedData;


    }}






