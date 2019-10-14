package no.sandvika.springbreak.domain;

public class ItemResource {
    private String resourceName;
    private Double amount;

    public ItemResource(String resourceName, Double amount) {
        this.resourceName = resourceName;
        this.amount = amount;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Double getAmount() {
        return amount;
    }
}
