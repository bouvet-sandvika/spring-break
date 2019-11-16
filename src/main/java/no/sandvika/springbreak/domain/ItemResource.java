package no.sandvika.springbreak.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemResource {
    @Id
    @GeneratedValue
    private Long id;

    private String resourceName;
    private Double amount;

    @ManyToOne
    private BookableItem bookableItem;

    public ItemResource(String resourceName, Double amount, BookableItem bookableItem) {
        this.resourceName = resourceName;
        this.amount = amount;
        this.bookableItem = bookableItem;
    }

    public ItemResource() {
    }

    public String getResourceName() {
        return resourceName;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getId() {
        return id;
    }

    public BookableItem getBookableItem() {
        return bookableItem;
    }
}
