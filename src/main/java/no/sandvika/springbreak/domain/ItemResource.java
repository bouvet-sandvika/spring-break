package no.sandvika.springbreak.domain;

import org.springframework.data.annotation.Id;

public class ItemResource {
    @Id
    private String id;

    private String resourceName;
    private Double amount;

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

    public String getId() {
        return id;
    }
}
