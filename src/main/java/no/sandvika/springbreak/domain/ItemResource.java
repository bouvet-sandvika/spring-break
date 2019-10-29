package no.sandvika.springbreak.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.awt.print.Book;

@Entity
public class ItemResource {
    @Id
    @GeneratedValue
    private Long id;

    private String resourceName;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "resources")
    private BookableItem item;

    public ItemResource(String resourceName, Double amount, BookableItem bookableItem) {
        this.resourceName = resourceName;
        this.amount = amount;
        this.item = bookableItem;
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
}
