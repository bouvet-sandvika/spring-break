package no.sandvika.springbreak.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemLocation {
    @Id
    @GeneratedValue
    private Long id;

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
