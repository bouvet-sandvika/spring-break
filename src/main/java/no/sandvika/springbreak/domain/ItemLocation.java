package no.sandvika.springbreak.domain;

public class ItemLocation {
    private String locationName;

    public ItemLocation(String locationName) {
        this.locationName = locationName;
    }

    public ItemLocation() {
    }

    public String getLocationName() {
        return locationName;
    }
}
