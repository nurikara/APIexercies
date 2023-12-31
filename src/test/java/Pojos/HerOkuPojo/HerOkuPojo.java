package Pojos.HerOkuPojo;

public class HerOkuPojo {
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

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private HerOkuDataPojo bookingdates;
    private String additionalneeds;

    public HerOkuPojo() {
    }

    public HerOkuPojo(String firstname, String lastname, Integer totalprice, Boolean depositpaid, HerOkuDataPojo bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public HerOkuDataPojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(HerOkuDataPojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "HerOkuPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
