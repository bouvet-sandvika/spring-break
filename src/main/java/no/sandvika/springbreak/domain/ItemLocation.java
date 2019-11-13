package no.sandvika.springbreak.domain;

public class ItemLocation {
    private Long id;
    private String locationName;

    public ItemLocation(Long id, String locationName) {
        this.id = id;
        this.locationName = locationName;
    }

    public ItemLocation() {
    }

    public String getLocationName() {
        return locationName;
    }

    public Long getId() {
        return id;
    }
}
