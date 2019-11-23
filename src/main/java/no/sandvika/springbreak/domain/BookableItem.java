package no.sandvika.springbreak.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BookableItem {
    @Id
    @GeneratedValue
    private Long id;

    private String itemName;

    @OneToOne(cascade = CascadeType.ALL)
    private ItemLocation itemLocation;

    @OneToMany(mappedBy = "bookableItem", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "bookableItem", cascade = CascadeType.ALL)
    private List<ItemResource> resources;

    public BookableItem(String itemName, ItemLocation itemLocation) {
        this.itemName = itemName;
        this.itemLocation = itemLocation;
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
