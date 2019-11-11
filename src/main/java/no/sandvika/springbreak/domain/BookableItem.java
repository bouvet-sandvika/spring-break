package no.sandvika.springbreak.domain;

import java.util.ArrayList;
import java.util.List;

public class BookableItem {
    private String itemName;
    private ItemLocation itemLocation;
    private List<Booking> bookings;
    private List<ItemResource> resources;

    public BookableItem(String itemName) {
        this.itemName = itemName;
        this.itemLocation = null;
        this.bookings = new ArrayList<>();
        this.resources = new ArrayList<>();
    }

    public BookableItem() {
    }

    public String getItemName() {
        return itemName;
    }

    public ItemLocation getItemLocation() {
        return itemLocation;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<ItemResource> getResources() {
        return resources;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public void addResource(ItemResource itemResource) {
        this.resources.add(itemResource);
    }

    public void setItemLocation(ItemLocation itemLocation) {
        this.itemLocation = itemLocation;
    }
}
