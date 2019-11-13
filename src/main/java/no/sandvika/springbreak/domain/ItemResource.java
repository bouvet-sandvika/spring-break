package no.sandvika.springbreak.domain;

public class ItemResource {
    private Long id;
    private String resourceName;
    private Double amount;
    private BookableItem item;

    public ItemResource(Long id, String resourceName, Double amount, BookableItem bookableItem) {
        this.id = id;
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
