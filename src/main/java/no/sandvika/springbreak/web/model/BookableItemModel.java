package no.sandvika.springbreak.web.model;

import no.sandvika.springbreak.web.HalEntityModel;
import org.springframework.hateoas.server.core.Relation;

import static no.sandvika.springbreak.web.Rels.BOOKABLE_ITEMS;

@Relation(collectionRelation = BOOKABLE_ITEMS)
public class BookableItemModel extends HalEntityModel<BookableItemModel> {
    private String name;
    private String location;

    public BookableItemModel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
