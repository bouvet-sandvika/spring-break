package no.sandvika.springbreak.web.modelAssembler;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.ItemLocation;
import no.sandvika.springbreak.web.controller.BookableItemController;
import no.sandvika.springbreak.web.controller.BookingController;
import no.sandvika.springbreak.web.model.BookableItemModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static no.sandvika.springbreak.web.Rels.BOOKINGS;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BookableItemModelAssembler extends RepresentationModelAssemblerSupport<BookableItem, BookableItemModel> {

    public BookableItemModelAssembler() {
        super(BookableItem.class, BookableItemModel.class);
    }

    @Override
    public BookableItemModel toModel(BookableItem entity) {
        BookableItemModel bookableItemModel = new BookableItemModel(entity.getItemName(), entity.getItemLocation().getLocationName());
        bookableItemModel.add(linkTo(methodOn(BookableItemController.class).getBookableItem(entity.getId())).withSelfRel());

        return bookableItemModel;
    }

    public BookableItem toEntity(BookableItemModel model) {
        ItemLocation itemLocation = new ItemLocation(model.getLocation());
        return new BookableItem(model.getName(), itemLocation);
    }
}
