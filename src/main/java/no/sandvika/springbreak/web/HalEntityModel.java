package no.sandvika.springbreak.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.EmbeddedWrapper;
import org.springframework.hateoas.server.core.EmbeddedWrappers;

import java.util.ArrayList;
import java.util.List;

public abstract class HalEntityModel<T extends RepresentationModel<? extends T>> extends RepresentationModel<T> {

    public HalEntityModel() {
        wrappers = new ArrayList<>();
    }

    @JsonIgnore
    public List<EmbeddedWrapper> wrappers;

    @JsonUnwrapped
    public CollectionModel<EmbeddedWrapper> getEmbedded() {
        if (wrappers == null) {
            return null;
        }
        return new CollectionModel<>(wrappers);
    }

    public void embed(final LinkRelation rel, final Object source, boolean preferCollections) {
        if (wrappers == null) {
            wrappers = new ArrayList<>();
        }
        wrappers.add(new EmbeddedWrappers(preferCollections).wrap(source, rel));
    }

    public void embed(final LinkRelation rel, final CollectionModel source, boolean preferCollections) {
        embed(rel, source.getContent(), preferCollections);
    }
}
