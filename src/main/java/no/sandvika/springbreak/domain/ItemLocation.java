package no.sandvika.springbreak.domain;

import org.springframework.data.annotation.Id;

public class ItemLocation {
    @Id
    private String id;

    private String locationName;

    public ItemLocation(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    public ItemLocation() {
    }
}
