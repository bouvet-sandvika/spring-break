package no.sandvika.springbreak.domain;

import java.util.List;

public class BookableItem implements Bookable {
    private List<Booking> bookings;
    public List<Booking> getBookings() {
        return bookings;
    }
}
