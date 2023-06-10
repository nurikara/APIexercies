package Pojos.HerOkuPojo;


import java.util.Date;

public class HerOkuDataPojo {
   /*  "firstname" : "James",
             "lastname" : "Brown",
             "totalprice" : 111,
             "depositpaid" : true,
             "bookingdates" : {
        "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
    },
            "additionalneeds" : "Breakfast"

    */

private String checkin;
private String checkout;

    public HerOkuDataPojo() {
    }

    public HerOkuDataPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "HerOkuDataPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
