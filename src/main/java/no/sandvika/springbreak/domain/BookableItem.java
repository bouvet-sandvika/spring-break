package no.sandvika.springbreak.domain;

import java.util.List;

public class BookableItem {
    private String itemName;
    private ItemLocation itemLocation;
    private List<Booking> bookings;

    public List<Booking> getBookings() {
        return bookings;
    }

    public String getItemName() {
        return itemName;
    }
}
