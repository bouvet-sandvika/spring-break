package no.sandvika.springbreak.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BookableItem {
    @Id
    @GeneratedValue
    private Long id;

    private String itemName;

    @OneToOne(targetEntity = ItemLocation.class, cascade = CascadeType.ALL)
    private ItemLocation itemLocation;

    @OneToMany(targetEntity = Booking.class, mappedBy = "bookableItem")
    private List<Booking> bookings;

    @OneToMany(targetEntity = ItemResource.class, mappedBy = "bookableItem", cascade = CascadeType.ALL)
    private List<ItemResource> resources;

    public BookableItem(String itemName, ItemLocation itemLocation) {
        this.itemName = itemName;
        this.itemLocation = itemLocation;
        this.bookings = new ArrayList<>();
        this.resources = new ArrayList<>();
    }

    public BookableItem(String itemName) {
        this(itemName, null);
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

    public Long getId() {
        return id;
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
