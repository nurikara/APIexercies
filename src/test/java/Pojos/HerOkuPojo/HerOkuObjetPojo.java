package Pojos.HerOkuPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HerOkuObjetPojo {

    private HerOkuPojo booking;

    public HerOkuObjetPojo() {
    }

    public HerOkuObjetPojo(HerOkuPojo booking) {
        this.booking = booking;
    }

    public HerOkuPojo getBooking() {
        return booking;
    }

    public void setBooking(HerOkuPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "HerOkuObjetPojo{" +
                "booking=" + booking +
                '}';
    }
}

